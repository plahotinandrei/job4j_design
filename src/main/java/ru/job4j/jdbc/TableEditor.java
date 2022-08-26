package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    final private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName(properties.getProperty("connection.driver_class"));
            String url = properties.getProperty("connection.url");
            String login = properties.getProperty("connection.username");
            String password = properties.getProperty("connection.password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void query(String sql)  {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        query(String.format(
                "create table if not exists %s();",
                tableName
        ));
    }

    public void dropTable(String tableName) {
        query(String.format(
                "drop table if exists %s;",
                tableName
        ));
    }

    public void addColumn(String tableName, String columnName, String type) {
        query(String.format(
                "alter table %s add column if not exists %s %s;",
                tableName,
                columnName,
                type
        ));
    }

    public void dropColumn(String tableName, String columnName) {
        query(String.format(
                "alter table %s drop column if exists %s;",
                tableName,
                columnName
        ));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        query(String.format(
                "alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        ));
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("statement.properties")) {
            config.load(in);
            try (TableEditor te = new TableEditor(config)) {
                Connection c = te.getConnection();
                te.createTable("new_table");
                System.out.println(getTableScheme(c, "new_table"));
                te.addColumn("new_table", "count", "serial primary key");
                System.out.println(getTableScheme(c, "new_table"));
                te.renameColumn("new_table", "count", "id");
                System.out.println(getTableScheme(c, "new_table"));
                te.dropColumn("new_table", "id");
                System.out.println(getTableScheme(c, "new_table"));
                te.dropTable("new_table");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

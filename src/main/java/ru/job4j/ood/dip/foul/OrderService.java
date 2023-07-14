package ru.job4j.ood.dip.foul;

/* Нарушает принцип DIP, так как класс зависит от конкретной реализации SqlDatabaseConnection
для взаимодействия с базой данных, вместо зависимости от абстракции базы данных. */
public class OrderService {

    private final SqlDatabaseConnection databaseConnection;

    public OrderService() {
        this.databaseConnection = new SqlDatabaseConnection();
    }

    public void saveOrder(Order order) {
        databaseConnection.connect();
        databaseConnection.save(order);
        databaseConnection.disconnect();
    }
}

package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws IOException {
        paramsValid(argsName);
        String path = argsName.get("path");
        String out = argsName.get("out");
        List<String> filter = Arrays.asList(argsName.get("filter").split(","));
        String delimiter = argsName.get("delimiter");
        List<String> stringsOut = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        Scanner scanner = new Scanner(new FileInputStream(path));
        if (scanner.hasNextLine()) {
            String[] head = scanner.nextLine().split(delimiter);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < head.length; i++) {
                if (filter.contains(head[i])) {
                    columns.add(i);
                    str.append(head[i]).append(";");
                }
            }
            stringsOut.add(str.substring(0, str.length() - 1));
        }
        while (scanner.hasNextLine()) {
            String[] row = scanner.nextLine().split(delimiter);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                if (columns.contains(i)) {
                    str.append(row[i]).append(";");
                }
            }
            stringsOut.add(str.substring(0, str.length() - 1));
        }
        writeString(String.join(System.lineSeparator(), stringsOut), out);
        scanner.close();
    }

    private static void writeString(String str, String out) {
        try (PrintStream ps = new PrintStream("stdout".equals(out) ? System.out : new FileOutputStream(out))) {
            ps.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void paramsValid(ArgsName argsName) {
        if (argsName.size() < 4) {
            throw new IllegalArgumentException("Not all arguments entered");
        }
        if (!Files.isReadable(Paths.get(argsName.get("path")))) {
            throw new IllegalArgumentException(
                    String.format("File %s does not exist or is not readable", argsName.get("path"))
            );
        }
        if (!"stdout".equals(argsName.get("out")) && !Files.isWritable(Paths.get(argsName.get("out")))) {
            throw new IllegalArgumentException("Incorrect output");
        }
    }

    public static void main(String[] args) throws IOException {
        handle(ArgsName.of(args));
    }
}


package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public int size() {
        return values.entrySet().size();
    }

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("Key %s not found", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg:args) {
            strValid(arg);
            String[] kv = arg.split("=", 2);
            values.put(kv[0].substring(1), kv[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not found");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private void strValid(String str) {
        String[] kv = str.split("=", 2);
        if (kv.length < 2 || !kv[0].startsWith("-") || kv[0].length() < 2 || kv[1].length() == 0) {
            throw new IllegalArgumentException("One of the arguments does not match the pattern -key=value");
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}

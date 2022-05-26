package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter((el) -> !el.matches("^\\s*#.*"))
                    .filter((el) -> !el.matches("^\\s*$"))
                    .forEach((el) -> {
                        String[] keys = el.split("=", 2);
                        if (keys.length < 2 || keys[0].matches("^\\s*$") || keys[1].matches("^\\s*$")) {
                            throw new IllegalArgumentException(
                                    "File " + this.path + " does not match pattern key=value"
                            );
                        }
                        values.put(keys[0], keys[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}
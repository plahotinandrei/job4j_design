package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        find(Path.of(".")).forEach(System.out::println);
    }

    public static List<Path> find(Path root) throws IOException {
        DuplicatesVisitor finder = new DuplicatesVisitor();
        Files.walkFileTree(root, finder);
        return finder.getDuplicates();
    }
}
package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty property = new FileProperty(file.toFile().length(), file.getFileName().toString());
        duplicates.computeIfPresent(property, (k, v)  -> {
            v.add(file);
            return v;
        });
        duplicates.putIfAbsent(property, new ArrayList<>(List.of(file)));
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        return duplicates.entrySet().stream()
                .filter((entry) -> entry.getValue().size() > 1)
                .flatMap((entry) -> entry.getValue().stream())
                .collect(Collectors.toList());
    }
}

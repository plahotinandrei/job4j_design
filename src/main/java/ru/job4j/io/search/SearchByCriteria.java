package ru.job4j.io.search;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchByCriteria {
    private static final Logger LOG = LoggerFactory.getLogger(SearchByCriteria.class.getName());

    public static void main(String[] args) {
        try {
            ArgsName names = ArgsName.of(args);
            handle(names);
        } catch (IOException e) {
            LOG.error("IOException in SearchByCriteria", e);
        }
    }

    public static void handle(ArgsName argsName) throws IOException {
        paramsValid(argsName);
        String directory = argsName.get("d");
        String fileName = argsName.get("n");
        String searchType = argsName.get("t");
        String output = argsName.get("o");
        Predicate<Path> condition;
        if ("mask".equals(searchType)) {
            condition = (path) -> FileSystems.getDefault().getPathMatcher(String.format("glob:%s", fileName))
                    .matches(path.getFileName());
        } else if ("regex".equals(searchType)) {
            condition = (path) -> path.toFile().getName().matches(fileName);
        } else {
            condition = (path) -> path.toFile().getName().equals(fileName);
        }
        List<Path> rsl = search(Paths.get(directory), condition);
        save(rsl, output);
    }

    private static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void save(List<Path> rsl, String output) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(output))) {
            rsl.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void paramsValid(ArgsName argsName) {
        if (argsName.size() < 4) {
            throw new IllegalArgumentException("Not all arguments entered");
        }
        if (!Files.isDirectory(Paths.get(argsName.get("d")))) {
            throw new IllegalArgumentException(String.format("%s is not a directory", argsName.get("d")));
        }
        if (!Files.isWritable(Paths.get(argsName.get("o")))) {
            throw new IllegalArgumentException("Incorrect output");
        }
        if (!List.of("mask", "name", "regex").contains(argsName.get("t"))) {
            throw new IllegalArgumentException("Incorrect search type");
        }
    }
}

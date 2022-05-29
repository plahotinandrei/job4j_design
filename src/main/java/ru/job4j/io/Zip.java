package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source:sources) {
                packFileToZip(zip, source);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            packFileToZip(zip, source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void packFileToZip(ZipOutputStream zip, File source) throws IOException {
        zip.putNextEntry(new ZipEntry(source.getPath()));
        try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
            zip.write(out.readAllBytes());
        }
    }

    private static void paramsValid(String[] params) {
        if (params.length < 3) {
            throw new IllegalArgumentException("Not all arguments entered");
        }
        ArgsName jvm = ArgsName.of(params);
        if (!Files.isDirectory(Paths.get(jvm.get("d")))) {
            throw new IllegalArgumentException(String.format("%s is not a directory", jvm.get("d")));
        }
        if (!jvm.get("e").startsWith(".")) {
            throw new IllegalArgumentException("The file extension must start with .");
        }
    }

    public static void main(String[] args) throws IOException {
        paramsValid(args);
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        ArgsName jvm = ArgsName.of(args);
        String directory = jvm.get("d");
        String exclude = jvm.get("e");
        String output = jvm.get("o");
        List<File> files = Search
                .search(Paths.get(directory), (p) -> !p.toFile().getName().endsWith(exclude)).stream()
                .map(Path::toFile)
                .collect(Collectors.toList());
        zip.packFiles(files, new File(output));
    }
}

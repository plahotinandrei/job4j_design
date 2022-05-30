package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CSVReaderTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void whenFilterTwoColumns() throws IOException {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        File target = temporaryFolder.newFile("target.csv");
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=name,age"
        });
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "name;age",
                "Tom;20",
                "Jack;25",
                "William;30"
        ).concat(System.lineSeparator());
        CSVReader.handle(argsName);
        Assert.assertEquals(expected, Files.readString(target.toPath()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotArgument() throws IOException {
        ArgsName argsName = ArgsName.of(new String[]{"-delimiter=;", "-filter=name,age"});
        CSVReader.handle(argsName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectSource() throws IOException {
        File target = temporaryFolder.newFile("target.csv");
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=source", "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=name,age"
        });
        CSVReader.handle(argsName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectTarget() throws IOException {
        File file = temporaryFolder.newFile("source.csv");
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=directory", "-filter=name,age"
        });
        CSVReader.handle(argsName);
    }
}
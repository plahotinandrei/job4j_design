package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            int size = 9;
            for (int row = 0; row < size; row++) {
                for (int cell = 0; cell < size; cell++) {
                    out.write(Integer.valueOf(cell + 1).toString().getBytes());
                    out.write(" * ".getBytes());
                    out.write(Integer.valueOf(row + 1).toString().getBytes());
                    out.write(" = ".getBytes());
                    out.write(Integer.valueOf((cell + 1) * (row + 1)).toString().getBytes());
                    out.write("; ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

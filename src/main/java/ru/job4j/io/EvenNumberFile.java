package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] numbers = text.toString().split(System.lineSeparator());
            for (String number : numbers) {
                try {
                    if (Integer.parseInt(number) % 2 == 0) {
                        System.out.println(number + " - четное");
                    } else {
                        System.out.println(number + " - не четное");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(number + " - не число");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

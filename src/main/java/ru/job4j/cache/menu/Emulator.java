package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;
import java.util.Scanner;

public class Emulator {
    public static final int SET_DIRECTORY = 1;
    public static final int ADD_TO_CACHE = 2;
    public static final int EXTRACT_FROM_CACHE = 3;

    public static final String WHICH_DIR = "Укажите кэшируемую директорию";
    public static final String DIR_NAME = "Кэшируемая директория ";
    public static final String INCORRECT_DIR_OR_FILE = "Укажите корректную директорию и файл";
    public static final String WHICH_FILE = "Укажите имя файла";
    public static final String FILE_NAME = " добавлен в кэш";
    public static final String EXIT = "Конец работы";

    public static final String MENU = "Введите 1 чтобы указать кэшируемую директорию." + System.lineSeparator()
            + "Введите 2, чтобы загрузить содержимое файла в кэш." + System.lineSeparator()
            + "Введите 3, чтобы получить содержимое файла из кэша." + System.lineSeparator()
            + "Введите любое другое число для выхода.";

    public static void main(String[] args) {
        AbstractCache<String, String> cache = null;
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (SET_DIRECTORY == userChoice) {
                System.out.println(WHICH_DIR);
                String dir = scanner.nextLine();
                cache = new DirFileCache(dir);
                System.out.println(DIR_NAME + dir);
            } else if (ADD_TO_CACHE == userChoice) {
                System.out.println(WHICH_FILE);
                String file = scanner.nextLine();
                if (cache != null && cache.get(file) != null) {
                    System.out.println(file + FILE_NAME);
                } else {
                    System.out.println(INCORRECT_DIR_OR_FILE);
                }
            } else if (EXTRACT_FROM_CACHE == userChoice) {
                System.out.println(WHICH_FILE);
                String file = scanner.nextLine();
                if (cache != null) {
                    System.out.println(cache.get(file));
                }
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}

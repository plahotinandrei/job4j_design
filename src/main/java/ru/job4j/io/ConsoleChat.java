package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        System.out.print("Введите сообщение: ");
        Scanner scanner = new Scanner(System.in);
        List<String> answers = readPhrases();
        List<String> log = new ArrayList<>();
        Random rand = new Random();
        boolean run = true;
        boolean hush = false;
        while (run) {
            String msg = scanner.nextLine();
            log.add(String.format("Пользователь: %s", msg));
            if (OUT.equals(msg)) {
                run = false;
                saveLog(log);
                continue;
            }
            if (STOP.equals(msg)) {
                hush = true;
            }
            if (CONTINUE.equals(msg)) {
                hush = false;
            }
            if (!hush) {
                int i = rand.nextInt(answers.size() - 1);
                String answer = answers.get(i);
                log.add(String.format("Бот: %s", answer));
                System.out.println(answer);
            }
        }
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            br.lines().forEach(rsl::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/console_chat.log", "./data/bot_answers.txt");
        cc.run();
    }
}

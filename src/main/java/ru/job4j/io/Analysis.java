package ru.job4j.io;

import java.io.*;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (
            BufferedReader read = new BufferedReader(new FileReader(source));
            PrintWriter out = new PrintWriter(new FileOutputStream(target))
        ) {
            String start = null;
            boolean isWorked;
            while (read.ready()) {
                String[] sd = read.readLine().split(" ", 2);
                isWorked = "200".equals(sd[0]) || "300".equals(sd[0]);
                if (!isWorked && start == null) {
                    start = sd[1];
                } else if (isWorked && start != null) {
                    out.println(start + ";" + sd[1] + ";");
                    start = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unavailable("server.log", "target.csv");
    }
}

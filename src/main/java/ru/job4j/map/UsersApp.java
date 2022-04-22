package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UsersApp {
    public static void main(String[] args) {
        User u1 = new User("Andrey", 0, new GregorianCalendar(1994, Calendar.JUNE, 7));
        User u2 = new User("Andrey", 0, new GregorianCalendar(1994, Calendar.JUNE, 7));
        Map<User, Object> users = new HashMap<>();
        users.put(u1, new Object());
        users.put(u2, new Object());
        for (Map.Entry<User, Object> entry : users.entrySet()) {
            System.out.println(entry);
        }
    }
}

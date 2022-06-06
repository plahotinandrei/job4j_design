package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[] {"Worker", "Married"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson1 = new GsonBuilder().create();
        System.out.println(gson1.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Person personMod = gson1.fromJson(personJson, Person.class);
        System.out.println(personMod);

        final Account account = new Account("user12", person, 234, false, new Person[0]);

        /* Преобразуем объект person в json-строку. */
        final Gson gson2 = new GsonBuilder().create();
        System.out.println(gson2.toJson(account));

        /* Модифицируем json-строку */
        final String accountJson =
                "{"
                    + "\"login\":\"user12\","
                    + "\"user\":"
                    + "{"
                    + "\"sex\":false,"
                    + "\"age\":35,"
                    + "\"contact\":"
                    + "{"
                    + "\"phone\":\"+7(924)111-111-11-11\""
                    + "},"
                    + "\"statuses\":"
                    + "[\"Student\",\"Free\"]"
                    + "},"
                    + "\"id\":234,"
                    + "\"subscription\":false,"
                    + "\"friends\":"
                    + "[]"
                    + "}";
        final Account accountMod = gson2.fromJson(accountJson, Account.class);
        System.out.println(accountMod);
    }
}

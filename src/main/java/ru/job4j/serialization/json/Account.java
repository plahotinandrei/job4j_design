package ru.job4j.serialization.json;

import java.util.Arrays;

public class Account {
    String login;
    Person user;
    int id;
    boolean subscription;
    Person[] friends;

    public Account(String login, Person user, int id, boolean subscription, Person[] friends) {
        this.login = login;
        this.user = user;
        this.id = id;
        this.subscription = subscription;
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Account{"
                + "login='" + login + '\''
                + ", user=" + user
                + ", id=" + id
                + ", subscription=" + subscription
                + ", friends=" + Arrays.toString(friends)
                + '}';
    }
}

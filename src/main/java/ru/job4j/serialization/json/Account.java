package ru.job4j.serialization.json;

import java.util.Arrays;

public class Account {
    private final String login;
    private final Person user;
    private final int id;
    private final boolean subscription;
    private final Person[] friends;

    public Account(String login, Person user, int id, boolean subscription, Person[] friends) {
        this.login = login;
        this.user = user;
        this.id = id;
        this.subscription = subscription;
        this.friends = friends;
    }

    public String getLogin() {
        return login;
    }

    public Person getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public Person[] getFriends() {
        return friends;
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

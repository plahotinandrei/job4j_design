package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

    @XmlAttribute
    private String login;

    private Person user;

    @XmlAttribute
    private int id;

    @XmlAttribute
    private boolean subscription;

    @XmlElementWrapper
    @XmlElement(name = "friend")
    private Person[] friends;

    public Account() {

    }

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


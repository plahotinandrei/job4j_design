package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Andrey Plakhotin";
        int age = 27;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte n1 = 10;
        short n2 = 20;
        int n3 = 30;
        long n4 = 40;
        float n5 = 50.1F;
        double n6 = 60.2D;
        LOG.debug("numbers - byte: {}, short: {}, int: {}, long: {}, float: {}, double: {}", n1, n2, n3, n4, n5, n6);
        boolean t = true;
        boolean f = false;
        LOG.debug("boolean: {} and {}", t, f);
        char c = 'A';
        LOG.debug("char: {}", c);
    }
}

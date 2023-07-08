package ru.job4j.ood.srp.foul;

/* Нарушает принцип SRP, так как синглтон имеет две обязанности:
управлять созданием экземпляра класса и бизнес-логику */
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        /* Бизнес-логика */
    }

}

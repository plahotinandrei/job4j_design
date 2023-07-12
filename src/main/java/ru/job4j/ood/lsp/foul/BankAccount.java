package ru.job4j.ood.lsp.foul;

public class BankAccount {
    private double balance;

    public double withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
        return balance;
    }
}

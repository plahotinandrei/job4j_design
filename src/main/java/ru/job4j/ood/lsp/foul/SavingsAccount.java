package ru.job4j.ood.lsp.foul;

public class SavingsAccount extends BankAccount {
    private double balance;

    @Override
    public double withdraw(double amount) {
        /* Ослабление постусловия - сберегательный счет позволяет снять большую сумму, чем есть на балансе */
        balance -= amount;
        return balance;
    }
}

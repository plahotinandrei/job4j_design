package ru.job4j.ood.lsp.foul;

/* Нарушает принцип LSP, так как код, который вызывает метод healing(),
должен обрабатывать исключение UnsupportedOperationException, что усложняет код
и создает неясность в поведении системы. */
public class Warrior extends Character {
    @Override
    public void attack() {
        System.out.println("Warrior attacks with a sword.");
    }

    @Override
    public void healing() {
        throw new UnsupportedOperationException("Warrior cannot heal other characters.");
    }
}

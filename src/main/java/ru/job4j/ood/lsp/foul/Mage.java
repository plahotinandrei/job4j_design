package ru.job4j.ood.lsp.foul;

public class Mage extends Character {

    @Override
    public void attack() {
        System.out.println("Mage casts a fireball spell.");
    }

    @Override
    public void healing() {
        System.out.println("healing");
    }
}

package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {

    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (!isExpired(0, 100, food)) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> findAll() {
        return foods;
    }

    @Override
    public List<Food> clear() {
        List<Food> rsl = foods.stream()
                .filter((food) -> isExpired(0, 100, food))
                .toList();
        foods.removeAll(rsl);
        return rsl;
    }
}

package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {

    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (isExpired(75, 100, food)) {
            food.setPrice(getDiscountPrice(food));
        }
        if (isExpired(25, 100, food)) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> findAll() {
        return foods;
    }

    @Override
    public List<Food> clear() {
        foods.stream()
                .filter((food) -> isExpired(75, 100, food))
                .forEach((food -> food.setPrice(getDiscountPrice(food))));
        List<Food> rsl = foods.stream()
                .filter((food) -> !isExpired(25, 100, food))
                .toList();
        foods.removeAll(rsl);
        return rsl;
    }

    private double getDiscountPrice(Food food) {
        return food.getPrice() - food.getPrice() * food.getDiscount() / 100;
    }
}

package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractStore implements Store<Food> {

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return findAll().stream().filter(filter).collect(Collectors.toList());
    }

    protected boolean isExpired(int from, int to, Food food) {
        long expiration = food.getExpiryDate().getTime().getTime() - food.getCreateDate().getTime().getTime();
        long passed = System.currentTimeMillis() - food.getCreateDate().getTime().getTime();
        long percent = passed * 100 / expiration;
        return from <= percent && percent < to;
    }
}

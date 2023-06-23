package ru.job4j.ood.lsp.foods;

import java.util.List;

public class Warehouse extends AbstractStore {

    @Override
    public void add(Food food) {
        if (isExpired(WAREHOUSE_FROM, SHOP_FROM, food)) {
            findAll().add(food);
        }
    }

    @Override
    public List<Food> clear() {
        List<Food> rsl = findAll().stream()
                .filter((food) -> !isExpired(WAREHOUSE_FROM, SHOP_FROM, food))
                .toList();
        super.removeAll(rsl);
        return rsl;
    }
}

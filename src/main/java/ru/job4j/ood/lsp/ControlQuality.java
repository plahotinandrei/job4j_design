package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControlQuality {
    private final List<Store<Food>> stores = new ArrayList<>();

    public void addStore(Store<Food> store) {
        stores.add(store);
    }

    public void addFoodToStore(Food food) {
        stores.forEach((s) -> s.add(food));
    }

    public void refreshStores() {
        stores.stream()
                .map(Store::clear)
                .flatMap(Collection::stream)
                .forEach(this::addFoodToStore);
    }

    public List<Store<Food>> getStores() {
        return stores;
    }
}

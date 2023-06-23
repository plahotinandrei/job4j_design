package ru.job4j.ood.lsp.foods;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenFoodExpiration24PercentThenWarehouseStoreContainsFood() {
        ControlQuality control = new ControlQuality();
        Store<Food> store = new Warehouse();
        control.addStore(store);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.add(Calendar.DAY_OF_MONTH, 76);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -24);
        Food food = new Food(
                "sugar",
                expiryDate,
                createDate,
                1000,
                30);
        control.addFoodToStore(food);
        List<Food> foods = control.getStores().get(0).findAll();
        assertThat(foods).contains(food);
    }

    @Test
    public void whenRefreshStoresThenFoodRemovedFromWarehouseStore() {
        ControlQuality control = new ControlQuality();
        Store<Food> store = new Warehouse();
        control.addStore(store);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.add(Calendar.DAY_OF_MONTH, 76);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -24);
        Food food = new Food(
                "sugar",
                expiryDate,
                createDate,
                1000,
                30);
        control.addFoodToStore(food);
        expiryDate.add(Calendar.DAY_OF_MONTH, -10);
        control.refreshStores();
        List<Food> foods = control.getStores().get(0).findAll();
        assertThat(foods).isEmpty();
    }

    @Test
    public void whenRefreshStoresThenFoodMovedFromWarehouseToTrashStore() {
        ControlQuality control = new ControlQuality();
        Store<Food> store1 = new Warehouse();
        Store<Food> store2 = new Trash();
        control.addStore(store1);
        control.addStore(store2);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.add(Calendar.DAY_OF_MONTH, 8);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -2);
        Food food = new Food(
                "sugar",
                expiryDate,
                createDate,
                1000,
                30);
        control.addFoodToStore(food);
        List<Food> warehouseFoods = control.getStores().get(0).findAll();
        List<Food> trashFoods = control.getStores().get(1).findAll();
        assertThat(warehouseFoods).contains(food);
        assertThat(trashFoods).isEmpty();
        expiryDate.add(Calendar.DAY_OF_MONTH, -9);
        control.refreshStores();
        assertThat(warehouseFoods).isEmpty();
        assertThat(trashFoods).contains(food);
    }

    @Test
    public void when() {
        ControlQuality control = new ControlQuality();
        Store<Food> store = new Shop();
        control.addStore(store);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.add(Calendar.DAY_OF_MONTH, 70);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -30);
        Food food = new Food(
                "sugar",
                expiryDate,
                createDate,
                1000,
                30);
        control.addFoodToStore(food);
        expiryDate.add(Calendar.DAY_OF_MONTH, -50);
        createDate.add(Calendar.DAY_OF_MONTH, -50);
        control.refreshStores();
        List<Food> foods = control.getStores().get(0).findAll();
        assertThat(foods).contains(food)
                .element(0)
                .matches((e) -> e.getPrice() == 700);
    }
}
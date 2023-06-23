package ru.job4j.ood.lsp.foods;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    public void whenExpiryThenStoreContainsFood() {
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.add(Calendar.DAY_OF_MONTH, -5);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -6);
        Food food = new Food(
                "sugar",
                expiryDate,
                createDate,
                1000,
                30);
        Store<Food> store = new Trash();
        store.add(food);
        assertThat(store.findAll()).contains(food);
    }

    @Test
    public void whenExpiryTodayThenStoreContainsFood() {
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -6);
        Food food = new Food(
                "sugar",
                expiryDate,
                createDate,
                1000,
                30);
        Store<Food> store = new Trash();
        store.add(food);
        assertThat(store.findAll()).contains(food);
    }

    @Test
    public void whenNotExpiryThenStoreIsEmpty() {
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.add(Calendar.DAY_OF_MONTH, 5);
        Calendar createDate = Calendar.getInstance();
        createDate.add(Calendar.DAY_OF_MONTH, -2);
        Food food = new Food(
                "sugar",
                expiryDate,
                createDate,
                1000,
                30);
        Store<Food> store = new Trash();
        store.add(food);
        assertThat(store.findAll()).isEmpty();
    }
}
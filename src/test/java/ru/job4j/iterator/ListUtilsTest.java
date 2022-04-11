package ru.job4j.iterator;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 0, 3);
        assertThat(input, is(Arrays.asList(0, 3, 1, 2)));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(input, is(Arrays.asList(0, 1, 3, 2)));
    }

    @Test
    public void whenRemoveIfEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 3, 1, 5, 6, 8));
        ListUtils.removeIf(input, (n) -> n % 2 == 0);
        assertThat(input, is(Arrays.asList(3, 1, 5)));
    }

    @Test
    public void whenReplaceIfNegativeThenZero() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, -3, -1, 5, -6, 8));
        ListUtils.replaceIf(input, (n) -> n < 0, 0);
        assertThat(input, is(Arrays.asList(2, 0, 0, 5, 0, 8)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 3, 1, 5, 6, 8));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 6, 8));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(3, 1, 5)));
    }
}
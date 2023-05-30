package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class MaxMinTest {
    @Test
    public void whenListOfIntegersNotEmptyThenMaxValue() {
        MaxMin maxMin = new MaxMin();
        List<Integer> nums = List.of(1, 6, 3, 4, 5);
        Integer expected = 6;
        Assert.assertEquals(maxMin.max(nums, Comparator.comparingInt(n -> n)), expected);
    }

    @Test
    public void whenListOfIntegersNotEmptyThenMinValue() {
        MaxMin maxMin = new MaxMin();
        List<Integer> nums = List.of(1, 6, 3, 4, 5);
        Integer expected = 1;
        Assert.assertEquals(maxMin.min(nums, Comparator.comparingInt(n -> n)), expected);
    }

    @Test
    public void whenListIsEmptyThenMaxValueIsNull() {
        MaxMin maxMin = new MaxMin();
        List<Integer> nums = List.of();
        Assert.assertNull(maxMin.max(nums, Comparator.comparingInt(n -> n)));
    }

    @Test
    public void whenListIsEmptyThenMinValueIsNull() {
        MaxMin maxMin = new MaxMin();
        List<Integer> nums = List.of();
        Assert.assertNull(maxMin.min(nums, Comparator.comparingInt(n -> n)));
    }

    @Test
    public void whenListOfStringsNotEmptyThenMaxValue() {
        MaxMin maxMin = new MaxMin();
        List<String> strings = List.of("a", "v", "b", "aa");
        String expected = "v";
        Assert.assertEquals(maxMin.max(strings, String::compareTo), expected);
    }

    @Test
    public void whenListOfStringsNotEmptyThenMinValue() {
        MaxMin maxMin = new MaxMin();
        List<String> strings = List.of("a", "v", "b", "aa");
        String expected = "a";
        Assert.assertEquals(maxMin.min(strings, String::compareTo), expected);
    }
}
package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddDuplicate() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(3);
        set.add(null);
        set.add(5);
        assertFalse(set.add(5));
    }

    @Test
    public void whenNonContains() {
        Set<Integer> set = new SimpleSet<>();
        set.add(3);
        assertFalse(set.contains(1));
    }

}
package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class SimpleMapTest {
    @Test
    public void whenPutUniqueKeyThenTrue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("Ivan", 1));
    }

    @Test
    public void whenPutNotUniqueKeyThenFalse() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Ivan", 1);
        assertFalse(map.put("Ivan", 1));
    }

    @Test
    public void whenGetEntryKeyThenValue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Ivan", 1);
        assertThat(map.get("Ivan"), is(1));
    }

    @Test
    public void whenGetNotEntryKeyThenNull() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Ivan", 1);
        assertNull(map.get("Petr"));
    }

    @Test
    public void whenRemoveEntryKeyThenTrue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Ivan", 1);
        assertTrue(map.remove("Ivan"));
    }

    @Test
    public void whenRemoveNotEntryKeyThenFalse() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Ivan", 1);
        assertFalse(map.remove("Petr"));
    }

    @Test
    public void whenExistNextThenKey() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Ivan", 1);
        Iterator<String> it = map.iterator();
        assertThat(it.next(), is("Ivan"));
    }

    @Test
    public void whenMultiCallHasNextThenTrue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Ivan", 1);
        Iterator<String> it = map.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        Iterator<String> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenPutAfterGetIteratorThenMustBeException() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        Iterator<String> it = map.iterator();
        map.put("Ivan", 1);
        it.next();
    }
}
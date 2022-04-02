package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return searchIndex(index) != -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = searchIndex(index);
        return data[index++];
    }

    private int searchIndex(int point) {
        while (point < data.length) {
            if (data[point] % 2 == 0) {
                return point;
            }
            point++;
        }
        return -1;
    }
}


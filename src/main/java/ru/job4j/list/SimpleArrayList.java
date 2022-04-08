package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.Objects;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size == container.length) {
            container = grow();
        }
        container[size++] = value;
    }

    @Override
    public T set(int index, T newValue) {
        modCount++;
        Objects.checkIndex(index, container.length);
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        modCount++;
        Objects.checkIndex(index, container.length);
        T oldValue = container[index];
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(container, index + 1, container, index, newSize - index);
        }
        container[newSize] = null;
        size = newSize;
        return oldValue;
    }

    @Override
    public T get(int index) {
        modCount++;
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point;
            final private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }

        };
    }

    private T[] grow() {
        return Arrays.copyOf(container, container.length * 2);
    }
}


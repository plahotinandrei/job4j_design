package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.lang.UnsupportedOperationException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;

    private int modCount;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index < size / 2) {
            Node<E> n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            modCount++;
            return n.item;
        }
        Node<E> n = last;
        for (int i = size - 1; i > index; i--) {
            n = n.prev;
        }
        modCount++;
        return n.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> point = first;
            final private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = point.item;
                point = point.next;
                return item;
            }
        };
    }

    @Override
    public E set(int index, E newValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

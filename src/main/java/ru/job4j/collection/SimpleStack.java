package ru.job4j.collection;

public class SimpleStack<T> {

    private final ForwardLinked<T> linked = new ForwardLinked<>();
    private int size;

    public int size() {
        return size;
    }

    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    public void push(T value) {
        size++;
        linked.addFirst(value);
    }
}
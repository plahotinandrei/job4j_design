package ru.job4j.ood.lsp;

import java.util.List;
import java.util.function.Predicate;

public interface Store<T> {
    void add(T obj);

    List<T> findAll();

    List<T> findBy(Predicate<T> filter);

    List<T> clear();
}

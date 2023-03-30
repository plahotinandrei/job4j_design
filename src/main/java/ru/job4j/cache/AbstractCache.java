package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public final V get(K key) {
        cache.computeIfPresent(key, (k, v) -> v.get() == null ? new SoftReference<>(load(k)) : v);
        SoftReference<V> ref = cache.getOrDefault(key, cache.put(key, new SoftReference<>(load(key))));
        return ref.get();
    }

    protected abstract V load(K key);
}

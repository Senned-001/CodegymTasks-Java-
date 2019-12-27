package com.codegym.task.task37.task3708.cache;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        // Remove the eldest element whenever the size of the cache exceeds its capacity
        return (size() > this.capacity);
    }

    public LRUCache(int capacity) {
        // Call LinkedHashMap constructor with accessOrder set to true in order to
        // achieve LRU caching behavior
        super(capacity + 1, 1.0f, true);
        this.capacity = capacity;
    }

    public V find(K key) {
        return super.get(key);
    }

    public void set(K key, V value) {
        super.put(key, value);
    }
}

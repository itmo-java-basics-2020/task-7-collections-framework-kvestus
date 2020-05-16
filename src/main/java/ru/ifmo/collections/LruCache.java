package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private LinkedHashMap<K, V> cache;
    private int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            V value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);

            return value;
        }

        return null;
    }

    public void put(K key, V value) {
        if (get(key) == null) {
            if (cache.size() == capacity) {
                var firstKey = cache.entrySet().iterator().next().getKey();
                cache.remove(firstKey);
            }
        }

        cache.put(key, value);
    }

    public int elements() {
        return cache.size();
    }
}
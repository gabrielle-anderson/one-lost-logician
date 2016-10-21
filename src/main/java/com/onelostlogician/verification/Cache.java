package com.onelostlogician.verification;

import java.util.HashMap;

public class Cache<K,V> implements Source<K,V> {
    protected Source<K,V> expensiveSource;
    private HashMap<K,V> localCache;

    public Cache(Source<K, V> expensiveSource) {
        this.expensiveSource = expensiveSource;
        this.localCache = new HashMap<>();
    }

    public V getKey(K key) {
        if (localCache.containsKey(key)) {
            return localCache.get(key);
        }
        else {
            V value = getKeyExpensive(key);
            localCache.put(key, value);
            return value;
        }
    }

    protected V getKeyExpensive(K key) {
        return expensiveSource.getKey(key);
    }
}

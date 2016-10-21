package com.onelostlogician.verification;

import java.util.HashMap;

public class ExpensiveSource<K,V> implements Source<K,V> {
    private HashMap<K,V> map;

    public ExpensiveSource(HashMap<K, V> map) {
        this.map = map;
    }

    public V getKey(Object key) {
        return map.get(key);
    }
}

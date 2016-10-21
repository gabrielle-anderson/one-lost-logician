package com.onelostlogician.verification;

import java.util.HashMap;

public class ExpensiveSourceStub<K,V> implements Source<K,V> {
    private V value;
    private HashMap<K,Integer> calls;

    public ExpensiveSourceStub(V value) {
        this.value = value;
        this.calls = new HashMap<>();
    }

    public V getKey(K key) {
        increment(key);
        return value;
    }

    public Integer getKeyCalls(K key) {
        if (calls.containsKey(key)) {
            return calls.get(key);
        }
        else {
            return 0;
        }
    }

    private void increment(K key) {
        Integer keyCalls = 0;
        if (calls.containsKey(key)) {
            keyCalls = calls.get(key);
        }
        calls.put(key, keyCalls + 1);
    }
}

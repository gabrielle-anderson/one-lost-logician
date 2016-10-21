package com.onelostlogician.verification;

import java.util.HashMap;

public class ModifiedCache<K,V> extends Cache<K,V> implements Source<K,V>  {
    private HashMap<K,Integer> calls;

    public ModifiedCache(Source<K, V> expensiveSource) {
        super(expensiveSource);
        this.calls = new HashMap<>();
    }

    @Override
    protected V getKeyExpensive(K key) {
        increment(key);
        return expensiveSource.getKey(key);
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

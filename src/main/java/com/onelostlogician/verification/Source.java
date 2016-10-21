package com.onelostlogician.verification;

public interface Source<K,V> {
    V getKey(K key);
}

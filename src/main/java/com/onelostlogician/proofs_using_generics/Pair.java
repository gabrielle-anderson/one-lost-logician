package com.onelostlogician.proofs_using_generics;

public final class Pair<S,T> {
    private S x;
    private T y;

    public void setFst(S x) {
        this.x = x;
    }

    public void setSnd(T y) {
        this.y = y;
    }

    public S getFst() {
        return x;
    }

    public T getSnd() {
        return y;
    }
}
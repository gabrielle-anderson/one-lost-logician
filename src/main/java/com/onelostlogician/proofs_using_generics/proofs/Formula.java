package com.onelostlogician.proofs_using_generics.proofs;

public class Formula<T extends Formula<T>> {
        Formula() {}
    public static <T extends Formula<T>> Formula<T> build() {
        return new Formula<T>();
    }
}

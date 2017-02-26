package com.onelostlogician.fluent_specifications.assertions;

public interface NumberAssert<N extends Number, T extends NumberAssert<N, T>> {
    T isZero();

    T isNotZero();

    T isPositive();

    T isNegative();

    T isNotNegative();

    T isNotPositive();

    T mod(N n);
}
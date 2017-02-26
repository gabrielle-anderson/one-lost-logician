package com.onelostlogician.fluent_specifications.assumptions;

public interface NumberAssume<N extends Number, T extends NumberAssume<N, T>> {
    T isZero();

    T isNotZero();

    T isPositive();

    T isNegative();

    T isNotNegative();

    T isNotPositive();

    T mod(N n);
}
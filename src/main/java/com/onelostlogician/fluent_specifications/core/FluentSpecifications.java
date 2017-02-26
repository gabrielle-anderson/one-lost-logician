package com.onelostlogician.fluent_specifications.core;

import com.onelostlogician.fluent_specifications.assertions.AbstractComparableAssert;
import com.onelostlogician.fluent_specifications.assumptions.AbstractComparableAssume;

public class FluentSpecifications {
    public static <T> T forAll(Class<T> clazz) {
        return CoreFluentSpecifications.forall(clazz);
    }

    public static <T> T exists(Class<T> clazz) {
        return CoreFluentSpecifications.exists(clazz);
    }

    public static <T> T existsUnique(Class<T> clazz) {
        return CoreFluentSpecifications.existsUnique(clazz);
    }

    public static <T> T systemUnderTest(Class<T> clazz) {
        return CoreFluentSpecifications.systemUnderTest(clazz);
    }

    public static <T> T result(Class<T> clazz) {
        return null;
    }

    private static <S extends AbstractComparableAssert<S, T>, T extends Comparable<T>> AbstractComparableAssert<S, T> assertThat(T t) {
        return null;
    }

    private static <S extends AbstractComparableAssume<S, T>, T extends Comparable<T>> AbstractComparableAssume<S, T> assumeThat(T t) {
        return null;
    }
}

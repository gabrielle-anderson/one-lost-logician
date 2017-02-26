package com.onelostlogician.fluent_specifications.assertions;

import org.fest.assertions.core.Assert;
import org.fest.assertions.core.ComparableAssert;

public interface AbstractComparableAssert<S extends AbstractComparableAssert<S, A>, A extends Comparable<? super A>> extends Assert<S, A>, ComparableAssert<S, A> {
}

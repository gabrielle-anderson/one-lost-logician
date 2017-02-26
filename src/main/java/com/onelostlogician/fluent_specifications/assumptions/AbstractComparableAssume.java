package com.onelostlogician.fluent_specifications.assumptions;

import org.fest.assertions.core.Assert;
import org.fest.assertions.core.ComparableAssert;

public interface AbstractComparableAssume<S extends AbstractComparableAssume<S, A>, A extends Comparable<? super A>> extends Assert<S, A>, ComparableAssert<S, A> {
}

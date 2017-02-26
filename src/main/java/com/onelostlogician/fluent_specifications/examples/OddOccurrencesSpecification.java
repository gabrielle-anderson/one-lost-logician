package com.onelostlogician.fluent_specifications.examples;

import com.onelostlogician.fluent_specifications.Specification;

import java.util.List;

import static com.onelostlogician.fluent_specifications.assertions.Assertions.assertThat;
import static com.onelostlogician.fluent_specifications.assertions.Collections.frequency;
import static com.onelostlogician.fluent_specifications.assumptions.Assumptions.assumeThat;
import static com.onelostlogician.fluent_specifications.core.FluentSpecifications.forAll;
import static com.onelostlogician.fluent_specifications.core.FluentSpecifications.systemUnderTest;

@SuppressWarnings("ConstantConditions")
public class OddOccurrencesSpecification implements Specification {
    private final List<Integer> A = forAll(List.class);
    private Integer i = forAll(Integer.class);
    private Integer n = forAll(Integer.class);

    private void assumeIsIndexIn(Integer i, List<Integer> l) {
        assumeThat(i).isGreaterThanOrEqualTo(0);
        assumeThat(i).isLessThan(l.size());
    }

    @Override
    public void given() {
        assumeIsIndexIn(i, A);
        assumeThat(A.size()).mod(2).isNotEqualTo(0);
        assumeThat(A.size()).isGreaterThanOrEqualTo(1);
        assumeThat(A.size()).isLessThanOrEqualTo(1_000_000);

        Integer j = forAll(Integer.class);
        assumeIsIndexIn(j, A);
        assertThat(A.get(j)).isGreaterThanOrEqualTo(1);
        assertThat(A.get(j)).isLessThanOrEqualTo(1_000_000);

        Integer k = forAll(Integer.class);
        assumeIsIndexIn(j, A);
        assumeThat(frequency(A, A.get(k))).mod(2).isEqualTo(1);
        assertThat(k).isEqualTo(i);

        assumeThat(frequency(A, A.get(i))).mod(2).isEqualTo(1);
    }

    @Override
    public void when() {
        assumeThat(systemUnderTest(OddOccurrences.class).solution(A)).isEqualTo(n);
    }

    @Override
    public void then() {
        assertThat(n).isEqualTo(A.get(i));
    }
}

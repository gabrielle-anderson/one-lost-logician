package com.onelostlogician.fluent_specifications.core;

import com.onelostlogician.fluent_specifications.Specification;
import com.onelostlogician.fluent_specifications.exceptions.FluentSpecificationException;
import com.onelostlogician.fluent_specifications.variables.Variable;
import com.onelostlogician.fluent_specifications.variables.VariableType;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

import static com.onelostlogician.fluent_specifications.core.FluentSpecifications.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class CoreFluentSpecificationsTest {
    @Test
    public void shouldMapVariables() {
        ValidSpecification validSpecification = new ValidSpecification();
        validSpecification.given();
        validSpecification.when();
        validSpecification.then();
        int noOfVariablesCreated = 4;

        Map<UUID, Variable> variableMap = CoreFluentSpecifications.getVariableMap();
        assertThat(variableMap.keySet().size()).isEqualTo(noOfVariablesCreated);
        assertThat(variableMap.values().stream()
                .filter(v -> v.callSite == CallSite.INIT)
                .allMatch(v -> v.variableType == VariableType.FORALL)
        ).isTrue();
        assertThat(variableMap.values().stream()
                .filter(v -> v.callSite == CallSite.GIVEN)
                .allMatch(v -> v.variableType == VariableType.EXISTS)
        ).isTrue();
        assertThat(variableMap.values().stream()
                .filter(v -> v.callSite == CallSite.WHEN)
                .allMatch(v -> v.variableType == VariableType.EXISTS)
        ).isTrue();
        assertThat(variableMap.values().stream()
                .filter(v -> v.callSite == CallSite.THEN)
                .allMatch(v -> v.variableType == VariableType.EXISTS_UNIQUE)
        ).isTrue();
    }

    @Test(expected = FluentSpecificationException.class)
    public void shouldNotPermitExistsInInit() {
        new InvalidInit();
    }

    @Test(expected = FluentSpecificationException.class)
    public void shouldNotPermitSUTInGiven() {
        new InvalidGiven().given();
    }

    @Test(expected = FluentSpecificationException.class)
    public void shouldNotForAllInWhen() {
        new InvalidWhen().when();
    }

    @Test(expected = FluentSpecificationException.class)
    public void shouldNotSUTInThen() {
        new InvalidThen().then();
    }

    private class InvalidInit implements Specification {
        private EmptyInterface emptyInterface = exists(EmptyInterface.class);

        @Override
        public void given() {}

        @Override
        public void when() {}

        @Override
        public void then() {}
    }

    private class InvalidGiven implements Specification {
        @Override
        public void given() {
            EmptyInterface emptyInterface = systemUnderTest(EmptyInterface.class);
        }

        @Override
        public void when() {}

        @Override
        public void then() {}
    }

    private class InvalidWhen implements Specification {
        @Override
        public void given() {}

        @Override
        public void when() {
            EmptyInterface emptyInterface = forAll(EmptyInterface.class);
        }

        @Override
        public void then() {}
    }

    private class InvalidThen implements Specification {
        @Override
        public void given() {}

        @Override
        public void when() {}

        @Override
        public void then() {
            EmptyInterface emptyInterface = systemUnderTest(EmptyInterface.class);
        }
    }

    public class ValidSpecification implements Specification {
        private EmptyInterface emptyInterface = forAll(EmptyInterface.class);

        @Override
        public void given() {
            exists(EmptyInterface.class);
        }

        @Override
        public void when() {
            systemUnderTest(EmptyInterface.class);
        }

        @Override
        public void then() {
            existsUnique(EmptyInterface.class);
        }
    }
}

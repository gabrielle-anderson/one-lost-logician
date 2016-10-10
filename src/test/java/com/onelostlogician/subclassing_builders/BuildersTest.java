package com.onelostlogician.subclassing_builders;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BuildersTest {
    private static final Integer FIELD1VALUE = 3;
    private static final UUID FIELD2VALUE = UUID.randomUUID();
    private static final String FIELD3VALUE = "hello";
    private static SubSubClass.Builder builder;
    private static final SubSubClass.Builder nullBuilder = SubSubClass.newSubSubClassBuilder();

    @Before
    public void setup() {
        builder = SubSubClass.newSubSubClassBuilder()
                .withField1(FIELD1VALUE)
                .withField2(FIELD2VALUE)
                .withField3(FIELD3VALUE);
    }

    @Test
    public void SubClassBuilderShouldInitialiseFieldsToNull() {
        SubClass subClass = nullBuilder.build();

        assertNull(subClass.getField1());
        assertNull(subClass.getField2());
    }

    @Test
    public void SubSubClassBuilderShouldInitialiseFieldsToNull() {
        SubSubClass subSubClass = nullBuilder.build();

        assertNull(subSubClass.getField1());
        assertNull(subSubClass.getField2());
        assertNull(subSubClass.getField3());
    }

    @Test
    public void ShouldBeAbleToUseSubClassBuilderAsBaseClassBuilder() {
        BaseClass baseClass = builder.build();

        assertEquals(baseClass.getField1(), FIELD1VALUE);
    }

    @Test
    public void ShouldBeAbleToUseSubSubClassBuilderAsSubClassBuilder() {
        SubClass subClass = builder.build();

        assertEquals(subClass.getField1(), FIELD1VALUE);
        assertEquals(subClass.getField2(), FIELD2VALUE);
    }

    @Test
    public void SubSubBuilderShouldBuildCorrectly() {
        SubSubClass subClass = builder.build();

        assertEquals(subClass.getField1(), FIELD1VALUE);
        assertEquals(subClass.getField2(), FIELD2VALUE);
        assertEquals(subClass.getField3(), FIELD3VALUE);
    }

    @Test
    public void WithField1ShouldReturnSubBuilder() {
        assertTrue(builder.withField1(1) instanceof SubSubClass.Builder);
    }

    @Test
    public void WithField2ShouldReturnSubSubBuilder() {
        assertTrue(builder.withField2(FIELD2VALUE) instanceof SubSubClass.Builder);
    }
}

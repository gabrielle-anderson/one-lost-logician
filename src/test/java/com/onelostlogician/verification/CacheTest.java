package com.onelostlogician.verification;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CacheTest {
    private static HashMap<String,Boolean> MAP;
    private static String KEY = "key";
    private static Boolean VALUE = true;

    @Before
    public void initialSetup() {
        MAP = new HashMap<>();
        MAP.put(KEY, VALUE);
    }

    @Test
    public void cacheShouldOnlyCallExpensiveSourceOnceModifying() {
        ExpensiveSource<String, Boolean> expensiveSource = new ExpensiveSource<>(MAP);
        ModifiedCache<String, Boolean> modifiedCache = new ModifiedCache<>(expensiveSource);

        modifiedCache.getKey(KEY);
        modifiedCache.getKey(KEY);

        assertThat(modifiedCache.getKeyCalls(KEY)).isEqualTo(1);
    }

    @Test
    public void cacheShouldOnlyCallExpensiveSourceOnceStubbing() {
        ExpensiveSourceStub<String, Boolean> expensiveSourceStub = new ExpensiveSourceStub<>(VALUE);
        Cache<String, Boolean> cache = new Cache<>(expensiveSourceStub);

        cache.getKey(KEY);
        cache.getKey(KEY);

        assertThat(expensiveSourceStub.getKeyCalls(KEY)).isEqualTo(1);
    }

    @Test
    public void cacheShouldOnlyCallExpensiveSourceOnceMocking() {
        ExpensiveSource<String, Boolean> expensiveSource = mock(ExpensiveSource.class);
        when(expensiveSource.getKey(KEY)).thenReturn(VALUE);
        Cache<String, Boolean> cache = new Cache<>(expensiveSource);

        cache.getKey(KEY);
        cache.getKey(KEY);

        verify(expensiveSource, times(1)).getKey(KEY);
    }
}
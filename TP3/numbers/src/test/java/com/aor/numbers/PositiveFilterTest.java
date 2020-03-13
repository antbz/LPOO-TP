package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositiveFilterTest {
    @Test
    public void positive() {
        PositiveFilter filter = new PositiveFilter();

        assertTrue(filter.accept(2));
        assertTrue(filter.accept(4));
        assertTrue(filter.accept(6));
        assertFalse(filter.accept(-3));
        assertFalse(filter.accept(-9));
        assertFalse(filter.accept(-13));
        assertFalse(filter.accept(0));
    }
}

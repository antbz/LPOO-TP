package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DivisibleByFilterTest {
    @Test
    public void divisible() {
        DivisibleByFilter filter = new DivisibleByFilter(2);

        assertTrue(filter.accept(2));
        assertTrue(filter.accept(4));
        assertTrue(filter.accept(6));
        assertFalse(filter.accept(3));
        assertFalse(filter.accept(9));
        assertFalse(filter.accept(13));
    }
}

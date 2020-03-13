package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListDeduplicatorTest2 {
    List<Integer> list;
    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
    }

    @Test
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        class StubSorter implements IListSorter {
            public List<Integer> sort() {
                List<Integer> sorted = new ArrayList<>();
                sorted.add(1);
                sorted.add(2);
                sorted.add(2);
                sorted.add(4);
                return sorted;
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new StubSorter());

        assertEquals(expected, distinct);
    }
}
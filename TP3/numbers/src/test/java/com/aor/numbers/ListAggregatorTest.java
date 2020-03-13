package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
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
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(9, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(4, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class StubDeduplicator implements IListDeduplicator {
            public List<Integer> deduplicate(IListSorter listSorter) {
                List<Integer> dedups = new ArrayList<>();
                dedups.add(1);
                dedups.add(2);
                dedups.add(4);
                return dedups;
            }
        }
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubDeduplicator(), new ListSorter(list));

        assertEquals(3, distinct);
    }
}
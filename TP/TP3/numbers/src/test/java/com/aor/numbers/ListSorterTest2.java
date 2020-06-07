package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListSorterTest2 {
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
    public void sort() {
        List<Integer> expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(4);


        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();

        assertEquals(expected, sorted);
    }
}
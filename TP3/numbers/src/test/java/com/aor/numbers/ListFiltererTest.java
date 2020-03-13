package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFiltererTest {
    List<Integer> list;
    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(9);
        list.add(13);
        list.add(-11);
        list.add(-2);
        list.add(-5);
        list.add(-12);
        list.add(0);
    }

    @Test
    public void listFilterPositive() {
        PositiveFilter filter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(6);
        expected.add(3);
        expected.add(9);
        expected.add(13);

        assertEquals(expected, filterer.filter(filter));
    }


    @Test
    public void listFilterDivisible() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        ListFilterer filterer = new ListFilterer(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(6);
        expected.add(-2);
        expected.add(-12);
        expected.add(0);

        assertEquals(expected, filterer.filter(filter));
    }

    @Test
    public void listFilterNoDepend() {
        IListFilter filter = Mockito.mock(IListFilter.class);
        ListFilterer filterer = new ListFilterer(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(-2);

        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(true);
        Mockito.when(filter.accept(4)).thenReturn(true);
        Mockito.when(filter.accept(-2)).thenReturn(true);
        Mockito.when(filter.accept(6)).thenReturn(false);
        Mockito.when(filter.accept(3)).thenReturn(false);
        Mockito.when(filter.accept(9)).thenReturn(false);
        Mockito.when(filter.accept(13)).thenReturn(false);
        Mockito.when(filter.accept(-11)).thenReturn(false);
        Mockito.when(filter.accept(-5)).thenReturn(false);
        Mockito.when(filter.accept(-12)).thenReturn(false);
        Mockito.when(filter.accept(0)).thenReturn(false);

        assertEquals(expected, filterer.filter(filter));
    }
}

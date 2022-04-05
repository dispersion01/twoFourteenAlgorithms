package com.any.twofourteenalgorithms.stringList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    StringList stringListTest = new StringListImpl();

    @Test
    public void add(String expect) {
        assertEquals(expect, stringListTest.add(expect));
        assertTrue(stringListTest.contains(expect));
    }

    @Test
    void set() {
        stringListTest.set(1, "three");
        assertTrue(stringListTest.contains("three"));
    }

    @Test
    void indexOf() {
        stringListTest.add("three");
        assertEquals(1, stringListTest.indexOf("three"));
    }
}
package com.luoxiaobatman.assignment.datastructure.list;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO luoxiao test edge cases
 */
public class LinkedListTest {
    private List<Object> animals;

    @BeforeEach
    void setup() {
        animals = new LinkedList<>();
    }

    @Test
    void testAdd() {
        Object monkey = new Object();
        animals.add(monkey);
        assertEquals(animals.size(), 1);
        Object horse = new Object();
        animals.add(horse);
        assertEquals(animals.size(), 2);
        assertSame(animals.get(0), monkey);
        assertSame(animals.get(1), horse);
    }

    @Test
    void testRemove() {
        Object monkey = new Object();
        animals.add(monkey);
        assertEquals(animals.size(), 1);
        Object horse = new Object();
        animals.add(horse);
        assertEquals(animals.size(), 2);

        Object removed = animals.remove(0);
        assertSame(removed, monkey);
        assertEquals(animals.size(), 1);
        assertTrue(animals.remove(horse));
        assertEquals(animals.size(), 0);
    }

    @Test
    void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> animals.get(0));
        Object cow = new Object();
        animals.add(cow);
        assertSame(animals.get(0), cow);
    }

//    @Test
//    void testRemoveEdgeCases() {
//        assertDoesNotThrow(() -> {
//            animals.remove(0);
//            animals.remove(new Object());
//        });
//    }
}

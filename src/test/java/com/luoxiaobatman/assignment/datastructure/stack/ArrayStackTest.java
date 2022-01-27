package com.luoxiaobatman.assignment.datastructure.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    private Stack<Object> animals;

    @BeforeEach
    void setup() {
        animals = new ArrayStack<>();
    }

    @Test
    void testPush() {
        Object monkey = new Object();
        animals.push(monkey);
        assertEquals(animals.size(), 1);
        Object horse = new Object();
        animals.push(horse);
        assertEquals(animals.size(), 2);
    }

    @Test
    void testPop() {
        Object monkey = new Object();
        animals.push(monkey);
        Object horse = new Object();
        animals.push(horse);

        assertSame(animals.pop(), horse);
        assertEquals(animals.size(), 1);
        assertSame(animals.pop(), monkey);
        assertEquals(animals.size(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> animals.pop());
    }

    @Test
    void testPeek() {
        assertThrows(IndexOutOfBoundsException.class, () -> animals.peek());
        Object monkey = new Object();
        animals.push(monkey);
        assertSame(animals.peek(), monkey);
        assertEquals(animals.size(), 1);
    }
}
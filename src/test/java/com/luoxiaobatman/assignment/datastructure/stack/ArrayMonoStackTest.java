package com.luoxiaobatman.assignment.datastructure.stack;

import com.luoxiaobatman.assignment.datastructure.list.LinkedList;
import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.IntsArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMonoStackTest {
    @AllArgsConstructor
    private static class Animal implements Comparable<Animal> {
        final int speed;

        @Override
        public int compareTo(Animal o) {
            return this.speed - o.speed;
        }
    }

    private Stack<Animal> animals;

    @BeforeEach
    void setup() {
        animals = new ArrayMonoStack<>(true, 2);
    }

    @Test
    void testPush() {
        Animal monkey = new Animal(2);
        animals.push(monkey);
        assertEquals(animals.size(), 1);
        Animal horse = new Animal(3);
        animals.push(horse);
        assertEquals(animals.size(), 2);
    }

    @ParameterizedTest
    @SolutionSource(
            value = {
                    "1,2,3,4", "4", "1,2,3,4",
                    "1,2,3,4,5", "4", "2,3,4,5",
                    "1,8,3,4,2", "2", "8,4",
                    "2,2,7,7,5,2,1,8,9,0,8,5", "7", "7,7,8,9,0,8,5"
            },
            argumentsCount = 3, delimiter = ",",
            argumentsParsers = {IntsArgumentsParser.class, IntArgumentsParser.class, IntsArgumentsParser.class}
    )
    void testMono(int[] speeds, int size, int[] expected) {
        animals = new ArrayMonoStack<>(true, size);
        Arrays.stream(speeds).mapToObj(Animal::new).forEach(animal -> {
            animals.push(animal);
        });
        List<Animal> monod = new ArrayList<>();
        try {
            while (true) {
                monod.add(0, animals.pop());
            }
        } catch (IndexOutOfBoundsException ignored) {}
        assertEquals(monod.size(), expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(monod.get(i).speed, expected[i]);
        }
    }

//    @Test
//    void testPop() {
//        Object monkey = new Object();
//        animals.push(monkey);
//        Object horse = new Object();
//        animals.push(horse);
//
//        assertSame(animals.pop(), horse);
//        assertEquals(animals.size(), 1);
//        assertSame(animals.pop(), monkey);
//        assertEquals(animals.size(), 0);
//        assertThrows(IndexOutOfBoundsException.class, () -> animals.pop());
//    }
//
//    @Test
//    void testPeek() {
//        assertThrows(IndexOutOfBoundsException.class, () -> animals.peek());
//        Object monkey = new Object();
//        animals.push(monkey);
//        assertSame(animals.peek(), monkey);
//        assertEquals(animals.size(), 1);
//    }
}
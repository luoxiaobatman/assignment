package com.luoxiaobatman.assignment.datastructure.stack;

import com.luoxiaobatman.assignment.support.SolutionSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonoStackTest {
    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3", "3,2,1",
            "1,2,3,2", "2,2,1",
            "1,2,3,2,1", "1,1"
    })
    void monoInc(int[] ints, int[] expected) {
        MonoStack<Integer> monoStack = new MonoStack<>(true);
        for (int anInt : ints) {
            monoStack.push(anInt);
        }
        try {
            int index = 0;
            for (; ; ) {
                assertEquals(expected[index], monoStack.pop());
                index++;
            }
        } catch (NoSuchElementException | IndexOutOfBoundsException ignored) {
        }
    }

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3", "3",
            "1,2,3,2", "2,3",
            "1,2,3,2,1", "1"
    })
    void monoDec(int[] ints, int[] expected) {
        MonoStack<Integer> monoStack = new MonoStack<>(false);
        for (int anInt : ints) {
            monoStack.push(anInt);
        }
        try {
            int index = 0;
            for (; ; ) {
                assertEquals(expected[index], monoStack.pop());
                index++;
            }
        } catch (NoSuchElementException | IndexOutOfBoundsException ignored) {
        }
    }

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3", "",
            "1,2,3,2", "3",
            "1,2,3,1", "3,2"
    })
    void preOrder(int[] ints, int[] expected) {
        MonoStack<Integer> monoStack = new MonoStack<>(true);
        var ref = new Object() {
            int index = 0;
        };
        for (int anInt : ints) {
            monoStack.push(anInt, consumed -> {
                assertEquals(expected[ref.index], consumed);
                ref.index++;
            }, null);
        }
    }

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3", "",
            "1,2,3,2", "3",
            "1,2,3,1", "2,3"
    })
    void postOrder(int[] ints, int[] expected) {
        MonoStack<Integer> monoStack = new MonoStack<>(true);
        var ref = new Object() {
            int index = 0;
        };
        for (int anInt : ints) {
            monoStack.push(anInt, null, consumed -> {
                assertEquals(expected[ref.index], consumed);
                ref.index++;
            });
        }
    }
}

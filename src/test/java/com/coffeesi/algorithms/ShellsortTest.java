package com.coffeesi.algorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class ShellsortTest {

    @Test
    public void testEmptyArray() {
        int[] actual = {};
        Shellsort.sort(actual, "shell");
        assertArrayEquals(new int[]{}, actual);
        Shellsort.sort(actual, "knuth");
        assertArrayEquals(new int[]{}, actual);
        Shellsort.sort(actual, "sedgewick");
        assertArrayEquals(new int[]{}, actual);
    }

    @Test
    public void testSingleElement() {
        int[] actual = {11};
        Shellsort.sort(actual, "shell");
        assertArrayEquals(new int[]{11}, actual);
        Shellsort.sort(actual, "knuth");
        assertArrayEquals(new int[]{11}, actual);
        Shellsort.sort(actual, "sedgewick");
        assertArrayEquals(new int[]{11}, actual);
    }

    @Test
    public void testSortedArray() {
        int[] actual = {5, 6, 7, 8, 9, 10};
        Shellsort.sort(actual, "shell");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
        Shellsort.sort(actual, "knuth");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
        Shellsort.sort(actual, "sedgewick");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
    }

    @Test
    public void testReversedSortedArray() {
        int[] actual = {10, 9, 8, 7, 6, 5};
        Shellsort.sort(actual, "shell");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
        Shellsort.sort(actual, "knuth");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
        Shellsort.sort(actual, "sedgewick");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
    }

    @Test
    public void testNearlySortedArray() {
        int[] actual = {5, 6, 8, 7, 9, 10};
        Shellsort.sort(actual, "shell");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
        Shellsort.sort(actual, "knuth");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
        Shellsort.sort(actual, "sedgewick");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10}, actual);
    }

    @Test
    public void testRandomArray() {
        Random rand = new Random();
        int[] actual = new int[10000];
        for (int i = 0; i < 10000; i++) {
            actual[i] = rand.nextInt(10000) - 5000;
        }
        int[] sorted = Arrays.copyOf(actual, 10000);
        Arrays.sort(sorted);
        Shellsort.sort(actual, "shell");
        assertArrayEquals(sorted, actual);
        Shellsort.sort(actual, "knuth");
        assertArrayEquals(sorted, actual);
        Shellsort.sort(actual, "sedgewick");
        assertArrayEquals(sorted, actual);
    }
}

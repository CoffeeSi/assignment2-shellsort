package com.coffeesi.benchmark;

import java.util.Random;

import org.openjdk.jmh.annotations.*;

import com.coffeesi.algorithms.Shellsort;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class BenchmarkJMH {
    
    @Param({"100", "1000", "10000"})
    private int size;

    @Param({"shell", "knuth", "sedgewick"})
    private String sequence;

    private int[] array;

    @Setup(Level.Invocation)
    public void setup() {
        Random rand = new Random();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000) - 5000;
        }
    }

    @Benchmark
    public void benchmark() {
        Shellsort.sort(array.clone(), sequence);
    }

}

package com.coffeesi.cli;

import java.util.Random;

import com.coffeesi.algorithms.Shellsort;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        String[] sequences = {"shell", "knuth", "sedgewick"};

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("--help")) {
                System.out.println("Usage: java BenchmarkRunner.java [size]");
                System.out.println("Example: java BenchmarkRunner 500");
                return;
            }
            int size = Integer.parseInt(args[0]);
            sizes = new int[]{size};
        }
        
        for (int n : sizes) {
            for (String seq : sequences) {
                int[] arr = generateRandomArray(n);
                Shellsort.sort(arr, seq);
                System.out.println("Array sorted with " + seq + ", n = " + arr.length);
            }
        }
        System.out.println("Results saved in metrics.csv");
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10000) - 5000;
        }
        return array;
    }
}

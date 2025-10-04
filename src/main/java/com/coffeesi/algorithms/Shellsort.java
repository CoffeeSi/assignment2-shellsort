package com.coffeesi.algorithms;

import com.coffeesi.metrics.PerformanceTracker;
import java.util.ArrayList;

public class Shellsort {
    public static void sort(int[] array, String sequence) {
        PerformanceTracker metrics = new PerformanceTracker("metrics");
        ArrayList<Integer> gaps = computeGaps(sequence, array.length);
        metrics.startTimer();
        sort(array, gaps, metrics);
        metrics.stopTimer();
        metrics.writeToCSV(sequence);
    }

    private static void sort(int[] array, 
                            ArrayList<Integer> gaps, 
                            PerformanceTracker metrics) {
        metrics.setN(array.length);
        for (int gap : gaps) {
            for (int i = gap; i < array.length; i++ ) {
                int temp = array[i];
                metrics.addArrayAccess();
                int j = i;
                while (j >= gap) {
                    metrics.addComparison();
                    int prev = array[j - gap];
                    metrics.addArrayAccess();
                    if (array[j - gap] > temp) {
                        array[j] = prev;
                        metrics.addArrayAccess();
                        metrics.addSwap();
                        j -= gap;
                    } else { break; }
                }
                array[j] = temp;
                metrics.addArrayAccess();
            }
        }
    }

    private static ArrayList<Integer> computeGaps(String sequence, int n) {
        ArrayList<Integer> gaps = new ArrayList<>();
        if (sequence.equals("shell")) {
            for (int i = n/2; i > 0; i /= 2) {
                gaps.add(i);
            }
        }
        else if (sequence.equals("knuth")) {
            int gap = 1;
            while (gap < n) {
                gaps.add(0, gap);
                gap = 3*gap + 1;
            }
        }
        else if (sequence.equals("sedgewick")) {
            int k = 1;
            while (true) {
                int gap = (int) (Math.pow(4, k) + 3 * Math.pow(2, k - 1) + 1);
                if (gap >= n) break;
                gaps.add(0, gap);
                k++;
            }
            gaps.add(1);
        }
        else {
            throw new RuntimeException("Unknown sequence");
        }
        return gaps;
    }
}

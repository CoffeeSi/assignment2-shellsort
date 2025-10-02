package com.coffeesi.metrics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private String filename;
    private long n;
    private long comparisons;
    private long swaps;
    private long arrayAccesses;
    private long allocations;
    private double startTime;
    private double endTime;

    public PerformanceTracker(String filename) {
        this.filename = filename + ".csv";

        File file = new File(this.filename);
        boolean writeHeader = (!file.exists() || file.length() == 0);

        try (FileWriter writer = new FileWriter(this.filename, true)) {
            if (writeHeader)
                writer.write("algorithm,n,comparisons,swaps,arrayAccesses,allocations,timeMs\n");
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize CSV file", e);
        }
    }

    public void setN(long n) { this.n = n; }
    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addArrayAccess() { arrayAccesses ++; }
    public void addArrayAccess(int count) { arrayAccesses += count; }
    public void addAllocation() { allocations++; }
    public void startTimer() { startTime = System.nanoTime(); }
    public void stopTimer() { endTime = System.nanoTime(); }

    public long getN() { return n; }
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccess() { return arrayAccesses; }
    public long getAllocations() { return allocations; }
    public double getDurationMs() { return (endTime - startTime) / 1000000; }

    public void reset() {
        comparisons = swaps = arrayAccesses = allocations = 0;
        startTime = endTime = 0;
    }

    public void writeToCSV(String algorithm) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(String.format("%s,%d,%d,%d,%d,%d,%.4f%n", 
                algorithm, getN(), getComparisons(), getSwaps(), getArrayAccess(), getAllocations(), getDurationMs()));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

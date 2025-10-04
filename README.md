# Assignment 2 - Shellsort

## Usage
### 1. Build the project

`` mvn clean package ``

### 2. Run CLI

`` java -jar target/assignment2-1.0.jar ``

`` java -jar target/assignment2-1.0.jar [size] ``

Example:

`` java -jar target/assignment2-1.0.jar 10000 ``

### 3. Results

Performance metrics are saved in ``metrics.csv`` file.

## Complexity Analysis

### Worst-case:

- With Shell’s original sequence (n/2, n/4, …, 1) → O(n²)

- With Knuth’s sequence (1, 4, 13, …) → O(n^(3/2))

- With Sedgewick’s sequence → O(n^(4/3))

### Average-case: 

- O(n log² n) - O(n^(4/3))

### Best-case

- Already sorted → O(n log n).

![Chart 1](/docs/performance-plots/chart1.png)

## Conclusion

Shell Sort was implemented with multiple gap sequences and validated through theory and benchmarks.

- Sedgewick’s sequence showed the best performance in practice.

- Edge cases were handled correctly, ensuring robust behavior.

- Metrics and JMH benchmarks confirmed theoretical complexity with real data.

This work shows how combining analysis and measurement represents algorithm efficiency.

## Author

Yevgeniy Averyanov SE-2436
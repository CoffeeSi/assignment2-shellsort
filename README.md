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

## Author

Yevgeniy Averyanov SE-2436
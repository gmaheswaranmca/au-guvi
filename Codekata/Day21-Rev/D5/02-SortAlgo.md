# Sorting Algorithms - Notes

## Overview
Sorting is the process of arranging elements in a particular order (ascending or descending). Here are the main sorting algorithms covered in Day 5 of the curriculum.

---

## 1. Selection Sort

### What is Selection Sort?
Selection Sort repeatedly finds the minimum element from the unsorted portion and places it at the beginning.

### Algorithm:
1. Find the minimum element in the unsorted array
2. Swap it with the first element
3. Move the boundary of unsorted array by one position
4. Repeat until the entire array is sorted

### Implementation:
```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Find minimum element in remaining unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
```

### Time Complexity:
- **Best Case**: O(n²) - Even if array is sorted
- **Average Case**: O(n²)
- **Worst Case**: O(n²)

### Space Complexity: O(1) - In-place sorting

### Characteristics:
- **Stable**: No (relative order of equal elements may change)
- **In-place**: Yes
- **Adaptive**: No (performance doesn't improve for partially sorted arrays)

### Advantages:
- Simple implementation
- Performs well on small datasets
- In-place sorting (constant space)
- Makes minimum number of swaps

### Disadvantages:
- Inefficient for large datasets
- Always O(n²) time complexity

---

## 2. Bubble Sort

### What is Bubble Sort?
Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they're in the wrong order.

### Algorithm:
1. Compare adjacent elements
2. If they're in wrong order, swap them
3. Continue until no swaps are needed
4. After each pass, largest element "bubbles" to the end

### Implementation:
```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
```

### Time Complexity:
- **Best Case**: O(n) - Already sorted array with optimization
- **Average Case**: O(n²)
- **Worst Case**: O(n²) - Reverse sorted array

### Space Complexity: O(1) - In-place sorting

### Characteristics:
- **Stable**: Yes
- **In-place**: Yes
- **Adaptive**: Yes (with optimization)

### Advantages:
- Simple implementation
- Stable sorting algorithm
- Can detect if array is already sorted
- In-place sorting

### Disadvantages:
- Inefficient for large datasets
- Many unnecessary comparisons
- O(n²) average time complexity

---

## 3. Insertion Sort

### What is Insertion Sort?
Insertion Sort builds the sorted array one element at a time by inserting each element into its correct position.

### Algorithm:
1. Start with second element (assume first is sorted)
2. Compare with elements in sorted portion
3. Insert current element at correct position
4. Repeat for all elements

### Implementation:
```java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
```

### Time Complexity:
- **Best Case**: O(n) - Already sorted array
- **Average Case**: O(n²)
- **Worst Case**: O(n²) - Reverse sorted array

### Space Complexity: O(1) - In-place sorting

### Characteristics:
- **Stable**: Yes
- **In-place**: Yes
- **Adaptive**: Yes (efficient for small/nearly sorted arrays)

### Advantages:
- Simple implementation
- Efficient for small datasets
- Adaptive (performs well on nearly sorted arrays)
- Stable and in-place
- Online algorithm (can sort as it receives data)

### Disadvantages:
- Inefficient for large datasets
- O(n²) average time complexity

---

## 4. Quick Sort

### What is Quick Sort?
Quick Sort is a divide-and-conquer algorithm that picks a pivot element and partitions the array around it.

### Algorithm:
1. Choose a pivot element
2. Partition array so elements < pivot are on left, > pivot on right
3. Recursively apply quicksort to left and right subarrays
4. Combine results

### Implementation:
```java
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find partition index
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element (upper bound)
        
        for (int j = low; j < high; j++) {//traversal in greater elements
            if (arr[j] <= pivot) {
                i++;//update smaller element index
                // Swap arr[i] and arr[j]//samller with greater
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] (first greater) and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;//index of pivot
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
```

### Time Complexity:
- **Best Case**: O(n log n) - Pivot divides array into equal halves
- **Average Case**: O(n log n)
- **Worst Case**: O(n²) - Pivot is always smallest/largest element

### Space Complexity: O(log n) - Due to recursion stack

### Characteristics:
- **Stable**: No (depends on partition implementation)
- **In-place**: Yes
- **Adaptive**: No

### Advantages:
- Very efficient on average O(n log n)
- In-place sorting
- Widely used in practice
- Cache-friendly

### Disadvantages:
- Worst-case O(n²) time complexity
- Not stable
- Performance depends on pivot selection

---

## 5. Merge Sort

### What is Merge Sort?
Merge Sort is a divide-and-conquer algorithm that divides the array into halves, sorts them, and then merges them back.

### Algorithm:
1. Divide array into two halves
2. Recursively sort both halves
3. Merge the sorted halves

### Implementation:
```java
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temp arrays for left and right subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        // Merge the temp arrays back into arr[left..right]
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
```

### Time Complexity:
- **Best Case**: O(n log n)
- **Average Case**: O(n log n)
- **Worst Case**: O(n log n) - Consistent performance

### Space Complexity: O(n) - Requires additional space for temporary arrays

### Characteristics:
- **Stable**: Yes
- **In-place**: No
- **Adaptive**: No

### Advantages:
- Guaranteed O(n log n) time complexity
- Stable sorting algorithm
- Predictable performance
- Good for large datasets
- Parallelizable

### Disadvantages:
- Requires O(n) extra space
- Not in-place
- Slower than quicksort in practice for smaller arrays

---

## Comparison of Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable | In-place |
|-----------|-----------|--------------|------------|-------|--------|----------|
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No | Yes |
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes | No |

## When to Use Each Algorithm

### Selection Sort:
- Small datasets
- When memory is limited
- When you need to minimize swaps

### Bubble Sort:
- Educational purposes
- Very small datasets
- When you need stable sort and simplicity

### Insertion Sort:
- Small datasets (< 50 elements)
- Nearly sorted arrays
- Online sorting (data arrives over time)

### Quick Sort:
- Large datasets
- When average-case performance is important
- When memory is limited (in-place)

### Merge Sort:
- Large datasets
- When you need guaranteed O(n log n) performance
- When stability is required
- External sorting (when data doesn't fit in memory)

## Key Points to Remember

1. **Simple sorts (Selection, Bubble, Insertion)**: O(n²) but good for small data
2. **Quick Sort**: Fast average case O(n log n), but O(n²) worst case
3. **Merge Sort**: Consistent O(n log n) but requires extra space
4. **Stability**: Merge, Bubble, Insertion are stable
5. **In-place**: Selection, Bubble, Insertion, Quick are in-place
6. **Adaptive**: Bubble and Insertion perform better on nearly sorted data

## Practice Problems

1. **Implement all sorting algorithms**
2. **Sort colors (Dutch National Flag)**
3. **Sort array with limited range**
4. **Merge two sorted arrays**
5. **Find Kth largest element**
6. **Sort array of 0s, 1s, and 2s**
7. **Implement custom comparator sorting**

This comprehensive guide covers all sorting algorithms from your Day 5 curriculum with detailed implementations and comparisons!
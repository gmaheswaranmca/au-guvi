## Bucket Sort and Radix Sort - Notes

### 1. Bucket Sort

#### What is Bucket Sort?
Bucket Sort is a sorting algorithm that distributes elements into a number of buckets, sorts each bucket individually, and then concatenates the sorted buckets to get the final sorted array.

#### When to Use Bucket Sort:
- When input is uniformly distributed over a range
- When you know the range of input values
- Best for floating-point numbers in [0, 1) range

#### Algorithm:
1. Create n empty buckets
2. Distribute array elements into buckets based on their values
3. Sort each bucket individually (using any sorting algorithm)
4. Concatenate all sorted buckets

#### Implementation:
```java
import java.util.*;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        
        // Create empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Put array elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }
        
        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        
        // Concatenate all buckets
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float value : buckets[i]) {
                arr[index++] = value;
            }
        }
    }
    
    // For integer arrays with known range
    public static void bucketSortIntegers(int[] arr, int maxValue) {
        int n = arr.length;
        
        // Create buckets
        List<Integer>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Distribute elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] * n) / (maxValue + 1);
            buckets[bucketIndex].add(arr[i]);
        }
        
        // Sort each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        
        // Merge buckets back
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int value : buckets[i]) {
                arr[index++] = value;
            }
        }
    }
    
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        bucketSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
```

#### Time Complexity:
- **Best Case**: O(n + k) where k is the number of buckets
- **Average Case**: O(n + k)
- **Worst Case**: O(n²) when all elements go to one bucket

#### Space Complexity: O(n + k)

#### Characteristics:
- **Stable**: Yes (depends on sorting algorithm used for buckets)
- **In-place**: No
- **Adaptive**: No

#### Advantages:
- Very efficient when input is uniformly distributed
- Can achieve O(n) time complexity in best case
- Stable sorting algorithm
- Good for sorting floating-point numbers

#### Disadvantages:
- Requires knowledge of input range
- Performance depends on input distribution
- Uses extra space for buckets
- Not suitable for general-purpose sorting

---

### 2. Radix Sort

#### What is Radix Sort?
Radix Sort is a non-comparative sorting algorithm that sorts numbers by processing individual digits. It uses counting sort as a subroutine to sort digits.

#### Types of Radix Sort:
1. **LSD (Least Significant Digit)**: Sorts from rightmost digit to leftmost
2. **MSD (Most Significant Digit)**: Sorts from leftmost digit to rightmost

#### Algorithm (LSD):
1. Find the maximum number to determine number of digits
2. For each digit position (from least to most significant):
   - Use counting sort to sort array based on current digit
3. Repeat until all digits are processed

#### Implementation:
```java
public class RadixSort {
    
    // Main radix sort function
    public static void radixSort(int[] arr) {
        // Find maximum number to determine number of digits
        int max = getMax(arr);
        
        // Do counting sort for every digit
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    
    // Find maximum element in array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Counting sort based on digit represented by exp
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // For digits 0-9
        
        // Initialize count array
        Arrays.fill(count, 0);
        
        // Store count of occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        // Change count[i] so it contains actual position of digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        // Copy output array to arr
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    // Radix sort for strings
    public static void radixSortStrings(String[] arr) {
        if (arr.length == 0) return;
        
        // Find maximum length
        int maxLength = 0;
        for (String str : arr) {
            maxLength = Math.max(maxLength, str.length());
        }
        
        // Sort from rightmost character to leftmost
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSortStrings(arr, pos);
        }
    }
    
    private static void countingSortStrings(String[] arr, int pos) {
        int n = arr.length;
        String[] output = new String[n];
        int[] count = new int[256]; // For ASCII characters
        
        Arrays.fill(count, 0);
        
        // Count occurrences of each character
        for (String str : arr) {
            int charIndex = (pos < str.length()) ? str.charAt(pos) : 0;
            count[charIndex]++;
        }
        
        // Change count[i] to actual position
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            int charIndex = (pos < arr[i].length()) ? arr[i].charAt(pos) : 0;
            output[count[charIndex] - 1] = arr[i];
            count[charIndex]--;
        }
        
        // Copy output to original array
        System.arraycopy(output, 0, arr, 0, n);
    }
    
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 2, 802, 24, 66};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        // String example
        String[] strArr = {"apple", "banana", "cherry", "date", "elderberry"};
        System.out.println("Original strings: " + Arrays.toString(strArr));
        
        radixSortStrings(strArr);
        System.out.println("Sorted strings: " + Arrays.toString(strArr));
    }
}
```

#### Time Complexity:
- **Best Case**: O(d × (n + k)) where d = number of digits, k = range of digits
- **Average Case**: O(d × (n + k))
- **Worst Case**: O(d × (n + k))

#### Space Complexity: O(n + k)

#### Characteristics:
- **Stable**: Yes
- **In-place**: No
- **Adaptive**: No

#### Advantages:
- Linear time complexity O(d × n) for fixed number of digits
- Stable sorting algorithm
- Good for sorting integers and strings
- No comparisons needed

#### Disadvantages:
- Only works for integers, strings, or fixed-length keys
- Uses extra space
- Performance depends on number of digits
- Not suitable for general-purpose sorting

---

## Comparison: Bucket Sort vs Radix Sort

| Aspect | Bucket Sort | Radix Sort |
|--------|-------------|------------|
| **Type** | Distribution Sort | Non-comparative Sort |
| **Best For** | Uniformly distributed data | Integers, strings |
| **Time Complexity** | O(n + k) average | O(d × (n + k)) |
| **Space Complexity** | O(n + k) | O(n + k) |
| **Stability** | Yes | Yes |
| **Input Requirements** | Known range | Fixed-length keys |
| **Use Cases** | Float numbers [0,1) | Integers, strings |

## Advanced Variations:

### 1. **Counting Sort (Used in Radix Sort)**
```java
public static void countingSort(int[] arr, int range) {
    int n = arr.length;
    int[] count = new int[range + 1];
    int[] output = new int[n];
    
    // Count occurrences
    for (int i = 0; i < n; i++) {
        count[arr[i]]++;
    }
    
    // Cumulative count
    for (int i = 1; i <=
    range; i++) {
        count[i] += count[i - 1];
        }

        // Build output array
        for (int i = n - 1; i >= 0; i--) {
        output[count[arr[i]] - 1] = arr[i];
        count[arr[i]]--;
        }

        // Copy output to original array
        for (int i = 0; i < n; i++) {
        arr[i] = output[i];
        }
    }
```

#### Characteristics:
- **Stable**: Yes
- **In-place**: No
- **Time Complexity**: O(n + k)
- **Space Complexity**: O(n + k)

---

## Summary

- **Bucket Sort** and **Radix Sort** are efficient for specific types of data and can outperform comparison-based sorts in those cases.
- Both require extra space and have input constraints.
- **Counting Sort** is a key building block for Radix Sort and is also efficient for small ranges.

---
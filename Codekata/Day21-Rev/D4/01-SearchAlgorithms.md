## Searching Algorithms - Notes

### 1. Linear Search

#### What is Linear Search?
Linear search is the simplest searching algorithm that checks each element in the array sequentially until the target element is found or the end of the array is reached.

#### Algorithm:
1. Start from the first element
2. Compare each element with the target
3. If found, return the index
4. If not found after checking all elements, return -1

#### Implementation:
```java
public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        int result = linearSearch(arr, target);
        
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

#### Time Complexity:
- **Best Case**: O(1) - Element found at first position
- **Average Case**: O(n/2) = O(n) - Element found at middle
- **Worst Case**: O(n) - Element at last position or not found

#### Space Complexity: O(1)

#### Advantages:
- Simple to understand and implement
- Works on both sorted and unsorted arrays
- No preprocessing required

#### Disadvantages:
- Inefficient for large datasets
- Time complexity is O(n)

---

### 2. Binary Search

#### What is Binary Search?
Binary search is an efficient searching algorithm that works on sorted arrays by repeatedly dividing the search space in half.

#### Prerequisites:
- Array must be sorted
- Random access to elements (works well with arrays)

#### Algorithm:
1. Set low = 0, high = array.length - 1
2. While low <= high:
   - Calculate mid = (low + high) / 2
   - If arr[mid] == target, return mid
   - If arr[mid] < target, set low = mid + 1
   - If arr[mid] > target, set high = mid - 1
3. Return -1 if not found

#### Implementation:

##### Iterative Approach:
```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents overflow
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1; // Not found
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int target = 40;
        int result = binarySearch(arr, target);
        
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

##### Recursive Approach:
```java
public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: not found
        }
        
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, high);
        } else {
            return binarySearch(arr, target, low, mid - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int target = 40;
        int result = binarySearch(arr, target, 0, arr.length - 1);
        
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

#### Time Complexity:
- **Best Case**: O(1) - Element found at middle
- **Average Case**: O(log n)
- **Worst Case**: O(log n) - Element at extremes or not found

#### Space Complexity:
- **Iterative**: O(1)
- **Recursive**: O(log n) - due to function call stack

#### Advantages:
- Very efficient for large datasets
- Time complexity is O(log n)
- Divide and conquer approach

#### Disadvantages:
- Requires sorted array
- Not suitable for linked lists (no random access)

---

### 3. Ternary Search

#### What is Ternary Search?
Ternary search is a divide-and-conquer algorithm that divides the array into three parts instead of two (like binary search).

#### Prerequisites:
- Array must be sorted
- Works by eliminating 1/3 of the search space in each iteration

#### Algorithm:
1. Set low = 0, high = array.length - 1
2. While low <= high:
   - Calculate mid1 = low + (high - low) / 3
   - Calculate mid2 = high - (high - low) / 3
   - If arr[mid1] == target, return mid1
   - If arr[mid2] == target, return mid2
   - If target < arr[mid1], search in left third
   - If target > arr[mid2], search in right third
   - Otherwise, search in middle third
3. Return -1 if not found

#### Implementation:

##### Iterative Approach:
```java
public class TernarySearch {
    public static int ternarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            
            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }
            
            if (target < arr[mid1]) {
                high = mid1 - 1;
            } else if (target > arr[mid2]) {
                low = mid2 + 1;
            } else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        
        return -1; // Not found
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target = 60;
        int result = ternarySearch(arr, target);
        
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

##### Recursive Approach:
```java
public class TernarySearchRecursive {
    public static int ternarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: not found
        }
        
        int mid1 = low + (high - low) / 3;
        int mid2 = high - (high - low) / 3;
        
        if (arr[mid1] == target) {
            return mid1;
        }
        if (arr[mid2] == target) {
            return mid2;
        }
        
        if (target < arr[mid1]) {
            return ternarySearch(arr, target, low, mid1 - 1);
        } else if (target > arr[mid2]) {
            return ternarySearch(arr, target, mid2 + 1, high);
        } else {
            return ternarySearch(arr, target, mid1 + 1, mid2 - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target = 60;
        int result = ternarySearch(arr, target, 0, arr.length - 1);
        
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

#### Time Complexity:
- **Best Case**: O(1) - Element found at mid1 or mid2
- **Average Case**: O(log₃ n)
- **Worst Case**: O(log₃ n)

#### Space Complexity:
- **Iterative**: O(1)
- **Recursive**: O(log₃ n)

#### Advantages:
- Divides search space into three parts
- Can be faster than binary search in some cases
- Efficient for large datasets

#### Disadvantages:
- More comparisons per iteration than binary search
- Requires sorted array
- In practice, binary search is often preferred

---

### Comparison of Search Algorithms:

| Algorithm | Time Complexity | Space Complexity | Prerequisites | Best For |
|-----------|----------------|------------------|---------------|----------|
| Linear Search | O(n) | O(1) | None | Small/unsorted arrays |
| Binary Search | O(log n) | O(1) iterative | Sorted array | Large sorted arrays |
| Ternary Search | O(log₃ n) | O(1) iterative | Sorted array | Theoretical interest |

### When to Use Each Algorithm:

#### Linear Search:
- Small datasets (< 100 elements)
- Unsorted arrays
- When simplicity is more important than efficiency

#### Binary Search:
- Large sorted datasets
- When O(log n) performance is required
- Most commonly used efficient search algorithm

#### Ternary Search:
- Theoretical scenarios
- When you want to explore divide-and-conquer variants
- Research or educational purposes

### Key Points to Remember:

1. **Linear Search**: Simple but inefficient O(n)
2. **Binary Search**: Most practical and efficient O(log n)
3. **Ternary Search**: Theoretical interest O(log₃ n)
4. **Sorting requirement**: Binary and Ternary need sorted arrays
5. **Space complexity**: All can be implemented with O(1) space
6. **Practical choice**: Binary search is the gold standard for sorted arrays

### Practice Problems:

1. **Find First and Last Position**: Use binary search to find first and last occurrence
2. **Search in Rotated Sorted Array**: Modified binary search
3. **Find Peak Element**: Using ternary search concept
4. **Search in 2D Matrix**: Apply binary search principles
5. **Find Minimum in Rotated Array**: Binary search variant

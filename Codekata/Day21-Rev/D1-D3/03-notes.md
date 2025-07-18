# Java Arrays & Strings - Day 3 Notes

## Table of Contents
1. [Arrays in Java](#arrays-in-java)
2. [Arrays Class in Java](#arrays-class-in-java)
3. [String Class in Java](#string-class-in-java)
4. [Easy Scenario Based Problems on Arrays and Strings](#easy-scenario-based-problems-on-arrays-and-strings)
5. [More Problem Solving on Arrays and Strings](#more-problem-solving-on-arrays-and-strings)
6. [Advanced Level Problem Solving on Arrays and Strings](#advanced-level-problem-solving-on-arrays-and-strings)

---

## Arrays in Java

Arrays are data structures that store multiple elements of the same type in contiguous memory locations.

### Array Declaration and Initialization

#### 1. Declaration Syntax
```java
// Method 1: Declare then initialize
dataType[] arrayName;
dataType arrayName[];  // C-style (less preferred)

// Method 2: Declare and initialize together
dataType[] arrayName = new dataType[size];

// Method 3: Declare and initialize with values
dataType[] arrayName = {value1, value2, value3, ...};
```

#### 2. Examples of Array Declaration
```java
public class ArrayDeclaration {
    public static void main(String[] args) {
        // Integer arrays
        int[] numbers = new int[5];                    // Array of 5 integers (default: 0)
        int[] scores = {85, 92, 78, 96, 88};          // Array with initial values
        int[] grades = new int[]{90, 85, 92, 78};     // Alternative syntax
        
        // String arrays
        String[] names = new String[3];                // Array of 3 strings (default: null)
        String[] cities = {"New York", "London", "Tokyo"};
        
        // Double arrays
        double[] prices = {19.99, 25.50, 12.75, 8.99};
        
        // Character arrays
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        
        // Boolean arrays
        boolean[] flags = new boolean[4];              // All false by default
    }
}
```

### Array Operations

#### 1. Accessing and Modifying Elements
```java
public class ArrayOperations {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Accessing elements (0-based indexing)
        System.out.println("First element: " + numbers[0]);    // 10
        System.out.println("Last element: " + numbers[4]);     // 50
        System.out.println("Array length: " + numbers.length); // 5
        
        // Modifying elements
        numbers[2] = 35;  // Change 30 to 35
        System.out.println("Modified element: " + numbers[2]); // 35
        
        // Iterating through array
        System.out.println("Array elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
        
        // Enhanced for loop (for-each)
        System.out.println("Using enhanced for loop:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
```

#### 2. Array Input and Output
```java
import java.util.Scanner;

public class ArrayInputOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        
        // Input array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Output array elements
        System.out.println("Array elements are:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
```

### Multi-dimensional Arrays

#### 1. Two-Dimensional Arrays
```java
public class TwoDArrays {
    public static void main(String[] args) {
        // Declaration and initialization
        int[][] matrix = new int[3][4];  // 3 rows, 4 columns
        
        // Initialize with values
        int[][] numbers = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        // Accessing elements
        System.out.println("Element at [1][2]: " + numbers[1][2]); // 7
        
        // Iterating through 2D array
        System.out.println("Matrix elements:");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
        
        // Enhanced for loop for 2D arrays
        System.out.println("Using enhanced for loop:");
        for (int[] row : numbers) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
```

#### 2. Jagged Arrays
```java
public class JaggedArrays {
    public static void main(String[] args) {
        // Jagged array - rows can have different lengths
        int[][] jaggedArray = new int[3][];
        
        jaggedArray[0] = new int[3];        // First row has 3 elements
        jaggedArray[1] = new int[2];        // Second row has 2 elements
        jaggedArray[2] = new int[4];        // Third row has 4 elements
        
        // Initialize values
        int value = 1;
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = value++;
            }
        }
        
        // Display jagged array
        System.out.println("Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## Arrays Class in Java

The `java.util.Arrays` class provides utility methods for array operations.

### Common Arrays Class Methods

```java
import java.util.Arrays;

public class ArraysClassDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9, 3};
        
        // 1. toString() - Convert array to string
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        // 2. sort() - Sort array in ascending order
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        
        // 3. binarySearch() - Search element (array must be sorted)
        int index = Arrays.binarySearch(numbers, 5);
        System.out.println("Index of 5: " + index);
        
        // 4. fill() - Fill array with specified value
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 10);
        System.out.println("Filled array: " + Arrays.toString(fillArray));
        
        // 5. copyOf() - Copy array
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied array: " + Arrays.toString(copy));
        
        // 6. copyOfRange() - Copy part of array
        int[] partialCopy = Arrays.copyOfRange(numbers, 1, 4);
        System.out.println("Partial copy: " + Arrays.toString(partialCopy));
        
        // 7. equals() - Compare arrays
        boolean areEqual = Arrays.equals(numbers, copy);
        System.out.println("Arrays are equal: " + areEqual);
        
        // 8. deepEquals() - For multi-dimensional arrays
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        boolean deepEqual = Arrays.deepEquals(matrix1, matrix2);
        System.out.println("Matrices are equal: " + deepEqual);
        
        // 9. deepToString() - For multi-dimensional arrays
        System.out.println("Matrix: " + Arrays.deepToString(matrix1));
    }
}
```

### Advanced Arrays Class Methods

```java
import java.util.Arrays;
import java.util.Comparator;

public class AdvancedArraysClass {
    public static void main(String[] args) {
        // Sorting with custom comparator
        String[] names = {"Alice", "Bob", "Charlie", "David"};
        
        // Sort by length
        Arrays.sort(names, Comparator.comparing(String::length));
        System.out.println("Sorted by length: " + Arrays.toString(names));
        
        // Sort in reverse order
        Integer[] numbers = {5, 2, 8, 1, 9, 3};
        Arrays.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse sorted: " + Arrays.toString(numbers));
        
        // Parallel sort (for large arrays)
        int[] largeArray = {64, 34, 25, 12, 22, 11, 90};
        Arrays.parallelSort(largeArray);
        System.out.println("Parallel sorted: " + Arrays.toString(largeArray));
        
        // Stream operations (Java 8+)
        int sum = Arrays.stream(largeArray).sum();
        System.out.println("Sum of array: " + sum);
        
        double average = Arrays.stream(largeArray).average().orElse(0.0);
        System.out.println("Average: " + average);
    }
}
```

---

## String Class in Java

Strings in Java are objects that represent sequences of characters. The String class is immutable.

### String Creation

```java
public class StringCreation {
    public static void main(String[] args) {
        // Method 1: String literal (recommended)
        String str1 = "Hello World";
        
        // Method 2: Using new keyword
        String str2 = new String("Hello World");
        
        // Method 3: From character array
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);
        
        // Method 4: From byte array
        byte[] byteArray = {72, 101, 108, 108, 111};
        String str4 = new String(byteArray);
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);
        
        // String comparison
        System.out.println("str1 == str2: " + (str1 == str2));         // false
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true
    }
}
```

### String Methods

```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello World Java Programming";
        
        // Length and character access
        System.out.println("Length: " + str.length());                    // 28
        System.out.println("Character at index 6: " + str.charAt(6));     // W
        
        // Case conversion
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        
        // Substring operations
        System.out.println("Substring(6): " + str.substring(6));          // World Java Programming
        System.out.println("Substring(6,11): " + str.substring(6, 11));   // World
        
        // Search operations
        System.out.println("Index of 'World': " + str.indexOf("World"));           // 6
        System.out.println("Last index of 'a': " + str.lastIndexOf("a"));          // 26
        System.out.println("Contains 'Java': " + str.contains("Java"));            // true
        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));     // true
        System.out.println("Ends with 'ing': " + str.endsWith("ing"));             // true
        
        // Replace operations
        System.out.println("Replace 'Java' with 'Python': " + str.replace("Java", "Python"));
        System.out.println("Replace all 'a' with 'X': " + str.replaceAll("a", "X"));
        
        // Trim and split
        String spacedStr = "  Hello World  ";
        System.out.println("Original: '" + spacedStr + "'");
        System.out.println("Trimmed: '" + spacedStr.trim() + "'");
        
        String[] words = str.split(" ");
        System.out.println("Split words: " + Arrays.toString(words));
        
        // Comparison
        String str2 = "hello world java programming";
        System.out.println("Equals: " + str.equals(str2));                         // false
        System.out.println("Equals ignore case: " + str.equalsIgnoreCase(str2));   // true
        System.out.println("Compare to: " + str.compareTo(str2));                  // negative value
    }
}
```

### StringBuilder and StringBuffer

```java
public class StringBuilderDemo {
    public static void main(String[] args) {
        // StringBuilder (not thread-safe, faster)
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println("StringBuilder: " + sb.toString());
        
        // Insert and delete operations
        sb.insert(5, " Beautiful");
        System.out.println("After insert: " + sb.toString());
        
        sb.delete(5, 15);
        System.out.println("After delete: " + sb.toString());
        
        sb.reverse();
        System.out.println("Reversed: " + sb.toString());
        
        // StringBuffer (thread-safe, slower)
        StringBuffer sbf = new StringBuffer("Java");
        sbf.append(" Programming");
        System.out.println("StringBuffer: " + sbf.toString());
        
        // Performance comparison
        long startTime = System.currentTimeMillis();
        
        // String concatenation (inefficient)
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String concatenation time: " + (endTime - startTime) + "ms");
        
        // StringBuilder (efficient)
        startTime = System.currentTimeMillis();
        StringBuilder efficientSB = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            efficientSB.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + "ms");
    }
}
```

---

## Easy Scenario Based Problems on Arrays and Strings

### Array Problems

#### Problem 1: Find Maximum and Minimum in Array
```java
public class FindMaxMin {
    public static void main(String[] args) {
        int[] numbers = {45, 23, 67, 12, 89, 34, 78};
        
        int max = numbers[0];
        int min = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
```

#### Problem 2: Sum of Array Elements
```java
public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        
        double average = (double) sum / numbers.length;
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
```

#### Problem 3: Count Even and Odd Numbers
```java
public class CountEvenOdd {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int evenCount = 0;
        int oddCount = 0;
        
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }
}
```

#### Problem 4: Linear Search
```java
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] numbers = {45, 23, 67, 12, 89, 34, 78};
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.print("Enter number to search: ");
        int target = scanner.nextInt();
        
        int index = linearSearch(numbers, target);
        
        if (index != -1) {
            System.out.println("Number " + target + " found at index " + index);
        } else {
            System.out.println("Number " + target + " not found in array");
        }
        
        scanner.close();
    }
    
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```

#### Problem 5: Reverse Array
```java
public class ReverseArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        // Method 1: Using two pointers
        reverseArray(numbers);
        System.out.println("Reversed array: " + Arrays.toString(numbers));
        
        // Method 2: Create new reversed array
        int[] original = {1, 2, 3, 4, 5};
        int[] reversed = createReversedArray(original);
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("New reversed: " + Arrays.toString(reversed));
    }
    
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    
    public static int[] createReversedArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
```

### String Problems

#### Problem 1: Count Vowels and Consonants
```java
public class CountVowelsConsonants {
    public static void main(String[] args) {
        String text = "Hello World Java Programming";
        
        int vowels = 0;
        int consonants = 0;
        
        String vowelString = "aeiouAEIOU";
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                if (vowelString.indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Text: " + text);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
```

#### Problem 2: Reverse String
```java
public class ReverseString {
    public static void main(String[] args) {
        String original = "Hello World";
        
        // Method 1: Using StringBuilder
        StringBuilder sb = new StringBuilder(original);
        String reversed1 = sb.reverse().toString();
        
        // Method 2: Using character array
        char[] charArray = original.toCharArray();
        String reversed2 = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversed2 += charArray[i];
        }
        
        // Method 3: Using loop
        String reversed3 = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed3 += original.charAt(i);
        }
        
        System.out.println("Original: " + original);
        System.out.println("Reversed (StringBuilder): " + reversed1);
        System.out.println("Reversed (char array): " + reversed2);
        System.out.println("Reversed (loop): " + reversed3);
    }
}
```

#### Problem 3: Check Palindrome
```java
public class PalindromeChecker {
    public static void main(String[] args) {
        String[] testStrings = {"racecar", "hello", "madam", "level", "world"};
        
        for (String str : testStrings) {
            boolean isPalindrome = checkPalindrome(str);
            System.out.println(str + " is " + (isPalindrome ? "" : "not ") + "a palindrome");
        }
    }
    
    public static boolean checkPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

#### Problem 4: Count Words in String
```java
public class CountWords {
    public static void main(String[] args) {
        String text = "Java is a programming language";
        
        // Method 1: Using split
        String[] words = text.trim().split("\\s+");
        int wordCount1 = text.trim().isEmpty() ? 0 : words.length;
        
        // Method 2: Manual counting
        int wordCount2 = 0;
        boolean inWord = false;
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isWhitespace(ch)) {
                inWord = false;
            } else if (!inWord) {
                wordCount2++;
                inWord = true;
            }
        }
        
        System.out.println("Text: " + text);
        System.out.println("Word count (split): " + wordCount1);
        System.out.println("Word count (manual): " + wordCount2);
        System.out.println("Words: " + Arrays.toString(words));
    }
}
```

#### Problem 5: Remove Duplicates from String
```java
public class RemoveDuplicates {
    public static void main(String[] args) {
        String original = "programming";
        
        String result = removeDuplicates(original);
        
        System.out.println("Original: " + original);
        System.out.println("After removing duplicates: " + result);
    }
    
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // ASCII characters
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}
```

---

## More Problem Solving on Arrays and Strings

### Intermediate Array Problems

#### Problem 1: Binary Search
```java
public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78};
        int target = 23;
        
        int index = binarySearch(sortedArray, target);
        
        System.out.println("Array: " + Arrays.toString(sortedArray));
        System.out.println("Target: " + target);
        
        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not found");
        }
    }
    
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}
```

#### Problem 2: Bubble Sort
```java
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array: " + Arrays.toString(array));
        
        bubbleSort(array);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
    
    public static void bubbleSort(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
}
```

#### Problem 3: Find Second Largest Element
```java
public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {45, 23, 67, 12, 89, 34, 78, 89};
        
        int secondLargest = findSecondLargest(array);
        
        System.out.println("Array: " + Arrays.toString(array));
        
        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Second largest: " + secondLargest);
        } else {
            System.out.println("No second largest element found");
        }
    }
    
    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            return Integer.MIN_VALUE;
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        
        return secondLargest == Integer.MIN_VALUE ? Integer.MIN_VALUE : secondLargest;
    }
}
```

#### Problem 4: Array Rotation
```java
public class ArrayRotation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int rotations = 3;
        
        System.out.println("Original array: " + Arrays.toString(array));
        
        // Left rotation
        int[] leftRotated = Arrays.copyOf(array, array.length);
        rotateLeft(leftRotated, rotations);
        System.out.println("Left rotated by " + rotations + ": " + Arrays.toString(leftRotated));
        
        // Right rotation
        int[] rightRotated = Arrays.copyOf(array, array.length);
        rotateRight(rightRotated, rotations);
        System.out.println("Right rotated by " + rotations + ": " + Arrays.toString(rightRotated));
    }
    
    public static void rotateLeft(int[] array, int rotations) {
        int n = array.length;
        rotations = rotations % n; // Handle rotations > array length
        
        reverse(array, 0, rotations - 1);
        reverse(array, rotations, n - 1);
        reverse(array, 0, n - 1);
    }
    
    public static void rotateRight(int[] array, int rotations) {
        int n = array.length;
        rotations = rotations % n;
        
        reverse(array, 0, n - 1);
        reverse(array, 0, rotations - 1);
        reverse(array, rotations, n - 1);
    }
    
    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
```

#### Problem 5: Missing Number in Array
```java
public class MissingNumber {
    public static void main(String[] args) {
        // Array contains numbers from 1 to n with one missing
        int[] array = {1, 2, 4, 6, 3, 7, 8};  // Missing: 5
        
        int missing = findMissingNumber(array);
        
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Missing number: " + missing);
    }
    
    public static int findMissingNumber(int[] array) {
        int n = array.length + 1; // Since one number is missing
        
        // Method 1: Using sum formula
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : array) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
        
        // Method 2: Using XOR (alternative approach)
        // int xor1 = 0, xor2 = 0;
        // for (int i = 0; i < array.length; i++) {
        //     xor2 ^= array[i];
        //     xor1 ^= (i + 1);
        // }
        // xor1 ^= n;
        // return xor1 ^ xor2;
    }
}
```

### Intermediate String Problems

#### Problem 1: Anagram Checker
```java
import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        boolean isAnagram = checkAnagram(str1, str2);
        
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("Are anagrams: " + isAnagram);
    }
    
    public static boolean checkAnagram(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Method 1: Sort and compare
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        
        Arrays.sort(char1);
        Arrays.sort(char2);
        
        return Arrays.equals(char1, char2);
        
        // Method 2: Character frequency count (alternative)
        // int[] count = new int[26];
        // for (int i = 0; i < str1.length(); i++) {
        //     count[str1.charAt(i) - 'a']++;
        //     count[str2.charAt(i) - 'a']--;
        // }
        // for (int c : count) {
        //     if (c != 0) return false;
        // }
        // return true;
    }
}
```

#### Problem 2: String Compression
```java
public class StringCompression {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        String compressed = compress(input);
        
        System.out.println("Original: " + input);
        System.out.println("Compressed: " + compressed);
    }
    
    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
            }
        }
        
        // Add last character and its count
        compressed.append(str.charAt(str.length() - 1));
        if (count > 1) {
            compressed.append(count);
        }
        
        return compressed.toString();
    }
}
```

#### Problem 3: Longest Common Prefix
```java
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        
        String prefix = findLongestCommonPrefix(strings);
        
        System.out.println("Strings: " + Arrays.toString(strings));
        System.out.println("Longest common prefix: '" + prefix + "'");
    }
    
    public static String findLongestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        
        String prefix = strings[0];
        
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}
```

#### Problem 4: Valid Parentheses
```java
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        
        for (String test : testCases) {
            boolean isValid = isValidParentheses(test);
            System.out.println("'" + test + "' is " + (isValid ? "valid" : "invalid"));
        }
    }
    
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
```

---

## Advanced Level Problem Solving on Arrays and Strings

### Advanced Array Problems

#### Problem 1: Merge Sort
```java
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original array: " + Arrays.toString(array));
        
        mergeSort(array, 0, array.length - 1);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
    
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            
            merge(array, left, mid, right);
        }
    }
    
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
```

#### Problem 2: Maximum Subarray Sum (Kadane's Algorithm)
```java
public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        
        int maxSum = kadaneAlgorithm(array);
        
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Maximum subarray sum: " + maxSum);
        
        // Also find the subarray
        int[] result = kadaneWithSubarray(array);
        System.out.println("Subarray: " + Arrays.toString(Arrays.copyOfRange(array, result[1], result[2] + 1)));
    }
    
    public static int kadaneAlgorithm(int[] array) {
        int maxSoFar = array[0];
        int maxEndingHere = array[0];
        
        for (int i = 1; i < array.length; i++) {
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    public static int[] kadaneWithSubarray(int[] array) {
        int maxSoFar = array[0];
        int maxEndingHere = array[0];
        int start = 0, end = 0, tempStart = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = array[i];
                tempStart = i;
            } else {
                maxEndingHere += array[i];
            }
            
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        
        return new int[]{maxSoFar, start, end};
    }
}
```

#### Problem 3: Trapping Rain Water
```java
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        int trappedWater = trap(height);
        
        System.out.println("Heights: " + Arrays.toString(height));
        System.out.println("Trapped water: " + trappedWater);
    }
    
    public static int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        
        return trappedWater;
    }
}
```

#### Problem 4: Stock Buy Sell Problem
```java
public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        
        int maxProfit = maxProfitSingleTransaction(prices);
        int maxProfitMultiple = maxProfitMultipleTransactions(prices);
        
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Max profit (single transaction): " + maxProfit);
        System.out.println("Max profit (multiple transactions): " + maxProfitMultiple);
    }
    
    // Best Time to Buy and Sell Stock (single transaction)
    public static int maxProfitSingleTransaction(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
    
    // Best Time to Buy and Sell Stock II (multiple transactions)
    public static int maxProfitMultipleTransactions(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}
```

### Advanced String Problems

#### Problem 1: KMP Pattern Matching
```java
public class KMPPatternMatching {
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABCABCABCABC";
        String pattern = "ABABCABCAB";
        
        int index = KMPSearch(pattern, text);
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        
        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
    
    public static int KMPSearch(String pattern, String text) {
        int[] lps = computeLPSArray(pattern);
        
        int i = 0; // index for text
        int j = 0; // index for pattern
        
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            
            if (j == pattern.length()) {
                return i - j; // Pattern found
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return -1; // Pattern not found
    }
    
    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
```

#### Problem 2: Longest Palindromic Substring
```java
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        
        String longest = longestPalindrome(s);
        
        System.out.println("String: " + s);
        System.out.println("Longest palindromic substring: " + longest);
    }
    
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        int start = 0;
        int maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int currentLength = right - left + 1;
                if (currentLength > maxLength) {
                    start = left;
                    maxLength = currentLength;
                }
                left--;
                right++;
            }
            
            // Check for even length palindromes
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int currentLength = right - left + 1;
                if (currentLength > maxLength) {
                    start = left;
                    maxLength = currentLength;
                }
                left--;
                right++;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}
```

#### Problem 3: Edit Distance (Levenshtein Distance)
```java
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        
        int distance = minDistance(word1, word2);
        
        System.out.println("Word 1: " + word1);
        System.out.println("Word 2: " + word2);
        System.out.println("Edit distance: " + distance);
    }
    
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],     // Delete
                        Math.min(
                            dp[i][j - 1], // Insert
                            dp[i - 1][j - 1] // Replace
                        )
                    );
                }
            }
        }
        
        return dp[m][n];
    }
}
```

#### Problem 4: Word Break Problem
```java
import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        
        boolean canBreak = wordBreak(s, wordDict);
        
        System.out.println("String: " + s);
        System.out.println("Dictionary: " + wordDict);
        System.out.println("Can break: " + canBreak);
        
        if (canBreak) {
            List<String> allBreaks = wordBreakAll(s, wordDict);
            System.out.println("All possible breaks: " + allBreaks);
        }
    }
    
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public static List<String> wordBreakAll(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet, new HashMap<>());
    }
    
    private static List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixes = backtrack(s.substring(i), wordSet, memo);
                for (String suffix : suffixes) {
                    result.add(prefix + (suffix.isEmpty() ? "" : " " + suffix));
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}
```

---

## Best Practices and Tips

### Array Best Practices
1. **Always check array bounds** to avoid `ArrayIndexOutOfBoundsException`
2. **Use enhanced for loops** when you don't need the index
3. **Initialize arrays properly** and handle null arrays
4. **Consider using ArrayList** for dynamic arrays
5. **Use Arrays class methods** for common operations

### String Best Practices
1. **Use StringBuilder** for multiple string concatenations
2. **Be aware of string immutability** and memory implications
3. **Use appropriate comparison methods** (`equals()` vs `==`)
4. **Handle null strings** gracefully
5. **Use regular expressions** for complex pattern matching

### Performance Considerations
1. **Time Complexity**: Always analyze the time complexity of your algorithms
2. **Space Complexity**: Consider memory usage, especially for large datasets
3. **Algorithm Choice**: Choose the right algorithm for the problem size
4. **Optimization**: Look for opportunities to optimize your solutions

---

## Summary

This comprehensive guide covers:

1. **Arrays in Java**: Declaration, initialization, operations, and multi-dimensional arrays
2. **Arrays Class**: Utility methods for sorting, searching, and manipulating arrays
3. **String Class**: String operations, methods, StringBuilder, and StringBuffer
4. **Easy Problems**: Basic array and string manipulation problems
5. **Intermediate Problems**: More complex algorithms like binary search, sorting, and advanced string operations
6. **Advanced Problems**: Complex algorithms like merge sort, dynamic programming, and advanced pattern matching

These concepts and problems provide a solid foundation for data structure and algorithm problem-solving in Java.
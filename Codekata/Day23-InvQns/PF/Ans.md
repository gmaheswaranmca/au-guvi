# Programming Fundamentals in Java - Answers

**Target:** IT, CS, AI, ML, ECE candidates  
**Level:** Beginner  
**Companies:** Google, Amazon, Microsoft, Facebook, Zoho, etc.

---

## Basic Java Concepts

### 1. What is Java and what are its main features? (Google, Microsoft, Zoho)

**Answer:**
Java is a high-level, object-oriented programming language developed by Sun Microsystems (now Oracle). 

**Main features:**
- **Platform Independent:** Write once, run anywhere (WORA)
- **Object-Oriented:** Supports OOP concepts like inheritance, polymorphism, encapsulation
- **Simple:** Easy to learn and use
- **Secure:** Built-in security features
- **Robust:** Strong memory management and exception handling
- **Multithreaded:** Supports concurrent programming
- **Portable:** Can run on different platforms
- **High Performance:** Bytecode compilation and JIT compiler

### 2. Explain the difference between JDK, JRE, and JVM. (Amazon, Facebook, TCS)

**Answer:**
- **JVM (Java Virtual Machine):** Runtime environment that executes Java bytecode
- **JRE (Java Runtime Environment):** JVM + libraries + other files needed to run Java programs
- **JDK (Java Development Kit):** JRE + development tools (compiler, debugger, etc.)

**Relationship:** JDK > JRE > JVM

### 3. What is the difference between `==` and `.equals()` method in Java? (Google, Microsoft, Infosys)

**Answer:**
- **`==` operator:** Compares references (memory addresses) for objects, values for primitives
- **`.equals()` method:** Compares the actual content/value of objects

```java
String s1 = new String("Hello");
String s2 = new String("Hello");
String s3 = "Hello";
String s4 = "Hello";

System.out.println(s1 == s2);        // false (different objects)
System.out.println(s1.equals(s2));   // true (same content)
System.out.println(s3 == s4);        // true (string pool)
```

### 4. What are access modifiers in Java? Explain public, private, protected, and default. (Amazon, Zoho, Wipro)

**Answer:**
- **public:** Accessible from anywhere
- **private:** Accessible only within the same class
- **protected:** Accessible within package and subclasses
- **default (package-private):** Accessible within the same package

| Modifier | Same Class | Same Package | Subclass | Different Package |
|----------|------------|--------------|----------|-------------------|
| public   | ✓          | ✓            | ✓        | ✓                 |
| protected| ✓          | ✓            | ✓        | ✗                 |
| default  | ✓          | ✓            | ✗        | ✗                 |
| private  | ✓          | ✗            | ✗        | ✗                 |

### 5. What is the difference between static and non-static methods? (Facebook, Microsoft, Cognizant)

**Answer:**
- **Static methods:** Belong to the class, called without creating object, cannot access instance variables
- **Non-static methods:** Belong to instance, require object creation, can access both static and instance variables

```java
class Example {
    static int staticVar = 10;
    int instanceVar = 20;
    
    static void staticMethod() {
        System.out.println(staticVar); // OK
        // System.out.println(instanceVar); // Error
    }
    
    void instanceMethod() {
        System.out.println(staticVar);    // OK
        System.out.println(instanceVar);  // OK
    }
}
```

## Data Types and Variables

### 6. What are primitive data types in Java? List all eight primitive types. (Google, Amazon, HCL)

**Answer:**
Java has 8 primitive data types:

1. **byte:** 8-bit signed integer (-128 to 127)
2. **short:** 16-bit signed integer (-32,768 to 32,767)
3. **int:** 32-bit signed integer (-2^31 to 2^31-1)
4. **long:** 64-bit signed integer (-2^63 to 2^63-1)
5. **float:** 32-bit floating point
6. **double:** 64-bit floating point
7. **char:** 16-bit Unicode character
8. **boolean:** true or false

### 7. What is the difference between String, StringBuilder, and StringBuffer? (Microsoft, Zoho, Accenture)

**Answer:**
- **String:** Immutable, thread-safe, slower for concatenation
- **StringBuilder:** Mutable, not thread-safe, faster for concatenation
- **StringBuffer:** Mutable, thread-safe, slower than StringBuilder

```java
String str = "Hello";
str += " World"; // Creates new object

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Modifies existing object

StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World"); // Thread-safe modification
```

### 8. Explain type casting in Java with examples of implicit and explicit casting. (Facebook, Google, TCS)

**Answer:**
- **Implicit casting (Widening):** Automatic conversion from smaller to larger type
- **Explicit casting (Narrowing):** Manual conversion from larger to smaller type

```java
// Implicit casting
int i = 10;
double d = i; // int to double (automatic)

// Explicit casting
double d2 = 10.5;
int i2 = (int) d2; // double to int (manual)
```

### 9. What is autoboxing and unboxing in Java? (Amazon, Microsoft, Infosys)

**Answer:**
- **Autoboxing:** Automatic conversion of primitive to wrapper class
- **Unboxing:** Automatic conversion of wrapper class to primitive

```java
// Autoboxing
Integer obj = 10; // int to Integer

// Unboxing
int num = obj; // Integer to int
```

### 10. What happens when you don't initialize a variable in Java? (Zoho, Wipro, Cognizant)

**Answer:**
- **Instance variables:** Get default values (0 for numbers, false for boolean, null for objects)
- **Local variables:** Must be initialized before use, compilation error otherwise
- **Static variables:** Get default values

```java
class Example {
    int instanceVar;     // Default: 0
    static int staticVar; // Default: 0
    
    void method() {
        int localVar;
        // System.out.println(localVar); // Compilation error
    }
}
```

## Control Flow Statements

### 11. Write a program to check if a number is prime or not. (Google, Amazon, Microsoft)

**Answer:**
```java
public class PrimeCheck {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int num = 29;
        if (isPrime(num)) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
        }
    }
}
```

### 12. Explain the difference between `for`, `while`, and `do-while` loops with examples. (Facebook, Zoho, TCS)

**Answer:**
- **for loop:** When iteration count is known
- **while loop:** When condition is checked before execution
- **do-while loop:** When at least one execution is guaranteed

```java
// for loop
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// while loop
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

// do-while loop
int j = 0;
do {
    System.out.println(j);
    j++;
} while (j < 5);
```

### 13. What is the difference between `break` and `continue` statements? (Microsoft, Infosys, HCL)

**Answer:**
- **break:** Exits the loop completely
- **continue:** Skips current iteration and moves to next

```java
for (int i = 0; i < 10; i++) {
    if (i == 3) continue; // Skip 3
    if (i == 7) break;    // Exit at 7
    System.out.println(i); // Prints: 0,1,2,4,5,6
}
```

### 14. Write a program to find the factorial of a number using recursion. (Amazon, Google, Wipro)

**Answer:**
```java
public class Factorial {
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " = " + factorial(num));
    }
}
```

### 15. Implement a program to print the Fibonacci series up to n terms. (Zoho, Facebook, Accenture)

**Answer:**
```java
public class Fibonacci {
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
    
    public static void main(String[] args) {
        printFibonacci(10);
    }
}
```

## Arrays and Strings

### 16. How do you declare and initialize an array in Java? (Microsoft, Google, Cognizant)

**Answer:**
```java
// Declaration and initialization
int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = new int[5];
int[] arr3 = new int[]{1, 2, 3, 4, 5};

// 2D array
int[][] arr2D = {{1, 2}, {3, 4}};
int[][] arr2D2 = new int[3][3];
```

### 17. Write a program to find the largest element in an array. (Amazon, Zoho, TCS)

**Answer:**
```java
public class LargestElement {
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};
        System.out.println("Largest element: " + findLargest(arr));
    }
}
```

### 18. How do you reverse a string in Java without using built-in methods? (Facebook, Google, Infosys)

**Answer:**
```java
public class ReverseString {
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
    
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Reversed: " + reverse(str));
    }
}
```

### 19. Write a program to check if a string is a palindrome. (Microsoft, Amazon, HCL)

**Answer:**
```java
public class Palindrome {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0, end = str.length() - 1;
        
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        System.out.println(str + " is palindrome: " + isPalindrome(str));
    }
}
```

### 20. How do you sort an array in Java? Explain different sorting algorithms. (Zoho, Google, Wipro)

**Answer:**
```java
import java.util.Arrays;

public class Sorting {
    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // Using built-in sort
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

## Object-Oriented Programming

### 21. What are the four pillars of OOP? Explain each with examples. (Google, Microsoft, Facebook)

**Answer:**
**1. Encapsulation:** Bundling data and methods together

```java
class BankAccount {
    private double balance;
    
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
    
    public double getBalance() {
        return balance;
    }
}
```

**2. Inheritance:** Acquiring properties from parent class

```java
class Animal {
    void eat() { System.out.println("Animal eats"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Dog barks"); }
}
```

**3. Polymorphism:** One interface, multiple implementations

```java
class Shape {
    void draw() { System.out.println("Drawing shape"); }
}

class Circle extends Shape {
    void draw() { System.out.println("Drawing circle"); }
}
```

**4. Abstraction:** Hiding implementation details

```java
abstract class Vehicle {
    abstract void start();
    void stop() { System.out.println("Vehicle stopped"); }
}

class Car extends Vehicle {
    void start() { System.out.println("Car started"); }
}
```

### 22. What is the difference between method overloading and method overriding? (Amazon, Zoho, TCS)

**Answer:**
- **Method Overloading:** Same method name, different parameters (compile-time polymorphism)
- **Method Overriding:** Same method signature in parent and child class (runtime polymorphism)

```java
// Method Overloading
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}

// Method Overriding
class Animal {
    void sound() { System.out.println("Animal makes sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}
```

### 23. What are constructors in Java? Explain default and parameterized constructors. (Microsoft, Infosys, Accenture)

**Answer:**
Constructors are special methods called when object is created.

```java
class Person {
    String name;
    int age;
    
    // Default constructor
    public Person() {
        name = "Unknown";
        age = 0;
    }
    
    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Constructor overloading
    public Person(String name) {
        this.name = name;
        this.age = 0;
    }
}
```

### 24. What is inheritance in Java? Explain single, multilevel, and hierarchical inheritance. (Facebook, Google, Cognizant)

**Answer:**
Inheritance allows a class to acquire properties from another class.

```java
// Single Inheritance
class Animal {
    void eat() { System.out.println("Eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking"); }
}

// Multilevel Inheritance
class Animal {
    void eat() { System.out.println("Eating"); }
}

class Mammal extends Animal {
    void breathe() { System.out.println("Breathing"); }
}

class Dog extends Mammal {
    void bark() { System.out.println("Barking"); }
}

// Hierarchical Inheritance
class Animal {
    void eat() { System.out.println("Eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking"); }
}

class Cat extends Animal {
    void meow() { System.out.println("Meowing"); }
}
```

### 25. What is polymorphism? Explain compile-time and runtime polymorphism. (Amazon, Zoho, HCL)

**Answer:**
Polymorphism means "one interface, multiple forms."

**Compile-time polymorphism (Method Overloading):**
```java
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

**Runtime polymorphism (Method Overriding):**
```java
class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    void sound() { System.out.println("Woof"); }
}

class Cat extends Animal {
    void sound() { System.out.println("Meow"); }
}

// Usage
Animal animal = new Dog();
animal.sound(); // Prints "Woof"
```

## Exception Handling

### 26. What is exception handling in Java? Explain try-catch-finally blocks. (Microsoft, Google, Wipro)

**Answer:**
Exception handling is a mechanism to handle runtime errors gracefully.

```java
public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // May throw exception
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
        } finally {
            System.out.println("This always executes");
        }
    }
}
```

### 27. What is the difference between checked and unchecked exceptions? (Facebook, Amazon, TCS)

**Answer:**
- **Checked exceptions:** Must be handled at compile time (IOException, SQLException)
- **Unchecked exceptions:** Runtime exceptions (NullPointerException, ArrayIndexOutOfBoundsException)

```java
// Checked exception - must handle
try {
    FileReader file = new FileReader("file.txt");
} catch (FileNotFoundException e) {
    System.out.println("File not found");
}

// Unchecked exception - optional to handle
int[] arr = new int[5];
// arr[10] = 5; // ArrayIndexOutOfBoundsException
```

### 28. Write a program to handle division by zero exception. (Zoho, Microsoft, Infosys)

**Answer:**
```java
import java.util.Scanner;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
```

### 29. What is the difference between `throw` and `throws` keywords? (Google, Facebook, Accenture)

**Answer:**
- **throw:** Used to explicitly throw an exception
- **throws:** Used to declare that a method may throw exceptions

```java
// throw example
public void validateAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or above");
    }
}

// throws example
public void readFile() throws IOException {
    FileReader file = new FileReader("file.txt");
    // File reading code
}
```

### 30. Create a custom exception class and demonstrate its usage. (Amazon, Microsoft, Cognizant)

**Answer:**
```java
// Custom exception class
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Usage
class BankAccount {
    private double balance;
    
    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", Remaining: " + balance);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        
        try {
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

## Collections Framework

### 31. What is the difference between Array and ArrayList? (Google, Zoho, HCL)

**Answer:**

| Feature | Array | ArrayList |
|---------|-------|-----------|
| Size | Fixed | Dynamic |
| Type | Can store primitives | Stores objects only |
| Performance | Faster | Slower (boxing/unboxing) |
| Memory | Less memory | More memory overhead |
| Methods | Limited | Rich API |

```java
// Array
int[] arr = new int[5];
arr[0] = 10;

// ArrayList
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.remove(0);
```

### 32. Explain the difference between ArrayList and LinkedList. (Microsoft, Amazon, Wipro)

**Answer:**

| Feature | ArrayList | LinkedList |
|---------|-----------|------------|
| Data Structure | Dynamic array | Doubly linked list |
| Access Time | O(1) | O(n) |
| Insertion/Deletion | O(n) | O(1) |
| Memory | Less | More (extra pointers) |
| Cache Performance | Better | Worse |

```java
// ArrayList - better for frequent access
ArrayList<String> arrayList = new ArrayList<>();
arrayList.add("A");
String element = arrayList.get(0); // O(1)

// LinkedList - better for frequent insertions/deletions
LinkedList<String> linkedList = new LinkedList<>();
linkedList.add("A");
linkedList.addFirst("B"); // O(1)
```

### 33. What is the difference between HashMap and HashTable? (Facebook, Google, TCS)

**Answer:**

| Feature | HashMap | HashTable |
|---------|---------|-----------|
| Synchronization | Not synchronized | Synchronized |
| Null values | Allows null | Doesn't allow null |
| Performance | Faster | Slower |
| Inheritance | Extends AbstractMap | Extends Dictionary |

```java
// HashMap
HashMap<String, Integer> hashMap = new HashMap<>();
hashMap.put("key", 1);
hashMap.put(null, 2); // Allowed

// HashTable
Hashtable<String, Integer> hashTable = new Hashtable<>();
hashTable.put("key", 1);
// hashTable.put(null, 2); // Not allowed
```

### 34. Write a program to remove duplicates from an ArrayList. (Zoho, Microsoft, Infosys)

**Answer:**
```java
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(1);
        
        System.out.println("Original: " + list);
        
        // Method 1: Using LinkedHashSet
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        ArrayList<Integer> result1 = new ArrayList<>(set);
        System.out.println("Method 1: " + result1);
        
        // Method 2: Using loop
        ArrayList<Integer> result2 = new ArrayList<>();
        for (Integer item : list) {
            if (!result2.contains(item)) {
                result2.add(item);
            }
        }
        System.out.println("Method 2: " + result2);
        
        // Method 3: Using Java 8 streams
        ArrayList<Integer> result3 = list.stream()
            .distinct()
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Method 3: " + result3);
    }
}
```

### 35. How do you iterate through a HashMap? (Amazon, Facebook, Accenture)

**Answer:**
```java
import java.util.*;

public class HashMapIteration {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        
        // Method 1: Using entrySet()
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        // Method 2: Using keySet()
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        
        // Method 3: Using values()
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }
        
        // Method 4: Using Java 8 forEach
        map.forEach((key, value) -> System.out.println(key + " = " + value));
        
        // Method 5: Using Iterator
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

## Input/Output and File Handling

### 36. How do you read input from the console in Java? (Microsoft, Google, Cognizant)

**Answer:**
```java
import java.util.Scanner;
import java.io.*;

public class ConsoleInput {
    public static void main(String[] args) throws IOException {
        // Method 1: Using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        // Method 2: Using BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter city: ");
        String city = reader.readLine();
        
        // Method 3: Using Console class
        Console console = System.console();
        if (console != null) {
            String username = console.readLine("Username: ");
            char[] password = console.readPassword("Password: ");
        }
        
        scanner.close();
        reader.close();
    }
}
```

### 37. Write a program to read and write data to a file. (Zoho, Amazon, HCL)

**Answer:**
```java
import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        // Writing to file
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Hello, World!\n");
            writer.write("This is a test file.\n");
            System.out.println("Data written to file successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Reading from file
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            System.out.println("Reading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        
        // Using try-with-resources for automatic resource management
        try (PrintWriter writer = new PrintWriter("data.txt");
             Scanner scanner = new Scanner(new File("data.txt"))) {
            
            writer.println("Line 1");
            writer.println("Line 2");
            writer.close(); // Close writer before reading
            
            Scanner fileScanner = new Scanner(new File("data.txt"));
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### 38. What is the difference between FileInputStream and FileReader? (Facebook, Microsoft, Wipro)

**Answer:**

| Feature | FileInputStream | FileReader |
|---------|-----------------|------------|
| Data Type | Byte stream | Character stream |
| Usage | Binary data | Text data |
| Encoding | No encoding | Uses default encoding |
| Buffer Size | 1 byte | 1 character |

```java
// FileInputStream - for binary data
try (FileInputStream fis = new FileInputStream("image.jpg")) {
    int data;
    while ((data = fis.read()) != -1) {
        // Process byte data
    }
} catch (IOException e) {
    e.printStackTrace();
}

// FileReader - for text data
try (FileReader fr = new FileReader("text.txt")) {
    int data;
    while ((data = fr.read()) != -1) {
        System.out.print((char) data);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### 39. How do you handle file not found exception? (Google, Zoho, TCS)

**Answer:**
```java
import java.io.*;

public class FileNotFoundHandling {
    public static void main(String[] args) {
        String filename = "nonexistent.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            System.out.println("Please check if the file exists and try again.");
            
            // Create the file if it doesn't exist
            try (PrintWriter writer = new PrintWriter(filename)) {
                writer.println("This is a new file created because the original was not found.");
                System.out.println("New file created: " + filename);
            } catch (IOException createException) {
                System.out.println("Error creating file: " + createException.getMessage());
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

### 40. Write a program to count the number of words in a text file. (Amazon, Microsoft, Infosys)

**Answer:**
```java
import java.io.*;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        String filename = "sample.txt";
        
        // Create sample file for testing
        createSampleFile(filename);
        
        // Method 1: Using Scanner
        countWordsWithScanner(filename);
        
        // Method 2: Using BufferedReader
        countWordsWithBufferedReader(filename);
        
        // Method 3: Using split method
        countWordsWithSplit(filename);
    }
    
    public static void createSampleFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("This is a sample text file.");
            writer.println("It contains multiple lines with words.");
            writer.println("We will count the total number of words.");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
    
    public static void countWordsWithScanner(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int wordCount = 0;
            
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            
            System.out.println("Word count (Scanner method): " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    
    public static void countWordsWithBufferedReader(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int wordCount = 0;
            
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
            
            System.out.println("Word count (BufferedReader method): " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void countWordsWithSplit(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder content = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
            
            String[] words = content.toString().trim().split("\\s+");
            int wordCount = content.toString().trim().isEmpty() ? 0 : words.length;
            
            System.out.println("Word count (Split method): " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

## Basic Algorithms and Logic

### 41. Write a program to implement bubble sort algorithm. (Google, Facebook, Accenture)

**Answer:**
```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
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
    
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
```

### 42. Implement binary search algorithm in Java. (Microsoft, Amazon, Cognizant)

**Answer:**
```java
public class BinarySearch {
    // Iterative approach
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Element not found
    }
    
    // Recursive approach
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Element not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 50, 60};
        int target = 10;
        
        System.out.println("Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        int result1 = binarySearchIterative(arr, target);
        System.out.println("Iterative: Element " + target + " found at index " + result1);
        
        int result2 = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("Recursive: Element " + target + " found at index " + result2);
    }
}
```

### 43. Write a program to find the second largest number in an array. (Zoho, Google, HCL)

**Answer:**
```java
public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }
        
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found");
        }
        
        return secondLargest;
    }
    
    // Alternative method using sorting
    public static int findSecondLargestBySorting(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        
        java.util.Arrays.sort(arr);
        
        // Find second largest (skip duplicates)
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) {
                return arr[i];
            }
        }
        
        throw new IllegalArgumentException("No second largest element found");
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        
        System.out.println("Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        try {
            int secondLargest = findSecondLargest(arr);
            System.out.println("Second largest element: " + secondLargest);
            
            int secondLargestSorted = findSecondLargestBySorting(arr.clone());
            System.out.println("Second largest (sorting method): " + secondLargestSorted);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### 44. How do you find duplicate elements in an array? (Facebook, Microsoft, Wipro)

**Answer:**
```java
import java.util.*;

public class FindDuplicates {
    // Method 1: Using HashSet
    public static void findDuplicatesUsingHashSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        
        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        
        System.out.println("Duplicates (HashSet): " + duplicates);
    }
    
    // Method 2: Using HashMap to count occurrences
    public static void findDuplicatesUsingHashMap(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        System.out.print("Duplicates (HashMap): ");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
    
    // Method 3: Using nested loops (brute force)
    public static void findDuplicatesUsingNestedLoops(int[] arr) {
        System.out.print("Duplicates (Nested loops): ");
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    break; // Avoid printing same duplicate multiple times
                }
            }
        }
        System.out.println();
    }
    
    // Method 4: Using sorting
    public static void findDuplicatesUsingSorting(int[] arr) {
        Arrays.sort(arr);
        System.out.print("Duplicates (Sorting): ");
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.print(arr[i] + " ");
                // Skip all occurrences of the same element
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 6, 3, 7, 8, 1};
        
        System.out.println("Array: " + Arrays.toString(arr));
        
        findDuplicatesUsingHashSet(arr);
        findDuplicatesUsingHashMap(arr);
        findDuplicatesUsingNestedLoops(arr);
        findDuplicatesUsingSorting(arr.clone()); // Use clone to avoid modifying original
    }
}
```

### 45. Write a program to check if two strings are anagrams. (Amazon, Zoho, TCS)

**Answer:**
```java
import java.util.*;

public class AnagramChecker {
    // Method 1: Using sorting
    public static boolean isAnagramUsingSorting(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] chars1 = str1.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
    // Method 2: Using character count
    public static boolean isAnagramUsingCharCount(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        int[] charCount = new int[26]; // For lowercase letters
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }
        
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // Method 3: Using HashMap
    public static boolean isAnagramUsingHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        Map<Character, Integer> charMap = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // Count characters in first string
        for (char c : str1.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        
        // Decrement count for characters in second string
        for (char c : str2.toCharArray()) {
            if (!charMap.containsKey(c)) {
                return false;
            }
            charMap.put(c, charMap.get(c) - 1);
            if (charMap.get(c) == 0) {
                charMap.remove(c);
            }
        }
        
        return charMap.isEmpty();
    }
    
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        
        System.out.println("Are anagrams (sorting): " + isAnagramUsingSorting(str1, str2));
        System.out.println("Are anagrams (char count): " + isAnagramUsingCharCount(str1, str2));
        System.out.println("Are anagrams (HashMap): " + isAnagramUsingHashMap(str1, str2));
        
        // Test with non-anagrams
        String str3 = "hello";
        String str4 = "world";
        
        System.out.println("\nString 3: " + str3);
        System.out.println("String 4: " + str4);
        System.out.println("Are anagrams: " + isAnagramUsingSorting(str3, str4));
    }
}
```

## Multithreading Basics

### 46. What is multithreading in Java? How do you create a thread? (Google, Microsoft, Infosys)

**Answer:**
Multithreading allows concurrent execution of multiple threads within a program.

**Ways to create threads:**

```java
// Method 1: Extending Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Method 2: Implementing Runnable interface
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable: " + Thread.currentThread().getName() + ", Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        // Creating thread by extending Thread class
        MyThread thread1 = new MyThread();
        thread1.start();
        
        // Creating thread by implementing Runnable interface
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
        
        // Using lambda expression (Java 8+)
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda Thread: " + Thread.currentThread().getName() + ", Count: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();
    }
}
```

### 47. What is the difference between extending Thread class and implementing Runnable interface? (Facebook, Amazon, Accenture)

**Answer:**

| Feature | Extending Thread | Implementing Runnable |
|---------|------------------|----------------------|
| Inheritance | Single inheritance used | Can extend other classes |
| Reusability | Less reusable | More reusable |
| Coupling | Tightly coupled | Loosely coupled |
| Thread pool | Cannot be used | Can be used |
| Best Practice | Not recommended | Recommended |

```java
// Extending Thread - limits inheritance
class MyThread extends Thread {
    // Cannot extend any other class
    @Override
    public void run() {
        System.out.println("Thread running");
    }
}

// Implementing Runnable - flexible
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task running");
    }
}

class MyClass extends SomeOtherClass implements Runnable {
    // Can extend other classes and implement Runnable
    @Override
    public void run() {
        System.out.println("MyClass task running");
    }
}
```

### 48. What are thread states in Java? (Zoho, Microsoft, Cognizant)

**Answer:**
Java thread can be in one of these states:

1. **NEW:** Thread created but not started
2. **RUNNABLE:** Thread executing or ready to execute
3. **BLOCKED:** Thread blocked waiting for monitor lock
4. **WAITING:** Thread waiting indefinitely for another thread
5. **TIMED_WAITING:** Thread waiting for specified time
6. **TERMINATED:** Thread completed execution

```java
public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000); // TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        System.out.println("Before start: " + thread.getState()); // NEW
        
        thread.start();
        System.out.println("After start: " + thread.getState()); // RUNNABLE
        
        Thread.sleep(100);
        System.out.println("While sleeping: " + thread.getState()); // TIMED_WAITING
        
        thread.join();
        System.out.println("After completion: " + thread.getState()); // TERMINATED
    }
}
```

### 49. Write a simple program demonstrating thread creation and execution. (Google, Facebook, HCL)

**Answer:**
```java
public class ThreadDemo {
    public static void main(String[] args) {
        // Create multiple threads
        Thread t1 = new Thread(new NumberPrinter("Thread-1", 1, 5));
        Thread t2 = new Thread(new NumberPrinter("Thread-2", 10, 15));
        Thread t3 = new Thread(new NumberPrinter("Thread-3", 20, 25));
        
        System.out.println("Starting threads...");
        
        // Start threads
        t1.start();
        t2.start();
        t3.start();
        
        try {
            // Wait for all threads to complete
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All threads completed.");
    }
}

class NumberPrinter implements Runnable {
    private String threadName;
    private int start;
    private int end;
    
    public NumberPrinter(String threadName, int start, int end) {
        this.threadName = threadName;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void run() {
        System.out.println(threadName + " started");
        
        for (int i = start; i <= end; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(500); // Simulate some work
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted");
                return;
            }
        }
        
        System.out.println(threadName + " finished");
    }
}
```

### 50. What is synchronization in Java? Why is it needed? (Amazon, Microsoft, Wipro)

**Answer:**
Synchronization ensures that only one thread can access a shared resource at a time, preventing data corruption.

**Why needed:**
- Prevents race conditions
- Ensures data consistency
- Maintains thread safety

```java
// Without synchronization - race condition
class Counter {
    private int count = 0;
    
    public void increment() {
        count++; // Not thread-safe
    }
    
    public int getCount() {
        return count;
    }
}

// With synchronization - thread-safe
class SynchronizedCounter {
    private int count = 0;
    
    public synchronized void increment() {
        count++; // Thread-safe
    }
    
    public synchronized int getCount() {
        return count;
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        SynchronizedCounter syncCounter = new SynchronizedCounter();
        
        // Create multiple threads that increment counter
        Thread[] threads = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                    syncCounter.increment();
                }
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("Without synchronization: " + counter.getCount());
        System.out.println("With synchronization: " + syncCounter.getCount());
    }
}
```

---

## Programming Exercises Solutions

### Easy Level Solutions:

**1. Swap two numbers without using a third variable:**
```java
public class SwapNumbers {
    public static void main(String[] args) {
        int a = 10, b = 20;
        
        System.out.println("Before swap: a = " + a + ", b = " + b);
        
        // Method 1: Using arithmetic operators
        a = a + b;
        b = a - b;
        a = a - b;
        
        System.out.println("After swap: a = " + a + ", b = " + b);
        
        // Method 2: Using XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        System.out.println("After XOR swap: a = " + a + ", b = " + b);
    }
}
```

**2. Check if a year is a leap year:**
```java
public class LeapYear {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static void main(String[] args) {
        int year = 2024;
        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}
```

**3. Count vowels and consonants in a string:**
```java
public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    public static void main(String[] args) {
        String str = "Hello World";
        countVowelsAndConsonants(str);
    }
}
```

**4. Find sum of digits of a number:**
```java
public class SumOfDigits {
    public static int sumOfDigits(int number) {
        int sum = 0;
        number = Math.abs(number); // Handle negative numbers
        
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Sum of digits of " + number + " = " + sumOfDigits(number));
    }
}
```

**5. Simple calculator program:**
```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        boolean validOperation = true;
        
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operator");
                validOperation = false;
        }
        
        if (validOperation) {
            System.out.println("Result: " + result);
        }
        
        scanner.close();
    }
}
```

---

This comprehensive answer document covers all 50 questions with detailed explanations, code examples, and practical implementations. Each answer includes the reasoning behind the solution and demonstrates best practices in Java programming.
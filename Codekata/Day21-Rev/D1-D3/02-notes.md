# Java Loops & Object-Oriented Programming - Day 2 Notes

## Table of Contents
1. [Loops in Java](#loops-in-java)
2. [Scenario Based Problem Solving on Loops](#scenario-based-problem-solving-on-loops)
3. [Problem Solving on Nested Loops](#problem-solving-on-nested-loops)
4. [Advanced Problems on Loops](#advanced-problems-on-loops)
5. [Introduction to OOP in Java](#introduction-to-oop-in-java)
6. [Creating Classes and Objects](#creating-classes-and-objects)
7. [Constructors in Java](#constructors-in-java)
8. [this, super Keywords](#this-super-keywords)
9. [Instance Initialized Block](#instance-initialized-block)
10. [Local vs Instance Variables](#local-vs-instance-variables)

---

## Loops in Java

Loops allow you to execute a block of code repeatedly until a specific condition is met.

### 1. for Loop
Best used when you know the exact number of iterations.

```java
for (initialization; condition; increment/decrement) {
    // code to be executed
}
```

**Example:**
```java
public class ForLoopExample {
    public static void main(String[] args) {
        // Print numbers 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
        
        // Print even numbers from 2 to 10
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even: " + i);
        }
    }
}
```

### 2. while Loop
Best used when the number of iterations is unknown and depends on a condition.

```java
while (condition) {
    // code to be executed
}
```

**Example:**
```java
public class WhileLoopExample {
    public static void main(String[] args) {
        int count = 1;
        
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
        
        // Reading input until user enters 0
        Scanner scanner = new Scanner(System.in);
        int number;
        while ((number = scanner.nextInt()) != 0) {
            System.out.println("You entered: " + number);
        }
    }
}
```

### 3. do-while Loop
Executes the code block at least once, then checks the condition.

```java
do {
    // code to be executed
} while (condition);
```

**Example:**
```java
public class DoWhileExample {
    public static void main(String[] args) {
        int i = 1;
        
        do {
            System.out.println("Value: " + i);
            i++;
        } while (i <= 5);
        
        // Menu-driven program
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Addition selected");
                    break;
                case 2:
                    System.out.println("Subtraction selected");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);
    }
}
```

### 4. Enhanced for Loop (for-each)
Used to iterate through arrays and collections.

```java
for (dataType variable : array/collection) {
    // code to be executed
}
```

**Example:**
```java
public class EnhancedForLoop {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Traditional for loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Traditional: " + numbers[i]);
        }
        
        // Enhanced for loop
        for (int number : numbers) {
            System.out.println("Enhanced: " + number);
        }
        
        String[] names = {"Alice", "Bob", "Charlie"};
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
}
```

---

## Scenario Based Problem Solving on Loops

### Problem 1: Sum and Average Calculator
```java
import java.util.Scanner;

public class SumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        int number;
        
        System.out.println("Enter numbers (enter 0 to stop):");
        while ((number = scanner.nextInt()) != 0) {
            sum += number;
            count++;
        }
        
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        } else {
            System.out.println("No numbers entered");
        }
    }
}
```

### Problem 2: Factorial Calculator
```java
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}
```

### Problem 3: Prime Number Checker
```java
import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        boolean isPrime = true;
        
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        if (isPrime) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
}
```

### Problem 4: Fibonacci Series
```java
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = scanner.nextInt();
        
        int first = 0, second = 1;
        
        if (n >= 1) {
            System.out.print("Fibonacci Series: " + first);
        }
        if (n >= 2) {
            System.out.print(", " + second);
        }
        
        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }
}
```

### Problem 5: Palindrome Checker
```java
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        
        if (original == reversed) {
            System.out.println(original + " is a palindrome");
        } else {
            System.out.println(original + " is not a palindrome");
        }
    }
}
```

---

## Problem Solving on Nested Loops

### Problem 1: Star Patterns

#### Right Triangle Pattern
```java
public class StarPatterns {
    public static void main(String[] args) {
        int n = 5;
        
        // Right triangle
        System.out.println("Right Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

#### Pyramid Pattern
```java
public class PyramidPattern {
    public static void main(String[] args) {
        int n = 5;
        
        System.out.println("Pyramid:");
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

#### Diamond Pattern
```java
public class DiamondPattern {
    public static void main(String[] args) {
        int n = 5;
        
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

### Problem 2: Number Patterns

#### Number Triangle
```java
public class NumberPatterns {
    public static void main(String[] args) {
        int n = 5;
        
        // Number triangle
        System.out.println("Number Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
        // Floyd's triangle
        System.out.println("\nFloyd's Triangle:");
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
```

### Problem 3: Matrix Operations
```java
public class MatrixOperations {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int rows = 3, cols = 3;
        
        // Matrix addition
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        // Display result
        System.out.println("Sum of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## Advanced Problems on Loops

### Problem 1: Prime Numbers in Range
```java
public class PrimeRange {
    public static void main(String[] args) {
        int start = 10, end = 50;
        
        System.out.println("Prime numbers between " + start + " and " + end + ":");
        for (int num = start; num <= end; num++) {
            boolean isPrime = true;
            
            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
```

### Problem 2: Armstrong Numbers
```java
public class ArmstrongNumbers {
    public static void main(String[] args) {
        System.out.println("Armstrong numbers between 1 and 1000:");
        
        for (int num = 1; num <= 1000; num++) {
            int original = num;
            int sum = 0;
            int digits = String.valueOf(num).length();
            
            while (original > 0) {
                int digit = original % 10;
                sum += Math.pow(digit, digits);
                original /= 10;
            }
            
            if (sum == num) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
```

### Problem 3: Perfect Numbers
```java
public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println("Perfect numbers up to 10000:");
        
        for (int num = 1; num <= 10000; num++) {
            int sum = 0;
            
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            
            if (sum == num) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
```

### Problem 4: Magic Square Generator
```java
public class MagicSquare {
    public static void main(String[] args) {
        int n = 3; // Odd number only
        int[][] magicSquare = new int[n][n];
        
        // Initialize position for 1
        int i = n / 2;
        int j = n - 1;
        
        for (int num = 1; num <= n * n; ) {
            if (i == -1 && j == n) {
                j = n - 2;
                i = 0;
            } else {
                if (j == n) j = 0;
                if (i < 0) i = n - 1;
            }
            
            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            } else {
                magicSquare[i][j] = num++;
            }
            
            j++;
            i--;
        }
        
        // Display magic square
        System.out.println("Magic Square:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## Introduction to OOP in Java

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects" which contain data (attributes) and code (methods).

### Four Pillars of OOP:

1. **Encapsulation**: Bundling data and methods that work on that data within one unit
2. **Inheritance**: Mechanism where one class acquires properties of another class
3. **Polymorphism**: Ability of objects to take on multiple forms
4. **Abstraction**: Hiding complex implementation details and showing only essential features

### Benefits of OOP:
- **Modularity**: Code is organized into separate, interchangeable components
- **Reusability**: Code can be reused through inheritance and composition
- **Maintainability**: Easier to modify and maintain code
- **Scalability**: Easy to add new features without affecting existing code

---

## Creating Classes and Objects

### Class Definition
A class is a blueprint or template for creating objects.

```java
// Class definition
public class Student {
    // Instance variables (attributes)
    private String name;
    private int age;
    private String studentId;
    private double gpa;
    
    // Methods (behavior)
    public void study() {
        System.out.println(name + " is studying");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("GPA: " + gpa);
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
```

### Object Creation and Usage
```java
public class StudentDemo {
    public static void main(String[] args) {
        // Creating objects
        Student student1 = new Student();
        Student student2 = new Student();
        
        // Setting values using setter methods
        student1.setName("Alice");
        student1.setAge(20);
        
        student2.setName("Bob");
        student2.setAge(22);
        
        // Calling methods
        student1.displayInfo();
        student1.study();
        
        System.out.println();
        
        student2.displayInfo();
        student2.study();
    }
}
```

### More Complex Class Example
```java
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static int totalAccounts = 0; // Static variable
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        totalAccounts++;
    }
    
    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }
    
    // Method to check balance
    public double getBalance() {
        return balance;
    }
    
    // Static method
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}
```

---

## Constructors in Java

Constructors are special methods used to initialize objects when they are created.

### Types of Constructors:

#### 1. Default Constructor
```java
public class Car {
    private String brand;
    private String model;
    private int year;
    
    // Default constructor
    public Car() {
        brand = "Unknown";
        model = "Unknown";
        year = 2024;
        System.out.println("Default constructor called");
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}
```

#### 2. Parameterized Constructor
```java
public class Car {
    private String brand;
    private String model;
    private int year;
    
    // Parameterized constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        System.out.println("Parameterized constructor called");
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}
```

#### 3. Constructor Overloading
```java
public class Rectangle {
    private double length;
    private double width;
    
    // Default constructor
    public Rectangle() {
        length = 1.0;
        width = 1.0;
    }
    
    // Constructor with one parameter (square)
    public Rectangle(double side) {
        length = side;
        width = side;
    }
    
    // Constructor with two parameters
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    // Copy constructor
    public Rectangle(Rectangle other) {
        this.length = other.length;
        this.width = other.width;
    }
    
    public double getArea() {
        return length * width;
    }
    
    public void displayInfo() {
        System.out.println("Length: " + length + ", Width: " + width + ", Area: " + getArea());
    }
}

// Usage
public class ConstructorDemo {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();           // Default
        Rectangle rect2 = new Rectangle(5.0);       // Square
        Rectangle rect3 = new Rectangle(4.0, 6.0);  // Rectangle
        Rectangle rect4 = new Rectangle(rect3);     // Copy
        
        rect1.displayInfo();
        rect2.displayInfo();
        rect3.displayInfo();
        rect4.displayInfo();
    }
}
```

---

## this, super Keywords

### The `this` Keyword
The `this` keyword refers to the current object instance.

#### Uses of `this`:

1. **Differentiate between instance and parameter variables**
```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;  // this.name refers to instance variable
        this.age = age;    // this.age refers to instance variable
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
```

2. **Call other constructors in the same class**
```java
public class Employee {
    private String name;
    private int id;
    private double salary;
    
    public Employee() {
        this("Unknown", 0, 0.0);  // Call parameterized constructor
    }
    
    public Employee(String name) {
        this(name, 0, 0.0);
    }
    
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}
```

3. **Return current object**
```java
public class Builder {
    private String value;
    
    public Builder setValue(String value) {
        this.value = value;
        return this;  // Method chaining
    }
    
    public Builder append(String text) {
        this.value += text;
        return this;
    }
}

// Usage: builder.setValue("Hello").append(" World");
```

### The `super` Keyword
The `super` keyword refers to the immediate parent class object.

#### Uses of `super`:

1. **Access parent class variables**
```java
class Animal {
    protected String name = "Animal";
}

class Dog extends Animal {
    private String name = "Dog";
    
    public void printNames() {
        System.out.println("Child class: " + this.name);
        System.out.println("Parent class: " + super.name);
    }
}
```

2. **Call parent class methods**
```java
class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        super.start();  // Call parent method
        System.out.println("Car is starting with key");
    }
}
```

3. **Call parent class constructor**
```java
class Animal {
    protected String species;
    
    public Animal(String species) {
        this.species = species;
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    private String breed;
    
    public Dog(String species, String breed) {
        super(species);  // Must be first statement
        this.breed = breed;
        System.out.println("Dog constructor called");
    }
}
```

---

## Instance Initialized Block

Instance initialization blocks are used to initialize instance variables and run code before any constructor is called.

```java
public class InitializationExample {
    private int value;
    private String message;
    
    // Instance initialization block
    {
        System.out.println("Instance initialization block executed");
        value = 100;
        message = "Initialized";
    }
    
    // Static initialization block
    static {
        System.out.println("Static initialization block executed");
    }
    
    public InitializationExample() {
        System.out.println("Constructor executed");
        System.out.println("Value: " + value + ", Message: " + message);
    }
    
    public InitializationExample(int value) {
        this.value = value;
        System.out.println("Parameterized constructor executed");
        System.out.println("Value: " + value + ", Message: " + message);
    }
}
```

### Order of Execution:
1. Static initialization block (only once when class is first loaded)
2. Instance initialization block
3. Constructor

### Multiple Instance Blocks:
```java
public class MultipleBlocks {
    private int a;
    private int b;
    
    // First instance block
    {
        a = 10;
        System.out.println("First instance block: a = " + a);
    }
    
    // Second instance block
    {
        b = 20;
        System.out.println("Second instance block: b = " + b);
    }
    
    public MultipleBlocks() {
        System.out.println("Constructor: a = " + a + ", b = " + b);
    }
}
```

---

## Local vs Instance Variables

### Instance Variables
- Declared inside a class but outside any method
- Belong to an instance of the class
- Have default values
- Accessible throughout the class
- Memory allocated when object is created

```java
public class VariableExample {
    // Instance variables
    private int instanceInt;        // Default: 0
    private String instanceString;  // Default: null
    private boolean instanceBool;   // Default: false
    
    public void method1() {
        // Local variables
        int localInt;               // No default value
        String localString;         // No default value
        
        // Must initialize before use
        localInt = 10;
        localString = "Hello";
        
        System.out.println("Instance int: " + instanceInt);
        System.out.println("Local int: " + localInt);
    }
}
```

### Comparison Table:

| Aspect | Instance Variables | Local Variables |
|--------|-------------------|-----------------|
| **Scope** | Throughout the class | Within the method/block |
| **Default Values** | Yes (0, null, false) | No default values |
| **Memory** | Heap memory | Stack memory |
| **Lifetime** | Until object exists | Until method/block ends |
| **Access Modifiers** | Can have access modifiers | Cannot have access modifiers |
| **Initialization** | Optional (has defaults) | Must initialize before use |

### Detailed Example:
```java
public class Student {
    // Instance variables
    private static int totalStudents = 0;  // Static variable
    private String name;                   // Instance variable
    private int rollNumber;                // Instance variable
    private double[] grades;               // Instance variable
    
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new double[5];
        totalStudents++;
    }
    
    public void calculateAverage() {
        double sum = 0;        // Local variable
        int count = 0;         // Local variable
        
        for (int i = 0; i < grades.length; i++) {  // i is local
            sum += grades[i];
            count++;
        }
        
        double average = sum / count;  // Local variable
        System.out.println("Average grade: " + average);
        
        // Local variables sum, count, average, i are destroyed when method ends
    }
    
    public void displayInfo() {
        String info;  // Local variable - must initialize before use
        info = "Student: " + name + ", Roll: " + rollNumber;
        System.out.println(info);
    }
    
    // Static method can only access static variables
    public static int getTotalStudents() {
        return totalStudents;
        // Cannot access name, rollNumber here - they are instance variables
    }
}
```

### Variable Shadowing:
```java
public class ShadowingExample {
    private int x = 10;  // Instance variable
    
    public void method(int x) {  // Parameter shadows instance variable
        int y = 20;  // Local variable
        
        System.out.println("Parameter x: " + x);           // Parameter
        System.out.println("Instance x: " + this.x);       // Instance variable
        System.out.println("Local y: " + y);               // Local variable
        
        {
            int z = 30;  // Block-level local variable
            System.out.println("Block z: " + z);
        }
        // z is not accessible here
    }
}
```

---

## Best Practices

### 1. Constructor Best Practices
- Always initialize all instance variables
- Use `this()` to call other constructors (constructor chaining)
- Keep constructors simple and focused on initialization
- Validate parameters in constructors

### 2. Instance Variables Best Practices
- Make instance variables `private` (encapsulation)
- Provide public getter and setter methods when needed
- Initialize variables with meaningful default values
- Use meaningful names for variables

### 3. Method Best Practices
- Keep methods small and focused on one task
- Use descriptive method names
- Validate input parameters
- Handle edge cases appropriately

### 4. General OOP Best Practices
- Follow naming conventions (camelCase for variables and methods)
- Use access modifiers appropriately
- Document your code with comments
- Write unit tests for your classes

---

## Summary

This comprehensive guide covers:

1. **Loops**: for, while, do-while, and enhanced for loops with practical examples
2. **Problem Solving**: Scenario-based problems, nested loops, and advanced loop problems
3. **OOP Introduction**: Four pillars of OOP and benefits
4. **Classes and Objects**: How to create and use classes and objects
5. **Constructors**: Default, parameterized, and constructor overloading
6. **Keywords**: `this` and `super` keywords with their various uses
7. **Initialization**: Instance initialization blocks and their execution order
8. **Variables**: Differences between local and instance variables

These concepts form the foundation for advanced Java programming and object-oriented design patterns.
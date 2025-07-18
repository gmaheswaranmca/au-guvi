# Java Basic Fundamentals - Day 1 Notes

## Table of Contents
1. [Introduction to Programming Basics](#introduction-to-programming-basics)
2. [Java Primitive Types](#java-primitive-types)
3. [Operators](#operators)
4. [Switch-Case Statement](#switch-case-statement)
5. [Conditional Programming](#conditional-programming)

---

## Introduction to Programming Basics

### What is Programming?
Programming is the process of creating a set of instructions that tell a computer how to perform a task. It involves:
- **Problem Solving**: Breaking down complex problems into smaller, manageable parts
- **Logic Building**: Creating step-by-step solutions
- **Implementation**: Writing code using a programming language

### What is Java?
- **Object-Oriented Programming Language**: Everything in Java is an object
- **Platform Independent**: "Write Once, Run Anywhere" (WORA)
- **Compiled and Interpreted**: Java code is compiled to bytecode, then interpreted by JVM
- **Strongly Typed**: Variable types must be declared explicitly

### Basic Structure of a Java Program
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Key Components:
- **Class**: Blueprint for objects (`public class HelloWorld`)
- **Method**: Block of code that performs a specific task (`main` method)
- **Statement**: Individual instruction (`System.out.println()`)

---

## Java Primitive Types

Java has 8 primitive data types that are built into the language:

### Numeric Types

#### Integer Types
1. **byte**
   - Size: 8 bits (1 byte)
   - Range: -128 to 127
   - Example: `byte age = 25;`

2. **short**
   - Size: 16 bits (2 bytes)
   - Range: -32,768 to 32,767
   - Example: `short year = 2024;`

3. **int**
   - Size: 32 bits (4 bytes)
   - Range: -2,147,483,648 to 2,147,483,647
   - Example: `int population = 1000000;`

4. **long**
   - Size: 64 bits (8 bytes)
   - Range: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
   - Example: `long distance = 1234567890L;` (Note the 'L' suffix)

#### Floating-Point Types
5. **float**
   - Size: 32 bits (4 bytes)
   - Precision: ~7 decimal digits
   - Example: `float price = 99.99f;` (Note the 'f' suffix)

6. **double**
   - Size: 64 bits (8 bytes)
   - Precision: ~15 decimal digits
   - Example: `double pi = 3.14159265359;`

### Non-Numeric Types
7. **char**
   - Size: 16 bits (2 bytes)
   - Stores single Unicode character
   - Example: `char grade = 'A';`

8. **boolean**
   - Size: 1 bit (conceptually)
   - Values: `true` or `false`
   - Example: `boolean isActive = true;`

### Variable Declaration Examples
```java
public class DataTypes {
    public static void main(String[] args) {
        // Integer types
        byte myByte = 100;
        short myShort = 5000;
        int myInt = 100000;
        long myLong = 15000000000L;
        
        // Floating-point types
        float myFloat = 5.75f;
        double myDouble = 19.99d;
        
        // Other types
        char myChar = 'D';
        boolean myBoolean = true;
        
        System.out.println("Byte: " + myByte);
        System.out.println("Short: " + myShort);
        System.out.println("Int: " + myInt);
        System.out.println("Long: " + myLong);
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        System.out.println("Char: " + myChar);
        System.out.println("Boolean: " + myBoolean);
    }
}
```

---

## Operators

Operators are special symbols that perform operations on variables and values.

### 1. Arithmetic Operators
| Operator | Description | Example |
|----------|-------------|---------|
| `+` | Addition | `a + b` |
| `-` | Subtraction | `a - b` |
| `*` | Multiplication | `a * b` |
| `/` | Division | `a / b` |
| `%` | Modulus (remainder) | `a % b` |
| `++` | Increment | `a++` or `++a` |
| `--` | Decrement | `a--` or `--a` |

```java
int a = 10, b = 3;
System.out.println("a + b = " + (a + b)); // 13
System.out.println("a - b = " + (a - b)); // 7
System.out.println("a * b = " + (a * b)); // 30
System.out.println("a / b = " + (a / b)); // 3 (integer division)
System.out.println("a % b = " + (a % b)); // 1
```

### 2. Assignment Operators
| Operator | Description | Example | Equivalent |
|----------|-------------|---------|------------|
| `=` | Simple assignment | `a = 5` | `a = 5` |
| `+=` | Add and assign | `a += 3` | `a = a + 3` |
| `-=` | Subtract and assign | `a -= 3` | `a = a - 3` |
| `*=` | Multiply and assign | `a *= 3` | `a = a * 3` |
| `/=` | Divide and assign | `a /= 3` | `a = a / 3` |
| `%=` | Modulus and assign | `a %= 3` | `a = a % 3` |

### 3. Comparison Operators
| Operator | Description | Example |
|----------|-------------|---------|
| `==` | Equal to | `a == b` |
| `!=` | Not equal to | `a != b` |
| `>` | Greater than | `a > b` |
| `<` | Less than | `a < b` |
| `>=` | Greater than or equal | `a >= b` |
| `<=` | Less than or equal | `a <= b` |

### 4. Logical Operators
| Operator | Description | Example |
|----------|-------------|---------|
| `&&` | Logical AND | `(a > 5) && (b < 10)` |
| `\|\|` | Logical OR | `(a > 5) \|\| (b < 10)` |
| `!` | Logical NOT | `!(a > 5)` |

```java
boolean result1 = (5 > 3) && (8 > 6); // true
boolean result2 = (5 > 8) || (3 > 1); // true
boolean result3 = !(5 > 3); // false
```

### 5. Bitwise Operators
| Operator | Description | Example |
|----------|-------------|---------|
| `&` | Bitwise AND | `a & b` |
| `\|` | Bitwise OR | `a \| b` |
| `^` | Bitwise XOR | `a ^ b` |
| `~` | Bitwise NOT | `~a` |
| `<<` | Left shift | `a << 2` |
| `>>` | Right shift | `a >> 2` |

---

## Switch-Case Statement

The switch statement allows you to test a variable against many values efficiently.

### Syntax
```java
switch (expression) {
    case value1:
        // code block
        break;
    case value2:
        // code block
        break;
    // more cases...
    default:
        // default code block
}
```

### Examples

#### Example 1: Days of the Week
```java
public class SwitchExample {
    public static void main(String[] args) {
        int day = 3;
        String dayName;
        
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }
        
        System.out.println("Day " + day + " is " + dayName);
    }
}
```

#### Example 2: Grade Calculator
```java
public class GradeCalculator {
    public static void main(String[] args) {
        char grade = 'B';
        
        switch (grade) {
            case 'A':
                System.out.println("Excellent! (90-100%)");
                break;
            case 'B':
                System.out.println("Good! (80-89%)");
                break;
            case 'C':
                System.out.println("Average (70-79%)");
                break;
            case 'D':
                System.out.println("Below Average (60-69%)");
                break;
            case 'F':
                System.out.println("Fail (Below 60%)");
                break;
            default:
                System.out.println("Invalid grade");
        }
    }
}
```

#### Example 3: Fall-through Cases
```java
public class SeasonExample {
    public static void main(String[] args) {
        int month = 12;
        String season;
        
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                season = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                season = "Autumn";
                break;
            default:
                season = "Invalid month";
        }
        
        System.out.println("Month " + month + " is in " + season);
    }
}
```

### Important Notes about Switch:
- The `break` statement is crucial to prevent fall-through
- The `default` case is optional but recommended
- Expression must be of type: byte, short, int, char, String, or enum
- Case values must be compile-time constants

---

## Conditional Programming

Conditional statements allow programs to make decisions and execute different code blocks based on conditions.

### 1. if Statement
```java
if (condition) {
    // code to execute if condition is true
}
```

**Example:**
```java
int age = 18;
if (age >= 18) {
    System.out.println("You are eligible to vote!");
}
```

### 2. if-else Statement
```java
if (condition) {
    // code if condition is true
} else {
    // code if condition is false
}
```

**Example:**
```java
int number = 15;
if (number % 2 == 0) {
    System.out.println(number + " is even");
} else {
    System.out.println(number + " is odd");
}
```

### 3. if-else-if Statement
```java
if (condition1) {
    // code for condition1
} else if (condition2) {
    // code for condition2
} else if (condition3) {
    // code for condition3
} else {
    // default code
}
```

**Example:**
```java
int score = 85;
if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else if (score >= 60) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F");
}
```

### 4. Nested if Statements
```java
if (condition1) {
    if (condition2) {
        // code when both conditions are true
    } else {
        // code when condition1 is true but condition2 is false
    }
} else {
    // code when condition1 is false
}
```

**Example:**
```java
int age = 20;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("You can drive!");
    } else {
        System.out.println("You need a license to drive.");
    }
} else {
    System.out.println("You must be 18 or older to drive.");
}
```

### 5. Ternary Operator (Conditional Operator)
```java
variable = (condition) ? value1 : value2;
```

**Example:**
```java
int a = 10, b = 20;
int max = (a > b) ? a : b;
System.out.println("Maximum: " + max); // Output: Maximum: 20

String result = (age >= 18) ? "Adult" : "Minor";
System.out.println(result);
```

### Practical Examples

#### Example 1: Number Classification
```java
public class NumberClassifier {
    public static void main(String[] args) {
        int number = -5;
        
        if (number > 0) {
            System.out.println(number + " is positive");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            System.out.println(number + " is zero");
        }
    }
}
```

#### Example 2: Leap Year Calculator
```java
public class LeapYear {
    public static void main(String[] args) {
        int year = 2024;
        boolean isLeapYear = false;
        
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        
        if (isLeapYear) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}
```

#### Example 3: Login System
```java
public class LoginSystem {
    public static void main(String[] args) {
        String username = "admin";
        String password = "password123";
        boolean isLoggedIn = false;
        
        if (username.equals("admin")) {
            if (password.equals("password123")) {
                isLoggedIn = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect password!");
            }
        } else {
            System.out.println("Username not found!");
        }
        
        if (isLoggedIn) {
            System.out.println("Welcome to the system!");
        } else {
            System.out.println("Access denied!");
        }
    }
}
```

---

## Best Practices

### 1. Naming Conventions
- **Variables**: Use camelCase (`myVariable`, `studentAge`)
- **Constants**: Use UPPER_CASE (`MAX_SIZE`, `DEFAULT_VALUE`)
- **Classes**: Use PascalCase (`MyClass`, `StudentRecord`)
- **Methods**: Use camelCase (`getName()`, `calculateTotal()`)

### 2. Code Organization
- Always use meaningful variable names
- Add comments to explain complex logic
- Use proper indentation
- Group related code together

### 3. Performance Tips
- Use appropriate data types (don't use `long` when `int` is sufficient)
- Initialize variables when declaring them
- Use `switch` instead of multiple `if-else` when comparing against constants

### 4. Common Mistakes to Avoid
- Forgetting `break` statements in switch cases
- Using `=` instead of `==` for comparison
- Not handling edge cases in conditional statements
- Incorrect operator precedence understanding

---

## Summary

This covers the fundamental concepts of Java programming:

1. **Programming Basics**: Understanding what programming is and Java's structure
2. **Primitive Types**: 8 basic data types for storing different kinds of values
3. **Operators**: Tools for performing operations on data
4. **Switch-Case**: Efficient way to handle multiple conditions
5. **Conditional Programming**: Making decisions in code using if-else statements

These fundamentals form the foundation for more advanced Java concepts like loops, arrays, methods, and object-oriented programming.
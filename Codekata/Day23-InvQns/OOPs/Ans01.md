# OOPs in Java - Interview Answers (Part 1)

**Target:** IT, CS, AI, ML, ECE candidates  
**Level:** Beginner  
**Companies:** Google, Amazon, Microsoft, Facebook, Zoho, etc.

---

## Fundamental OOP Concepts

### 1. What is Object-Oriented Programming (OOP) and what are its main principles? (Google, Amazon, Microsoft)

**Answer:**
Object-Oriented Programming (OOP) is a programming paradigm that organizes code around objects and classes rather than functions and logic. It models real-world entities as objects that have properties (attributes) and behaviors (methods).

**Main Principles:**
1. **Encapsulation:** Bundling data and methods together and hiding internal details
2. **Inheritance:** Creating new classes based on existing classes
3. **Polymorphism:** Same interface, different implementations
4. **Abstraction:** Hiding complex implementation details and showing only essential features

**Example:**
```java
// Real-world entity: Car
class Car {
    // Properties (attributes)
    private String brand;
    private int speed;
    
    // Behaviors (methods)
    public void accelerate() {
        speed += 10;
    }
    
    public void brake() {
        speed -= 5;
    }
}
```

### 2. Explain the four pillars of OOP: Encapsulation, Inheritance, Polymorphism, and Abstraction. (Facebook, Microsoft, Zoho)

**Answer:**

**1. Encapsulation:**
- Bundling data and methods that operate on that data within a single unit (class)
- Data hiding using access modifiers (private, protected, public)
- Provides security and control over data access

```java
class BankAccount {
    private double balance; // Data hiding
    
    public void deposit(double amount) { // Controlled access
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public double getBalance() {
        return balance;
    }
}
```

**2. Inheritance:**
- Creating new classes based on existing classes
- Child class inherits properties and methods from parent class
- Promotes code reusability

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}
```

**3. Polymorphism:**
- Same interface, different implementations
- One name, many forms
- Achieved through method overloading and overriding

```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}
```

**4. Abstraction:**
- Hiding complex implementation details
- Showing only essential features
- Achieved through abstract classes and interfaces

```java
abstract class Vehicle {
    abstract void start(); // Abstract method
    
    void stop() { // Concrete method
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car started with key");
    }
}
```

### 3. What is the difference between a class and an object in Java? (Google, Amazon, TCS)

**Answer:**

| Aspect | Class | Object |
|---------|-------|--------|
| Definition | Blueprint or template | Instance of a class |
| Memory | No memory allocated | Memory allocated |
| Existence | Logical entity | Physical entity |
| Creation | Using `class` keyword | Using `new` keyword |
| Quantity | One class definition | Multiple objects possible |

**Example:**
```java
// Class - Blueprint
class Student {
    String name;
    int age;
    
    void study() {
        System.out.println(name + " is studying");
    }
}

// Objects - Instances
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(); // Object 1
        student1.name = "Alice";
        student1.age = 20;
        
        Student student2 = new Student(); // Object 2
        student2.name = "Bob";
        student2.age = 22;
        
        student1.study(); // Alice is studying
        student2.study(); // Bob is studying
    }
}
```

### 4. What are the advantages of using OOP over procedural programming? (Microsoft, Facebook, Infosys)

**Answer:**

**OOP Advantages:**

1. **Modularity:** Code is organized into classes and objects, making it easier to manage
2. **Reusability:** Classes can be reused in different programs through inheritance
3. **Maintainability:** Changes to one class don't affect other classes
4. **Scalability:** Easy to add new features and functionality
5. **Security:** Data hiding through encapsulation
6. **Problem-solving approach:** Models real-world scenarios naturally

**Comparison:**
```java
// Procedural approach
public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
}

// OOP approach
class Calculator {
    private double result;
    
    public Calculator() {
        this.result = 0;
    }
    
    public Calculator add(double value) {
        this.result += value;
        return this;
    }
    
    public Calculator multiply(double value) {
        this.result *= value;
        return this;
    }
    
    public double getResult() {
        return result;
    }
}

// Usage: calculator.add(5).multiply(3).getResult();
```

### 5. What is encapsulation and how is it implemented in Java? (Amazon, Google, Wipro)

**Answer:**
Encapsulation is the mechanism of binding data (variables) and methods together in a single unit and hiding the internal details from outside access.

**Implementation in Java:**
1. **Private fields:** Use private access modifier for variables
2. **Public methods:** Provide public getter and setter methods
3. **Data validation:** Control access through methods

**Example:**
```java
class Employee {
    // Private fields - data hiding
    private String name;
    private int age;
    private double salary;
    
    // Public constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        setAge(age);        // Using setter for validation
        setSalary(salary);  // Using setter for validation
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getSalary() {
        return salary;
    }
    
    // Setter methods with validation
    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }
    
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary");
        }
    }
}
```

## Classes and Objects

### 6. How do you create a class in Java? Explain with an example. (Zoho, Microsoft, Cognizant)

**Answer:**
A class in Java is created using the `class` keyword followed by the class name. It contains fields (variables) and methods.

**Syntax:**
```java
[access_modifier] class ClassName {
    // Fields (variables)
    // Constructors
    // Methods
}
```

**Example:**
```java
public class Book {
    // Fields
    private String title;
    private String author;
    private int pages;
    private double price;
    
    // Constructor
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }
    
    // Methods
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: $" + price);
    }
    
    public double calculateDiscountedPrice(double discountPercent) {
        return price - (price * discountPercent / 100);
    }
    
    // Getters and Setters
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Other getters and setters...
}

// Usage
public class Main {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "John Doe", 500, 49.99);
        book.displayInfo();
        System.out.println("Discounted Price: $" + book.calculateDiscountedPrice(20));
    }
}
```

### 7. What is a constructor in Java? What are the different types of constructors? (Google, Facebook, HCL)

**Answer:**
A constructor is a special method that is called when an object is created. It has the same name as the class and no return type.

**Types of Constructors:**

**1. Default Constructor:**
```java
class Student {
    String name;
    int age;
    
    // Default constructor
    public Student() {
        name = "Unknown";
        age = 0;
        System.out.println("Default constructor called");
    }
}
```

**2. Parameterized Constructor:**
```java
class Student {
    String name;
    int age;
    
    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor called");
    }
}
```

**3. Copy Constructor (Not directly supported in Java):**
```java
class Student {
    String name;
    int age;
    
    // Copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
        System.out.println("Copy constructor called");
    }
}
```

**Complete Example:**
```java
class Car {
    private String brand;
    private String model;
    private int year;
    
    // Default constructor
    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }
    
    // Parameterized constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    // Copy constructor
    public Car(Car other) {
        this.brand = other.brand;
        this.model = other.model;
        this.year = other.year;
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}
```

### 8. What is the difference between default constructor and parameterized constructor? (Amazon, Microsoft, Accenture)

**Answer:**

| Aspect | Default Constructor | Parameterized Constructor |
|---------|-------------------|---------------------------|
| Parameters | No parameters | Takes parameters |
| Purpose | Initialize with default values | Initialize with custom values |
| Provided by | Java (if no constructor defined) | Must be explicitly defined |
| Flexibility | Less flexible | More flexible |
| Usage | When default values are sufficient | When custom initialization needed |

**Example:**
```java
class Rectangle {
    private int width;
    private int height;
    
    // Default constructor
    public Rectangle() {
        this.width = 1;
        this.height = 1;
        System.out.println("Default rectangle created: 1x1");
    }
    
    // Parameterized constructor
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("Custom rectangle created: " + width + "x" + height);
    }
    
    public int calculateArea() {
        return width * height;
    }
    
    public void displayInfo() {
        System.out.println("Width: " + width + ", Height: " + height + ", Area: " + calculateArea());
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();          // Default constructor
        Rectangle rect2 = new Rectangle(5, 10);     // Parameterized constructor
        
        rect1.displayInfo(); // Width: 1, Height: 1, Area: 1
        rect2.displayInfo(); // Width: 5, Height: 10, Area: 50
    }
}
```

### 9. Can a class have multiple constructors? Explain constructor overloading. (Facebook, Google, TCS)

**Answer:**
Yes, a class can have multiple constructors with different parameters. This is called **Constructor Overloading**.

**Rules for Constructor Overloading:**
1. Constructors must have different parameter lists
2. Different number of parameters OR different types of parameters
3. Same name (class name) but different signatures

**Example:**
```java
class Person {
    private String name;
    private int age;
    private String email;
    
    // Constructor 1: No parameters
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "unknown@email.com";
    }
    
    // Constructor 2: Name only
    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.email = "unknown@email.com";
    }
    
    // Constructor 3: Name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "unknown@email.com";
    }
    
    // Constructor 4: All parameters
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Constructor 5: Different parameter order
    public Person(int age, String name) {
        this.name = name;
        this.age = age;
        this.email = "unknown@email.com";
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Alice");
        Person person3 = new Person("Bob", 25);
        Person person4 = new Person("Charlie", 30, "charlie@email.com");
        Person person5 = new Person(28, "Diana");
        
        person1.displayInfo(); // Name: Unknown, Age: 0, Email: unknown@email.com
        person2.displayInfo(); // Name: Alice, Age: 0, Email: unknown@email.com
        person3.displayInfo(); // Name: Bob, Age: 25, Email: unknown@email.com
        person4.displayInfo(); // Name: Charlie, Age: 30, Email: charlie@email.com
        person5.displayInfo(); // Name: Diana, Age: 28, Email: unknown@email.com
    }
}
```

### 10. What is a copy constructor? Does Java support copy constructors? (Microsoft, Zoho, Infosys)

**Answer:**
A copy constructor is a constructor that creates a new object by copying another object of the same class.

**Java doesn't have built-in copy constructors** like C++, but we can create our own copy constructor.

**Implementation:**
```java
class Student {
    private String name;
    private int age;
    private int[] grades;
    
    // Regular constructor
    public Student(String name, int age, int[] grades) {
        this.name = name;
        this.age = age;
        this.grades = new int[grades.length];
        System.arraycopy(grades, 0, this.grades, 0, grades.length);
    }
    
    // Copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
        // Deep copy for arrays
        this.grades = new int[other.grades.length];
        System.arraycopy(other.grades, 0, this.grades, 0, other.grades.length);
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
        System.out.print("Grades: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }
    
    public void updateGrade(int index, int newGrade) {
        if (index >= 0 && index < grades.length) {
            grades[index] = newGrade;
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        int[] grades = {85, 90, 78, 92};
        Student original = new Student("Alice", 20, grades);
        Student copy = new Student(original); // Copy constructor
        
        System.out.println("Original:");
        original.displayInfo();
        
        System.out.println("Copy:");
        copy.displayInfo();
        
        // Modify original
        original.updateGrade(0, 95);
        
        System.out.println("\nAfter modifying original:");
        System.out.println("Original:");
        original.displayInfo();
        
        System.out.println("Copy (unchanged):");
        copy.displayInfo();
    }
}
```

## Inheritance

### 11. What is inheritance in Java? Explain with an example. (Google, Amazon, Wipro)

**Answer:**
Inheritance is a mechanism where a new class (child/subclass) acquires properties and behaviors of an existing class (parent/superclass). It promotes code reusability and establishes an "IS-A" relationship.

**Key Terms:**
- **Superclass/Parent class:** The class being inherited from
- **Subclass/Child class:** The class that inherits
- **`extends` keyword:** Used to implement inheritance

**Example:**
```java
// Parent class
class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Child class
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
    
    public void wagTail() {
        System.out.println(name + " is wagging tail");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Breed: " + breed);
    }
}

// Another child class
class Cat extends Animal {
    private String color;
    
    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }
    
    public void meow() {
        System.out.println(name + " is meowing");
    }
    
    public void climb() {
        System.out.println(name + " is climbing");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Color: " + color);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, "Black");
        
        // Using inherited methods
        dog.eat();    // From Animal class
        dog.sleep();  // From Animal class
        dog.bark();   // Dog's own method
        dog.wagTail(); // Dog's own method
        dog.displayInfo(); // Overridden method
        
        System.out.println();
        
        cat.eat();    // From Animal class
        cat.sleep();  // From Animal class
        cat.meow();   // Cat's own method
        cat.climb();  // Cat's own method
        cat.displayInfo(); // Overridden method
    }
}
```

### 12. What are the different types of inheritance? Which types does Java support? (Microsoft, Facebook, Cognizant)

**Answer:**

**Types of Inheritance:**

1. **Single Inheritance:** One child class inherits from one parent class
2. **Multiple Inheritance:** One child class inherits from multiple parent classes
3. **Multilevel Inheritance:** Chain of inheritance (A→B→C)
4. **Hierarchical Inheritance:** Multiple child classes inherit from one parent
5. **Hybrid Inheritance:** Combination of multiple inheritance types

**Java Support:**
- ✅ **Single Inheritance**
- ❌ **Multiple Inheritance** (classes) - Not supported due to Diamond Problem
- ✅ **Multilevel Inheritance**
- ✅ **Hierarchical Inheritance**
- ✅ **Multiple Inheritance** (interfaces only)

**Examples:**

**1. Single Inheritance:**
```java
class Vehicle {
    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving");
    }
}
```

**2. Multilevel Inheritance:**
```java
class Animal {
    void breathe() {
        System.out.println("Animal is breathing");
    }
}

class Mammal extends Animal {
    void giveMilk() {
        System.out.println("Mammal gives milk");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("Dog is barking");
    }
}
```

**3. Hierarchical Inheritance:**
```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    void drawCircle() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    void drawRectangle() {
        System.out.println("Drawing a rectangle");
    }
}

class Triangle extends Shape {
    void drawTriangle() {
        System.out.println("Drawing a triangle");
    }
}
```

**4. Multiple Inheritance (Interfaces only):**
```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}
```

### 13. What is the difference between `extends` and `implements` keywords? (Amazon, Google, HCL)

**Answer:**

| Aspect | `extends` | `implements` |
|---------|-----------|-------------|
| Purpose | Inherit from a class | Implement an interface |
| Inheritance | Class inheritance | Interface implementation |
| Multiple | Single class only | Multiple interfaces |
| Methods | Inherit concrete methods | Must implement abstract methods |
| Variables | Inherit all variables | Inherit only constants |
| Constructor | Can call parent constructor | No constructor in interface |

**Example:**
```java
// Base class
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
}

// Interface
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

// Using extends
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    public void chirp() {
        System.out.println(name + " is chirping");
    }
}

// Using implements
class Fish implements Swimmable {
    private String name;
    
    public Fish(String name) {
        this.name = name;
    }
    
    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }
}

// Using both extends and implements
class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name) {
        super(name);
    }
    
    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }
    
    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck("Donald");
        duck.eat();  // From Animal class
        duck.fly();  // From Flyable interface
        duck.swim(); // From Swimmable interface
    }
}
```

### 14. What is method overriding? How is it different from method overloading? (Facebook, Microsoft, Accenture)

**Answer:**

**Method Overriding:**
- Child class provides a specific implementation of a method already defined in parent class
- Same method signature (name, parameters, return type)
- Runtime polymorphism
- Uses `@Override` annotation

**Method Overloading:**
- Multiple methods with same name but different parameters in same class
- Different method signatures
- Compile-time polymorphism
- No special annotation needed

**Comparison:**

| Aspect | Method Overriding | Method Overloading |
|---------|------------------|-------------------|
| Definition | Redefining parent method | Multiple methods with same name |
| Location | Different classes | Same class |
| Parameters | Same | Different |
| Return type | Same (or covariant) | Can be different |
| Access modifier | Same or less restrictive | Any |
| Polymorphism | Runtime | Compile-time |
| Inheritance | Required | Not required |

**Example:**
```java
// Method Overriding Example
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
    
    public void move() {
        System.out.println("Animal moves");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
    
    @Override
    public void move() {
        System.out.println("Dog runs");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
    
    @Override
    public void move() {
        System.out.println("Cat jumps");
    }
}

// Method Overloading Example
class Calculator {
    // Method 1: Two integers
    public int add(int a, int b) {
        return a + b;
    }
    
    // Method 2: Three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Method 3: Two doubles
    public double add(double a, double b) {
        return a + b;
    }
    
    // Method 4: Array of integers
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Method Overriding
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal animal : animals) {
            animal.makeSound(); // Calls overridden method
            animal.move();      // Calls overridden method
        }
        
        // Method Overloading
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3));           // 8
        System.out.println(calc.add(5, 3, 2));        // 10
        System.out.println(calc.add(5.5, 3.2));       // 8.7
        System.out.println(calc.add(new int[]{1, 2, 3, 4})); // 10
    }
}
```

### 15. What is the `super` keyword in Java? When and how is it used? (Google, Zoho, TCS)

**Answer:**
The `super` keyword is used to refer to the immediate parent class object. It's used to access parent class members and constructors.

**Uses of `super` keyword:**

1. **Access parent class methods**
2. **Access parent class variables**
3. **Call parent class constructor**

**Example:**
```java
class Vehicle {
    protected String brand;
    protected int year;
    
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    public void start() {
        System.out.println("Vehicle is starting");
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

class Car extends Vehicle {
    private String model;
    private int doors;
    
    public Car(String brand, int year, String model, int doors) {
        super(brand, year); // Call parent constructor
        this.model = model;
        this.doors = doors;
    }
    
    @Override
    public void start() {
        super.start(); // Call parent method
        System.out.println("Car engine started");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Model: " + model + ", Doors: " + doors);
    }
    
    public void showDetails() {
        System.out.println("Brand from parent: " + super.brand); // Access parent variable
        System.out.println("Model from child: " + this.model);
    }
}

// Example with method parameter hiding
class Parent {
    String name = "Parent";
    
    void display() {
        System.out.println("Parent display method");
    }
}

class Child extends Parent {
    String name = "Child";
    
    void display() {
        System.out.println("Child display method");
    }
    
    void showNames() {
        System.out.println("Child name: " + this.name);  // Child
        System.out.println("Parent name: " + super.name); // Parent
    }
    
    void callMethods() {
        this.display();  // Child display method
        super.display(); // Parent display method
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 2022, "Camry", 4);
        car.start();
        car.displayInfo();
        car.showDetails();
        
        System.out.println();
        
        Child child = new Child();
        child.showNames();
        child.callMethods();
    }
}
```

**Important Notes:**
- `super()` must be the first statement in constructor
- `super` cannot be used in static methods
- `super` and `this` cannot be used together in constructor

### 16. Can you override static methods in Java? Why or why not? (Amazon, Microsoft, Infosys)

**Answer:**
**No, you cannot override static methods in Java.** Static methods belong to the class, not to any instance, so they cannot be overridden. Instead, they can be **hidden** or **shadowed**.

**Reasons:**
1. **Static methods belong to class, not instance**
2. **Method overriding requires inheritance and dynamic binding**
3. **Static methods are resolved at compile time**
4. **No polymorphism with static methods**

**Example:**
```java
class Parent {
    // Static method
    public static void staticMethod() {
        System.out.println("Parent static method");
    }
    
    // Instance method
    public void instanceMethod() {
        System.out.println("Parent instance method");
    }
}

class Child extends Parent {
    // This is method hiding, not overriding
    public static void staticMethod() {
        System.out.println("Child static method");
    }
    
    // This is method overriding
    @Override
    public void instanceMethod() {
        System.out.println("Child instance method");
    }
}

// Demonstration
public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        Parent parentRef = new Child(); // Parent reference, Child object
        
        // Static method calls - resolved at compile time
        Parent.staticMethod();    // Parent static method
        Child.staticMethod();     // Child static method
        parentRef.staticMethod(); // Parent static method (not Child!)
        
        // Instance method calls - resolved at runtime
        parent.instanceMethod();    // Parent instance method
        child.instanceMethod();     // Child instance method
        parentRef.instanceMethod(); // Child instance method (polymorphism)
    }
}
```

**What happens if you try to override:**
```java
class Parent {
    public static void method() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    // This will cause compilation error if you use @Override
    // @Override // Error: Cannot override static method
    public static void method() {
        System.out.println("Child static method");
    }
}
```

**Key Points:**
- Static methods are resolved based on the **reference type**, not object type
- Instance methods are resolved based on the **object type** (polymorphism)
- Use `@Override` annotation to catch such errors at compile time

### 17. What is the `final` keyword in Java? How does it affect inheritance? (Facebook, Google, Wipro)

**Answer:**
The `final` keyword is used to restrict modification or extension. It can be applied to variables, methods, and classes.

**Uses of `final` keyword:**

**1. Final Variables:**
```java
class Constants {
    public static final double PI = 3.14159;
    public static final int MAX_SIZE = 100;
    
    public void method() {
        final int localVar = 10;
        // localVar = 20; // Error: cannot reassign
        
        final List<String> list = new ArrayList<>();
        list.add("item"); // OK: can modify object
        // list = new ArrayList<>(); // Error: cannot reassign reference
    }
}
```

**2. Final Methods:**
```java
class Parent {
    // Final method - cannot be overridden
    public final void finalMethod() {
        System.out.println("This method cannot be overridden");
    }
    
    // Regular method - can be overridden
    public void regularMethod() {
        System.out.println("This method can be overridden");
    }
}

class Child extends Parent {
    // This would cause compilation error
    // public void finalMethod() { } // Error!
    
    @Override
    public void regularMethod() {
        System.out.println("Overridden regular method");
    }
}
```

**3. Final Classes:**
```java
// Final class - cannot be extended
public final class ImmutableClass {
    private final String value;
    
    public ImmutableClass(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}

// This would cause compilation error
// class ExtendedClass extends ImmutableClass { } // Error!
```

**Real-world Examples:**
```java
// String class is final
public final class String {
    // String cannot be extended
}

// Wrapper classes are final
public final class Integer {
    // Integer cannot be extended
}

// Example of final class usage
public final class UtilityClass {
    private UtilityClass() {
        // Private constructor prevents instantiation
    }
    
    public static final double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}
```

**Complete Example:**
```java
class Vehicle {
    protected final String vehicleId;
    
    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    // Final method - cannot be overridden
    public final void displayVehicleId() {
        System.out.println("Vehicle ID: " + vehicleId);
    }
    
    // Regular method - can be overridden
    public void start() {
        System.out.println("Vehicle starting");
    }
}

final class Car extends Vehicle {
    private final int maxSpeed;
    
    public Car(String vehicleId, int maxSpeed) {
        super(vehicleId);
        this.maxSpeed = maxSpeed;
    }
    
    @Override
    public void start() {
        System.out.println("Car starting with max speed: " + maxSpeed);
    }
    
    // Final method in final class
    public final void displayMaxSpeed() {
        System.out.println("Max Speed: " + maxSpeed);
    }
}

// Cannot extend Car because it's final
// class SportsCar extends Car { } // Compilation error

public class Main {
    public static void main(String[] args) {
        Car car = new Car("CAR001", 200);
        car.displayVehicleId(); // From Vehicle class
        car.start();           // Overridden method
        car.displayMaxSpeed(); // From Car class
    }
}
```

**Effects on Inheritance:**
- **Final variables:** Cannot be reassigned
- **Final methods:** Cannot be overridden by subclasses
- **Final classes:** Cannot be extended (no subclasses)

### 18. What is multilevel inheritance? Provide an example. (Microsoft, Zoho, Cognizant)

**Answer:**
Multilevel inheritance is a type of inheritance where a class inherits from another class, which in turn inherits from another class, forming a chain of inheritance (A → B → C).

**Characteristics:**
- Forms a chain/hierarchy of classes
- Each class can access properties and methods of all its ancestors
- Follows transitive property of inheritance

**Example:**
```java
// Level 1 - Grandparent class
class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Level 2 - Parent class
class Mammal extends Animal {
    protected String furColor;
    
    public Mammal(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }
    
    public void giveBirth() {
        System.out.println(name + " gives birth to live young");
    }
    
    public void produceMilk() {
        System.out.println(name + " produces milk");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fur Color: " + furColor);
    }
}

// Level 3 - Child class
class Dog extends Mammal {
    private String breed;
    
    public Dog(String name, int age, String furColor, String breed) {
        super(name, age, furColor);
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
    
    public void wagTail() {
        System.out.println(name + " is wagging tail");
    }
    
    public void guard() {
        System.out.println(name + " is guarding the house");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}

// Usage and demonstration
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Golden", "Golden Retriever");
        
        // Methods from Animal class (Level 1)
        dog.eat();
        dog.sleep();
        
        // Methods from Mammal class (Level 2)
        dog.giveBirth();
        dog.produceMilk();
        
        // Methods from Dog class (Level 3)
        dog.bark();
        dog.wagTail();
        dog.guard();
        
        // Display complete information
        dog.displayInfo();
        
        System.out.println("\n--- Demonstrating inheritance chain ---");
        
        // Dog IS-A Mammal
        Mammal mammal = new Dog("Rex", 2, "Brown", "German Shepherd");
        mammal.eat();        // From Animal
        mammal.giveBirth();  // From Mammal
        // mammal.bark();    // Not accessible (Dog method)
        
        // Dog IS-A Animal
        Animal animal = new Dog("Max", 4, "Black", "Labrador");
        animal.eat();        // From Animal
        animal.sleep();      // From Animal
        // animal.giveBirth(); // Not accessible (Mammal method)
        // animal.bark();      // Not accessible (Dog method)
    }
}
```

**Another Example - Academic Hierarchy:**
```java
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayBasicInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    protected String studentId;
    protected String major;
    
    public Student(String name, int age, String studentId, String major) {
        super(name, age);
        this.studentId = studentId;
        this.major = major;
    }
    
    public void study() {
        System.out.println(name + " is studying " + major);
    }
    
    public void displayStudentInfo() {
        displayBasicInfo();
        System.out.println("Student ID: " + studentId + ", Major: " + major);
    }
}

class GraduateStudent extends Student {
    private String researchTopic;
    private String advisor;
    
    public GraduateStudent(String name, int age, String studentId, String major, 
                          String researchTopic, String advisor) {
        super(name, age, studentId, major);
        this.researchTopic = researchTopic;
        this.advisor = advisor;
    }
    
    public void conductResearch() {
        System.out.println(name + " is conducting research on " + researchTopic);
    }
    
    public void displayGraduateInfo() {
        displayStudentInfo();
        System.out.println("Research Topic: " + researchTopic + ", Advisor: " + advisor);
    }
}
```

**Key Points:**
- Each level adds its own functionality
- Lower levels can access all higher-level methods
- Method overriding works at any level
- Creates a natural hierarchy reflecting real-world relationships

### 19. Why doesn't Java support multiple inheritance? How does it achieve similar functionality? (Amazon, Google, HCL)

**Answer:**
Java doesn't support multiple inheritance of classes due to the **Diamond Problem** (ambiguity problem), but it achieves similar functionality through **interfaces**.

**Diamond Problem:**
```java
// This is NOT allowed in Java
class A {
    public void method() {
        System.out.println("Method from A");
    }
}

class B extends A {
    @Override
    public void method() {
        System.out.println("Method from B");
    }
}

class C extends A {
    @Override
    public void method() {
        System.out.println("Method from C");
    }
}

// This would cause ambiguity - which method() to inherit?
// class D extends B, C { } // Not allowed in Java
```

**Problems with Multiple Inheritance:**
1. **Ambiguity:** Which method to call when multiple parents have same method
2. **Complexity:** Complex resolution rules
3. **Maintenance:** Difficult to maintain and debug

**Java's Solutions:**

**1. Multiple Interface Implementation:**
```java
interface Flyable {
    void fly();
    
    default void move() {
        System.out.println("Moving through air");
    }
}

interface Swimmable {
    void swim();
    
    default void move() {
        System.out.println("Moving through water");
    }
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
    
    // Must override to resolve ambiguity
    @Override
    public void move() {
        System.out.println("Duck can move in air and water");
    }
}
```

**2. Composition Pattern:**
```java
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
    
    public void stop() {
        System.out.println("Engine stopped");
    }
}

class GPS {
    public void navigate() {
        System.out.println("GPS navigating");
    }
    
    public void findLocation() {
        System.out.println("Finding current location");
    }
}

class Car {
    private Engine engine;  // HAS-A relationship
    private GPS gps;        // HAS-A relationship
    
    public Car() {
        this.engine = new Engine();
        this.gps = new GPS();
    }
    
    public void start() {
        engine.start();
    }
    
    public void navigate() {
        gps.navigate();
    }
    
    public void findLocation() {
        gps.findLocation();
    }
}
```

**3. Interface Hierarchy:**
```java
interface Animal {
    void eat();
}

interface Flyable extends Animal {
    void fly();
}

interface Swimmable extends Animal {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void eat() {
        System.out.println("Duck is eating");
    }
    
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}
```

**4. Mixin Pattern with Interfaces:**
```java
interface Debuggable {
    default void debug() {
        System.out.println("Debugging: " + this.getClass().getSimpleName());
    }
}

interface Loggable {
    default void log(String message) {
        System.out.println("Log: " + message);
    }
}

interface Cacheable {
    default void cache() {
        System.out.println("Caching data");
    }
}

class DatabaseService implements Debuggable, Loggable, Cacheable {
    public void processData() {
        log("Processing data");
        cache();
        debug();
    }
}
```

**Complete Example:**
```java
// Base class
abstract class Vehicle {
    protected String name;
    
    public Vehicle(String name) {
        this.name = name;
    }
    
    public abstract void start();
}

// Interfaces for different capabilities
interface Flyable {
    void fly();
    void land();
}

interface Swimmable {
    void swim();
    void dive();
}

interface Drivable {
    void drive();
    void park();
}

// Amphibious vehicle that can swim and drive
class AmphibiousVehicle extends Vehicle implements Swimmable, Drivable {
    public AmphibiousVehicle(String name) {
        super(name);
    }
    
    @Override
    public void start() {
        System.out.println(name + " amphibious vehicle started");
    }
    
    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }
    
    @Override
    public void dive() {
        System.out.println(name + " is diving");
    }
    
    @Override
    public void drive() {
        System.out.println(name + " is driving on land");
    }
    
    @Override
    public void park() {
        System.out.println(name + " is parked");
    }
}
```

**Advantages of Java's Approach:**
- **No ambiguity:** Clear resolution rules
- **Flexibility:** Mix and match interfaces
- **Maintainability:** Easier to understand and maintain
- **Multiple contracts:** Can implement multiple interfaces

### 20. What is the difference between IS-A and HAS-A relationships? (Facebook, Microsoft, Accenture)

**Answer:**

**IS-A Relationship (Inheritance):**
- Represents inheritance relationship
- "Child IS-A Parent" relationship
- Implemented using `extends` keyword
- Establishes a hierarchical relationship

**HAS-A Relationship (Composition/Aggregation):**
- Represents ownership/containment relationship
- "Class HAS-A component" relationship
- Implemented using instance variables
- Establishes a containment relationship

**Comparison:**

| Aspect | IS-A Relationship | HAS-A Relationship |
|---------|------------------|-------------------|
| Keyword | `extends` | Instance variables |
| Type | Inheritance | Composition/Aggregation |
| Coupling | Tight coupling | Loose coupling |
| Reusability | Less flexible | More flexible |
| Example | Dog IS-A Animal | Car HAS-A Engine |

**IS-A Relationship Examples:**
```java
// IS-A relationship through inheritance
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
}

// Dog IS-A Animal
// Dog inherits all properties and methods of Animal
```

**HAS-A Relationship Examples:**
```java
// HAS-A relationship through composition
class Engine {
    private String type;
    private int horsepower;
    
    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }
    
    public void start() {
        System.out.println(type + " engine started");
    }
    
    public void stop() {
        System.out.println(type + " engine stopped");
    }
}

class Wheel {
    private int size;
    private String type;
    
    public Wheel(int size, String type) {
        this.size = size;
        this.type = type;
    }
    
    public void rotate() {
        System.out.println(size + " inch " + type + " wheel rotating");
    }
}

class Car {
    private Engine engine;    // Car HAS-A Engine
    private Wheel[] wheels;   // Car HAS-A Wheels
    private String model;
    
    public Car(String model) {
        this.model = model;
        this.engine = new Engine("V6", 300);
        this.wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(17, "Alloy");
        }
    }
    
    public void start() {
        engine.start();
        System.out.println(model + " is ready to drive");
    }
    
    public void drive() {
        for (Wheel wheel : wheels) {
            wheel.rotate();
        }
        System.out.println(model + " is driving");
    }
}
```

**Complex Example with Both Relationships:**
```java
// Base class for IS-A relationship
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Classes for HAS-A relationship
class Address {
    private String street;
    private String city;
    private String zipCode;
    
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    public String getFullAddress() {
        return street + ", " + city + " " + zipCode;
    }
}

class Phone {
    private String number;
    private String type;
    
    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }
    
    public void call() {
        System.out.println("Calling " + number + " (" + type + ")");
    }
}

// Employee IS-A Person (inheritance)
class Employee extends Person {
    private String employeeId;
    private Address address;    // Employee HAS-A Address
    private Phone phone;        // Employee HAS-A Phone
    
    public Employee(String name, int age, String employeeId, Address address, Phone phone) {
        super(name, age);  // IS-A relationship
        this.employeeId = employeeId;
        this.address = address;  // HAS-A relationship
        this.phone = phone;      // HAS-A relationship
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Address: " + address.getFullAddress());
        System.out.println("Phone: " + phone.toString());
    }
    
    public void makeCall() {
        phone.call();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "New York", "10001");
        Phone phone = new Phone("555-1234", "Mobile");
        
        Employee employee = new Employee("John Doe", 30, "EMP001", address, phone);
        
        // IS-A relationship: Employee IS-A Person
        employee.displayInfo();  // Can use Person methods
        
        // HAS-A relationship: Employee HAS-A Phone
        employee.makeCall();     // Uses Phone functionality
    }
}
```

**When to Use Which:**

**Use IS-A (Inheritance) when:**
- There's a clear hierarchical relationship
- Child class is a specialized version of parent
- You want to reuse code from parent class
- Example: Student IS-A Person, Dog IS-A Animal

**Use HAS-A (Composition) when:**
- One class contains another as a component
- You want loose coupling
- You need flexibility in design
- Example: Car HAS-A Engine, House HAS-A Room

**Best Practices:**
- Favor composition over inheritance when possible
- Use inheritance for IS-A relationships
- Use composition for HAS-A relationships
- Consider the Liskov Substitution Principle for inheritance

---

**Note:** These answers provide comprehensive explanations with practical examples. Practice implementing these concepts with actual code to reinforce your understanding. Focus on understanding the principles behind each concept rather than just memorizing the definitions.
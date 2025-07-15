## Stack Data Structure - Notes

### What is a Stack?
A **Stack** is a linear data structure that follows the **LIFO (Last In, First Out)** principle. Think of it like a stack of plates - you can only add or remove plates from the top.

### Key Characteristics:
- **LIFO Principle**: The last element added is the first one to be removed
- **Single Point of Access**: All operations happen at the top of the stack
- **Dynamic Size**: Can grow and shrink during runtime

### Basic Stack Operations:

#### 1. **Push**
- Adds an element to the top of the stack
- Time Complexity: O(1)
```java
stack.push(element);
```

#### 2. **Pop**
- Removes and returns the top element
- Time Complexity: O(1)
- Throws exception if stack is empty
```java
element = stack.pop();
```

#### 3. **Peek/Top**
- Returns the top element without removing it
- Time Complexity: O(1)
```java
element = stack.peek();
```

#### 4. **isEmpty**
- Checks if the stack is empty
- Time Complexity: O(1)
```java
boolean empty = stack.isEmpty();
```

#### 5. **Size**
- Returns the number of elements in the stack
- Time Complexity: O(1)
```java
int size = stack.size();
```

### Stack Implementation in Java:

#### 1. **Using Java Collections Framework**
```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop()); // Output: 30
System.out.println(stack.peek()); // Output: 20
```

#### 2. **Using ArrayList**
```java
import java.util.ArrayList;

ArrayList<Integer> stack = new ArrayList<>();
// Push operation
stack.add(element);
// Pop operation
stack.remove(stack.size() - 1);
// Peek operation
stack.get(stack.size() - 1);
```

#### 3. **Array-based Implementation**
```java
class ArrayStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    public ArrayStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    public void push(int x) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = x;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}
```

### Real-World Applications:

#### 1. **Function Call Management**
- Method calls are stored in a call stack
- When a method is called, it's pushed onto the stack
- When it returns, it's popped from the stack

#### 2. **Expression Evaluation**
- **Infix to Postfix conversion**
- **Postfix expression evaluation**
- **Parentheses matching**

#### 3. **Undo Operations**
- Text editors use stacks for undo functionality
- Each action is pushed onto the stack
- Undo pops the last action

#### 4. **Browser History**
- Back button functionality
- Each visited page is pushed onto the stack

### Common Stack Problems:

#### 1. **Balanced Parentheses**
```java
public boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : str.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else if (c == ')' || c == ']' || c == '}') {
            if (stack.isEmpty()) return false;
            
            char top = stack.pop();
            if (!isMatchingPair(top, c)) return false;
        }
    }
    
    return stack.isEmpty();
}
```

#### 2. **Postfix Expression Evaluation**
```java
public int evaluatePostfix(String expression) {
    Stack<Integer> stack = new Stack<>();
    
    for (char c : expression.toCharArray()) {
        if (Character.isDigit(c)) {
            stack.push(c - '0');
        } else {
            int operand2 = stack.pop();
            int operand1 = stack.pop();
            
            switch (c) {
                case '+': stack.push(operand1 + operand2); break;
                case '-': stack.push(operand1 - operand2); break;
                case '*': stack.push(operand1 * operand2); break;
                case '/': stack.push(operand1 / operand2); break;
            }
        }
    }
    
    return stack.pop();
}
```

### Stack vs Other Data Structures:

| Feature | Stack | Queue | Array | Linked List |
|---------|-------|-------|-------|-------------|
| Access Pattern | LIFO | FIFO | Random | Sequential |
| Insertion | Top only | Rear only | Any position | Any position |
| Deletion | Top only | Front only | Any position | Any position |
| Time Complexity | O(1) | O(1) | O(1) for access | O(n) for access |

### Advantages:
- **Simple Implementation**: Easy to understand and implement
- **Efficient Operations**: All basic operations are O(1)
- **Memory Efficient**: No extra memory overhead
- **Automatic Memory Management**: In dynamic implementations

### Disadvantages:
- **Limited Access**: Can only access the top element
- **No Random Access**: Cannot access elements in the middle
- **Stack Overflow**: Fixed-size implementations can overflow

### Time & Space Complexity:
- **Push**: O(1)
- **Pop**: O(1)
- **Peek**: O(1)
- **isEmpty**: O(1)
- **Space Complexity**: O(n) where n is the number of elements

### Key Points to Remember:
1. Stack is a **LIFO** data structure
2. All operations happen at the **top** of the stack
3. **Push** adds elements, **Pop** removes elements
4. Always check for **empty stack** before popping
5. Useful for **recursive problems** and **expression evaluation**
6. Java provides built-in `Stack` class in `java.util` package

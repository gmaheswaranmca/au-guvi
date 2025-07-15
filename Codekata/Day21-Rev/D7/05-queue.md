## Queue Data Structure - Notes

### What is a Queue?
A **Queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle. Think of it like a line of people waiting - the first person to join the line is the first one to be served.

### Key Characteristics:
- **FIFO Principle**: The first element added is the first one to be removed
- **Two Points of Access**: Insertion at rear, deletion from front
- **Dynamic Size**: Can grow and shrink during runtime

### Basic Queue Operations:

#### 1. **Enqueue**
- Adds an element to the rear of the queue
- Time Complexity: O(1)
```java
queue.offer(element);
// or
queue.add(element);
```

#### 2. **Dequeue**
- Removes and returns the front element
- Time Complexity: O(1)
- Returns null if queue is empty (poll) or throws exception (remove)
```java
element = queue.poll(); // Returns null if empty
element = queue.remove(); // Throws exception if empty
```

#### 3. **Front/Peek**
- Returns the front element without removing it
- Time Complexity: O(1)
```java
element = queue.peek(); // Returns null if empty
element = queue.element(); // Throws exception if empty
```

#### 4. **isEmpty**
- Checks if the queue is empty
- Time Complexity: O(1)
```java
boolean empty = queue.isEmpty();
```

#### 5. **Size**
- Returns the number of elements in the queue
- Time Complexity: O(1)
```java
int size = queue.size();
```

### Queue Implementation in Java:

#### 1. **Using Java Collections Framework**
```java
import java.util.Queue;
import java.util.LinkedList;

Queue<Integer> queue = new LinkedList<>();
queue.offer(10);
queue.offer(20);
queue.offer(30);

System.out.println(queue.poll()); // Output: 10
System.out.println(queue.peek()); // Output: 20
```

#### 2. **Using ArrayDeque**
```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue<Integer> queue = new ArrayDeque<>();
queue.offer(10);
queue.offer(20);
queue.offer(30);
```

#### 3. **Array-based Implementation (Circular Queue)**
```java
class ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int x) {
        if (size == capacity) {
            throw new RuntimeException("Queue Overflow");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int element = arr[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}
```

#### 4. **Linked List Implementation**
```java
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedQueue {
    private Node front;
    private Node rear;
    private int size;
    
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int element = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return element;
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public int size() {
        return size;
    }
}
```

### Types of Queues:

#### 1. **Simple Queue**
- Basic FIFO queue
- Insertion at rear, deletion from front

#### 2. **Circular Queue**
- Uses circular array to optimize space
- Rear wraps around to beginning when it reaches end

#### 3. **Priority Queue**
- Elements have priorities
- Higher priority elements are dequeued first
```java
import java.util.PriorityQueue;

PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(30);
pq.offer(10);
pq.offer(20);
System.out.println(pq.poll()); // Output: 10 (lowest priority first)
```

#### 4. **Double-Ended Queue (Deque)**
- Insertion and deletion at both ends
```java
import java.util.Deque;
import java.util.ArrayDeque;

Deque<Integer> deque = new ArrayDeque<>();
deque.offerFirst(10);  // Add to front
deque.offerLast(20);   // Add to rear
deque.pollFirst();     // Remove from front
deque.pollLast();      // Remove from rear
```

### Real-World Applications:

#### 1. **CPU Scheduling**
- Process scheduling in operating systems
- Round-robin scheduling algorithm

#### 2. **Print Queue**
- Managing print jobs in printers
- First submitted job gets printed first

#### 3. **BFS (Breadth-First Search)**
- Graph traversal algorithm
- Level-order traversal in trees

#### 4. **Buffer for Data Streams**
- Keyboard buffer
- Network packet buffering

#### 5. **Call Center Systems**
- Managing incoming calls
- First caller gets served first

### Common Queue Problems:

#### 1. **Implement Stack using Queues**
```java
class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
```

#### 2. **Generate Binary Numbers**
```java
public void generateBinary(int n) {
    Queue<String> queue = new LinkedList<>();
    queue.offer("1");
    
    for (int i = 0; i < n; i++) {
        String current = queue.poll();
        System.out.println(current);
        
        queue.offer(current + "0");
        queue.offer(current + "1");
    }
}
```

#### 3. **Level Order Traversal**
```java
public void levelOrder(TreeNode root) {
    if (root == null) return;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        System.out.print(current.val + " ");
        
        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
    }
}
```

### Queue vs Other Data Structures:

| Feature | Queue | Stack | Array | Linked List |
|---------|-------|-------|-------|-------------|
| Access Pattern | FIFO | LIFO | Random | Sequential |
| Insertion | Rear only | Top only | Any position | Any position |
| Deletion | Front only | Top only | Any position | Any position |
| Time Complexity | O(1) | O(1) | O(1) for access | O(n) for access |

### Advantages:
- **Fair Processing**: First come, first served
- **Efficient Operations**: All basic operations are O(1)
- **Natural Flow**: Matches real-world scenarios
- **Memory Efficient**: Linked list implementation grows dynamically

### Disadvantages:
- **Limited Access**: Can only access front element
- **No Random Access**: Cannot access middle elements
- **Memory Overhead**: Linked list implementation has pointer overhead

### Time & Space Complexity:
- **Enqueue**: O(1)
- **Dequeue**: O(1)
- **Peek**: O(1)
- **isEmpty**: O(1)
- **Space Complexity**: O(n) where n is the number of elements

### Array vs Linked List Implementation:

| Aspect | Array Implementation | Linked List Implementation |
|--------|---------------------|---------------------------|
| Memory | Fixed size | Dynamic size |
| Space | O(n) | O(n) + pointer overhead |
| Cache Performance | Better | Worse |
| Implementation | More complex (circular) | Simpler |

### Key Points to Remember:
1. Queue is a **FIFO** data structure
2. **Enqueue** adds to rear, **Dequeue** removes from front
3. Use **LinkedList** or **ArrayDeque** in Java
4. **Circular queue** prevents memory wastage in array implementation
5. Essential for **BFS** and **level-order traversal**
6. Java provides **Queue** interface with multiple implementations
7. **PriorityQueue** is useful for scheduling algorithms
8. **Deque** provides flexibility for both ends operations

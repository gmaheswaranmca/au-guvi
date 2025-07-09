# AVL Tree Notes

## Definition
- An AVL tree is a self-balancing binary search tree (BST).
- Named after inventors Adelson-Velsky and Landis.
- For every node, the heights of the left and right subtrees differ by at most 1.

## Properties
- **Balance Factor (BF)** = height(left subtree) - height(right subtree)
- For every node: BF ∈ {-1, 0, 1}
- Ensures O(log n) time complexity for search, insert, and delete.

## Rotations
Used to restore balance after insertions or deletions.

### Four types:
1. **Left Rotation (LL)**
2. **Right Rotation (RR)**
3. **Left-Right Rotation (LR)**
4. **Right-Left Rotation (RL)**

### Rotations Explained with Text Tree Examples:

#### **LL Rotation (Right Rotation)**
When left subtree of left child is taller.

**Before Rotation:**
```
      A (BF = +2)
     /
    B (BF = +1)
   /
  C
```

**After Right Rotation on A:**
```
    B
   / \
  C   A
```

**Step-by-Step Process:**
1. B becomes the new root
2. A becomes B's right child
3. B's right subtree becomes A's left subtree

#### **RR Rotation (Left Rotation)**
When right subtree of right child is taller.

**Before Rotation:**
```
  A (BF = -2)
   \
    B (BF = -1)
     \
      C
```

**After Left Rotation on A:**
```
    B
   / \
  A   C
```

**Step-by-Step Process:**
1. B becomes the new root
2. A becomes B's left child
3. B's left subtree becomes A's right subtree

#### **LR Rotation (Left-Right Rotation)**
When right subtree of left child is taller (Triangle case).

**Before Rotation:**
```
      A (BF = +2)
     /
    B (BF = -1)
     \
      C
```

**Step 1: Left Rotation on B**
```
      A
     /
    C
   /
  B
```

**Step 2: Right Rotation on A**
```
    C
   / \
  B   A
```

**Complete LR Process:**
1. First perform left rotation on B (left child)
2. Then perform right rotation on A (root)
3. C becomes the new root

#### **RL Rotation (Right-Left Rotation)**
When left subtree of right child is taller (Triangle case).

**Before Rotation:**
```
  A (BF = -2)
   \
    B (BF = +1)
   /
  C
```

**Step 1: Right Rotation on B**
```
  A
   \
    C
     \
      B
```

**Step 2: Left Rotation on A**
```
    C
   / \
  A   B
```

**Complete RL Process:**
1. First perform right rotation on B (right child)
2. Then perform left rotation on A (root)
3. C becomes the new root

#### **Comprehensive Example: Building AVL Tree**

Let's insert: 10, 20, 30, 40, 50, 25

**Step 1: Insert 10**
```
10
```

**Step 2: Insert 20**
```
  10
    \
    20
```

**Step 3: Insert 30 (RR Rotation needed)**
```
  10
    \
    20
      \
      30  // Unbalanced!
```

**After RR Rotation:**
```
    20
   /  \
  10   30
```

**Step 4: Insert 40**
```
    20
   /  \
  10   30
         \
         40
```

**Step 5: Insert 50 (RR Rotation needed)**
```
    20
   /  \
  10   30
         \
         40
           \
           50  // Unbalanced!
```

**After RR Rotation on subtree rooted at 30:**
```
    20
   /  \
  10   40
      /  \
     30   50
```

**Step 6: Insert 25 (RL Rotation needed)**
```
    20
   /  \
  10   40
      /  \
     30   50
    /
   25  // This makes 20 unbalanced!
```

**After RL Rotation on subtree rooted at 20:**
First right rotation on 40:
```
    20
   /  \
  10   30
      /  \
     25   40
            \
            50
```

Then left rotation on 20:
```
      30
     /  \
    20   40
   /  \    \
  10   25   50
```

**Final AVL Tree:**
```
      30
     /  \
    20   40
   /  \    \
  10   25   50
```

**Key Points:**
- **LL and RR** are single rotations
- **LR and RL** are double rotations
- Always check balance factor after insertion
- Rotations preserve BST property while restoring balance

## Operations

### AVL - Left Rotate Steps:
1. Identify the node (x) to perform left rotation on.
2. Let y = x.right (the right child of x).
3. Set x.right = y.left.
4. Set y.left = x.
5. Update heights of x and y.
6. Return y (the new root of the rotated subtree).

#### Text Diagram for Left Rotation:

**Before Left Rotation:**
```
    x               Variables:
   / \              x = node to rotate
  α   y             y = x.right
     / \            α = x.left
    β   γ           β = y.left
                    γ = y.right
```

**After Left Rotation:**
```
      y
     / \
    x   γ
   / \
  α   β
```

**Step-by-Step Transformation:**

**Step 1:** Identify x and y
```
    x (rotate this)
   / \
  α   y (this becomes new root)
     / \
    β   γ
```

**Step 2:** Save y = x.right
```
    x
   / \
  α   y ← Save this as new root
     / \
    β   γ
```

**Step 3:** Move β (y's left child) to become x's right child
```
    x
   / \
  α   β ← Moved from y.left to x.right
     
    y
     \
      γ
```

**Step 4:** Make x the left child of y
```
      y (new root)
     / \
    x   γ
   / \
  α   β
```

```pseudocode
leftRotate(x):
    y = x.right              // Step 2: Save right child
    x.right = y.left         // Step 3: Move β
    y.left = x               // Step 4: Make x left child of y
    // Update heights
    x.height = 1 + max(height(x.left), height(x.right))
    y.height = 1 + max(height(y.left), height(y.right))
    return y                 // Return new root
```

### AVL - Right Rotate Steps:
1. Identify the node (y) to perform right rotation on.
2. Let x = y.left (the left child of y).
3. Set y.left = x.right.
4. Set x.right = y.
5. Update heights of y and x.
6. Return x (the new root of the rotated subtree).

#### Text Diagram for Right Rotation:

**Before Right Rotation:**
```
      y             Variables:
     / \            y = node to rotate
    x   γ           x = y.left
   / \              α = x.left
  α   β             β = x.right
                    γ = y.right
```

**After Right Rotation:**
```
    x
   / \
  α   y
     / \
    β   γ
```

**Step-by-Step Transformation:**

**Step 1:** Identify y and x
```
      y (rotate this)
     / \
    x   γ (this becomes new root)
   / \
  α   β
```

**Step 2:** Save x = y.left
```
      y
     / \
    x   γ ← Save this as new root
   / \
  α   β
```

**Step 3:** Move β (x's right child) to become y's left child
```
      y
     / \
    β   γ ← Moved from x.right to y.left
    
  x
 /
α
```

**Step 4:** Make y the right child of x
```
    x (new root)
   / \
  α   y
     / \
    β   γ
```

```pseudocode
rightRotate(y):
    x = y.left               // Step 2: Save left child
    y.left = x.right         // Step 3: Move β
    x.right = y              // Step 4: Make y right child of x
    // Update heights
    y.height = 1 + max(height(y.left), height(y.right))
    x.height = 1 + max(height(x.left), height(x.right))
    return x                 // Return new root
```

### AVL Tree - Insert Steps:
1. Start at the root node.
2. Insert the new key as in a standard BST.
3. Update the height of each ancestor node.
4. Calculate the balance factor for each ancestor node.
5. If the balance factor becomes unbalanced (not in {-1, 0, 1}):
   - a) Identify the case (LL, RR, LR, RL) based on the structure.
   - b) Perform the appropriate rotation(s) to restore balance.
6. Repeat the process up to the root if necessary.

#### Handling Unbalanced Nodes in AVL Tree Insertion

When the balance factor of a node is not in {-1, 0, 1}, the tree is unbalanced. You need to:

1. **Identify the imbalance type:**
   - **LL (Left-Left)**: Insertion happened in the left subtree of the left child.
   - **RR (Right-Right)**: Insertion happened in the right subtree of the right child.
   - **LR (Left-Right)**: Insertion happened in the right subtree of the left child.
   - **RL (Right-Left)**: Insertion happened in the left subtree of the right child.

2. **Apply the appropriate rotation(s):**
   - **LL Case**: Perform a single right rotation.
   - **RR Case**: Perform a single left rotation.
   - **LR Case**: Perform a left rotation on the left child, then a right rotation on the unbalanced node.
   - **RL Case**: Perform a right rotation on the right child, then a left rotation on the unbalanced node.

```pseudocode
if balance > 1 and key < node.left.key:
    // LL Case
    rightRotate(node)
elif balance < -1 and key > node.right.key:
    // RR Case
    leftRotate(node)
elif balance > 1 and key > node.left.key:
    // LR Case
    leftRotate(node.left)
    rightRotate(node)
elif balance < -1 and key < node.right.key:
    // RL Case
    rightRotate(node.right)
    leftRotate(node)
```

### Additional Explanation: LR Case (Left Triangle)

The LR case is a left triangle that needs to be straightened:

1. **Left Triangle Pattern:**
```
    A (BF = +2)
   /
  B (BF = -1)  
   \
    C
```
This creates a "zigzag" or triangle pattern going left-right

2. **Step 1: Left Rotate B (Straighten the triangle)**
```
        A
       /
      C
     /
    B
```
Now we have a straight line going left-left

3. **Step 2: Right Rotate A (Balance the line)**
```
      C
     / \
    B   A
```
Final balanced tree with C as new root

**Key Insight**: LR = Left Triangle → Straighten → Balance
- Triangle: Must be straightened first (left rotate the left child)
- Line: Then balanced (right rotate the unbalanced node)

### AVL Tree - Delete Steps:
1. Start at the root node.
2. Delete the target key as in a standard BST:
   - If the node has no children, simply remove it.
   - If the node has one child, replace it with its child.
   - If the node has two children, replace it with its in-order successor or predecessor, then delete that node.
3. Update the height of each ancestor node.
4. Calculate the balance factor for each ancestor node.
5. If the balance factor becomes unbalanced (not in {-1, 0, 1}):
   - a) Identify the case (LL, RR, LR, RL) based on the structure.
   - b) Perform the appropriate rotation(s) to restore balance.
6. Repeat the process up to the root if necessary.

#### Handling Unbalanced Nodes in AVL Tree Deletion

When the balance factor of a node is not in {-1, 0, 1}, the tree is unbalanced. You need to:

1. **Identify the imbalance type:**
   - **LL (Left-Left)**: Left child's left subtree is taller.
   - **LR (Left-Right)**: Left child's right subtree is taller.
   - **RR (Right-Right)**: Right child's right subtree is taller.
   - **RL (Right-Left)**: Right child's left subtree is taller.

2. **Apply the appropriate rotation(s):**
   - **LL Case**: Perform a single right rotation.
   - **LR Case**: Perform a left rotation on the left child, then a right rotation on the unbalanced node.
   - **RR Case**: Perform a single left rotation.
   - **RL Case**: Perform a right rotation on the right child, then a left rotation on the unbalanced node.

```pseudocode
if balance > 1 and getBalance(node.left) >= 0:
    // LL Case
    rightRotate(node)
elif balance > 1 and getBalance(node.left) < 0:
    // LR Case
    leftRotate(node.left)
    rightRotate(node)
elif balance < -1 and getBalance(node.right) <= 0:
    // RR Case
    leftRotate(node)
elif balance < -1 and getBalance(node.right) > 0:
    // RL Case
    rightRotate(node.right)
    leftRotate(node)
```

## Complexity
- **Search**: O(log n)
- **Insert**: O(log n)
- **Delete**: O(log n)

## Applications
- Databases, file systems, memory management, and any application requiring ordered data with fast lookups.

## Advantages
- Maintains strict balance, guaranteeing logarithmic height.
- Faster lookups compared to unbalanced BSTs.

## Disadvantages
- More rotations and bookkeeping compared to other BSTs (e.g., Red-Black Trees).
- Slightly more complex implementation.

## Summary
- After deletion, update heights and balance factors up the tree.
- Detect the imbalance type by checking the balance factor of the node and its children.
- Apply the correct rotation(s) to restore AVL balance.

## References
- "Introduction to Algorithms" by Cormen et al.
- Wikipedia: https://en.wikipedia.org/wiki/AVL_tree

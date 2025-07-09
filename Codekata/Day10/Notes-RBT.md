# Red-Black Tree Notes

## Definition
- A Red-Black Tree (RBT) is a self-balancing binary search tree (BST).
- Each node contains an extra bit for color (red or black).
- Ensures the tree remains approximately balanced.

## Properties (Red-Black Properties)
1. Every node is either red or black.
2. The root is always black.
3. All leaves (NIL nodes) are black.
4. If a node is red, then both its children are black (no two reds in a row).
5. Every path from a node to its descendant NIL nodes contains the same number of black nodes (black-height).

## Rotations
Used to maintain balance after insertions and deletions.

### Two types:
1. **Left Rotation**
2. **Right Rotation**

### RBT - Left Rotate Steps:
1. Identify the node (x) to perform left rotation on.
2. Let y = x.right (the right child of x).
3. Set x.right = y.left.
4. If y.left is not null, set y.left.parent = x.
5. Set y.parent = x.parent.
6. If x is the root, set root = y. Else if x is a left child, set x.parent.left = y. Else set x.parent.right = y.
7. Set y.left = x.
8. Set x.parent = y.

```pseudocode
leftRotate(x):
    y = x.right
    x.right = y.left
    if y.left != null:
        y.left.parent = x
    y.parent = x.parent
    if x.parent == null:
        root = y
    elif x == x.parent.left:
        x.parent.left = y
    else:
        x.parent.right = y
    y.left = x
    x.parent = y
```

### RBT - Right Rotate Steps:
1. Identify the node (y) to perform right rotation on.
2. Let x = y.left (the left child of y).
3. Set y.left = x.right.
4. If x.right is not null, set x.right.parent = y.
5. Set x.parent = y.parent.
6. If y is the root, set root = x. Else if y is a right child, set y.parent.right = x. Else set y.parent.left = x.
7. Set x.right = y.
8. Set y.parent = x.

```pseudocode
rightRotate(y):
    x = y.left
    y.left = x.right
    if x.right != null:
        x.right.parent = y
    x.parent = y.parent
    if y.parent == null:
        root = x
    elif y == y.parent.right:
        y.parent.right = x
    else:
        y.parent.left = x
    x.right = y
    y.parent = x
```

## Operations

### RBT - Insert Steps
1. Start at the root node.
2. Insert the new key as in a standard BST.
3. Color the new node red.
4. Fix any violations of Red-Black properties:
   - a) If the parent is black, insertion is done.
   - b) If the parent is red, there is a violation:
     - i. If the uncle is red: Recolor parent and uncle to black, recolor grandparent to red, move up to the grandparent and repeat.
     - ii. If the uncle is black or null: If the new node is on the "inside" (left-right or right-left), rotate to convert to "outside" (left-left or right-right). Perform a rotation on the grandparent (right or left, as appropriate). Swap colors of parent and grandparent.
5. Ensure the root is always black.

```pseudocode
insert(node):
    standard BST insert, color new node red
    while node != root and node.parent.color == RED:
        if node.parent is left child of grandparent:
            uncle = grandparent.right
            if uncle and uncle.color == RED:
                // Case 1: recolor
                node.parent.color = BLACK
                uncle.color = BLACK
                grandparent.color = RED
                node = grandparent
            else:
                if node == node.parent.right:
                    // Case 2: left-rotate parent
                    node = node.parent
                    leftRotate(node)
                // Case 3: right-rotate grandparent
                node.parent.color = BLACK
                grandparent.color = RED
                rightRotate(grandparent)
        else:
            // mirror image of above
            uncle = grandparent.left
            if uncle and uncle.color == RED:
                node.parent.color = BLACK
                uncle.color = BLACK
                grandparent.color = RED
                node = grandparent
            else:
                if node == node.parent.left:
                    node = node.parent
                    rightRotate(node)
                node.parent.color = BLACK
                grandparent.color = RED
                leftRotate(grandparent)
    root.color = BLACK
```

### RBT Insert Example - Step by Step Tree Formation:

Let's insert values: 10, 20, 30, 15, 25, 12, 18 to demonstrate all fixInsert cases.

**Initial State:** Empty tree
```
NULL
```

**Step 1: Insert 10**
```
10(B)  // Root is always black
```

**Step 2: Insert 20**
```
  10(B)
    \
    20(R)  // New node is red, parent is black - NO VIOLATION
```

**Step 3: Insert 30**
```
  10(B)
    \
    20(R)
      \
      30(R)  // Red-Red violation! 20(R) -> 30(R)
```

**Fix Step 3:** Uncle is NULL (black), parent is right child, z is right child
Case 2b: Line case - recolor and left rotate
```
    20(B)
   /     \
10(R)   30(R)
```

**Step 4: Insert 15**
```
    20(B)
   /     \
10(R)   30(R)
  \
  15(R)  // Red-Red violation! 10(R) -> 15(R)
```

**Fix Step 4:** Uncle is 30(R) - RED UNCLE!
Case 1: Recolor parent, uncle, grandparent
```
    20(R)     // Grandparent becomes red
   /     \
10(B)   30(B)  // Parent and uncle become black
  \
  15(R)
```
Then root.color = BLACK (final step)
```
    20(B)
   /     \
10(B)   30(B)
  \
  15(R)
```

**Cases Demonstrated:**
1. **Case 1 (Uncle Red)**: Step 4 - Recolor parent, uncle, grandparent
2. **Case 2a (Triangle)**: Step 6 & 7 - Rotate to convert triangle to line
3. **Case 2b (Line)**: Step 3, 6, 7 - Recolor and rotate grandparent

**Key Insights:**
- New nodes are always inserted as RED
- Violations occur when red parent has red child
- Uncle's color determines the fix strategy
- Triangle cases need conversion to line cases first
- Root is always forced to BLACK at the end

### RBT - Delete Steps:
1. Start at the root node.
2. Delete the target key as in a standard BST.
3. If the deleted node or the node that replaces it is red, simply remove it (no violation).
4. If a black node is deleted or replaced, fix violations of Red-Black properties:
   - a) If the replacement node is red, color it black.
   - b) If the replacement node is black (or null), perform fix-up:
     - i. While the node is not the root and is black: Apply cases based on sibling color and children colors.
     - ii. Color node black.
5. Ensure the root is always black.

### RBT Delete Example - Step by Step Tree Formation:

Let's start with this Red-Black Tree and delete values to demonstrate all fixDelete cases.

**Initial Tree:**
```
    20(B)
   /     \
10(R)   30(B)
/  \    /    \
5(B) 15(B) 25(R) 40(R)
          /
        22(B)
```

**Detailed Case Analysis:**

**Case 1: Sibling is Red**
- Make sibling black, parent red
- Rotate parent towards deleted side
- Updates sibling reference
- Converts to Cases 2, 3, or 4

**Case 2: Sibling is Black, Both Nephews Black**
- Make sibling red (reduces black-height)
- Move double-black up to parent
- May propagate up the tree

**Case 3: Sibling is Black, Outer Nephew Black, Inner Nephew Red**
- Make inner nephew black, sibling red
- Rotate sibling away from deleted side
- Converts to Case 4

**Case 4: Sibling is Black, Outer Nephew Red**
- Copy parent's color to sibling
- Make parent and outer nephew black
- Rotate parent towards deleted side
- Terminates fix-up (sets node to root)

**Key Insights:**
- Deleting red nodes never causes violations
- Deleting black nodes may create "double-black" problems
- Sibling's color determines the fix strategy
- Cases 1 and 3 are conversion cases
- Cases 2 and 4 are terminal cases
- Fix-up may propagate up the tree in Case 2
- Always ensure final node is black

**Mirror Cases:**
- Left child cases are mirrored for right child cases
- Rotation directions are reversed
- Left/right nephew roles are swapped
- Same logical flow applies

## Balancing Explained
- Balancing is achieved by enforcing red-black properties after every insert and delete.
- Rotations and recoloring are used to restore properties.

## Complexity
- **Search**: O(log n)
- **Insert**: O(log n)
- **Delete**: O(log n)

## Applications
- Used in many libraries and systems (e.g., C++ STL map/set, Java TreeMap/TreeSet).
- Databases, memory management, and associative containers.

## Advantages
- Guarantees logarithmic height.
- Fewer rotations on average compared to AVL trees.
- Efficient for insertion and deletion-heavy workloads.

## Disadvantages
- Slightly slower lookups compared to AVL trees due to less strict balancing.
- More complex than simple BSTs.

## References
- "Introduction to Algorithms" by Cormen et al.
- Wikipedia: https://en.wikipedia.org/wiki/Red–black_tree

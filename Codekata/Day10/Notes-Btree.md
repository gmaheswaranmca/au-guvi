# B-Tree Notes

## Definition
- A B-Tree is a self-balancing search tree designed for systems that read and write large blocks of data (e.g., databases, filesystems).
- Generalizes binary search trees by allowing nodes to have more than two children.
- Optimized for minimizing disk I/O.

## Properties
- Each node contains a certain number of keys and children (except leaves).
- All leaves appear at the same level (tree is balanced).
- A B-Tree of order t (minimum degree) has:
  - Every node (except root) has at least t-1 keys and at most 2t-1 keys.
  - The root has at least 1 key.
  - Every internal node has at least t children and at most 2t children.
  - Keys within a node are sorted.
  - Children pointers separate the keys into intervals.

## Structure
Each node contains:
- **n**: number of keys
- **keys[1..n]**: sorted array of keys
- **children[0..n]**: pointers to child nodes (if not a leaf)
- **leaf**: boolean indicating if node is a leaf

## Operations

### Search Operation
- Similar to binary search within a node.
- At each node, perform binary search to find the key or the child to descend into.
- Time complexity: O(log n)

```pseudocode
search(node, key):
    i = 0
    while i < node.n and key > node.keys[i]:
        i += 1
    if i < node.n and key == node.keys[i]:
        return (node, i)
    elif node.leaf:
        return null
    else:
        return search(node.children[i], key)
```

### B-Tree - Search Steps:
1. Start at the root node.
2. For the current node:
   - a) Perform binary search among the keys.
   - b) If the key is found, return it.
   - c) If the node is a leaf and key not found, return null.
   - d) Otherwise, descend to the appropriate child and repeat.

### Insertion
- Always insert into a leaf node.
- If the leaf is full (2t-1 keys), split it:
  - Median key moves up to the parent.
  - Node splits into two nodes with t-1 keys each.
- If the parent is also full, recursively split up to the root.
- If the root splits, the tree height increases by 1.

```pseudocode
insert(key):
    if root is full:
        s = new node
        s.leaf = False
        s.children[0] = root
        splitChild(s, 0)
        root = s
    insertNonFull(root, key)

splitChild(parent, i):
    y = parent.children[i]
    z = new node
    z.leaf = y.leaf
    z.keys = y.keys[t:2t-1]
    if not y.leaf:
        z.children = y.children[t:2t]
    y.keys = y.keys[0:t-1]
    parent.children.insert(i+1, z)
    parent.keys.insert(i, y.keys[t-1])
```

### B-Tree - Insert Steps:
1. If the root is full, split it and increase the tree height.
2. Descend to the appropriate child recursively, splitting any full child encountered on the way down.
3. Insert the key into a non-full leaf node.

```pseudocode
insertNonFull(node, key):
    i = node.n - 1
    if node.leaf:
        node.keys.append(0)
        while i >= 0 and key < node.keys[i]:
            node.keys[i+1] = node.keys[i]
            i -= 1
        node.keys[i+1] = key
        node.n += 1
    else:
        while i >= 0 and key < node.keys[i]:
            i -= 1
        i += 1
        if node.children[i].n == 2*t - 1:
            splitChild(node, i)
            if key > node.keys[i]:
                i += 1
        insertNonFull(node.children[i], key)
```

### Deletion
- More complex than insertion.
- If the key is in a leaf, simply remove it.
- If the key is in an internal node:
  - If the child before or after the key has at least t keys, replace the key with its predecessor or successor and recursively delete.
  - If both children have t-1 keys, merge them and recursively delete.
- If a child has only t-1 keys, ensure it has at least t keys before descending (by borrowing from siblings or merging).

### B-Tree - Delete Steps:
1. Find the key to be deleted.
2. If the key is in a leaf, remove it.
3. If the key is in an internal node:
   - a) If the child before or after the key has at least t keys, replace the key with its predecessor or successor and recursively delete.
   - b) If both children have t-1 keys, merge them and recursively delete.
4. If descending into a child with t-1 keys, ensure it has at least t keys by borrowing or merging.

```pseudocode
delete(node, key):
    // See Cormen et al. for full details; deletion is complex and involves multiple cases.
```

## Complexity
- **Search**: O(log n)
- **Insert**: O(log n)
- **Delete**: O(log n)
- **Height of B-Tree**: O(log_t n), where t is the minimum degree.

## Applications
- Widely used in databases and filesystems (e.g., MySQL, SQLite, NTFS, ext4).
- Suitable for storage systems with large blocks/pages.

## Advantages
- Minimizes disk reads/writes by maximizing branching factor.
- Maintains balance with minimal restructuring.
- Efficient for large datasets and external storage.

## Disadvantages
- More complex implementation than binary search trees.
- Not as efficient for in-memory data structures with small datasets.

## Summary
- B-Trees are balanced, multi-way search trees optimized for disk and large block storage.
- They minimize disk I/O by maximizing the number of keys per node.
- Used extensively in database and filesystem implementations.

## References
- "Introduction to Algorithms" by Cormen et al.
- Wikipedia: https://en.wikipedia.org/wiki/B-tree

# Minimum Spanning Tree Construction - Kruskal's Algorithm

## Problem Overview
This program implements Kruskal's algorithm to find the Minimum Spanning Tree (MST) of a connected, undirected, weighted graph. The MST is a subset of edges that connects all vertices with the minimum total weight.

## Algorithm Explanation

### Kruskal's Algorithm Steps:
1. **Sort all edges** by weight in ascending order
2. **Initialize a Disjoint Set Union (DSU)** data structure
3. **Iterate through sorted edges** and add edge to MST if it doesn't create a cycle
4. **Continue until MST has (n-1) edges**

## Code Structure Analysis

### 1. Edge Class
```java
static class Edge implements Comparable<Edge> {
    int u, v;      // Source and destination vertices
    long w;        // Weight of the edge
    
    Edge(int u, int v, long w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    
    // Compare edges by weight for sorting
    public int compareTo(Edge other) {
        return Long.compare(this.w, other.w);
    }
}
```

**Purpose**: Represents an edge in the graph with source vertex `u`, destination vertex `v`, and weight `w`. The `Comparable` interface allows sorting edges by weight.

### 2. Disjoint Set Union (DSU) Class
```java
static class DSU {
    int[] parent, rank;
    
    DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
    }
    
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return false;
        if (rank[xr] < rank[yr]) parent[xr] = yr;
        else if (rank[xr] > rank[yr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}
```

**Purpose**: 
- **find(x)**: Finds the root parent of vertex x with path compression
- **union(x, y)**: Merges two sets containing x and y using union by rank
- **Cycle Detection**: If two vertices have the same root, adding an edge between them would create a cycle

## Step-by-Step Code Walkthrough

### Example: Sample Input
```
4 5
1 2 1
1 3 4
2 3 2
2 4 3
3 4 5
```

### Step 1: Input Reading
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] nm = br.readLine().split(" ");
int n = Integer.parseInt(nm[0]);  // n = 4 (vertices)
int m = Integer.parseInt(nm[1]);  // m = 5 (edges)
```

### Step 2: Edge Creation and Storage
```java
Edge[] edges = new Edge[m];
for (int i = 0; i < m; i++) {
    String[] uvw = br.readLine().split(" ");
    int u = Integer.parseInt(uvw[0]);
    int v = Integer.parseInt(uvw[1]);
    long w = Long.parseLong(uvw[2]);
    edges[i] = new Edge(u, v, w);
}
```

**Created edges array:**
- Edge(1, 2, 1)
- Edge(1, 3, 4)
- Edge(2, 3, 2)
- Edge(2, 4, 3)
- Edge(3, 4, 5)

### Step 3: Sort Edges by Weight
```java
Arrays.sort(edges);
```

**Sorted edges:**
1. Edge(1, 2, 1) - weight: 1
2. Edge(2, 3, 2) - weight: 2
3. Edge(2, 4, 3) - weight: 3
4. Edge(1, 3, 4) - weight: 4
5. Edge(3, 4, 5) - weight: 5

### Step 4: Initialize DSU and Process Edges
```java
DSU dsu = new DSU(n);
long total = 0;
int count = 0;
```

**Initial DSU state:**
- parent = [0, 1, 2, 3, 4]
- rank = [0, 0, 0, 0, 0]

### Step 5: Edge Processing Loop

#### Iteration 1: Edge(1, 2, 1)
```java
if (dsu.union(1, 2)) {  // Returns true (different sets)
    total += 1;         // total = 1
    count++;            // count = 1
}
```
- **DSU state**: parent = [0, 1, 1, 3, 4], Sets: {1,2}, {3}, {4}
- **MST edges**: [(1,2,1)]

#### Iteration 2: Edge(2, 3, 2)
```java
if (dsu.union(2, 3)) {  // Returns true (different sets)
    total += 2;         // total = 3
    count++;            // count = 2
}
```
- **DSU state**: parent = [0, 1, 1, 1, 4], Sets: {1,2,3}, {4}
- **MST edges**: [(1,2,1), (2,3,2)]

#### Iteration 3: Edge(2, 4, 3)
```java
if (dsu.union(2, 4)) {  // Returns true (different sets)
    total += 3;         // total = 6
    count++;            // count = 3
    if (count == n - 1) break;  // MST complete (3 edges for 4 vertices)
}
```
- **DSU state**: parent = [0, 1, 1, 1, 1], Sets: {1,2,3,4}
- **MST edges**: [(1,2,1), (2,3,2), (2,4,3)]

### Step 6: Output Result
```java
System.out.println(total);  // Output: 6
```

## Visual Representation

### Original Graph:
```
    1 -----(1)------ 2
    |               |
   (4)             (2)
    |               |
    3 -----(5)------ 4
         \     /
          (2) (3)
```

### Minimum Spanning Tree:
```
    1 -----(1)------ 2
                    / \
                  (2) (3)
                  /     \
                 3       4
```

**Total Weight**: 1 + 2 + 3 = 6

## Time and Space Complexity

### Time Complexity:
- **Sorting edges**: O(M log M)
- **DSU operations**: O(M α(N)) where α is inverse Ackermann function
- **Overall**: O(M log M)

### Space Complexity:
- **Edge storage**: O(M)
- **DSU arrays**: O(N)
- **Overall**: O(M + N)

## Key Points

1. **Greedy Approach**: Always pick the minimum weight edge that doesn't create a cycle
2. **Cycle Detection**: Uses DSU to efficiently detect cycles in O(α(N)) time
3. **Optimizations**: 
   - Path compression in `find()`
   - Union by rank in `union()`
   - Early termination when MST is complete
4. **Edge Cases**: Handles single edge graphs and ensures connectivity

## Test Case Analysis

For the given test case:
- **Input**: 4 vertices, 5 edges
- **MST edges**: (1,2,1), (2,3,2), (2,4,3)
- **Total weight**: 6
- **Edges considered**: 3 out of 5 (optimal)

This implementation efficiently finds the MST using Kruskal's algorithm with optimal time complexity.

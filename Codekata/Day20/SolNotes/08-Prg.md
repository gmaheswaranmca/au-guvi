# Maximum Bipartite Matching using Network Flow - Comprehensive Explanation

## Problem Overview
This program solves the Maximum Bipartite Matching problem using the Ford-Fulkerson method for network flow. Given a bipartite graph with nodes on left side (U) and right side (V), it finds the maximum number of edges such that no two edges share a node.

## Algorithm Explanation

### Network Flow Approach to Bipartite Matching
The key insight is to transform the bipartite matching problem into a maximum flow problem:

1. **Create a flow network** with source S and sink T
2. **Connect source to all left nodes** (U) with capacity 1
3. **Connect all right nodes** (V) to sink with capacity 1
4. **Add original edges** between U and V with capacity 1
5. **Find maximum flow** from S to T = Maximum matching

### Why This Works
- Each unit of flow corresponds to one matching edge
- Capacity constraints ensure no node is matched more than once
- Maximum flow = Maximum matching (König's theorem)

## Code Structure Analysis

### 1. Edge Class
```java
static class Edge {
    int to, rev;    // destination node, reverse edge index
    int cap;        // current capacity
    Edge(int to, int rev, int cap) {
        this.to = to;
        this.rev = rev;
        this.cap = cap;
    }
}
```

**Purpose**: Represents a directed edge in the flow network
- **to**: Destination vertex
- **rev**: Index of reverse edge in destination's adjacency list
- **cap**: Current capacity (0 or 1 for this problem)

### 2. Graph Representation
```java
static ArrayList<Edge>[] graph;  // Adjacency list representation
static boolean[] visited;        // DFS visited array
```

**Data Structures**:
- **graph[]**: Array of ArrayLists, each containing edges from that vertex
- **visited[]**: Boolean array to track visited nodes during DFS

### 3. Add Edge Function
```java
static void addEdge(int from, int to) {
    graph[from].add(new Edge(to, graph[to].size(), 1));
    graph[to].add(new Edge(from, graph[from].size() - 1, 0));
}
```

**Purpose**: Adds a directed edge with capacity 1 and its reverse edge with capacity 0
- **Forward edge**: from → to with capacity 1
- **Reverse edge**: to → from with capacity 0 (for flow reversal)

### 4. DFS Function (Ford-Fulkerson)
```java
static boolean dfs(int v, int t) {
    if (v == t) return true;
    visited[v] = true;
    for (Edge e : graph[v]) {
        if (e.cap > 0 && !visited[e.to]) {
            if (dfs(e.to, t)) {
                e.cap -= 1;
                graph[e.to].get(e.rev).cap += 1;
                return true;
            }
        }
    }
    return false;
}
```

**Purpose**: Finds an augmenting path from source to sink using DFS
- **Base case**: If reached sink, return true
- **Explore edges**: Only traverse edges with positive capacity
- **Update capacities**: Decrease forward edge, increase reverse edge
- **Backtrack**: If path found, update capacities along the path

### 5. Maximum Flow Function
```java
static int maxFlow(int s, int t) {
    int flow = 0;
    while (true) {
        visited = new boolean[graph.length];
        if (!dfs(s, t)) break;
        flow++;
    }
    return flow;
}
```

**Purpose**: Repeatedly finds augmenting paths until no more exist
- **Initialize**: Reset visited array for each iteration
- **Find path**: Use DFS to find augmenting path
- **Update flow**: Increment flow counter for each path found
- **Terminate**: Stop when no augmenting path exists

## Step-by-Step Walkthrough with Sample Input

### Sample Input:
```
3 3
4
1 1
1 2
2 2
3 3
```

### Graph Construction:

#### Step 1: Initialize Flow Network
- **N = 3** (left nodes), **M = 3** (right nodes)
- **S = 0** (source), **T = 7** (sink)
- **Total nodes**: 8 (0, 1, 2, 3, 4, 5, 6, 7)

#### Step 2: Node Mapping
- **Source**: 0
- **Left nodes (U)**: 1, 2, 3
- **Right nodes (V)**: 4, 5, 6 (N + 1, N + 2, N + 3)
- **Sink**: 7

#### Step 3: Add Source to Left Edges
```java
// Source to U
for (int i = 1; i <= N; i++) addEdge(S, i);
```
- **Edge 0→1**: capacity 1
- **Edge 0→2**: capacity 1
- **Edge 0→3**: capacity 1

#### Step 4: Add Right to Sink Edges
```java
// V to Sink
for (int i = 1; i <= M; i++) addEdge(N + i, T);
```
- **Edge 4→7**: capacity 1
- **Edge 5→7**: capacity 1
- **Edge 6→7**: capacity 1

#### Step 5: Add Bipartite Edges
```java
// Original edges: (1,1), (1,2), (2,2), (3,3)
// Mapped to: (1,4), (1,5), (2,5), (3,6)
```
- **Edge 1→4**: capacity 1
- **Edge 1→5**: capacity 1
- **Edge 2→5**: capacity 1
- **Edge 3→6**: capacity 1

### Flow Network Visualization:
```
    Source(0)
   /    |    \
  1     2     3    (Left nodes)
 /|\    |     |
4  5    5     6    (Right nodes)
 \ |    |    /
  \|    |   /
   Sink(7)
```

### Maximum Flow Execution:

#### Iteration 1: Find First Augmenting Path
**DFS from 0 to 7:**
- **Path**: 0 → 1 → 4 → 7
- **Capacity**: min(1, 1, 1) = 1
- **Update**: Decrease forward edges, increase reverse edges
- **Flow**: 1

**Updated capacities:**
- 0→1: 0, 1→0: 1
- 1→4: 0, 4→1: 1
- 4→7: 0, 7→4: 1

#### Iteration 2: Find Second Augmenting Path
**DFS from 0 to 7:**
- **Path**: 0 → 2 → 5 → 7
- **Capacity**: min(1, 1, 1) = 1
- **Update**: Decrease forward edges, increase reverse edges
- **Flow**: 2

#### Iteration 3: Find Third Augmenting Path
**DFS from 0 to 7:**
- **Path**: 0 → 3 → 6 → 7
- **Capacity**: min(1, 1, 1) = 1
- **Update**: Decrease forward edges, increase reverse edges
- **Flow**: 3

#### Iteration 4: No More Augmenting Paths
**DFS from 0 to 7:**
- **0→1**: capacity 0 (already used)
- **0→2**: capacity 0 (already used)
- **0→3**: capacity 0 (already used)
- **Result**: No path found, terminate

### Final Result:
**Maximum Flow = 3**

### Matching Interpretation:
The flow corresponds to the matching:
- **Left node 1 ↔ Right node 1**
- **Left node 2 ↔ Right node 2**
- **Left node 3 ↔ Right node 3**

## Algorithm Complexity Analysis

### Time Complexity:
- **DFS per iteration**: O(V + E) where V = N + M + 2, E = edges in flow network
- **Maximum iterations**: O(min(N, M)) (at most min(N,M) matching edges)
- **Overall**: O((N + M) × E × min(N, M))
- **For complete bipartite graph**: O(N × M × min(N, M))

### Space Complexity:
- **Graph storage**: O(N + M + E)
- **Visited array**: O(N + M)
- **Overall**: O(N + M + E)

## Key Implementation Details

### 1. Reverse Edge Mechanism
```java
graph[from].add(new Edge(to, graph[to].size(), 1));
graph[to].add(new Edge(from, graph[from].size() - 1, 0));
```
- **Forward edge**: Real edge with capacity 1
- **Reverse edge**: Allows flow reversal (undo previous decisions)
- **rev field**: Points to corresponding reverse edge for quick access

### 2. Flow Network Construction
```java
// Network topology:
// Source(0) → U(1..N) → V(N+1..N+M) → Sink(N+M+1)
int S = 0;
int T = N + M + 1;
int size = N + M + 2;
```

### 3. Capacity Updates
```java
e.cap -= 1;                           // Decrease forward edge
graph[e.to].get(e.rev).cap += 1;      // Increase reverse edge
```

## Alternative Approaches

### 1. Hungarian Algorithm
- **Time**: O(N³)
- **Space**: O(N²)
- **Best for**: Dense bipartite graphs

### 2. Hopcroft-Karp Algorithm
- **Time**: O(E√V)
- **Space**: O(V)
- **Best for**: General bipartite matching

### 3. Augmenting Path (Direct)
- **Time**: O(VE)
- **Space**: O(V)
- **Best for**: Simple implementation

## Edge Cases Handled

1. **Complete matching**: When all nodes can be matched
2. **Partial matching**: When some nodes cannot be matched
3. **Single node sides**: N=1 or M=1
4. **No edges**: E=0, result is 0
5. **Multiple edges**: Between same pair (handled by capacity)

## Visual Example - Test Case 3

### Input:
```
3 3
2
1 2
2 3
```

### Flow Network:
```
    0 (Source)
   /||\
  1 2 3
  | | |
  4 5 6
   \|/
    7 (Sink)
```

**Available edges**: 1→5, 2→6

### Execution:
1. **Path 1**: 0→1→5→7 (flow = 1)
2. **Path 2**: 0→2→6→7 (flow = 2)
3. **No more paths**: Node 3 cannot reach any unmatched right node

**Result**: Maximum matching = 2

## Practical Applications

1. **Job Assignment**: Assign workers to jobs
2. **Resource Allocation**: Distribute resources optimally
3. **Network Design**: Design efficient communication networks
4. **Matching Systems**: Dating apps, course registration
5. **Scheduling**: Assign time slots to events

## Conclusion

This implementation efficiently solves the Maximum Bipartite Matching problem using network flow:

- **Transforms** bipartite matching into maximum flow
- **Uses Ford-Fulkerson** with DFS to find augmenting paths
- **Handles** reverse edges for flow optimization
- **Provides** optimal solution for bipartite graphs

The algorithm is particularly effective for moderate-sized bipartite graphs and provides a clear understanding of the relationship between network flow and matching problems.

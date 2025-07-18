ALGORITHMS - BEGINNER LEVEL INTERVIEW QUESTIONS (SET 2)
======================================================

**Target:** IT, CS, AI, ML, ECE candidates
**Level:** Beginner
**Companies:** Google, Amazon, Microsoft, Facebook, Zoho, etc.
**Category:** Algorithms (Extended Set)

**GREEDY ALGORITHMS**
1. What is a greedy algorithm? (Google, Amazon)
2. What are the characteristics of greedy algorithms? (Microsoft, Zoho)
3. What is the coin change problem using greedy approach? (Facebook, Google)
4. What is the activity selection problem? (Amazon, Microsoft)
5. What is the fractional knapsack problem? (Zoho, Facebook)
6. What is Huffman coding algorithm? (Google, Amazon)
7. What are the advantages and disadvantages of greedy algorithms? (Microsoft, Zoho)
8. When does a greedy algorithm give optimal solution? (Facebook, Google)

**DYNAMIC PROGRAMMING**
9. What is dynamic programming? (Amazon, Microsoft)
10. What is the difference between recursion and dynamic programming? (Zoho, Facebook)
11. What is memoization in dynamic programming? (Google, Amazon)
12. What is tabulation in dynamic programming? (Microsoft, Zoho)
13. What is the 0/1 knapsack problem? (Facebook, Google)
14. What is the longest common subsequence problem? (Amazon, Microsoft)
15. What is the Fibonacci sequence using dynamic programming? (Zoho, Facebook)
16. What is the coin change problem using dynamic programming? (Google, Amazon)
17. What are overlapping subproblems? (Microsoft, Zoho)
18. What is optimal substructure property? (Facebook, Google)

**BACKTRACKING ALGORITHMS**
19. What is backtracking? (Amazon, Microsoft)
20. What is the N-Queens problem? (Zoho, Facebook)
21. What is the subset sum problem using backtracking? (Google, Amazon)
22. What is the rat in maze problem? (Microsoft, Zoho)
23. What is the knight's tour problem? (Facebook, Google)
24. What is the difference between backtracking and brute force? (Amazon, Microsoft)
25. What is pruning in backtracking? (Zoho, Facebook)

**GRAPH ALGORITHMS**
26. What is breadth-first search (BFS)? (Google, Amazon)
27. What is depth-first search (DFS)? (Microsoft, Zoho)
28. What is the difference between BFS and DFS? (Facebook, Google)
29. What is the time complexity of BFS and DFS? (Amazon, Microsoft)
30. What is topological sorting? (Zoho, Facebook)
31. What is Dijkstra's shortest path algorithm? (Google, Amazon)
32. What is the minimum spanning tree? (Microsoft, Zoho)
33. What is Kruskal's algorithm? (Facebook, Google)
34. What is Prim's algorithm? (Amazon, Microsoft)
35. What is cycle detection in graphs? (Zoho, Facebook)

**STRING ALGORITHMS**
36. What is string matching? (Google, Amazon)
37. What is the naive string matching algorithm? (Microsoft, Zoho)
38. What is the KMP (Knuth-Morris-Pratt) algorithm? (Facebook, Google)
39. What is the Rabin-Karp algorithm? (Amazon, Microsoft)
40. What is the longest common prefix problem? (Zoho, Facebook)
41. What is palindrome checking algorithm? (Google, Amazon)
42. What is string reversal algorithm? (Microsoft, Zoho)
43. What is anagram detection algorithm? (Facebook, Google)

**MATHEMATICAL ALGORITHMS**
44. What is the Euclidean algorithm for GCD? (Amazon, Microsoft)
45. What is the sieve of Eratosthenes? (Zoho, Facebook)
46. What is fast exponentiation algorithm? (Google, Amazon)
47. What is the algorithm to check if a number is prime? (Microsoft, Zoho)
48. What is the algorithm to find factorial of a number? (Facebook, Google)
49. What is the algorithm to generate Fibonacci numbers? (Amazon, Microsoft)
50. What is the algorithm to check if a number is perfect? (Zoho, Facebook)

**QUESTION DIFFICULTY DISTRIBUTION:**
- Very Basic: Questions 1-15 (Greedy basics, DP fundamentals)
- Basic: Questions 16-30 (Advanced DP, Backtracking, Basic graphs)
- Intermediate Basic: Questions 31-45 (Graph algorithms, String algorithms)
- Concept Application: Questions 46-50 (Mathematical algorithms)

**ADVANCED ALGORITHM PARADIGMS:**
1. **Greedy Algorithms** - Make locally optimal choices
2. **Dynamic Programming** - Solve overlapping subproblems
3. **Backtracking** - Try all possibilities with pruning
4. **Graph Algorithms** - Process connected data structures
5. **String Algorithms** - Process text and pattern matching
6. **Mathematical Algorithms** - Number theory and arithmetic

**ALGORITHM COMPLEXITY ANALYSIS:**
**Greedy Algorithms:**
- Activity Selection: O(n log n) time
- Fractional Knapsack: O(n log n) time
- Huffman Coding: O(n log n) time

**Dynamic Programming:**
- 0/1 Knapsack: O(nW) time, O(nW) space
- LCS: O(mn) time, O(mn) space
- Fibonacci: O(n) time, O(n) space

**Graph Algorithms:**
- BFS: O(V + E) time, O(V) space
- DFS: O(V + E) time, O(V) space
- Dijkstra: O(V²) or O(E log V) time

**String Algorithms:**
- Naive Matching: O(nm) time
- KMP: O(n + m) time
- Rabin-Karp: O(nm) worst case, O(n + m) average

**PROBLEM-SOLVING STRATEGIES:**
1. **Understand the Problem** - Read requirements carefully
2. **Identify the Pattern** - Recognize algorithm type
3. **Choose the Approach** - Select appropriate paradigm
4. **Implement the Solution** - Write clean, efficient code
5. **Test and Optimize** - Verify correctness and efficiency

**WHEN TO USE WHICH ALGORITHM:**
- **Greedy**: When local optimal leads to global optimal
- **Dynamic Programming**: When there are overlapping subproblems
- **Backtracking**: When you need to explore all possibilities
- **Divide and Conquer**: When problem can be split into subproblems
- **BFS**: When you need shortest path in unweighted graph
- **DFS**: When you need to explore all paths or detect cycles

**OPTIMIZATION TECHNIQUES:**
- **Memoization**: Top-down DP approach
- **Tabulation**: Bottom-up DP approach
- **Pruning**: Skip unnecessary computations in backtracking
- **Heuristics**: Use domain knowledge to guide search
- **Parallel Processing**: Divide work across multiple cores

**REAL-WORLD APPLICATIONS:**
- **Greedy**: Task scheduling, resource allocation
- **Dynamic Programming**: Optimization problems, game theory
- **Backtracking**: Puzzle solving, constraint satisfaction
- **Graph Algorithms**: Social networks, routing, web crawling
- **String Algorithms**: Text editors, search engines, bioinformatics
- **Mathematical**: Cryptography, computer graphics, statistics

**COMMON ALGORITHMIC PATTERNS:**
- **Two Pointers**: Array problems, string problems
- **Sliding Window**: Subarray problems, string matching
- **Fast and Slow Pointers**: Cycle detection, middle finding
- **Merge Intervals**: Overlapping intervals, scheduling
- **Prefix Sum**: Range queries, subarray problems
- **Binary Search**: Search in sorted arrays, optimization

**DEBUGGING ALGORITHM IMPLEMENTATIONS:**
- **Greedy**: Check if greedy choice leads to optimal solution
- **DP**: Verify recurrence relation and base cases
- **Backtracking**: Ensure proper pruning and backtracking
- **Graph**: Check for proper visited node handling
- **String**: Verify boundary conditions and pattern matching
- **Mathematical**: Check for overflow and edge cases

**FOLLOW-UP QUESTIONS TO EXPECT:**
- Can you optimize this algorithm further?
- What are the space-time tradeoffs?
- How would you handle very large inputs?
- Can you implement this iteratively instead of recursively?
- What are the edge cases for this algorithm?
- How would you test this implementation?

**COMPANY-SPECIFIC ALGORITHM PREFERENCES:**
- **Google**: Graph algorithms, string processing, optimization
- **Amazon**: Dynamic programming, greedy algorithms, scalability
- **Microsoft**: Mathematical algorithms, recursive solutions
- **Facebook**: Graph algorithms, string algorithms, data processing
- **Zoho**: Basic implementations, logical problem-solving

**ALGORITHM DESIGN CHECKLIST:**
1. **Correctness**: Does it solve the problem correctly?
2. **Efficiency**: Is it time and space efficient?
3. **Simplicity**: Is it easy to understand and implement?
4. **Robustness**: Does it handle edge cases?
5. **Scalability**: Does it work for large inputs?
6. **Maintainability**: Is the code clean and readable?

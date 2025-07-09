# Trie Notes

## Definition
- A Trie (pronounced "try"), also known as a prefix tree or digital tree, is a tree-like data structure used to store a dynamic set of strings, typically for retrieval by prefix.
- Each node represents a single character of a string.

## Properties
- The root node is usually empty and does not correspond to any character.
- Each edge represents a character.
- Each path from the root to a node represents a prefix of the stored strings.
- Nodes may store a flag indicating if they mark the end of a valid word.

## Structure
Each node contains:
- A map or array of child pointers (one for each possible character).
- A boolean flag (isEndOfWord) to indicate if the node represents the end of a word.

## Operations

### Search Operation
- Start at the root.
- For each character in the search string, follow the corresponding child pointer.
- If a pointer is missing, the string is not present.
- If all characters are found and the last node is marked as end of word, the string exists.

```pseudocode
search(root, word):
    node = root
    for char in word:
        if char not in node.children:
            return False
        node = node.children[char]
    return node.isEndOfWord
```

### Trie - Search Steps:
1. Start at the root node.
2. For each character in the word:
   - a) If the character does not exist as a child, return False.
   - b) Move to the child node.
3. After the last character, return True if the node is marked as end of word.

### Insertion
- Start at the root.
- For each character in the word, create a child node if it does not exist.
- After the last character, mark the node as end of word.

```pseudocode
insert(root, word):
    node = root
    for char in word:
        if char not in node.children:
            node.children[char] = new TrieNode()
        node = node.children[char]
    node.isEndOfWord = True
```

### Trie - Insert Steps:
1. Start at the root node.
2. For each character in the word:
   - a) If the character does not exist as a child, create a new node.
   - b) Move to the child node.
3. After the last character, mark the node as end of word.

### Deletion
- Recursively traverse the trie to the end of the word.
- Unmark the end of word flag.
- Optionally, remove nodes that are no longer needed (i.e., nodes that are not prefixes of other words).

```pseudocode
delete(node, word, depth=0):
    if depth == len(word):
        if not node.isEndOfWord:
            return False
        node.isEndOfWord = False
        return len(node.children) == 0
    char = word[depth]
    if char not in node.children:
        return False
    shouldDelete = delete(node.children[char], word, depth+1)
    if shouldDelete:
        del node.children[char]
        return not node.isEndOfWord and len(node.children) == 0
    return False
```

### Trie - Delete Steps:
1. Recursively traverse to the end of the word.
2. Unmark the end of word flag.
3. Remove nodes that are no longer needed (i.e., not prefixes for other words).

### Prefix Search Steps:
1. Start at the root node.
2. For each character in the prefix:
   - a) If the character does not exist as a child, return False.
   - b) Move to the child node.
3. After the last character, return True (prefix exists).

## Example with Text Diagram

### Trie Example: Dictionary Words

Let's insert these words: "CAT", "CAR", "CARD", "CARE", "CAREFUL", "CATS", "DOG"

#### Step-by-Step Insertion:

**#1. Insert "CAT":**
```
    ROOT
    |
    C
    |
    A
    |
    T*
```

**#2. Insert "CAR":**
```
    ROOT
    |
    C
    |
    A
   / \
  T*  R*
```

**#3. Insert "CARD":**
```
    ROOT
    |
    C
    |
    A
   / \
  T*  R*
      |
      D*
```

**#4. Insert "CARE":**
```
    ROOT
    |
    C
    |
    A
   / \
  T*  R*
     / \
    D*  E*
```

**#5. Insert "CAREFUL":**
```
    ROOT
    |
    C
    |
    A
   / \
  T*  R*
     / \
    D*  E*
        |
        F
        |
        U
        |
        L*
```

**#6. Insert "CATS":**
```
    ROOT
     |
     C
     |
     A
    / \
   T*  R*
   |  / \
  S* D* E*
        |
        F
        |
        U
        |
        L*
```

**#7. Insert "DOG":**
```
    ROOT
   /   \
  C     D
  |     |
  A     O
 / \    |
T*  R*  G*
|  / \
S* D* E*
      |
      F
      |
      U
      |
      L*
```

#### Final Complete Trie Structure:
```
    ROOT
   /   \
  C     D
  |     |
  A     O
 / \    |
T*  R*  G*
|  / \
S* D* E*
      |
      F
      |
      U
      |
      L*
```

**Legend:** `*` = End of word marker (isEndOfWord = true)

### Trie Properties Demonstrated:

1. **Shared Prefixes**: "CAR", "CARD", "CARE", "CAREFUL" all share "CAR"
2. **Root is Empty**: ROOT node contains no character
3. **Path = Word**: Each path from root to `*` represents a complete word
4. **Efficient Storage**: Common prefixes stored only once

### Search Examples:

**Search "CAR":**
- ROOT → C → A → R* ✅ (Found, ends with *)

**Search "CARD":**
- ROOT → C → A → R → D* ✅ (Found, ends with *)

**Search "CA":**
- ROOT → C → A ❌ (Not found, no * marker)

**Search "CAMERA":**
- ROOT → C → A → ? ❌ (Path doesn't exist)

## Complexity
- **Search**: O(L), where L is the length of the word.
- **Insert**: O(L)
- **Delete**: O(L)
- **Space**: O(N * L * A), where N is the number of words, L is average word length, and A is the alphabet size.

**Time Complexity:**
- Search/Insert/Delete: O(L) where L = length of word
- Space: O(N × L × A) where N = number of words, A = alphabet size

This Trie efficiently stores 7 words using shared prefixes, demonstrating why it's perfect for autocomplete, spell-checkers, and dictionary implementations!

## Applications
- Autocomplete and spell-checking.
- IP routing (longest prefix matching).
- Dictionary implementations.
- Word games and search engines.

## Advantages
- Fast prefix-based lookups.
- Efficient for storing large sets of strings with shared prefixes.

## Disadvantages
- Can use more memory than other data structures (e.g., hash tables) for sparse datasets.
- Not suitable for non-string or non-prefix-based queries.

## Summary
- Tries are efficient for prefix-based operations and storing dictionaries of words.
- They support fast insert, search, and prefix queries.
- Widely used in text processing, autocomplete, and search applications.

## References
- "Introduction to Algorithms" by Cormen et al.
- Wikipedia: https://en.wikipedia.org/wiki/Trie

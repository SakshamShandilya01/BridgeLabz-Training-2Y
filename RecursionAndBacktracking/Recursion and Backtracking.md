**Problem 1: Understanding Recursion Mechanics**

a) Recursive Function (Pseudocode)

&#x20;  function getDirectorySize(directory, visited):

&#x20;   if directory in visited:

&#x20;       return 0       visited.add(directory)



&#x20;   totalSize = 0

&#x20;   for each item in directory:

&#x20;       if item is a file:

&#x20;           totalSize += item.size  

&#x20;       else if item is a directory:

&#x20;           totalSize += getDirectorySize(item, visited)  

&#x20;   return totalSize







b) Execution Trace (Call Stack)

&#x20;  getDirectorySize(project)

&#x20;├── getDirectorySize(src)

&#x20;│     ├── main.java → 100 KB

&#x20;│     └── utils.java → 50 KB

&#x20;│     → returns 150 KB

&#x20;├── getDirectorySize(docs)

&#x20;│     ├── readme.txt → 10 KB

&#x20;│     └── getDirectorySize(guides)

&#x20;│           └── setup.pdf → 200 KB

&#x20;│           → returns 200 KB

&#x20;│     → returns 210 KB

&#x20;└── config.xml → 20 KB

Final total = 150 + 210 + 20 = 380 KB







c) Time Complexity

Each file/directory is visited once.



If there are 

𝑛

&#x20;total items (files + directories):



𝑇(𝑛)=𝑂(𝑛)

Linear in the number of entries.







d) Iterative Approach

Yes, possible using a stack (DFS) or queue (BFS).



Recursive → elegant, uses call stack implicitly.



Iterative → explicit stack/queue, avoids recursion depth limits.



Both have O(n) complexity, but iterative gives more control.







e) Handling Cycles (Symbolic Links)

Problem: Symbolic links can create cycles → infinite recursion.



Solution: Track visited directories.



If directory already visited → return 0.











**Problem 2: Backtracking Template Application**

a) Backtracking Algorithm (Pseudocode)

&#x20;  function searchWord(grid, word, index, row, col, visited):

&#x20;   if index == length(word):

&#x20;       return true   

&#x20;   

&#x20;   if (row, col) out of bounds OR grid\[row]\[col] != word\[index] OR (row,col) in visited:

&#x20;       return false     

&#x20;   visited.add((row, col))      

&#x20;   // Explore all 8 directions (horizontal, vertical, diagonal)

&#x20;   for each (dr, dc) in directions:

&#x20;       if searchWord(grid, word, index+1, row+dr, col+dc, visited):

&#x20;           return true

&#x20;   

&#x20;   visited.remove((row, col)) 

&#x20;   return false







b) Decision Tree for “DREAM”

Start at D (row=2, col=0) →



Next letter R found at (1,1).



Next letter E found at (2,1).



Next letter A found at (2,2).



Next letter M found at (2,3).







c) Execution Trace

Start at D (2,0) → matches word\[0].



Move to R (1,1) → matches word\[1].



Move to E (2,1) → matches word\[2].



Move to A (2,2) → matches word\[3].



Move to M (2,3) → matches word\[4].



Word complete → return true.







d) Worst‑Case Time Complexity

Grid size = 𝑁×𝑀.



Word length = 𝐿.



At each step, up to 8 choices.



𝑇(𝑁,𝑀,𝐿)=𝑂(𝑁⋅*M.*8^𝐿)

Because we may start at any cell and explore up to 8 branches per letter.



In practice, pruning (constraints) reduces search space.







e) Finding All Possible Ways

Modify algorithm to collect all successful paths instead of returning after first success.



Use a list of paths (array of coordinates or strings).



Each time goal condition is met → append path to results.











**Problem 3: N‑Queens Optimization and Variants**

a) Search Space Analysis

Brute force (no constraints):  

Each queen can be placed in any of 64 squares.



64^8≈2.8×10^14

possibilities.



With “one queen per row” constraint:  

Each of 8 rows has 8 choices →



8^8=16,777,216

possibilities.



Backtracking exploration:



Prunes invalid placements early (same column/diagonal conflicts).



Actual explored states ≪ 8^8.



In practice, only a few million states are checked before solutions are found.







b) Optimized N‑Queens Solution (Pseudocode)

&#x20; function solveNQueens(n):

&#x20;   board = array of size n   

&#x20;   cols = boolean\[n]         

&#x20;   diag1 = boolean\[2n]       

&#x20;   diag2 = boolean\[2n]          

&#x20;   function backtrack(row):

&#x20;       if row == n:

&#x20;           recordSolution(board)

&#x20;           return

&#x20;       

&#x20;       for col in 0..n-1:

&#x20;           if not cols\[col] and not diag1\[row+col] and not diag2\[row-col+n]:

&#x20;               board\[row] = col

&#x20;               cols\[col] = diag1\[row+col] = diag2\[row-col+n] = true

&#x20;               

&#x20;               backtrack(row+1)

&#x20;               

&#x20;              

&#x20;               cols\[col] = diag1\[row+col] = diag2\[row-col+n] = false

&#x20;   

&#x20;   backtrack(0)







c) Trace for N=4

Row 0: Place queen at col 1 → board = \[1, \_, \_, \_].



Row 1: Try col 3 → board = \[1, 3, \_, \_].



Row 2: No valid col → backtrack.



Row 1: Try col 0 → board = \[1, 0, \_, \_].



Row 2: Place col 2 → board = \[1, 0, 2, \_].



Row 3: Place col 3 → board = \[1, 0, 2, 3].







d) Finding Just ONE Solution Quickly

Modify backtracking to return immediately after first valid solution.



Stop recursion once solution recorded.



Saves time compared to exploring all solutions.







e) N‑Queens with Forbidden Squares

Add constraint:



pseudo

if (row,col) is forbidden → skip

Impact:



Reduces available choices.



May eliminate some solutions entirely.



Complexity remains exponential, but pruning is stronger.




























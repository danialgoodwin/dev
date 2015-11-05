Contents
--------

[For Interview](#For_Interview)

[FAQs](#FAQs)

[Sorting Algorithms](#Sorting_Algorithms)

-   [Bubble Sort: O(n\^2), O(1) space](#Bubble_Sort:_O.28n.5E2.29.2C_O.281.29_space)
-   [Insertion Sort: O(n\^2) time, O(1) space](#Insertion_Sort:_O.28n.5E2.29_time.2C_O.281.29_space)
-   [Selection Sort: T(n\^2) time, O(1) space](#Selection_Sort:_.CE.98.28n.5E2.29_time.2C_O.281.29_space)
-   [Shell Sort: O(...) time, O(1) space](#Shell_Sort:_O.28....29_time.2C_O.281.29_space)
-   [Merge Sort: O(n log n) time, O(n) space](#Merge_Sort:_O.28n_log_n.29_time.2C_O.28n.29_space)
-   [Quick Sort: O(n log n) time, O(...) space](#Quick_Sort:_O.28n_log_n.29_time.2C_O.28....29_space)
-   [Heap Sort: O(n log n) time, O(1) space](#Heap_Sort:_O.28n_log_n.29_time.2C_O.281.29_space)
-   [Bucket Sort: O(n) time, O(...) space](#Bucket_Sort:_O.28n.29_time.2C_O.28....29_space)
-   [Counting Sort: O(n) time, O(n) space](#Counting_Sort:_O.28n.29_time.2C_O.28n.29_space)
-   [Radix Sort: O(n) time, O(q) space](#Radix_Sort:_O.28n.29_time.2C_O.28q.29_space)

[Traversal Algorithms](#Traversal_Algorithms)

-   [Kruskal's Algorithm (Greedy)](#Kruskal.27s_Algorithm_.28Greedy.29)

[Selection](#Selection)

-   [Quick Select](#Quick_Select)

* * * * *

For Interview
-------------

-   Sorting approaches
-   Searching approaches
-   Brute-force approach
-   Greedy approaches
-   Task Scheduling algorithm
-   Huffman codes
-   Longest common subsequence
-   Naive string matching
-   Rabin-Karp algorithm
-   NP-completeness algorithms
-   Red-Black trees
-   B-Trees
-   Graph traversals
-   Hash tables

-   Compress string
-   Partition the array of balls
-   Adding two n-bit binary integers
-   Trie data structure to store words
-   Algorithm to do wild card string matching
-   Convert a BST into a linked list
-   N-ary tree
-   Graph's breath first traversal
-   Shuffling a deck of cards

FAQs
----

Q: What is an algorithm?

A: Step by step procedures on how to do something.

Q: What's the best way to start learning algorithms?

A: [This top Quora answer](http://www.quora.com/Which-are-the-10-algorithms-every-computer-science-student-must-implement-at-least-once-in-life "http://www.quora.com/Which-are-the-10-algorithms-every-computer-science-student-must-implement-at-least-once-in-life") gives a great overview of the different areas of algorithms

A: Email me for all the slides, practice problems, and solutions from my algorithms course.

A: [Stanford's algorithms course lectures](https://class.coursera.org/algo-004/lecture/preview "https://class.coursera.org/algo-004/lecture/preview") (Mainly Videos)

A: (Video) [Big-O Notation](http://www.youtube.com/watch?v=V6mKVRU1evU "http://www.youtube.com/watch?v=V6mKVRU1evU")

A: (Advanced) After reviewing the above, you will find this cheat sheet very helpful: ([link](http://bigocheatsheet.com/ "http://bigocheatsheet.com/"))

A: (Advanced) Great website for coders, many advanced concepts ([link](http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=alg_index "http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=alg_index"))

Q: Is there any math involved?

A: Some parts may look like calculus, but the only math is dealing with polynomials. You should have a general idea of what the following graphs look like (when x \>= 0) and how they appear compared to each other, especially at large numbers, like 10,000 is a common large number.

-   y = 1
-   y = x
-   y = log(x)
-   y = x\^2
-   y = x!
-   y = 2\^x
-   y = x\^x

You don't ever need to draw these graphs, you'll just have to compare them when x is a large number.

When you see a polynomial like 2x\^5 + 200x\^4 - 6x\^3 + 20x\^2 - 10,000x, then you will have to be able to find the largest power, and ignore all coefficients and constants. Answer: x\^5.

And, there will be a little bit of counting involved.

Sorting Algorithms
------------------

### Bubble Sort: O(n\^2), O(1) space

Never use this.

-   Best case: Already balanced. Thus, linear time. O(n).

### Insertion Sort: O(n\^2) time, O(1) space

Like bubble sort, but bring sorted data to front rather than end. Don't need to use this one either.

-   Good case: Balanced search tree. Thus, log linear time.
-   Best case: Already balanced. Thus, linear time. O(n).

### Selection Sort: T(n\^2) time, O(1) space

1.  Iterate through array to find min.
2.  Swap with first unsorted position.
3.  Repeat.

-   Don't use. This always takes T(n\^2) time, even for a sorted list. This is when data is backed by array or linked list.

        public void selectionSort(int[] a) {
            for (int i = 0, j = 0; i < a.length; i++, j++) {

            }
        }


### Shell Sort: O(...) time, O(1) space

Like insertion sort, but done over larger distances.

### Merge Sort: O(n log n) time, O(n) space

A recursive divide-and-conquer algorithm.

Built on idea that you can merge two lists into one in linear time.

Great for linked lists (O(1) space)?, not too much for arrays O(n) space

-   1 + ceil(log(2, n)) levels
-   O(n) per level

1.  Recursively sort down to two adjacent values.
2.  

           public void mergesort(unsorted list I) {
               I1 has first half, rounded up
               I2 has last half, rounded down
               sort I1 recursively, yielding S1
               sort I2 recursively, yielding S2
               Combine S1 and S2 to S.

               // Let Q1 and Q2 be sorted queues.
               while (neither Q1 nor Q2 is empty) {
                   item1 = Q1.front();
                   item2 = Q2.front();
                   move smaller of item1,item2 from present queue to end of Q
               }
               concatenate end of other non-empty queue to end of Q
           }


### Quick Sort: O(n log n) time, O(...) space

A recursive divide-and-conquer algorithm.

Fastest known comparison-based sort for randomized arrays.

-   The worst case is when the list is already sorted or almost sorted. O(n\^2).

-   Invariants
    -   All items left of index i have a key <= pivot
    -   All items right of index j have a key \>= pivot

1.  Pick pivot
2.  Split array into data less than pivot and greater than pivot, two unsorted lists I1 and I2.
    -   I1: Keys smaller than pivot's key
    -   I2: Keys larger than pivot's key
    -   Equal keys go into either list depending on implementation
    -   The pivot is not in either list.

3.  Sort I1 recursively.
4.  Sort I2 recursively.
5.  Concatenate I1, pivot, I2, yielding sorted lists.

-   Additional strategy
    -   Randomized pivot: To choose a possibly better pivot, randomize the pivot.
    -   "Median-of-three": To choose pivot, select median of three random keys. Best for large data set, don't really need for smaller ones, like < 50 data.
    -   When backed by linked lists
        -   When data has duplicates, have three lists, the one that contains the pivot also contains items with same key.

    -   When backed by arrays
        -   In-place is fast.

               public void quicksort() {
                   if () {



                       do {
                           do {} while ();
                           do {} while ();
                           if () { ;}
                       } while ();
                   }
               }

### Heap Sort: O(n log n) time, O(1) space

A selection sort that is backed by a heap.

Great for sorting arrays, very clumsy for linked lists.

To stay an in-place sort, it uses same array backed by data, but backwards, so that array will be sorted. Basically, instead of "deleting" the heap sort just leaves the last leaf alone.

1.  Toss everything on heap, ignoring order. O(n)
2.  Sort heap using bottom-up heap. O(n)
3.  For all data, remove min, causes a reordering. O(log n).

-   Heap reminder
    -   Every parent is less than child. Thus, root is always min.
    -   To delete min, swap with last leaf, then delete last leaf, then bubble down new root.

### Bucket Sort: O(n) time, O(...) space

Better when sorting linked lists. Counting sort is better for arrays.

Works when keys are distributed in a small range, e.g. 0 to q-1, i.e. when q is in O(n).

Array of q queues, numbered from O to q-1. Each queue is called a bucket.

-   Bucketsort is stable: Items with equal keys come out the same order they went in. (Also could be: insertion, selection, mergesort, linked list quicksort. Not: array quicksort, heapsort)

Running time is T(q + n).

-   T(q) time to initialize & concatenate buckets
-   T(n) time to put items in buckets

1.  Enqueue each item key i goes into queue i.
2.  Concatenate each queue together in order.

### Counting Sort: O(n) time, O(n) space

Better when sorting arrays. Bucket sort is better for linked lists. For arrays, counting sort takes less memory. For linked list, bucket sort is more natural.

Running time is T(q + n).

-   If items are keys; No associated values.
    1.  Count copies of each key in another array
    2.  Output number of each keys.

            index:        0 1 2 3 4 5 6 7 8
            int[] counts: 2 0 0 3 1 1 0 2 0
            sorted        0 0 3 3 3 4 5 7 7

-   If items are keys plus value.
    1.  Count copies of each key in another array
    2.  Change counts to a cumulative list of additions; Each index contains number of keys less than i.
    3.  For this implementation, counts[i] tells us the first index to put key+value

               index:         0  1  2  3  4  5  6  7  8
               int[] counts:  2  0  0  3  1  1  0  2  0
               scan()
               int[] counts:  2  2  2  5  6  7  7  9  0
               sorted        0 0 3 3 3 4 5 7 7

               // First time filling up int[] counts.
               for (i = 0; i < x.length; i++) {
                   counts[x[i].key]++;
               }

               // Scan(). But, this is actually a little different than I learned.
               int total = 0;
               for (i = 0; i < counts.length; i++) {
                   int c = counts[i];
                   counts[i] = total;
                   total += c;
               }

               // Final sorting/placing
               for (int i = 0; i < x.length; i++) {
                   y[counts[x[i].key]] = x[i];
                   counts[x[i].key]++;
               }

### Radix Sort: O(n) time, O(q) space

Easier to parallelize than quicksort.

Kinda like counting sort and bucket sort, but you do just one character/digit at a time via mod 10\^1, mod 10\^2, mod 10\^3, etc...

Radix sort uses bucket sort in a sub-loop, depends on it being stable.

Use number of buckets q.

-   Each pass inspects log(2, q) bits of each key. For 32-bit int, that would be four passes.
-   Each pass takes O(n+q)
-   If all keys represented in b bits, \# of passes is ceil(b/(log(2,q)))

Running time is O((n+q) \* ceil(b/(log(2,q))))

-   One q makes time better, the other q makes time worse.
-   At least q <= n so that each pass takes linear time.
-   With that constraint, we want q to be large as possible so that the number of passes is small
-   Therefore, choose q to be about n, and make q a power of two so that computer can use bit operations and be more efficient.
    -   Practical choice, make q = n rounded down to power of two.
    -   To keep memory use lower: make q about sqrt(n) rounded to nearest power of two.

Running time simplifies to O((n) + b\*n/(log(2,n)))

Traversal Algorithms
--------------------

### Kruskal's Algorithm (Greedy)

Basically, add lowest weight edges as long as you don't create loop. And, you've created a minimum path tree.

-   T is guaranteed to be a tree if G is connected, otherwise T is a forest.

-   Creating new graph and list of all edges takes O(|V|) time.
-   Sorting |E| edges takes O(|E| log|E|).
-   Checking for loop is less than O(|E| log|E|).
-   Overall time: O(|V| + |E|log|V|).

1.  Create new graph T with same vertices as G, but no edges yet.
2.  Make list of all edges in G.
3.  Sort edges by weight, lowest to highest.
4.  Iterate through edges in sorted order.
    -   Add edge as long as a loop isn't created.

            public void kruskal(Graph G) {

            }

Selection
---------

One option is to sort list first, but that's typically O(n log n)

Median of set of n keys: item whose index is j = (n-1)/2 in sorted list.

### Quick Select

Find kth smallest key in unsorted list. Aka, get item at index j if list is sorted, j = k - 1

Modified quicksort

-   Start with unsorted list I on n items
-   Choose pivot v from I
-   Partition I into lists I1, Iv, and I2
-   if (j < |I1|) { recursively find item w/index j in I1; return it; }
-   else if (j < |I1| + |Iv|) { return v; }
-   else { recursively find item w/index j-|I1|-|Iv| in I2; return it; }

Runs O(n) average time if select pivots randomly.

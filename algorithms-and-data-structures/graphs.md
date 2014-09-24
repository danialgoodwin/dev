# Graphs #

## Definitions / Vocabulary ##
A graph G = (V,E) consists of a set of vertices V together with a set of vertex pairs or edges.

- Vertex (plural vertices): A point in a graph.
- Edge: A connection between two points.

- Degree: The number of edges connected to a vertex.

- Directed vs undirected
  - Formally: A graph G = (V,E) is undirected if edge (x, y) exists in E implies that (y, x) is also in E. Otherwise, the graph is directed.
  - Basically, a graph is undirected if flow/control on each edge can go either way. Otherwise, the graph is directed.
  - Ex: A two-way road would be modelled as undirected because flow can go both ways. A one-way road would be directed.
- Weighted vs unweighted
  - Each edge (or vertex) in a weighted graph G is assigned a numerical value, or weight. In unweighted graphs, there is no cost distinction between various edges and vertices.
  - Ex: Roads may be weighted with their length, drive-time, or speed limit, depending on the application.
- Simple vs non-simple: A graph is simple if there are no self-loops (edge (x,x)) and no multiedge. Otherwise, graph is non-simple, which tends to complicate graph algorithms.
- Sparse vs dense: A graph is sparse when only a small fraction of possible vertex pairs have an edge. A graph is dense when a large fraction of vertex pairs have edges.
- Cyclic vs acyclic: A graph is acyclic if it does not contain any cycles, like trees.
- Embedded vs topological
- Explicit vs implicit
- Labeled vs unlabeled: A graph is labeled if vertices have ways to distinguish them, like a name.

- Connected vs unconnected: A graph is connected if there is a path between any two vertices.
- Strongly connected: If there is a directed path between any two vertices. Ex: Road network typically.

- Vertex-coloring problem: Assigning of labels or colors to each vertex of a graph such that no edge links any two vertices of the same color.
- Bipartite (or two-colorable): A graph is bipartite if vertices can be colored using only two colors such that no edge links any two vertices of the same color.


## Uses ##
Graphs can be used to:
- Represent essentially any relationship
  - Ex: Network of roads, with cities as vertices and roads between cities as edges.
  - Ex: Electronic circuits, with junctions as vertices and components as edges.


## How to model a graph ##

Here's a comparison of the different models:

    Comparison                                Winner
    Faster to test if (x,y) is in graph?     adjacency matrices
    Faster to find the degree of a vertex?    adjacency lists
    Less memory on small graphs?              adjacency lists (m + n) vs. (n2)
    Less memory on big graphs?                adjacency matrices (a small win)
    Edge insertion or deletion?               adjacency matrices O(1) vs. O(d)
    Faster to traverse the graph?             adjacency lists T(m + n) vs. T(n2)
    Better for most problems?                 adjacency lists

In the following models, we assume the graph G = (V,E) contains n vertices and m edges.


### Adjacency Matrix ###
G is represented using an n x n matrix M, where element M[i,j] = 1 if (i,j) is an edge of G, and 0 if it isn’t.



### Adjacency List ###

G is represented using and array of linked lists. Each element in the array is a vertex, and each element in the linked lists represents a directed edge from that vertex. An undirected edge would appear twice in the adjacency list.


### Objects with pointers ###
Not used a much.


## Traversal ##
The most basic problem in dealing with graphs -- how to systematically check all nodes.

The main difference between BFS and DFS is the container data structure used to store discovered vertices: BFS uses queues, DFS uses stacks.

### Breadth-First Search (BFS) ###
This can be used to find a minimum path between two nodes for an unweighted graph.

To record the paths, a data structure could be used to hold the parent of each vertex through traversal.

    // Pseudocode
    bfs(Graph G, Node startNode s) {
        // Initialize all vertices to unchecked.
        for each vertex in G
            set state to unchecked
        
        Queue<Node> Q = s
        while Q is not empty
            Node u = Q.dequeue()
            if u is unchecked
                process u // Ex: Check value or print.
                set state of u to checked
                add all connecting edges to Q if they haven't already been checked
    }

### Depth-Firth Search (DFS) ###

To record the paths, a data structure could be used to hold the parent of each vertex through traversal. Though, another interesting method is keeping track of entry and exit "time" for each vertex to know who is ancestor and how many decendants there are by just looking at the numbers (Skiena p169).

    // Pseudocode // Initialize all vertices to unchecked beforehand.
    dfs(Graph g, Node currentNode u) {
        
        
        set state of u to checked
        process u // Ex: Check value or print.
        for each vertex connected to u
            if vertex is unchecked
                // Recurse into node.
                dfs(G, vertex)
    }


## Topological sorting ##
Used for DAGs (directed acyclic graphs). It orders the vertices on a line such that all directed edges go from left to right. This would not be possible with a directed cycle. This sorting is useful because it provides us an ordering to process each vertex.

Topological sorting can be done efficiently using DFS. A directed graph is a DAG iff no back edges are found. Labeling the vertices in the reverse order that they are marked processed finds a topological sort of a DAG.

Ex: Precedence constraints.
Ex: Shortest or longest path between x and y.


## Weighted graphs ##

### Minimum Spanning Trees ###

Ex: Connect a set of points/cities/homes by the smallest amount of roadway/wire/pipes.

#### Prim's Algorithm ####
To find the MST, start from one vertex and grow the rest of the tree on edge at a time until all vertices are included.

Time complexity: O(mn) or O(n^2) or O(m + n*lg(n)) depending on data structure.

#### Kruskal's Algorithm ####
To find the MST, repeatedly add the globally minimum edge that doesn't create a cycle.

Time complexity: O(mn) or O(m*lg(m)) depending on data structure. So, this is better than Prim's for sparse graphs.

The Union-Find data structure
- Represents each subset as a "backwards" tree, with pointers from a mode to its parent.
- Two operations:
  - find(i): Returns root of tree containing element i.
  - union(i,j): Links two tree roots (so that find(i) equals find(j)). This operation tries to keep height minimized.
- Model: Three sets/roots. Tallest one has height of three (7->2->4).

        vertex | 1 2 3 4 5 6 7
        parent | 0 4 0 0 3 4 2


### Maximum Spanning Trees ###
These can be made by negating the weights of all edges and running Prim's algorithm.

### Minimum Product Spanning Trees ###
Suppose we seek the spanning tree that minimizes the product of edge weights, assuming all edge weights are positive. Since lg(a · b) = lg(a) + lg(b), the minimum spanning tree on a graph whose edge weights are replaced with their logarithms gives the minimum product spanning tree on the original graph.

### Minimum Bottleneck Spanning Trees ###
Just like minimum spanning trees to minimize the maximum edge weight, but a less efficient but conceptually simpler way can be to delete "heavy" edges from graph and ask whether the result is still connected.


### Shortest path ###
For unweighted graphs, a BFS can be used. For weighted graphs, Dijkstra's algorithm is the common method used.

Dijkstra's is similar to Prim's in that one edge is added at a time, but they are NOT the same. For example, imagine that you want to find the shortest path between Node s and Node t. There are two possible paths, (1) one edge with weight 2, (2) three edges with weight 1. So, with Dijkstra's all edges still much be considered even if the end node has already been found because the shortest distance may decrease.

About Dijkstra's:
- Time complexity is O(n^2).
- Only works correctly on graphs without negative-cost edges.
- Dinds the shortest path to all vertices. And, for undirected graphs, it would be a BFS tree.

A particularly convenient dynamic programming solution for DAG shortest path problems is called the Viterbi algorithm, which is widely used in speech and handwriting recognition systems.

#### All-pairs shortest path #### (Skiena p210)
Used to find "center" of graph, which minimizes the longest or average distance to all other nodes. Also helps to find graph's diameter -- the longest shortest-path distance.

Ex: Start a new business there.

One method is using Disjkstra's on all vertices. Another, more efficient algorithm would be the Floyd(-Warshall) algorithm, which is typically employed on an adjacency matrix data structure.

Time complexity is O(n^3), which is same asympototic value as n calls to Dijkstra's, but in practice Floyd's runs better.


## Network flow ##
These types of problems look for the maximum amount of flow which can be sent between two vertices.

Ex: A network of pipes, each an edge with a maximum amount of capacity/flow.

The largest bipartite matching can be readily found using network flow. Create a source node s that is connected to every vertex in L by an edge of weight 1. Create a sink node t and connect it to every vertex in R by an edge of weight 1. Finally, assign each edge in the bipartite graph G a weight of 1. Now, the maximum possible flow from s to t defines the largest matching in G.

The maximum flow from s to t always equals the weight of the minimum s-t cut.


## Further Resources ##
- The Algorithm Design Manual by Skiena (Note: A lot of words/sentences on this page have come directly from this great book. I do not try to pass it off as my own work.)

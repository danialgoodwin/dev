// Source: https://www.hackerrank.com/challenges/bfsshortreach
// Note: Not fully working yet.. should be re-done and much simplified.
public class BfsShortestReach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int testNum = 1; testNum <= numTests; testNum++) {
            int numNodes = sc.nextInt();
            int numEdges = sc.nextInt();
            Graph<Integer, String> g = new Graph<>();

            for (int nodeNum = 1; nodeNum <= numNodes; nodeNum++) {
                g.addNode(nodeNum, "");
            }

            for (int edgeNum = 1; edgeNum <= numEdges; edgeNum++) {
                int nodeIdA = sc.nextInt();
                int nodeIdB = sc.nextInt();
                Graph.Node nodeA = g.addNode(nodeIdA, "");
                Graph.Node nodeB = g.addNode(nodeIdB, "");
                g.addEdge(nodeA, nodeB);
            }

            int startNodeId = sc.nextInt();
            Graph.Node start = g.addNode(startNodeId, "");
            g.bfs(start);

            StringBuilder sb = new StringBuilder();
            for (Graph.Node n : g.graph) {
                if (n.equals(start)) { continue; }
                sb.append(n.distance).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    public static class Graph<K extends Comparable, V> {
        public Set<Graph.Node<K, V>> graph = new HashSet<>();

        public Node<K, V> addNode(K key, V value) {
            Node<K, V> n = new Node<>(key, value);
            return addNode(n);
        }

        /** @return node for key id */
        public Node<K, V> addNode(Graph.Node<K, V> node) {
            if (!graph.contains(node)) {
                graph.add(node);
            }
            for (Graph.Node findNode : graph) {
                if (findNode.equals(node)) { return findNode; }
            }
            return null; // Code shouldn't reach here...
        }

        // Undirected edge
        public void addEdge(Node<K, V> a, Node<K, V> b) {
            a.addEdge(b);
            b.addEdge(a);
        }

        public void bfs() {
            clearVisited();
            for (Graph.Node<K, V> n : graph) {
                if (!n.isVisited) {
                    bfs(n);
                }
            }
        }

        public void bfs(Graph.Node<K, V> root) {
            //if (root.isVisited()) { return; }
            Queue<Graph.Node<K, V>> q = new LinkedList<>();
            q.add(root);
            int depth = 1;
            while (!q.isEmpty()) {
                Node<K, V> first = q.remove();
                first.visit();
                for (Graph.Node<K, V> n : first.edges) {
                    if (!n.isVisited) {
                        n.distance = 6 * depth;
                        q.add(n);
                    }
                }
                depth++;
            }
        }

        public void clearVisited() {
            for (Graph.Node<K, V> n : graph) {
                n.isVisited = false;
            }
        }

        public static class Node<K extends Comparable, V> implements Comparable<Graph.Node<K, V>> {
            public final K id;
            public V value;
            public boolean isVisited = false;
            public int distance = -1;
            public Set<Node<K, V>> edges = new TreeSet<>();

            public Node(K id, V value) { this.id = id; this.value = value; }

            @Override
            public boolean equals(Object o) {
                if (o == null) { return false; }
                if (!(o instanceof Node)) { return false; }
                Node n = (Node) o;
                return this.id.equals(n.id);
            }

            public void addEdge(Node n) {
                if (!edges.contains(n)) {
                    edges.add(n);
                }
            }

            public void visit() {
                isVisited = true;
            }

            @Override
            public int hashCode() {
                return id.hashCode();
            }

            @Override
            public int compareTo(Graph.Node<K, V> i) {
                return this.id.compareTo(i.id);
            }
        }
    }

}

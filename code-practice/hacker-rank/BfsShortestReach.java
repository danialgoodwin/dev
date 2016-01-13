import java.util.*;

/**
 * Created by dan on 9/13/15.
 */
// Source: https://www.hackerrank.com/challenges/bfsshortreach

/**
 * Using ArrayList:
 * - This code passes case 0, 3, 4
 * - This code fails for case 1, 2, 6
 * - This code takes too long for case 5
 * Using HashMap
 * - Not guaranteed to be sorted when printing.
 * Using TreeMap
 * - This code passes case 0, 3, 4
 * - This code fails for case 1, 2, 6
 * - This code takes too long for case 5
 * Use TreeMap for Node also so that multiple edges aren't allowed/counted.
 * - This code passes case 0, 3, 4
 * - This code fails for case 1, 2, 5, 6
 */
public class BfsShortestReach {

    private static final int EDGE_LENGTH = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int test = 0; test < numTests; test++) {
            Graph graph = new Graph();
            int numNodes = sc.nextInt();
            graph.createNodes(numNodes);
            int numEdges = sc.nextInt();
            for (int edge = 0; edge < numEdges; edge++) {
                int nodeA = sc.nextInt();
                int nodeB = sc.nextInt();
                graph.addEdge(nodeA, nodeB);
            }
            int startNode = sc.nextInt();
            solve(graph, startNode);
        }
        System.out.println();
    }

    private static void solve(Graph graph, int startNode) {
        graph.bfs(startNode);
        StringBuilder sb = new StringBuilder();
        for (Graph.Node node : graph.nodes.values()) {
            if (node.key != startNode) {
                sb.append(node.value).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static class Graph {
        Map<Integer, Node> nodes = new TreeMap<>();


        // Not needed for this problem, instead use createNodes(int)
//        public Node addNode(Node node) {}

        public void createNodes(int numNodes) {
            for (int node = 1; node <= numNodes; node++) {
                nodes.put(node, new Node(node, -1));
            }
        }

        public void addEdge(int nodeA, int nodeB) {
            Node a = nodes.get(nodeA);
            Node b = nodes.get(nodeB);
            if (!a.edges.containsKey(nodeB)) {
                a.addEdge(b);
                b.addEdge(a);
            }
        }

        // Set value to minimum distances from start node.
        public void bfs(int nodeStart) {
            clearVisited();
            Node start = nodes.get(nodeStart);
            start.depth = 0;
            Queue<Node> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                Node n = queue.remove();
                if (!n.isVisited) {
                    n.visit();
                }
                for (Node edge : n.edges.values()) {
                    if (!edge.isVisited) {
                        edge.depth = n.depth + 1;
                        queue.add(edge);
                    }
                }
            }
        }

        private void clearVisited() {
            for (Node node : nodes.values()) {
                node.isVisited = false;
            }
        }

        public static class Node {
            final int key;
            int depth;
            int value;
            boolean isVisited = false;
            Map<Integer, Node> edges = new TreeMap<>();

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public void addEdge(Node node) {
                edges.put(node.key, node);
            }

            public void visit() {
                value = depth * EDGE_LENGTH;
                isVisited = true;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return Objects.equals(key, node.key);
            }

            @Override
            public int hashCode() {
                return Objects.hash(key);
            }
        }

    }

}

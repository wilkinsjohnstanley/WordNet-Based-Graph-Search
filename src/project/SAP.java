package project;
// Importing classes from the Princeton Algorithms library
import edu.princeton.cs.algs4.*;

public class SAP {
    // Instance variable to hold the reference to the directed graph
    private final Digraph G;
    /**
     * Constructor for the SAP (Shortest Ancestral Path) class.
     * Makes a defensive copy of the given Digraph to ensure immutability.
     *
     * @param G The directed graph to be used for SAP calculations.
     */
    public SAP(Digraph G) {
        if (G == null) {
            throw new NullPointerException("Argument should not be null");
        }
        this.G = new Digraph(G); // Defensive copy of the graph
    }
    /**
     * Finds the length of the shortest ancestral path between two vertices.
     *
     * @param v The first vertex.
     * @param w The second vertex.
     * @return The length of the shortest ancestral path, or -1 if no such path exists.
     */
    public int length(int v, int w) {
        return bfs(v, w)[1]; // Second element of the result array is the length
    }
    /**
     * Finds the common ancestor in the shortest ancestral path between two vertices.
     *
     * @param v The first vertex.
     * @param w The second vertex.
     * @return The common ancestor, or -1 if no such ancestor exists.
     */
    public int ancestor(int v, int w) {
        return bfs(v, w)[0]; // First element of the result array is the ancestor
    }
    /**
     * Finds the length of the shortest ancestral path between two sets of vertices.
     *
     * @param v An iterable of vertices from the first set.
     * @param w An iterable of vertices from the second set.
     * @return The length of the shortest ancestral path, or -1 if no such path exists.
     */
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        return bfs(v, w)[1]; // Second element is the length
    }
 /**
     * Helper method to calculate the shortest ancestral path and common ancestor
     * between two individual vertices.
     *
     * @param v The first vertex.
     * @param w The second vertex.
     * @return An array where:
     *         - index 0 contains the common ancestor
     *         - index 1 contains the length of the shortest ancestral path
     */
    private int[] bfs(int v, int w) {
        return bfs(new BreadthFirstDirectedPaths(G, v), new BreadthFirstDirectedPaths(G, w));
    }
    /**
     * Helper method to calculate the shortest ancestral path and common ancestor
     * between two sets of vertices.
     *
     * @param v An iterable of vertices from the first set.
     * @param w An iterable of vertices from the second set.
     * @return An array where:
     *         - index 0 contains the common ancestor
     *         - index 1 contains the length of the shortest ancestral path
     */
    private int[] bfs(Iterable<Integer> v, Iterable<Integer> w) {
        return bfs(new BreadthFirstDirectedPaths(G, v), new BreadthFirstDirectedPaths(G, w));
    }
    /**
     * Core BFS logic that computes the shortest ancestral path and common ancestor.
     *
     * @param bfs1 The BFS results from the first vertex or set of vertices.
     * @param bfs2 The BFS results from the second vertex or set of vertices.
     * @return An array where:
     *         - index 0 contains the common ancestor
     *         - index 1 contains the length of the shortest ancestral path
     */
    private int[] bfs(BreadthFirstDirectedPaths bfs1, BreadthFirstDirectedPaths bfs2) {
        int minDistance = Integer.MAX_VALUE; // Initialize minimum distance to a very high value
        int ancestor = 0; // Initialize ancestor to 0 (no valid ancestor)
        // Iterate through all vertices in the graph
        for (int i = 0; i < G.V(); i++) {
            // Check if both BFS searches have paths to the current vertex
            if (bfs1.hasPathTo(i) && bfs2.hasPathTo(i)) {
                int distance = bfs1.distTo(i) + bfs2.distTo(i); // Total Distance
                if (distance < minDistance) {
                    minDistance = distance; //Update minimum distance
                    ancestor = i; //Update Ancestor
                }
            }
        }
        // Return [-1, -1] if no valid ancestor was found
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{ancestor, minDistance}; // Return ancestor and distance
    }
    /**
     * Finds the common ancestor in the shortest ancestral path between two sets of vertices.
     *
     * @param v An iterable of vertices from the first set.
     * @param w An iterable of vertices from the second set.
     * @return The common ancestor, or -1 if no such ancestor exists.
     */
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        return bfs(v, w)[0]; // First element is the ancestor
    }
    /**
     * Main method to test SAP functionality.
     * Reads a graph from an input file and processes pairs of vertices from standard input.
     *
     * @param args Command-line arguments:
     *             args[0] - Path to the input graph file.
     */
    public static void main(String[] args) {
        // Read the graph from the input file
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        // Create an SAP object for the graph
        SAP sap = new SAP(G);
        // Process vertex pairs from standard input
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();// First vertex
            int w = StdIn.readInt();// Second vertex
            int length = sap.length(v, w); // Shortest path length
            int ancestor = sap.ancestor(v, w); // Common ancestor
            // Print the results
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}

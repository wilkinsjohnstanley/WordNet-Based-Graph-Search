package project;


import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import java.util.*;
/**
 * WordNet is a semantic lexicon that models the relationships between nouns in the English language.
 * This class provides functionalities to process synsets and hypernyms, determine the semantic
 * relationship between nouns, and find common ancestors in a directed acyclic graph (DAG).
 */
public class WordNet {

    private final Digraph digraph; // Directed graph representing the hypernym relationships
    private final Map<String, List<Integer>> nouns = new HashMap<>(); // Maps nouns to their synset IDs
    private final Map<Integer, String> synsets = new HashMap<>(); // Maps synset IDs to their associated words
    /**
     * Constructs a WordNet from the given synsets and hypernyms files.
     *
     * @param synsets   the file containing synsets
     * @param hypernyms the file containing hypernym relationships
     * @throws IllegalArgumentException if either argument is null or the input graph is not a rooted DAG
     */
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        // Read and process synsets
        In in = new In(synsets);
        while (!in.isEmpty()) {
            String[] line = in.readLine().split(",");
            int index = Integer.parseInt(line[0]);
            this.synsets.put(index, line[1]);
 // Map each word in the synset to its corresponding synset ID
            Arrays
                    .stream(line[1].split(" "))
                    .forEach(word -> {
                        if (!nouns.containsKey(word)) {
                            nouns.put(word, new ArrayList<>());
                        }
                        nouns.get(word).add(index);
                    });
        }
        in.close();
        // Create the directed graph from hypernyms
        digraph = new Digraph(this.synsets.size());
        in = new In(hypernyms);
        while (!in.isEmpty()) {
            String[] line = in.readLine().split(",");
            int synset = Integer.parseInt(line[0]);
            for (int i = 1; i < line.length; i++) {
                digraph.addEdge(synset, Integer.parseInt(line[i]));
            }
        }
        in.close();
        // Validate that the graph is a rooted DAG
        DirectedCycle finder = new DirectedCycle(digraph);
        if (finder.hasCycle()) {
            throw new IllegalArgumentException("Given graph is not rooted DAG");
        }
    }
    /**
     * Returns all WordNet nouns.
     *
     * @return an iterable collection of all nouns
     */
    public Iterable<String> nouns() {
        return nouns.keySet();
    }
    /**
     * Checks if the given word is a WordNet noun.
     *
     * @param word the word to check
     * @return true if the word is a WordNet noun, false otherwise
     * @throws IllegalArgumentException if the argument is null
     */
    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        return nouns.containsKey(word);
    }
    /**
     * Calculates the semantic distance between two nouns.
     *
     * @param nounA the first noun
     * @param nounB the second noun
     * @return the distance between nounA and nounB
     * @throws IllegalArgumentException if any argument is null or not a WordNet noun
     */
    public int distance(String nounA, String nounB) {
        if (nounA == null || nounB == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("One of the arguments is not assignment1ct.WordNet noun");
        }
        SAP sap = new SAP(digraph);
        return sap.length(numberOf(nounA), numberOf(nounB));

    }
    /**
     * Helper method to retrieve the synset IDs for a given noun.
     *
     * @param noun the noun whose synset IDs are needed
     * @return an iterable of synset IDs associated with the noun
     */
    private Iterable<Integer> numberOf(String noun) {
        return nouns.get(noun);
    }
    /**
     * Finds the common ancestor (shortest ancestral path) of two nouns in the WordNet.
     *
     * @param nounA the first noun
     * @param nounB the second noun
     * @return the common ancestor of nounA and nounB
     * @throws IllegalArgumentException if any argument is null, not a WordNet noun, or has no common ancestor
     */
    public String sap(String nounA, String nounB) {
        if (nounA == null || nounB == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("One of the arguments is not assignment1.WordNet noun");
        }
        SAP sap = new SAP(digraph);
        int ancestor = sap.ancestor(numberOf(nounA), numberOf(nounB));
        if (ancestor == -1) {
            throw new IllegalArgumentException("Nouns do not have common ancestor");
        }
        return synsets.get(ancestor);
    }
}
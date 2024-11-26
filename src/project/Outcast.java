package project;

// Import classes from the Princeton Algorithms library
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/**
 * The Outcast class identifies an "outcast" noun from a given set of nouns
 * based on the WordNet semantic distance between them.
 */
public class Outcast {
    // Instance variable to hold the reference to the WordNet object
    private final WordNet wordNet;
    /**
     * Constructor for the Outcast class.
     * Initializes the WordNet object.
     *
     * @param wordNet The WordNet object that provides the distance calculation.
     */
    public Outcast(WordNet wordNet) {
        this.wordNet = wordNet;
    }
    /**
     * Determines the "outcast" noun from an array of nouns.
     * The outcast is the noun with the largest semantic distance to other nouns.
     *
     * @param nouns Array of nouns to evaluate.
     * @return The noun that is the outcast.
     */
    public String outcast(String[] nouns) {
        int maxDistance = Integer.MIN_VALUE; // Track the maximum semantic distance
        String outCast = null; // Variable to store the outcast noun
        // Loop through each noun
        for (int i = 0; i < nouns.length; i++) {
            for (int j = i + 1; j < nouns.length; j++) {
                int distance = wordNet.distance(nouns[i], nouns[j]);
                // Update the outcast if the current noun has a larger distance sum
                if (distance > maxDistance) {
                    maxDistance = distance;
                    outCast = nouns[j];
                }
            }
        }
        return outCast; // Return the noun identified as the outcast
    }

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}

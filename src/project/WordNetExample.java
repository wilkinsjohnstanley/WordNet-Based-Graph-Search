// package edu.princeton.cs.algs4;
// package project;


public class WordNetExample {
    public static void main(String[] args) {
        // Paths to synsets and hypernyms files
        String synsetsFile = "src\\data\\synsets11.txt";
        String hypernymsFile = "src\\data\\hypernyms.txt";

        // Create a WordNet instance
        WordNet wordNet = new WordNet(synsetsFile, hypernymsFile);

        // List all nouns
        System.out.println("All nouns in the WordNet:");
        for (String noun : wordNet.nouns()) {
            System.out.println(noun);
        }

        // Check if a word is a WordNet noun
        String testWord = "word1";
        System.out.println("\nIs '" + testWord + "' a WordNet noun? " + wordNet.isNoun(testWord));

        // Calculate distance between two nouns
        String nounA = "word0";
        String nounB = "word3";
        System.out.println("\nDistance between '" + nounA + "' and '" + nounB + "': " + wordNet.distance(nounA, nounB));

        // Find common ancestor of two nouns
        System.out.println("\nCommon ancestor of '" + nounA + "' and '" + nounB + "': " + wordNet.sap(nounA, nounB));
    }
}

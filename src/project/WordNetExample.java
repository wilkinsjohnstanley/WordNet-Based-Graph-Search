package project;

public class WordNetExample {
    public static void main(String[] args) {
        // String synsetsFile = "src/data/synsets.txt";
        // String hypernymsFile = "src/data/hypernyms.txt";
        String synsetsFile = "C:/Users/thepo/OneDrive/Desktop/courseProject/src/data/synsets.txt";
        String hypernymsFile = "C:/Users/thepo/OneDrive/Desktop/courseProject/src/data/hypernyms.txt";
        
        // Create WordNet instance
        WordNet wordNet = new WordNet(synsetsFile, hypernymsFile);

        // Example usage of WordNet methods
        System.out.println("All WordNet nouns:");
        for (String noun : wordNet.nouns()) {
            System.out.println(noun);
        }

        // Example of distance calculation
        String nounA = "horse";
        String nounB = "zebra";
        System.out.println("Distance between " + nounA + " and " + nounB + ": " +
                           wordNet.distance(nounA, nounB));

        // Example of shortest ancestral path (SAP)
        System.out.println("SAP between " + nounA + " and " + nounB + ": " +
                           wordNet.sap(nounA, nounB));
    }
}

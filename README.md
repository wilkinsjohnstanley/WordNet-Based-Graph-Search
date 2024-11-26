# WordNet Semantic Relationship Analyzer

## Project Overview
This project implements a WordNet semantic relationship analyzer. It utilizes graph algorithms to find relationships between words, calculate shortest ancestral paths (SAP), and detect outcast words. The implementation demonstrates applications of graph theory in natural language processing and semantic analysis.

### Main Files
- **Outcast.java**: Detects outcast words using WordNet relationships.
- **SAP.java**: Computes the shortest ancestral path between words.
- **WordNet.java**: Represents and processes the WordNet graph structure.

---

## Software Environment
- **Programming Language**: Java
- **IDE**: Visual Studio Code
- **Java Version**: Ensure you have JDK (Java Development Kit) version 8 or later installed.
- **Extensions**: Install the "Extension Pack for Java" in Visual Studio Code for Java development.

---

## Steps to Compile and Run the Program

### 1. Setup the Environment
1. **Install JDK**: Download and install JDK from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).
2. **Configure JAVA_HOME**: Set the `JAVA_HOME` environment variable to the JDK installation directory.
3. **Install Visual Studio Code**: If not already installed, download Visual Studio Code from [here](https://code.visualstudio.com/).
4. **Install Java Extensions**: Open Visual Studio Code and install the "Extension Pack for Java" from the Extensions Marketplace.

### 2. Prepare the Project
1. Create a new folder for the project.
2. Add the main project files (`Outcast.java`, `SAP.java`, `WordNet.java`) to this folder.

### 3. Open the Project in Visual Studio Code
1. Open Visual Studio Code.
2. Go to `File > Open Folder` and select the project folder.

### 4. Compile the Program
1. Open the terminal in Visual Studio Code (`Ctrl + ` ` or `View > Terminal`).
2. Use the `javac` command to compile the `.java` files:
   ```bash
   javac Outcast.java SAP.java WordNet.java
### 5. Run the Prorgram
Execute the program using the java command:
java <MainClass> (Replace with approprite class containing the main method)
### 6. Example Usage
1. To detect an outcast word:
java Outcast input.txt
(Replace input.txt with your input file containing the words)
2. To calculate the shortestt ancestral path
java SAP word1 word2
(Replace word1 and word2 with the words for which you want to find the SAP).
### Additional Considerations
1. Ensure all inputt files are in the same directory as the compiled .class files or provide the full file path.
2. If you encounter issues with the setup, check your Java installation and environment variables.
3. Coding Pack for Java

To help you set up quickly, you can install the Coding Pack for Java, which includes VS Code, the Java Development Kit (JDK), and essential Java extensions. The Coding Pack can be used as a clean installation, or to update or repair an existing development environment.

After installing the CTRL+SHIFT+P and click Java:Configure Java Runtime. Configure the dependencies.
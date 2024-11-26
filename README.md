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
- **Extensions**: Install the "Extension Pack for Java" in Visual Studio Code for Java development. Alternatively, search Visual Studio Code Coding Pack for Java and select the Visual Studio Code website link. This downloadable will detect whatever is missing from your computer that is needed to run Java projects.

---

## Steps to Compile and Run the Program

### 1. Setup the Environment
1. **Install JDK**: Download and install JDK from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).
2. **Configure JAVA_HOME**: Set the `JAVA_HOME` environment variable to the JDK installation directory.
3. **Install Visual Studio Code**: If not already installed, download Visual Studio Code from [here](https://code.visualstudio.com/).
4. **Install Java Extensions**: Open Visual Studio Code and install the "Extension Pack for Java" from the Extensions Marketplace.

### 2. Project Files
1. The main project files (`Outcast.java`, `SAP.java`, `WordNet.java`) are in the project folder.
2. algs4.jar is in the lib folder. It's contents are also in the edu folder for redundency. To use the library: Update your classpath to include the JAR file when compiling and running your project. One possible way to do this is to Add a launch.json configuration for Java with the classpath pointing to lib/algs4.jar.
3. If this is too difficult, I have the algs4 library files extracted and stored in courseProject\src\edu\princeton\cs\algs4, you can compile and run your project without needing the JAR file. To compile the project, you must include the src directory as the root of the classpath. Navigate to the courseProject directory and use the following command: javac -cp src src/project/*.java



### 3. Open the Project in Visual Studio Code
1. Open Visual Studio Code.
2. Go to `File > Open Folder` and select the project folder.

### 4. Compile the Program
When compiling and running Java programs that are inside a package, you need to make sure you're running them from the root of the source directory and using the correct classpath.

#For example: cd C:\Users\userName\OneDrive\Desktop\courseProject\src
javac project/SAP.java
To Run; Then, run the class using the fully qualified name: java project.SAP input.txt



1. Open the terminal in Visual Studio Code (`Ctrl + ` ` or `View > Terminal`).
2. Use the `javac` command to compile the `.java` files:
   ```bash
   javac Outcast.java SAP.java WordNet.java
3. Alternatively:
Compile All Files: Ensure that you compile both WordNet.java and WordNetExample.java together. In the courseProject/src directory, run:

 javac project/*.java edu/princeton/cs/algs4/*.java

### 5. Run the Prorgram
Execute the program using the java command:
java <MainClass> (Replace with approprite class containing the main method)

### 6. Example Usage
1. Outcast.java
To detect an outcast word:

Directory: Be in the src/project directory (or where your compiled .class files for Outcast.java are).

Ensure you've compiled all the Java files: Nagivate to the courseProject/src directory and run the following to compile: javac project/*.java

##Run the Program:

Assuming the .class files for Outcast, WordNet, and any dependencies are all in the project package and your current directory is C:\Users\userName\OneDrive\Desktop\courseProject\src\project, you can run the Outcast program like this:

Format:
java -cp ".;C:\path\to\algs4.jar" project.Outcast C:\path\to\synsets.txt C:\path\to\hypernyms.txt C:\path\to\input1.txt C:\path\to\input2.txt

Actual Format (change to the path based on your file system!)
java -cp ".;C:\path\to\algs4.jar" project.Outcast C:\Users\userName\OneDrive\Desktop\courseProject\src\data\synsets.txt C:\Users\userName\OneDrive\Desktop\courseProject\src\data\hypernyms.txt C:\Users\userName\OneDrive\Desktop\courseProject\src\sampleInputs\input1.txt C:\Users\userName\OneDrive\Desktop\courseProject\src\sampleInputs\input2.txt


2. SAP.java
To calculate the shortest ancestral path
In the courseProject\src directory: java project.SAP C:\Users\userName\OneDrive\Desktop\courseProject\src\data\digraph1.txt
(Replace digraph1.txt with the input you desire).

Directory: Be in the src/project directory (or where your compiled .class files for SAP.java are).

Next Step (after running the command):

    The program will expect you to input pairs of integers (representing vertices) for which it will calculate the shortest ancestral path and the common ancestor.
    For example, after you run the above command, you can enter: 1 2 3 4
    and it will compute the length and ancestor for each pair.
    

Problems?

Ensure you've compiled all your Java files: Navigate to the courseProject/src directory and run: javac project/*.java




3. WordNet.java
Directory: Be in the src/project directory (or where your compiled .class files for WordNet.java are).

Ensure you've compiled all your Java files: Navigate to the courseProject/src directory and run: javac project/*.java

Run WordNet.java: From the src/project directory, run:
java project.WordNet

### Additional Considerations
1. Ensure all inputt files are in the same directory as the compiled .class files or provide the full file path.
2. If you encounter issues with the setup, check your Java installation and environment variables.
3. Coding Pack for Java

To help you set up quickly, you can install the Coding Pack for Java, which includes VS Code, the Java Development Kit (JDK), and essential Java extensions. The Coding Pack can be used as a clean installation, or to update or repair an existing development environment.

After installing the CTRL+SHIFT+P and click Java:Configure Java Runtime. Configure the dependencies.
4. Class Root: The src folder must be the root for the edu and project packages. This ensures that the compiler and runtime environment can locate the classes correctly.
5. Package Declarations: All files in the edu.princeton.cs.algs4 folder should retain their "package edu.princeton.cs.algs4;" declaration at the top of each file. Or, if you choose to use the algs4.jar file, "import edu.princeton.cs.algs4" along with configuring the environment to use the file as explained earlier in this README.md file.
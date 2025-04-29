# Kruskal's MST Simulation

## Overview
This project, `kruskal-simulation`, is a school activity developed for a Data Structures and Algorithms (DSA) course at New Era University. It implements Kruskal's algorithm to find the Minimum Spanning Tree (MST) of a graph and visualizes the process using a graphical user interface (GUI). The simulation allows users to generate random graphs, run the algorithm step-by-step, and view the resulting MST with edge weights displayed in a table.

## Author
- **Name**: Bai Sakina B. Abad  
- **Program**: Computer Science  
- **University**: New Era University  
- **Context**: This project was created as part of a DSA course to demonstrate the application of Kruskal's algorithm of Greedy Techniques.

## Technologies Used
- **IDE**: IntelliJ IDEA  
- **Framework**: Java Swing (for the GUI)  
- **Language**: Java  
- **Libraries**: Standard Java libraries (`javax.swing`, `java.awt`, etc.) for GUI and graphics rendering.

## Features
- Visualize Kruskal's algorithm step-by-step as it constructs the MST.
- Generate random graphs with varying complexity (7 different sample graphs).
- Interactive controls to start, pause, and new graph.
- Display the MST edges and total weight in a table.

## UI Preview
Below is a preview of the application's user interface. 

![UI Sreenshot](src/resources/ui_preview2.png)

*Caption*: The GUI shows the graph on the left, the MST table on the right, and control buttons (Start, Pause, New Graph) at the bottom.

## How to Run the Project
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/BaiSakinaAbad/kruskal-simulation.git
   ```
2. **Open in IntelliJ IDEA**:
   - Open IntelliJ IDEA.
   - Select `File > Open` and navigate to the cloned repository folder.
   - Open the project.
3. **Compile and Run**:
   - Ensure you have a JDK installed (Java 22 or higher recommended).
   - Compile the project:
     ```bash
     javac -d out src/com/simulation/*.java
     ```
   - Run the application:
     ```bash
     java -cp out com.simulation.KruskalMSTSimulation
     ```
    - ALTERNATIVE: open the src/com.simulation/KruskalMSTSimulation class and run it.
4. **Interact with the Simulation**:
   - Click "Start" to begin the MST simulation.
   - Click "Pause" to pause the simulation.
   - Click "New Graph" to generate a new random graph.

## Project Structure
- **`src/com/simulation/`**:
  - `KruskalMSTSimulation.java`: Main class that sets up the GUI and handles the simulation logic.
  - `KruskalGUIFormNew.java`: GUI form class designed using IntelliJ's GUI Designer.
  - `GraphGenerator.java`: Generates random graphs for the simulation.
  - `KruskalAlgorithm.java`: Implements Kruskal's algorithm to compute the MST.

## License
This project is for educational purposes and does not include a specific license. Please contact the author for usage permissions.

## Acknowledgments
- The simulation is inspired by the Kruskal's algorithm demonstration at [ds2-iiith.vlabs.ac.in](https://ds2-iiith.vlabs.ac.in/exp/min-spanning-trees/kruskals-algorithm/mst_kruskal_demo.html).
- Inspired by standard graph theory visualizations and Java Swing tutorials.
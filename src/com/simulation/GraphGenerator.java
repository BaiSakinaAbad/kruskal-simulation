package com.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphGenerator {
    static class Graph {
        List<KruskalMSTSimulation.Node> nodes;
        List<KruskalMSTSimulation.Edge> edges;

        Graph(List<KruskalMSTSimulation.Node> nodes, List<KruskalMSTSimulation.Edge> edges) {
            this.nodes = nodes;
            this.edges = edges;
        }
    }

    public static Graph getRandomGraph() {
        List<Graph> graphs = new ArrayList<>();
        graphs.add(generateGraph1());
        graphs.add(generateGraph2());
        graphs.add(generateGraph3());

        Random random = new Random();
        Graph selectedGraph = graphs.get(random.nextInt(graphs.size()));

        // Sort edges by weight for Kruskal's algorithm
        selectedGraph.edges.sort((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        return selectedGraph;
    }

    private static Graph generateGraph1() {
        List<KruskalMSTSimulation.Node> nodes = new ArrayList<>();
        List<KruskalMSTSimulation.Edge> edges = new ArrayList<>();

        // Nodes: (x, y, id)
        nodes.add(new KruskalMSTSimulation.Node(100, 100, 0));
        nodes.add(new KruskalMSTSimulation.Node(300, 100, 1));
        nodes.add(new KruskalMSTSimulation.Node(200, 200, 2));
        nodes.add(new KruskalMSTSimulation.Node(100, 300, 3));
        nodes.add(new KruskalMSTSimulation.Node(300, 300, 4));
        nodes.add(new KruskalMSTSimulation.Node(200, 400, 5));

        // Edges: (src, dest, weight)
        edges.add(new KruskalMSTSimulation.Edge(0, 1, 4));
        edges.add(new KruskalMSTSimulation.Edge(0, 2, 3));
        edges.add(new KruskalMSTSimulation.Edge(1, 2, 1));
        edges.add(new KruskalMSTSimulation.Edge(1, 4, 2));
        edges.add(new KruskalMSTSimulation.Edge(2, 3, 4));
        edges.add(new KruskalMSTSimulation.Edge(2, 4, 6));
        edges.add(new KruskalMSTSimulation.Edge(3, 4, 2));
        edges.add(new KruskalMSTSimulation.Edge(3, 5, 3));
        edges.add(new KruskalMSTSimulation.Edge(4, 5, 3));

        return new Graph(nodes, edges);
    }

    private static Graph generateGraph2() {
        List<KruskalMSTSimulation.Node> nodes = new ArrayList<>();
        List<KruskalMSTSimulation.Edge> edges = new ArrayList<>();

        // Nodes: (x, y, id)
        nodes.add(new KruskalMSTSimulation.Node(150, 150, 0));
        nodes.add(new KruskalMSTSimulation.Node(250, 150, 1));
        nodes.add(new KruskalMSTSimulation.Node(150, 250, 2));
        nodes.add(new KruskalMSTSimulation.Node(250, 250, 3));
        nodes.add(new KruskalMSTSimulation.Node(200, 350, 4));

        // Edges: (src, dest, weight)
        edges.add(new KruskalMSTSimulation.Edge(0, 1, 5));
        edges.add(new KruskalMSTSimulation.Edge(0, 2, 2));
        edges.add(new KruskalMSTSimulation.Edge(1, 3, 3));
        edges.add(new KruskalMSTSimulation.Edge(2, 3, 4));
        edges.add(new KruskalMSTSimulation.Edge(2, 4, 6));
        edges.add(new KruskalMSTSimulation.Edge(3, 4, 1));

        return new Graph(nodes, edges);
    }

    private static Graph generateGraph3() {
        List<KruskalMSTSimulation.Node> nodes = new ArrayList<>();
        List<KruskalMSTSimulation.Edge> edges = new ArrayList<>();

        // Nodes: (x, y, id)
        nodes.add(new KruskalMSTSimulation.Node(100, 200, 0));
        nodes.add(new KruskalMSTSimulation.Node(200, 100, 1));
        nodes.add(new KruskalMSTSimulation.Node(300, 200, 2));
        nodes.add(new KruskalMSTSimulation.Node(200, 300, 3));
        nodes.add(new KruskalMSTSimulation.Node(150, 400, 4));
        nodes.add(new KruskalMSTSimulation.Node(250, 400, 5));

        // Edges: (src, dest, weight)
        edges.add(new KruskalMSTSimulation.Edge(0, 1, 3));
        edges.add(new KruskalMSTSimulation.Edge(0, 3, 5));
        edges.add(new KruskalMSTSimulation.Edge(1, 2, 4));
        edges.add(new KruskalMSTSimulation.Edge(2, 3, 2));
        edges.add(new KruskalMSTSimulation.Edge(3, 4, 3));
        edges.add(new KruskalMSTSimulation.Edge(3, 5, 4));
        edges.add(new KruskalMSTSimulation.Edge(4, 5, 2));

        return new Graph(nodes, edges);
    }
}
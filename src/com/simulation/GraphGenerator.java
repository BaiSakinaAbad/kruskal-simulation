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
        graphs.add(generateGraph4());
        graphs.add(generateGraph5());
        graphs.add(generateGraph6());

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

    private static Graph generateGraph4() {
        List<KruskalMSTSimulation.Node> nodes = new ArrayList<>();
        List<KruskalMSTSimulation.Edge> edges = new ArrayList<>();

        // Nodes: (x, y, id) - Form a square
        nodes.add(new KruskalMSTSimulation.Node(150, 150, 0));
        nodes.add(new KruskalMSTSimulation.Node(250, 150, 1));
        nodes.add(new KruskalMSTSimulation.Node(250, 250, 2));
        nodes.add(new KruskalMSTSimulation.Node(150, 250, 3));

        // Edges: (src, dest, weight) - Square cycle with one diagonal
        edges.add(new KruskalMSTSimulation.Edge(0, 1, 2));
        edges.add(new KruskalMSTSimulation.Edge(1, 2, 3));
        edges.add(new KruskalMSTSimulation.Edge(2, 3, 1));
        edges.add(new KruskalMSTSimulation.Edge(3, 0, 4));
        edges.add(new KruskalMSTSimulation.Edge(0, 2, 5)); // Diagonal

        return new Graph(nodes, edges);
    }

    private static Graph generateGraph5() {
        List<KruskalMSTSimulation.Node> nodes = new ArrayList<>();
        List<KruskalMSTSimulation.Edge> edges = new ArrayList<>();

        // Nodes: (x, y, id) - Hexagonal arrangement
        nodes.add(new KruskalMSTSimulation.Node(200, 100, 0));
        nodes.add(new KruskalMSTSimulation.Node(300, 150, 1));
        nodes.add(new KruskalMSTSimulation.Node(350, 250, 2));
        nodes.add(new KruskalMSTSimulation.Node(300, 350, 3));
        nodes.add(new KruskalMSTSimulation.Node(200, 400, 4));
        nodes.add(new KruskalMSTSimulation.Node(100, 350, 5));

        // Edges: (src, dest, weight) - Complete graph (every node connected to every other)
        edges.add(new KruskalMSTSimulation.Edge(0, 1, 4));
        edges.add(new KruskalMSTSimulation.Edge(0, 2, 7));
        edges.add(new KruskalMSTSimulation.Edge(0, 3, 9));
        edges.add(new KruskalMSTSimulation.Edge(0, 4, 6));
        edges.add(new KruskalMSTSimulation.Edge(0, 5, 5));
        edges.add(new KruskalMSTSimulation.Edge(1, 2, 3));
        edges.add(new KruskalMSTSimulation.Edge(1, 3, 5));
        edges.add(new KruskalMSTSimulation.Edge(1, 4, 8));
        edges.add(new KruskalMSTSimulation.Edge(1, 5, 9));
        edges.add(new KruskalMSTSimulation.Edge(2, 3, 2));
        edges.add(new KruskalMSTSimulation.Edge(2, 4, 4));
        edges.add(new KruskalMSTSimulation.Edge(2, 5, 7));
        edges.add(new KruskalMSTSimulation.Edge(3, 4, 3));
        edges.add(new KruskalMSTSimulation.Edge(3, 5, 6));
        edges.add(new KruskalMSTSimulation.Edge(4, 5, 5));

        return new Graph(nodes, edges);
    }

    private static Graph generateGraph6() {
        List<KruskalMSTSimulation.Node> nodes = new ArrayList<>();
        List<KruskalMSTSimulation.Edge> edges = new ArrayList<>();

        // Nodes: (x, y, id) - Star-like pattern with central node
        nodes.add(new KruskalMSTSimulation.Node(250, 250, 0)); // Central node
        nodes.add(new KruskalMSTSimulation.Node(150, 150, 1));
        nodes.add(new KruskalMSTSimulation.Node(350, 150, 2));
        nodes.add(new KruskalMSTSimulation.Node(100, 250, 3));
        nodes.add(new KruskalMSTSimulation.Node(400, 250, 4));
        nodes.add(new KruskalMSTSimulation.Node(150, 350, 5));
        nodes.add(new KruskalMSTSimulation.Node(350, 350, 6));

        // Edges: (src, dest, weight) - Central node connected to all, plus some peripheral edges
        edges.add(new KruskalMSTSimulation.Edge(0, 1, 3));
        edges.add(new KruskalMSTSimulation.Edge(0, 2, 3));
        edges.add(new KruskalMSTSimulation.Edge(0, 3, 2));
        edges.add(new KruskalMSTSimulation.Edge(0, 4, 2));
        edges.add(new KruskalMSTSimulation.Edge(0, 5, 4));
        edges.add(new KruskalMSTSimulation.Edge(0, 6, 4));
        edges.add(new KruskalMSTSimulation.Edge(1, 3, 5));
        edges.add(new KruskalMSTSimulation.Edge(2, 4, 5));
        edges.add(new KruskalMSTSimulation.Edge(3, 5, 6));
        edges.add(new KruskalMSTSimulation.Edge(4, 6, 6));
        edges.add(new KruskalMSTSimulation.Edge(1, 2, 7));
        edges.add(new KruskalMSTSimulation.Edge(5, 6, 7));

        return new Graph(nodes, edges);
    }
}
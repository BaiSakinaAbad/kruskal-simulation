package com.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

public class KruskalMSTSimulation extends JFrame {
    private KruskalGUIFormNew guiForm;
    private GraphPanel graphPanel;
    private List<Edge> mstEdges;
    private int totalWeight;
    private boolean isPaused;

    public KruskalMSTSimulation() {
        setTitle("Kruskal's MST Simulation");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize GUI form
        guiForm = new KruskalGUIFormNew();
        setContentPane(guiForm.getMainPanel());
        guiForm.getResultTable().getTableHeader().setBackground(new Color(255, 193, 231));
        guiForm.getResultTable().getTableHeader().setOpaque(true);

        // Initialize graph panel
        graphPanel = new GraphPanel();
        guiForm.getGraphPanelContainer().add(graphPanel);

        // Button actions
        guiForm.getStartButton().addActionListener(e -> {
            if (isPaused) {
                isPaused = false;
                synchronized (graphPanel) {
                    graphPanel.notify();
                }
            } else {
                guiForm.getStartButton().setEnabled(false);
                guiForm.getPauseButton().setEnabled(true);
                guiForm.getNewGraphButton().setEnabled(false);
                new Thread(() -> graphPanel.runSimulation()).start();
            }
        });

        guiForm.getPauseButton().addActionListener(e -> {
            isPaused = true;
            guiForm.getPauseButton().setEnabled(false);
            guiForm.getStartButton().setEnabled(true);
        });

        guiForm.getNewGraphButton().addActionListener(e -> {
            graphPanel.resetGraph();
            guiForm.getStartButton().setEnabled(true);
            guiForm.getPauseButton().setEnabled(false);
            guiForm.getNewGraphButton().setEnabled(true);
            guiForm.getResultTable().setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{}, new String[]{"Source", "Destination", "Weight"}
            ));
        });

        // Initial button states
        guiForm.getPauseButton().setEnabled(false);
    }

    class GraphPanel extends JPanel {
        private List<Node> nodes;
        private List<Edge> edges;
        private List<Edge> mst;
        private int currentEdgeIndex;

        public GraphPanel() {
            setBackground(new Color(246, 223, 235));
            setOpaque(true);
            resetGraph();
        }

        public void resetGraph() {
            GraphGenerator.Graph graph = GraphGenerator.getRandomGraph();
            nodes = graph.nodes;
            edges = graph.edges;
            mst = new ArrayList<>();
            currentEdgeIndex = -1;
            repaint();
        }

        public void runSimulation() {
            mst.clear();
            totalWeight = 0;
            currentEdgeIndex = -1;
            KruskalAlgorithm kruskal = new KruskalAlgorithm(nodes.size());
            mstEdges = new ArrayList<>();

            for (Edge edge : edges) {
                currentEdgeIndex++;
                if (kruskal.union(edge.src, edge.dest)) {
                    mst.add(edge);
                    mstEdges.add(edge);
                    totalWeight += edge.weight;
                }
                repaint();
                try {
                    synchronized (this) {
                        while (isPaused) {
                            wait();
                        }
                    }
                    Thread.sleep(1000); // 1-second delay for visualization
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Update table
            updateResultTable();
            guiForm.getStartButton().setEnabled(true);
            guiForm.getPauseButton().setEnabled(false);
            guiForm.getNewGraphButton().setEnabled(true);
        }

        private void updateResultTable() {
            String[] columns = {"Source", "Destination", "Weight"};
            Object[][] data = new Object[mstEdges.size() + 1][3];
            for (int i = 0; i < mstEdges.size(); i++) {
                Edge e = mstEdges.get(i);
                data[i][0] = e.src;
                data[i][1] = e.dest;
                data[i][2] = e.weight;
            }
            data[mstEdges.size()][0] = "Total";
            data[mstEdges.size()][1] = "";
            data[mstEdges.size()][2] = totalWeight;

            guiForm.getResultTable().setModel(new javax.swing.table.DefaultTableModel(data, columns));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw edges
            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                Node src = nodes.get(e.src);
                Node dest = nodes.get(e.dest);
                if (mst.contains(e)) {
                    g2d.setColor(Color.GREEN);
                    g2d.setStroke(new BasicStroke(10)); //accepted
                } else if (i == currentEdgeIndex) {
                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(5)); // rejected
                } else {
                    g2d.setColor(Color.BLACK);
                    g2d.setStroke(new BasicStroke(1)); // initial
                }
                g2d.drawLine(src.x, src.y, dest.x, dest.y);

                // Draw weight
                int midX = (src.x + dest.x) / 2;
                int midY = (src.y + dest.y) / 2;
                g2d.setColor(Color.BLACK);
                g2d.drawString(String.valueOf(e.weight), midX, midY);
            }

            // Draw nodes
            for (Node node : nodes) {
                g2d.setColor(new Color(171, 138, 158));
                g2d.fillOval(node.x - 15, node.y - 15, 30, 30);
                g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(node.id), node.x - 5, node.y + 5);
            }
        }
    }

    static class Node {
        int x, y, id;

        public Node(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KruskalMSTSimulation().setVisible(true);
        });
    }
}
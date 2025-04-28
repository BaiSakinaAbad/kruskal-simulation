package com.simulation;

import javax.swing.*;
import java.awt.*;

public class KruskalGUIFormNew {
    private JPanel mainPanel;
    private JPanel controlPanel;
    private JPanel graphPanelContainer;
    private JButton startButton;
    private JButton pauseButton;
    private JButton newGraphButton;
    private JTable resultTable;
    private JScrollPane tableScrollPane;

    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        graphPanelContainer = new JPanel();
        graphPanelContainer.setLayout(new BorderLayout());
        mainPanel.add(graphPanelContainer, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        startButton = new JButton("Start");
        controlPanel.add(startButton);

        pauseButton = new JButton("Pause");
        controlPanel.add(pauseButton);

        newGraphButton = new JButton("New Graph");
        controlPanel.add(newGraphButton);

        tableScrollPane = new JScrollPane();
        mainPanel.add(tableScrollPane, BorderLayout.EAST);

        resultTable = new JTable();
        tableScrollPane.setViewportView(resultTable);
    }

    // Getter methods for components
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getGraphPanelContainer() {
        return graphPanelContainer;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getNewGraphButton() {
        return newGraphButton;
    }

    public JTable getResultTable() {
        return resultTable;
    }
}
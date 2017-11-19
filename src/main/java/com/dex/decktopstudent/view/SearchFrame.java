package com.dex.decktopstudent.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.dex.decktopstudent.controller.Manager;
import com.dex.decktopstudent.controller.StudentManager;
import com.dex.decktopstudent.model.Student;

public class SearchFrame extends JFrame {

    private Manager<Student> manager = StudentManager.getInstance();

    private JLabel nameLable = new JLabel("Enter student name");

    private JTextArea nameTextArea = new JTextArea();

    private JButton searchButton = new JButton("Search");
    private JButton cancelButton = new JButton("Cancel");

    private JPanel southPanel = new JPanel();
    private JPanel mainPanel = new JPanel();

    private JTable table;

    private Map<String, Integer> rows = manager.getMap();

    public SearchFrame(JTable table) {
        this.table = table;
        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search windows");
        init();
        setResizable(false);
        setActionListener();
    }

    private void init() {
        nameTextArea.setColumns(30);

        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(searchButton);
        southPanel.add(cancelButton);

        getContentPane().add(southPanel, BorderLayout.SOUTH);

        mainPanel.add(nameLable);
        mainPanel.add(nameTextArea);

        add(mainPanel);
    }

    private void setActionListener() {
        cancelButton.addActionListener(e -> dispose());

        searchButton.addActionListener(e -> {
            String name = nameTextArea.getText();
            table.clearSelection();

            int row = rows.get(name);

            table.setRowSelectionInterval(row, row);
            table.updateUI();

        });

    }

}

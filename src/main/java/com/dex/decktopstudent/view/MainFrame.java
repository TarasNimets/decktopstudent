package com.dex.decktopstudent.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import com.dex.decktopstudent.controller.Manager;
import com.dex.decktopstudent.controller.StudentManager;
import com.dex.decktopstudent.model.Student;

public class MainFrame extends JFrame {

    private Manager<Student> manager = StudentManager.getInstance();

    private JButton saveButton = new JButton("Save");
    private JButton editButton = new JButton("Edit");
    private JButton removeButton = new JButton("Remove");
    private JButton searchButton = new JButton("Search");

    private JTable table = new JTable(new TableModel());
    private JScrollPane scrol = new JScrollPane(table);

    private JPanel mainPanel = new JPanel();
    private JPanel northPanel = new JPanel();

    MainFrame() {
        setVisible(true);
        setSize(400, 400);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("StudentManager");
        setActionListener();
        init();
        setVisible(true);
    }

    private void init() {

        mainPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new GridLayout(1, 4));

        northPanel.add(saveButton);
        northPanel.add(editButton);
        northPanel.add(searchButton);
        northPanel.add(removeButton);

        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(scrol, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void setActionListener() {
        saveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new SaveFrame(table);
            }

        });

        removeButton.addActionListener(e -> {
            int i = table.getSelectedRow();
            manager.remove(i);
            table.updateUI();
        });

        editButton.addActionListener(e -> {
            int i = table.getSelectedRow();
            new SaveFrame(i, table);
        });

        searchButton.addActionListener(e -> new SearchFrame(table));
    }

}

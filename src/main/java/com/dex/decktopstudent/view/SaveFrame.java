package com.dex.decktopstudent.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.dex.decktopstudent.controller.Manager;
import com.dex.decktopstudent.controller.StudentManager;
import com.dex.decktopstudent.model.Degree;
import com.dex.decktopstudent.model.Student;
import com.dex.decktopstudent.model.Student.StudentBuilder;
import com.dex.decktopstudent.model.Teacher;
import com.dex.decktopstudent.model.Teacher.TeacherBulder;

public class SaveFrame extends JFrame {

    private Manager<Student> manager = StudentManager.getInstance();

    private JLabel nameLable = new JLabel("Student name");
    private JLabel ageLable = new JLabel("Student age");
    private JLabel ballLable = new JLabel("Student ball");
    private JLabel teacherNameLable = new JLabel("Teacher name");
    private JLabel teacherAgeLable = new JLabel("Teacher age");
    private JLabel teacherDegreeLable = new JLabel("Teacher degree");
    private JLabel teacherSalaryLable = new JLabel("Teacher salary");

    private JTextArea nameTextArea = new JTextArea();
    private JTextArea ageTextArea = new JTextArea();
    private JTextArea ballTextArea = new JTextArea();
    private JTextArea teacherNameTextArea = new JTextArea();
    private JTextArea teacherAgeTextArea = new JTextArea();
    private JTextArea teacherDegreeTextArea = new JTextArea();
    private JTextArea teacherSalaryTextArea = new JTextArea();

    private JButton saveButton = new JButton("save");
    private JButton cancelButton = new JButton("cancel");

    private JPanel southPanel = new JPanel();
    private JPanel mainPanel = new JPanel();

    private int statusSaveButton;
    private int i;

    private JTable table;

    public SaveFrame(JTable table) {
        this.table = table;
        statusSaveButton = 1;
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Save windows");
        init();
        setResizable(false);
        setActionListener();
        setVisible(true);
    }

    public SaveFrame(int i, JTable table) {
        statusSaveButton = 2;
        this.table = table;
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Save windows");
        init();
        setResizable(false);
        setActionListener();
        this.i = i;
        setVisible(true);
    }

    private void init() {
        nameTextArea.setColumns(30);
        ageTextArea.setColumns(30);
        ballTextArea.setColumns(30);
        teacherNameTextArea.setColumns(30);
        teacherAgeTextArea.setColumns(30);
        teacherDegreeTextArea.setColumns(30);
        teacherSalaryTextArea.setColumns(30);

        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(saveButton);
        southPanel.add(cancelButton);

        getContentPane().add(southPanel, BorderLayout.SOUTH);

        mainPanel.add(nameLable);
        mainPanel.add(nameTextArea);
        mainPanel.add(ageLable);
        mainPanel.add(ageTextArea);
        mainPanel.add(ballLable);
        mainPanel.add(ballTextArea);
        mainPanel.add(teacherNameLable);
        mainPanel.add(teacherNameTextArea);
        mainPanel.add(teacherAgeLable);
        mainPanel.add(teacherAgeTextArea);
        mainPanel.add(teacherDegreeLable);
        mainPanel.add(teacherDegreeTextArea);
        mainPanel.add(teacherSalaryLable);
        mainPanel.add(teacherSalaryTextArea);

        add(mainPanel);
    }

    private void setActionListener() {
        cancelButton.addActionListener(e -> dispose());

        saveButton.addActionListener(e -> {
            if (statusSaveButton == 1) {
                try {
                    manager.save(getStudent());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Wrong input data", "Incorrect data",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (statusSaveButton == 2) {
                try {
                    manager.edit(getStudent(), i);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Wrong input data", "Incorrect data",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            table.updateUI();
            dispose();
        });
    }

    private Student getStudent() {
        StudentBuilder student = new StudentBuilder();
        student.setName(nameTextArea.getText());
        student.setAge(Integer.parseInt(ageTextArea.getText()));
        student.setBall(Double.parseDouble(ballTextArea.getText()));
        student.setTeacher(getTeacher());

        return student.build();
    }

    private Teacher getTeacher() {
        TeacherBulder teacher = new TeacherBulder();
        teacher.setName(teacherNameTextArea.getText());
        teacher.setAge(Integer.parseInt(teacherAgeTextArea.getText()));
        teacher.setDegree(Degree.getDegree(teacherDegreeTextArea.getText()));
        teacher.setSalary(Integer.parseInt(teacherSalaryTextArea.getText()));

        return teacher.build();

    }
}

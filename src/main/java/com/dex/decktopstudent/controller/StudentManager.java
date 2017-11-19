package com.dex.decktopstudent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dex.decktopstudent.model.Student;

public class StudentManager implements Manager<Student> {

    private static Map<String, Integer> rows = new HashMap<>();
    private static final StudentManager MANAGER = new StudentManager();
    private List<Student> studentList = SrudentSeriaLiser.init();

    private StudentManager() {
    }

    public Map<String, Integer> getMap() {
        return rows;
    }

    public static StudentManager getInstance() {
        return MANAGER;
    }

    public Student search(int i) {
        return studentList.get(i);
    }

    public void save(Student student) {
        studentList.add(student);
        SrudentSeriaLiser.save(studentList);
    }

    public void remove(int i) {
        studentList.remove(i);
        SrudentSeriaLiser.save(studentList);

    }

    public void edit(Student student, int i) {
        studentList.set(i, student);
        SrudentSeriaLiser.save(studentList);
    }

    public List<Student> getAll() {
        return studentList;
    }

}

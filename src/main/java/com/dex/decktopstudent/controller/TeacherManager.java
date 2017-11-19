package com.dex.decktopstudent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dex.decktopstudent.model.Teacher;

public class TeacherManager implements Manager<Teacher> {

    private static Map<String, Integer> rows = new HashMap<>();
    private List<Teacher> teachetList = new ArrayList<>();

    public Map<String, Integer> getMap() {
        return rows;
    }

    public void save(Teacher teacher) {
        teachetList.add(teacher);
    }

    public void remove(int i) {
        teachetList.remove(i);
    }

    public void edit(Teacher teacher, int i) {
        teachetList.set(i, teacher);
    }

    public Teacher search(int i) {
        return teachetList.get(i);
    }

    public List<Teacher> getAll() {
        return teachetList;
    }

}

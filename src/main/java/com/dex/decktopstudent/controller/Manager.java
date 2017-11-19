package com.dex.decktopstudent.controller;

import java.util.List;
import java.util.Map;

public interface Manager<T> {

    void save(T person);

    void remove(int i);

    void edit(T person, int i);

    T search(int i);

    List<T> getAll();

    Map<String, Integer> getMap();

}

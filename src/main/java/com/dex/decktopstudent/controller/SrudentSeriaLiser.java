package com.dex.decktopstudent.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.dex.decktopstudent.model.Student;

public class SrudentSeriaLiser {

    private final static String FILE_NAME = "Student.data";

    public static void save(List<Student> student) {
        try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {

            objectOutputStream.writeObject(student);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Student> init() {
        try (FileInputStream inputStream = new FileInputStream(FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);) {

            List<Student> students = (List<Student>) objectInputStream.readObject();
            return students;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ArrayList<>();
    }

}

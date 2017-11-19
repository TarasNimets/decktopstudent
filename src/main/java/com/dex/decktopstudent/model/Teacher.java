package com.dex.decktopstudent.model;

import java.io.Serializable;

public class Teacher implements Serializable {

    private static final Teacher defaultTeacher = new Teacher("HIO", 55, Degree.DEFAULT, 1000);

    public final String name;
    public final int age;
    public final Degree degree;
    public final int salary;

    public Teacher(String name, int age, Degree degree, int salary) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.salary = salary;
    }

    public static Teacher getInstance() {
        return defaultTeacher;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((degree == null) ? 0 : degree.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + salary;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Teacher other = (Teacher) obj;
        if (age != other.age)
            return false;
        if (degree != other.degree)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (salary != other.salary)
            return false;
        return true;
    }

    public String toString() {
        return "Name - " + name + ", age - " + age + ", Degree - " + degree + ", Salary - " + salary;
    }

    public static class TeacherBulder {

        private String name;
        private int age;
        private Degree degree;
        private int salary;

        public TeacherBulder() {

        }

        public TeacherBulder setName(String name) {
            this.name = name;
            return this;
        }

        public TeacherBulder setAge(int age) {
            this.age = age;
            return this;
        }

        public TeacherBulder setDegree(Degree degree) {
            this.degree = degree;
            return this;
        }

        public TeacherBulder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public Teacher build() {
            return new Teacher(name, age, degree, salary);
        }
    }

}

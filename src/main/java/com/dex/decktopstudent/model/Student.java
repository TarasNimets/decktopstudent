package com.dex.decktopstudent.model;

import java.io.Serializable;

public class Student implements Serializable {

    private static final Student defaultStudent = new Student("Ivan", 21, 2.3, Teacher.getInstance());

    public final String name;
    public final int age;
    public final double ball;
    public final Teacher teacher;

    public Student(String name, int age, double ball, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.ball = ball;
        this.teacher = teacher;
    }

    public static Student getInstance() {
        return defaultStudent;
    }

    public String toString() {
        return "Student name - " + name + ", Age - " + age + ", Ball - " + ball + ", Teacher {" + teacher + "}";
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        long temp;
        temp = Double.doubleToLongBits(ball);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (age != other.age)
            return false;
        if (Double.doubleToLongBits(ball) != Double.doubleToLongBits(other.ball))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (teacher == null) {
            if (other.teacher != null)
                return false;
        } else if (!teacher.equals(other.teacher))
            return false;
        return true;
    }

    public static class StudentBuilder {

        private String name;
        private int age;
        private double ball;
        private Teacher teacher;

        public StudentBuilder() {

        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setBall(double ball) {
            this.ball = ball;
            return this;
        }

        public StudentBuilder setTeacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public Student build() {
            return new Student(name, age, ball, teacher);
        }

    }

}

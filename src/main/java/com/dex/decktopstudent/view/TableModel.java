package com.dex.decktopstudent.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import com.dex.decktopstudent.controller.Manager;
import com.dex.decktopstudent.controller.StudentManager;
import com.dex.decktopstudent.model.Student;

public class TableModel extends AbstractTableModel {

    private Manager<Student> manager = StudentManager.getInstance();
    private Map<String, Integer> rows = manager.getMap();

    public int getColumnCount() {
        return 7;
    }

    public int getRowCount() {
        return manager.getAll().size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = manager.getAll().get(rowIndex);
        rows.put(student.name, rowIndex);
        ColumnName name = ColumnName.getColumnName(columnIndex);
        switch (name) {
        case NAME:
            return student.name;
        case AGE:
            return student.age;
        case BALL:
            return student.ball;
        case TEACHER_NAME:
            return student.teacher.name;
        case TEACHER_AGE:
            return student.teacher.age;
        case TEACHER_DEGREE:
            return student.teacher.degree;
        case TEACHER_SALARY:
            return student.teacher.salary;
        }
        return " ";
    }

    public String getColumnName(int column) {
        ColumnName name = ColumnName.getColumnName(column);
        switch (name) {
        case NAME:
            return ColumnName.NAME.name();
        case AGE:
            return ColumnName.AGE.name();
        case BALL:
            return ColumnName.BALL.name();
        case TEACHER_NAME:
            return ColumnName.TEACHER_NAME.name();
        case TEACHER_AGE:
            return ColumnName.TEACHER_AGE.name();
        case TEACHER_DEGREE:
            return ColumnName.TEACHER_DEGREE.name();
        case TEACHER_SALARY:
            return ColumnName.TEACHER_SALARY.name();
        }
        return " ";
    }

    public enum ColumnName {

        NAME, AGE, BALL, TEACHER_NAME, TEACHER_AGE, TEACHER_DEGREE, TEACHER_SALARY, DEFAULT;

        private static Map<Integer, ColumnName> map = new HashMap<>();

        static {
            map.put(NAME.ordinal(), NAME);
            map.put(AGE.ordinal(), AGE);
            map.put(BALL.ordinal(), BALL);
            map.put(TEACHER_NAME.ordinal(), TEACHER_NAME);
            map.put(TEACHER_AGE.ordinal(), TEACHER_AGE);
            map.put(TEACHER_DEGREE.ordinal(), TEACHER_DEGREE);
            map.put(TEACHER_SALARY.ordinal(), TEACHER_SALARY);
            map.put(DEFAULT.ordinal(), DEFAULT);
        }

        private static ColumnName getColumnName(int i) {
            if (map.containsKey(i)) {
                return map.get(i);
            }

            return DEFAULT;
        }
    }
}

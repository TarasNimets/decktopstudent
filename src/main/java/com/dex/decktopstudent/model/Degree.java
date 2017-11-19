package com.dex.decktopstudent.model;

import java.io.Serializable;

public enum Degree implements Serializable {

    PREPOD("df"), LABORANT, PROFFESOR, DEFAULT;

    private Degree(String degree) {
    }

    private Degree() {
    }

    public static Degree getDegree(String degree) {
        if (degree.isEmpty() || degree == null) {
            return DEFAULT;
        }
        for (Degree d : Degree.values()) {
            if (degree.equals(d.toString())) {
                return d;
            }
        }
        return DEFAULT;

    }
}

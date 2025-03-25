package com.mycompany.JavaY2.Class;

import java.util.ArrayList;

public class Matrix {
    public static String[][] removeEmptyRows(String[][] matrix) {
        ArrayList<String[]> filteredRows = new ArrayList<>();

        for (String[] row : matrix) {
            boolean hasEmpty = false;
            for (String value : row) {
                if (value == null || value.trim().isEmpty()) {
                    hasEmpty = true;
                    break;
                }
            }
            if (!hasEmpty) {
                filteredRows.add(row);
            }
        }

        return filteredRows.toArray(new String[0][]);
    }
}

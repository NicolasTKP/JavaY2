package com.mycompany.JavaY2.Class;

import java.util.IllegalFormatException;

public class ValidateFormat {

    public static boolean quantityUnit(String quantity){
        try {
            Integer.parseInt(quantity);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean unitPrice(String unitPrice){
        try {
            Double.parseDouble(unitPrice);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean date(String date) {
        return date.matches("\\d{2}\\d{2}\\d{4}");
    }
}

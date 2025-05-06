package com.mycompany.JavaY2.Class;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean username(String username){
        String[] usernames = Query.getAllUsername();
        if (username.length() <4){
            return false;
        }
        for(String item:usernames){
            if(item.equals(username)){
                return false;
            }
        }
        return true;
    }

    public static boolean password(String password){
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{7,}$";
        return password.matches(regex);
    }

    public static boolean itemName(String item_name){
        String[] items = Query.getAllItemGroup();
        for (String item:items){
            if(item.equals(item_name)){
                return false;
            }
        }
        return true;
    }

    public static boolean supplierName(String supplier_name){
        String[] suppliers = Query.getAllSupplier();
        for (String supplier:suppliers){
            if(supplier.equals(supplier_name)){
                return false;
            }
        }
        return true;
    }

    public static boolean contact(String contact){
        String[] contacts = Query.getAllContact();
        String regex = "^01[0-9]-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contact);
        if (matcher.matches()){
            for (String item:contacts){
                if (item.equals(contact)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean prItems(String groupID){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));

            for (int i=1;i<linesList.size();i++){
                String line = linesList.get(i);
                String[] column = line.split("\\|");
                if (column[6].equals("Pending")&&column[1].equals(groupID)){
                    return false;
                }
            }
            return true;

        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

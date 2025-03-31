package com.mycompany.JavaY2.Class;

import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.PurchaseOrder;
import com.mycompany.JavaY2.Object.Receives;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Query {

    public static String getLatestOrderID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(1));
            number++;
            return String.format("%s%03d", "O", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getLatestUserID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(1));
            number++;
            return String.format("%s%03d", "U", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getPendingPR(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));
            List<String> res = new ArrayList<>();
            for (String line:linesList){
                String[] column = line.split("\\|");
                if (column[column.length-1].equals("Pending")){
                    res.add(column[0]);
                }
            }
            return res.toArray(new String[0]);


        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean ifItemExist(String itemID){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            for (String line:linesList){
                String[] column = line.split("\\|");
                if (column[0].equalsIgnoreCase(itemID)){
                    return true;
                }
            }
            return false;

        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean ifUserExist(String username){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            for (String line:linesList){
                String[] column = line.split("\\|");
                if (column[1].equalsIgnoreCase(username)){
                    return true;
                }
            }
            return false;

        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] getAllSupplier(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String[] ls = new String[linesList.size()-1];
            for (int i=1;i<linesList.size();i++){
                String line = linesList.get(i);
                String[] column = line.split("\\|");
                ls[i-1] = column[1];
            }
            return ls;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

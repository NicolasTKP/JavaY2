/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author acer
 */
public class Search {

    public static String getUsername(String userID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(userID.toUpperCase())){
                    return line.split("\\|")[1];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getItemNamebyItemID(String itemID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(itemID.toUpperCase())){
                    return line.split("\\|")[1];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getItemNamebyGroupID(String groupID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(groupID.toUpperCase())){
                    return line.split("\\|")[1];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getItemID(String supplierID, String groupID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[6].equals(supplierID.toUpperCase()) && line.split("\\|")[7].equals(groupID.toUpperCase())){
                    return line.split("\\|")[0];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getGroupIDbyItemName(String item_name){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[1].equals(item_name)){
                    return line.split("\\|")[0];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSupplierName(String supplierID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(supplierID.toUpperCase())){
                    return line.split("\\|")[1];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSupplierID(String supplier_name){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[1].equals(supplier_name)){
                    return line.split("\\|")[0];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUserID(String username){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[1].equals(username)){
                    return line.split("\\|")[0];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDeliveryStatus(String orderID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(orderID.toUpperCase())){
                    return line.split("\\|")[6];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPaymentStatus(String orderID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(orderID.toUpperCase())){
                    return line.split("\\|")[8];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDateReceived(String orderID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(orderID.toUpperCase())){
                    return line.split("\\|")[5];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPaymentDate(String orderID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(orderID.toUpperCase())){
                    return line.split("\\|")[7];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getSuppliersByGroupID(String groupID){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            List<String> ls = new ArrayList<>();
            for (int i=1;i<linesList.size();i++){
                String line = linesList.get(i);
                String[] column = line.split("\\|");
                if (column[7].equals(groupID)){
                    ls.add(Search.getSupplierName(column[6]));
                }
            }
            return Arrays.copyOf(ls.toArray(), ls.toArray().length, String[].class);
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getRetailPrice(String groupID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(groupID.toUpperCase())){
                    return line.split("\\|")[3];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFromPR(String requestID, int column){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(requestID.toUpperCase())){
                    return line.split("\\|")[column];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFromInventory(String groupID, int column){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(groupID.toUpperCase())){
                    return line.split("\\|")[column];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFromItems(String itemID, int column){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(itemID.toUpperCase())){
                    return line.split("\\|")[column];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFromPO(String orderID, int column){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(orderID.toUpperCase())){
                    return line.split("\\|")[column];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFromSuppliers(String supplierID, int column){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(supplierID.toUpperCase())){
                    return line.split("\\|")[column];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

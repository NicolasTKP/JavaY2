/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.FinanceManagerGUI;

import com.mycompany.JavaY2.Object.SessionManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;


public class FinanceManagerFunction {
    public static void editFMProfile(String currentUsername, String fmUsername, String fmPassword, String fmRole) {

        List<String> updatedLs = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/users"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] column = line.split("\\|");
                if (currentUsername.equals(column[1])) {
                    column[1] = fmUsername;
                    column[2] = fmPassword;
                    column[3] = fmRole;
                    updated = true;
                }
                updatedLs.add(String.join("|", column));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/users"))) {
                for (String row : updatedLs) {
                    bw.write(row);
                    bw.newLine();
                    SessionManager.getInstance().username = fmUsername;
                }

                JOptionPane.showMessageDialog(null, "Profile has been updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error writing file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You are not allowed to change others' credentials", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    
//     public static String getSupplierID(String itemID){
//        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"))){
//            String line; 
//            while((line = br.readLine()) != null){
//                String[] columns = line.split("\\|");
//                String[] itemIDs = columns[4].split(",");
//                for (String id : itemIDs){
//                    if (id.equals(itemID)){
//                         return columns[0];
//                    }
//                }
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return "Supplier ID not found";
//    }
     
//    public static List<String> getSupplierNames(String itemName){
//        Map<String, String> itemToSupplier = new HashMap<>(); // itemID -> supplierID
//        Map<String, String> supplierName = new HashMap<>(); // supplierID -> supplierName
//        //Read items file to get supplier id based on corresponding item id
//        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] column = line.split("\\|");
//                if (column[1].equals(itemName)) {
//                    itemToSupplier.put(column[0], column[6]); // itemID -> supplierID
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        // Read suppliers file to get supplier name for corresponding supplier ID
//        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] columns = line.split("\\|");
//                supplierName.put(columns[0], columns[1]); // supplierID -> supplierName
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        // Get supplier names for the given item
//        Set<String> supplierNames = new HashSet<>();
//        for (String supplierID : itemToSupplier.values()) {
//            if (supplierName.containsKey(supplierID)) {
//                supplierNames.add(supplierName.get(supplierID));
//            }
//        }
//        
//        return new ArrayList<>(supplierNames);
//    }
    
    public static void payment(String orderID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/receives", false));
            String[] items;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                items = line.split("\\|");
                if (items.length>column && items[0].equals(orderID)){
                    items[column] = value;
                }
                bw.write(String.join("|",items));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}

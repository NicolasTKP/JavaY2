package com.mycompany.JavaY2;

import com.mycompany.JavaY2.Class.Edit;
import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.SessionManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
//        SessionManager.getInstance().username = "hello";
//        System.out.println(SessionManager.getInstance().username);
        String itemName = "apple"; // Example item name to search for
        List<String> suppliers = getSuppliersForItem(itemName);
        
        System.out.println("Suppliers for " + itemName + ": " + suppliers);
    }
    public static List<String> getSuppliersForItem(String itemName) {
        Map<String, String> itemToSupplierMap = new HashMap<>(); // itemID -> supplierID
        Map<String, String> supplierNameMap = new HashMap<>(); // supplierID -> supplierName
        
        // Read items file to get itemID -> supplierID mapping
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns[1].equalsIgnoreCase(itemName)) { // Match item name
                    itemToSupplierMap.put(columns[0], columns[6]); // itemID -> supplierID
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Read suppliers file to get supplierID -> supplierName mapping
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");
                supplierNameMap.put(columns[0], columns[1]); // supplierID -> supplierName
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Get unique supplier names for the given item
        Set<String> supplierNames = new HashSet<>();
        for (String supplierID : itemToSupplierMap.values()) {
            if (supplierNameMap.containsKey(supplierID)) {
                supplierNames.add(supplierNameMap.get(supplierID));
            }
        }
        
        return new ArrayList<>(supplierNames);
    }
}

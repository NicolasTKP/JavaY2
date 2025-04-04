/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Supplier {
    public String supplier_id;
    public String supplier_name;
    public String address;
    public String contact_number;
    public String supply_items;
    String payment_term;

    public Supplier(){
        
    }
    
    public Supplier(String supplier_id, String supplier_name, String address, String contact_number, String supply_items, String payment_term){
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.address = address;
        this.contact_number = contact_number;
        this.supply_items = supply_items;
        this.payment_term = payment_term;
    }
    

    public static String getNextSupplierID() {
        String lastSupplierId = null;
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\suppliers";

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                lastSupplierId = line.split("\\|")[0]; // Get first column (item_id)
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }

        // If no lastItemId found, return the first ID as "I001"
        if (lastSupplierId == null) {
            return "SU001";
        }

        // Extract numeric part and increment
        if (lastSupplierId.startsWith("SU")) {
            try {
                int lastNumber = Integer.parseInt(lastSupplierId.substring(2)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("SU%03d", newNumber); // 
                
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    public String getSupplierID() {
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\suppliers";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Split by '|'
                supplier_id =  columns[0]; // Return the Item ID
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return supplier_id;
    }

    public String setSupplierID(){
        this.supplier_id = getNextSupplierID();
        return this.supplier_id;
    }
    
    public void editSupplierID(String supplier_id){
        this.supplier_id = supplier_id;
    }
    
    public String getSupplierName(){
        return supplier_name;
    }
    
    public void setSupplierName(String supplier_name){
        if (supplier_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter supplier name.");
        }
        this.supplier_name = supplier_name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        if (address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter supplier address.");
        }
        this.address = address;
    }
    
    public String getContact(){
        return contact_number;
    }

    public void setContact(String contact_number) {
        contact_number = contact_number.replaceAll("[^0-9]", ""); // Remove non-numeric characters

        if (contact_number.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter supplier's contact number.");
            return; // Stop execution
        } else if (contact_number.length() == 10) {
            contact_number = contact_number.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        } else if (contact_number.length() == 11) {
            contact_number = contact_number.replaceAll("(\\d{3})(\\d{3})(\\d{5})", "$1-$2-$3");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid contact number length. Must be 10 or 11 digits.");
            return; // Stop execution if invalid
        }

        this.contact_number = contact_number;
    }
    
    public String getSupplyItems() {
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\suppliers";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Split by '|'
                if (columns.length == 5 && columns[0].equals(this.supplier_id)) { // Check if supplier ID matches
                    return columns[4]; // Return the supply_items column
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file");
        }
        return null; // Return null if supplier ID is not found
    }

    public String setSupplyItems(String supply_items) {
        Map<String, String> itemMap = new HashMap<>();
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\items";
        // Read items.txt and create a map (item_name -> item_id)
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns.length > 1) {
                    itemMap.put(columns[1].toLowerCase(), columns[0]); // item_name -> item_id
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file");
        }
        
        StringBuilder itemIDList = new StringBuilder();
        String[] supplyItemsArray = supply_items.trim().split(",");      
        
        for (String supplyItem : supplyItemsArray) {
            supplyItem = supplyItem.trim().toLowerCase();
            if (itemMap.containsKey(supplyItem)) {
                if (itemIDList.length() > 0) {
                    itemIDList.append(", ");
                }
                itemIDList.append(itemMap.get(supplyItem));
            } else{
                JOptionPane.showMessageDialog(null, "Item is not found. Please enter the item details first ");
            }
        }
        
        return itemIDList.toString();
    }
    
    
    public String getPaymentTerm(){
        return payment_term;
    }

    public void setPaymentTerm(String payment_term){
        if (payment_term.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter supplier's payment term.");
        }
        this.payment_term = payment_term;
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    

    public Supplier(){
        
    }
    
    public Supplier(String supplier_id, String supplier_name, String address, String contact_number, String supply_items){
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.address = address;
        this.contact_number = contact_number;
        this.supply_items = supply_items;
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
            br.readLine(); // Skip header

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
    
    public void setContact(String contact_number){
        String contactRegex = "^[0-9]{10,11}$";
        if (contact_number.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter supplier's contact number.");
        }else if(!contact_number.matches(contactRegex)){
            JOptionPane.showMessageDialog(null, "Invalid contact number entry");
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
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null; // Return null if supplier ID is not found
    }
    
    public void setSupplyItems(String supply_items){
        this.supply_items = supply_items.toLowerCase().trim();           
    }
}

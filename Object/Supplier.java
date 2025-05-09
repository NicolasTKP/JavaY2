package com.mycompany.JavaY2.Object;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class Supplier {
    public String supplier_id;
    public String supplier_name;
    public String address;
    public String contact;
    public String supply_items;
    public String payment_term;


    public Supplier(){
    }
    
    public Supplier(String supplier_id, String supplier_name, String address, String contact, String supply_items, String payment_term){
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.address = address;
        this.contact = contact;
        this.supply_items = supply_items;
        this.payment_term = payment_term;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.supplier_id.toLowerCase(),
                this.supplier_name.toLowerCase(),
                this.address.toLowerCase(),
                this.contact.toLowerCase(),
                this.supply_items.toLowerCase(),
                this.payment_term.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
    
    public static String getNextSupplierID() {
        String last_supplier_id = null;
        String supplier_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\suppliers";

        try (BufferedReader br = new BufferedReader(new FileReader(supplier_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                last_supplier_id = line.split("\\|")[0]; // Get first column (item_id)
            }
        } catch (IOException e) {
            System.out.println("Error reading supplier text file");
            return null;
        }

        // If no lastItemId found, return the first ID as "I001"
        if (last_supplier_id == null) {
            return "SU001";
        }

        // Extract numeric part and increment
        if (last_supplier_id.startsWith("SU")) {
            try {
                int lastNumber = Integer.parseInt(last_supplier_id.substring(2)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("SU%03d", newNumber); // Format as I002, I003, etc.
            } catch (NumberFormatException e) {
                System.out.println("Error in assigning Supplier ID to supplier.");
            }
        }
        return null;
    }
 
    public String setSupplierID(){
        this.supplier_id = getNextSupplierID();
        return supplier_id;
    }    
    
    public String getSupplierID(){
        return supplier_id;
    }
    
    public void setSupplierName(String supplier_name){
        this.supplier_name = supplier_name;
    }
    
    public String getSupplierName(){
        return supplier_name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setContactNumber(String contact){
        this.contact = contact;
    }
    
    public static boolean validateContact(String contact){
        String contact_regex = "^01[0-9]-\\d{3}-\\d{4}$";
        if(!contact.matches(contact_regex)){  
            return false;
        }else{
            return true;            
        }
    }
    
    public String getContactNumber(){
        return contact;
    }
    
    public void setSupplyItem(String item_id){
        this.supply_items = item_id;
    }
    
    public String getSupplyItem(){
        return supply_items;
    }
    
    public void setPaymentTerm(String payment_term){
        this.payment_term = payment_term;
    }
    
    public String getPaymentTerm(){
        return payment_term;
    }
    
    public static boolean checkIsNewItem(String item_id){
        String item_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\items";
        try (BufferedReader br = new BufferedReader(new FileReader(item_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Get first column (item_id)
                if(columns.length >=1 && item_id.equalsIgnoreCase(columns[1])){
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading item text file");
        }
        return true;                
    }
    
    public static boolean checkIsDuplicateItem(String supplier_id, String item_id){
       String item_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\items";
        try (BufferedReader br = new BufferedReader(new FileReader(item_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Get first column (item_id)
                if(columns.length >=1 && supplier_id.equalsIgnoreCase(columns[6]) && item_id.equalsIgnoreCase(columns[0])){
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading item text file");
        }
        return true;        
    }
}

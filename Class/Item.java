package com.mycompany.JavaY2.Class;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Item {
    public String item_id;
    public String item_name;
    public double stock_price;
    public int sales_per_day;
    public int ordering_lead_time;
    public int safety_level;
    public String supplier_id;
    public String group_id;

    public Item(){
        
    }
    public Item(String item_id, String item_name, double stock_price, int sales_per_day, int ordering_lead_time, int safety_level, String supplier_id, String group_id){
        this.item_id = item_id;
        this.item_name = item_name;
        this.stock_price = stock_price;
        this.sales_per_day = sales_per_day;
        this.ordering_lead_time = ordering_lead_time;
        this.safety_level = safety_level;
        this.supplier_id = supplier_id;
        this.group_id = group_id;

    }

    public static String getNextItemID() {
        String lastItemId = null;
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\items";

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                lastItemId = line.split("\\|")[0]; // Get first column (item_id)
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }

        // If no lastItemId found, return the first ID as "I001"
        if (lastItemId == null) {
            return "I001";
        }

        // Extract numeric part and increment
        if (lastItemId.startsWith("I")) {
            try {
                int lastNumber = Integer.parseInt(lastItemId.substring(1)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("I%03d", newNumber); // Format as I002, I003, etc.
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    public String getItemID() {
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\items";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Split by '|'
                item_id =  columns[0]; // Return the Item ID
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return item_id;
    }

    public String setItemID(){
        this.item_id = getNextItemID();
        return this.item_id;
    }
    
    public String getItemName(){
        return item_name;
    }
    
    public void setItemName(String item_name){
        String nameRegex = "^[A-Za-z]+(\\s[A-Za-z]+)*$";
        if (item_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter item name.");
        }else if (!item_name.matches(nameRegex)) {
            JOptionPane.showMessageDialog(null, "Invalid item name.");
            this.item_name = null;
            return;
        }
        this.item_name = item_name;
    }
   
    
    public double getStockPrice(){
        return stock_price;
    }
    
    public void setStockPrice(String input_stock_price){
        if (input_stock_price.isEmpty()){
            this.stock_price = 0.0;
        }else if (!input_stock_price.matches("^\\d+(\\.\\d+)?$")){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for item stock price.");
        }else{
            try{
                double stock_price= Double.parseDouble(input_stock_price);
                if (stock_price <=0){
                    JOptionPane.showMessageDialog(null, "Item stock price cannot be 0 or less than 0");
                }else{
                    this.stock_price = stock_price;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for item stock price.");
            }
        } 
    }
    
    public String getSupplierID(){
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
    
    public String setSupplierID(String supplier_id) {
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\suppliers";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length > 1 && parts[1].equalsIgnoreCase(supplier_id)) {
                    return parts[0]; // Return item_id
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file.");
        }
        return null; // Return null if item not found
    }
    
    public int getSalesPerDay(){
        return sales_per_day;
    }
    
    public void setSalesPerDay(int sales_per_day){
        try{
            this.sales_per_day = sales_per_day;
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for item sales per day.");
        }
    }
    
    public int getOrderingLeadTime(){
        return ordering_lead_time;
    }
    
    public void setOrderingLeadTime(int ordering_lead_time){
        try{
            this.ordering_lead_time = ordering_lead_time;
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for item ordering lead time.");
        }
    }
    
    public int getSafetyLevel(){
        return safety_level;
    }
    
    public int setSafetyLevel(int sales_per_day, int ordering_lead_time){
        int safetyLevel = sales_per_day * ordering_lead_time;
        this.safety_level = safetyLevel;
        return safety_level;
    }
  
    public String getNextGroupID(String lastGroupID) {
        int lastNumber = Integer.parseInt(lastGroupID.substring(1)); // Extract number part
        int newNumber = lastNumber + 1;    
        return String.format("G%03d", newNumber); // Format as Gxxx (e.g., G003)    
    } 
    
    public String getGroupID(){
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\inventory";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Split by '|'
                group_id =  columns[0]; // Return the Item ID
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return group_id;
    }
    
    public String setGroupID(){
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\inventory";
        String lastGroupID = "G000";
        
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] itemColumns = line.split("\\|"); // Split by '|'
                if (this.item_name.equals(itemColumns[1])){
                    this.group_id = itemColumns[0];
                    return this.group_id;
                }
                
                lastGroupID = itemColumns[0];
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        this.group_id = getNextGroupID(lastGroupID);
        return group_id;      
    }

}
    

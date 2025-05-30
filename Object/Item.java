package com.mycompany.JavaY2.Object;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import java.util.Map;

public class Item {
    public String item_id;
    public String item_name;
    public int sales_per_day;
    public double stock_price;
    public int ordering_lead_time;
    public int safety_level;
    public String supplier_id;
    public String group_id;


    public Item(){
    }
    public Item(String item_id, String item_name, double stock_price, int sales_per_day, int ordering_lead_time,int safety_level, String supplier_id, String group_id){
        this.item_id = item_id;
        this.item_name = item_name;
        this.sales_per_day = sales_per_day;
        this.stock_price = stock_price;
        this.ordering_lead_time = ordering_lead_time;
        this.safety_level = safety_level;
        this.supplier_id = supplier_id;
        this.group_id = group_id;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.item_id.toLowerCase(),
                this.item_name.toLowerCase(),
                Integer.toString(sales_per_day),
                Double.toString(stock_price),
                Integer.toString(ordering_lead_time),
                Integer.toString(safety_level),
                this.supplier_id.toLowerCase(),
                this.group_id.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
    
    public static String getNextItemID() {
        String last_item_id = null;
        String item_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\items";

        try (BufferedReader br = new BufferedReader(new FileReader(item_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                last_item_id = line.split("\\|")[0]; // Get first column (item_id)
            }
        } catch (IOException e) {
            System.out.println("Error reading item text file");
            return null;
        }

        // If no lastItemId found, return the first ID as "I001"
        if (last_item_id == null) {
            return "I001";
        }

        // Extract numeric part and increment
        if (last_item_id.startsWith("I")) {
            try {
                int lastNumber = Integer.parseInt(last_item_id.substring(1)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("I%03d", newNumber); // Format as I002, I003, etc.
            } catch (NumberFormatException e) {
                System.out.println("Error in assigning Item ID to item.");
            }
        }
        return null;
    }
 
    public String setItemID(){
        this.item_id = getNextItemID();
        return item_id;
    }
    
    public String getItemID(){
        return item_id;
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
            JOptionPane.showMessageDialog(null, "Please enter item stock price.");
        }else if (!input_stock_price.matches("^\\d+(\\.\\d+)?$")){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for item stock price.");
        }else{
            try{
                double stock_price= Double.parseDouble(input_stock_price);
                if (stock_price<=0){
                    JOptionPane.showMessageDialog(null, "Item stock price cannot be 0 or less than 0");
                }else{
                    this.stock_price = stock_price;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for item stock price.");
            }
        } 
    }
    
    public void setSalesPerDay(int sales_per_day){
        this.sales_per_day = sales_per_day;
    }
    
    public int getSalesPerDay(){
        return sales_per_day;
    }
    
    public void setOrderingLeadTime(int ordering_lead_time){
        this.ordering_lead_time = ordering_lead_time;
    }
    
    public int setSafetyLevel(int sales_per_day, int ordering_lead_time){
        this.safety_level = sales_per_day * ordering_lead_time;
        return safety_level;
    }
    
    public int getSafetyLevel(){
        return safety_level;
    }
    
    public void setSupplierID(String supplier_id){
        this.supplier_id = supplier_id;
    }
    
    public String getSupplierID(String supplier_id){
        return supplier_id;
    }
    
    public String getGroupID(){
        return group_id;
    }

    public static String getNextGroupID(String item_name) {
        String last_group_id = null;
         String inventory_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\inventory";

        try (BufferedReader br = new BufferedReader(new FileReader(inventory_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Get first column (group_id)
                if(columns.length>=2){
                    String group_id = columns[0].trim();
                    String existing_item_name = columns[1].trim().toLowerCase();

                    if(existing_item_name.equalsIgnoreCase(item_name)){
                        return group_id;
                    }
                    last_group_id = group_id;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading item text file");
            return null;
        }

        // If no lastItemId found, return the first ID as "I001"
        if (last_group_id == null) {
            return "G001";
        }

        // Extract numeric part and increment
        if (last_group_id.startsWith("G")) {
            try {
                int lastNumber = Integer.parseInt(last_group_id.substring(1)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("G%03d", newNumber); //
            } catch (NumberFormatException e) {
                System.out.println("Error in assigning Group ID to item");
            }
        }
        return null;
    }
 
    public String setGroupID(String item_name){
        this.group_id = getNextGroupID(item_name);
        return group_id;
    }
    
    public static boolean checkIsNewGroupID(String group_id){
         String inventory_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\inventory";
 
        try (BufferedReader br = new BufferedReader(new FileReader(inventory_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Get first column (item_id)
                if(columns.length >=1 && group_id.equalsIgnoreCase(columns[0])){
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory text file");
        }
        return true;
    }
    
    public static boolean checkIsNewSupplier(String supplier_name){
        String supplier_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\suppliers";
        try (BufferedReader br = new BufferedReader(new FileReader(supplier_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Get first column (item_id)
                if(columns.length >=1 && supplier_name.equalsIgnoreCase(columns[1])){
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading supplier text file");
        }
        return true;
    }
}

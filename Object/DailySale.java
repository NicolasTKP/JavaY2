package com.mycompany.JavaY2.Object;

import com.mycompany.JavaY2.Class.DataMapping;
import com.mycompany.JavaY2.Class.TextFile;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DailySale {
    public String daily_sales_id;
    public String group_id;
    public int quantity;
    public double retail_price;
    public String date;

    public DailySale(){
    }
    public DailySale(String daily_sales_id, int quantity, String group_id, double retail_price, String date){
        this.daily_sales_id = daily_sales_id;
        this.quantity = quantity;
        this.group_id = group_id;
        this.retail_price = retail_price;
        this.date = date;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.daily_sales_id.toLowerCase(),
                this.group_id.toLowerCase(),
                this.date.toLowerCase(),
                Integer.toString(this.quantity),
                Double.toString(this.retail_price)
        ));
        return valuesToCheck.contains(keyword);
    }
    
    public String setSalesID(){
        this.daily_sales_id = getNextSalesID();
        return daily_sales_id;
    }
    
    public String getSalesID(){
        return daily_sales_id;
    }
    
    public String getGroupID(){
        return group_id;
    }
    
    public void setGroupID(String group_id){
        this.group_id = group_id;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public double getRetailPrice(){
        return retail_price;
    } 
    
    public void setRetailPrice(double retail_price){
        this.retail_price = retail_price;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
        public static String getNextSalesID() {
        String last_sales_id = null;
        String sales_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\daily_sales_items";

        try (BufferedReader br = new BufferedReader(new FileReader(sales_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                last_sales_id = line.split("\\|")[0]; // Get first column (item_id)
            }
        } catch (IOException e) {
            System.out.println("Error reading daily sales item text file");
            return null;
        }

        // If no lastItemId found, return the first ID as "I001"
        if (last_sales_id == null) {
            return "DS00001";
        }

        // Extract numeric part and increment
        if (last_sales_id.startsWith("DS")) {
            try {
                int lastNumber = Integer.parseInt(last_sales_id.substring(2)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("DS%05d", newNumber); // Format as I002, I003, etc.
            } catch (NumberFormatException e) {
                System.out.println("Error in assigning Daily Sales ID to item.");
            }
        }
        return null;
    }
        
    public static boolean updateInventoryQuantity(Component parent_component, String group_id, int sold_quantity) {
        String inventory_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\inventory";

        try {
            BufferedReader br = new BufferedReader(new FileReader(inventory_file_path));
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");

                if (columns.length >= 4 && columns[0].trim().equals(group_id.trim())) {
                    found = true;

                    String item_name = columns[1].trim();
                    int current_quantity = Integer.parseInt(columns[2].trim());
                    String retail_price = columns[3].trim();

                    if (sold_quantity > current_quantity) {
                        JOptionPane.showMessageDialog(parent_component, "Insufficient quantity of item: " + item_name);
                        br.close();
                        return false;  // ❗️ Fail - stop further process
                    } else {
                        int new_quantity = current_quantity - sold_quantity;

                        String updated_line = group_id + "|" + item_name + "|" + new_quantity + "|" + retail_price;

                        // ✅ Update inventory file
                        TextFile.editTextfileRow(parent_component, inventory_file_path, group_id, 0, updated_line, 4);

                        br.close();
                        return true;  // ✅ Success
                    }
                }
            }
            br.close();

            if (!found) {
                JOptionPane.showMessageDialog(parent_component, "Group ID not found in inventory: " + group_id);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent_component, "Error updating inventory due to file error: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent_component, "Error updating inventory due to number format issue.");
        }

        return false;  // Default to false if something failed
    }
    
    public static void populateDailySalesTable(DefaultTableModel model, JTable table, String[] columns, String filePath, int rowHeight){
        model.setRowCount(0);
        model.setColumnIdentifiers(columns);
        table.setRowHeight(rowHeight);
        String inventory_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/inventory";
        
        Date current_date = new Date();
        SimpleDateFormat date_format = new SimpleDateFormat("ddMMyyyy");
        String today = date_format.format(current_date);        

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Set<String> uniqueRows = new HashSet<>();

            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || !uniqueRows.add(line)) {
                    continue;
                }
                String[] rowData = line.split("\\|");
                if(rowData.length>2 && rowData[4].equals(today)){
                    DataMapping mapping = new DataMapping();
                    Map<String, String> inventory_map = mapping.IdNameMapping(inventory_file_path);
                    rowData[2] = inventory_map.get(rowData[2]);
                    model.addRow(rowData);                   
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file to populate JTable: " + filePath);
        }
    }
    
    public static void populateTable(DefaultTableModel model, JTable table, String[] columns, String filePath, int rowHeight, Map<Integer, Map<String, String>> columnMappings) {
        model.setRowCount(0); // clear row
        model.setColumnIdentifiers(columns); //set column name
        table.setRowHeight(rowHeight); // set column height
        
        Date current_date = new Date();
        SimpleDateFormat date_format = new SimpleDateFormat("ddMMyyyy");
        String formatted_date = date_format.format(current_date);
        
        // read file using br
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Set<String> uniqueRows = new HashSet<>();
            br.readLine(); // Skip header
            
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || !uniqueRows.add(line)) continue;
                
                String[] rowData = line.split("\\|"); // split the line into different column

                // Apply mappings to specific columns
            if (columnMappings != null) {
                for (Map.Entry<Integer, Map<String, String>> entry : columnMappings.entrySet()) {
                    int index = entry.getKey(); // retrieve column index
                    Map<String, String> map = entry.getValue(); // get the mapping dictionary for the column

                    if (index < rowData.length) {
                        String originalValue = rowData[index]; // get the current value from the specific column (such as item IDs, Supplier IDs)
                        
                        // in contain multiple value, split them by "," and do mapping
                        if (originalValue.contains(",")) {
                            String[] parts = originalValue.split(",");
                            List<String> mappedValues = new ArrayList<>();
                            
                            // iterate all objects inside the column, then add the mapped value
                            for (String part : parts) {
                                String trimmed = part.trim();
                                String mapped = map.getOrDefault(trimmed, trimmed);
                                mappedValues.add(mapped);
                            }
                            // join the mapped values back together 
                            rowData[index] = String.join(", ", mappedValues);
                            
                            // if contain only one value, map it directly
                        } else {
                            String trimmed = originalValue.trim();
                            String mapped = map.getOrDefault(trimmed, trimmed);
                            rowData[index] = mapped;
                        }
                    }
                }
            }
                model.addRow(rowData); // add the row of data into table
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath); // handle IOException
        }
    }    
}

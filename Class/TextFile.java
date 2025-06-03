package com.mycompany.JavaY2.Class;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;


public class TextFile {

    public static void addLine(String path, String line){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.newLine();
            bw.write(line);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLine(String path, String target, int targetColumn){
        try {
            List<String> linesList = Files.readAllLines(Paths.get(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
            boolean flag = true;

            for (String line:linesList) {
                if (line.split("\\|")[targetColumn].strip().equals(target.strip())){
                    continue;
                }
                if (flag){
                    bw.write(line);
                    flag = false;
                }else{
                    bw.newLine();
                    bw.write(line);
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getColumn(String path, int target_column, String target, int get_column){
        try {
            List<String> linesList = Files.readAllLines(Paths.get(path));
            for (String line:linesList) {
                if (line.split("\\|")[target_column].strip().equals(target.strip())) {
                    return line.split("\\|")[get_column];
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean editTextfileRow(Component parent_component, String file_path, String primary_key, int column_index, String updated_line){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            StringBuilder updated_file = new StringBuilder();
            String line;
            boolean found = false;

            while((line = br.readLine()) !=null){
                String[] columns = line.split("\\|");

                if(columns[column_index].trim().equals(primary_key.trim())){
                    updated_file.append(updated_line).append("\n");
                    found = true;
                }else{
                    updated_file.append(line).append("\n");
                }
            }
            br.close();

            if(!found){
                JOptionPane.showMessageDialog(parent_component, "Data now found");
                return false;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file_path, false));
            bw.write(updated_file.toString());
            bw.close();

            return true;
        }catch(IOException e){
            System.out.println("Error reading " + file_path);
            return false;
        }
    }

    public static void populateTable(DefaultTableModel model, JTable table, String[] columns, String filePath, int rowHeight){
        model.setRowCount(0);
        model.setColumnIdentifiers(columns);
        table.setRowHeight(rowHeight);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Set<String> uniqueRows = new HashSet<>();

            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || !uniqueRows.add(line)) {
                    continue;
                }
                String[] rowData = line.split("\\|");
                model.addRow(rowData);
            }
        } catch (IOException e) {
            System.out.println("Error reading file to populate JTable: " + filePath);
        }
    }

    // Overloaded with mapping
    public static void populateTable(DefaultTableModel model, JTable table, String[] columns, String filePath,
                                     int rowHeight, Map<Integer, Map<String, String>> columnMappings) {
        model.setRowCount(0); // clear row
        model.setColumnIdentifiers(columns); //set column name
        table.setRowHeight(rowHeight); // set column height
        
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

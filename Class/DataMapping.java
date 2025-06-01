/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Class;


import com.mycompany.JavaY2.InventoryManager.StockReportContent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author User
 */
public class DataMapping {
    public Map<String, String> IdNameMapping(String file_path) {
        Map<String, String> mapping = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns.length >= 2) {
                    String id = columns[0];
                    String name = columns[1];
                    mapping.put(id,name);
                }
            }
        } catch(IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return mapping;
    }

    public Map<String, String> NameIdMapping(String file_path) {
        Map<String, String> mapping = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns.length >= 2) {
                    String id = columns[0];
                    String name = columns[1];
                    mapping.put(name,id);
                }
            }
        } catch(IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return mapping;
    }    
    
    public Map<String, String> NameRetailPriceMapping(String file_path){
        Map<String, String> mapping = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns.length >= 2) {
                    String name = columns[1];
                    String retail_price = columns[3];
                    mapping.put(name,retail_price);
                }
            }
        } catch(IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return mapping;
    }
    public static Map<String, StockReportContent> NameLatestDateMapping(String inventoryFile, String receivesFile){
        Set<String> inventoryList = new HashSet<>();
        Map<String, StockReportContent> mapping = new HashMap<>();
        Map<String, String> groupIdMap = new HashMap<>();
        Map<String, Integer> quantityMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inventoryFile))){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                if(data.length >= 2){
                    String groupId = data[0];
                    String itemName = data[1];
                    int quantity = Integer.parseInt(data[2]);
                    inventoryList.add(itemName);
                    groupIdMap.put(itemName, groupId);
                    quantityMap.put(itemName, quantity);
                }
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(receivesFile))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                if(data.length >= 7){
                    String itemName = data[2];
                    String dateReceived = data[5];
                    String status = data[6];

                    if (inventoryList.contains(itemName) && !dateReceived.isEmpty() && status.equals("Received")){
                         if (!mapping.containsKey(itemName) || dateReceived.compareTo(mapping.get(itemName).dateReceived) > 0) {
                            String groupId = groupIdMap.getOrDefault(itemName, "");
                            int quantity = quantityMap.getOrDefault(itemName, 0);
                            mapping.put(itemName, new StockReportContent(itemName, groupId, quantity, dateReceived));
            }
        }
    }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return mapping;
    }
    
    public static Map<String, String[]> getSupplierDetails(String itemName) {
        Map<String, String[]> supplierDetails = new HashMap<>(); // supplierName -> {itemID, supplierID, unitPrice}

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] column = line.split("\\|");
                if (column[1].equals(itemName)) { // Match item name
                    String supplierID = column[6];
                    String supplierName = Search.getSupplierName(supplierID);
                    if (supplierName != null) {
                        supplierDetails.put(supplierName, new String[]{column[0], supplierID, column[2]}); // {itemID, supplierID, unitPrice}
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return supplierDetails;
    }
}
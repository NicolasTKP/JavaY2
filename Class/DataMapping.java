/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Kaiqi
 */
public class DataMapping {
    public static Map<String, String> NameLatestDateMapping(String inventoryFile, String receivesFile){
        Set<String> inventoryList = new HashSet<>();
        Map<String, String> mapping = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"))){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                if(data.length >= 2){
                    inventoryList.add(data[1]); //get item name
                }
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        } 
        
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/receives"))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                if(data.length >= 7){
                    String itemName = data[2];
                    String dateReceived = data[5];
                    String status = data[6];
                    
                    if (inventoryList.contains(itemName) && !dateReceived.isEmpty() && status.equals("Received")){
                        mapping.merge(itemName, dateReceived, (oldDate, newDate) -> //add itemname and date received in the mapping
                        newDate.compareTo(oldDate) > 0 ? newDate : oldDate); //compares the old date and new date and update mapping
                        }
                    }
                }
            }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return mapping;
        }
        
        
    }
    
    
  

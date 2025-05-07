/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaY2.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    
}

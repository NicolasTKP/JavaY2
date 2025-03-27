/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author acer
 */
public class Search {

    public static String getUsername(String userID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(userID)){
                    return line.split("\\|")[1];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getItemName(String itemID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(itemID)){
                    return line.split("\\|")[1];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSupplierName(String supplierID){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(supplierID)){
                    return line.split("\\|")[1];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFromPR(String requestID, int column){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(requestID)){
                    return line.split("\\|")[column];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFromInventory(String itemID, int column){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(itemID)){
                    return line.split("\\|")[column];
                }

            }
            br.close();
            return null;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

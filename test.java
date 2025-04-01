package com.mycompany.JavaY2;

import com.mycompany.JavaY2.Class.Edit;
import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.SessionManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        SessionManager.getInstance().username = "hello";
//        System.out.println(SessionManager.getInstance().username);
          String selectedItemID = "I001";
          
          String supplier_id = getSupplierID(selectedItemID, "src/main/java/com/mycompany/JavaY2/TextFile/suppliers");
          System.out.println("Supplier ID: "+ supplier_id);
    }
    
     public static String getSupplierID(String itemID, String supplierFilePath){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"))){
            String line; 
            while((line = br.readLine()) != null){
                String[] columns = line.split("\\|");
                String[] itemIDs = columns[4].split(",");
                for (String id : itemIDs){
                    if (id.equals(itemID)){
                         return columns[0];
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "Supplier ID not found";
    }
}

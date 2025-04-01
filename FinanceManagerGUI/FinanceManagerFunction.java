/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.FinanceManagerGUI;

import com.mycompany.JavaY2.Object.SessionManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FinanceManagerFunction {
    public static void editFMProfile(String currentUsername, String fmUsername, String fmPassword, String fmRole) {

        List<String> updatedLs = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/users"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] column = line.split("\\|");
                if (currentUsername.equals(column[1])) { 
                    column[1] = fmUsername;  
                    column[2] = fmPassword;  
                    column[3] = fmRole; 
                    updated = true;
                }
                updatedLs.add(String.join("|", column));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/users"))) {
                for (String row : updatedLs) {
                    bw.write(row);
                    bw.newLine();
                    SessionManager.getInstance().username = fmUsername;
                }
                
                JOptionPane.showMessageDialog(null, "Profile has been updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error writing file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You are not allowed to change others' credentials", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    public static String getItemName(String itemID){
        String itemsFilePath = "src/main/java/com/mycompany/JavaY2/TextFile/items";
        try(BufferedReader br = new BufferedReader(new FileReader(itemsFilePath))){
            String line; 
            while((line = br.readLine()) != null){
                String[] columns = line.split("\\|");
                if(columns[0].equals(itemID)){
                    return columns[1];
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
          return "Item ID not found";
    }
    
//     public static String getSupplierID(String itemID){
//        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"))){
//            String line; 
//            while((line = br.readLine()) != null){
//                String[] columns = line.split("\\|");
//                String[] itemIDs = columns[4].split(",");
//                for (String id : itemIDs){
//                    if (id.equals(itemID)){
//                         return columns[0];
//                    }
//                }
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return "Supplier ID not found";
//    }
     
    public static String getSupplierNames(String itemID){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"))){
            String line; 
            while((line = br.readLine()) != null){
                String[] columns = line.split("\\|");
                String[] itemIDs = columns[4].split(",");
                for (String id : itemIDs){
                    if (id.equals(itemID)){
                         return columns[1];
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "Supplier Name not found";
    }
}

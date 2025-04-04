/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author User
 */
public class PurchaseRequisition {
    public String request_id;
    public String group_id;
    public String user_id;
    public int quantity;
    public String request_date;
    public String required_date;
    public String pr_status;
    
    public PurchaseRequisition(){
        
    }
    
    public PurchaseRequisition(String request_id, String group_id, String user_id, int quantity, String request_date, String required_date, String pr_status){
        this.request_id = request_id;
        this.group_id = group_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.request_date = request_date;
        this.required_date = required_date;
        this.pr_status = pr_status;
    }
    
    public PurchaseRequisition(String group_id, int quantity, String required_date){
        this.group_id = group_id;
        this.quantity = quantity;
        this.required_date = required_date;
    }
    
    public static String getNextRequestID() {
        String lastRequestID = null;
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\purchase_requisitions";

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                lastRequestID = line.split("\\|")[0]; 
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }

        if (lastRequestID == null) {
            return "R001";
        }

        // Extract numeric part and increment
        if (lastRequestID.startsWith("R")) {
            try {
                int lastNumber = Integer.parseInt(lastRequestID.substring(1)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("R%03d", newNumber); // 
                
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    public String getRequestID() {
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\purchase_requisitions";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Split by '|'
                request_id =  columns[0]; // Return the Item ID
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return request_id;
    }

    public String setRequestID(){
        request_id = getNextRequestID();
        return request_id;
    }
        
    public String setGroupID(String item_name){
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\inventory";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Split by '|'
                item_name = item_name.trim().toLowerCase();
                if(item_name.equals(columns[1].trim().toLowerCase())){
                    return columns[0];
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading to file");
        }
        return "Item not found in the inventory.";
    }
    
    public String getGroupID(){
        return group_id;
    }
    
    public String setUserID(){
        return "";
    }
    
    public String getUserID(){
        return user_id;
    }
    
    public void setQuantity(int quantity){
        if (quantity <=0){
            JOptionPane.showMessageDialog(null, "Quantity cannot be less or equal to 0. ");
        }
        this.quantity = quantity;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String setRequestDate(){
        LocalDate today = LocalDate.now();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        request_date = today.format(dateFormatter);
        return request_date;
    }
    
    public String getRequestDate(){
        LocalDate today = LocalDate.now();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return today.format(dateFormatter);
    }
    
    public String setRequiredDate(String required_date){
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat3 = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("ddMMyyyy");
        
        dateFormat1.setLenient(false);
        dateFormat2.setLenient(false);
        dateFormat3.setLenient(false);
        
        Date date;        
        try {
            if (required_date.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                date = dateFormat1.parse(required_date);
            } else if (required_date.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                date = dateFormat2.parse(required_date);
            } else if (required_date.matches("^\\d{8}$")) {
                date = dateFormat3.parse(required_date);
            } else {
                return null;
            }
            
            Date currentDate = new Date();
            if (date.before(currentDate)){
                return null;
            }           
            return outputDateFormat.format(date);            
        }catch (ParseException e){
            return null;
        }
    }
    
    public String getRequiredtDate(){
        return required_date;
    }
    
    public String setPRStatus(){
        return "pending";
    }
    
    public String getPRStatus(String request_id){
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\purchase_requisitions";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|"); // Split by '|'
                request_id = request_id.trim().toLowerCase();
                if(request_id.equals(columns[0].trim().toLowerCase())){
                    return columns[6];
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading to file");
        }
        return "No purchase requisition found.";
    }
    
    public static List<PurchaseRequisition> readPRFromFile(String pr_file_path, Map<String, String> pr_inventory_map) {
        List<PurchaseRequisition> prList = new ArrayList<>();
        Set<String> uniquePRs = new HashSet<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(pr_file_path))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 7) {
                    String requestID = parts[0].trim();
                    
                    if (!uniquePRs.contains(requestID)){
                        uniquePRs.add(requestID);
                        
                        int quantity = Integer.parseInt(parts[3].trim());
                        String groupID = parts[1].trim();
                        String itemName = pr_inventory_map.get(groupID);
                    
                        PurchaseRequisition pr = new PurchaseRequisition(parts[0].trim(), itemName, parts[2].trim(),quantity, parts[4].trim(), parts[5].trim(), parts[6].trim()
                        );
                        prList.add(pr); 
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading PR file");
        }

        return prList;
    }
    
    public void writePRtoFile(String pr_details){
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\purchase_requisitions";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_path, true))){
            bw.write(pr_details + "\n");
            JOptionPane.showMessageDialog(null, "Purchase requisition placed successfully.");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error reading to file");
        }
    }
    
    public static boolean editPR(String request_id, String pr_details, String file_path){
        StringBuilder updatedContent = new StringBuilder();
        boolean found = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(file_path))){
            String line;
            while ((line = br.readLine())!=null){
                String[] columns = line.split("\\|");
                
                if(columns[0].trim().equals(request_id.trim())){
                    line = pr_details; 
                    found = true;
                }
                updatedContent.append(line).append("\n");
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error reading file.");
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_path, false))) {
            bw.write(updatedContent.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error editing PR file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;        
        
    }
    
    public static boolean deletePR(String request_id, String file_path){
        List<String> updatedLines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(request_id + "|")) { // Keep only lines that do not match the ID
                    updatedLines.add(line);
                }else{
                    found = true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading the file.");
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_path))){
            for (String updatedLine : updatedLines){
                bw.write(updatedLine);
                bw.newLine();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error reading textfile");
            return false;
        }  
        return found;
    }

    
}

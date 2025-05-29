package com.mycompany.JavaY2.Object;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PurchaseRequisition extends Request {
    public String group_id;
    public String request_date;
    public String required_date;
    public String status;

    public PurchaseRequisition(){
    }
    
    public PurchaseRequisition(String request_id, String group_id, String item_name, String user_id, int quantity, String request_date, String required_date, String status){
        this.request_id = request_id;
        this.group_id = group_id;
        this.item_name = item_name;
        this.user_id = user_id;
        this.quantity = quantity;
        this.request_date = request_date;
        this.required_date = required_date;
        this.status = status;
    }

    public PurchaseRequisition(String request_id, String group_id, String user_id, int quantity, String request_date, String required_date, String status){
        this.request_id = request_id;
        this.group_id = group_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.request_date = request_date;
        this.required_date = required_date;
        this.status = status;
    }


    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.request_id.toLowerCase(),
                this.group_id.toLowerCase(),
                this.item_name.toLowerCase(),
                this.user_id.toLowerCase(),
                Integer.toString(this.quantity),
                this.request_date,
                this.required_date,
                this.status
        ));
        return valuesToCheck.contains(keyword);
    }

    public boolean anyPrMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.request_id.toLowerCase(),
                this.group_id.toLowerCase(),
                this.user_id.toLowerCase(),
                Integer.toString(this.quantity),
                this.request_date,
                this.required_date,
                this.status
        ));
        return valuesToCheck.contains(keyword);
    }

    public static String getNextRequestID() {
        String last_pr_id = null;
        String pr_file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\purchase_requisitions";

        try (BufferedReader br = new BufferedReader(new FileReader(pr_file_path))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                last_pr_id = line.split("\\|")[0]; // Get first column (item_id)
            }
        } catch (IOException e) {
            System.out.println("Error reading PR text file");
            return null;
        }

        // If no lastItemId found, return the first ID as "I001"
        if (last_pr_id == null) {
            return "R001";
        }

        // Extract numeric part and increment
        if (last_pr_id.startsWith("R")) {
            try {
                int lastNumber = Integer.parseInt(last_pr_id.substring(1)); // Extract numeric part
                int newNumber = lastNumber + 1; // Increment
                return String.format("R%03d", newNumber); // Format as I002, I003, etc.
            } catch (NumberFormatException e) {
                System.out.println("Error in assigning Request ID to PR.");
            }
        }
        return null;
    }
 
    public String setRequestID(){
        this.request_id = getNextRequestID();
        return request_id;
    }       
    
    public String getRequestID(){
        return request_id;
    }
    
    public void setGroupID(String group_id){
        this.group_id = group_id;
    }
    
    public String getGroupID(){
        return group_id;
    }
    
    public void setItemName(String item_name){
        this.item_name = item_name;
    }
    
    public String getItemName(){
        return item_name;
    }
    
    public void setUserID(String user_id){
        this.user_id = this.user_id;
    }
    
    public String getUserID(){
        return user_id;
    }
    
    public void setRequestDate(String request_date){
        this.request_date = request_date;
    }
    
    public String getRequestDate(){
        return request_date;
    }
    
    public void setRequiredDate(String required_date){
        this.required_date = required_date;
    }
    
    public String getRequiredDate(){
        return required_date; 
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return status;
    } 
}



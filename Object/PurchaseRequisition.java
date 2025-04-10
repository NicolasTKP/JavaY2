package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PurchaseRequisition {
    public String request_id;
    public String group_id;
    public String item_name;
    public String user_id;
    public int quantity;
    public String request_date;
    public String required_date;
    public String status;

    PurchaseRequisition(){
    }
    PurchaseRequisition(String request_id, String group_id, String item_name, String user_id, int quantity, String request_date, String required_date, String status){
        this.request_id = request_id;
        this.group_id = group_id;
        this.item_name = item_name;
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
}

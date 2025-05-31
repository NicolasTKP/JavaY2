package com.mycompany.JavaY2.Object;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PurchaseOrder extends Request {
    public String order_id;
    public String item_id;
    public String username;
    public double unit_price;
    public double amount;
    public String supplier_id;
    public LocalDate order_date;
    public String order_status;
    public String supplier_name;

    public PurchaseOrder(){
    }
    PurchaseOrder(String order_id, String request_id, String item_id, String user_id, String username, int quantity, double unit_price, double amount, String supplier_id, LocalDate order_date, String order_status, String item_name, String supplier_name){
        this.order_id = order_id;
        this.request_id = request_id;
        this.item_id = item_id;
        this.user_id = user_id;
        this.username = username;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.amount = amount;
        this.supplier_id = supplier_id;
        this.order_date = order_date;
        this.order_status = order_status;
        this.item_name = item_name;
        this.supplier_name = supplier_name;
    }
    
    //Overloaded for editPO
    public PurchaseOrder(String order_id, String item_id, String item_name, int quantity, double unit_price, String supplier_id) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.supplier_id = supplier_id;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.order_id.toLowerCase(),
                this.request_id.toLowerCase(),
                this.item_id.toLowerCase(),
                this.user_id.toLowerCase(),
                this.username.toLowerCase(),
                Integer.toString(this.quantity),
                Double.toString(this.unit_price),
                Double.toString(this.amount),
                this.supplier_id.toLowerCase(),
                this.order_status.toLowerCase(),
                this.item_name.toLowerCase(),
                this.supplier_name.toLowerCase()
        ));
        if (this.order_date != null)
            valuesToCheck.add(this.order_date.toString().toLowerCase());
        return valuesToCheck.contains(keyword);
    }
}

package com.mycompany.JavaY2.Object;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Receives extends PurchaseOrder {
    public String delivery_status;
    public String payment_status;
    public String date_received;
    public String payment_date;

    Receives(){
    }
    Receives(String order_id, String request_id, String item_id, String user_id, String username, int quantity, double unit_price, double amount, String supplier_id, LocalDate order_date, String order_status, String item_name, String supplier_name, String date_received, String delivery_status, String payment_date, String payment_status){
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
        this.delivery_status = delivery_status;
        this.payment_status = payment_status;
        this.date_received = date_received;
        this.payment_date = payment_date;
    }
    @Override
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
                this.order_date.toString().toLowerCase(),
                this.order_status.toLowerCase(),
                this.item_name.toLowerCase(),
                this.supplier_name.toLowerCase(),
                this.delivery_status.toLowerCase(),
                this.payment_status.toLowerCase(),
                this.date_received.toLowerCase(),
                this.payment_date.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
}

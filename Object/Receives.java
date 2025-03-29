package com.mycompany.JavaY2.Object;


import java.time.LocalDate;

public class Receives extends PurchaseOrder {
    public String delivery_status;

    Receives(){
    }
    Receives(String order_id, String request_id, String item_id, String user_id, String username, int quantity, double unit_price, double amount, String supplier_id, LocalDate order_date, String order_status, String item_name, String supplier_name, String delivery_status){
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
    }
}

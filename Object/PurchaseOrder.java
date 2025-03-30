package com.mycompany.JavaY2.Object;

import java.time.LocalDate;

public class PurchaseOrder {
    public String order_id;
    public String request_id;
    public String item_id;
    public String user_id;
    public String username;
    public int quantity;
    public double unit_price;
    public double amount;
    public String supplier_id;
    public LocalDate order_date;
    public String order_status;
    public String item_name;
    public String supplier_name;

    PurchaseOrder(){
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
}

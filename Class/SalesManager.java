package com.mycompany.JavaY2.Class;

import java.util.ArrayList;

public class SalesManager {
    private ArrayList<Item> itemList;

    public SalesManager(){
        this.itemList = new ArrayList<>();
    }

    public void addItem(String item_id, String item_name, int quantity, double stock_price, double retail_price, int low_stock_benchmark, String supplier_id){
        itemList.add(new Item(item_id, item_name, quantity, stock_price, retail_price, low_stock_benchmark, supplier_id));
        System.out.println("Items add successfully");
    }



}

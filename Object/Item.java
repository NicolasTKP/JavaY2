package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Item {
    public String item_id;
    public String item_name;
    public int quantity;
    public double stock_price;
    public double retail_price;
    public int low_stock_benchmark;
    public String supplier_id;


    Item(){
    }
    Item(String item_id, String item_name, int quantity, double stock_price, double retail_price,int low_stock_benchmark, String supplier_id){
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.stock_price = stock_price;
        this.retail_price = retail_price;
        this.low_stock_benchmark = low_stock_benchmark;
        this.supplier_id = supplier_id;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.item_id.toLowerCase(),
                this.item_name.toLowerCase(),
                Integer.toString(quantity),
                Double.toString(stock_price),
                Double.toString(retail_price),
                Integer.toString(low_stock_benchmark),
                this.supplier_id.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
}

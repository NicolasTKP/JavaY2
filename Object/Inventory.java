package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Inventory {

    public String group_id;
    public String item_name;
    public int quantity;
    public double retail_price;


    public Inventory(){
    }
    public Inventory(String group_id, String item_name, int quantity, double retail_price){
        this.group_id = group_id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.retail_price = retail_price;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.group_id.toLowerCase(),
                this.item_name.toLowerCase(),
                Integer.toString(quantity),
                Double.toString(retail_price)
        ));
        return valuesToCheck.contains(keyword);
    }
}

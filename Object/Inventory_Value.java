package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Inventory_Value extends Inventory{
    public double average_unit_price;
    public double actual_value;
    Inventory_Value(){
    }
    Inventory_Value(String group_id, String item_name, int quantity, double retail_price, double average_unit_price, double actual_value){
        this.group_id = group_id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.retail_price = retail_price;
        this.average_unit_price = average_unit_price;
        this.actual_value = actual_value;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.group_id.toLowerCase(),
                this.item_name.toLowerCase(),
                Integer.toString(quantity),
                Double.toString(retail_price),
                Double.toString(average_unit_price),
                Double.toString(actual_value)
        ));
        return valuesToCheck.contains(keyword);
    }
}

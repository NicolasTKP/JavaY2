package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Item {
    public String item_id;
    public String item_name;
    public int sales_per_day;
    public double stock_price;
    public int ordering_lead_time;
    public int safety_level;
    public String supplier_id;
    public String group_id;


    Item(){
    }
    Item(String item_id, String item_name, double stock_price, int sales_per_day, int ordering_lead_time,int safety_level, String supplier_id, String group_id){
        this.item_id = item_id;
        this.item_name = item_name;
        this.sales_per_day = sales_per_day;
        this.stock_price = stock_price;
        this.ordering_lead_time = ordering_lead_time;
        this.safety_level = safety_level;
        this.supplier_id = supplier_id;
        this.group_id = group_id;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.item_id.toLowerCase(),
                this.item_name.toLowerCase(),
                Integer.toString(sales_per_day),
                Double.toString(stock_price),
                Integer.toString(ordering_lead_time),
                Integer.toString(safety_level),
                this.supplier_id.toLowerCase(),
                this.group_id.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
}

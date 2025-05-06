package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DailySale {
    public String daily_sales_id;
    public String group_id;
    public int quantity;
    public double retail_price;
    public String date;

    DailySale(){
    }
    DailySale(String daily_sales_id, String group_id, int quantity, double retail_price, String date){
        this.daily_sales_id = daily_sales_id;
        this.group_id = group_id;
        this.quantity = quantity;
        this.retail_price = retail_price;
        this.date = date;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.daily_sales_id.toLowerCase(),
                this.group_id.toLowerCase(),
                this.date.toLowerCase(),
                Integer.toString(this.quantity),
                Double.toString(this.retail_price)
        ));
        return valuesToCheck.contains(keyword);
    }
}

package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Payment {
    public String order_id;
    public String item_id;
    public int quantity;
    public double amount;
    public String payment_status;
    public String payment_date;

    Payment(){
    }
    Payment(String order_id, String item_id, int quantity, double amount, String payment_status, String payment_date){
        this.order_id = order_id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.amount = amount;
        this.payment_status = payment_status;
        this.payment_date = payment_date;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.order_id.toLowerCase(),
                this.item_id.toLowerCase(),
                this.payment_status.toLowerCase(),
                this.payment_date.toLowerCase(),
                Integer.toString(this.quantity),
                Double.toString(this.amount)
        ));
        return valuesToCheck.contains(keyword);
    }
}

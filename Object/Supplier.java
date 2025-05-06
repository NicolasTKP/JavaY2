package com.mycompany.JavaY2.Object;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Supplier {
    public String supplier_id;
    public String supplier_name;
    public String address;
    public String contact;
    public String supply_items;
    public String payment_term;


    Supplier(){
    }
    Supplier(String supplier_id, String supplier_name, String address, String contact, String supply_items, String payment_term){
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.address = address;
        this.contact = contact;
        this.supply_items = supply_items;
        this.payment_term = payment_term;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.supplier_id.toLowerCase(),
                this.supplier_name.toLowerCase(),
                this.address.toLowerCase(),
                this.contact.toLowerCase(),
                this.supply_items.toLowerCase(),
                this.payment_term.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
}

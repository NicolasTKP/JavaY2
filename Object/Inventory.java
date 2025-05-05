/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Object;

/**
 *
 * @author Kaiqi
 */
public class Inventory {
    private String groupId;
    private String itemName;
    private int quantity;
    private double retailPrice;
    
    public Inventory(String groupId, String itemName, int quantity, double retailPrice){
        this.groupId = groupId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
    }
    
    public String getGroupId(){
        return groupId;
    }
    
    public String getInventoryItemName(){
        return itemName;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getRetailPrice(){
        return retailPrice;
    }
}

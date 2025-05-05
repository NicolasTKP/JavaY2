/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Object;

/**
 *
 * @author Kaiqi
 */
public class Item {
    private String itemId;
    private String itemName;
    private double stockPrice;
    private int salesPerDay;
    private int orderingLeadTime;
    private int safetyLevel;
    private String supplierId;
    private String groupId;
    
    public Item(String itemId, String itemName, double stockPrice, int salesPerDay, int orderingLeadTime, int safetyLevel, String supplierId, String groupId){
        this.itemId = itemId;
        this.itemName = itemName;
        this.stockPrice = stockPrice;
        this.salesPerDay = salesPerDay;
        this.orderingLeadTime = orderingLeadTime;
        this.safetyLevel = safetyLevel;
        this.supplierId = supplierId;
        this.groupId = groupId;
    }
    
    public String getItemId(){
        return itemId;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public double getStockPrice(){
        return stockPrice;
    }
    
    public int getSalesPerDay(){
        return salesPerDay;
    }
    
    public int getOrderingLeadTime(){
        return orderingLeadTime;
    }
    
    public int getSafetyLevel(){
        return safetyLevel;
    }
    
    public String getSupplierId(){
        return supplierId;
    }
    
    public String getGroupId(){
        return groupId;
    }
    
}

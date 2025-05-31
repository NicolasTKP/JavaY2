/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Object;

/**
 *
 * @author Kaiqi
 */
public class Receive {
    private String orderId;
    private String itemId;
    private String itemName;
    private int quantity;
    private double amount;
    private String dateReceived;
    private String status;
    private String paymentDate;
    private String paymentStatus;
    
    public Receive(String orderId, String itemId, String itemName, int quantity, double amount, String dateReceived, String status, String paymentDate, String paymentStatus){
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.amount = amount;
        this.dateReceived = dateReceived;
        this.status = status;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }
    
    public String getOrderId(){
        return orderId;
    }
    
    public String getItemId(){
        return itemId;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public String getDateReceived(){
        return dateReceived;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String getPaymentDate(){
        return paymentDate;
    }
    
    public String getPaymentStatus(){
        return paymentStatus;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Object;


/**
 *
 * @author Kaiqi
 */
public class StockReport extends Inventory{
    private String group_id, item_name, date_received;
    private double retail_price;
    private int quantity, pending_order_quantity;
    
    public StockReport(String group_id, String item_name, String date_received, double retail_price, int quantity){
        this.group_id = group_id;
        this.item_name = item_name;
        this.date_received = date_received;
        this.retail_price = retail_price;
        this.quantity = quantity;
    }
    
    public String[] toArray(){
        return new String[]{
            group_id, 
            item_name, 
            date_received,
            String.valueOf(retail_price),  
            String.valueOf(quantity), 
        };
    }
    
    public String generateReportString(){
        StringBuilder stockReport = new StringBuilder();
        String headerFormat = "%-10s %-20s %-15s %-20s %-20s %-25s %-25s%n";
        String dataFormat = "%-10s %-20s %-15.2f %-20s %-20d %-25d %-25s%n";
        stockReport.append("---------------------------------------------------------------------------------\n");
        stockReport.append(String.format(headerFormat, "Group ID", "Item Name", "Date Received", "Retail Price", "Quantity"));
        stockReport.append("---------------------------------------------------------------------------------\n");
        stockReport.append(String.format(dataFormat, group_id, item_name, date_received, retail_price, quantity));
        
        return stockReport.toString();
    }

}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.InventoryManager;

import com.mycompany.JavaY2.Object.Inventory;
import com.mycompany.JavaY2.Object.Item;
import com.mycompany.JavaY2.Object.PurchaseOrder;
import com.mycompany.JavaY2.Object.Supplier;
import java.util.List;

/**
 *
 * @author Kaiqi
 */
public class GenerateStockReport {
    Item itemDetails;
    Inventory inventoryDetails;
    Supplier supplierDetails;
    List<PurchaseOrder> pendingOrders;
    
    public GenerateStockReport(Item item, Inventory inventory, Supplier supplier, List<PurchaseOrder> pendingOrders){
        this.itemDetails = item;
        this.inventoryDetails = inventory;
        this.supplierDetails = supplier;
        this.pendingOrders = pendingOrders;
    }
    
    public void generateStockReport(){
        StringBuilder stockReportContent = new StringBuilder();
        String headerFormat = "%-10s %-20s %-15s %-20s %-20s %-25s %-25s%n";
        String dataFormat = "%-10s %-20s %-15.2f %-20s %-20d %-25d %-25s%n";
        String separator = "---------------------------------------------------------------------------------\n";
        stockReportContent.append(separator);
        stockReportContent.append(String.format(headerFormat, "Item ID", "Item Name", "Retail Price", "Supplier Name", "Current Quantity", "Pending Order Quantity", "Available Stock Status"));
        stockReportContent.append(separator);
        
        if(itemDetails != null && inventoryDetails != null && supplierDetails != null){
            int pendingQuantity = 0;
            for (PurchaseOrder order : pendingOrders){
                if(order.order_status.equals("Pending")){
                    pendingQuantity += order.quantity;
                }
            }
            String availableStockStatus = (inventoryDetails.quantity <= itemDetails.safety_level) ? "Low":"Sufficient";
            
            stockReportContent.append(String.format(dataFormat, 
                    itemDetails.item_id,
                    itemDetails.item_name,
                    inventoryDetails.retail_price,
                    supplierDetails.supplier_name,
                    inventoryDetails.quantity,
                    pendingQuantity,
                    availableStockStatus));
        }else {
            stockReportContent.append("Error");
        }
        stockReportContent.append(separator);
                
    }
}

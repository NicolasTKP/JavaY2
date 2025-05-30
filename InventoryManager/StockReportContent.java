/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.InventoryManager;

/**
 *
 * @author Kaiqi
 */
public class StockReportContent {
    public String itemName;
    public String groupId;
    public int quantity;
    public String dateReceived;

    public StockReportContent(String itemName, String groupId, int quantity, String dateReceived) {
        this.itemName = itemName;
        this.groupId = groupId;
        this.quantity = quantity;
        this.dateReceived = dateReceived;
    }
}

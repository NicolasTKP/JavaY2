package com.mycompany.JavaY2;

import com.mycompany.JavaY2.Class.Edit;
import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Class.Search;
import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.SessionManager;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.JRException;


public class test {
    public static class Item {
        String itemID;
        String itemName;
        int quantity;
        double unitPrice;
        double amount;
        public Item(String itemID, String itemName, int quantity, double unitPrice, double amount){
            this.itemID = itemID;
            this.itemName = itemName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.amount = amount;
        }

        public String getItemID() {
            return itemID;
        }

        public String getItemName() {
            return itemName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getAmount() {
            return amount;
        }
    }
    public void test() throws IOException, JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("OrderID", "O001");
        parameters.put("OrderDate", "01052025");
        parameters.put("RequestBy", "ntkp");
        parameters.put("Supplier", "Hello supplier");
        parameters.put("RequisitionID", "R001");
        parameters.put("ShippingTerm", "12 Days");
        parameters.put("PaymentTerm", "pay after ship");
        parameters.put("VendorCode", "SU001");
        parameters.put("VendorName", "Hello supplier");
        parameters.put("VendorAddress", "Kuala Lumpur");
        parameters.put("VendorPhone", "011-111-1111");
        parameters.put("TotalAmount", "35.0");
        parameters.put("Status", "Approved");

        List<Item> itemList = Arrays.asList(
                new Item("I001", "orange", 10, 3.5, 35.0)
        );
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(itemList);
        JasperReport report = JasperCompileManager.compileReport("src//main//java//com//mycompany//JavaY2//PDF//PurchaseOrder.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

        try {
            JasperExportManager.exportReportToPdfFile(
                    print,
                    "src//main//java//com//mycompany//JavaY2//PDF//purchase_order.pdf"
            );
        } catch (net.sf.jasperreports.engine.JRRuntimeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof java.io.FileNotFoundException) {
                JOptionPane.showMessageDialog(null,
                        "The PDF file is currently open in another program.\nPlease close it and try again.",
                        "File Access Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Failed to export PDF: " + e.getMessage(),
                        "Export Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "An unexpected error occurred: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            desktop.open(new java.io.File("src//main//java//com//mycompany//JavaY2//PDF//purchase_order.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to open PDF: " + e.getMessage());
        }
    }
}

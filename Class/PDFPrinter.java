package com.mycompany.JavaY2.Class;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDFPrinter {
    public static class PDFItem {
        String itemID;
        String itemName;
        String quantity;
        String unitPrice;
        String amount;
        public PDFItem(String itemID, String itemName, String quantity, String unitPrice, String amount){
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

        public String getQuantity() {
            return quantity;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public String getAmount() {
            return amount;
        }
    }

    public static class PDFRequest {
        String groupID;
        String itemName;
        String quantity;
        String remainingStock;
        String stockAfterRestock;
        public PDFRequest(String groupID, String itemName, String quantity, String remainingStock, String stockAfterRestock){
            this.groupID = groupID;
            this.itemName = itemName;
            this.quantity = quantity;
            this.remainingStock = remainingStock;
            this.stockAfterRestock = stockAfterRestock;
        }

        public String getGroupID() {
            return groupID;
        }

        public String getItemName() {
            return itemName;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getRemainingStock() {
            return remainingStock;
        }

        public String getStockAfterRestock() {
            return stockAfterRestock;
        }
    }
    public void printPurchaseOrder(String orderID, String orderDate, String requester, String supplier, String PRID,
                                   String shippingTerm, String paymentTerm, String vendorCode, String vendorName,
                                   String vendorAddress, String vendorPhone, String totalAmount, String status,
                                   PDFPrinter.PDFItem items) throws IOException, JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("OrderID", orderID);
        parameters.put("OrderDate", orderDate);
        parameters.put("RequestBy", requester);
        parameters.put("Supplier", supplier);
        parameters.put("RequisitionID", PRID);
        parameters.put("ShippingTerm", shippingTerm);
        parameters.put("PaymentTerm", paymentTerm);
        parameters.put("VendorCode", vendorCode);
        parameters.put("VendorName", vendorName);
        parameters.put("VendorAddress", vendorAddress);
        parameters.put("VendorPhone", vendorPhone);
        parameters.put("TotalAmount", totalAmount);
        parameters.put("Status", status);

        List<PDFPrinter.PDFItem> itemList = Arrays.asList(
                items
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

    public void printPurchaseRequisition(String requestID, String requester, String requestDate, String requiredDate,
                                   String status, PDFPrinter.PDFRequest request) throws IOException, JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("RequisitionID", requestID);
        parameters.put("RequestBy", requester);
        parameters.put("RequestDate", requestDate);
        parameters.put("RequiredDate", requiredDate);
        parameters.put("Status", status);

        List<PDFPrinter.PDFRequest> requestList = Arrays.asList(
                request
        );

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(requestList);
        JasperReport report = JasperCompileManager.compileReport("src//main//java//com//mycompany//JavaY2//PDF//PurchaseRequisition.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

        try {
            JasperExportManager.exportReportToPdfFile(
                    print,
                    "src//main//java//com//mycompany//JavaY2//PDF//purchase_requisition.pdf"
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
            desktop.open(new java.io.File("src//main//java//com//mycompany//JavaY2//PDF//purchase_requisition.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to open PDF: " + e.getMessage());
        }
    }
}

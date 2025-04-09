package com.mycompany.JavaY2.Class;

import com.mycompany.JavaY2.Object.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UpdateTable {

    public static void forPO(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<PurchaseOrder> orders = objectList.getPurchaseOrders();
        String[][] matrix = new String[orders.size()][10];
        PurchaseOrder order;
        for (int i = 0;i<orders.size();i++){
            order = orders.get(i);
            matrix[i][0] = order.order_id;
            matrix[i][1] = order.request_id;
            matrix[i][2] = order.item_name;
            matrix[i][3] = order.username;
            matrix[i][4] = Integer.toString(order.quantity);
            matrix[i][5] = Double.toString(order.unit_price);
            matrix[i][6] = Double.toString(order.amount);
            matrix[i][7] = order.supplier_name;
            matrix[i][8] = order.order_date.toString();
            matrix[i][9] = order.order_status;
        }
        jTable.setModel(new DefaultTableModel(
                                 matrix,
                                 new String [] {
                                         "Order_ID", "Request_ID", "Item_Name", "Username","Quantity","Unit_Price","Amount","Supplier","Order_Date","Order_Status"
                                 }
                         ){
                             @Override
                             public boolean isCellEditable(int row, int column) {
                                 return false;
                             }
                         }
        );
    }

    public static void forReceive(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<Receives> receives = objectList.getReceives();
        String[][] matrix = new String[receives.size()][7];
        Receives receive;
        for (int i = 0;i<receives.size();i++){
            receive = receives.get(i);
            matrix[i][0] = receive.order_id;
            matrix[i][1] = receive.item_id;
            matrix[i][2] = receive.item_name;
            matrix[i][3] = Integer.toString(receive.quantity);
            matrix[i][4] = Double.toString(receive.amount);
            matrix[i][5] = receive.delivery_status;
            matrix[i][6] = receive.date_received;
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Order_ID", "Item_ID", "Item_Name","Quantity","Amount","Delivery Status","Date Received"                                }
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }

    public static void forUser(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<User> users = objectList.getUsers();
        String[][] matrix = new String[users.size()][4];
        User user;
        for (int i = 0;i<users.size();i++){
            user = users.get(i);
            matrix[i][0] = user.user_id;
            matrix[i][1] = user.username;
            matrix[i][2] = user.password;
            matrix[i][3] = user.role;
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "User_ID", "Username", "Password","Role"}
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }

    public static void forItems(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<Item> items = objectList.getItems();
        String[][] matrix = new String[items.size()][8];
        Item item;
        for (int i = 0;i<items.size();i++){
            item = items.get(i);
            matrix[i][0] = item.item_id;
            matrix[i][1] = item.item_name;
            matrix[i][2] = Double.toString(item.stock_price);
            matrix[i][3] = Integer.toString(item.sales_per_day);
            matrix[i][4] = Integer.toString(item.ordering_lead_time);
            matrix[i][5] = Integer.toString(item.safety_level);
            matrix[i][6] = Search.getSupplierName(item.supplier_id);
            matrix[i][7] = item.group_id;

        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Item_ID", "Item Name","Stock Price","Sales Per Day","Ordering Lead Time", "Safety Level", "Supplier", "Group ID"}
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }

    public static void forInventory(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<Inventory> inventories = objectList.getInventory();
        String[][] matrix = new String[inventories.size()][4];
        Inventory inventory;
        for (int i = 0;i<inventories.size();i++){
            inventory = inventories.get(i);
            matrix[i][0] = inventory.group_id;
            matrix[i][1] = inventory.item_name;
            matrix[i][2] = Integer.toString(inventory.quantity);
            matrix[i][3] = Double.toString(inventory.retail_price);
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Group_ID", "Item Name","Quantity","Retail Price"}
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }

    public static void forInventoryValue(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<Inventory_Value> inventories = objectList.getInventoryValue();
        String[][] matrix = new String[inventories.size()][5];
        Inventory_Value inventory;
        for (int i = 0;i<inventories.size();i++){
            inventory = inventories.get(i);
            matrix[i][0] = inventory.group_id;
            matrix[i][1] = inventory.item_name;
            matrix[i][2] = Integer.toString(inventory.quantity);
            matrix[i][3] = Double.toString(inventory.average_unit_price);
            matrix[i][4] = Double.toString(inventory.actual_value);
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Group ID", "Item Name", "Quantity", "Average Unit Price", "Actual Value"}
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }

    public static void forPayment(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<Payment> payments = objectList.getPayments();
        String[][] matrix = new String[payments.size()][6];
        Payment payment;
        for (int i = 0;i<payments.size();i++){
            payment = payments.get(i);
            matrix[i][0] = payment.order_id;
            matrix[i][1] = payment.item_id;
            matrix[i][2] = Integer.toString(payment.quantity);
            matrix[i][3] = Double.toString(payment.amount);
            matrix[i][4] = payment.payment_status;
            matrix[i][5] = payment.payment_date;
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Order ID", "Item ID", "Quantity", "Amount", "Payment Status", "Payment Date"}
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }

    public static void forSupplier(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<Supplier> suppliers = objectList.getSuppliers();
        String[][] matrix = new String[suppliers.size()][6];
        Supplier supplier;
        for (int i = 0;i<suppliers.size();i++){
            supplier = suppliers.get(i);
            matrix[i][0] = supplier.supplier_id;
            matrix[i][1] = supplier.supplier_name;
            matrix[i][2] = supplier.address;
            matrix[i][3] = supplier.contact;
            matrix[i][4] = supplier.supply_items;
            matrix[i][5] = supplier.payment_term;
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Supplier ID", "Supplier Name", "Address", "Contact", "Supply Items","Payment Term"}
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }

    public static void forDailySale(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<DailySale> daily_sales = objectList.getDailySales();
        String[][] matrix = new String[daily_sales.size()][5];
        DailySale daily_sale;
        for (int i = 0;i<daily_sales.size();i++){
            daily_sale = daily_sales.get(i);
            matrix[i][0] = daily_sale.daily_sales_id;
            matrix[i][1] = Integer.toString(daily_sale.quantity);
            matrix[i][2] = Search.getItemNamebyGroupID(daily_sale.group_id);
            matrix[i][3] = Double.toString(daily_sale.retail_price);
            matrix[i][4] = daily_sale.date;
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Daily Sales ID", "Quantity", "Item Name", "Retail Price", "Date"}
                        ){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        }
        );
    }
}

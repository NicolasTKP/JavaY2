package com.mycompany.JavaY2.Class;

import com.mycompany.JavaY2.Object.ObjectList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UpdateTable {

    public static void forPO(JTable jTable){
        ObjectList objectList = new ObjectList();
        List<ObjectList.PurchaseOrder> orders = objectList.getPurchaseOrders();
        String[][] matrix = new String[orders.size()][10];
        ObjectList.PurchaseOrder order;
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
}

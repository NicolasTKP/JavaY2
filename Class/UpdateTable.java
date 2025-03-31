package com.mycompany.JavaY2.Class;

import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.PurchaseOrder;
import com.mycompany.JavaY2.Object.Receives;
import com.mycompany.JavaY2.Object.User;

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
        String[][] matrix = new String[receives.size()][6];
        Receives receive;
        for (int i = 0;i<receives.size();i++){
            receive = receives.get(i);
            matrix[i][0] = receive.order_id;
            matrix[i][1] = receive.item_id;
            matrix[i][2] = receive.item_name;
            matrix[i][3] = Integer.toString(receive.quantity);
            matrix[i][4] = Double.toString(receive.amount);
            matrix[i][5] = receive.delivery_status;
        }
        jTable.setModel(new DefaultTableModel(
                                matrix,
                                new String [] {
                                        "Order_ID", "Item_ID", "Item_Name","Quantity","Amount","Delivery_Status"                                }
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
}

package com.mycompany.JavaY2.Object;

import com.mycompany.JavaY2.Class.Search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectList {

    public List<PurchaseOrder> getPurchaseOrders(){
        List<PurchaseOrder> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders"));
            String line;
            String[] lines;
            br.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            while ((line = br.readLine()) != null) {
                PurchaseOrder order = new PurchaseOrder();
                lines = line.split("\\|");
                order.order_id = lines[0];
                order.request_id = lines[1];
                order.item_id = lines[2];
                order.user_id = lines[3];
                order.username = Search.getUsername(order.user_id);
                order.quantity = Integer.parseInt(lines[4]);
                order.unit_price = Double.parseDouble(lines[5]);
                order.amount = Double.parseDouble(lines[6]);
                order.supplier_id = lines[7];
                order.order_date = LocalDate.parse(lines[8], formatter);
                order.order_status = lines[9];
                order.item_name = Search.getItemName(lines[2]);
                order.supplier_name = Search.getSupplierName(lines[7]);
                ls.add(order);
            }
            br.close();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class PurchaseOrder{
        public String order_id;
        public String request_id;
        public String item_id;
        public String user_id;
        public String username;
        public int quantity;
        public double unit_price;
        public double amount;
        public String supplier_id;
        public LocalDate order_date;
        public String order_status;
        public String item_name;
        public String supplier_name;

        PurchaseOrder(){
        }
        PurchaseOrder(String order_id, String request_id, String item_id, String user_id, String username, int quantity, double unit_price, double amount, String supplier_id, LocalDate order_date, String order_status, String item_name, String supplier_name){
            this.order_id = order_id;
            this.request_id = request_id;
            this.item_id = item_id;
            this.user_id = user_id;
            this.username = username;
            this.quantity = quantity;
            this.unit_price = unit_price;
            this.amount = amount;
            this.supplier_id = supplier_id;
            this.order_date = order_date;
            this.order_status = order_status;
            this.item_name = item_name;
            this.supplier_name = supplier_name;
        }
    }
}

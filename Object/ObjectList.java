package com.mycompany.JavaY2.Object;

import com.mycompany.JavaY2.Class.Search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
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


    public List<Receives> getReceives(){
        List<Receives> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders"));
            String line;
            String[] lines;
            br.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            while ((line = br.readLine()) != null) {
                Receives receive = new Receives();
                lines = line.split("\\|");
                if (lines[9].equals("Approved")){
                    receive.order_id = lines[0];
                    receive.request_id = lines[1];
                    receive.item_id = lines[2];
                    receive.user_id = lines[3];
                    receive.username = Search.getUsername(receive.user_id);
                    receive.quantity = Integer.parseInt(lines[4]);
                    receive.unit_price = Double.parseDouble(lines[5]);
                    receive.amount = Double.parseDouble(lines[6]);
                    receive.supplier_id = lines[7];
                    receive.order_date = LocalDate.parse(lines[8], formatter);
                    receive.order_status = lines[9];
                    receive.item_name = Search.getItemName(lines[2]);
                    receive.supplier_name = Search.getSupplierName(lines[7]);
                    receive.delivery_status = Search.getDeliveryStatus(receive.order_id);
                    ls.add(receive);
                }
            }
            ls.sort(Comparator.comparing(receive -> !receive.delivery_status.equals("Not Received")));
            br.close();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }




}


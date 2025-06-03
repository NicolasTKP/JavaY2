package com.mycompany.JavaY2.Object;

import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Class.Search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
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
                try{
                    order.order_date = LocalDate.parse(lines[8], formatter);
                }catch (DateTimeParseException e){
                    order.order_date = null;
                }

                order.order_status = lines[9];
                order.item_name = Search.getItemNamebyItemID(lines[2]);
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
                    try{
                        receive.order_date = LocalDate.parse(lines[8], formatter);
                    }catch (DateTimeParseException e){
                        receive.order_date = null;
                    }
                    receive.order_status = lines[9];
                    receive.item_name = Search.getItemNamebyItemID(lines[2]);
                    receive.supplier_name = Search.getSupplierName(lines[7]);
                    receive.delivery_status = Search.getDeliveryStatus(receive.order_id);
                    receive.payment_status = Search.getPaymentStatus(receive.order_id);
                    receive.date_received = Search.getDateReceived(receive.order_id);
                    receive.payment_date = Search.getPaymentDate(receive.order_id);
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



    public List<User> getUsers(){
        List<User> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                User user = new User() {};
                lines = line.split("\\|");
                user.setUserID(lines[0]);
                user.setUsername(lines[1]);
                user.setPassword(lines[2]);
                user.setRole(lines[3]);
                ls.add(user);
            }
            br.close();
            ls.reversed();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Item> getItems(){
        List<Item> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Item item = new Item();
                lines = line.split("\\|");
                item.item_id = lines[0];
                item.item_name = lines[1];
                item.stock_price = Double.parseDouble(lines[2]);
                item.sales_per_day = Integer.parseInt(lines[3]);
                item.ordering_lead_time = Integer.parseInt(lines[4]);
                item.safety_level = Integer.parseInt(lines[5]);
                item.supplier_id = lines[6];
                item.group_id = lines[7];
                ls.add(item);
            }
            br.close();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Inventory> getInventory(){
        List<Inventory> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Inventory inventory = new Inventory();
                lines = line.split("\\|");
                inventory.group_id = lines[0];
                inventory.item_name = lines[1];
                inventory.quantity = Integer.parseInt(lines[2]);
                inventory.retail_price = Double.parseDouble(lines[3]);
                ls.add(inventory);
            }
            br.close();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Inventory_Value> getInventoryValue(){
        List<Inventory_Value> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Inventory_Value inventory_value = new Inventory_Value();
                lines = line.split("\\|");
                inventory_value.group_id = lines[0];
                inventory_value.item_name = lines[1];
                inventory_value.quantity = Integer.parseInt(lines[2]);
                inventory_value.retail_price = Double.parseDouble(lines[3]);
                String[] purchase_orders = Query.getAllPurchaseOrder(inventory_value.group_id);
                assert purchase_orders != null;
                int quantity = inventory_value.quantity;
                double unit_prices = 0.0;
                double total_value = 0.0;
                for (String order:purchase_orders){
                    String[] orders = order.split("\\|");
                    if (Integer.parseInt(orders[0]) < quantity){
                        total_value = total_value + Double.parseDouble(orders[2]);
                        quantity = quantity - Integer.parseInt(orders[0]);
                    }else if(Integer.parseInt(orders[0]) > quantity){
                        total_value = total_value + (Double.parseDouble(Integer.toString(quantity)) * Double.parseDouble(orders[1]));
                        break;
                    }else{
                        total_value = total_value + Double.parseDouble(orders[2]);
                        break;
                    }
                }
                unit_prices = total_value/Double.parseDouble(Integer.toString(inventory_value.quantity));
                inventory_value.average_unit_price = Math.round(unit_prices*100.0)/100.0;
                inventory_value.actual_value = total_value;
                ls.add(inventory_value);
            }
            br.close();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Payment> getPayments(){
        List<Payment> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Payment payment = new Payment();
                lines = line.split("\\|");
                payment.order_id = lines[0];
                payment.item_id = lines[1];
                payment.quantity = Integer.parseInt(lines[3]);
                payment.amount = Double.parseDouble(lines[4]);
                payment.payment_status = lines[8];
                payment.payment_date = lines[7];
                ls.add(payment);
            }
            br.close();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Supplier> getSuppliers(){
        List<Supplier> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Supplier supplier = new Supplier();
                lines = line.split("\\|");
                supplier.supplier_id = lines[0];
                supplier.supplier_name = lines[1];
                supplier.address = lines[2];
                supplier.contact = lines[3];
                supplier.supply_items = lines[4];
                supplier.payment_term = lines[5];
                ls.add(supplier);
            }
            br.close();
            return ls;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DailySale> getDailySales(){
        List<DailySale> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/daily_sales_items"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                DailySale daily_sales = new DailySale();
                lines = line.split("\\|");
                daily_sales.daily_sales_id = lines[0];
                daily_sales.quantity = Integer.parseInt(lines[1]);
                daily_sales.group_id = lines[2];
                daily_sales.retail_price = Double.parseDouble(lines[3]);
                daily_sales.date = lines[4];
                ls.add(daily_sales);
            }
            br.close();
            return ls.reversed();
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PurchaseRequisition> getPurchaseRequisitions(){
        List<PurchaseRequisition> ls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));
            String line;
            String[] lines;
            br.readLine();
            while ((line = br.readLine()) != null) {
                PurchaseRequisition purchase_requisition = new PurchaseRequisition();
                lines = line.split("\\|");
                purchase_requisition.request_id = lines[0];
                purchase_requisition.group_id = lines[1];
                purchase_requisition.user_id = lines[2];
                purchase_requisition.quantity = Integer.parseInt(lines[3]);
                purchase_requisition.request_date = lines[4];
                purchase_requisition.required_date = lines[5];
                purchase_requisition.status = lines[6];
                purchase_requisition.item_name = Search.getItemNamebyGroupID(purchase_requisition.group_id);
                ls.add(purchase_requisition);
            }
            br.close();
            return ls.reversed();
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}


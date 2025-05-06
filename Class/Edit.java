package com.mycompany.JavaY2.Class;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Edit {
    public static void purchaseOrders(String orderID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders", false));
            String[] items;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                items = line.split("\\|");
                if (items.length>column && items[0].equals(orderID)){
                    items[column] = value;
                }
                bw.write(String.join("|",items));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void purchaseRequisitions(String requestID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions", false));
            String[] items;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                items = line.split("\\|");
                if (items.length>column && items[0].equals(requestID)){
                    items[column] = value;
                }
                bw.write(String.join("|",items));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void users(String userID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/users", false));
            String[] items;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                items = line.split("\\|");
                if (items.length>column && items[0].equals(userID)){
                    items[column] = value;
                }
                bw.write(String.join("|",items));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inventory(String groupID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/inventory", false));
            String[] items;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                items = line.split("\\|");
                if (items.length>column && items[0].equals(groupID)){
                    items[column] = value;
                }
                bw.write(String.join("|",items));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void item(String itemID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/items", false));
            String[] items;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                items = line.split("\\|");
                if (items.length>column && items[0].equals(itemID.toUpperCase())){
                    items[column] = value;
                }
                bw.write(String.join("|",items));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void supplier(String supplierID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/suppliers", false));
            String[] suppliers;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                suppliers = line.split("\\|");
                if (suppliers.length>column && suppliers[0].equals(supplierID.toUpperCase())){
                    suppliers[column] = value;
                }
                bw.write(String.join("|",suppliers));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receives(String orderID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/receives", false));
            String[] receives;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                receives = line.split("\\|");
                if (receives.length>column && receives[0].equals(orderID.toUpperCase())){
                    receives[column] = value;
                }
                bw.write(String.join("|",receives));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dailySalesItems(String dailySalesID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/daily_sales_items"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/daily_sales_items", false));
            String[] sales;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                sales = line.split("\\|");
                if (sales.length>column && sales[0].equals(dailySalesID.toUpperCase())){
                    sales[column] = value;
                }
                bw.write(String.join("|",sales));
                if (i < linesList.size() - 1) {
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeItemForInventory(String supplierID, String itemID){
        String item_line = TextFile.getColumn("src/main/java/com/mycompany/JavaY2/TextFile/suppliers",0, supplierID, 4);
        assert item_line != null;
        String[] items_id = item_line.split(",");
        List<String> items = new ArrayList<>();
        for(String item:items_id){
            System.out.println(item);
            if(!item.equals(itemID)){
                items.add(item);
            }
        }
        items_id = items.toArray(new String[0]);
        item_line = String.join(",", items_id);
        Edit.supplier(supplierID,4,item_line);
    }

    public static void addItemForInventory(String supplierID, String itemID){
        String item_line = TextFile.getColumn("src/main/java/com/mycompany/JavaY2/TextFile/suppliers",0, supplierID, 4);
        assert item_line != null;

        if (!item_line.isEmpty() && !item_line.isBlank()){
            item_line = item_line + "," + itemID;
        }else{
            item_line = itemID;
        }
        Edit.supplier(supplierID,4,item_line);
    }

    public static void updateSalesTxt(){
        String first_line = "sales_id|date|amount";
        Map<String, Double> sales = new HashMap<>();
        try{
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/daily_sales_items"));
            linesList.removeFirst();
            for (String line:linesList){
                String[] lines = line.split("\\|");
                sales.put(lines[4], sales.getOrDefault(lines[4],0.0) + (Double.parseDouble(lines[3])*Double.parseDouble(lines[1])));
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/TextFile/sales", false));
            bw.write(first_line);
            int i = 1;
            for (Map.Entry<String, Double> entry : sales.entrySet()) {
                String date = entry.getKey();
                String amount = Double.toString(entry.getValue());
                String sales_id = String.format("%s%05d", "S", i);
                i++;
                bw.newLine();
                bw.write(sales_id+"|"+date+"|"+amount);
            }
            bw.close();
        }catch (IOException e){

        }
    }
}

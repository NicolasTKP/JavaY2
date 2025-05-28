package com.mycompany.JavaY2.Class;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Edit {

    public static void editingColumn(String textfile, String id, int column,String value){
        String path = switch (textfile) {
            case "PO" -> "src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders";
            case "PR" -> "src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions";
            case "user" -> "src/main/java/com/mycompany/JavaY2/TextFile/users";
            case "inventory" -> "src/main/java/com/mycompany/JavaY2/TextFile/inventory";
            case "item" -> "src/main/java/com/mycompany/JavaY2/TextFile/items";
            case "supplier" -> "src/main/java/com/mycompany/JavaY2/TextFile/suppliers";
            case "receive" -> "src/main/java/com/mycompany/JavaY2/TextFile/receives";
            case "daily_sales_item" -> "src/main/java/com/mycompany/JavaY2/TextFile/daily_sales_items";
            default -> "";
        };
        try {
            List<String> linesList = Files.readAllLines(Paths.get(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
            String[] lines;
            String line;
            for (int i = 0; i < linesList.size(); i++) {
                line = linesList.get(i);
                lines = line.split("\\|");
                if (lines.length>column && lines[0].equals(id.toUpperCase())){
                    lines[column] = value;
                }
                bw.write(String.join("|",lines));
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
        Edit.editingColumn("supplier", supplierID,4,item_line);
    }

    public static void addItemForInventory(String supplierID, String itemID){
        String item_line = TextFile.getColumn("src/main/java/com/mycompany/JavaY2/TextFile/suppliers",0, supplierID, 4);
        assert item_line != null;

        if (!item_line.isEmpty() && !item_line.isBlank()){
            item_line = item_line + "," + itemID;
        }else{
            item_line = itemID;
        }
        Edit.editingColumn("supplier", supplierID,4,item_line);
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

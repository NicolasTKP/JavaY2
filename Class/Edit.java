package com.mycompany.JavaY2.Class;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Edit {
    public static void purchaseOrders(String orderID, int column,String value){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/purchase_orders"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/JavaY2/purchase_orders", false));
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
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

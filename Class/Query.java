package com.mycompany.JavaY2.Class;

import com.mycompany.JavaY2.Object.ObjectList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Query {
    public static boolean anyMatchOrder(ObjectList.PurchaseOrder order, String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                order.order_id.toLowerCase(),
                order.request_id.toLowerCase(),
                order.item_id.toLowerCase(),
                order.user_id.toLowerCase(),
                order.username.toLowerCase(),
                Integer.toString(order.quantity),
                Double.toString(order.unit_price),
                Double.toString(order.amount),
                order.supplier_id.toLowerCase(),
                order.order_date.toString().toLowerCase(),
                order.order_status.toLowerCase(),
                order.item_name.toLowerCase(),
                order.supplier_name.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }

    public static String getLatestOrderID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(1));
            number++;
            return String.format("%s%03d", "O", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getPendingPR(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));
            List<String> res = new ArrayList<>();
            for (String line:linesList){
                String[] column = line.split("\\|");
                if (column[column.length-1].equals("Pending")){
                    res.add(column[0]);
                }
            }
            return res.toArray(new String[0]);


        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

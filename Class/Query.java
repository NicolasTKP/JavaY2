package com.mycompany.JavaY2.Class;

import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.PurchaseOrder;
import com.mycompany.JavaY2.Object.Receives;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Query {

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

    public static String getLatestUserID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(1));
            number++;
            return String.format("%s%03d", "U", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getLatestGroupID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(1));
            number++;
            return String.format("%s%03d", "G", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getLatestItemID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(1));
            number++;
            return String.format("%s%03d", "I", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getLatestSupplierID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(2));
            number++;
            return String.format("%s%03d", "SU", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getLatestDailySalesID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/daily_sales_items"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(2));
            number++;
            return String.format("%s%05d", "DS", number);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getLatestRequestID(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions"));
            String line = linesList.getLast();
            String latest = line.split("\\|")[0];
            int number = Integer.parseInt(latest.substring(2));
            number++;
            return String.format("%s%03d", "R", number);

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

    public static boolean ifItemExist(String itemID){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            for (String line:linesList){
                String[] column = line.split("\\|");
                if (column[0].equalsIgnoreCase(itemID)&&!line.equals(linesList.getFirst())){
                    return true;
                }
            }
            return false;

        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean ifUserExist(String username){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/users"));
            for (String line:linesList){
                String[] column = line.split("\\|");
                if (column[1].equalsIgnoreCase(username)&&!line.equals(linesList.getFirst())){
                    return true;
                }
            }
            return false;

        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] getAllSupplier(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String[] ls = new String[linesList.size()-1];
            for (int i=1;i<linesList.size();i++){
                String line = linesList.get(i);
                String[] column = line.split("\\|");
                ls[i-1] = column[1];
            }
            return ls;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getAllItemGroup(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String[] ls = new String[linesList.size()-1];
            for (int i=1;i<linesList.size();i++){
                String line = linesList.get(i);
                String[] column = line.split("\\|");
                ls[i-1] = column[1];
            }
            return ls;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getAllContact(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/suppliers"));
            String[] ls = new String[linesList.size()-1];
            for (int i=1;i<linesList.size();i++){
                String line = linesList.get(i);
                String[] column = line.split("\\|");
                ls[i-1] = column[3];
            }
            return ls;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getNotReceivedReceives(){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            List<String> ls = new ArrayList<>();
            for (int i=1;i<linesList.size();i++){
                String line = linesList.get(i);
                String[] column = line.split("\\|");
                if (column[6].equals("Not Received")){
                    ls.add(column[0]);
                }
            }
            return ls.toArray(new String[0]);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] notUsedSuppliers(String[] suppliers, String group_id){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            List<String> ls = new ArrayList<>(Arrays.asList(suppliers));
            for (String line:linesList){
                if(line.split("\\|")[7].equals(group_id)){
                    ls.remove(Search.getSupplierName(line.split("\\|")[6]));
                }
            }
            return ls.toArray(new String[0]);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCurrectDate(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return today.format(formatter);
    }

    public static String[] getAllPurchaseOrder(String groupID){
        try {
            List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders"));
            Map<LocalDate, String> map = new HashMap<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            for(int i = 1; i<linesList.size();i++){
                String line = linesList.get(i);
                String[] lines = line.split("\\|");
                String str_date = TextFile.getColumn("src/main/java/com/mycompany/JavaY2/TextFile/receives", 0, lines[0], 5);
                if (!(str_date == null) && !str_date.equals("-")){
                    LocalDate date = LocalDate.parse(str_date, formatter);
                    if(Search.getGroupIDbyItemName(Search.getItemNamebyItemID(lines[2])).equals(groupID)){
                        String item = lines[4] + "|" + lines[5] + "|" + lines[6];
                        map.put(date, item);
                    }
                }
            }
            Map<LocalDate, String> sortedMap = new TreeMap<>((a, b) -> b.compareTo(a));
            sortedMap.putAll(map);
            return sortedMap.values().toArray(new String[0]);

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

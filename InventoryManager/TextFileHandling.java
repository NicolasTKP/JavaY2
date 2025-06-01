/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.InventoryManager;

import com.mycompany.JavaY2.Class.Search;
import com.mycompany.JavaY2.Object.Item;
import com.mycompany.JavaY2.Object.Receive;
import com.mycompany.JavaY2.Object.Inventory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kaiqi
 */
public class TextFileHandling {
    public List<Item> getItemList(){
        List<Item> itemList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/items"));
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                if (data[2].isEmpty()) {
                    data[2] = "0.0";
                }
                Item item = new Item(
                    data[0],                     
                    data[1],
                    Double.parseDouble(data[2]),
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]),   
                    data[6],                      
                    data[7]                       
                );
                itemList.add(item);  
            }
            br.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        return itemList;
    }
    
    public List<Receive> getReceiveList(){
        List<Receive> receiveList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/receives"));
            String line;
            br.readLine();
            while((line = br.readLine())!= null){
                String[] data = line.split("\\|");

                if(data[6].equals("Not Received")){
                    Receive receive = new Receive(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        Double.parseDouble(data[4]),
                        data[5],
                        data[6],
                        data[7],
                        data[8]     
                    );
                    receiveList.add(receive);
                }
            }
            br.close();
    
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return receiveList;

}
    
    public List<Inventory> getLowStockItems(){
        List<Inventory> lowStockAlerts = new ArrayList<>();
        List<Item> itemList = getItemList();
        Map<String, Item> itemMap  = new HashMap<>();
        for (Item item : itemList){
            String key = item.item_name.toLowerCase() + "|" + Search.getGroupIDbyItemName(item.item_name).toLowerCase();
            itemMap.merge(key, item, (existingItem, newItem) ->
                newItem.safety_level > existingItem.safety_level ? newItem : existingItem
            );
        }
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mycompany/JavaY2/TextFile/inventory"));
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                
                if (data.length >= 3){
                    String groupId = data[0];
                    String itemName = data[1];
                    int quantity = Integer.parseInt(data[2]);
                    
                    String key = itemName.toLowerCase() + "|" + groupId.toLowerCase();
                    Item item = itemMap.get(key);
                    
                    if(item != null && quantity <= item.safety_level){
                        Inventory lowStock = new Inventory(
                        groupId,
                        itemName,
                        quantity,
                        item.safety_level
                    );
                    lowStockAlerts.add(lowStock);
                    }
                }
            }
        }catch(IOException | NumberFormatException e){
            e.printStackTrace();
        }
        return lowStockAlerts;
    }
    
}

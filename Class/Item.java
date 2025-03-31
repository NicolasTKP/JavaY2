package com.mycompany.JavaY2.Class;

import javax.swing.JOptionPane;

public class Item {
    public String item_id;
    public String item_name;
    public int quantity;
    public double stock_price;
    public double retail_price;
    public int low_stock_benchmark;
    public String supplier_id;
    
    public Item(){
        
    }
    public Item(String item_id, String item_name, int quantity, double stock_price, double retail_price, int low_stock_benchmark, String supplier_id ){
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.stock_price = stock_price;
        this.retail_price = retail_price;
        this.low_stock_benchmark = low_stock_benchmark;
        this.supplier_id = supplier_id;

    }

    public String getItemId(){
        return item_id;
    }
    public void setItem_id(String item_id){
        this.item_id = item_id;
    }
    
    public String getItemName(){
        return item_name;
    }
    
    public void setItemName(String item_name){
        String nameRegex = "^[A-Za-z]+(\\s[A-Za-z]+)*$";
        if (item_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter item name.");
        }else if (!item_name.matches(nameRegex)) {
            JOptionPane.showMessageDialog(null, "Invalid item name.");
            this.item_name = null;
            return;
        }
        this.item_name = item_name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(String input_quantity){
        if (input_quantity.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter item quantity.");
        }else if (!input_quantity.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for item quantity.");
        }else{
            try{
                int quantity = Integer.parseInt(input_quantity);
                if (quantity <=0){
                    JOptionPane.showMessageDialog(null, "Item quantity cannot be 0 or less than 0");
                }else{
                    this.quantity = quantity;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for item quantity.");
            }
        } 
    }
    
    public double getStockPrice(){
        return stock_price;
    }
    
    public void setStockPrice(String input_stock_price){
        if (input_stock_price.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter item stock price.");
        }else if (!input_stock_price.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for item quantity.");
        }else{
            try{
                double stock_price= Double.parseDouble(input_stock_price);
                if (quantity <=0){
                    JOptionPane.showMessageDialog(null, "Item stock price cannot be 0 or less than 0");
                }else{
                    this.stock_price = stock_price;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for item stock price.");
            }
        } 
    }
    
    public double getRetailPrice(){
        return retail_price;
    }
    
    public void setRetailPrice(String input_retail_price){
        if (input_retail_price.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter item retail price.");
        }else if (!input_retail_price.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for item quantity.");
        }else{
            try{
                double retail_price= Double.parseDouble(input_retail_price);
                if (quantity <=0){
                    JOptionPane.showMessageDialog(null, "Item retail price cannot be 0 or less than 0");
                }else{
                    this.retail_price = retail_price;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for item retail price.");
            }
        } 
    }
    
}
    

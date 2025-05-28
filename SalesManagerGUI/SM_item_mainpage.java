/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.JavaY2.SalesManagerGUI;


import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.Inventory;
import com.mycompany.JavaY2.Object.Item;
import com.mycompany.JavaY2.Object.SessionManager;
import com.mycompany.javaY2.Class.DataMapping;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class SM_item_mainpage extends javax.swing.JFrame {
    private final String item_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/items";
    private final String supplier_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/suppliers";
    private final String inventory_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/inventory";
    
    private final DefaultTableModel itemContainer = new DefaultTableModel();
    private final DefaultTableModel inventoryContainer = new DefaultTableModel();
    private final String itemTableColumnName[] = {"Item ID", "Item Name", "Stock Price", "Sales per day", "Ordering Lead Time (Days)", "Safety Level", "Supplier", "Group ID"};
    private final String inventoryTableColumnName[] = {"Group ID", "Item Name", "Quantity", "Retail Price"};
    /**
     * Creates new form sales_manager_item_management
     */
    public SM_item_mainpage() {
        initComponents();
        populateItemTable();
        populateInventoryTable();
      
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                itemContainer.setRowCount(0);
                populateItemTable();
                
                inventoryContainer.setRowCount(0);
                populateInventoryTable();             
            }
        });
        
        item_search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemSearchFunction(item_search_bar.getText());
            }
        });
        
        inventory_search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inventorySearchFunction(inventory_search_bar.getText());
            }
        });
    }
    
    private void populateItemTable(){
        DataMapping mapping = new DataMapping();
        Map<String, String> supplier_map = mapping.IdNameMapping(supplier_file_path);
        Map<Integer, Map<String, String>> column_mappings = new HashMap<>();
        column_mappings.put(6, supplier_map); // supplier_id column
        TextFile.populateTable(itemContainer, item_table, itemTableColumnName, item_file_path, 50,column_mappings);         
    }
 
    private void populateInventoryTable(){
        TextFile.populateTable(inventoryContainer, inventory_table, inventoryTableColumnName, inventory_file_path, 50);         
    }

    
    private void itemSearchFunction(String item_keyword) {
        itemContainer.setRowCount(0); // Clear existing rows
        item_keyword = item_keyword.toLowerCase().trim();
        
        if (item_keyword.isEmpty()) {
            populateItemTable(); // <- call your full data loader
            return;
        }
            
        DataMapping mapping = new DataMapping();
        Map<String,String> supplier_map = mapping.IdNameMapping(supplier_file_path);

        try (BufferedReader br = new BufferedReader(new FileReader(item_file_path))) {
            String item_line;
            Set<String> uniqueItemRows = new HashSet<>();
            br.readLine(); // skip header

            while ((item_line = br.readLine()) != null) {
                if (!item_line.trim().isEmpty() && !uniqueItemRows.contains(item_line)) {
                    String[] item_details = item_line.split("\\|");

                    // Create an Item object from the line
                    Item item = new Item(
                        item_details[0], // item_id
                        item_details[1], // item_name
                        Double.parseDouble(item_details[2]), // stock_price
                        Integer.parseInt(item_details[3]), // sales_per_day
                        Integer.parseInt(item_details[4]), // ordering_lead_time
                        Integer.parseInt(item_details[5]), // safety_level
                        supplier_map.get(item_details[6]), // supplier_id
                        item_details[7]  // group_id
                    );

                    if (item.anyMatch(item_keyword)) {
                        // Replace supplier_id with supplier_name
                        item_details[6] = supplier_map.get(item_details[6]);
                        itemContainer.addRow(item_details);
                        uniqueItemRows.add(item_line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading item file during search: " + e.getMessage());
        }
    }

    private void inventorySearchFunction(String inventory_keyword) {
        inventoryContainer.setRowCount(0); // Clear existing rows
        inventory_keyword = inventory_keyword.toLowerCase().trim();
        
        if (inventory_keyword.isEmpty()) {
            populateInventoryTable(); // <- call your full data loader
            return;
        }
            
        try (BufferedReader br = new BufferedReader(new FileReader(inventory_file_path))) {
            String inventory_line;
            Set<String> uniqueInventoryRows = new HashSet<>();
            br.readLine(); // skip header

            while ((inventory_line = br.readLine()) != null) {
                if (!inventory_line.trim().isEmpty() && !uniqueInventoryRows.contains(inventory_line)) {
                    String[] inventory_details = inventory_line.split("\\|");

                    // Create an Item object from the line
                    Inventory inventory = new Inventory(
                            inventory_details[0],
                            inventory_details[1],
                            Integer.parseInt(inventory_details[2]),
                            Double.parseDouble(inventory_details[3])
                    );

                    if (inventory.anyMatch(inventory_keyword)) {
                        inventoryContainer.addRow(inventory_details);
                        uniqueInventoryRows.add(inventory_line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading item file during search: " + e.getMessage());
        }
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        add_item_button = new javax.swing.JButton();
        homepage_button1 = new javax.swing.JButton();
        edit_item_button = new javax.swing.JButton();
        delete_item_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        item_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        inventory_table = new javax.swing.JTable();
        add_item_label = new javax.swing.JLabel();
        add_item_label1 = new javax.swing.JLabel();
        item_search_bar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inventory_search_bar = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add_item_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        add_item_button.setText("Add Item");
        add_item_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_item_buttonActionPerformed(evt);
            }
        });

        homepage_button1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        homepage_button1.setText("Homepage");
        homepage_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homepage_button1ActionPerformed(evt);
            }
        });

        edit_item_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        edit_item_button.setText("Edit Item");
        edit_item_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_item_buttonActionPerformed(evt);
            }
        });

        delete_item_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        delete_item_button.setText("Delete Item");
        delete_item_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_item_buttonActionPerformed(evt);
            }
        });

        item_table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        item_table.setModel(itemContainer);
        item_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(item_table);

        inventory_table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inventory_table.setModel(inventoryContainer);
        inventory_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventory_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(inventory_table);

        add_item_label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        add_item_label.setText("Inventory Table");

        add_item_label1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        add_item_label1.setText("Item Table");

        item_search_bar.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        item_search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_search_barActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Item Search Bar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Inventory Search Bar");

        inventory_search_bar.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        inventory_search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_search_barActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homepage_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_item_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inventory_search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(add_item_label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(item_search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addComponent(add_item_label1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(item_search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homepage_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(add_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add_item_label)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inventory_search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edit_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_item_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_item_buttonActionPerformed
        String password = JOptionPane.showInputDialog("Please insert your user password");
        if (password == null || !password.equals(SessionManager.getInstance().password)){
            JOptionPane.showMessageDialog(null, "Wrong password, action denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            new SM_item_add().setVisible(true);           
        }       
        

    }//GEN-LAST:event_add_item_buttonActionPerformed

    private void homepage_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homepage_button1ActionPerformed
        new SM_mainpage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homepage_button1ActionPerformed

    private void edit_item_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_item_buttonActionPerformed
        int selected_row = item_table.getSelectedRow();
        
        String password = JOptionPane.showInputDialog("Please insert your user password");
        if (password == null || !password.equals(SessionManager.getInstance().password)){
            JOptionPane.showMessageDialog(null, "Wrong password, action denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (selected_row != -1) {
            int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure to edit this item?",
                "Confirm To Edit?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                String item_id = item_table.getValueAt(selected_row , 0).toString();
                String item_name = item_table.getValueAt(selected_row , 1).toString();
                String stock_price = item_table.getValueAt(selected_row , 2).toString();
                String sales_per_day = item_table.getValueAt(selected_row , 3).toString();
                String ordering_lead_time = item_table.getValueAt(selected_row , 4).toString();
                String safety_level = item_table.getValueAt(selected_row , 5).toString();
                String supplier_id = item_table.getValueAt(selected_row , 6).toString();
                String group_id = item_table.getValueAt(selected_row , 7).toString();

                new SM_item_edit(item_id, item_name, stock_price, sales_per_day, ordering_lead_time, safety_level, supplier_id, group_id).setVisible(true);
            } else {
                // Cancel editing
            JOptionPane.showMessageDialog(null, "You have decided to not edit item details. Back to item mainpage now");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an item to edit.");
        }
    }//GEN-LAST:event_edit_item_buttonActionPerformed

    private void delete_item_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_item_buttonActionPerformed
        int selected_row = item_table.getSelectedRow();
        
        String password = JOptionPane.showInputDialog("Please insert your user password");
        if (password == null || !password.equals(SessionManager.getInstance().password)){
            JOptionPane.showMessageDialog(null, "Wrong password, action denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String selected_id = item_table.getValueAt(selected_row, 0).toString();
        
        if (selected_row != -1) {
            int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure to delete this item?",
                "Confirm To Delete?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                TextFile.deleteTextfileLine(item_file_path, selected_id);
                JOptionPane.showMessageDialog(null, "You have deleted the item. Item table is updated");
            } else {
                // Cancel editing
            JOptionPane.showMessageDialog(null, "You have decided to not delete the item. Back to item mainpage now");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an item to delete.");
        }
    }//GEN-LAST:event_delete_item_buttonActionPerformed

    private void item_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_tableMouseClicked
        System.out.println(item_table.getSelectedRow());
    }//GEN-LAST:event_item_tableMouseClicked

    private void inventory_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_inventory_tableMouseClicked

    private void item_search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_search_barActionPerformed
        String item_keyword = item_search_bar.getText();
        itemSearchFunction(item_keyword);
    }//GEN-LAST:event_item_search_barActionPerformed

    private void inventory_search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_search_barActionPerformed
        String inventory_keyword = inventory_search_bar.getText();
        inventorySearchFunction(inventory_keyword);
    }//GEN-LAST:event_inventory_search_barActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SM_item_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SM_item_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SM_item_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SM_item_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SM_item_mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_item_button;
    private javax.swing.JLabel add_item_label;
    private javax.swing.JLabel add_item_label1;
    private javax.swing.JButton delete_item_button;
    private javax.swing.JButton edit_item_button;
    private javax.swing.JButton homepage_button1;
    private javax.swing.JTextField inventory_search_bar;
    private javax.swing.JTable inventory_table;
    private javax.swing.JTextField item_search_bar;
    private javax.swing.JTable item_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

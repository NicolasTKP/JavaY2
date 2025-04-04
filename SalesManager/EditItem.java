/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.JavaY2.SalesManager;

import com.mycompany.JavaY2.Class.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class EditItem extends javax.swing.JFrame {

    /**
     * Creates new form EditItem
     * @param item_id
     * @param item_name
     * @param stock_price
     * @param sales_per_day
     * @param ordering_lead_time
     * @param safety_level
     * @param supplier_id
     * @param group_id
     */
    public EditItem(String item_id, String item_name, String stock_price, String sales_per_day, String ordering_lead_time, String safety_level, String supplier_id, String group_id ) {
        initComponents();
        jTextField_item_id.setText(item_id);
        jTextField_item_name.setText(item_name);
        jTextField_stock_price.setText(stock_price);
        jTextField_sales_per_day.setText(sales_per_day);
        jTextField_ordering_lead_time.setText(ordering_lead_time);
        jTextField_safety_level.setText(safety_level);
        jTextField_supplier_id.setText(supplier_id);
        jTextField_group_id.setText(group_id);
        
        // Add key listeners to update safety level dynamically
        jTextField_sales_per_day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateSafetyLevel();
            }
        });

        jTextField_ordering_lead_time.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateSafetyLevel();
            }
        });        
        
        
        setVisible(true);
    }

    private void updateSafetyLevel() {
        try {
            // Get the values entered by the user
            String inputSalesPerDay = jTextField_sales_per_day.getText();
            String inputOrderingLeadTime = jTextField_ordering_lead_time.getText();

            // Ensure that the values are not empty
            if (!inputSalesPerDay.isEmpty() && !inputOrderingLeadTime.isEmpty()) {
                int salesPerDay = Integer.parseInt(inputSalesPerDay);
                int orderingLeadTime = Integer.parseInt(inputOrderingLeadTime);

                // Calculate safety level using your existing logic
                int safetyLevel = salesPerDay * orderingLeadTime; // Modify if needed

                // Update the safety level field
                jTextField_safety_level.setText(String.valueOf(safetyLevel));
            }
        } catch (NumberFormatException e) {
            // Handle invalid inputs
            jTextField_safety_level.setText("Invalid Input");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel_item_name = new javax.swing.JLabel();
        jTextField_item_name = new javax.swing.JTextField();
        jTextField_stock_price = new javax.swing.JTextField();
        jLabel_stock_price = new javax.swing.JLabel();
        jLabel_retail_price = new javax.swing.JLabel();
        jLabel_low_stock_benchmark = new javax.swing.JLabel();
        jLabel_low_stock_benchmark2 = new javax.swing.JLabel();
        jLabel_low_stock_benchmark1 = new javax.swing.JLabel();
        jTextField_supplier_id = new javax.swing.JTextField();
        jButton_edit_supplier = new javax.swing.JButton();
        jLabel_item_name1 = new javax.swing.JLabel();
        jTextField_item_id = new javax.swing.JTextField();
        jLabel_low_stock_benchmark3 = new javax.swing.JLabel();
        jTextField_safety_level = new javax.swing.JTextField();
        jLabel_group_id = new javax.swing.JLabel();
        jTextField_group_id = new javax.swing.JTextField();
        jTextField_sales_per_day = new javax.swing.JTextField();
        jTextField_ordering_lead_time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Edit Item");

        jLabel_item_name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_item_name.setText("Item Name: ");

        jTextField_item_name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField_item_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_item_nameActionPerformed(evt);
            }
        });

        jTextField_stock_price.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel_stock_price.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_stock_price.setText("Stock Price:");

        jLabel_retail_price.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_retail_price.setText("Sales Per Day:");

        jLabel_low_stock_benchmark.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_low_stock_benchmark.setText("Ordering Lead ");

        jLabel_low_stock_benchmark2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_low_stock_benchmark2.setText("Times (Days):");

        jLabel_low_stock_benchmark1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_low_stock_benchmark1.setText("Supplier:");

        jTextField_supplier_id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField_supplier_id.setEnabled(false);

        jButton_edit_supplier.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton_edit_supplier.setText("Edit");
        jButton_edit_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_edit_supplierActionPerformed(evt);
            }
        });

        jLabel_item_name1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_item_name1.setText("Item ID ");

        jTextField_item_id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField_item_id.setEnabled(false);
        jTextField_item_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_item_idActionPerformed(evt);
            }
        });

        jLabel_low_stock_benchmark3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_low_stock_benchmark3.setText("Safety Level:");

        jTextField_safety_level.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField_safety_level.setEnabled(false);

        jLabel_group_id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_group_id.setText("Group ID:");

        jTextField_group_id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField_group_id.setEnabled(false);

        jTextField_sales_per_day.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTextField_ordering_lead_time.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_stock_price)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_item_name)
                            .addComponent(jLabel_retail_price)
                            .addComponent(jLabel_low_stock_benchmark2)
                            .addComponent(jLabel_low_stock_benchmark)
                            .addComponent(jLabel_item_name1)
                            .addComponent(jLabel_low_stock_benchmark3)
                            .addComponent(jLabel_group_id)
                            .addComponent(jLabel_low_stock_benchmark1))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_group_id, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton_edit_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_item_id, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(jTextField_stock_price, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(jTextField_item_name, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(jTextField_safety_level)
                                .addComponent(jTextField_sales_per_day, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(jTextField_ordering_lead_time, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_item_name1)
                            .addComponent(jTextField_item_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_item_name)
                            .addComponent(jTextField_item_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_stock_price)
                            .addComponent(jTextField_stock_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel_retail_price))
                    .addComponent(jTextField_sales_per_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel_low_stock_benchmark)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_low_stock_benchmark2)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ordering_lead_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_low_stock_benchmark3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_safety_level, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_low_stock_benchmark1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_group_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_group_id))
                .addGap(40, 40, 40)
                .addComponent(jButton_edit_supplier)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_item_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_item_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_item_nameActionPerformed

    private void jButton_edit_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_edit_supplierActionPerformed
        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\items";
        Item item = new Item();
        
        String item_id = jTextField_item_id.getText();
        
        String item_name = jTextField_item_name.getText();
        item.setItemName(item_name);
        
        String input_stock_price = jTextField_stock_price.getText();
        item.setStockPrice(input_stock_price);
        
        String input_sales_per_day = jTextField_sales_per_day.getText();
        int sales_per_day = Integer.parseInt(input_sales_per_day);
        item.setSalesPerDay(sales_per_day);
        
        String input_ordering_lead_time = jTextField_ordering_lead_time.getText();
        int ordering_lead_time = Integer.parseInt(input_ordering_lead_time);
        
        item.setOrderingLeadTime(ordering_lead_time);
        
        int safety_level = item.setSafetyLevel(sales_per_day, ordering_lead_time);
        
        String supplier_id = jTextField_supplier_id.getText();
        
        String group_id = jTextField_group_id.getText();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            StringBuilder updatedContent = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\|");

                if (columns.length < 8) {
                    updatedContent.append(line).append("\n");  
                    continue;
                    }

                if (columns[0].trim().equals(item_id.trim())) {
                    line = item_id + "|" + item_name + "|" + input_stock_price + "|" + sales_per_day + "|" + ordering_lead_time + "|" + safety_level + "|" + supplier_id + "|" + group_id;
                    found = true;
                }
                updatedContent.append(line).append("\n");  
            }
            br.close();

            if (!found) {
                JOptionPane.showMessageDialog(this, "Item not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file_path, false));
            bw.write(updatedContent.toString());
            bw.close();

            JOptionPane.showMessageDialog(this, "Item updated successfully!");
            this.dispose();  // Close the edit window

       }catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Item updating supplier: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_edit_supplierActionPerformed

    private void jTextField_item_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_item_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_item_idActionPerformed

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
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_edit_supplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_group_id;
    private javax.swing.JLabel jLabel_item_name;
    private javax.swing.JLabel jLabel_item_name1;
    private javax.swing.JLabel jLabel_low_stock_benchmark;
    private javax.swing.JLabel jLabel_low_stock_benchmark1;
    private javax.swing.JLabel jLabel_low_stock_benchmark2;
    private javax.swing.JLabel jLabel_low_stock_benchmark3;
    private javax.swing.JLabel jLabel_retail_price;
    private javax.swing.JLabel jLabel_stock_price;
    private javax.swing.JTextField jTextField_group_id;
    private javax.swing.JTextField jTextField_item_id;
    private javax.swing.JTextField jTextField_item_name;
    private javax.swing.JTextField jTextField_ordering_lead_time;
    private javax.swing.JTextField jTextField_safety_level;
    private javax.swing.JTextField jTextField_sales_per_day;
    private javax.swing.JTextField jTextField_stock_price;
    private javax.swing.JTextField jTextField_supplier_id;
    // End of variables declaration//GEN-END:variables
}

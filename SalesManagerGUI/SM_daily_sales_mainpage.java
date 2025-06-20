/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.JavaY2.SalesManagerGUI;
import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.DailySale;
import com.mycompany.JavaY2.Class.DataMapping;
import com.mycompany.JavaY2.Object.SessionManager;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SM_daily_sales_mainpage extends javax.swing.JFrame {
    private final String daily_sales_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/daily_sales_items";
    private final String inventory_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/inventory";
    private final DefaultTableModel salesContainer = new DefaultTableModel();
    private final String salesTableColumnName[] = {"Daily Sales ID", "Quantity", "Item Name", "Retail Price", "Date"};
    
    /**
     * Creates new form SM_daily_sales_mainpage
     */
    public SM_daily_sales_mainpage() {
        initComponents();
        populateSalesTable();
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                salesContainer.setRowCount(0);
                populateSalesTable();                           
            }
        });

        daily_sales_search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dailySalesSearchFunction(daily_sales_search_bar.getText());
            }
        });
        
        all_daily_sales_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salesContainer.setRowCount(0);
                populateSalesTable();
            }
        });

        today_daily_sales_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salesContainer.setRowCount(0);
                populateSalesTableForToday();
            }
        });
        
    }
    
    private void populateSalesTable(){
        DataMapping mapping = new DataMapping();
        Map<String, String> inventory_map = mapping.IdNameMapping(inventory_file_path);
        Map<Integer, Map<String, String>> column_mappings = new HashMap<>();
        column_mappings.put(2, inventory_map);
        TextFile.populateTable(salesContainer, sales_table, salesTableColumnName, daily_sales_file_path, 50,column_mappings);          
    }
    
    private void populateSalesTableForToday(){
        DailySale.populateDailySalesTable(salesContainer, sales_table, salesTableColumnName, daily_sales_file_path, 50);
    }
    
    private void dailySalesSearchFunction(String daily_sales_keyword) {
        salesContainer.setRowCount(0); // Clear existing rows
        daily_sales_keyword = daily_sales_keyword.toLowerCase().trim();
        
        if (daily_sales_keyword.isEmpty()) {
            populateSalesTable(); // <- call your full data loader
            return;
        }
            
        DataMapping mapping = new DataMapping();
        Map<String,String> inventory_map = mapping.IdNameMapping(inventory_file_path);

        try (BufferedReader br = new BufferedReader(new FileReader(daily_sales_file_path))) {
            String daily_sales_line;
            Set<String> uniqueSalesRows = new HashSet<>();
            br.readLine(); // skip header

            while ((daily_sales_line = br.readLine()) != null) {
                if (!daily_sales_line.trim().isEmpty() && !uniqueSalesRows.contains(daily_sales_line)) {
                    String[] daily_sales_details = daily_sales_line.split("\\|");
                    
                    // Create an Item object from the line
                    DailySale daily_sales = new DailySale(
                            daily_sales_details[0],
                            Integer.parseInt(daily_sales_details[1]),
                            inventory_map.get(daily_sales_details[2]),
                            Double.parseDouble(daily_sales_details[3]),
                            daily_sales_details[4]
                    );

                    if (daily_sales.anyMatch(daily_sales_keyword)) {
                        
                        daily_sales_details[2] = inventory_map.get(daily_sales_details[2]);
                        salesContainer.addRow(daily_sales_details);
                        uniqueSalesRows.add(daily_sales_line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading daily sales file during search: " + e.getMessage());
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

        homepage_button1 = new javax.swing.JButton();
        add_sales_button = new javax.swing.JButton();
        edit_sales_button = new javax.swing.JButton();
        delete_sales_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sales_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        daily_sales_search_bar = new javax.swing.JTextField();
        all_daily_sales_button = new javax.swing.JButton();
        today_daily_sales_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homepage_button1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        homepage_button1.setText("Homepage");
        homepage_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homepage_button1ActionPerformed(evt);
            }
        });

        add_sales_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        add_sales_button.setText("Add Sales");
        add_sales_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_sales_buttonActionPerformed(evt);
            }
        });

        edit_sales_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        edit_sales_button.setText("Edit Sales");
        edit_sales_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sales_buttonActionPerformed(evt);
            }
        });

        delete_sales_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        delete_sales_button.setText("Delete Sales");
        delete_sales_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_sales_buttonActionPerformed(evt);
            }
        });

        sales_table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sales_table.setModel(salesContainer);
        jScrollPane1.setViewportView(sales_table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Sales Record Table");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Sales Record Search Bar");

        daily_sales_search_bar.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        daily_sales_search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daily_sales_search_barActionPerformed(evt);
            }
        });

        all_daily_sales_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        all_daily_sales_button.setText("All");

        today_daily_sales_button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        today_daily_sales_button.setText("Today");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homepage_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(daily_sales_search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(all_daily_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(today_daily_sales_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(daily_sales_search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homepage_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(add_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(edit_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(delete_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(all_daily_sales_button)
                            .addComponent(today_daily_sales_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homepage_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homepage_button1ActionPerformed
        new SM_mainpage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homepage_button1ActionPerformed

    private void add_sales_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_sales_buttonActionPerformed
        String password = JOptionPane.showInputDialog("Please insert your user password");
        if (password == null || !password.equals(SessionManager.getInstance().password)){
            JOptionPane.showMessageDialog(null, "Wrong password, action denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            new SM_daily_sales_add().setVisible(true);            
        }        
    }//GEN-LAST:event_add_sales_buttonActionPerformed

    private void edit_sales_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sales_buttonActionPerformed
        int selected_row = sales_table.getSelectedRow();
        String sales_id = sales_table.getValueAt(selected_row , 0).toString();
        String quantity = sales_table.getValueAt(selected_row , 1).toString();
        String group_id = sales_table.getValueAt(selected_row , 2).toString();
        String retail_price = sales_table.getValueAt(selected_row , 3).toString();
        String date = sales_table.getValueAt(selected_row , 4).toString();   
        
        String password = JOptionPane.showInputDialog("Please insert your user password");
        if (password == null || !password.equals(SessionManager.getInstance().password)){
            JOptionPane.showMessageDialog(null, "Wrong password, action denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (selected_row != -1) {
            int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure to edit this daily sales record?",
                "Confirm To Edit?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                    new SM_daily_sales_edit(sales_id, quantity, group_id, retail_price, date).setVisible(true);                 
            } else {
                // Cancel editing
            JOptionPane.showMessageDialog(null, "You have decided to not edit the sales record. Back to sales record mainpage now");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a sales record to edit.");
        }
    }//GEN-LAST:event_edit_sales_buttonActionPerformed

    private void delete_sales_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_sales_buttonActionPerformed
        int selected_row = sales_table.getSelectedRow();
        
        String password = JOptionPane.showInputDialog("Please insert your user password");
        if (password == null || !password.equals(SessionManager.getInstance().password)){
            JOptionPane.showMessageDialog(null, "Wrong password, action denied", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String selected_id = sales_table.getValueAt(selected_row, 0).toString();
        int quantity_difference = Integer.parseInt(sales_table.getValueAt(selected_row, 1).toString());  // quantity
        String item_name = sales_table.getValueAt(selected_row, 2).toString();  // group_id    
        String sales_record_date = sales_table.getValueAt(selected_row,4).toString();        
        
        DataMapping mapping = new DataMapping();
        Map<String, String> inventory_map = mapping.NameIdMapping(inventory_file_path);
        String group_id = inventory_map.get(item_name);
        
        if (selected_row != -1) {
            int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure to delete this daily sales record?",
                "Confirm To Delete?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                
                Date current_date = new Date();
                SimpleDateFormat date_format = new SimpleDateFormat("ddMMyyyy");
                String today = date_format.format(current_date);  
                
                if(!sales_record_date.equals(today)){
                    JOptionPane.showMessageDialog(null, "You are not allow to delete the past sales records");                        
                }else{
                    TextFile.deleteLine(daily_sales_file_path, selected_id, 0);
                    DailySale.adjustInventoryQuantity(this, inventory_file_path, group_id, quantity_difference); 
                    JOptionPane.showMessageDialog(null, "You have deleted the daily sales record. Daily sales table is updated, inventory is restored");                    
                }

            } else {
                // Cancel editing
                JOptionPane.showMessageDialog(null, "You have decided to not delete the daily sales record. Back to daily sales mainpage now");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a daily sales record to delete.");
        }

    }//GEN-LAST:event_delete_sales_buttonActionPerformed

    private void daily_sales_search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daily_sales_search_barActionPerformed
        String daily_sales_keyword = daily_sales_search_bar.getText();
        dailySalesSearchFunction(daily_sales_keyword);
    }//GEN-LAST:event_daily_sales_search_barActionPerformed

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
            java.util.logging.Logger.getLogger(SM_daily_sales_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SM_daily_sales_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SM_daily_sales_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SM_daily_sales_mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SM_daily_sales_mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_sales_button;
    private javax.swing.JButton all_daily_sales_button;
    private javax.swing.JTextField daily_sales_search_bar;
    private javax.swing.JButton delete_sales_button;
    private javax.swing.JButton edit_sales_button;
    private javax.swing.JButton homepage_button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sales_table;
    private javax.swing.JButton today_daily_sales_button;
    // End of variables declaration//GEN-END:variables
}

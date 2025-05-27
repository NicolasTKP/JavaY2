/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.JavaY2.SalesManagerGUI;
import com.mycompany.JavaY2.Object.DailySale;
import com.mycompany.javaY2.Class.DataMapping;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import java.io.*;

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
    }
    
    private void populateSalesTable(){
        salesContainer.setRowCount(0);
        salesContainer.setColumnIdentifiers(salesTableColumnName);
        sales_table.setRowHeight(50);

        DataMapping mapping = new DataMapping();
        Map<String, String> inventory_map = mapping.IdNameMapping(inventory_file_path);
        
        try (BufferedReader br = new BufferedReader(new FileReader(daily_sales_file_path))) {
            String item_line;
            Set<String> uniqueItemRows = new HashSet<>();
            
            br.readLine(); 
            while ((item_line = br.readLine()) != null) {
                if (!uniqueItemRows.contains(item_line)){
                    if (item_line.trim().isEmpty()){
                        continue;                        
                    } 
                    String sales_details[] = item_line.split("\\|");
                    String group_id = sales_details[2];
                    String item_name = inventory_map.get(group_id);
                    sales_details[2] = item_name;
                    salesContainer.addRow(sales_details);                   
                }

            }
        } catch (IOException e) {
            System.out.println("Error reading item text file for item table.");
        }         
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
        jLabel1.setText("Daily Sales Table");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Daily Sales Search Bar");

        daily_sales_search_bar.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        daily_sales_search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daily_sales_search_barActionPerformed(evt);
            }
        });

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
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(daily_sales_search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homepage_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(add_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(edit_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(delete_sales_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homepage_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homepage_button1ActionPerformed
        new SM_mainpage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homepage_button1ActionPerformed

    private void add_sales_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_sales_buttonActionPerformed
        new SM_daily_sales_add().setVisible(true);
    }//GEN-LAST:event_add_sales_buttonActionPerformed

    private void edit_sales_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sales_buttonActionPerformed

    }//GEN-LAST:event_edit_sales_buttonActionPerformed

    private void delete_sales_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_sales_buttonActionPerformed

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
    private javax.swing.JTextField daily_sales_search_bar;
    private javax.swing.JButton delete_sales_button;
    private javax.swing.JButton edit_sales_button;
    private javax.swing.JButton homepage_button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sales_table;
    // End of variables declaration//GEN-END:variables
}

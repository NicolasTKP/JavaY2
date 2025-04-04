/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.JavaY2.SalesManager;

import com.mycompany.JavaY2.Class.PurchaseRequisition;
import com.mycompany.JavaY2.Class.DataMapping;
import com.mycompany.JavaY2.Class.Mapping;  
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author User
 */
public class PREntry extends javax.swing.JFrame {
    private final String columnName [] = {"Request ID", "Item Name", "Person in Charge", "Quantity", "Request Date", "Required Date", "Status"};
    private final DefaultTableModel container = new DefaultTableModel(columnName, 0);

    /**
     * Creates new form PREntry
     */
    public PREntry() {
        initComponents(); 
        String pr_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/purchase_requisitions";
        String inventory_file_path = "src/main/java/com/mycompany/JavaY2/TextFile/inventory";
        jTable_pr.setRowHeight(50);
        jTable_pr.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable_pr.getColumnModel().getColumn(1).setPreferredWidth(80); 
        jTable_pr.getColumnModel().getColumn(2).setPreferredWidth(100); 
        jTable_pr.getColumnModel().getColumn(3).setPreferredWidth(50); 
        jTable_pr.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable_pr.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable_pr.getColumnModel().getColumn(6).setPreferredWidth(100);  
        
        String[] columnNames = {"Request ID", "Item Name", "User ID", "Quantity", "Request Date", "Required Date", "Status"};
        container.setColumnIdentifiers(columnNames);
        container.setRowCount(0); // clear existing rows
        
        Mapping mapping = new DataMapping();
        Map<String, String> pr_inventory_map = mapping.loadInventoryMap(inventory_file_path);
        List<PurchaseRequisition> prList = PurchaseRequisition.readPRFromFile(pr_file_path, pr_inventory_map);

        try (BufferedReader br = new BufferedReader(new FileReader(pr_file_path))) {
            String line;
            br.readLine(); // Skip header
            Set<String> uniqueRows = new HashSet<>();
            
            while ((line = br.readLine()) != null) {
                if (!uniqueRows.contains(line)) { // Ensure uniqueness
                    uniqueRows.add(line);
                    String[] pr_details = line.split("\\|");

                    if (pr_details.length == 7) { // Ensure correct data structure
                        String groupId = pr_details[1].trim();
                        String itemName = pr_inventory_map.getOrDefault(groupId, "Unknown Item"); // Map group ID to item name

                        // Replace group ID with item name in the array
                        pr_details[1] = itemName;

                        container.addRow(pr_details);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading PR file");
        }        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent evt) {
                container.setRowCount(0); // Clear existing rows
                try (BufferedReader br = new BufferedReader(new FileReader(pr_file_path))) {
                    String line;
                    br.readLine(); // Skip header
                    Set<String> uniqueRows = new HashSet<>();

                    while ((line = br.readLine()) != null) {
                        if (!uniqueRows.contains(line)) { // Ensure uniqueness
                            uniqueRows.add(line);
                            String[] pr_details = line.split("\\|");

                            if (pr_details.length == 7) { // Ensure correct data structure
                                String groupId = pr_details[1].trim();
                                String itemName = pr_inventory_map.getOrDefault(groupId, "Unknown Item"); // Map group ID to item name

                                // Replace group ID with item name in the array
                                pr_details[1] = itemName;

                                container.addRow(pr_details);
                            }
                        }
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error reading file.");
                }                   
            }
        });        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JButton_Homepage = new javax.swing.JButton();
        JButton_add_pr = new javax.swing.JButton();
        JButton_edit_pr = new javax.swing.JButton();
        JButton_delete_pr = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_pr = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1168, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Purchase Requisition List");

        JButton_Homepage.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        JButton_Homepage.setText("Homepage");
        JButton_Homepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_HomepageActionPerformed(evt);
            }
        });

        JButton_add_pr.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        JButton_add_pr.setText("Add");
        JButton_add_pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_add_prActionPerformed(evt);
            }
        });

        JButton_edit_pr.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        JButton_edit_pr.setText("Edit");
        JButton_edit_pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_edit_prActionPerformed(evt);
            }
        });

        JButton_delete_pr.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        JButton_delete_pr.setText("Delete");
        JButton_delete_pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_delete_prActionPerformed(evt);
            }
        });

        jTable_pr.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable_pr.setModel(container);
        jTable_pr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_prMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_pr);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JButton_add_pr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButton_Homepage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButton_edit_pr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButton_delete_pr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(JButton_Homepage)
                        .addGap(43, 43, 43)
                        .addComponent(JButton_add_pr)
                        .addGap(43, 43, 43)
                        .addComponent(JButton_edit_pr)
                        .addGap(41, 41, 41)
                        .addComponent(JButton_delete_pr))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButton_HomepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_HomepageActionPerformed
        new sales_manager_homepage().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_JButton_HomepageActionPerformed

    private void JButton_add_prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_add_prActionPerformed
        new AddPurchaseRequisition().setVisible(true);
    }//GEN-LAST:event_JButton_add_prActionPerformed

    private void JButton_edit_prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_edit_prActionPerformed
        int selectedRow = jTable_pr.getSelectedRow(); // Get selected row index

        if (selectedRow != -1) {
            String request_id = jTable_pr.getValueAt(selectedRow, 0).toString();
            String item_name = jTable_pr.getValueAt(selectedRow, 1).toString();
            String user_id = jTable_pr.getValueAt(selectedRow, 2).toString();
            String quantity = jTable_pr.getValueAt(selectedRow, 3).toString();
            String request_date = jTable_pr.getValueAt(selectedRow, 4).toString();
            String required_date = jTable_pr.getValueAt(selectedRow, 5).toString();
            String pr_status = jTable_pr.getValueAt(selectedRow, 6).toString();

            new EditPurchaseRequisition(request_id, item_name, request_date).setVisible(true);
        }
    }//GEN-LAST:event_JButton_edit_prActionPerformed

    private void JButton_delete_prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_delete_prActionPerformed
        int selectedRow = jTable_pr.getSelectedRow();

        if (selectedRow == -1){
            return;
        }

        String file_path = "src\\main\\java\\com\\mycompany\\JavaY2\\TextFile\\purchase_requisitions";
        String request_id = jTable_pr.getValueAt(selectedRow, 0).toString();

        boolean delete_pr = PurchaseRequisition.deletePR(request_id, file_path);
        if(delete_pr){
            container.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Purchase requisitions has been deleted");            
        }else{
            JOptionPane.showMessageDialog(null, "Request ID not found.");
        }


    }//GEN-LAST:event_JButton_delete_prActionPerformed

    private void jTable_prMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_prMouseClicked
        System.out.println(jTable_pr.getSelectedRow());
    }//GEN-LAST:event_jTable_prMouseClicked

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
            java.util.logging.Logger.getLogger(PREntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PREntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PREntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PREntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PREntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton_Homepage;
    private javax.swing.JButton JButton_add_pr;
    private javax.swing.JButton JButton_delete_pr;
    private javax.swing.JButton JButton_edit_pr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_pr;
    // End of variables declaration//GEN-END:variables
}

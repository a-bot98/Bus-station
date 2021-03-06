
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp_pc
 */
public class EditTripWindow extends javax.swing.JFrame {

    /**
     * Creates new form EditTripWindow
     */
    public EditTripWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonImport = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "To", "price", "final price", "No. of stops", "Date of Departure", "Trip Type", "Vehicle type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 520, 216));

        jLabel1.setText("Please Choose the Trip you want to edit :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 17, 310, 39));

        jButtonImport.setText(" Import Data");
        jButtonImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 63, 122, -1));

        jButtonUpdate.setText("Update");
        jButtonUpdate.setEnabled(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 63, 114, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportActionPerformed
        String filepath ="Trips.txt";
        File file = new File(filepath);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
            Object[]lines =br.lines().toArray();
            for(int i=0;i<lines.length;i++)
            {
                String [] row = lines[i].toString().split("/");
                model.addRow(row);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditTripWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                jButtonUpdate.setEnabled(true);
                jButtonImport.setEnabled(false);
    }//GEN-LAST:event_jButtonImportActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
      
        String filepath ="Trips.txt";
        File file = new File(filepath);
        try {
            FileWriter fw= new FileWriter(file);
            BufferedWriter bw= new BufferedWriter(fw);
            for(int i=0;i<jTable1.getRowCount();i++) //rows
            {
                for(int j=0 ;j<jTable1.getColumnCount();j++)//column
                {
                    if(j == jTable1.getColumnCount()-1)
                        bw.write((String)jTable1.getValueAt(i, j).toString()+"\r\n");
                    else
                         bw.write((String)jTable1.getValueAt(i, j).toString()+"/");
                    
                }
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(EditTripWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jButtonImport.setEnabled(true);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(EditTripWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTripWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTripWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTripWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTripWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonImport;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

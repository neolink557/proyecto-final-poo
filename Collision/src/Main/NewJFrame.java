package Main;

import BackGrounds.BackGrounds;
import Characthers.Steve;
import java.awt.event.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Braya
 */
public class NewJFrame extends javax.swing.JFrame {
    Steve steve;
    int change=1;
    BackGrounds bg;
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        bg=new BackGrounds(jPanel1);
        steve=new Steve(jPanel1);
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1320, 1500));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1423, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1423, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int x,y;
        
        x=steve.CoordX();
        y=steve.CoordY();
        
        String direccionS[]=new String[10];
        direccionS[1]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s1.png";
        direccionS[2]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s2.png";
        direccionS[3]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s3.png";
        direccionS[4]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s4.png";
        direccionS[5]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s5.png";
        direccionS[6]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s6.png";
        direccionS[7]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s7.png";
        direccionS[8]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s8.png";
        direccionS[9]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Adelante/s9.png";
        String direccionW[]=new String[10];
        direccionW[1]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w1.png";
        direccionW[2]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w2.png";
        direccionW[3]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w3.png";
        direccionW[4]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w4.png";
        direccionW[5]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w5.png";
        direccionW[6]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w6.png";
        direccionW[7]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w7.png";
        direccionW[8]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w8.png";
        direccionW[9]="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Atras/w9.png";
        
        switch(evt.getKeyCode())
        {
            case 83:
             
                change ++;
                if(change == 9)
                change=1;
                y=y+10;
                
                break;
            case 87:
                change ++;
                if(change == 9)
                change=1;
                y=y-10;
                steve.DrawChar(jPanel1.getGraphics(), x, y, direccionW[change]);
                break;
            case 65:
                change ++;
                if(change == 9)
                change=1;
                x=x-10;
                steve.DrawChar(jPanel1.getGraphics(), x, y, direccionS[change]);
                break;
            case 68:
                change ++;
                if(change == 9)
                change=1;
                x=x+10;
                steve.DrawChar(jPanel1.getGraphics(), x, y, direccionS[change]);
                break;
                
        }
                
        if(evt.getKeyCode() == 83)
        {
            
            
            
        }
        if(evt.getKeyCode() == 87)
        {
            change ++;
            
            steve.DrawChar(jPanel1.getGraphics(), x, y, direccionW[change]);
            if(change == 9)
                change=1;
            
            
        }
        if(evt.getKeyCode() == 65)
        {
            change ++;
            steve.DrawChar(jPanel1.getGraphics(), x, y, direccionS[change]);
            if(change == 9)
                change=1;
            
        }
        if(evt.getKeyCode() == 68)
        {
            change ++;
            steve.DrawChar(jPanel1.getGraphics(), x, y, direccionS[change]);
            if(change == 9)
                change=1;
            
        }
        
    }//GEN-LAST:event_formKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
             // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
                    
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

package Main;

import BackGrounds.BackGrounds;
import BackGrounds.Refresh;
import Characthers.Enemy;
import Characthers.Steve;
import Powers.StevePower;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

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
    Enemy enemy;
    Enemy enemy1;
    StevePower powa;
    int change = 1;
    BackGrounds bg;
    Refresh refresh;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        Random n = new Random();
        int z=n.nextInt(1000);
        Random n1 = new Random();
        int z1=n1.nextInt(1000);
        bg = new BackGrounds(jPanel1);
        bg.DrawBack();
        steve = new Steve(jPanel1);
        steve.setActual(steve.getSkey(1));
        steve.DrawChar(500, 500, steve.getActual());
        powa = new StevePower(jPanel1, -200, -200, steve, steve.getLastkey(), enemy);
        enemy = new Enemy(jPanel1, z, z1, steve, powa);
        enemy.DrawEnemy(jPanel1.getGraphics(), enemy.getX(), enemy.getY());
        enemy.start();
        enemy1 = new Enemy(jPanel1, 0, 0, steve, powa);
        enemy1.DrawEnemy(jPanel1.getGraphics(), enemy1.getX(), enemy1.getY());
        enemy1.start();
        refresh = new Refresh(jPanel1, enemy, steve, powa, bg);
        refresh.start();

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
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
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
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int x, y, j;

        x = steve.CoordX();
        y = steve.CoordY();
        j = 15;
        if (steve.colision(enemy.getX(), enemy.getY(), enemy.getAltoe(), enemy.getAnchoe(), steve.CoordX(), steve.CoordY(), steve.getAltos(), steve.getAnchos()) || steve.colision(enemy1.getX(), enemy1.getY(), enemy1.getAltoe(), enemy1.getAnchoe(), steve.CoordX(), steve.CoordY(), steve.getAltos(), steve.getAnchos())) {
            steve.DrawChar(x, y, steve.getDeath());
            steve.setActual(steve.getDeath());

        } else {

            switch (evt.getKeyCode()) {
                case 83:

                    change++;
                    if (change == 9) {
                        change = 1;
                    }

                    y = y + j;
                    steve.DrawChar(x, y, steve.getSkey(change));
                    steve.setLastkey(83);
                    steve.setActual(steve.getSkey(change));
                    break;
                case 87:
                    change++;
                    if (change == 9) {
                        change = 1;
                    }

                    y = y - j;
                    steve.DrawChar(x, y, steve.getWkey(change));
                    steve.setLastkey(87);
                    steve.setActual(steve.getWkey(change));

                    break;

                case 65:
                    change++;
                    if (change == 9) {
                        change = 1;
                    }

                    x = x - j;
                    steve.DrawChar(x, y, steve.getAkey(change));
                    steve.setLastkey(65);
                    steve.setActual(steve.getAkey(change));
                    break;
                case 68:
                    change++;
                    if (change == 9) {
                        change = 1;
                    }

                    x = x + j;
                    steve.DrawChar(x, y, steve.getDkey(change));
                    steve.setLastkey(68);
                    steve.setActual(steve.getDkey(change));
                    break;

                case 69:
                    powa = new StevePower(jPanel1, x, y, steve, steve.getLastkey(), enemy);
                    powa.start();
                    enemy1.setPowa(powa);
                    enemy.setPowa(powa);
                    break;

            }

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

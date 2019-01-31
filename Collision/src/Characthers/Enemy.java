/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

import Powers.StevePower;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Braya
 */
public class Enemy extends Thread {

    int x, y, j;
    int anchoe;
    int altoe;
    Steve misteve;
    StevePower powa;
    JPanel miJP;
    Graphics g;
    String direct = "C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/al otro lado v/d1.png";
    boolean col = true;

    public Enemy(JPanel miJ, int xi, int yi, Steve misteve) {
        super();
        this.g = miJ.getGraphics();
        this.miJP = miJ;
        this.x = xi;
        this.y = yi;
        this.misteve = misteve;
    }

    public boolean isCol() {
        return col;
    }

    public void setCol(boolean col) {
        this.col = col;
    }

    public void DrawEnemy(Graphics g, int xi, int yi) {

        this.x = xi;
        this.y = yi;
        ImageIcon MiImagen = new ImageIcon(direct);
        g.drawImage(MiImagen.getImage(), xi, yi, miJP);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void run() {
        this.y = 150;
        j = 1;
        while (true) {
            while (j <= 550) {
                j = j + 5;
                try {
                    this.x = j;
                    misteve.DrawChar(g, misteve.CoordX(), misteve.CoordY(), misteve.direccion());
                    ImageIcon miImagen = new ImageIcon(direct);
                    this.g.drawImage(miImagen.getImage(), this.x + j, this.y, this.miJP);
                    altoe = miImagen.getIconHeight();
                    anchoe = miImagen.getIconWidth();
                    if (colision(this.x, this.y, this.altoe, this.anchoe, misteve.CoordX(), misteve.CoordY(), misteve.altos, misteve.anchos)) {
                        direct = "C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Enemies/ghost.png";

                    } else {
                        direct = "C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/al otro lado v/d1.png";
                    }
                    Enemy.sleep(50);
                    this.miJP.update(g);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            while (j > 0) {
                j = j - 5;
                try {
                    this.x = j;
                    misteve.DrawChar(g, misteve.CoordX(), misteve.CoordY(), misteve.direccion());
                    ImageIcon miImagen = new ImageIcon(direct);
                    g.drawImage(miImagen.getImage(), x + j, y, miJP);
                    altoe = miImagen.getIconHeight();
                    anchoe = miImagen.getIconWidth();

                    if (colision(this.x, this.y, this.altoe, this.anchoe, misteve.CoordX(), misteve.CoordY(), misteve.altos, misteve.anchos)) {
                        direct = "C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/Enemies/ghost.png";

                    } else {
                        direct = "C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/al otro lado v/d1.png";
                    }
                    Enemy.sleep(50);
                    this.miJP.update(g);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public boolean colision(int x1, int y1, int alto, int ancho, int x2, int y2, int alto2, int ancho2) {

        int lado1a,lado2a;
     
        
        lado1a=x2+ancho2;
        lado1a=y2+alto2;
          
        if ((x1 > x1 && x1 < x1 + ancho) && (y1 > y1 && y1 < y1 + alto)) {
            return true;
        } else {
            return false;
        }
        
    }

}

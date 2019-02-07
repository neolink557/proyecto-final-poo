/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

import Powers.StevePower;
import java.awt.Graphics;
import java.awt.Image;
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
    boolean col = true;
    int c = 1;

    Image[] death = {new ImageIcon(getClass().getResource("../resources/Enemies/death1.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death2.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death3.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death4.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death5.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death6.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death7.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death8.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death9.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death10.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death11.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death12.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death13.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death14.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death15.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death16.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death17.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death18.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Enemies/death19.png")).getImage()
    };
    Image[] wkey = {new ImageIcon(getClass().getResource("../resources/atras/w1.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w2.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w3.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w4.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w5.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w6.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w7.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w8.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/atras/w9.png")).getImage()
    };
    Image dkey = new ImageIcon(getClass().getResource("../resources/Enemies/s1.png")).getImage();
    Image[] akey = {new ImageIcon(getClass().getResource("../resources/al lado/a1.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a2.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a3.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a4.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a5.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a6.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a7.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a8.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al lado/a9.png")).getImage()
    };

    public Enemy(JPanel miJ, int xi, int yi, Steve misteve, StevePower powa) {
        super();
        this.g = miJ.getGraphics();
        this.x = xi;
        this.y = yi;
        this.misteve = misteve;
        this.powa = powa;
    }

    public void setPowa(StevePower powa) {
        this.powa = powa;
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

        g.drawImage(dkey, xi, yi, null);

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

    public int getAnchoe() {
        return anchoe;
    }

    public void setAnchoe(int anchoe) {
        this.anchoe = anchoe;
    }

    public int getAltoe() {
        return altoe;
    }

    public void setAltoe(int altoe) {
        this.altoe = altoe;
    }

    public void run() {

        while (col) {
            int j = 5;

            try {
                altoe = dkey.getHeight(null) - 50;
                anchoe = dkey.getWidth(null) - 50;
                if (col == false) {
                    this.g.drawImage(death[18], this.x, this.y, null);
                }
                else{
                if (colision(this.x, this.y, this.altoe, this.anchoe, misteve.CoordX(), misteve.CoordY(), misteve.altos, misteve.anchos)) {

                } else {

                    if (colision(this.x, this.y, this.altoe, this.anchoe, powa.getX(), powa.getY(), powa.getAlto(), powa.getAncho())) {
                        for (int i = 1; i < 19; i++) {
                            this.g.drawImage(death[i], this.x, this.y, null);
                            Enemy.sleep(50);

                        }
                        this.x=-1000;
                        this.y=-1000;
                        col = false;
                    }
                    if (col) {

                        while (c <= 8) {
                            c++;
                        }
                        while (c > 0) {
                            c--;
                        }
                        if (this.x <= misteve.CoordX() && this.y <= misteve.CoordY()) {
                            this.x += j;
                            this.y += j;

                            this.g.drawImage(dkey, this.x, this.y, null);
                        }
                        if (this.x >= misteve.CoordX() && this.y >= misteve.CoordY()) {
                            this.x -= j;
                            this.y -= j;
                            this.g.drawImage(dkey, this.x, this.y, null);

                        }
                        if (this.x <= misteve.CoordX() && this.y >= misteve.CoordY()) {
                            this.x += j;
                            this.y -= j;
                            this.g.drawImage(dkey, this.x, this.y, null);

                        }
                        if (this.x >= misteve.CoordX() && this.y <= misteve.CoordY()) {
                            this.x -= j;
                            this.y += j;
                            this.g.drawImage(dkey, this.x, this.y, null);

                        }
                    }

                }
                }
                Enemy.sleep(50);

            } catch (InterruptedException ex) {
                Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean colision(int x1, int y1, int alto, int ancho, int x2, int y2, int alto2, int ancho2) {

        if ((x2 >= x1 && x2 <= (x1 + ancho)) && (y2 >= y1 && y2 <= (y1 + alto))) {
            return true;
        }
        if ((x2 + ancho >= x1 && x2 <= (x1 + ancho)) && (y2 + alto >= y1 && y2 <= (y1 + alto))) {
            return true;
        }
        if ((x2 >= x1 && x2 <= (x1 + ancho)) && (y2 + alto >= y1 && y2 <= (y1 + alto))) {
            return true;
        }
        if (((x2 + ancho2) >= x1 && (x2 + ancho2) <= x1 + ancho) && ((y2 + alto2) >= y1 && (y2 + alto2) < y1 + alto)) {
            return true;
        } else {
            return false;
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

import Powers.StevePower;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
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

    public Enemy(Steve steve) {
        super();
        this.misteve = steve;
        this.x = 0;
        this.y = 0;
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

    public void DrawEnemy(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = dkey.getHeight(null);
        int spriteWidth = dkey.getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);
        g2d.drawImage(dkey, affineTransform, null);

    }

    public void DrawDeath(Graphics g, int i) {
        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = dkey.getHeight(null);
        int spriteWidth = dkey.getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);   
            g2d.drawImage(death[i], affineTransform, null);
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

    public void perseguir() {
        int j = 8;

        try {
            altoe = dkey.getHeight(null) - 50;
            anchoe = dkey.getWidth(null) - 50;

            if (this.x <= misteve.CoordX() && this.y <= misteve.CoordY()) {
                this.x += j;
                this.y += j;

            }
            if (this.x >= misteve.CoordX() && this.y >= misteve.CoordY()) {
                this.x -= j;
                this.y -= j;

            }
            if (this.x <= misteve.CoordX() && this.y >= misteve.CoordY()) {
                this.x += j;
                this.y -= j;

            }
            if (this.x >= misteve.CoordX() && this.y <= misteve.CoordY()) {
                this.x -= j;
                this.y += j;

            }

            Enemy.sleep(50);

        } catch (InterruptedException ex) {
            Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {

    }

    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, dkey.getWidth(null), dkey.getHeight(null));
        return rect;
    }

}

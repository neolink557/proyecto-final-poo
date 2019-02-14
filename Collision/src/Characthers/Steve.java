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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.w3c.dom.css.Rect;

/**
 *
 * @author Braya
 */
public class Steve {

    int x, y;
    int change = 0;
    int lastkey = 83;
    int anchos;
    int altos;
    Image actual;
    StevePower powa;

    public Image getActual() {
        return actual;
    }

    public void setActual(Image setactual) {
        this.actual = setactual;
    }
    Image death = new ImageIcon(getClass().getResource("../resources/death/death.png")).getImage();

    public Image getDeath() {
        return death;
    }

    public void setDeath(Image death) {
        this.death = death;
    }
    Image[] skey = {new ImageIcon(getClass().getResource("../resources/Adelante/s1.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s2.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s3.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s4.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s5.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s6.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s7.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s8.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/Adelante/s9.png")).getImage()
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
    Image[] dkey = {new ImageIcon(getClass().getResource("../resources/al otro lado v/a1.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a2.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a3.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a4.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a5.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a6.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a7.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a8.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/al otro lado v/a9.png")).getImage()
    };
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

    public Image getDkey(int x) {
        return dkey[x];
    }

    public Image getAkey(int x) {
        return akey[x];
    }

    public Image getSkey(int x) {
        return skey[x];
    }

    public Image getWkey(int x) {
        return wkey[x];
    }

    public int getLastkey() {
        return lastkey;
    }

    public void setLastkey(int lastkey) {
        this.lastkey = lastkey;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }

    public Steve() {
        this.x = 0;
        this.y = 0;
    }

    public void DrawChar(Image image, Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = skey[1].getHeight(null);
        int spriteWidth = skey[1].getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);

        g2d.drawImage(skey[change], affineTransform, null);

        altos = image.getHeight(null);
        anchos = image.getWidth(null);
    }

    public void update(int c) {
        switch (c) {
            case 65:
                
                this.x -= 20;
                change++;
                if (change == 8) {
                    change = 0;
                }
                setLastkey(c);
                break;
            case 68:
                this.x += 20;
                change++;
                if (change == 8) {
                    change = 0;
                }
                setLastkey(c);
                break;
            case 83:
                this.y += 20;
                change++;
                if (change == 8) {
                    change = 0;
                }
                setLastkey(c);
                break;
            case 87:
                this.y -= 20;
                change++;
                if (change == 8) {
                    change = 0;
                }
                setLastkey(c);
                break;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAnchos() {
        return anchos;
    }

    public void setAnchos(int anchos) {
        this.anchos = anchos;
    }

    public int getAltos() {
        return altos;
    }

    public void setAltos(int altos) {
        this.altos = altos;
    }

    public int CoordX() {
        return this.x;
    }

    public int CoordY() {
        return this.y;
    }

    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, skey[1].getWidth(null), skey[1].getHeight(null));
        return rect;
    }
}

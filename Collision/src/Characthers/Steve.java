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

    public int i;
    int x, y, j = 0;
    int change = 0;
    int lastkey = 83;
    int anchos;
    int altos;
    int velocidad=20;
    Image actual;
    StevePower powa;
    Image steve[][] = new Image[5][9];

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

    public void llenarMatriz() {
        for (i = 0; i < 9; i++) {
            steve[0][i] = new ImageIcon(getClass().getResource("../resources/Adelante/s" + (i + 1) + ".png")).getImage();
            steve[1][i] = new ImageIcon(getClass().getResource("../resources/atras/w" + (i + 1) + ".png")).getImage();
            steve[2][i] = new ImageIcon(getClass().getResource("../resources/al otro lado v/a" + (i + 1) + ".png")).getImage();
            steve[3][i] = new ImageIcon(getClass().getResource("../resources/al lado/a" + (i + 1) + ".png")).getImage();
            steve[4][i] = new ImageIcon(getClass().getResource("../resources/death/death.png")).getImage();
        }
        i = 0;
    }

    public Image getDkey(int x) {
        return steve[2][x];
    }

    public Image getAkey(int x) {
        return steve[3][x];
    }

    public Image getWkey(int x) {
        return steve[1][x];
    }

    public Image getSkey(int x) {
        return steve[0][x];
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
        llenarMatriz();
    }

    public void DrawChar(Image image, Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = steve[0][1].getHeight(null);
        int spriteWidth = steve[0][1].getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);

        g2d.drawImage(steve[i][j], affineTransform, null);

        altos = image.getHeight(null);
        anchos = image.getWidth(null);
    }

    public void update(int c,boolean coli) {
        
        switch (c) {
            
            case 65:
                j++;
                
                if (j == 8) {
                    j = 0;
                }
                if (this.x == 180 || coli == true) {
                    this.x += velocidad*2;
                    i=4;
                } else {
                    i = 3;
                    this.x -= velocidad;
                }
                setLastkey(c);
                break;
            case 68:
                j++;
                if (j == 8) {
                    j = 0;
                }
                if (this.x == 1600 || coli == true) {
                    this.x -= velocidad*2;
                    i=4;
                } else {
                    this.x += velocidad;
                    i = 2;
                }
                setLastkey(c);
                break;
            case 83:
                i = 0;
                j++;
                if (j == 8) {
                    j = 0;
                }
                if (this.y == 760 || this.y == 780 || coli == true) {
                    this.y -= velocidad*2;
                    i=4;
                } else {
                    this.y += velocidad;
                    i = 0;
                }
                setLastkey(c);
                break;
            case 87:
                
                j++;
                if (j == 8) {
                    j = 0;
                }
                if (this.y == 0 || coli == true) {
                        this.y += velocidad*2;
                        i=4;
                } else {
                    this.y -=velocidad;
                    i = 1;
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
        rect = new Rectangle(x, y, steve[0][1].getWidth(null), steve[0][1].getHeight(null));
        return rect;
    }
}

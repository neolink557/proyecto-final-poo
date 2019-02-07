/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.w3c.dom.css.Rect;

/**
 *
 * @author Braya
 */
public class Steve {

    int x, y;
    int change;
    int lastkey = 83;
    int anchos;
    int altos;
    Image actual;

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
    JPanel MiJP;

    public Steve(JPanel miJ) {
        this.x = 0;
        this.y = 0;
        this.MiJP = miJ;
    }

    public void DrawChar(int xi, int yi, Image image) {

        this.x = xi;
        this.y = yi;

        MiJP.getGraphics().drawImage(image, xi, yi, null);
        altos = image.getHeight(null);
        anchos = image.getWidth(null);
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

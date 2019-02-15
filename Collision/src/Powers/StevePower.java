/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Powers;

import Characthers.Enemy;
import Characthers.Steve;
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
public class StevePower extends Thread {

    int x, y, key;
    Graphics g;
    String direct;
    int ancho, alto;
    Image imagen = new ImageIcon(getClass().getResource("../resources/powers/Stevepower.png")).getImage();
    boolean activated=false;

    public StevePower(int xi, int yi) {
        this.x = xi;
        this.y = yi;
    }

    public void drawPowa(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = imagen.getHeight(null);
        int spriteWidth = imagen.getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);

        g2d.drawImage(imagen, affineTransform, null);

        alto = imagen.getHeight(null);
        ancho = imagen.getWidth(null);
    }
    public void setKey(int key) {
        this.key = key;
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

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void update(int c,int x,int y) {
        switch (c) {
            case 69:
                this.x = x;
                this.y =y;
                activated=true;
                break;
            
        }
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void run() {

    }
public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }
}

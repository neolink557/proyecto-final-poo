/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Powers;

import Characthers.Enemy;
import Characthers.Steve;
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
public class StevePower extends Thread {

    int x, y, key;
    Steve misteve;
    JPanel miJP;
    Graphics g;
    String direct;
    Enemy enemy;
    int ancho, alto;
    Image imagen = new ImageIcon(getClass().getResource("../resources/powers/Stevepower.png")).getImage();

    public StevePower(JPanel miJ, int xi, int yi, Steve misteve, int key, Enemy enemy) {
        super();
        this.g = miJ.getGraphics();
        this.miJP = miJ;
        this.x = xi;
        this.y = yi;
        this.misteve = misteve;
        this.key = key;
        this.enemy = enemy;
        this.ancho = imagen.getWidth(null);
        this.alto = imagen.getHeight(null);
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

    public void run() {
        x = x + 100;
        y = y + 150;
        for (int j = 0; j < 10; j++) {

            try {

                switch (key) {
                    case 83:
                        y = y + j * 10;
                        g.drawImage(imagen, x, y, null);
                        StevePower.sleep(50);

                        break;
                    case 87:
                        y = y - j * 10;
                        g.drawImage(imagen, x, y, null);
                        StevePower.sleep(50);

                        break;
                    case 65:
                        x = x - j * 10;
                        g.drawImage(imagen, x, y, null);
                        StevePower.sleep(50);

                        break;
                    case 68:
                        x = x + j * 10;
                        g.drawImage(imagen, x, y, null);
                        StevePower.sleep(50);

                        break;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            this.x=-1000;
            this.y=-1000;
    }

}

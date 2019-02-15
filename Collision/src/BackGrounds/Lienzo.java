/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGrounds;

import Characthers.Enemy;
import Characthers.Steve;
import Powers.StevePower;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author estudiantes
 */
public class Lienzo extends JPanel implements KeyListener {

    int i, j;
    Steve steve;
    StevePower sp;
    Enemy enemy;
    Graphics miG;
    Graphics g;
    Image imgBuffer;
    BackGrounds bg;
    Timer timer;
    int col = 0;

    public Lienzo(Steve steve, Enemy enemy, StevePower powa) {
        bg = new BackGrounds();
        this.steve = steve;
        this.enemy = enemy;
        this.sp = powa;
        //this.enemy=enemy;
        timer = new Timer();
        setBounds(0, 0, 1920, 1080);
        imgBuffer = new BufferedImage(1920, 1080, BufferedImage.OPAQUE);
        timer.schedule(new Actualizador(), 0, 100);
    }

    public void paint(Graphics g) {
        this.g = g;
        miG = imgBuffer.getGraphics();
        bg.DrawBack(miG);
        sp.drawPowa(miG);
        if (sp.isActivated()) {
            j++;
            int h = steve.i;
            switch (h){
                case 0:
                    sp.setY(sp.getY() + 1 * (j * 30));
                    break;
                case 1:
                    sp.setY(sp.getY() - 1 * (j * 30));
                    break;
                case 2:
                    sp.setX(sp.getX() + 1 * (j * 30));
                    break;
                case 3:
                    sp.setX(sp.getX() - 1 * (j * 30));
                    break;
            }
            
            sp.drawPowa(miG);
            if (j == 5) {
                sp.setActivated(false);
                j = 0;
                sp.setX(-3000);
                sp.setY(-3000);
            }
        }
        if (collision()) {
            col = 1;
        }
        if (col == 1) {
            i++;
            enemy.DrawDeath(miG, i);
            System.out.println(i);
            if (i == 18) {
                i = 0;
                col = 2;
                enemy.setX(-2000);
                enemy.setY(-2000);
            }

        } else {
            if (col == 0) {
                enemy.DrawEnemy(miG);
                enemy.perseguir();
            }
        }
        steve.DrawChar(steve.getActual(), miG);
        g.drawImage(imgBuffer, 0, 0, this);
        //enemy.DrawEnemy(miG, enemy.getX(), enemy.getY());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        steve.update(e.getKeyCode());
        sp.update(e.getKeyCode(), steve.CoordX(), steve.CoordY() + 100);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean collision() {
        if (enemy.getRect().intersects(sp.getRect())) {
            return true;
        }
        if (enemy.getRect().intersects(steve.getRect())) {
            return true;
        } else {
            return false;
        }

    }

    private class Actualizador extends TimerTask {

        @Override
        public void run() {
            repaint();

        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGrounds;

import Characthers.Enemy;
import Characthers.Steve;
import ObjetosEscenario.Cama;
import ObjetosEscenario.Chimenea;
import ObjetosEscenario.Mesa;
import Powers.StevePower;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
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
    ArrayList<Enemy> enemigos;
    Graphics miG;
    Graphics g;
    Image imgBuffer;
    BackGrounds bg;
    Timer timer;
    int col = 0;
    Cama cama = new Cama();
    Mesa mesa = new Mesa();
    Chimenea chi = new Chimenea();
    boolean coli = false;

    public Lienzo(Steve steve, StevePower powa) {
        bg = new BackGrounds();
        this.steve = steve;
        this.sp = powa;
        enemigos = new ArrayList<Enemy>();

        for (int a = 0; a < 5; a++) {
            enemigos.add(new Enemy());
        }
        //this.enemy=enemy;
        timer = new Timer();
        setBounds(0, 0, 1920, 1080);
        imgBuffer = new BufferedImage(1920, 1080, BufferedImage.OPAQUE);
        timer.schedule(new Actualizador(), 0, 100);
    }

    public void paint(Graphics g) {
        this.g = g;

        miG = imgBuffer.getGraphics();
        
        if(steve.getRect().intersects(bg.getRect()))
        {
           bg.DrawBack(miG,1); 
        }
        else{
            bg.DrawBack(miG,0);
        }
        sp.drawPowa(miG);
        cama.DrawBack(miG);
        mesa.DrawBack(miG);

        if (sp.isActivated()) {
            j++;
            int h = steve.i;
            switch (h) {
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
                sp.setX(3000);
                sp.setY(3000);
            }
        }

        Iterator<Enemy> it = enemigos.iterator();

        while (it.hasNext()) {
            Enemy r = it.next();

            if (r.getRect().intersects(sp.getRect())) {
                r.setCol(1);
            }
            if(r.isCol()==1){
                r.setK(r.getK()+1);
                r.DrawDeath(miG, r.getK());
                if (r.getK() == 18) {
                    r.setX(-500);
                    r.setY(-500);
                    r.setCol(2);
                    r.setK(0);
                    break;
                }

                
            } else if (r.isCol() == 0) {
                r.DrawEnemy(miG);
                r.perseguir(steve);
            }
        }

        
        if (Stevecollision()) {
            steve.DrawChar(steve.getDeath(), miG);
        } else {
            
            steve.DrawChar(steve.getDeath(), miG);
        }

        g.drawImage(imgBuffer, 0, 0, this);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        coli = Stevecollision();

        steve.update(e.getKeyCode(), coli);
        sp.update(e.getKeyCode(), steve.CoordX(), steve.CoordY() + 100);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Stevecollision() {

        if (steve.getRect().intersects(cama.getRect())) {
            return true;
        }
        if (steve.getRect().intersects(mesa.getRect())) {
            return true;
        }
        Iterator<Enemy> it = enemigos.iterator();

        while (it.hasNext()) {
            Enemy r = it.next();
            r.perseguir(steve);
            if (r.getRect().intersects(steve.getRect())) {
                return true;
            }
        }

        return false;
    }

    private class Actualizador extends TimerTask {

        @Override
        public void run() {

            Iterator<Enemy> it = enemigos.iterator();

            while (it.hasNext()) {
                Enemy r = it.next();
                

            }
            repaint();
        }

    }
}

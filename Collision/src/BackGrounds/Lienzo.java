package BackGrounds;

import Characthers.Enemy;
import Characthers.Steve;
import ObjetosEscenario.Cama;
import ObjetosEscenario.Chimenea;
import ObjetosEscenario.Mesa;
import Powers.StevePower;
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

public class Lienzo extends JPanel implements KeyListener {

    private int i, j, h, k, m;
    private int muertes;
    private Steve steve;
    private StevePower sp;
    private ArrayList<Enemy> enemigos;
    private Graphics miG;
    private Graphics g;
    private Image imgBuffer;
    private BackGrounds bg;
    private Timer timer;
    private Cama cama = new Cama();
    private Mesa mesa = new Mesa();
    private Chimenea chi = new Chimenea();
    private boolean instadeath = false;
    private boolean cambioescenario = false;

    public Lienzo(Steve steve, StevePower powa) {
        bg = new BackGrounds();
        this.steve = steve;
        this.sp = powa;
        enemigos = new ArrayList<Enemy>();

        for (int a = 0; a < 3; a++) {
            enemigos.add(new Enemy());
        }

        timer = new Timer();
        setBounds(0, 0, 1920, 1080);
        imgBuffer = new BufferedImage(1920, 1080, BufferedImage.OPAQUE);
        timer.schedule(new Actualizador(), 0, 100);
    }

    public void paint(Graphics g) {
        this.g = g;

        miG = imgBuffer.getGraphics();
        System.out.println(muertes);

        if (muertes >= 3) {
            bg.DrawBack(miG, 1);

            if (steve.getRect().intersects(bg.getRect())) {
                cambioescenario = true;
            }

        }

        if (cambioescenario == true) {
            bg.DrawBack(miG, 2);
        }

        if (muertes < 3) {
            bg.DrawBack(miG, 0);
        }

        if (sp.isActivated2()) {
            k++;
            System.out.println(k);

            if (k == 6) {
                instadeath = true;
                sp.setActivated2(false);
                k = 0;
            }
            sp.DrawBack2(miG, k);

        }
        if (sp.isActivated()) {
            sp.DrawBack(miG);
        }

        if (cambioescenario) {

        } else {
            cama.DrawBack(miG);
            mesa.DrawBack(miG);
        }
        Collision();
        if (sp.isActivated()) {
            j++;
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

            sp.DrawBack(miG);
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
            if (r.isCol() == 2 || instadeath == true) {
                r.setK(r.getK() + 1);
                r.DrawDeath(miG, r.getK());
                if (r.getK() == 18) {
                    r.setX(-500);
                    r.setY(-500);
                    r.setCol(2);
                    r.setK(0);
                    muertes++;
                    break;
                }

            } else {
                r.DrawBack(miG);
                r.perseguir(steve);
                r.update(i, r.isCol());
            }
        }

        steve.DrawChar(steve.getActual(), miG);

        g.drawImage(imgBuffer, 0, 0, this);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        steve.update(e.getKeyCode(), steve.getCol());
        if (sp.isActivated()) {
            sp.perseguir(e.getKeyCode(), sp.getX(), sp.getY());
        } else {
            h = steve.getI();
            sp.perseguir(e.getKeyCode(), steve.CoordX(), steve.CoordY() + 100);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Collision() {
        Iterator<Enemy> it = enemigos.iterator();
        //enemigo escenario
        while (it.hasNext()) {
            Enemy r = it.next();

            if (r.getRect().intersects(cama.getRect())) {
                r.setCol(1);
                if (r.getX() <= 650) {
                    r.setX(r.getX() + 10);
                }

                if (r.getY() >= 580) {
                    r.setY(r.getY() - 10);
                }

            } else if (r.getRect().intersects(mesa.getRect())) {

                r.setCol(1);
                if (r.getX() >= 1320) {
                    r.setX(r.getX() - 10);
                }
                if (r.getX() <= 500) {
                    r.setY(r.getY() - 10);
                }

            }
        }
        //enemigo poder
        Iterator<Enemy> it2 = enemigos.iterator();
        while (it2.hasNext()) {
            Enemy r = it2.next();
            if (sp.getRect().intersects(r.getRect())) {
                r.setCol(2);
            }
        }

        //personaje escenario
        if (steve.getRect().intersects(cama.getRect())) {
            steve.setCol(4);
            if (steve.getLastkey() == 65) {
                steve.setX(650);
            }
            if (steve.getLastkey() == 83) {
                steve.setY(580);
            }

        } else if (steve.getRect().intersects(mesa.getRect())) {

            steve.setCol(4);
            if (steve.getLastkey() == 68) {
                steve.setX(1320);
            }
            if (steve.getLastkey() == 87) {
                steve.setY(500);
            }
        } else {
            steve.setCol(0);
        }

        if (steve.getRect().intersects(bg.getRect()) && cambioescenario==true) {
            steve.setX(1000);
            steve.setY(800);
        }

        //personaje enemigo
        Iterator<Enemy> it3 = enemigos.iterator();
        while (it3.hasNext()) {
            Enemy r = it3.next();
            if (steve.getRect().intersects(r.getRect())) {
                steve.setCol(3);

            }
        }
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

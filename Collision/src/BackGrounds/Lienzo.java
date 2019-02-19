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
import ObjetosEscenario.Arboles;

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
    private Arboles arboles = new Arboles();
    private Arboles arboles2 = new Arboles();
    private Arboles arboles3 = new Arboles();
    private Cama cama = new Cama();
    private Mesa mesa = new Mesa();
    private Chimenea chi = new Chimenea();
    private boolean instadeath = false;
    private boolean cambioescenario = false;
    private int escenario;
    private int numeroenemigos = 5;
    private int totalmuertes=0;
    private boolean generated = false;
    private Puntaje puntaje = new Puntaje();

    public Lienzo(Steve steve, StevePower powa) {
        bg = new BackGrounds();
        this.steve = steve;
        this.sp = powa;
        enemigos = new ArrayList<Enemy>();

        for (int a = 0; a < numeroenemigos; a++) {
            totalmuertes++;
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
         puntaje.setData("muertes: " + Integer.toString(muertes));
        
        if (muertes >= totalmuertes) {
            bg.DrawBack(miG, 1);
            if (steve.getRect().intersects(bg.getRect())) {
                cambioescenario = true;
                generated = true;

                steve.setX(1000);
                steve.setY(800);

            }

        }
        

        if (cambioescenario == true) {
            bg.DrawBack(miG, 2);
            mesa.setX(500);
            mesa.setY(600);
            mesa.DrawBack(miG);
            arboles.setX(0);
            arboles.setY(500);
            arboles2.setY(200);
            arboles2.setX(1500);
            arboles2.DrawBack(miG);
            arboles.DrawBack(miG);
            escenario = 2;
            if (generated) {
                for (int a = 0; a < numeroenemigos; a++) {
                    totalmuertes++;
                    enemigos.add(new Enemy());
                    Iterator<Enemy> it = enemigos.iterator();

        while (it.hasNext()) {
            Enemy r = it.next();

                    r.setVelocidad(2);
                }
                }
                generated = false;
            }
        }

        if (muertes < numeroenemigos) {
            escenario = 1;
            bg.DrawBack(miG, 0);
        }

        if (sp.isActivated2()) {
            k++;
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
        System.out.println("muertes: " + muertes);
        System.out.println("muertestotal: " + totalmuertes);

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
                    r.setCol(0);
                    it.remove();
                    muertes++;
                    if (it.hasNext() == false) {
                        instadeath = false;
                    }
                    break;
                }

            } else if (r.isCol() == 1) {
                r.DrawBack(miG);
                r.perseguir(steve);
                r.update(i, r.isCol());
            } else {
                r.DrawBack(miG);
                r.perseguir(steve);
                System.out.println(r.isCol());
                r.update(i, r.isCol());
            }
        }

        steve.DrawChar(steve.getActual(), miG);
        puntaje.DrawBack(miG);
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
            if (escenario == 1) {
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
            } else {
                if (r.getRect().intersects(arboles.getRect())) {
                    r.setCol(1);
                    switch (r.getLastkey()) {
                        case 65:
                            r.setY(r.getY() - 10);
                            break;
                        case 68:
                            r.setY(r.getY() - 10);
                            break;
                        case 83:
                            r.setY(r.getY() + 10);
                            break;
                        case 87:
                            r.setY(r.getY() - 10);
                            break;
                    }
                } else if (r.getRect().intersects(mesa.getRect())) {
                    r.setCol(1);
                    switch (r.getLastkey()) {
                        case 65:
                            r.setY(r.getY() - 10);
                            break;
                        case 68:
                            r.setY(r.getY() - 10);
                            break;
                        case 83:
                            r.setY(r.getY() + 10);
                            break;
                    }
                }else if (r.getRect().intersects(arboles2.getRect())) {
                    r.setCol(1);
                    switch (r.getLastkey()) {
                        case 65:
                            r.setY(r.getY() - 10);
                            break;
                        case 68:
                            r.setY(r.getY() - 10);
                            break;
                        case 83:
                            r.setY(r.getY() + 10);
                            break;
                        case 87:
                            r.setY(r.getY() - 10);
                            break;
                    }
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
        if (escenario == 1) {
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
                    steve.setY(mesa.getY() + mesa.getAlto() + 25);
                }
            } else {
                steve.setCol(0);
            }
        } else {
            if (steve.getRect().intersects(arboles.getRect())) {
                steve.setCol(4);
                switch (steve.getLastkey()) {
                    case 65:
                        steve.setX(arboles.getX() + arboles.getAncho() + 100);
                        break;
                    case 68:
                        steve.setX(arboles.getX() - arboles.getAncho() + 125);
                        break;
                    case 83:
                        steve.setY(arboles.getY() - arboles.getAlto() - 25);
                        break;
                    case 87:
                        steve.setY(arboles.getY() + arboles.getAlto() + 100);
                        break;
                }
            } else if (steve.getRect().intersects(mesa.getRect())) {
                steve.setCol(4);
                switch (steve.getLastkey()) {
                    case 65:
                        steve.setX(mesa.getX() + mesa.getAncho() + 50);
                        break;
                    case 68:
                        steve.setX(mesa.getX() - mesa.getAncho() + 50);
                        break;
                    case 83:
                        steve.setY(mesa.getY() - mesa.getAlto() +100);
                        break;
                }
            } else {
                steve.setCol(0);
            }
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
            repaint();
        }

    }
}

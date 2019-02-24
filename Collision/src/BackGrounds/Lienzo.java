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
import Sounds.BackSound;
import Sounds.Deade;
import Sounds.EnmnemyHit;
import Sounds.Laser;
import Sounds.MainDead;
import Sounds.MainHit;
import Sounds.Open;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Lienzo extends JPanel implements MouseListener,MouseMotionListener,KeyListener {

    private int i, j, h, k, m;
    private int muertes;
    private final Steve steve;
    private final StevePower sp;
    private final ArrayList<Enemy> enemigos;
    private Graphics miG;
    private Graphics g;
    private final Image imgBuffer;
    private final BackGrounds bg;
    private final Timer timer;
    private final Arboles arboles = new Arboles();
    private final Arboles arboles2 = new Arboles();
    private final Arboles arboles3 = new Arboles();
    private final Cama cama = new Cama();
    private final Mesa mesa = new Mesa();
    private final Chimenea chi = new Chimenea();
    private final boolean instadeath = false;
    private int cambioescenario = 0;
    private final int numeroenemigos = 5;
    private int totalmuertes = 0;
    private boolean generated = false;
    private final Puntaje puntaje = new Puntaje();
    private final Vida vida = new Vida();
    int oleada = 1;
    private final BackSound fondo = new BackSound();
    private final Laser laser = new Laser();
    private final EnmnemyHit eh = new EnmnemyHit();
    private final MainHit mh = new MainHit();
    private final Deade deade = new Deade();
    private final MainDead md = new MainDead();
    private final Open open = new Open();
    private boolean abierta = true;

    public Lienzo(Steve steve, StevePower powa) {
        bg = new BackGrounds();
        this.steve = steve;
        this.sp = powa;
        vida.update(i, i);
        enemigos = new ArrayList<Enemy>();
        fondo.start();

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

            if (oleada < 2) {
                generated = true;

            } else {

                generated = false;
            }

            bg.DrawBack(miG, 1);

            if (steve.getRect().intersects(bg.getRect())) {
                cambioescenario++;
                steve.setX(1000);
                steve.setY(800);

            }

        }
        if (abierta && muertes == 5) {
            open.run();
            abierta = false;
        } else if (muertes == 15 && totalmuertes == 15) {
            open.run();
            muertes++;
        }

        if (cambioescenario >= 1) {
            bg.DrawBack(miG, 2);
            mesa.setX(1500);
            mesa.setY(600);
            mesa.DrawBack(miG);
            arboles.setX(0);
            arboles.setY(500);
            arboles2.setY(0);
            arboles2.setX(1500);
            arboles2.DrawBack(miG);
            arboles.DrawBack(miG);

            if (generated) {

                for (int a = 0; a < numeroenemigos; a++) {
                    totalmuertes++;
                    enemigos.add(new Enemy());
                    Iterator<Enemy> it = enemigos.iterator();

                    while (it.hasNext()) {
                        Enemy r = it.next();
                        r.setVida(2);
                        r.setVelocidad(7);
                    }
                }
                generated = false;
                if (muertes == 10) {
                    oleada++;
                }
            }
        }

        if (muertes < numeroenemigos) {

            bg.DrawBack(miG, 0);
        }

        if (sp.isActivated()) {
            sp.DrawBack(miG);
        }

        Collision();
        if (sp.isActivated()) {

            j++;
            switch (h) {
                case 0:
                    sp.setY(sp.getY() + 1 * (j * 50));
                    steve.setI(6);
                    break;
                case 1:

                    sp.setY(sp.getY() - 1 * (j * 50));
                    steve.setI(7);
                    break;
                case 2:

                    sp.setX(sp.getX() + 1 * (j * 50));
                    steve.setI(8);
                    break;
                case 3:

                    sp.setX(sp.getX() - 1 * (j * 50));
                    steve.setI(9);
                    break;
                case 6:
                    sp.setY(sp.getY() + 1 * (j * 50));
                    steve.setI(6);
                    break;
                case 7:

                    sp.setY(sp.getY() - 1 * (j * 50));
                    steve.setI(7);
                    break;
                case 8:

                    sp.setX(sp.getX() + 1 * (j * 50));
                    steve.setI(8);
                    break;
                case 9:

                    sp.setX(sp.getX() - 1 * (j * 50));
                    steve.setI(9);
                    break;
            }

            sp.DrawBack(miG);
            if (j == 4) {
                sp.setActivated(false);
                j = 0;
                sp.setX(3000);
                sp.setY(3000);
            }
            steve.setJ(steve.getJ() + 2);
            if (steve.getJ() >= 8) {
                steve.setJ(0);
            }
        }

        Iterator<Enemy> it = enemigos.iterator();

        while (it.hasNext()) {
            Enemy r = it.next();

            if (r.isCol() == 2) {
                r.setK(r.getK() + 1);

                r.DrawDeath(miG, r.getK());
                if (r.getK() == 11) {
                    deade.run();
                }
                if (r.getK() == 18) {
                    r.setX(-500);
                    r.setY(-500);
                    r.setCol(2);
                    r.setK(0);
                    r.setCol(0);
                    it.remove();
                    muertes++;
                    break;
                }

            } else if (r.isCol() == 1) {
                r.DrawBack(miG);
                r.perseguir(steve);
                r.update(i, r.isCol());
            } else if (r.isCol() == 5) {
                r.DrawDeath(miG, 1);
                r.perseguir(steve);
                r.update(i, r.isCol());
            } else {
                r.DrawBack(miG);
                r.perseguir(steve);
                r.update(i, r.isCol());
            }
        }
        if (steve.getCol() == 3) {
            if (steve.getVida() <= 1) {
                vida.setI(0);

                md.run();

            } else {
                vida.setI(steve.getVida() - 1);
            }
        }

        steve.DrawChar(steve.getActual(), miG);
        puntaje.DrawBack(miG);
        vida.DrawBack(miG);

        g.drawImage(imgBuffer, 0, 0, this);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        steve.update(e.getKeyCode(), steve.getCol());

        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         

            laser.run();

        if (sp.isActivated()) {
            sp.perseguir(steve.getLastkey(), sp.getX(), sp.getY());
        } else {
            h = steve.getI();
            sp.perseguir(steve.getLastkey(), steve.CoordX(), steve.CoordY() + 100);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Collision() {
        Iterator<Enemy> it = enemigos.iterator();
        //enemigo escenario
        while (it.hasNext()) {
            Enemy r = it.next();
            if (cambioescenario == 0) {
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
                } else if (r.getRect().intersects(arboles2.getRect())) {
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
            if (r.getVida() <= 0) {
                r.setCol(2);
            } else if (sp.getRect().intersects(r.getRect())) {
                eh.run();
                r.setVida(r.getVida() - 1);
                r.setCol(5);
                switch (r.getLastkey()) {
                    case 65:
                        r.setX(r.getX() + 50);

                        break;
                    case 68:
                        r.setX(r.getX() - 50);

                        break;
                    case 83:
                        r.setY(r.getY() + 50);

                        break;
                    case 87:
                        r.setY(r.getY() - 50);

                        break;

                }

            } else {
                r.setCol(0);
            }

        }

        //personaje escenario
        if (cambioescenario == 0) {
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
                        steve.setY(mesa.getY() - mesa.getAlto() + 100);
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
                mh.run();
                steve.setCol(3);
                switch (steve.getLastkey()) {
                    case 65:
                        steve.setX(steve.CoordX() + 100);

                        break;
                    case 68:
                        steve.setX(steve.CoordX() - 100);

                        break;
                    case 83:
                        steve.setY(steve.CoordY() - 100);

                        break;
                    case 87:
                        steve.setY(steve.CoordY() + 100);

                        break;
                }

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

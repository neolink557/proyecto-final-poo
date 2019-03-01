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
import ObjetosEscenario.Mago;
import ObjetosEscenario.Rocas;
import ObjetosEscenario.Trofeo;
import ObjetosEscenario.WinTittle;
import Sounds.BackSound;
import Sounds.Sonidos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener, KeyListener, Resolucion {

    private int i, j, h, k, m;
    private int muertes; // cuantas muerte llevamos (contador)
    private final Steve steve;
    private final StevePower sp;
    private final ArrayList<Enemy> enemigos;
    private Graphics miG;//guardar las imagenes 
    private Graphics g;//contexto grafino de ESTE panel
    private final Image imgBuffer;
    private final BackGrounds bg;
    private final Timer timer;//actualizar imagenes cada X tiempo
    private final Arboles arboles = new Arboles();
    private final Arboles arboles2 = new Arboles();
    private final Arboles arboles3 = new Arboles();
    private final Cama cama = new Cama();
    private final Mesa mesa = new Mesa();
    private final Chimenea chi = new Chimenea();
    private int cambioescenario = 0;//cada vez que creuce puerta cambia
    private final int numeroenemigos = 6;//spawn de enemigos
    private int totalmuertes = 0;
    private boolean generated = false;//generar enemigos
    private final Puntaje puntaje = new Puntaje();
    private final Vida vida = new Vida();
    private int oleada = 1;
    private final BackSound fondo = new BackSound();//Sonido de fondo
    private final Sonidos clip = new Sonidos();
    private boolean abierta = true;//puerta para saber si pasa o no al siguiente escenario
    private final Rocas rocas = new Rocas();//Escenario final
    private final Mago mago = new Mago();
    private final Trofeo trofeo = new Trofeo();
    private final WinTittle wint = new WinTittle();
    private boolean sonar = true;

    public Lienzo(Steve steve, StevePower powa) {//deben ser lo mismo con los que inicia el juego
        bg = new BackGrounds();
        this.steve = steve;
        this.sp = powa;
        enemigos = new ArrayList<Enemy>();
        fondo.start();

        for (int a = 0; a < numeroenemigos; a++) {
            totalmuertes++;
            enemigos.add(new Enemy());
        }

        timer = new Timer();
        setBounds(0, 0, ancho, alto);
        imgBuffer = new BufferedImage(1920, 1080, BufferedImage.OPAQUE);//pinta todas las imagenes
        timer.schedule(new Actualizador(), 0, 100);//actualiza cada X tiempo
    }

    public void paint(Graphics g) {
        this.g = g;
        miG = imgBuffer.getGraphics();
        puntaje.setData("muertes: " + Integer.toString(muertes));//pinta muertes

        if (muertes >= totalmuertes) {//generar oleadas (4)

            if (oleada < 5) {
                generated = true;

            } else {

                generated = false;
            }

            bg.DrawBack(miG, 1);//mismo escenario con la puerta abierta

            if (steve.getRect().intersects(bg.getRect())) {//si cruza puerta cambia escenario
                cambioescenario++;
                abierta = false;
                steve.setX(1000);
                steve.setY(800);
            }
        }
        if (muertes == numeroenemigos * oleada && sonar == true) {//sonar una sola vez completando oleada
            sonar = false;
            clip.run(8);
            abierta = true;
        } else if ((numeroenemigos * 5) - 1 == muertes) {
            sonar = true;
        }

        if (cambioescenario == 1) {//Pone scenario (nieve)
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

            if (generated) {  //se generan nuevos enemigos en el nuevo scenario
                for (int a = 0; a < numeroenemigos; a++) {
                    totalmuertes++;
                    enemigos.add(new Enemy());
                    Iterator<Enemy> it = enemigos.iterator();

                    while (it.hasNext()) {// mientras siga teniendo enemigos setea vida y velocidad
                        Enemy r = it.next();
                        r.setVida(8);
                        r.setVelocidad(25);
                        if (steve.CoordX() - r.getX() < 0)//con esto se generan nuevamente alejados steve
                        {
                            r.setX(r.getX() + 150);
                        }
                        if (steve.CoordY() - r.getY() < 0) {
                            r.setY(r.getY() + 150);
                        }
                        if (steve.CoordX() - r.getX() > 0) {
                            r.setX(r.getX() - 150);
                        }
                        if (steve.CoordY() - r.getY() > 0) {
                            r.setY(r.getY() - 150);
                        }
                    }
                }
                generated = false;
                if (muertes % numeroenemigos == 0) {
                    oleada++;
                }
            }
        }
        if (cambioescenario >= 2) {//Escenario FINAL
            if (steve.isWin() == false) {
                trofeo.setI(380);
            }

            bg.DrawBack(miG, 3);//Dibuja escenario final con levitaciones
            if (rocas.getJ() <= 100) {
                rocas.setJ(rocas.getJ() + 1);
                rocas.setI(rocas.getI() + 1);
            }
            if (rocas.getJ() > 100) {
                rocas.setI(rocas.getI() - 1);
                rocas.setJ(rocas.getJ() + 1);
            }
            if (rocas.getJ() == 200) {
                rocas.setJ(0);
            }

            if (mago.getJ() <= 13) {
                mago.setJ(mago.getJ() + 1);
                mago.setI(mago.getI() + 1);
            }
            if (mago.getJ() > 13) {
                mago.setI(mago.getI() - 1);
                mago.setJ(mago.getJ() + 1);
            }
            if (mago.getJ() == 26) {
                mago.setJ(0);
            }

            rocas.DrawBack(miG);
            mago.DrawBack(miG);
            trofeo.DrawBack(miG);
        }

        if (muertes < numeroenemigos) {//cuando comienza juego

            bg.DrawBack(miG, 0);

        }

        if (sp.isActivated()) {//si se activa poder dibujelo
            sp.DrawBack(miG);
        }

        Collision();  //llama a collision 
        if (sp.isActivated()) {

            j++;
            switch (h) {
                case 0:
                    sp.perseguir();//sigue mouse
                    steve.setI(6);//imgen de steve atacando
                    break;
                case 1:

                    sp.perseguir();
                    steve.setI(7);
                    break;
                case 2:

                    sp.perseguir();
                    steve.setI(8);
                    break;
                case 3:

                    sp.perseguir();
                    steve.setI(9);
                    break;
                case 6:
                    sp.perseguir();
                    steve.setI(6);
                    break;
                case 7:

                    sp.perseguir();
                    steve.setI(7);
                    break;
                case 8:

                    sp.perseguir();
                    steve.setI(8);
                    break;
                case 9:

                    sp.perseguir();
                    steve.setI(9);
                    break;
            }

            sp.DrawBack(miG);//una vez se acava animacion desaparece poder
            if (j == 5) {
                sp.setActivated(false);
                j = 0;
                sp.setX(3000);
                sp.setY(3000);
            }
            steve.setJ(steve.getJ() + 2);//nuevamente steve se setea en posicion 0
            if (steve.getJ() >= 8) {
                steve.setJ(0);
            }
        }

        Iterator<Enemy> it = enemigos.iterator();//evaluar colisones de enemigos

        while (it.hasNext()) {
            Enemy r = it.next();

            if (r.isCol() == 2) {
                r.setK(r.getK() + 1);

                r.DrawDeath(miG, r.getK());//k sirve para guardar pos imagen muerte y votar sonido
                if (r.getK() == 11) {
                    clip.run(1);
                }
                if (r.getK() == 18) {//desaparecen enemigos
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
        if (steve.getCol() == 3) {//si le quitan vida resta vida
            if (steve.getVida() <= 1) {
                vida.setI(0);

                clip.run(5);

            } else {
                vida.setI(steve.getVida() - 1);
            }
        }

        steve.DrawChar(steve.getActual(), miG);//Dibuja
        puntaje.DrawBack(miG);
        vida.DrawBack(miG);
        if (steve.isWin() == true) {//Muestra imagen ganaste
            wint.DrawBack(miG);
        }
        Image tmp = imgBuffer.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        g.drawImage(tmp, 0, 0, this);

    }

    @Override
    public void keyPressed(KeyEvent e) {

        steve.update(e.getKeyCode(), steve.getCol());

        if (e.getKeyCode() == 27) {
            int option = JOptionPane.showConfirmDialog(null, "Seguro desea salir?", "warning", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {//cuando se detecteta tira poder
        h = steve.getI();
        clip.run(4);
        sp.setX1(e.getX());
        sp.setY1(e.getY());
        h = steve.getI();
        sp.setX(steve.CoordX());
        sp.setY(steve.CoordY());
        sp.perseguir();
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
                clip.run(2);
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
                        r.setY(r.getY() - 50);

                        break;
                    case 87:
                        r.setY(r.getY() + 50);

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
                clip.run(6);
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
        if (steve.getRect().intersects(trofeo.getRect())) {
            trofeo.setI(-3800);
            steve.setWin(true);
            clip.run(9);

        }

    }

    private class Actualizador extends TimerTask {//actualiza la imagen de todo el lienzo

        @Override
        public void run() {
            repaint();
        }

    }

    //SON OBTENIDOS DE LAS INFERFACES MouseListener,MouseMotionListener, KeyListener (POLIMORFISMO) - NO CUMPLEN FUNCION EN ESTA CLASE
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}

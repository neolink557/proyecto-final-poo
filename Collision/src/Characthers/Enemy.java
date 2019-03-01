package Characthers;

import BackGrounds.Resolucion;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;
import javax.swing.ImageIcon;

public class Enemy extends Thread implements CharacterColisionable, CharacterDibujable, Resolucion {

    private int i, x, y, k;
    private int velocidad = 300;
    private int vel = (ancho / velocidad);//cambia velocidad segun pantalla
    private int anchoe;//dimension imagen enemigos
    private int altoe;
    private int c = 1;
    private int v;
    private int col = 0;
    private final Image death[] = new Image[19];
    private final Image dkey = new ImageIcon(getClass().getResource("../resources/Enemies/s1.png")).getImage();
    private Steve misteve;
    private int vida = 2;
    private int lastkey;

    public Enemy() {
        super();
        Random r = new Random();
        this.x = 180 + r.nextInt(1400);
        this.y = r.nextInt(400);
        llenarMatriz_Enmy();
    }

    public void llenarMatriz_Enmy() {
        for (i = 0; i < 19; i++) {
            death[i] = new ImageIcon(getClass().getResource("../resources/Enemies/death" + (i + 1) + ".png")).getImage();
        }
    }

    @Override
    public void DrawBack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);
        g2d.drawImage(dkey, affineTransform, null);
        altoe = dkey.getHeight(null);
        anchoe = dkey.getWidth(null);
    }

    @Override
    public void DrawDeath(Graphics g, int i) {//entero i para mostrar posicion del array de la muerte
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);
        g2d.drawImage(death[i], affineTransform, null);

    }

    public void perseguir(Steve misteve) {//steve de la clase, con el steve que viene desde el inicio - perseguir a steve
        this.misteve = misteve;
    }

    @Override
    public Rectangle getRect() {//hitbox enemigo
        Rectangle rect = null;
        rect = new Rectangle(x, y, dkey.getWidth(null), dkey.getHeight(null));
        return rect;
    }

    @Override
    public void update(int c, int coli) {//iguala x y y hasta llegar a steve

        int x1 = misteve.CoordX();
        int y1 = misteve.CoordY();
        if (this.x <= x1) {
            if (x == x1) {

            } else {
                this.x += vel;
            }
            setLastkey(68);
        }
        if (this.x > x1) {
            if (x == x1) {

            } else {
                this.x -= vel;
            }
            setLastkey(65);
        }
        if (this.y <= y1) {
            if (y == y1) {

            } else {
                this.y += vel;
            }
            setLastkey(83);
        }
        if (this.y > y1) {
            if (y == y1) {

            } else {
                this.y -= vel;
            }
            setLastkey(87);
        }
    }

    //METODOS SETTERS AND GETTERS DE LA CLASE
    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setAnchoe(int anchoe) {
        this.anchoe = anchoe;
    }

    public int getAnchoe() {
        return anchoe;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int isCol() {
        return col;
    }

    public int getLastkey() {
        return lastkey;
    }

    public void setLastkey(int lastkey) {
        this.lastkey = lastkey;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

}

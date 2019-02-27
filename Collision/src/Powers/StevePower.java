package Powers;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

public class StevePower extends Thread implements CharacterDibujable, CharacterColisionable {

    private int x, y, i, x1, y1;
    private Graphics g;
    private int ancho, alto;
    private Image imagen = new ImageIcon(getClass().getResource("../resources/powers/Stevepower.png")).getImage();
    private Image imagen2[] = new Image[6];
    private boolean activated = false;
    private boolean activated2 = false;

    public StevePower(int xi, int yi) {
        this.x = xi;
        this.y = yi;

    }

    public void llenar() {
        for (i = 0; i < 6; i++) {
            imagen2[i] = new ImageIcon(getClass().getResource("../resources/powers/q" + (i + 1) + ".png")).getImage();
        }
    }

    @Override
    public void DrawBack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = imagen.getHeight(null);
        int spriteWidth = imagen.getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);

        g2d.drawImage(imagen, affineTransform, null);

        alto = imagen.getHeight(null);
        ancho = imagen.getWidth(null);
    }

    @Override//COMO HACERLE PARA SEGUIR USANDO POLIMORFISMO.....
    public void update(int c, int i) {

    }

    public void perseguir() {

        if (this.x <= x1 ) {
            if (x == x1) {

            }else {
                this.x += 50;
            }
        }
         if (this.x > x1 ) {
            if (x == x1) {

            }else {
                this.x -= 50;
            }
        }
        if (this.y <= y1 ) {
            if (y == y1) {

            }else {
                this.y += 50;
            }
        }
         if (this.y > y1 ) {
            if (y == y1) {

            }else {
                this.y -= 50;
            }
        } else {
            activated = false;
        }
        activated = true;

    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }

    //METODOS SETTERS Y GETTERS 
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

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAlto() {
        return alto;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isActivated() {
        return activated;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    //NO CUMPLE NINGUNA FUNCION EN ESTA CLASE
    @Override
    public void DrawDeath(Graphics g, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

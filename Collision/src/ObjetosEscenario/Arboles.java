package ObjetosEscenario;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Arboles implements CharacterColisionable, CharacterDibujable {

    private Image imagen = new ImageIcon(getClass().getResource("../resources/escenario/arbol.png")).getImage();
    private int x;
    private int y;
    private int alto = imagen.getHeight(null) - 200;
    private int ancho = imagen.getWidth(null) - 200;

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x + 100, y + 75, ancho, alto);
        return rect;
    }

    @Override
    public void DrawBack(Graphics g) {
        g.drawImage(imagen, x, y, null);
    }

    //METODOS SETTERS AND GETTERS
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

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    //SON OBTENIDOS DE LAS INFERFACES (POLIMORFISMO) - NO CUMPLEN FUNCION EN ESTA CLASE
    @Override
    public void update(int c, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DrawDeath(Graphics g, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

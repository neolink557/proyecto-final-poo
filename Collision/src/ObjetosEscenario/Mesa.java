package ObjetosEscenario;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Mesa implements CharacterColisionable, CharacterDibujable {

    private Image imagen = new ImageIcon(getClass().getResource("../resources/escenario/mesa.png")).getImage();
    private int x = 1450;
    private int y = 100;
    private int ancho = imagen.getWidth(null) - 50;
    private int alto = imagen.getHeight(null) - 50;

    @Override
    public void DrawBack(Graphics g) {
        g.drawImage(imagen, x - 50, y, null);

    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, ancho, alto);
        return rect;
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

    //SON OBTENIDOS DE LAS INFERFACES (POLIMORFISMO) - NO CUMPLEN FUNCION EN ESTA CLASE
    @Override
    public void update(int c, int i) {
    }

    @Override
    public void DrawDeath(Graphics g, int i) {
    }

}

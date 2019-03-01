package ObjetosEscenario;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Trofeo extends Thread implements CharacterColisionable, CharacterDibujable {

    private Image imagen = new ImageIcon(getClass().getResource("../resources/Enemies/trofeo.png")).getImage();
    private Graphics g;
    private int i = -3800;
    private int j = 0;

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(925, i, imagen.getWidth(null) / 2, imagen.getHeight(null) / 2);

        return rect;
    }

    @Override
    public void DrawBack(Graphics g) {
        this.g = g;
        g.drawImage(imagen, 925, i, null);
    }

    //METODOS SETTERS AND GETTERS
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
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

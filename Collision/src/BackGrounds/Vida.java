package BackGrounds;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Vida implements CharacterColisionable, CharacterDibujable {

    private Image vida[] = new Image[4];
    private int i = 3;

    @Override
    public void DrawBack(Graphics g) {

        vida[0] = new ImageIcon(getClass().getResource("../resources/vida/vida4.png")).getImage();
        vida[1] = new ImageIcon(getClass().getResource("../resources/vida/vida3.png")).getImage();
        vida[2] = new ImageIcon(getClass().getResource("../resources/vida/vida2.png")).getImage();
        vida[3] = new ImageIcon(getClass().getResource("../resources/vida/vida1.png")).getImage();
        g.drawImage(vida[i], 1500, 50, null);

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //SON OBTENIDOS DE LAS INFERFACES (POLIMORFISMO) - NO CUMPLEN FUNCION EN ESTA CLASE
    @Override
    public void update(int c, int i) {
    }

    @Override
    public void DrawDeath(Graphics g, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle getRect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

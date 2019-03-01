package BackGrounds;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Puntaje implements CharacterColisionable, CharacterDibujable {

    String data = new String();

    @Override
    public void DrawBack(Graphics g) {
        g.setFont(new Font("Helvetica", Font.PLAIN, 59));
        g.setColor(Color.red);
        g.drawString(data, 100, 70);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
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

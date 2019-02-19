/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGrounds;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Braya
 */
public class Puntaje implements CharacterColisionable, CharacterDibujable{

    String data = new String();

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

    @Override
    public void DrawBack(Graphics g) {
        g.setFont(new Font("Helvetica", Font.PLAIN, 59));
        g.setColor(Color.red);
        g.drawString(data, 100, 50);
        
        
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}

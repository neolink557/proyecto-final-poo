/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class MiCanvas extends Canvas{
    Personaje p = new Personaje();

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        p.draw(g);
    }

    public Personaje getP() {
        return p;
    }
    
    
    
}

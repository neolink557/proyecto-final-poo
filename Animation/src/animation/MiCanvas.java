/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class MiCanvas extends Canvas {

    Personaje p = new Personaje();

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics g) {

        p.draw(g);
    }

    public void update(Graphics g) {
        Image buffer;
        Graphics pantallaVirtual;
        
        buffer = createImage(1820, 980);

        pantallaVirtual = buffer.getGraphics();

        paint(pantallaVirtual);

        g.drawImage(buffer, 0, 0, 1820, 980, null);
    }

    public Personaje getP() {
        return p;
    }

}

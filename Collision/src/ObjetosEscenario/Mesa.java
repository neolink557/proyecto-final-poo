/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosEscenario;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Braya
 */
public class Mesa implements CharacterColisionable, CharacterDibujable {

    Image imagen = new ImageIcon(getClass().getResource("../resources/escenario/mesa.png")).getImage();

    @Override
    public void DrawBack(Graphics g) {
        g.drawImage(imagen, 1380, 150, null);

    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(1450, 100, imagen.getWidth(null) - 50, imagen.getHeight(null) - 50);

        return rect;
    }

    //NO CUMPLE NINGUNA FUNCION EN ESTA CLASE
    @Override
    public void update(int c, int i) {
    }
    //NO CUMPLE NINGUNA FUNCION EN ESTA CLASE
    @Override
    public void DrawDeath(Graphics g, int i) {
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosEscenario;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Braya
 */
public class Cama {
    Image imagen = new ImageIcon(getClass().getResource("../resources/escenario/cama.png")).getImage();
    
     public void DrawBack(Graphics g) {
        g.drawImage(imagen, 0, 1020, null);
    }
     
     public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(215, 1015-imagen.getHeight(null), imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }

}

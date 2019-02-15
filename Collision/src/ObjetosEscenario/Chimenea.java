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
public class Chimenea {
    Image imagen = new ImageIcon(getClass().getResource("../resources/escenario/chimenea.png")).getImage();
      
     public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(200, 400, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }
}

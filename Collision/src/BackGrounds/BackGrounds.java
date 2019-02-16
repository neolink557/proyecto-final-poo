package BackGrounds;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Braya
 */
public class BackGrounds {

    
    Image imagen[] = {new ImageIcon(getClass().getResource("../resources/escenario/fondo.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/escenario/fon3.png")).getImage()};


    public BackGrounds() {
        
    }

    public void DrawBack(Graphics g,int i) {
        
        g.drawImage(imagen[i], 0, 0, null);
  
    }
    
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(850, 40, 200, 150);
        return rect;
    }

}

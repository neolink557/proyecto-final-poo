/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGrounds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Braya
 */
public class Lienzo2 extends JPanel implements Resolucion {
     JButton b1;
        Image imagen = new ImageIcon(getClass().getResource("../resources/menu/menu.png")).getImage();
        
    public Lienzo2() {      
        imagen= imagen.getScaledInstance(ancho, alto, FRAMEBITS);
        setBounds(0, 0, ancho, alto);
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(imagen,0, 0, this);
    }
}

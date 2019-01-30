/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Powers;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Braya
 */
public class Powerdrawing {
    int x;
    int y;
    int change;
    JPanel MiJP;
    String dir ="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/powers/Stevepower.png";
    
    public Powerdrawing(JPanel miJ){
        this.x=0;
        this.y=0;
        this.MiJP=miJ;
        
    }
    
    public void DrawPow(Graphics g,int xi , int yi)
    {
        
        this.x=xi;
        this.y=yi;
        ImageIcon MiImagen=new ImageIcon(dir);
        g.drawImage(MiImagen.getImage(), xi, yi, MiJP);
        
        
    }
}

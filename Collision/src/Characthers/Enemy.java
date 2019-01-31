/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

import Powers.StevePower;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Braya
 */
public class Enemy extends Thread{
  int x,y,j;
    Steve misteve;
    StevePower powa;
    JPanel miJP;
    Graphics g;
    String direct="C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/al otro lado v/d1.png";
    boolean col=true;
    
    
    public Enemy(JPanel miJ,int xi, int yi,Steve misteve)
    {
        super();
        this.g=miJ.getGraphics();
        this.miJP=miJ;
        this.x=xi;
        this.y=yi;
        this.misteve=misteve;
    }

    public boolean isCol() {
        return col;
    }

    public void setCol(boolean col) {
        this.col = col;
    }
    public void DrawEnemy(Graphics g,int xi , int yi)
    {
        
        this.x=xi;
        this.y=yi;
        ImageIcon MiImagen=new ImageIcon(direct);
        g.drawImage(MiImagen.getImage(), xi, yi, miJP);
        
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void run()
    {
        j=1;
        while(true)
        {
            while(j <= 1200)
            {
                j=j+10;
                try {
                    
                    ImageIcon MiImagen=new ImageIcon("C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/al otro lado v/d1.png");
                    g.drawImage(MiImagen.getImage(), (x+100)+j, (y+150), miJP);
                    
                    Enemy.sleep(50);
                    this.miJP.update(g);
                    misteve.DrawChar(g, misteve.CoordX(), misteve.CoordY(), misteve.direccion());
                    System.out.println(j);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            while(j>0)
            {
                j=j-10;
                try {
                     
                    ImageIcon MiImagen=new ImageIcon("C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/al lado/a1.png");
                    g.drawImage(MiImagen.getImage(), (x+100)+j, (y+150), miJP);
                    
                    
                    Enemy.sleep(50);
                    this.miJP.update(g);
                    misteve.DrawChar(g, misteve.CoordX(), misteve.CoordY(), misteve.direccion());
                } catch (InterruptedException ex) {
                    Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    }
    }
    
}

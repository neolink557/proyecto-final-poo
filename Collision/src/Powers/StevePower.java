/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Powers;

import Characthers.Enemy;
import Characthers.Steve;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Braya
 */
public class StevePower extends Thread{
    int x,y,key;
    Steve misteve;
    JPanel miJP;
    Graphics g;
    String direct;
    Enemy enemy;
    
    public StevePower(JPanel miJ,int xi, int yi,Steve misteve,int key,Enemy enemy)
    {
        super();
        this.g=miJ.getGraphics();
        this.miJP=miJ;
        this.x=xi;
        this.y=yi;
        this.misteve=misteve;
        this.direct=misteve.direccion();
        this.key=key;
        this.enemy=enemy;
    }
    public void run()
    {
        
            for (int j = 0; j < 10; j++) {
                
                try {
                    
                    ImageIcon MiImagen=new ImageIcon("C:/Users/Braya/OneDrive/Documents/NetBeansProjects/Collision/src/resources/powers/Stevepower.png");
                    switch(key)
                    {
                        case 83:
                            g.drawImage(MiImagen.getImage(), (x+100), (y+150)+j*25, miJP);
                            StevePower.sleep(50);
                            this.miJP.update(g);
                            misteve.DrawChar(g, x, y, direct);
                            enemy.DrawEnemy(g, enemy.getX(), enemy.getY());
                           break;
                        case 87:
                            g.drawImage(MiImagen.getImage(), (x+100), (y+150)-j*25, miJP);
                            StevePower.sleep(50);
                            this.miJP.update(g);
                            misteve.DrawChar(g, x, y, direct);
                            enemy.DrawEnemy(g, enemy.getX(), enemy.getY());
                           break;
                        case 65:
                            g.drawImage(MiImagen.getImage(), x-j*25, (y+150), miJP);
                            StevePower.sleep(50);
                            this.miJP.update(g);
                            misteve.DrawChar(g, x, y, direct);
                            enemy.DrawEnemy(g, enemy.getX(), enemy.getY());
                           break;
                        case 68:
                            g.drawImage(MiImagen.getImage(), (x+100)+j*25, (y+150), miJP);
                            StevePower.sleep(50);
                            this.miJP.update(g);
                            misteve.DrawChar(g, x, y, direct);
                            enemy.DrawEnemy(g, enemy.getX(), enemy.getY());
                           break;
                    }
                    
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(StevePower.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    }
    
    
}

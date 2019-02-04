/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGrounds;

import Characthers.Enemy;
import Characthers.Steve;
import Powers.StevePower;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author estudiantes
 */
public class Refresh extends Thread{
    private JPanel jpn;
    Steve steve;
    Enemy enemy;
    StevePower sp;
    public Refresh(JPanel jpan,Enemy enemy,Steve steve,StevePower sp)
    {
        this.jpn=jpan;
       this.enemy = enemy;
       this.steve=steve;
       this.sp=sp;
    }
    public void run()
    {
        while(true)
        {
             steve.DrawChar(jpn.getGraphics(), steve.CoordX(), steve.CoordY(), steve.getActual());
            try {
                jpn.update(jpn.getGraphics());
                Refresh.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Braya
 */
public class Steve {
    int x;
    int y;
    int change;

    public void setChange(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }
    JPanel MiJP;
    JPanel MiJP2;
   public Steve(JPanel miJ){
        this.x=0;
        this.y=0;
        this.MiJP=miJ;
    }
    
    public void DrawChar(Graphics g,int xi , int yi,String Direccion)
    {
        
        this.x=xi;
        this.y=yi;
        ImageIcon MiImagen=new ImageIcon(Direccion);
        g.drawImage(MiImagen.getImage(), xi, yi, MiJP);
        this.MiJP.update(g);
        
    }
    
    public int CoordX(){
        return this.x;
    }
    
    public int CoordY(){
        return this.y;
    }
    

}

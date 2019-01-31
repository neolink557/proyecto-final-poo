package BackGrounds;

import java.awt.Graphics;
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

    JPanel MiJPB;

    public BackGrounds(JPanel miJ) {
        this.MiJPB = miJ;
    }

    public void DrawBack(Graphics g, String Direccion) {
        ImageIcon MiImagen = new ImageIcon(Direccion);
        g.drawImage(MiImagen.getImage(), 0, 0, MiJPB);
    }

}

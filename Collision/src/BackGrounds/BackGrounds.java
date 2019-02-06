package BackGrounds;

import java.awt.Graphics;
import java.awt.Image;
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
    Image imagen = new ImageIcon(getClass().getResource("../resources/powers/bg.jpg")).getImage();

    public BackGrounds(JPanel miJ) {
        this.MiJPB = miJ;
    }

    public void DrawBack() {
        MiJPB.getGraphics().drawImage(imagen, 0, 0, null);
    }

}

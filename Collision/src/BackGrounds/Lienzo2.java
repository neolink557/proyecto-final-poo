package BackGrounds;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Lienzo2 extends JPanel implements Resolucion {

    private Image imagen = new ImageIcon(getClass().getResource("../resources/menu/menu.png")).getImage();

    public Lienzo2() {
        imagen = imagen.getScaledInstance(ancho, alto, FRAMEBITS);// Se escala la imagen al tamaño de la pantalla que se use
        setBounds(0, 0, ancho, alto);//poner alto y alto de Jpanel, lo pone en su lugar
    }

    @Override
    public void paint(Graphics g) // dibujar la imagen en el Jpanel
    {
        g.drawImage(imagen, 0, 0, this);
    }
}

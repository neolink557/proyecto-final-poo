package ObjetosEscenario;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Cama implements CharacterColisionable, CharacterDibujable {

    private Image imagen = new ImageIcon(getClass().getResource("../resources/escenario/cama.png")).getImage();

    @Override
    public void DrawBack(Graphics g) {
        g.drawImage(imagen, 0, 1020, null);
    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(215, 1015 - imagen.getHeight(null), imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }

    
    //SON OBTENIDOS DE LAS INFERFACES (POLIMORFISMO) - NO CUMPLEN FUNCION EN ESTA CLASE
    @Override
    public void update(int c, int i) {
    }


    @Override
    public void DrawDeath(Graphics g, int i) {
    }
}

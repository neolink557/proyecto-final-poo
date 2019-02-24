package BackGrounds;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class BackGrounds {

    private Image imagen[] = {new ImageIcon(getClass().getResource("../resources/escenario/fondo.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/escenario/fon3.png")).getImage(),
        new ImageIcon(getClass().getResource("../resources/escenario/fonn.png")).getImage()};

    public BackGrounds() {
    }

    public void DrawBack(Graphics g, int i) {
        g.drawImage(imagen[i], 0, 0, null);

    }

    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(950, 10, 50, 100);
        return rect;
    }

}

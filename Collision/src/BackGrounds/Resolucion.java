package BackGrounds;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface Resolucion {

    Toolkit screen = Toolkit.getDefaultToolkit();
    Dimension screensize = screen.getScreenSize();
    final int alto = (int) (screensize.getHeight());
    final int ancho = (int) (screensize.getWidth());

}

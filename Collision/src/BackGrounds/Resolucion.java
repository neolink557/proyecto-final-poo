/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGrounds;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Braya
 */
public interface Resolucion {

    Toolkit screen = Toolkit.getDefaultToolkit();
    Dimension screensize = screen.getScreenSize();
    final int alto = (int) (screensize.getHeight());
    final int ancho = (int) (screensize.getWidth());
    
    
}

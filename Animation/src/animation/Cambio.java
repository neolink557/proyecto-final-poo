/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

/**
 *
 * @author Estudiantes
 */
public class Cambio {
  
    public int change(int x, int y, String g) {
        switch (g) {
            case "atras":
                if (y <= 0 ) {
                    y = y;
                } else {
                    y = y - x;
                }
                break;
                case "adelante":
                if (y >= 700 ) {
                    y = y;
                } else {
                    y = y + x;
                }
                break;
                case "izquierda":
                if (y <= -25 ) {
                    y = y;
                } else {
                    y = y - x;
                }
                break;
                case "derecha":
                if (y >= 1270 ) {
                    y = y;
                } else {
                    y = y + x;
                }
                break;
        }
        return y;

    }

}

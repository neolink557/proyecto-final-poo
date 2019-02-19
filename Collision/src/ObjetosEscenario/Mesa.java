/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosEscenario;

import Characthers.CharacterColisionable;
import Characthers.CharacterDibujable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Braya
 */
public class Mesa implements CharacterColisionable, CharacterDibujable {

    Image imagen = new ImageIcon(getClass().getResource("../resources/escenario/mesa.png")).getImage();
    int x = 1450;
    int y = 100;
    int ancho = imagen.getWidth(null) - 50;
    int alto = imagen.getHeight(null) - 50;

    @Override
    public void DrawBack(Graphics g) {
        g.drawImage(imagen, x - 50, y, null);
        

    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, ancho, alto);
        return rect;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    //NO CUMPLE NINGUNA FUNCION EN ESTA CLASE
    @Override
    public void update(int c, int i) {
    }

    //NO CUMPLE NINGUNA FUNCION EN ESTA CLASE
    @Override
    public void DrawDeath(Graphics g, int i) {
    }

}
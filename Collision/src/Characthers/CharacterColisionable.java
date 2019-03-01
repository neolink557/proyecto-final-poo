package Characthers;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface CharacterColisionable {

    public void update(int x, int y);//actualizar posicion del objeto

    public void DrawDeath(Graphics g, int i);//dibujar animacion de muerte

    public Rectangle getRect();//hitbox
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author estudiantes
 */
public interface CharacterColisionable {
  public void update(int c, int i);
  public void DrawDeath(Graphics g, int i);
  public  Rectangle getRect();
}

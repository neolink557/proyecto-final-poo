/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class Personaje {
    
    
    ArrayList<String> adelante = new ArrayList();
    ArrayList<String> atras = new ArrayList();
    ArrayList<String> izquierda = new ArrayList();
    ArrayList<String> derecha = new ArrayList();
    Dimension tamaño = Toolkit.getDefaultToolkit().getScreenSize();
    ArrayList<String> actual;
    Personaje2 p2 = new Personaje2();
    
    int velocidad = 5;
    int contador = 0;
    int x = 500;
    int y = 500;

    public Personaje() {
        adelante.add("/imagenes/s1.png");
        adelante.add("/imagenes/s2.png");
        adelante.add("/imagenes/s3.png");
        adelante.add("/imagenes/s4.png");
        adelante.add("/imagenes/s5.png");
        adelante.add("/imagenes/s6.png");
        adelante.add("/imagenes/s7.png");
        adelante.add("/imagenes/s8.png");
        adelante.add("/imagenes/s9.png");
        adelante.add("/imagenes/s10.png");

        atras.add("/imagenes/w1.png");
        atras.add("/imagenes/w2.png");
        atras.add("/imagenes/w3.png");
        atras.add("/imagenes/w4.png");
        atras.add("/imagenes/w5.png");
        atras.add("/imagenes/w6.png");
        atras.add("/imagenes/w7.png");
        atras.add("/imagenes/w8.png");
        atras.add("/imagenes/w9.png");

        izquierda.add("/imagenes/a1.png");
        izquierda.add("/imagenes/a2.png");
        izquierda.add("/imagenes/a3.png");
        izquierda.add("/imagenes/a4.png");
        izquierda.add("/imagenes/a5.png");
        izquierda.add("/imagenes/a6.png");
        izquierda.add("/imagenes/a7.png");
        izquierda.add("/imagenes/a8.png");
        izquierda.add("/imagenes/a9.png");
        izquierda.add("/imagenes/a10.png");

        derecha.add("/imagenes/d1.png");
        derecha.add("/imagenes/d2.png");
        derecha.add("/imagenes/d3.png");
        derecha.add("/imagenes/d4.png");
        derecha.add("/imagenes/d5.png");
        derecha.add("/imagenes/d6.png");
        derecha.add("/imagenes/d7.png");
        derecha.add("/imagenes/d8.png");
        derecha.add("/imagenes/d9.png");
        derecha.add("/imagenes/d10.png");

        this.actual = this.atras;
    }

    public void actualizar(char accion) {
  
        
        
        switch (accion) {
            case 'w':
                this.actual = this.atras;
                if(getbounds().intersects(p2.getbounds())==true)
                {
                    y=y;
                    System.out.println("si");
                }
                else{
                y = y - velocidad;
                }
                break;
            case 's':
                this.actual = this.adelante;
                if(getbounds().intersects(p2.getbounds())==true)
                {
                    y=y;
                    System.out.println("si");
                }
                else{
                      y = y + velocidad;
                }
              

                break;
            case 'a':
                this.actual = this.izquierda;
                if(getbounds().intersects(p2.getbounds())==true)
                {
                    x=x;
                    System.out.println("si");
                }
                else
                {
                x = x - velocidad;
                }

                break;
            case 'd':
                this.actual = this.derecha;
                if(getbounds().intersects(p2.getbounds())==true)
                {
                    x=x;
                    System.out.println("si");
                }
                else
                {
                x = x + velocidad;
                }

                break;
        }
        contador = contador + 1;
        contador = contador % 9;

        System.out.println(contador + "<-");
    }

   public Rectangle getbounds() {
        return new Rectangle(x, y, 200, 200);

    }

    public void draw(Graphics g) {
        g.drawImage(new javax.swing.ImageIcon(getClass().getResource(actual.get(contador))).getImage(), this.x, this.y, null);
    }
}

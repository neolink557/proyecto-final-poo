/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characthers;

/**
 *
 * @author estudiantes
 */
public class Character {
    public boolean colision(int x1, int y1, int alto, int ancho, int x2, int y2, int alto2, int ancho2) {

        int lado1a,lado2a;
     
        
        lado1a=x2+ancho2;
        lado1a=y2+alto2;
          
        if ((x2 >= x1 && x2 <= (x1 + ancho)) && (y2 >= y1 && y2 <= (y1 + alto))) {
            return true;
        } 
        if ((x2+ancho >= x1 && x2 <= (x1 + ancho)) && (y2+alto >= y1 && y2 <= (y1 + alto))) {
            return true;
        } 
        if ((x2 >= x1 && x2 <= (x1 + ancho)) && (y2+alto >= y1 && y2 <= (y1 + alto))) {
            return true;
        } 
        if (((x2+ancho2) >= x1 && (x2+ancho2) <= x1 + ancho) && ((y2+alto2) >= y1 && (y2+alto2) < y1 + alto)) {
            return true;
        }else {
            return false;
        }
        
    }
}

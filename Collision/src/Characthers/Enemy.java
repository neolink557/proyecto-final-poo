
package Characthers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;
import javax.swing.ImageIcon;



public class Enemy extends Thread implements CharacterColisionable, CharacterDibujable {

    private int i,x, y, velocidad=2,k;
    private int anchoe;
    private int altoe;
    private int c = 1;
    private int col = 0;
    private Image death[] = new Image[19];
    private Image dkey = new ImageIcon(getClass().getResource("../resources/Enemies/s1.png")).getImage();
    Steve misteve;
    private int lastkey;
    
    
    public Enemy() {
        super();
        Random r = new Random();
        this.x = 180+r.nextInt(1400);
        this.y = r.nextInt(760);
        llenarMatriz_Enmy();
    }
    
    public void llenarMatriz_Enmy(){
        for (i = 0; i < 19 ; i++){
            death[i]=new ImageIcon(getClass().getResource("../resources/Enemies/death"+(i+1)+".png")).getImage();
        }
    }
    
    @Override
    public void DrawBack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = dkey.getHeight(null);
        int spriteWidth = dkey.getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);
        g2d.drawImage(dkey, affineTransform, null);
       
    }

    @Override
    public void DrawDeath(Graphics g, int i) {
        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = dkey.getHeight(null);
        int spriteWidth = dkey.getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);   
            g2d.drawImage(death[i], affineTransform, null);
            
    }
    
    
    
    public void perseguir(Steve misteve) {
        this.misteve=misteve;
    }

    
    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, dkey.getWidth(null), dkey.getHeight(null));
        return rect;
    }

    @Override
    public void update(int c, int coli) {
        

            altoe = dkey.getHeight(null) - 50;
            anchoe = dkey.getWidth(null) - 50;
           
            if (this.x <= misteve.CoordX() && this.y <= misteve.CoordY()) {
                this.x += velocidad;
                this.y += velocidad;
                lastkey=68;

            }
            if (this.x >= misteve.CoordX() && this.y >= misteve.CoordY()) {
                this.x -= velocidad;
                this.y -= velocidad;
                lastkey=87;

            }
            if (this.x <= misteve.CoordX() && this.y >= misteve.CoordY()) {
                this.x += velocidad;
                this.y -= velocidad;
                lastkey=83;

            }
            if (this.x >= misteve.CoordX() && this.y <= misteve.CoordY()) {
                this.x -= velocidad;
                this.y += velocidad;
                lastkey=65;

            }
            
            
    }
    
    //METODOS SETTERS AND GETTERS DE LA CLASE
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setAnchoe(int anchoe) {
        this.anchoe = anchoe;
    }
    
    public int getAnchoe() {
        return anchoe;
    }

    public void setAltoe(int altoe) {
        this.altoe = altoe;
    }
    
    public int getAltoe() {
        return altoe;
    }

    public void setK(int k) {
        this.k = k;
    }
    
    public int getK() {
        return k;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    public int isCol() {
        return col;
    }

    public int getLastkey() {
        return lastkey;
    }

    public void setLastkey(int lastkey) {
        this.lastkey = lastkey;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
}

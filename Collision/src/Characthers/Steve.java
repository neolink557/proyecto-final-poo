
package Characthers;

import Powers.StevePower;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;


public class Steve implements CharacterColisionable {

    private int i;
    private int x, y, j = 0;
    private int change = 0;
    private int lastkey = 83;
    private int anchos;
    private int altos;
    private int col;
    private int velocidad=20;
    private Image steve[][] = new Image[6][9];
    private Image actual;
    private Image death = new ImageIcon(getClass().getResource("../resources/death/death.png")).getImage();

    public Steve() {
        this.x = 0;
        this.y = 0;
        llenarMatriz();
    }
    
    public void llenarMatriz() {
        for (i = 0; i < 9; i++) {
            steve[0][i] = new ImageIcon(getClass().getResource("../resources/Adelante/s" + (i + 1) + ".png")).getImage();
            steve[1][i] = new ImageIcon(getClass().getResource("../resources/atras/w" + (i + 1) + ".png")).getImage();
            steve[2][i] = new ImageIcon(getClass().getResource("../resources/al otro lado v/a" + (i + 1) + ".png")).getImage();
            steve[3][i] = new ImageIcon(getClass().getResource("../resources/al lado/a" + (i + 1) + ".png")).getImage();
            steve[4][i] = new ImageIcon(getClass().getResource("../resources/death/death.png")).getImage();
            steve[5][i]= new ImageIcon(getClass().getResource("../resources/Adelante/s10.png")).getImage();
        }
        i = 0;
    }

    public void DrawChar(Image image, Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = steve[0][1].getHeight(null);
        int spriteWidth = steve[0][1].getWidth(null);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);

        g2d.drawImage(steve[i][j], affineTransform, null);

        altos = image.getHeight(null);
        anchos = image.getWidth(null);
    }
    
   
    @Override
    public void update(int c,int coli) {
        if(coli ==  3)
        {
            i=4;
            j=4;
        }else{
        switch (c) {
            
            case 65:
                j++;
                if (j == 8) {
                    j = 0;
                }
                if (this.x == 180 || coli == 4) {

                } else {
                    i = 3;
                    this.x -= velocidad;
                }
                setLastkey(c);
                break;
            case 68:
                j++;
                if (j == 8) {
                    j = 0;
                }
                if (this.x == 1600 || coli == 4) {

                } else {
                    this.x += velocidad;
                    i = 2;
                }
                setLastkey(c);
                break;
            case 83:
                i = 0;
                j++;
                if (j == 8) {
                    j = 0;
                }
                if (this.y == 760 || this.y == 780 || coli == 4) {

                } else {
                    this.y += velocidad;
                    i = 0;
                }
                setLastkey(c);
                break;
            case 87:
                j++;
                if (j == 8) {
                    j = 0;
                }
                if (this.y <= 0 || coli == 4) {

                } else {
                    this.y -=velocidad;
                    i = 1;
                }
                setLastkey(c);
                break;
            case 81:
                      i=5;
                setLastkey(c);
                break;
        }
        }        
    }
    
    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, steve[0][1].getWidth(null)-20, steve[0][1].getHeight(null));
        return rect;
    }
    
    
    //METODOS SETTERS AND GETTERS
    
    public Image getDkey(int x) {
        return steve[2][x];
    }

    public Image getAkey(int x) {
        return steve[3][x];
    }

    public Image getWkey(int x) {
        return steve[1][x];
    }

    public Image getSkey(int x) {
        return steve[0][x];
    }

    public void setLastkey(int lastkey) {
        this.lastkey = lastkey;
    }
    
    public int getLastkey() {
        return lastkey;
    }
    
    public void setChange(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setAnchos(int anchos) {
        this.anchos = anchos;
    }
    
    public int getAnchos() {
        return anchos;
    }
    
    public void setAltos(int altos) {
        this.altos = altos;
    }
    
    public int getAltos() {
        return altos;
    }

    public int CoordX() {
        return this.x;
    }

    public int CoordY() {
        return this.y;
    }
    
    public void setActual(Image setactual) {
        this.actual = setactual;
    }
    
    public Image getActual() {
        return actual;
    }
   
    public void setDeath(Image death) {
        this.death = death;
    }
    
    public Image getDeath() {
        return death;
    }

    public int getI() {
        return i;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Image getSteve(int i, int j) {
        return steve[i][j];
    }

   
    
    
    

    //NO REALIZA NINGUNCA FUNCION EN ESTA CLASE
    @Override
    public void DrawDeath(Graphics g, int i) {
    }

}

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
    private int velocidad = 30;
    private Image steve[][] = new Image[10][9];
    private Image actual;
    private int vida = 3;
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
            steve[5][i] = new ImageIcon(getClass().getResource("../resources/daño/d" + (i + 1) + ".png")).getImage();
            steve[6][i] = new ImageIcon(getClass().getResource("../resources/hits/c" + (i + 1) + ".png")).getImage();
            steve[7][i] = new ImageIcon(getClass().getResource("../resources/hitw/c" + (i + 1) + ".png")).getImage();
            steve[8][i] = new ImageIcon(getClass().getResource("../resources/hitd/c" + (i + 1) + ".png")).getImage();
            steve[9][i] = new ImageIcon(getClass().getResource("../resources/hita/c" + (i + 1) + ".png")).getImage();
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
        if (col == 3) {

                i = 5;
                switch (lastkey) {
                    case 65:
                        j = 2;
                        break;
                    case 68:
                        j = 3;
                        break;
                    case 83:
                        j = 4;
                        break;
                    case 87:
                        j = 1;
                        break;
                }
                vida--;
                col=0;
                
            } 
    }

    @Override
    public void update(int c, int coli) {
        if (vida <= 0) {
            i = 4;
            j = 4;

        } else {
            
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
                            this.y -= velocidad;
                            i = 1;
                        }
                        setLastkey(c);
                        break;
                    case 69:
                        
                    break;
                
            }
        }
    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(x, y, steve[0][1].getWidth(null) - 20, steve[0][1].getHeight(null));
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    public void setI(int j) {
        this.i = j;
    }

    //NO REALIZA NINGUNCA FUNCION EN ESTA CLASE
    @Override
    public void DrawDeath(Graphics g, int i) {
    }

}

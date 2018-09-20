/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;
import java.util.Random;
/**
 *
 * @author Braya
 */
public class Change {
    private int i;
    private boolean t,s;
    private int contador;
    private Random r = new Random();
    int x;
  
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean getT() {
        return t;
    }

    public void setT(boolean t) {
        this.t = t;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void Cambio(int y)
    {
        
        if(this.i < y && this.t == true)
            {
                this.i=this.i+1;
                
            }
            else
            {
               this.t=false;
            }
            if(this.i <= y && this.t== false && this.i>0)
            {
                this.i=this.i-1;
            }
            else
            {
                this.t=true;
            }
    }
    public boolean Parpadear()
    {
        x=r.nextInt(2);
        System.out.println(x);
        if((this.contador%30)==0 && x==1)
        {
            
            return true;
        }
        else
        {
            return false;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sounds;

import java.applet.AudioClip;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Braya
 */
public class Win1 {

    AudioClip sonido;
    int x;

    public Win1() {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/win.wav"));

    }

    public void run() {


            sonido.play();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

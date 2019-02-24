/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sounds;

import java.applet.AudioClip;

/**
 *
 * @author Braya
 */
public class BackSound extends Thread{
    AudioClip sonido;

    public BackSound() {
        sonido=java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/fondo.wav"));
        
    }
        
    @Override
    public void run() {
        
        sonido.play();
    }
}

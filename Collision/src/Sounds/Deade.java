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
public class Deade {

    AudioClip sonido;


    public Deade() {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/dead.wav"));

    }

    public void run() {


            sonido.play();

    }


}

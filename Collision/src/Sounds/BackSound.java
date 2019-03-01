package Sounds;

import java.applet.AudioClip;

public class BackSound extends Thread {

    AudioClip sonido;

    public BackSound() {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/fondo.wav"));
    }

    @Override
    public void run() {
        sonido.play();
    }
}

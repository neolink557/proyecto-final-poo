package Sounds;

import java.applet.AudioClip;

public class Sonidos {

    AudioClip[] clip = new AudioClip[10];

    public Sonidos() {

        clip[0] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/on.wav"));
        clip[1] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/dead.wav"));
        clip[2] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/enemyhit.wav"));
        clip[3] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/grito.wav"));
        clip[4] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/Laser.wav"));
        clip[5] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/maindead.wav"));
        clip[6] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/mainhit.wav"));
        clip[7] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/click.wav"));
        clip[8] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/open.wav"));
        clip[9] = java.applet.Applet.newAudioClip(getClass().getResource("../resources/sound/win.wav"));
    }

    public void run(int i) {
        clip[i].play();
    }
}

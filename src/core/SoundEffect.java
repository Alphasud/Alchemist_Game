package core;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class SoundEffect {

    Clip clip;

    public void setFile(String soundFileName) {

        try {
            File click = new File(soundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(click);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {

        }
    }

    public void play() {

        clip.setFramePosition(0);
        clip.start();
    }
}

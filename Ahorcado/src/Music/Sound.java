package Music;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Sound implements Runnable {

    private File soundFile;
    private Clip clip;
    private Runnable play;

    public Sound(File soundFile) {
        this.soundFile = soundFile;
    }

    public Sound() {
        soundFile = new File("../Ahorcado/src/Music/sound.wav");

        new Thread(play).start();

    }

    public void prepare() {

        try {
            AudioInputStream soundIn = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    AudioSystem.NOT_SPECIFIED,
                    16, 2, 4,
                    AudioSystem.NOT_SPECIFIED, true);
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            clip = (Clip) AudioSystem.getLine(info);
            clip.open(soundIn);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void run() {

    }

    public void play() {
        prepare();
        clip.start();
        while (clip.isRunning()) {
            Thread.yield();
        }

    }

    public void stop() {
        clip.stop();
    }
}

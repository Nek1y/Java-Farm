package Core;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MusicManager {
    public static ArrayList<Clip> Sounds = new ArrayList<>();
    public static final byte AMBIENT = 0;
    public static final byte HAND = 1;
    public static final byte SHOVEL= 2;
    public static final byte PLANT_BAG = 3;
    public static final byte WATER_POT = 4;
    public static final byte FAIL = 5;

    private static Clip soundLoad(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Clip clip = null;
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }

    public static void load() {
        try {
            Sounds.add(AMBIENT, soundLoad(new File("resource/Music/ambient.wav")));
            Sounds.add(HAND, soundLoad(new File("resource/Music/success.wav")));
            Sounds.add(SHOVEL, soundLoad(new File("resource/Music/shovel.wav")));
            Sounds.add(PLANT_BAG, soundLoad(new File("resource/Music/seeds.wav")));
            Sounds.add(WATER_POT, soundLoad(new File("resource/Music/water.wav")));
            Sounds.add(FAIL, soundLoad(new File("resource/Music/fail.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void soundPlay(byte ID){
        Clip clip = Sounds.get(ID);
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public static void soundAmbient(byte ID){
        Clip clip = Sounds.get(ID);
        clip.stop();
        clip.setFramePosition(0);
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(volume.getValue() - 16);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}

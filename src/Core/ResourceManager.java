package Core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ResourceManager {
    public static ArrayList<BufferedImage> Sprites = new ArrayList<>();
    //Array for sounds

    public static final byte GROUND = 0;
    public static final byte GARDEN = 1;
    public static final byte GARDEN_PLANT_PURPLE = 2;
    public static final byte GARDEN_PLANT_BLUE = 3;
    public static final byte GARDEN_PLANT_GREEN = 4;
    public static final byte GARDEN_WATER_PURPLE = 5;
    public static final byte GARDEN_WATER_BLUE = 6;
    public static final byte GARDEN_WATER_GREEN = 7;
    public static final byte GARDEN_READY_PURPLE = 8;
    public static final byte GARDEN_READY_BLUE = 9;
    public static final byte GARDEN_READY_GREEN = 10;
    public static final byte PLAYER = 11;
    public static final byte HAND = 12;
    public static final byte SHOVEL = 12;
    public static final byte WATER_POT = 13;
    public static final byte PLANT_PURPLE = 14;
    public static final byte PLANT_BLUE = 15;
    public static final byte PLANT_GREEN = 16;


    //add load music
    public static void load() {
        try{
            Sprites.add(GROUND, ImageIO.read(new File("resource/Sprite/ground.png")));
            Sprites.add(GARDEN, ImageIO.read(new File("resource/Sprite/garden1.png")));
            Sprites.add(GARDEN_PLANT_PURPLE, ImageIO.read(new File("resource/Sprite/garden2-1.png")));
            Sprites.add(GARDEN_PLANT_BLUE, ImageIO.read(new File("resource/Sprite/garden2-2.png")));
            Sprites.add(GARDEN_PLANT_GREEN, ImageIO.read(new File("resource/Sprite/garden2-3.png")));
            Sprites.add(GARDEN_WATER_PURPLE, ImageIO.read(new File("resource/Sprite/garden3-1.png")));
            Sprites.add(GARDEN_WATER_BLUE, ImageIO.read(new File("resource/Sprite/garden3-2.png")));
            Sprites.add(GARDEN_WATER_GREEN, ImageIO.read(new File("resource/Sprite/garden3-3.png")));
            Sprites.add(GARDEN_READY_PURPLE, ImageIO.read(new File("resource/Sprite/garden4-1.png")));
            Sprites.add(GARDEN_READY_BLUE, ImageIO.read(new File("resource/Sprite/garden4-2.png")));
            Sprites.add(GARDEN_READY_GREEN, ImageIO.read(new File("resource/Sprite/garden4-3.png")));
            Sprites.add(PLAYER, ImageIO.read(new File("resource/Sprite/player.png")));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}

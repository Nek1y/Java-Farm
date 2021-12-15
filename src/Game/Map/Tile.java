package Game.Map;

import Core.ResourceManager;
import Game.Builds.Building;
import Game.Builds.Garden;
import Game.Player.Player;

import java.awt.*;

public class Tile extends Rectangle {
    public static final int size = 64;
    private Building building;
    private byte SpriteID;

    public Tile(byte id, int posX, int posY){
        super(posX*size, posY*size, size, size);
        SpriteID = id;
        building = null;
    }

    public void Act(Player player){
        String toolName = player.getTool().name();
        if(building == null){
            if(toolName.equals("SHOVEL")){
                building = new Garden(this);
            }
        }
        else building.act(player);
    }

    public void buildProc(){
        if(building != null){
            building.buildProc();
        }
    }

    public void setID(byte id){
        SpriteID = id;
    }

    public int getID(){
        return SpriteID;
    }

    public void render(Graphics graphics){
        graphics.drawImage(ResourceManager.Sprites.get(SpriteID), super.x, super.y, super.width, super.height, null);
    }

}

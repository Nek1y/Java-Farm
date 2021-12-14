package Game.Player;

import java.awt.*;

import Core.ResourceManager;
import Game.Map.Tile;

public class Player extends Rectangle {

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int speed;
    private int score;
    private byte SpriteID;

    public enum Tool{
        HAND,
        SHOVEL,
        PLANT_BAG,
        WATER_POT,
    }

    private Tool tool;
   private Plant plant;

    public Player(int xPos, int yPos){
        super(xPos*Tile.size, yPos*Tile.size, Tile.size, Tile.size);
        up = false;
        down = false;
        left = false;
        right = false;
        speed = 8;
        score = 0;
        SpriteID = ResourceManager.PLAYER;
        tool = Tool.HAND;
    }

    public void addScore(int am){
        score += am;
    }

    public int getScore(){
        return score;
    }


    public void move() {
        if(up) {
            super.y-=this.speed;
        }
        if(down) {
            super.y+=this.speed;
        }
        if(left) {
            super.x-=this.speed;
        }
        if(right) {
            super.x+=this.speed;
        }

    }

    public void setMovingUp(boolean up) {
        this.up = up;
    }

    public void setMovingDown(boolean down) {
        this.down = down;
    }

    public void setMovingLeft(boolean left) {
        this.left = left;
    }

    public void setMovingRight(boolean right) {
        this.right = right;
    }

    public Tool getTool(){
        return tool;
    }



    public void switchTool(){
        Tool[] tools = Tool.values();
        int ind = tool.ordinal();
        if(ind == tools.length-1) tool = tools[0];
        else tool = tools[ind+1];
    }


    //NEED
    public void switchPlant(){
        return;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(ResourceManager.Sprites.get(SpriteID), super.x, super.y, super.width, super.height, null);
    }



}

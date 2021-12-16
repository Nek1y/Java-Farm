package Game.Player;

import java.awt.*;
import java.util.ArrayList;

import Core.ResourceManager;
import Game.Map.Tile;
import Game.Plants.*;

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
    private ArrayList<Plant> plant_list;
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
        plant_list = new ArrayList<>();
        plant_list.add(new PurplePlant());
        plant_list.add(new BluePlant());
        plant_list.add(new GreenPlant());
        plant = plant_list.get(0);
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

    public byte getToolID(){
        byte id = ResourceManager.HAND;
        switch (tool){
            case HAND:
                id = ResourceManager.HAND;
                break;
            case SHOVEL:
                id = ResourceManager.SHOVEL;
                break;
            case PLANT_BAG:
                id = ResourceManager.PLANT_BAG;
                break;
            case WATER_POT:
                id = ResourceManager.WATER_POT;
                break;
        }
        return id;
    }

    public Plant getPlant(){ return plant; }

    public void switchTool(){
        Tool[] tools = Tool.values();
        int ind = tool.ordinal();
        if(ind == tools.length-1) tool = tools[0];
        else tool = tools[ind+1];
    }

    public void switchPlant(){
        int id = plant_list.indexOf(plant);
        if(id == plant_list.size()-1) id = 0;
        else id++;
        plant = plant_list.get(id);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(ResourceManager.Sprites.get(SpriteID), super.x, super.y, super.width, super.height, null);
    }

}

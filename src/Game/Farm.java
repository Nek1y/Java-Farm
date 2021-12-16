package Game;

import Core.GameManager;
import Core.ResourceManager;
import Game.Map.*;
import Game.Player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Farm extends GameManager {

    private Map map;
    private Player player;

    public Farm(){
        int width = 10;
        int height = 10;
        map = new Map(width, height);
        player = new Player(width/2, height/2);
    }


    @Override
    protected void loop() {
        player.move();
        map.buildingProcess();
    }

    @Override
    protected void render(Graphics graphics) {
        map.render(graphics);
        player.render(graphics);
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("arial", Font.BOLD, 32));
        graphics.drawString(player.getScore()+"", map.getWidth()/2*Tile.size, Tile.size/2);
        graphics.drawImage(ResourceManager.Sprites.get(player.getPlant().getUI()), 96, 32,Tile.size, Tile.size, null);
        graphics.drawImage(ResourceManager.Sprites.get(player.getToolID()), 16, 32,Tile.size, Tile.size, null);
    }

    @Override
    protected void keyPressed(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_W:
                player.setMovingUp(true);
                break;
            case KeyEvent.VK_A:
                player.setMovingLeft(true);
                break;
            case KeyEvent.VK_S:
                player.setMovingDown(true);
                break;
            case KeyEvent.VK_D:
                player.setMovingRight(true);
                break;
            case KeyEvent.VK_E:
                playerAct();
                break;
            case KeyEvent.VK_Q:
                player.switchTool();
                break;
            case KeyEvent.VK_R:
                player.switchPlant();
                break;
        }
    }

    @Override
    protected void keyReleased(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_W:
                player.setMovingUp(false);
                break;
            case KeyEvent.VK_A:
                player.setMovingLeft(false);
                break;
            case KeyEvent.VK_S:
                player.setMovingDown(false);
                break;
            case KeyEvent.VK_D:
                player.setMovingRight(false);
                break;
        }
    }

    public void playerAct(){
        int xPos = (player.x+Tile.size/2)/Tile.size;
        int yPos = (player.y+Tile.size)/Tile.size;
        map.getTile(xPos, yPos).Act(player);
    }

}

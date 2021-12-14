package Game.Map;

import Core.ResourceManager;

import java.awt.*;

public class Map {

    private int Width;
    private int Height;
    private Tile[][] tiles;

    public Map(int w, int h){
        Width = w;
        Height = h;
        tiles = new Tile[w][h];
        for(int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                tiles[i][j] = new Tile(ResourceManager.GROUND, i, j);
            }
        }
    }

    public void render(Graphics graphics){
        for(int i = 0; i < Width; i++){
            for(int j = 0; j < Height; j++){
                tiles[i][j].render(graphics);
            }
        }
    }

    public Tile getTile(int i, int j){
        return tiles[i][j];
    }

    public void buildingProcess(){
        for(int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                tiles[i][j].buildProc();
            }
        }
    }
}

package Game.Builds;

import Core.MusicManager;
import Core.ResourceManager;
import Game.Farm;
import Game.Map.Tile;
import Game.Plants.Plant;
import Game.Player.Player;

public class Garden extends Building{
    private Plant plant;
    private Tile tile;
    private State state;
    private int procTime;

    public enum State{
        START,
        PREPARED,
        PROCESSED,
        FINISHED,
    }

    public Garden(Tile t){
        state = State.START;
        tile = t;
        tile.setID(ResourceManager.GARDEN);
        procTime = 0;
        plant = null;
        MusicManager.soundPlay(MusicManager.SHOVEL);
    }

    @Override
    public void act(Player player) {
        Player.Tool tool = player.getTool();
        if(state == State.START && tool == Player.Tool.PLANT_BAG){
            MusicManager.soundPlay(MusicManager.PLANT_BAG);
            plant = player.getPlant();
            tile.setID(plant.getPicPrepared());
            state = State.PREPARED;
        }

        else if(state == State.PREPARED && tool == Player.Tool.WATER_POT) {
            MusicManager.soundPlay(MusicManager.WATER_POT);
            tile.setID(plant.getPicProcessed());
            state = State.PROCESSED;
            procTime = plant.getSuccessTime();
        }

        else if(state == State.FINISHED && tool == Player.Tool.HAND){
            MusicManager.soundPlay(MusicManager.HAND);
            tile.setID(ResourceManager.GARDEN);
            player.addScore(plant.getScoreAm());
            plant = null;
            state = State.START;
        }

        else{
            MusicManager.soundPlay(MusicManager.FAIL);
        }
    }

    @Override
    public void buildProc() {
        if (procTime > 0){
            procTime--;
        }
        else if (state == State.PROCESSED){
            state = State.FINISHED;
            tile.setID(plant.getPicFinished());
        }
    }
}

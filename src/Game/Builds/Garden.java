package Game.Builds;

import Game.Farm;
import Game.Map.Tile;
import Game.Plants.Plant;
import Game.Player.Player;

public class Garden extends Building{

    private Plant plant;
    private Tile tile;
    private State state;

    public enum State{
        START,
        PREPARED,
        PROCESSED,
        FINISHED,
    }

    public Garden(Tile tile){
        state = State.START;
    }

    @Override
    public int act(Player player) {
        Player.Tool tool = player.getTool();
        switch (state){
            case START:{
                if(tool == Player.Tool.PLANT_BAG){
                    //sound success
                

                }
                    break;
            }

        }
    }

    @Override
    public void buildProc() {

    }


}

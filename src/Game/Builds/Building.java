package Game.Builds;
import Game.Player.Player;

public abstract class Building {
    public abstract void act(Player player);
    public abstract void buildProc();
}
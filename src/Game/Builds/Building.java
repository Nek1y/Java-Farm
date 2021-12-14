package Game.Builds;
import Game.Player.Player;

public abstract class Building {
    public abstract int act(Player player);
    public abstract void buildProc();
}
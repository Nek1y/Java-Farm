package Core;

import java.awt.*;

public abstract class GameManager {

    protected abstract void loop();

    protected abstract void render(Graphics graphics);

    protected abstract void keyPressed(int keyCode);

    protected abstract void keyReleased(int keyCode);



}

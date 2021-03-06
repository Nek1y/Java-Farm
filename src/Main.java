import Core.Engine;
import Core.MusicManager;
import Core.ResourceManager;
import Game.Farm;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ResourceManager.load();
                MusicManager.load();
                Engine.init(new Farm());
                Engine.run();
            }
        });

    }
}

package Core;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;

public class Engine {

    private static GameManager gameManager;
    private static WindowManager windowManager;
    private static Timer timer;

    public static void init(GameManager game){
        gameManager = game;
        windowManager = new WindowManager();
        timer = new Timer(20, new GameLoop());
    }

    public static void run(){
        windowManager.addPanel(new Screen());
        windowManager.addKeyListener(new Keyboard());
        windowManager.createWindow();
        timer.start();
    }


    private static class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameManager.loop();
        }
    }

    private static class Screen extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            gameManager.render(g);
            repaint();

        }
    }

    private static class Keyboard implements KeyListener {

        @Override
        public void keyPressed(KeyEvent key) {
            gameManager.keyPressed(key.getKeyCode());

        }

        @Override
        public void keyReleased(KeyEvent key) {
            gameManager.keyReleased(key.getKeyCode());
        }

        @Override
        public void keyTyped(KeyEvent e) {}

    }

}

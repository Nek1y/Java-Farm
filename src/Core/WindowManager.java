package Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class WindowManager {

    private JFrame frame;
    private JPanel panel;

    public static int WIDTH = 640;
    public static int HEIGHT = 640;


    public WindowManager(){
        frame = new JFrame("Game");
        frame.setBounds(100, 100, 0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void addPanel(JPanel p){
        panel = p;
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    public void addKeyListener(KeyListener l){
        panel.addKeyListener(l);
    }

    public void createWindow(){
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

}

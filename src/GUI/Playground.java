package GUI;


import Figure.GoalManager;
import Figure.KeyHandler;
import Map.Grid;
import Variables.MapVariables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.Key;

public class Playground extends JPanel {
    private Timer timer;
    public static Grid grid;

    public Playground() {
        this.setLayout(null);
        refreshScreen();
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        try {
            BufferedImage image = image = ImageIO.read(new File("playground-background.png"));
            graphics.drawImage(image,-100,-100,800,800,null);
        } catch (Exception e) {

        }

        GoalManager.checkGoal();

        grid.paint(graphics);
    }

    public void refreshScreen() {
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.setRepeats(true);

        timer.setDelay(100);
        timer.start();
    }
}

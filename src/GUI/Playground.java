/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package GUI;

import Figure.GoalManager;
import Map.Grid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Playground extends JPanel {
    private Timer timer;
    public static Grid grid;

    /**
     * Playground Constructor
     */
    public Playground() {
        this.setLayout(null);
        refreshScreen();
    }

    /**
     * graphicl output playground
     * @param graphics the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        try {
            BufferedImage image = image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/playground-background.png"));
            graphics.drawImage(image,-100,-100,800,800,null);
        } catch (Exception e) {

        }

        GoalManager.checkGoal();

        grid.paint(graphics);
    }

    /**
     * refresh to screen
     */
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

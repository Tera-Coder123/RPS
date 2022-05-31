/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package GUI;

import Figure.GoalManager;
import Figure.KeyHandler;
import Map.Grid;
import Variables.MainFrameVariables;
import Variables.MapVariables;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static MainFrame mainFrame;

    /**
     *
     */
    public MainFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MainFrameVariables.WIDTH,MainFrameVariables.HEIGHT);

        this.add(new Homescreen());

        this.addKeyListener(new KeyHandler());

        this.setTitle("Schere Stein Papier");

        this.setResizable(false);

        this.setVisible(true);

        Timer timer;
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.requestFocusInWindow();
            }
        });
        timer.setDelay(500);
        timer.start();
    }

    /***
     * Remove current panel from JFrame and replace it with the "AboutScreen"
     */
    public static void goToAboutScreen() {
        mainFrame.remove(new Homescreen());
        mainFrame.add(new Aboutscreen());
    }

    /***
     * Remove current panel from JFrame and replace it with the "HomeScreen"
     */
    public static void goToHomeScreenFromAboutScreen() {
        mainFrame.remove(new Aboutscreen());
        mainFrame.add(new Homescreen());
    }

    /***
     * Remove current panel from JFrame and replace it with the "HomeScreen"
     */
    public static void goToPlayScreen() {
        Playground.grid = new Grid(0,0, MapVariables.BOX_SIZE,14,11);
        Playground.grid.fillBoxes();

        mainFrame.remove(new Homescreen());
        Playscreen.playscreen = new Playscreen();
        mainFrame.add(Playscreen.playscreen);
    }

    /**
     * Remove current Panel and add lLost screen
     */
    public static void goToLooseScreen() {
        Playscreen.playscreen.remove(Playscreen.playground);
        GoalManager.timer.stop();
        mainFrame.remove(new Playscreen());
        mainFrame.add(new LostScreen());
    }
}

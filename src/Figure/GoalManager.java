/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Figure;

import GUI.MainFrame;
import GUI.Playscreen;
import Map.Grid;
import Variables.FigureVariables;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalManager {
    public static Timer timer;

    public static void checkGoal() {
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FigureVariables.player.getX() == FigureVariables.opponent.getX() && FigureVariables.player.getY() == FigureVariables.opponent.getY()) {
                    MainFrame.goToLooseScreen();
                }
                if(FigureVariables.goal != null) {
                    if(FigureVariables.player.getX() == FigureVariables.goal.getX() && FigureVariables.player.getY() == FigureVariables.goal.getY()) {
                        Grid.resetGoal();
                    }
                }
            }
        });
        timer.setRepeats(true);

        timer.setDelay(1000);
        timer.start();
    }
}

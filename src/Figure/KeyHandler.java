/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Figure;

import Map.Grid;
import Variables.FigureVariables;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(FigureVariables.player == null) return;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W,KeyEvent.VK_UP:
                if(FigureVariables.player.getY() == 0 || checkWall(FigureVariables.player.getX(),FigureVariables.player.getY() - 40)) {

                } else {
                    FigureVariables.player.setY(FigureVariables.player.getY() - 40);
                }
                break;
            case KeyEvent.VK_A,KeyEvent.VK_LEFT:
                if(FigureVariables.player.getX() == 0 || checkWall(FigureVariables.player.getX() - 40,FigureVariables.player.getY())) {
                } else {
                    FigureVariables.player.setX(FigureVariables.player.getX() - 40);
                }
                break;
            case KeyEvent.VK_S,KeyEvent.VK_DOWN:
                if(FigureVariables.player.getY() == 400 || checkWall(FigureVariables.player.getX(),FigureVariables.player.getY() + 40)) {
                } else {
                    FigureVariables.player.setY(FigureVariables.player.getY() + 40);
                }
                break;
            case KeyEvent.VK_D,KeyEvent.VK_RIGHT:
                if(FigureVariables.player.getX() == 520 || checkWall(FigureVariables.player.getX() + 40,FigureVariables.player.getY())) {
                } else {
                    FigureVariables.player.setX(FigureVariables.player.getX() + 40);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private boolean checkWall(int x, int y) {
        if(Grid.getBoxes()[x / 40][y / 40].isWall()) {
            return true;
        }
        return false;
    }
}

/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Map;

import Figure.*;
import GUI.Playscreen;
import Variables.FigureVariables;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    private int x, y, boxSize, boxCountColumn, boxCountRow;
    private static Box[][] boxes;

    /**
     * Grid Constructor
     * @param x
     * @param y
     * @param boxSize
     * @param boxCountColumn
     * @param boxCountRow
     */
    public Grid(int x, int y, int boxSize, int boxCountColumn, int boxCountRow) {
        setX(x);
        setY(y);
        setBoxSize(boxSize);
        setBoxCountColumn(boxCountColumn);
        setBoxCountRow(boxCountRow);

        boxes = new Box[boxCountColumn][boxCountRow];
        FigureVariables.maze = new int[boxCountColumn][boxCountRow];
    }

    /**
     * graphical output for Grid
     * @param graphics
     */
    public void paint(Graphics graphics) {
        for (int column = 0; column < boxes.length; column++) {
            for (int row = 0; row < boxes[column].length; row++) {
                boxes[column][row].paint(graphics,false);
            }
        }
        FigureVariables.player.paint(graphics);
        FigureVariables.opponent.paint(graphics);
        FigureVariables.goal.paint(graphics);
    }

    /**
     * create the walls
     */
    public void createWalls() {
        for (int i = 0; i <= 20; i++) {
            int randomX = (int)(Math.random() * 12) + 1;
            int randomY = (int)(Math.random() * 9) + 1;
            boxes[randomX][randomY].setWall(true);
            FigureVariables.maze[randomX][randomY] = 1;
        }
    }

    /**
     * fill th Boxes with
     */
    public void fillBoxes() {
        for (int column = 0; column < boxes.length; column++) {
            for (int row = 0; row < boxes[column].length; row++) {
                Box box = new Box(boxSize);
                box.setX(column * boxSize);
                box.setY(row * boxSize);
                boxes[column][row] = box;
            }
        }

        createWalls();

        addPlayer();
        addOpponent();
        addGoal();
        FigureVariables.opponent.move();
    }

    /**
     * add player to the screen
     */
    public void addPlayer() {
        FigureVariables.player = new Player(0 * 40, 0 * 40, FigureType.getRandomFigureType());
    }

    private final List<Integer> path = new ArrayList<>();

    /**
     * add opponent to the screen
     */
    public void addOpponent() {
        switch (FigureVariables.player.getType()) {
            case ROCK -> FigureVariables.opponent = new Opponent(360, 480, FigureType.PAPER);
            case SCISSOR -> FigureVariables.opponent = new Opponent(360, 480, FigureType.ROCK);
            case PAPER -> FigureVariables.opponent = new Opponent(360, 480, FigureType.SCISSOR);
        }
    }

    /**
     * add the Goal to the screen
     */
    public static void addGoal() {
        Random random = new Random();

        int randomX = random.nextInt(boxes.length - 1) * 40;
        int randomY = random.nextInt(boxes[0].length - 1)  * 40;

        while (checkWall(randomX,randomY)) {
            randomX = random.nextInt(boxes.length - 1) * 40;
            randomY = random.nextInt(boxes[0].length - 1) * 40;
        }

        switch (FigureVariables.player.getType()) {
            case ROCK -> FigureVariables.goal = new Goal(randomX,randomY,FigureType.SCISSOR);
            case PAPER -> FigureVariables.goal = new Goal(randomX,randomY,FigureType.ROCK);
            case SCISSOR -> FigureVariables.goal = new Goal(randomX,randomY,FigureType.PAPER);
        }
    }

    /**
     * check if wall is at the Postion
     * @param x
     * @param y
     * @return
     */
    public static boolean checkWall(int x, int y) {
        if(Grid.getBoxes()[x / 40][y / 40].isWall()) {
            return true;
        }
        return false;
    }

    /**
     * reset the position of the Goal
     */
    public static void resetGoal() {
        FigureVariables.goal = null;
        FigureVariables.player_points++;
        Playscreen.playerScore.setText(String.valueOf(FigureVariables.player_points));
        addGoal();
    }

    /**
     * set the X for the Grid
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set the Y for the Grid
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * ste the Box Count Column
     * @param boxCount
     */
    public void setBoxCountColumn(int boxCount) {
        this.boxCountColumn = boxCount;
    }

    /**
     * ste Box Count Row
     * @param boxCountRow
     */
    public void setBoxCountRow(int boxCountRow) {
        this.boxCountRow = boxCountRow;
    }

    /**
     * set the Size for Box
     * @param boxSize
     */
    public void setBoxSize(int boxSize) {
        this.boxSize = boxSize;
    }

    /**
     * ste the Boxes
     * @return
     */
    public static Box[][] getBoxes() {
        return boxes;
    }
}

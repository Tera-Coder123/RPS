/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Figure;

import Map.Grid;
import Variables.FigureVariables;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Player {
    private int x,y;
    private FigureType type;

    /**
     * Constructor Player
     * @param x
     * @param y
     * @param type
     */
    public Player(int x, int y,FigureType type) {
        setX(x);
        setY(x);
        setType(type);
    }

    /**
     * graphical output for Player
     * @param graphics
     */
    public void paint(Graphics graphics) {
        try {
            BufferedImage image = null;
            switch (getType()) {
                case ROCK -> image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/stone.png"));
                case PAPER -> image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/paper.png"));
                case SCISSOR -> image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/scissors.png"));
            }
            graphics.drawImage(image,getX(),getY(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set X for Player
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get X from Player
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * set Y for Player
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get Y from Player
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * set Type for Player
     * @param type
     */
    public void setType(FigureType type) {
        this.type = type;
    }

    /**
     * get Type from Player
     * @return
     */
    public FigureType getType() {
        return type;
    }
}

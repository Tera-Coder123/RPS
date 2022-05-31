/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Figure;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Goal {
    private int x,y;
    private FigureType type;

    /**
     * Constructor of Goal
     * @param x
     * @param y
     * @param type
     */
    public Goal(int x, int y,FigureType type) {
        setX(x);
        setY(y);
        setType(type);
    }

    /**
     * Graphical output
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
     * set the variable X
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get the variable X
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * set the variable Y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get the variable Y
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * set the Type for the Figure
     * @param type
     */
    public void setType(FigureType type) {
        this.type = type;
    }

    /**
     * get the type from the Figure
     * @return
     */
    public FigureType getType() {
        return type;
    }
}

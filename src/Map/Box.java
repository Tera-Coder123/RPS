/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Map;

import Variables.MapVariables;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Box {
    private int x,y,size;
    private boolean filled,isRect = MapVariables.DRAW_GRID,isWall;

    /**
     * Box constructor
     * @param size
     */
    Box(int size) {
        setSize(size);
    }

    /**
     * graphical output for the Box
     * @param graphics
     * @param fill
     */
    public void paint(Graphics graphics,boolean fill) {
        setFilled(fill);
        if(isRect) paintRect(graphics);
        if(isWall) paintWall(graphics);
    }

    /**
     * paint Rectangle
     * @param graphics
     */
    public void paintRect(Graphics graphics) {
        if(isFilled()) {
            graphics.setColor(Color.black);
            graphics.fillRect(x,y,size,size);
        } else {
            graphics.drawRect(x,y,size,size);
        }
    }

    /**
     * paint a wall
     * @param graphics
     */
    public void paintWall(Graphics graphics) {
        try {
            BufferedImage image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/wall.png"));
            graphics.drawImage(image,x,y,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set
     * @param filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * set wall
     * @param wall
     */
    public void setWall(boolean wall) {
        isWall = wall;
        this.isRect = false;
    }

    /**
     * set X of the Box
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set Y of the Box
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * set the size
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * return if isWall
     * @return
     */
    public boolean isWall() {
        return isWall;
    }

    /**
     * return if isFilled
     * @return
     */
    public boolean isFilled() {
        return filled;
    }
}

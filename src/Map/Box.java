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

    Box(int size) {
        setSize(size);
    }

    public void paint(Graphics graphics,boolean fill) {
        setFilled(fill);
        if(isRect) paintRect(graphics);
        if(isWall) paintWall(graphics);
    }

    public void paintRect(Graphics graphics) {
        if(isFilled()) {
            graphics.setColor(Color.black);
            graphics.fillRect(x,y,size,size);
        } else {
            graphics.drawRect(x,y,size,size);
        }
    }

    public void paintWall(Graphics graphics) {
        try {
            BufferedImage image = ImageIO.read(new File("wall.png"));
            graphics.drawImage(image,x,y,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRect(boolean rect) {
        isRect = rect;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void setWall(boolean wall) {
        isWall = wall;
        this.isRect = false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isRect() {
        return isRect;
    }

    public boolean isWall() {
        return isWall;
    }

    public boolean isFilled() {
        return filled;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}

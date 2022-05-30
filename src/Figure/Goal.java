package Figure;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Goal {
    private int x,y;
    private FigureType type;

    public Goal(int x, int y,FigureType type) {
        setX(x);
        setY(y);
        setType(type);
    }

    public void paint(Graphics graphics) {
        try {
            BufferedImage image = null;
            switch (getType()) {
                case ROCK -> image = ImageIO.read(new File("stone.png"));
                case PAPER -> image = ImageIO.read(new File("paper.png"));
                case SCISSOR -> image = ImageIO.read(new File("scissors.png"));
            }
            graphics.drawImage(image,getX(),getY(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setType(FigureType type) {
        this.type = type;
    }

    public FigureType getType() {
        return type;
    }
}

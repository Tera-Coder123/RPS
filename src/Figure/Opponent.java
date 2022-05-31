/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Figure;

import GUI.MainFrame;
import GUI.Playscreen;
import Variables.FigureVariables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Opponent {
    private int x,y;
    private FigureType type;
    private Timer timer;

    /**
     * Constructor for Opponent
     * @param x
     * @param y
     * @param type
     */
    public Opponent(int x, int y,FigureType type) {
        setX(x);
        setY(x);
        setType(type);
    }

    /**
     * graphical output for Opponent
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
     * Opponent move
     */
    public void move(){

        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int moveSize = 40;

                int playerX = FigureVariables.player.getX();
                int playerY = FigureVariables.player.getY();

                if(playerX > getX()) setX(getX() + moveSize);
                if(playerX < getX()) setX(getX() - moveSize);

                if(playerY > getY()) setY(getY() + moveSize);
                if(playerY < getY()) setY(getY() - moveSize);
            }
        });
        timer.setDelay(600);
        timer.start();
    }

    /**
     * set x for Opponent
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get X from Opponent
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * set Y for Opponent
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get Y from Opponent
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * set Type for Opponent
     * @param type
     */
    public void setType(FigureType type) {
        this.type = type;
    }

    /**
     * get Type from Opponent
     * @return
     */
    public FigureType getType() {
        return type;
    }
}

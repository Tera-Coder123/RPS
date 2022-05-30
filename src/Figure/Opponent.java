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

    public Opponent(int x, int y,FigureType type) {
        setX(x);
        setY(x);
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

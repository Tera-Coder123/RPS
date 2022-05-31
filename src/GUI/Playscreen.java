/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package GUI;

import Map.Grid;
import Variables.FigureVariables;
import Variables.MainFrameVariables;
import Variables.MapVariables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Playscreen extends JPanel {
    public static Playscreen playscreen;
    public static Playground playground;
    private static LostScreen lostScreen;
    public static JLabel playerScore = new JLabel();
    public static JLabel playerScoreText = new JLabel();

    /**
     * Constructor of Playscreen
     */
    public Playscreen() {
        this.setLayout(null);

        playground = new Playground();
        playground.setBounds(30,270,561,441);


        playerScoreText.setText("Score");
        playerScoreText.setBounds(658,525,140,40);
        playerScoreText.setHorizontalAlignment(JLabel.CENTER);
        playerScoreText.setVerticalTextPosition(JLabel.CENTER);
        playerScoreText.setForeground(Color.black);
        playerScoreText.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 35));

        playerScore.setText(String.valueOf(FigureVariables.player_points));
        playerScore.setBounds(670,575,120,40);
        playerScore.setHorizontalAlignment(JLabel.CENTER);
        playerScore.setVerticalTextPosition(JLabel.CENTER);
        playerScore.setForeground(Color.black);
        playerScore.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 40));

        lostScreen = new LostScreen();
        lostScreen.setBounds(30,270,560,440);

        this.add(playground);
        this.add(playerScore);
        this.add(playerScoreText);
    }

    /**
     * grphical output of Pllayscreen
     * @param aG the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics aG)
    {
        super.paintComponent(aG);
        try {

            //für den Hintergrund
            BufferedImage image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/background.png"));
            aG.drawImage(image,-50,-50,1000,1000,null);
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/TV.png"));
            aG.drawImage(image,-90,-160,1000,1000,null);

            BufferedImage imageDisplay = null;
            switch (FigureVariables.player.getType()) {
                case ROCK -> imageDisplay = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/stone.png"));
                case PAPER -> imageDisplay = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/paper.png"));
                case SCISSOR -> imageDisplay = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/scissors.png"));
            }
            aG.drawImage(imageDisplay,710,320,null);
        } catch (Exception e) {

        }

    }
}

package GUI;

import Variables.FigureVariables;
import Variables.MainFrameVariables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class LostScreen extends JPanel {
    private JLabel lostLable = new JLabel();
    private String lostText = "Du hast verloren!";

    private JLabel lostScoreShow = new JLabel();
    private JLabel lostScore= new JLabel();
    public LostScreen() {
        this.setLayout(null);

        lostLable.setText(lostText);
        lostLable.setBounds(0,200,800,100);
        lostLable.setHorizontalAlignment(JLabel.CENTER);
        lostLable.setVerticalTextPosition(JLabel.CENTER);
        lostLable.setForeground(Color.black);
        lostLable.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 70));

        lostScoreShow.setText("Score");
        lostScoreShow.setBounds(0,400,800,50);
        lostScoreShow.setHorizontalAlignment(JLabel.CENTER);
        lostScoreShow.setVerticalTextPosition(JLabel.CENTER);
        lostScoreShow.setForeground(Color.black);
        lostScoreShow.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 50));

        lostScore.setText(String.valueOf(FigureVariables.player_points));
        lostScore.setBounds(0,460,800,50);
        lostScore.setHorizontalAlignment(JLabel.CENTER);
        lostScore.setVerticalTextPosition(JLabel.CENTER);
        lostScore.setForeground(Color.black);
        lostScore.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 50));


        this.add(lostLable);
        this.add(lostScoreShow);
        this.add(lostScore);
    }

    @Override
    protected void paintComponent(Graphics aG)
    {
        super.paintComponent(aG);
        try {
            //für den Hintergrund
            BufferedImage image = ImageIO.read(new File("background.png"));
            aG.drawImage(image,-50,-50,1000,1000,null);

        } catch (Exception e) {

        }
    }
}

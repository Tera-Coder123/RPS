/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package GUI;

import Variables.MainFrameVariables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Homescreen extends JPanel {
    private static JLabel homeScreenLable = new JLabel();
    private static String homeScreenText = "Schere Stein Papier";

    private static JButton playButton = new JButton("Play");
    private static JButton aboutButton = new JButton("About");

    /**
     * Constructor for Homescreen
     */
    public Homescreen() {
        this.setLayout(null);

        homeScreenLable.setText(homeScreenText);
        homeScreenLable.setBounds(0,220,800,100);
        homeScreenLable.setHorizontalAlignment(JLabel.CENTER);
        homeScreenLable.setVerticalTextPosition(JLabel.CENTER);
        homeScreenLable.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 70));
        homeScreenLable.setForeground(Color.black);

        playButton.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 40));
        playButton.setBounds(300,600,200,50);
        playButton.setOpaque(false);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.setForeground(Color.black);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.goToPlayScreen();
            }
        });

        aboutButton.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 40));
        aboutButton.setBounds(300,670,200,50);
        aboutButton.setOpaque(false);
        aboutButton.setContentAreaFilled(false);
        aboutButton.setBorderPainted(false);
        aboutButton.setForeground(Color.black);
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.goToAboutScreen();
            }
        });

        this.add(homeScreenLable);
        this.add(playButton);
        this.add(aboutButton);
    }

    /**
     * graphical output for Homescreen
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

        } catch (Exception e) {

        }
    }
}

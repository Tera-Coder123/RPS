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

public class Aboutscreen extends JPanel {
    private static JLabel aboutscreenLable = new JLabel();
    private static String aboutscreenText = "<html><body>by Maximilian Raidl<br>ein SEW-Projekt<br>Auftrag: Professor Gaisberger</body></html>";

    private static JButton backButton = new JButton("Back");

    /**
     * Constructor for Aboutscreen
     */
    public Aboutscreen() {
        this.setLayout(null);

        aboutscreenLable.setText(aboutscreenText);
        aboutscreenLable.setBounds(0,100,800,500);
        aboutscreenLable.setHorizontalAlignment(JLabel.CENTER);
        //aboutscreenLable.setVerticalTextPosition(JLabel.CENTER);
        aboutscreenLable.setForeground(Color.black);
        aboutscreenLable.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 35));

        backButton.setFont(new Font(MainFrameVariables.FONT, Font.BOLD, 40));
        backButton.setBounds(300,630,200,50);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.black);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.goToHomeScreenFromAboutScreen();
            }
        });

        this.add(aboutscreenLable);
        this.add(backButton);
    }

    /**
     * graphical output for the Aboutscreen
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

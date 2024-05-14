package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images extends JPanel {

    BufferedImage image;
    JPanel container;
    String imagePath;

    private BufferedImage backgroundImage;

    // Method to set the background image
    public void setBackgroundImage(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint(); // Trigger repaint to update the panel with the new background image
    }

    // Override paintComponent to paint the background image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
};

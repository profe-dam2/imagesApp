package org.dam.views;

import javax.swing.*;
import java.awt.*;

public class Page1Panel extends JPanel {
    private JPanel mainPanel;
    private JPanel imagePreviewPanel;
    private Image backgroundImage;

    private ImagePanel imagePanel;

    public Page1Panel() {
        add(mainPanel);
        mainPanel.setOpaque(false);
        setImagePanel();
    }

    private void setImagePanel(){
        imagePanel = new ImagePanel();
        imagePreviewPanel.add(imagePanel);
    }

    public ImagePanel getImagePanel(){
        return imagePanel;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0,getWidth(), getHeight(), this);
        }
    }
    public void setBackgroundImage(String path) {
        backgroundImage = new ImageIcon(getClass().getResource(path)).getImage();
        repaint();
    }
}

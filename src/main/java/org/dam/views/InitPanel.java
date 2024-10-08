package org.dam.views;

import javax.swing.*;
import java.awt.*;

public class InitPanel extends JPanel {
    private JPanel mainPanel;

    private Image backgroundImage;

    public InitPanel() {
        add(mainPanel);
        mainPanel.setOpaque(false);
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

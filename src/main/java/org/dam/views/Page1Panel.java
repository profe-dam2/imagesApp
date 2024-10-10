package org.dam.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static org.dam.controllers.Page1PanelController.CREATE_PRODUCT;

public class Page1Panel extends JPanel {
    private JPanel mainPanel;
    private JPanel imagePreviewPanel;
    private JButton bt_save;
    private Image backgroundImage;

    private ImagePanel imagePanel;

    public Page1Panel() {
        add(mainPanel);
        mainPanel.setOpaque(false);
        setImagePanel();
        setCommands();
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

    // LLAMAR DESDE EL CONSTRUCTOR!!!
    private void setCommands(){
        bt_save.setActionCommand(CREATE_PRODUCT);
    }

    // LLAMAR DESDE EL MAIN DE LA CLASE APP
    public void addListener(ActionListener listener){
        bt_save.addActionListener(listener);
    }
}

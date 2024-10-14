package org.dam.views;

import org.dam.controllers.ProductPanelController;
import org.dam.models.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Page2Panel extends JPanel {
    private JPanel mainPanel;
    private JPanel queriesPanel;
    private JPanel productListPanel;
    private Image backgroundImage;

    public Page2Panel() {
        add(mainPanel);
        mainPanel.setOpaque(false);
        setCommands();
        productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.Y_AXIS));
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

    public void setProductPanels(ArrayList<ProductModel> listaProductos){
        for(ProductModel producto : listaProductos){

            ProductPanel productPanel = new ProductPanel();
            ProductPanelController productPanelController =
                    new ProductPanelController(productPanel,frame);
            productPanel.setProductData(producto);
            productListPanel.add(productPanel);
        }
    }

    // LLAMAR DESDE EL CONSTRUCTOR!!!!
    private void setCommands(){

    }

    // PASAR EL CONTROLADOR DESDE EL MAIN!!
    public void addListeners(ActionListener listener) {

    }
}

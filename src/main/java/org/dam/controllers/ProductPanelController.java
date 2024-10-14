package org.dam.controllers;

import org.dam.views.MainFrame;
import org.dam.views.ProductPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductPanelController implements ActionListener {

    public static final String EDIT_PRODUCT = "EDIT_PRODUCT";

    private final ProductPanel panel;
    private final MainFrame mainFrame;

    public ProductPanelController(ProductPanel panel, MainFrame mainFrame) {
        this.panel = panel;
        this.mainFrame = mainFrame;
    }

    private void handleEditProduct(){
        mainFrame.navigate("Page1Panel");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case EDIT_PRODUCT:
                handleEditProduct();
                break;
            default:
                break;
        }
    }


}

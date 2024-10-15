package org.dam.controllers;

import org.dam.models.ProductModel;
import org.dam.views.MainFrame;
import org.dam.views.ProductPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductPanelController implements ActionListener {

    public static final String EDIT_PRODUCT = "EDIT_PRODUCT";

    private final ProductPanel productPanel;
    private final MainFrame mainFrame;

    public ProductPanelController(ProductPanel productPanel, MainFrame mainFrame) {
        this.productPanel = productPanel;
        this.mainFrame = mainFrame;
    }

    private void handleEditProduct(){

        // PASO 1. Obtener el producto y pasarlo a la pagina de crear/editar
        ProductModel productModel = productPanel.getProductModel();
        mainFrame.getPage1Panel().setProductData(productModel);

        // PASO 2. Establecer el modo edicion en pagina de crear/editar
        mainFrame.getPage1Panel().setEditMode();

        // PASO 3. Navegar hasta la pagina de crear/editar
        mainFrame.navigate("page1Panel");
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

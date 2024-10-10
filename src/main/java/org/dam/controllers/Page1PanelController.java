package org.dam.controllers;

import org.dam.models.ProductModel;
import org.dam.utils.FileUtils;
import org.dam.views.Page1Panel;
import org.dam.xml.XMLManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1PanelController implements ActionListener {

    public static final String CREATE_PRODUCT = "CREATE_PRODUCT";

    private final Page1Panel panel;

    public Page1PanelController(Page1Panel panel) {
        this.panel = panel;
    }

    private void handleCreateProduct() {
        // Primero guardar la imagen
        String rutaImageOriginal = panel.getImagePanel().getRutaImagenOriginal();
        String rutaImagen = FileUtils.guardarImagen(rutaImageOriginal);
        if(rutaImagen != null) {
            ProductModel productModel = new ProductModel();
            productModel.setImagenPath(rutaImagen);
            productModel.setPrecio(341);
            productModel.setCodigo("3124");
            productModel.setDescripcion("El mejor producto jamas creado");
            boolean okCrear = XMLManager.createProduct(productModel);
            if(okCrear) {
                JOptionPane.showMessageDialog(panel, "El producto se ha guardado correctamente");
            }
        }
        System.out.println("El archivo se guardo: " + rutaImagen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case CREATE_PRODUCT:
                handleCreateProduct();
                break;
        }
    }
}

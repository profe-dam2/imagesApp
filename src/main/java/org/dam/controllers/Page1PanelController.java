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
        // PASO 1. Obtener el producto del panel
        ProductModel productModel = panel.getProduct();

        // PASO 2. Comprobar que el codigo no exista. Si existe salimos del metodo
        try {
            ProductModel p = XMLManager.getProductByCode(productModel.getCodigo());
            if(p != null) {
                JOptionPane.showMessageDialog(null, "El código de producto ya existe");
                panel.showMessageCode();
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // PASO 3. Guardar la imagen y obtener la ruta absoluta de la imagen
        String rutaImageOriginal = panel.getImagePanel().getRutaImagenOriginal();
        String rutaImagen;

        if(!rutaImageOriginal.equals("src/images/default.jpg")) {
            // Si la ruta no es default, guardarmos la imagen
            rutaImagen = FileUtils.guardarImagen(rutaImageOriginal);
        }else{
            rutaImagen = rutaImageOriginal;
        }

        if(rutaImagen != null) {
            // Establecer ruta imagen al producto
            productModel.setImagenPath(rutaImagen);

            // PASO 4. Crear producto
            try {
                boolean okCrear = XMLManager.createProduct(productModel);
                if(okCrear) {
                    JOptionPane.showMessageDialog(null, "El producto se ha guardado correctamente");
                    panel.setDefaultValues();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
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

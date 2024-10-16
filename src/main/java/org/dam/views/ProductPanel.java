package org.dam.views;

import org.dam.models.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static org.dam.controllers.ProductPanelController.EDIT_PRODUCT;

public class ProductPanel extends JPanel {
    private JPanel mainPanel;
    private JButton bt_edit;
    private JButton bt_delete;
    private JPanel imagePreviewPanel;
    private JLabel lb_codigo;
    private JLabel lb_descripcion;
    private JLabel lb_precio;
    private JLabel lb_image;
    private ProductModel productModel;
    public ProductPanel() {
        add(mainPanel);
        setCommands();
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductData(ProductModel product) {
        this.productModel = product;
        lb_codigo.setText(product.getCodigo());
        lb_descripcion.setText(product.getDescripcion());
        lb_precio.setText(String.valueOf(product.getPrecio()));
        setBackgroundImage(product.getImagenPath());
    }

    public void setBackgroundImage(String rutaImagen) {
        // Crea un nuevo objeto ImageIcon a partir de la ruta de la imagen proporcionada.
        ImageIcon icon = new ImageIcon(rutaImagen);

        // Obtiene la imagen del ImageIcon y la escala a 280x230 píxeles utilizando un algoritmo de suavizado para una mejor calidad visual.
        Image imagenEscalada = icon.getImage().getScaledInstance(182, 182, Image.SCALE_SMOOTH);

        // Asigna la imagen escalada a un nuevo ImageIcon y lo establece en el componente imageLabel.
        lb_image.setIcon(new ImageIcon(imagenEscalada));

    }

    // Llamar desde el constructor!!
    private void setCommands(){
        bt_edit.setActionCommand(EDIT_PRODUCT);
    }

    // Llamar desde el main!!!
    public void addListeners(ActionListener listener){
        bt_edit.addActionListener(listener);
    }
}

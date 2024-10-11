package org.dam.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static org.dam.controllers.ImagePanelController.SELECT_IMAGE;
import static org.dam.controllers.ImagePanelController.SET_DEFAULT_IMAGE;

public class ImagePanel extends JPanel {
    private JPanel mainPanel;
    private JButton bt_select;
    private JButton bt_delete;
    private JLabel lb_image;

    private String rutaImagenOriginal;

    public ImagePanel() {
        add(mainPanel);
        setCommands();
        setOpaque(false);
        setRutaImagenOriginal("src/images/default.jpg");
    }

    public void setRutaImagenOriginal(String rutaImagenOriginal) {
        this.rutaImagenOriginal = rutaImagenOriginal;
    }

    public String getRutaImagenOriginal() {
        return rutaImagenOriginal;
    }

    public void setBackgroundImage(String rutaImagen) {
        // Crea un nuevo objeto ImageIcon a partir de la ruta de la imagen proporcionada.
        ImageIcon icon = new ImageIcon(rutaImagen);

        // Obtiene la imagen del ImageIcon y la escala a 280x230 píxeles utilizando un algoritmo de suavizado para una mejor calidad visual.
        Image imagenEscalada = icon.getImage().getScaledInstance(182, 182, Image.SCALE_SMOOTH);

        // Asigna la imagen escalada a un nuevo ImageIcon y lo establece en el componente imageLabel.
        lb_image.setIcon(new ImageIcon(imagenEscalada));

    }

    private void setCommands(){
        bt_select.setActionCommand(SELECT_IMAGE);
        bt_delete.setActionCommand(SET_DEFAULT_IMAGE);
    }

    public void addListener(ActionListener listener) {
        bt_select.addActionListener(listener);
        bt_delete.addActionListener(listener);
    }


}

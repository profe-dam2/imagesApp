package org.dam.controllers;

import org.dam.utils.FileUtils;
import org.dam.views.ImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ImagePanelController implements ActionListener {
    public static final String SELECT_IMAGE = "SELECT_IMAGE";
    public static final String SET_DEFAULT_IMAGE = "SET_DEFAULT_IMAGE";

    private final ImagePanel imagePanel;

    public ImagePanelController(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
        setDefaultBackgroundImage();
    }

    private void setDefaultBackgroundImage() {
        try {
            String rutaImagen = URLDecoder.decode(getClass().getResource("/default.jpg").getPath(), "UTF-8");
            imagePanel.setBackgroundImage(rutaImagen);
        } catch (UnsupportedEncodingException e) {
            System.out.println("No se encontró el recurso indicado");
        }

    }

    private void handlerSelectImage() {
        String imagePath = FileUtils.seleccionarRutaImagen();
        if(imagePath != null) {
            imagePanel.setBackgroundImage(imagePath);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case SELECT_IMAGE:
                handlerSelectImage();
                break;
            case SET_DEFAULT_IMAGE:
                setDefaultBackgroundImage();
                break;
            default:
                break;
        }
    }
}

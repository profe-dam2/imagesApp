package org.dam.controllers;

import org.dam.models.ProductModel;
import org.dam.views.Page2Panel;
import org.dam.xml.XMLManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Page2PanelController implements ActionListener, WindowListener {

    private final Page2Panel panel2;

    public Page2PanelController(Page2Panel panel2) {
        this.panel2 = panel2;
        handleCargarTablaProductos();
    }

    private void handleCargarTablaProductos(){
        try {
            ArrayList<ProductModel> listaProductos = XMLManager.getProductList();
            if (listaProductos != null) {
                panel2.setProductPanels(listaProductos);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        handleCargarTablaProductos();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

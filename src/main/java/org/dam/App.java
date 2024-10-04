package org.dam;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.dam.controllers.MainFrameController;
import org.dam.models.ProductModel;
import org.dam.views.MainFrame;
import org.dam.xml.XMLManager;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        boolean okCrear = XMLManager.createProduct(new ProductModel("2", "Un producto nuevo 2",
                480, "/ruta2"));

        if(okCrear){
            JOptionPane.showMessageDialog(null, "Producto creado");
        }else{
            JOptionPane.showMessageDialog(null, "Error al crear producto");
        }

        FlatDarculaLaf.setup();

        MainFrame frame = new MainFrame();

        // Controllers
        MainFrameController mainFrameController = new MainFrameController(frame);

        // Listeners
        frame.addListener(mainFrameController);

        frame.showWindow();
    }
}

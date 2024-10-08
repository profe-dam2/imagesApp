package org.dam;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.dam.controllers.ImagePanelController;
import org.dam.controllers.MainFrameController;
import org.dam.models.ProductModel;
import org.dam.utils.FileUtils;
import org.dam.views.ImagePanel;
import org.dam.views.MainFrame;
import org.dam.xml.XMLManager;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



//        ProductModel p =  new ProductModel("101", "Un producto nuevo 10",
//            480, "/ruta2");
//
//        try {
//            ProductModel producto = XMLManager.getProductByCode(p.getCodigo());
//            if(producto == null) {
//                //JOptionPane.showMessageDialog(null, "No existe el producto");
//                boolean okCrear = XMLManager.createProduct(p);
//
//                if(okCrear){
//                    JOptionPane.showMessageDialog(null, "Producto creado: " + p);
//                }else{
//                    JOptionPane.showMessageDialog(null, "Error al crear producto");
//                }
//            }else{
//                JOptionPane.showMessageDialog(null, "EL CODIGO YA EXISTE");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        ArrayList<ProductModel> productList = null;
//        try {
//            productList = XMLManager.getProductList();
//            JOptionPane.showMessageDialog(null, productList);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }



        FlatDarculaLaf.setup();


        MainFrame frame = new MainFrame();

        ImagePanel imagePanel = frame.getPage1Panel().getImagePanel();

        // Controllers
        MainFrameController mainFrameController = new MainFrameController(frame);
        ImagePanelController imagePanelController = new ImagePanelController(imagePanel);

        // Listeners
        frame.addListener(mainFrameController);
        imagePanel.addListener(imagePanelController);

        frame.showWindow();
    }
}

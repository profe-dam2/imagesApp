package org.dam.xml;

import org.dam.models.ProductModel;
import org.dam.services.XMLService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import static org.dam.services.XMLService.ROOT_NODE;

public class XMLManager {

    public static boolean createProduct(ProductModel product) {
        Document document = XMLService.loadOrCreateXML(); // Cargar o crear el documento XML

        if (document != null) {
            try{
                Element newProduct = document.createElement("producto");
                newProduct.setAttribute("codigo", product.getCodigo());
                newProduct.setAttribute("descripcion", product.getDescripcion());
                newProduct.setAttribute("precio",String.valueOf(product.getPrecio()));
                newProduct.setAttribute("imagenPath",product.getImagenPath());

                // Obtener el nodo raiz
                NodeList nodeList = document.getElementsByTagName(ROOT_NODE);
                if(nodeList.getLength() > 0) {
                    Element rootElement = (Element) nodeList.item(0);
                    rootElement.appendChild(newProduct); // Añadir el nuevo producto al nodo raiz
                    return XMLService.saveXML(document);
                }

            }catch (Exception e) {
                System.out.println("Error al agregar nodo");
            }
        }
        return false;
    }
}

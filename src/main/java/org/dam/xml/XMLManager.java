package org.dam.xml;

import org.dam.models.ProductModel;
import org.dam.services.XMLService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

import static org.dam.services.XMLService.ROOT_NODE;

public class XMLManager {


    public static ArrayList<ProductModel> getProductList() throws Exception {
        ArrayList<ProductModel> productList = null;
        Document document = XMLService.loadOrCreateXML(); // Cargar o crear el documento XML
        if(document != null) {
            try{
                NodeList nodeList = document.getElementsByTagName("producto");
                productList = new ArrayList<>();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    productList.add(new ProductModel(element.getAttribute("codigo"),
                            element.getAttribute("descripcion"),
                            Double.parseDouble(element.getAttribute("precio")),
                            element.getAttribute("imagenPath")));
                }
            }catch (Exception e){
                System.out.println("Error al obtener producto");
                throw new Exception("1, Error al obtener productos");
            }
        }else{
            throw new Exception("2, Error al obtener el documento");
        }

        return productList;
    }

    public static ProductModel getProductByCode(String code) throws Exception {
        Document document = XMLService.loadOrCreateXML(); // Cargar o crear el documento XML
        if(document != null) {
            try{
                NodeList nodeList = document.getElementsByTagName("producto");
                for(int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    String codigo = element.getAttribute("codigo");
                    if(codigo.equals(code)) {
                        ProductModel productModel = new ProductModel();
                        productModel.setCodigo(code);
                        productModel.setDescripcion(element.getAttribute("descripcion"));
                        productModel.setPrecio(Double.parseDouble(element.getAttribute("precio")));
                        productModel.setImagenPath(element.getAttribute("imagenPath"));
                        return productModel;
                    }
                }
            }catch (Exception e) {
                System.out.println("Error al obtener producto");
                throw new Exception("1, Error al obtener producto");
            }
        }else{
            throw new Exception("2, Error al obtener el documento");
        }
        //throw new Exception("3,El producto no existe");
        return null;
    }


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

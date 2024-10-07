package org.dam.models;

public class ProductModel {
    private String codigo;
    private String descripcion;
    private double precio;
    private String imagenPath;

    public ProductModel(String codigo, String descripcion, double precio, String imagenPath) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenPath = imagenPath;
    }

    public ProductModel() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    @Override
    public String toString() {
        return "Producto: " + codigo + ", " + descripcion + ", " + precio + ", " + imagenPath+"\n";
    }
}

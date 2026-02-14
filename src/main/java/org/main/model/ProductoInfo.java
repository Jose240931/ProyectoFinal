package org.main.model;

public class ProductoInfo {
    private String categoria;
    private String nombreReal;

    public ProductoInfo(String categoria, String nombreReal) {
        this.categoria = categoria;
        this.nombreReal = nombreReal;
    }

    public String getCategoria() { return categoria; }
    public String getNombreReal() { return nombreReal; }
}
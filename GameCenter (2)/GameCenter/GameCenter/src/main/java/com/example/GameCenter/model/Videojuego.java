package com.example.GameCenter.model;


public class Videojuego {
    private int id;
    private String codigo;
    private String titulo;
    private String consola;
    private int añoLanzamiento;
    private double precio;



public Videojuego() {}

    public Videojuego(int id, String codigo, String titulo, String consola, int añoLanzamiento, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.consola = consola;
        this.añoLanzamiento = añoLanzamiento;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

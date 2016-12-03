package com.dev.firebase;

public class Post {

    private String fecha;
    private String nombreUsuario;
    private String contenido;

    public Post(){

    }

    public Post(String fecha,String nombreUsuario,String contenido){
        this.fecha = fecha;
        this.nombreUsuario = nombreUsuario;
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

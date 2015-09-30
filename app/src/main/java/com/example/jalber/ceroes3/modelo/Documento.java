package com.example.jalber.ceroes3.modelo;

import com.parse.ParseFile;


/**
 * Created by Jalber on 29/09/2015.
 */

public class Documento
{
    private String nombre;
    private String descripcion;
    private String tipo;
    private ParseFile foto;

    public Documento(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ParseFile getFoto() {
        return foto;
    }

    public void setFoto(ParseFile foto) {
        this.foto = foto;
    }

}

package com.example.analy.usuario.Cajas;

public class Grado {
    public   String idgrado;
    public  String descripcion;

    public String getIdestado() {
        return idgrado;
    }

    public void setIdestado(String idestado) {
        this.idgrado = idestado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Grado(String idestado, String descripcion) {
        this.idgrado = idestado;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion ;
    }
}

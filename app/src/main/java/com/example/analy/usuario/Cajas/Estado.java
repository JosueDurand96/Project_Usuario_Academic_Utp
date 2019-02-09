package com.example.analy.usuario.Cajas;

public class Estado {
  public   String idestado;
  public  String descripcion;

    public String getIdestado() {
        return idestado;
    }

    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado(String idestado, String descripcion) {
        this.idestado = idestado;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion ;
    }
}

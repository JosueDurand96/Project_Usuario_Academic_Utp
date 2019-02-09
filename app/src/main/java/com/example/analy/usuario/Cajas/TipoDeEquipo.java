package com.example.analy.usuario.Cajas;

public class TipoDeEquipo {
    public   String idtipoequipo;
    public  String descripcion;

    public String getIdestado() {
        return idtipoequipo;
    }

    public void setIdestado(String idestado) {
        this.idtipoequipo = idestado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDeEquipo(String idestado, String descripcion) {
        this.idtipoequipo = idestado;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion ;
        }
        }

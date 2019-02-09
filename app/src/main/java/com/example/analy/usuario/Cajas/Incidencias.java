package com.example.analy.usuario.Cajas;

public class Incidencias {
    public  String desgrado;
    public  String descripcion;
    public  String Auladescripcion;
    public  String nroaula;

    public String getDesgrado() {
        return desgrado;
    }

    public void setDesgrado(String desgrado) {
        this.desgrado = desgrado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAuladescripcion() {
        return Auladescripcion;
    }

    public void setAuladescripcion(String auladescripcion) {
        Auladescripcion = auladescripcion;
    }

    public String getNroaula() {
        return nroaula;
    }

    public void setNroaula(String nroaula) {
        this.nroaula = nroaula;
    }

    public Incidencias(String desgrado, String descripcion, String auladescripcion, String nroaula) {
        this.desgrado = desgrado;
        this.descripcion = descripcion;
        Auladescripcion = auladescripcion;
        this.nroaula = nroaula;
    }
}

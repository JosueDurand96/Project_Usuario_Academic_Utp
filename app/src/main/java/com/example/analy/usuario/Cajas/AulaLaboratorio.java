package com.example.analy.usuario.Cajas;

public class AulaLaboratorio {
    public String idaulla;
    public String descripcion;
    public  String nroaula;

    public AulaLaboratorio(String idaulla, String descripcion) {
        this.idaulla = idaulla;
        this.descripcion = descripcion;
    }

    public String getIdaulla() {
        return idaulla;
    }

    public void setIdaulla(String idaulla) {
        this.idaulla = idaulla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNroaula() {
        return nroaula;
    }

    public void setNroaula(String nroaula) {
        this.nroaula = nroaula;
    }
    @Override
    public String toString() {
        return  descripcion ;
    }
}

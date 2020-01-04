package com.eulersoft;

public class Simbolo {

    private String simbolo;
    private String estado;

    public Simbolo(String simbolo, String estado) {
        this.simbolo = simbolo;
        this.estado = estado;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

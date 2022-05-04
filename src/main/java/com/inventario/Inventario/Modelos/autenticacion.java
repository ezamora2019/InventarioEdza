package com.inventario.Inventario.Modelos;

import java.util.Date;

public class autenticacion {

    private String autorizacion;
    private int tiempoExpiracion;
    private Date tiempoIncio;
    private Date tiempoFin;

    public String getAutorizacion() {
        return autorizacion;
    }
    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }
    public int getTiempoExpiracion() {
        return tiempoExpiracion;
    }
    public void setTiempoExpiracion(int tiempoExpiracion) {
        this.tiempoExpiracion = tiempoExpiracion;
    }
    public Date getTiempoIncio() {
        return tiempoIncio;
    }
    public void setTiempoIncio(Date tiempoIncio) {
        this.tiempoIncio = tiempoIncio;
    }
    public Date getTiempoFin() {
        return tiempoFin;
    }
    public void setTiempoFin(Date tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

}
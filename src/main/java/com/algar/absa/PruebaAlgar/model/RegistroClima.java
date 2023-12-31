package com.algar.absa.PruebaAlgar.model;

public class RegistroClima {
    private final String ciudad;
    private final String datosClima;

    public RegistroClima(String ciudad, String datosClima) {
        this.ciudad = ciudad;
        this.datosClima = datosClima;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDatosClima() {
        return datosClima;
    }
}
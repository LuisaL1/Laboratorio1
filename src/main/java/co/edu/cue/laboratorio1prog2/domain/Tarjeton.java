package co.edu.cue.laboratorio1prog2.domain;

import java.io.Serializable;

public class Tarjeton implements Serializable {
    String nombre;
    String codigoTarjeton;
    String jornada;

    public Tarjeton(String nombre, String codigoTarjeton, String jornada) {
        this.nombre = nombre;
        this.codigoTarjeton = codigoTarjeton;
        this.jornada = jornada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoTarjeton() {
        return codigoTarjeton;
    }

    public void setCodigoTarjeton(String codigoTarjeton) {
        this.codigoTarjeton = codigoTarjeton;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }
}

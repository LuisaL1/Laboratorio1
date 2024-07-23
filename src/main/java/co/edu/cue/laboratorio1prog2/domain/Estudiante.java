package co.edu.cue.laboratorio1prog2.domain;

import java.io.Serializable;

public class Estudiante implements Serializable {
    String documento;
    String Jornada;

    public Estudiante(String documento, String jornada) {
        this.documento = documento;
        Jornada = jornada;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getJornada() {
        return Jornada;
    }

    public void setJornada(String jornada) {
        Jornada = jornada;
    }
}

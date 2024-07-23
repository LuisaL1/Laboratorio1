package co.edu.cue.laboratorio1prog2.domain;

import co.edu.cue.laboratorio1prog2.Utils.VentanaUtil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Voto implements Serializable {
    private String codigo;
    private String codigoVotante;
    private String codigoTarjeton;

    public Voto(String codigo, String codigoVotante, String codigoTarjeton) {
        this.codigo = codigo;
        this.codigoVotante = codigoVotante;
        this.codigoTarjeton = codigoTarjeton;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoVotante() {
        return codigoVotante;
    }

    public void setCodigoVotante(String codigoVotante) {
        this.codigoVotante = codigoVotante;
    }

    public String getCodigoTarjeton() {
        return codigoTarjeton;
    }

    public void setCodigoTarjeton(String codigoTarjeton) {
        this.codigoTarjeton = codigoTarjeton;
    }

}


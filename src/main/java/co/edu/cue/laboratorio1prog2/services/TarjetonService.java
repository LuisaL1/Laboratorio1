package co.edu.cue.laboratorio1prog2.services;

import co.edu.cue.laboratorio1prog2.domain.Tarjeton;

import java.util.List;

public interface TarjetonService {
    List<Tarjeton> obtenerTarjetonesManiana();
    List<Tarjeton> obtenerTarjetonesTarde();
}

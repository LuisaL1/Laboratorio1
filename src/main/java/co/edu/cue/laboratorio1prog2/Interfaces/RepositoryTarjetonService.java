package co.edu.cue.laboratorio1prog2.Interfaces;

import co.edu.cue.laboratorio1prog2.domain.Tarjeton;
import co.edu.cue.laboratorio1prog2.domain.Voto;

import java.util.List;

public interface RepositoryTarjetonService {
    List<Tarjeton> findAll();
    Tarjeton save(Tarjeton tarjeton);
}

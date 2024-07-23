package co.edu.cue.laboratorio1prog2.Interfaces;

import co.edu.cue.laboratorio1prog2.domain.Voto;

import java.util.List;

public interface RepositoryVotoService {
    List<Voto> findAll();
    Voto save(Voto codigo);
}

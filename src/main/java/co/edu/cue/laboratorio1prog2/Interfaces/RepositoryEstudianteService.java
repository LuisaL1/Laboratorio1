package co.edu.cue.laboratorio1prog2.Interfaces;

import co.edu.cue.laboratorio1prog2.domain.Estudiante;

import java.util.List;

public interface RepositoryEstudianteService {
    List<Estudiante> findAll();

    Estudiante save(Estudiante estudiante);
}

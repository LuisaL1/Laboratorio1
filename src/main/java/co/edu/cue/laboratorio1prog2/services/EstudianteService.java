package co.edu.cue.laboratorio1prog2.services;

import co.edu.cue.laboratorio1prog2.domain.Estudiante;

import java.util.List;
public interface EstudianteService {
    String ingresar(String documento, String jornada) throws Exception;
    Estudiante obtenerEstudiante(String documento) throws Exception;
}


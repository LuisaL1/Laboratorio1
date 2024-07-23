package co.edu.cue.laboratorio1prog2.services;

import co.edu.cue.laboratorio1prog2.Repository.RepositoryEstudianteImpl;
import co.edu.cue.laboratorio1prog2.Repository.RepositoryTarjetonImpl;
import co.edu.cue.laboratorio1prog2.domain.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class EstudianteImpl implements EstudianteService {

    RepositoryEstudianteImpl repositoryEstudiante= new RepositoryEstudianteImpl();


    @Override
    public String ingresar(String documento, String jornadaSeleccionada) throws Exception {

        List<Estudiante> estudiantes = repositoryEstudiante.findAll();

        // Lógica para autenticar al estudiante
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDocumento().equals(documento) && estudiante.getJornada().equals(jornadaSeleccionada)) {
                return documento; // Retorna el documento si la autenticación es exitosa
            }
        }
        throw new Exception("Autenticación fallida: Documento o jornada incorrectos");
    }

    @Override
    public Estudiante obtenerEstudiante(String documento) throws Exception {
        List<Estudiante> estudiantes = repositoryEstudiante.findAll();

        for (Estudiante estudiante: estudiantes){
            if (estudiante.getDocumento().equals(documento)){
                return estudiante;
            }
        }

        throw new Exception("El estudiante no existe");
    }

}

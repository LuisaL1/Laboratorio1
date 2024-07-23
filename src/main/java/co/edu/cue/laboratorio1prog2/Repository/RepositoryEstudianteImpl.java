package co.edu.cue.laboratorio1prog2.Repository;

import co.edu.cue.laboratorio1prog2.Interfaces.RepositoryEstudianteService;
import co.edu.cue.laboratorio1prog2.domain.Estudiante;
import co.edu.cue.laboratorio1prog2.domain.Tarjeton;
import co.edu.cue.laboratorio1prog2.domain.Voto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryEstudianteImpl implements RepositoryEstudianteService {
    private static final String RUTA_ARCHIVO = "src/main/resources/archivoEstudiantes.dat";

    @Override
    public List<Estudiante> findAll() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Estudiante>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        List<Estudiante> estudiantes = findAll();

        int index = estudiantes.indexOf(estudiante);
        if (index != -1) {
            estudiantes.set(index, estudiante);
        } else {
            estudiantes.add(estudiante);
        }
        saveAll(estudiantes);
        return estudiante;
    }

    private void saveAll(List<Estudiante> estudiantes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(estudiantes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

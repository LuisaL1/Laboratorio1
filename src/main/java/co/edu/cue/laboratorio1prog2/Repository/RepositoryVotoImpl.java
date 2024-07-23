package co.edu.cue.laboratorio1prog2.Repository;

import co.edu.cue.laboratorio1prog2.Interfaces.RepositoryVotoService;
import co.edu.cue.laboratorio1prog2.domain.Voto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryVotoImpl implements RepositoryVotoService {

    private static final String RUTA_ARCHIVO = "src/main/resources/archivoVotos.dat";
    public List<Voto> findAll() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Voto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public Voto save(Voto voto) {
        List<Voto> votos = findAll();

        int index = votos.indexOf(voto);
        if (index != -1) {
            votos.set(index, voto);
        } else {
            votos.add(voto);
        }
        saveAll(votos);
        return voto;
    }

    private void saveAll(List<Voto> votos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(votos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

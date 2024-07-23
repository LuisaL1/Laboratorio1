package co.edu.cue.laboratorio1prog2.Repository;

import co.edu.cue.laboratorio1prog2.Interfaces.RepositoryTarjetonService;
import co.edu.cue.laboratorio1prog2.domain.Tarjeton;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryTarjetonImpl implements RepositoryTarjetonService {

    private static final String RUTA_ARCHIVO = "src/main/resources/archivoTarjeton.dat";

    @Override
    public List<Tarjeton> findAll() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Tarjeton>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Tarjeton save(Tarjeton tarjeton) {
        List<Tarjeton> tarjetones = findAll();

        int index = tarjetones.indexOf(tarjeton);
        if (index != -1) {
            tarjetones.set(index, tarjeton);
        } else {
            tarjetones.add(tarjeton);
        }
        saveAll(tarjetones);
        return tarjeton;
    }

    private void saveAll(List<Tarjeton> tarjetones) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(tarjetones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

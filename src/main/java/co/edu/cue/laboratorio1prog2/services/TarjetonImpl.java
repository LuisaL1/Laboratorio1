package co.edu.cue.laboratorio1prog2.services;

import co.edu.cue.laboratorio1prog2.Repository.RepositoryTarjetonImpl;
import co.edu.cue.laboratorio1prog2.domain.Tarjeton;

import java.util.ArrayList;
import java.util.List;

public class TarjetonImpl implements TarjetonService {

    RepositoryTarjetonImpl repositoryTarjeton = new RepositoryTarjetonImpl();
    @Override
    public List<Tarjeton> obtenerTarjetonesManiana() {
        List<Tarjeton> tarjetones = repositoryTarjeton.findAll();
        List<Tarjeton> tarjetonesDiurna = new ArrayList<>();
        for (Tarjeton tarjeton: tarjetones){
            if (tarjeton.getJornada().equals("Mañana")) {
                tarjetonesDiurna.add(tarjeton);
            }
        }
        return tarjetonesDiurna;
    }

    @Override
    public List<Tarjeton> obtenerTarjetonesTarde() {
        List<Tarjeton> tarjetones = repositoryTarjeton.findAll();
        List<Tarjeton> tarjetonesTarde = new ArrayList<>();
        for (Tarjeton tarjeton: tarjetones){
            if (tarjeton.getJornada().equals("Tarde")) {
                tarjetonesTarde.add(tarjeton);
            }
        }
        return tarjetonesTarde;
    }
}


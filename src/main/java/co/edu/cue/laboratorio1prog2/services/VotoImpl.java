package co.edu.cue.laboratorio1prog2.services;

import co.edu.cue.laboratorio1prog2.Repository.RepositoryVotoImpl;
import co.edu.cue.laboratorio1prog2.domain.Estudiante;
import co.edu.cue.laboratorio1prog2.domain.Voto;

import java.util.List;

public class VotoImpl implements VotoService {

    EstudianteImpl estudianteService = new EstudianteImpl();
    RepositoryVotoImpl repositoryVoto = new RepositoryVotoImpl();


    public void votar(String codigoVotante, String codigoTarjeton) throws Exception {
        Estudiante estudiante = estudianteService.obtenerEstudiante(codigoVotante);


        List<Voto> listaVotos = repositoryVoto.findAll();

        for (Voto voto: listaVotos){
            if (voto.getCodigoVotante().equals(codigoVotante)){
                throw new Exception("Usted ya ha votado");
            }
        }


        Voto voto = new Voto((listaVotos.size()+1)+"",codigoVotante, codigoTarjeton);

        repositoryVoto.save(voto);

        // Aquí puedes agregar la lógica para almacenar el voto
        System.out.println("Voto registrado exitosamente.");

    }

    @Override
    public List<Voto> listarVotos() {
        return repositoryVoto.findAll();
    }
}


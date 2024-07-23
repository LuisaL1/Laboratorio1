package co.edu.cue.laboratorio1prog2.services;

import co.edu.cue.laboratorio1prog2.domain.Voto;

import java.util.List;

public interface VotoService {

   public void votar (String codigoVotante, String codigoTarjeton) throws Exception;
   List<Voto> listarVotos();
}

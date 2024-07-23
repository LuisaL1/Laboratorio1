package co.edu.cue.laboratorio1prog2;

import co.edu.cue.laboratorio1prog2.Repository.RepositoryEstudianteImpl;
import co.edu.cue.laboratorio1prog2.Repository.RepositoryTarjetonImpl;
import co.edu.cue.laboratorio1prog2.domain.Estudiante;
import co.edu.cue.laboratorio1prog2.domain.Tarjeton;

public class QuemadoDatos {
    public static void main(String[] args) {
//        RepositoryEstudianteImpl repositoryEstudiante = new RepositoryEstudianteImpl();
//
//        Estudiante estudiante = new Estudiante("1005233408", "Mañana");
//
//        repositoryEstudiante.save(estudiante);
//
//        estudiante = new Estudiante("1006242912", "Tarde");
//
//        repositoryEstudiante.save(estudiante);



        //Quemar tarjetones

        RepositoryTarjetonImpl repositoryTarjeton = new RepositoryTarjetonImpl();

        Tarjeton tarjeton = new Tarjeton("Mariana Lopéz","001","Mañana");
        repositoryTarjeton.save(tarjeton);

        tarjeton = new Tarjeton("Camilo Ramirez","002","Mañana");
        repositoryTarjeton.save(tarjeton);

        tarjeton = new Tarjeton("Juan Esteban Solarte","003","Mañana");
        repositoryTarjeton.save(tarjeton);

        tarjeton = new Tarjeton("Sebastian Jaramillo","004","Tarde");
        repositoryTarjeton.save(tarjeton);

        tarjeton = new Tarjeton("Daniel Restrepo","005","Tarde");
        repositoryTarjeton.save(tarjeton);

        tarjeton = new Tarjeton("Luisa Londoño","006","Tarde");
        repositoryTarjeton.save(tarjeton);

    }
}

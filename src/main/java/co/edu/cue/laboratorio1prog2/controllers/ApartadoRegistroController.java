package co.edu.cue.laboratorio1prog2.controllers;

import co.edu.cue.laboratorio1prog2.Repository.RepositoryTarjetonImpl;
import co.edu.cue.laboratorio1prog2.Utils.VentanaUtil;
import co.edu.cue.laboratorio1prog2.domain.Estudiante;
import co.edu.cue.laboratorio1prog2.domain.Tarjeton;
import co.edu.cue.laboratorio1prog2.domain.Voto;
import co.edu.cue.laboratorio1prog2.Repository.RepositoryVotoImpl;
import co.edu.cue.laboratorio1prog2.services.EstudianteImpl;
import co.edu.cue.laboratorio1prog2.services.TarjetonImpl;
import co.edu.cue.laboratorio1prog2.services.VotoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.List;

public class ApartadoRegistroController {


    @FXML
    private Label lbNombreTarjeton1;

    @FXML
    private Label lbNombreTarjeton2;

    @FXML
    private Label lbNombreTarjeton3;

    @FXML
    private Label lbNumeroTarjeton1;

    @FXML
    private Label lbNumeroTarjeton2;

    @FXML
    private Label lbNumeroTarjeton3;

    private Stage stage;
    private String documentoVotante;

    TarjetonImpl tarjetonImpl = new TarjetonImpl();
    EstudianteImpl estudianteImpl = new EstudianteImpl();



    // Método para configurar el documento del votante y el stage
    public void setDocumentoVotante(String documento) throws Exception {
        this.documentoVotante = documento;

        Estudiante estudiante = estudianteImpl.obtenerEstudiante(documento);

        if (estudiante.getJornada().equals("Mañana")){
            List<Tarjeton> listaTarjetonManiana = tarjetonImpl.obtenerTarjetonesManiana();

            lbNombreTarjeton1.setText(listaTarjetonManiana.get(0).getNombre());
            lbNombreTarjeton2.setText(listaTarjetonManiana.get(1).getNombre());
            lbNombreTarjeton3.setText(listaTarjetonManiana.get(2).getNombre());

            lbNumeroTarjeton1.setText(listaTarjetonManiana.get(0).getCodigoTarjeton());
            lbNumeroTarjeton2.setText(listaTarjetonManiana.get(1).getCodigoTarjeton());
            lbNumeroTarjeton3.setText(listaTarjetonManiana.get(2).getCodigoTarjeton());

        }else{
            List<Tarjeton> listaTarjetonTarde = tarjetonImpl.obtenerTarjetonesTarde();

            lbNombreTarjeton1.setText(listaTarjetonTarde.get(0).getNombre());
            lbNombreTarjeton2.setText(listaTarjetonTarde.get(1).getNombre());
            lbNombreTarjeton3.setText(listaTarjetonTarde.get(2).getNombre());

            lbNumeroTarjeton1.setText(listaTarjetonTarde.get(0).getCodigoTarjeton());
            lbNumeroTarjeton2.setText(listaTarjetonTarde.get(1).getCodigoTarjeton());
            lbNumeroTarjeton3.setText(listaTarjetonTarde.get(2).getCodigoTarjeton());
        }

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void votarPor001(ActionEvent event) {
        registrarVoto(lbNumeroTarjeton1.getText());
    }

    @FXML
    void votarPor002(ActionEvent event) {
        registrarVoto(lbNumeroTarjeton2.getText());
    }

    @FXML
    void votarPor003(ActionEvent event) {
        registrarVoto(lbNumeroTarjeton3.getText());
    }


    private void registrarVoto(String codigoTarjeton) {
        VotoImpl votoService = new VotoImpl();
        try {
            votoService.votar(documentoVotante, codigoTarjeton);

            VentanaUtil.mostrarMensajeInformacion("Voto Registrado", "Has votado por el candidato con código " + codigoTarjeton);


        } catch (Exception e) {
            VentanaUtil.mostrarMensajeAlerta("Error al registrar el voto: " + e.getMessage());
        } finally {

            if (stage != null) {
                stage.close();
            }
        }
    }
}

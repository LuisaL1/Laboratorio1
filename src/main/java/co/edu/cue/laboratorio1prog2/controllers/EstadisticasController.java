package co.edu.cue.laboratorio1prog2.controllers;

import co.edu.cue.laboratorio1prog2.domain.Voto;
import co.edu.cue.laboratorio1prog2.services.VotoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.List;

public class EstadisticasController {

    @FXML
    private Label lbCantidadVotos1;

    @FXML
    private Label lbCantidadVotos2;

    @FXML
    private Label lbCantidadVotos3;

    @FXML
    private Label lbCantidadVotos4;

    @FXML
    private Label lbCantidadVotos5;

    @FXML
    private Label lbCantidadVotos6;

    Stage stage;

    VotoImpl votoImpl = new VotoImpl();


    public void setStage(Stage stage) {
        this.stage = stage;

        inicialiarVotos();

    }

    private void inicialiarVotos() {
        List<Voto> listaVotos = votoImpl.listarVotos();
        for (Voto voto: listaVotos){
            if (voto.getCodigoTarjeton().equals("001")){
                int cantidadVotos = Integer.parseInt(lbCantidadVotos1.getText());
                lbCantidadVotos1.setText(cantidadVotos+1+"");
            }
            if (voto.getCodigoTarjeton().equals("002")){
                int cantidadVotos = Integer.parseInt(lbCantidadVotos2.getText());
                lbCantidadVotos2.setText(cantidadVotos+1+"");
            }
            if (voto.getCodigoTarjeton().equals("003")){
                int cantidadVotos = Integer.parseInt(lbCantidadVotos3.getText());
                lbCantidadVotos3.setText(cantidadVotos+1+"");
            }
            if (voto.getCodigoTarjeton().equals("004")){
                int cantidadVotos = Integer.parseInt(lbCantidadVotos4.getText());
                lbCantidadVotos4.setText(cantidadVotos+1+"");
            }
            if (voto.getCodigoTarjeton().equals("005")){
                int cantidadVotos = Integer.parseInt(lbCantidadVotos5.getText());
                lbCantidadVotos5.setText(cantidadVotos+1+"");
            }
            if (voto.getCodigoTarjeton().equals("006")){
                int cantidadVotos = Integer.parseInt(lbCantidadVotos6.getText());
                lbCantidadVotos6.setText(cantidadVotos+1+"");
            }
        }
    }
}

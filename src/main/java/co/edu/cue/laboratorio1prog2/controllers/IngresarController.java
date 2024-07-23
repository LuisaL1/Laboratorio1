package co.edu.cue.laboratorio1prog2.controllers;

import co.edu.cue.laboratorio1prog2.Utils.VentanaUtil;
import co.edu.cue.laboratorio1prog2.services.EstudianteImpl;
import co.edu.cue.laboratorio1prog2.services.EstudianteService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class IngresarController {

    private EstudianteService estudianteServicio;
    private Stage stage;

    public IngresarController() {
        this.estudianteServicio = new EstudianteImpl();
    }

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField pfDocumento;

    @FXML
    private SplitMenuButton sfJornada;

    @FXML
    void Ingresar(ActionEvent event) {
        try {
            String documento = pfDocumento.getText();
            String jornada = getSelectedJornada();
            if (documento.isEmpty() || jornada.equals("Seleccionar Jornada")) {
                VentanaUtil.mostrarMensajeAlerta("Debe ingresar su documento y seleccionar una jornada.");
                return;
            }
            estudianteServicio.ingresar(documento, jornada);
            VentanaUtil.cambiarVentana("/co/edu/cue/laboratorio1prog2/ApartadoRegistro.fxml", documento);
            if (stage != null) {
                stage.close();
            }
        } catch (Exception e) {
            VentanaUtil.mostrarMensajeAlerta(e.getMessage());
        }
    }

    @FXML
    void seleccionar(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        sfJornada.setText(selectedItem.getText());
    }

    private String getSelectedJornada() {
        return sfJornada.getText();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void verEstadistica(ActionEvent event) {
        VentanaUtil.cambiarVentana("/co/edu/cue/laboratorio1prog2/estadistica.fxml", null);
        if (stage != null) {
            stage.close();
        }
    }
}




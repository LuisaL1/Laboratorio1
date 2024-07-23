package co.edu.cue.laboratorio1prog2.Utils;

import co.edu.cue.laboratorio1prog2.controllers.ApartadoRegistroController;
import co.edu.cue.laboratorio1prog2.controllers.EstadisticasController;
import co.edu.cue.laboratorio1prog2.controllers.IngresarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaUtil {

    public static void cambiarVentana(String fxml, String documentoVotante) {
        try {
            // Cargar el archivo FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(VentanaUtil.class.getResource(fxml));
            Scene scene = new Scene(loader.load());

            // Obtener el controlador de la nueva ventana
            Object controller = loader.getController();

            // Crear una nueva etapa (Stage) para la nueva ventana
            Stage stage = new Stage();
            stage.setScene(scene);

            // Si el controlador necesita recibir el Stage, asignarlo
            if (controller instanceof ApartadoRegistroController) {
                ((ApartadoRegistroController) controller).setStage(stage);
                ((ApartadoRegistroController) controller).setDocumentoVotante(documentoVotante);

            }
            if (controller instanceof EstadisticasController) {
                ((EstadisticasController) controller).setStage(stage);
            }

            // Mostrar la nueva ventana
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Asegúrate de ver el stack trace si hay un error
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarMensajeAlerta(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public static void mostrarMensajeInformacion(String titulo,String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public static void mostrarMensajeConfirmacion(String titulo,String mensaje){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static Image loadImage(String filePath) {
        return new Image(VentanaUtil.class.getResourceAsStream(filePath));
    }

}


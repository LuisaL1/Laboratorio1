module co.edu.cue.laboratorio1prog2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.cue.laboratorio1prog2 to javafx.fxml;
    exports co.edu.cue.laboratorio1prog2;
    exports co.edu.cue.laboratorio1prog2.controllers;
    opens co.edu.cue.laboratorio1prog2.controllers to javafx.fxml;
}
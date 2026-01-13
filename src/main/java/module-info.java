module org.example.ejercicio23 {
    requires javafx.controls;
    requires javafx.fxml;


    exports org.example.ejercicio23;
    exports org.example.ejercicio23.control;

    opens org.example.ejercicio23.control to javafx.fxml;
}
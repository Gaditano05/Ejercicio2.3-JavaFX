package org.example.ejercicio23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ejercicio23.control.ColorChangedEvent;
import org.example.ejercicio23.control.ColorCirculoControl;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ColorCirculoControl control = new ColorCirculoControl();

        //Escuchamos el evento
        control.addEventHandler(
                ColorChangedEvent.COLOR_CHANGED,
                event -> System.out.println("Color cambiado a: " + event.getNewColor())
        );

        Scene scene = new Scene(control, 320, 240);
        stage.setTitle("prueba Circulo");
        stage.setScene(scene);
        stage.show();
    }

}

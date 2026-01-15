package org.example.ejercicio23.control;

import javafx.animation.FillTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;

public class ColorCirculoControl extends VBox {
    @FXML
    private Circle circulo;
    @FXML
    private Button cambiarColorCirculo;

    private final ObjectProperty<Color> propiedadColor = new SimpleObjectProperty<>(Color.RED);

    public ColorCirculoControl(){
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("color-circulo-control.fxml")
        );
        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el FXML", e);
        }
        inicializar();
    }

    private void inicializar(){
        circulo.setFill(propiedadColor.get());
        cambiarColorCirculo.setOnAction(e -> cambiarColor());

        propiedadColor.addListener((obs, oldColor, newColor) ->
                animarColor(oldColor, newColor));
    }

    public void cambiarColor(){
        Color newColor = propiedadColor.get().equals(Color.RED) ? Color.BLUE : Color.RED;

        setColor(newColor);
        fireEvent(new ColorChangedEvent(newColor));
    }

    private void animarColor(Color from, Color to){
        FillTransition transition = new FillTransition(
                Duration.millis(400),
                circulo,
                from,
                to
        );

        transition.play();
    }

    //------- Propiedades --------
    public Color getColor(){
        return propiedadColor.get();
    }

    public void setColor(Color color){
        propiedadColor.set(color);
    }

    public ObjectProperty<Color> propiedadColor(){
        return propiedadColor;
    }

}

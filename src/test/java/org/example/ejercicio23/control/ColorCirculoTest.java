package org.example.ejercicio23.control;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorCirculoTest extends ApplicationTest {

    @Test
    void testColorInicial(){
        ColorCirculoControl control = new ColorCirculoControl();
        assertEquals(Color.RED, control.getColor(), "El color inicial es rojo");
    }

    @Test
    void testCambiarColor(){
        ColorCirculoControl control = new ColorCirculoControl();
        //Cambiamos el color
        control.setColor(Color.BLUE);
        assertEquals(Color.BLUE, control.getColor(), "El color cambia a azul");
    }

    @Test
    void testEventoColorCambiado(){
        ColorCirculoControl control = new ColorCirculoControl();

        final Color[] eventoRecibido = new Color[1];

        //Registramos los listener del evento
        control.addEventHandler(ColorChangedEvent.COLOR_CHANGED, event ->{
            eventoRecibido[0] = event.getNewColor();
        });

        //Cambiamos de color
        control.cambiarColor();

        assertEquals(Color.BLUE, eventoRecibido[0], "El evento notifica el nuevo color");
    }
}

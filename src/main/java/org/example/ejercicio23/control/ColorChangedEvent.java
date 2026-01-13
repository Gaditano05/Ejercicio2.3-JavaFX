package org.example.ejercicio23.control;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.paint.Color;

public class ColorChangedEvent extends Event {
    public static final EventType<ColorChangedEvent> COLOR_CHANGED = new EventType<>(Event.ANY, "COLOR_CHANGED");

    private final Color newColor;

    public ColorChangedEvent(Color newColor){
        super(COLOR_CHANGED);
        this.newColor = newColor;
    }

    public Color getNewColor(){
        return newColor;
    }

}

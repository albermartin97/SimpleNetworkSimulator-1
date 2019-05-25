package simulator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import objects.Red;

public class Simulator implements Serializable {

    private Red red;

    //CONSTRUCTOR
    public Simulator() {
        this.red = new Red();
    }
    //GETTERS AND SETTERS

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }

    //METHODS
    public List<Event> play() {
        List<Event> eventos = new ArrayList<>();
        eventos.addAll(red.sendPackages());
        Collections.sort(eventos, new Event());
        return eventos;
    }
    public List<Event> play(BigDecimal time) {
        List<Event> eventos = new ArrayList<>();
        eventos.addAll(red.sendPackages(time));
        Collections.sort(eventos, new Event());
        return eventos;
    }
    public List<Event> playOneStep(int i) {
        List<Event> eventos = new ArrayList<>();
        eventos.addAll(red.sendNextPackages(i));
        Collections.sort(eventos, new Event());
        return eventos;
    }
    public String showTrace(List<Event> trace) {
        String s = "";
        for (Event e : trace) {
            if (e != null) {
                s = s + "\n" + e.toString();
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return "Simulator{" + "red=" + red + '}';
    }

}

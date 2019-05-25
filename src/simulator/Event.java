package simulator;

import java.math.BigDecimal;
import java.util.Comparator;
import objects.Node;

public class Event implements Comparator<Event> {

    private BigDecimal time;
    private String mensaje;
    private Node host;

    public Event() {

    }

    public Event(BigDecimal time, String mensaje, Node host) {
        this.time = time;
        this.mensaje = mensaje;
        this.host = host;
    }

    //GETTERS AND SETTERS
    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Node getHost() {
        return host;
    }

    public void setHost(Node h) {
        this.host = h;
    }
    @Override
    public int compare(Event e1, Event e2) {
        return e1.getTime().compareTo(e2.getTime());
    }

    @Override
    public String toString() {
        return "T = " + getTime() + " MENSAJE: " + getMensaje();

    }
}

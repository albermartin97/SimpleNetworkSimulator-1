package simulator;

import java.math.BigDecimal;
import java.util.Comparator;
import objects.Linker;
import objects.Node;

public class Event implements Comparator<Event> {

    private BigDecimal time;
    private String mensaje;
    private Node hostOrigen;
    private Node hostDestino;
    private Linker linker;
    private BigDecimal instant;
    

    public Event() {

    }

    public Event(BigDecimal time, String mensaje, Node hostOrigen, Node hostDestino, Linker linker, BigDecimal instant) {
        this.time = time;
        this.mensaje = mensaje;
        this.hostOrigen = hostOrigen;
        this.hostDestino = hostDestino;
        this.linker = linker;
        this.instant = instant;
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

    public Node getHostOrigen() {
        return hostOrigen;
    }

    public void setHostOrigen(Node hostOrigen) {
        this.hostOrigen = hostOrigen;
    }

    public Node getHostDestino() {
        return hostDestino;
    }

    public void setHostDestino(Node hostDestino) {
        this.hostDestino = hostDestino;
    }

    public Linker getLinker() {
        return linker;
    }

    public void setLinker(Linker linker) {
        this.linker = linker;
    }

    public BigDecimal getInstant() {
        return instant;
    }

    public void setInstant(BigDecimal instant) {
        this.instant = instant;
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

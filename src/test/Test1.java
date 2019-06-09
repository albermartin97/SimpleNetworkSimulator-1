package test;

import java.math.BigDecimal;
import java.util.List;

import material.graphs.Edge;
import material.graphs.Vertex;
import objects.Host;
import objects.Linker;
import objects.Router;
import simulator.Event;
import simulator.Simulator;
import objects.Node;

public class Test1 {

    public static void main(String[] args) {
        Simulator s = new Simulator();

        //Computers
        Host h1 = new Host("C1");
        Host h2 = new Host("C2");
        Host h3 = new Host("C3");

        Vertex<Node> c1 = s.getRed().addComputer(h1);
        Vertex<Node> c2 = s.getRed().addComputer(h2);
        Vertex<Node> c3 = s.getRed().addComputer(h3);

        //Routers
        Router h4 = new Router("R1");
        Vertex<Node> r1 = s.getRed().addRouter(h4);

        //Conexiones
        Edge<Linker> l1 = s.getRed().connect(c1, r1, "1", new BigDecimal("5.0"), new BigDecimal("10.0"));
        Edge<Linker> l2 = s.getRed().connect(c2, r1, "2", new BigDecimal("2.0"), new BigDecimal("100.0"));
        Edge<Linker> l3 = s.getRed().connect(c3, r1, "3", new BigDecimal("5.0"), new BigDecimal("12.0"));

        //Tablas de enrutamientos
        //R1
        h4.enrutar(c3, l3);
        h4.enrutar(c1, l1);
        h4.enrutar(c2, l2);

        //Ejecuci�n
        List<Event> trace = s.play(new BigDecimal("5.0"));
        s.showTrace(trace);
    }

}

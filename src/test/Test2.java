package test;

import java.util.List;

import material.graphs.Edge;
import material.graphs.Vertex;
import objects.Host;
import objects.Package;
import objects.Linker;
import objects.Router;
import simulator.Event;
import simulator.Simulator;
import objects.Node;

public class Test2 {

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
        Router h5 = new Router("R2");
        Router h6 = new Router("R3");
        Vertex<Node> r1 = s.getRed().addRouter(h4);
        Vertex<Node> r2 = s.getRed().addRouter(h5);
        Vertex<Node> r3 = s.getRed().addRouter(h6);

        //Conexiones
        /*Edge<Linker> l1 = s.getRed().connect(c1, r1, "1", 5.0f, 10.0f);
        Edge<Linker> l2 = s.getRed().connect(c2, r2, "2", 3.0f, 50.0f);
        Edge<Linker> l3 = s.getRed().connect(c3, r3, "3", 7.0f, 5.0f);
        Edge<Linker> l4 = s.getRed().connect(r1, r2, "4", 2.0f, 7.0f);
        Edge<Linker> l5 = s.getRed().connect(r2, r3, "5", 1.0f, 2.0f);
        Edge<Linker> l6 = s.getRed().connect(r1, r3, "6", 100.0f, 3.0f);*/

        //Tablas de enrutamientos
        //R1
        /*h4.enrutar(c3, l6);
        h4.enrutar(c1, l1);
        h4.enrutar(c2, l4);

        //R2
        h5.enrutar(c3, l5);
        h5.enrutar(c1, l4);
        h5.enrutar(c2, l2);

        //R3
        h6.enrutar(c3, l3);
        h6.enrutar(c1, l6);
        h6.enrutar(c2, l5);

        Float size = 200.0f;
        h1.addPackage(new Package(size, c2));
        h2.addPackage(new Package(size, c3));
        //Ejecuci�n
        //List<Event> trace = s.playOneStep();
        //String t = s.showTrace(trace);
        //t += s.showTrace(s.playOneStep());
        //System.err.println(t);*/
    }

}

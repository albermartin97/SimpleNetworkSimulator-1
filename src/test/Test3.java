package test;

import java.util.List;

import material.graphs.Edge;
import material.graphs.Vertex;
import objects.Host;
import objects.Linker;
import objects.Router;
import simulator.Event;
import simulator.Simulator;
import objects.Node;

public class Test3 {

	public static void main(String[] args) {
		Simulator s = new Simulator();
		
		//Computers
		Host c1 = new Host("C1");
		Host c2 = new Host("C2");
		Host c3 = new Host("C3");
		Host c4 = new Host("C4");
		Host c5 = new Host("C5");
		Vertex<Node> h1 = s.getRed().addComputer(c1);
		Vertex<Node> h5 = s.getRed().addComputer(c3);
		Vertex<Node> h7 = s.getRed().addComputer(c4);
		Vertex<Node> h8 = s.getRed().addComputer(c5);
		Vertex<Node> h2 = s.getRed().addComputer(c2);
		
		
		//Routers
		Router r1 = new Router("R1");
		Router r2 = new Router("R2");
		Router r3 = new Router("R3");
		Vertex<Node> h3 = s.getRed().addRouter(r1);
		Vertex<Node> h4 =s.getRed().addRouter(r2);
		Vertex<Node> h6 =s.getRed().addRouter(r3);

		
		//Conexiones
		/*Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", 5.0f,10.0f);
		Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", 3.0f,50.0f);
		Edge<Linker> l3 = s.getRed().connect(h4, h2, "3", 7.0f,5.0f);
		Edge<Linker> l4 = s.getRed().connect(h5, h3, "4", 2.0f,7.0f);
		Edge<Linker> l5 = s.getRed().connect(h4, h6, "5", 1.0f,2.0f);
		Edge<Linker> l6 = s.getRed().connect(h6, h7, "6", 100.0f,3.0f);
		Edge<Linker> l7 = s.getRed().connect(h6, h8, "7", 8.0f,5.0f);

		
		//Tablas de enrutamientos
		r1.enrutar(h2, l2);
		r1.enrutar(h1, l1);
		r1.enrutar(h5, l4);
		r1.enrutar(h7, l2);
		r1.enrutar(h8, l2);
		
		r2.enrutar(h2, l3);
		r2.enrutar(h1, l2);
		r2.enrutar(h5, l2);
		r2.enrutar(h7, l5);
		r2.enrutar(h8, l5);
		
		r3.enrutar(h2, l5);
		r3.enrutar(h1, l5);
		r3.enrutar(h5, l5);
		r3.enrutar(h7, l6);
		r3.enrutar(h8, l7);
	
		/List<Event> trace = s.play(5.0f);		
		s.showTrace(trace);*/
	}

}

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

public class TestExamen {

	public static void main(String[] args) {
		Simulator s = new Simulator();
		
		//Computers
		Host c1 = new Host("C1");
		Host c2 = new Host("C2");
		Vertex<Node> h1 = s.getRed().addComputer(c1);
		Vertex<Node> h2 = s.getRed().addComputer(c2);
		
		
		//Routers
		Router r1 = new Router("R1");
		Router r2 = new Router("R2");
		Vertex<Node> h3 = s.getRed().addRouter(r1);
		Vertex<Node> h4 = s.getRed().addRouter(r2);

		
		//Conexiones
		//Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", 5000.0f,10000.0f);
		//Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", 5000.0f,10000.0f);
		
		/*INICIO OPCION A*/
		/*Edge<Linker> l3 = s.getRed().connect(h4, h2, "3", 5000.0f,10000.0f);
		Float size = 5000.0f;
		for(int i = 0; i < 6; i++){
			c1.addPackage(new Package(size,h2));
		}*/
		/*FIN OPCION A*/
		
		/*INICIO OPCION B*/
		/*Edge<Linker> l3 = s.getRed().connect(h4, h2, "3", 5000.0f,10000.0f);
		Float size = 30000.0f;
		c1.addPackage(new Package(size,h2));*/
		/*FIN OPCION B*/
		
		/*INICIO OPCION C CON RETARDOS*/
		//Edge<Linker> l3 = s.getRed().connect(h4, h2, "3", 1000.0f,10000.0f);
		/*Float size = 5000.0f;
		for(int i = 0; i < 6; i++){
			c1.addPackage(new Package(size,h2));
			c2.addPackage(new Package(size,h1));
		}*/
		/*FIN OPCION C CON RETARDOS*/
		
		/*INICIO ENVIO ALEATORIO*/
		//c1.setRandomSend(50000.0f, 5.0f);
		//c2.setRandomSend(40000.0f, 10.0f);
		/*FIN ENVIO ALEATORIO*/
		
		
		//Tablas de enrutamientos
		/*r1.enrutar(h2, l2);
		r1.enrutar(h1, l1);
		
		r2.enrutar(h2, l3);
		r2.enrutar(h1, l2);
		
	
		List<Event> trace = s.play(100.0f);		
		s.showTrace(trace);*/
	}

}

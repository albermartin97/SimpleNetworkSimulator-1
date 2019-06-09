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

public class TestsExamenes {
	/*public static void main(String[] args) {
		Simulator s = new Simulator();
		configuracionMarzo2018(s);
		List<Event> trace = s.play(150.0f);		
		s.showTrace(trace);
	}
	private static void configuracionMarzo2016(Simulator s){
		//Computers
		Host c1 = new Host("C1");
		Host c2 = new Host("C2");
		Vertex<Node> h1 = s.getRed().addComputer(c1);
		Vertex<Node> h2 = s.getRed().addComputer(c2);
		
		//Routers
		Router r1 = new Router("R1");
		Router r2 = new Router("R2");
		Router r3 = new Router("R3");
		Vertex<Node> h3 = s.getRed().addRouter(r1);
		Vertex<Node> h4 = s.getRed().addRouter(r2);
		Vertex<Node> h5 = s.getRed().addRouter(r3);
		
		//Linkers
		Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", 20000.0f,2000.0f);
		Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", 10000.0f,2000.0f);
		Edge<Linker> l3 = s.getRed().connect(h4, h5, "3", 10000.0f,2000.0f);
		Edge<Linker> l4 = s.getRed().connect(h5, h2, "4", 1000.0f,2000.0f);
		
		
		for(int i = 0; i < 5; i++)
			c1.addPackage(new Package(20000.0f, h2));
		
		//Enrutar
		r1.enrutar(h2, l2);
		
		r2.enrutar(h2, l3);
		
		r3.enrutar(h2, l4);
	}
	private static void configuracionMayo2016(Simulator s){
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
		
		//Linkers
		Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", 10000.0f,1000.0f);
		Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", 1000.0f,1000.0f);
		Edge<Linker> l3 = s.getRed().connect(h4, h2, "4", 5000.0f,1000.0f);
		
		
		for(int i = 0; i < 5; i++)
			c1.addPackage(new Package(5000.0f, h2));
		
		//Enrutar
		r1.enrutar(h2, l2);
		
		r2.enrutar(h2, l3);
		
	}
	private static void configuracionFebrero2017(Simulator s){
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
		
		//Linkers
		Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", 2000.0f,1000.0f);
		Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", 1000.0f,1000.0f);
		Edge<Linker> l3 = s.getRed().connect(h4, h2, "4", 4000.0f,1000.0f);
		
		
		for(int i = 0; i < 4; i++)
			c1.addPackage(new Package(4000.0f, h2));
		
		//Enrutar
		r1.enrutar(h2, l2);
		
		r2.enrutar(h2, l3);
		
	}
	private static void configuracionJunio2016(Simulator s){
		//Computers
		Host c1 = new Host("C1");
		Host c2 = new Host("C2");
		Vertex<Node> h1 = s.getRed().addComputer(c1);
		Vertex<Node> h2 = s.getRed().addComputer(c2);
		
		//Routers
		Router r1 = new Router("R1");
		Router r2 = new Router("R2");
		Router r3 = new Router("R3");
		Vertex<Node> h3 = s.getRed().addRouter(r1);
		Vertex<Node> h4 = s.getRed().addRouter(r2);
		Vertex<Node> h5 = s.getRed().addRouter(r3);
		
		//Linkers
		Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", 10000.0f,1000.0f);
		Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", 50000.0f,4000.0f);
		Edge<Linker> l3 = s.getRed().connect(h4, h5, "3", 20000.0f,4000.0f);
		Edge<Linker> l4 = s.getRed().connect(h5, h2, "4", 10000.0f,1000.0f);
		
		
		for(int i = 0; i < 7; i++)
			c1.addPackage(new Package(5000.0f, h2));
		
		//Ejercicio d)
			//c1.addPackage(new Package(35000.0f, h2));
		//Enrutar
		r1.enrutar(h2, l2);
		
		r2.enrutar(h2, l3);
		
		r3.enrutar(h2, l4);
	}
	private static void configuracionJunio2017(Simulator s){
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
		
		//Linkers
		Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", 10000.0f,1000.0f);
		Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", 20000.0f,2000.0f);
		Edge<Linker> l3 = s.getRed().connect(h4, h2, "4", 5000.0f,1000.0f);
		
		
		c1.addPackage(new Package(4000.0f, h2));
		c1.addPackage(new Package(6000.0f, h2));
		c1.addPackage(new Package(3000.0f, h2));
		
		//Enrutar
		r1.enrutar(h2, l2);
		
		r2.enrutar(h2, l3);
		
	}
	private static void configuracionJunio2018(Simulator s){
		//Computers
		Host c1 = new Host("C1");
		Host c2 = new Host("C2");
		Host c3 = new Host("C3");
		Vertex<Node> h1 = s.getRed().addComputer(c1);
		Vertex<Node> h2 = s.getRed().addComputer(c2);
		Vertex<Node> h3 = s.getRed().addComputer(c3);
		
		//Routers
		Router r1 = new Router("R1");
		Router r2 = new Router("R2");
		Router r3 = new Router("R3");
		Router r4 = new Router("R4");
		Vertex<Node> h4 = s.getRed().addRouter(r1);
		Vertex<Node> h5 = s.getRed().addRouter(r2);
		Vertex<Node> h6 = s.getRed().addRouter(r3);
		Vertex<Node> h7 = s.getRed().addRouter(r4);
		
		//Linkers
		Edge<Linker> l1 = s.getRed().connect(h1, h6, "1", 1000.0f,100.0f);
		Edge<Linker> l2 = s.getRed().connect(h6, h5, "2", 20000.0f,10000.0f);
		Edge<Linker> l3 = s.getRed().connect(h6, h7, "3", 10000.0f,10000.0f);
		Edge<Linker> l4 = s.getRed().connect(h5, h4, "4", 5000.0f,1000.0f);
		Edge<Linker> l5 = s.getRed().connect(h4, h2, "5", 1000.0f,100.0f);
		Edge<Linker> l6 = s.getRed().connect(h7, h3, "6", 1000.0f,100.0f);
		
		
		for(int i = 0; i < 1; i++)
			c1.addPackage(new Package(1.0f, h2));
		
		Package p = new Package(2000.0f,h1);
		p.setTime(0.002306f);
		c2.addPackage(p);
		//Enrutar
		r1.enrutar(h2, l5);
		r1.enrutar(h1, l4);
		
		r2.enrutar(h2, l4);
		r2.enrutar(h1, l2);
		
		r3.enrutar(h2, l2);
		r3.enrutar(h3, l3);
		r3.enrutar(h1, l1);
		
		r4.enrutar(h3, l6);
	}
	private static void configuracionMarzo2018(Simulator s){
		//Computers
		Host c1 = new Host("C1");
		Host c2 = new Host("C2");
		Host c3 = new Host("C3");
		Vertex<Node> h1 = s.getRed().addComputer(c1);
		Vertex<Node> h2 = s.getRed().addComputer(c2);
		Vertex<Node> h3 = s.getRed().addComputer(c3);
		
		//Routers
		Router r1 = new Router("R1");
		Router r2 = new Router("R2");
		Router r3 = new Router("R3");
		Vertex<Node> h4 = s.getRed().addRouter(r1);
		Vertex<Node> h5 = s.getRed().addRouter(r2);
		Vertex<Node> h6 = s.getRed().addRouter(r3);
		
		//Linkers
		Edge<Linker> l1 = s.getRed().connect(h1, h4, "1", 20000.0f,1000.0f);
		Edge<Linker> l2 = s.getRed().connect(h4, h5, "2", 10000.0f,5000.0f);
		Edge<Linker> l3 = s.getRed().connect(h5, h6, "3", 10000.0f,5000.0f);
		Edge<Linker> l4 = s.getRed().connect(h5, h3, "4", 5000.0f,2000.0f);
		Edge<Linker> l5 = s.getRed().connect(h6, h2, "5", 20000.0f,1000.0f);
		
		
		for(int i = 0; i < 3; i++)
			c1.addPackage(new Package(10000.0f, h2));
		for(int i = 0; i < 4; i++)
			c1.addPackage(new Package(5000.0f, h3));
		
		//Enrutar
		r1.enrutar(h2, l2);
		r1.enrutar(h3, l2);
		
		r2.enrutar(h2, l3);
		r2.enrutar(h3, l4);
		
		r3.enrutar(h2, l5);
		
	}*/
}

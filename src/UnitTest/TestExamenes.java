/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import java.math.BigDecimal;
import java.util.List;
import material.graphs.Edge;
import material.graphs.Vertex;
import objects.Host;
import objects.Linker;
import objects.Node;
import objects.Router;
import objects.Package;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import simulator.Event;
import simulator.Simulator;

/**
 *
 * @author alber
 */
public class TestExamenes {

    private static Simulator s;

    public TestExamenes() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        s = new Simulator();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMarzo2016() {
        configuracionMarzo2016(s);
        List<Event> trace = s.play();
        Event e = trace.get(trace.size() - 1);
        assertEquals(new BigDecimal("105.000040"), e.getTime());
    }
    @Test
    public void testMayo2016() {
        configuracionMayo2016(s);
        List<Event> trace = s.play();
        Event e = trace.get(trace.size() - 1);
        assertEquals(new BigDecimal("26.500015"), e.getTime());
    }
    @Test
    public void testFebrero2017() {
        configuracionFebrero2017(s);
        List<Event> trace = s.play();
        Event e = trace.get(trace.size() - 1);
        assertEquals(new BigDecimal("19.000015"), e.getTime());
    }
    @Test
    public void testJunio2016() {
        configuracionJunio2016(s);
        List<Event> trace = s.play();
        Event e = trace.get(trace.size() - 1);
        assertEquals(new BigDecimal("4.350050"), e.getTime());
    }
    
    @Test
    public void testJunio2017() {
        configuracionJunio2017(s);
        List<Event> trace = s.play();
        Event e = trace.get(trace.size() - 1);
        assertEquals(new BigDecimal("3.100020"), e.getTime());
    }
    @Test
    public void testJunio2018() {
        configuracionJunio2018(s);
        List<Event> trace = s.play();
        Event e = trace.get(trace.size() - 1);
        assertEquals(new BigDecimal("4.502363"), e.getTime());
    }
    @Test
    public void testMarzo2018() {
        configuracionMarzo2018(s);
        List<Event> trace = s.play();
        Event e = trace.get(trace.size() - 1);
        assertEquals(new BigDecimal("8.500040"), e.getTime());
    }
    
    private static void configuracionMarzo2016(Simulator s) {
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
        Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", new BigDecimal("20000.0"), new BigDecimal("2000.0"));
        Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", new BigDecimal("10000.0"), new BigDecimal("2000.0"));
        Edge<Linker> l3 = s.getRed().connect(h4, h5, "3", new BigDecimal("10000.0"), new BigDecimal("2000.0"));
        Edge<Linker> l4 = s.getRed().connect(h5, h2, "4", new BigDecimal("1000.0"), new BigDecimal("2000.0"));

        for (int i = 0; i < 5; i++) {
            c1.addPackage(new Package(new BigDecimal("20000.0"), h2));
        }

        //Enrutar
        r1.enrutar(h2, l2);

        r2.enrutar(h2, l3);

        r3.enrutar(h2, l4);
    }

    private static void configuracionMayo2016(Simulator s) {
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
        Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", new BigDecimal("10000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", new BigDecimal("1000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l3 = s.getRed().connect(h4, h2, "4", new BigDecimal("5000.0"), new BigDecimal("1000.0"));

        for (int i = 0; i < 5; i++) {
            c1.addPackage(new Package(new BigDecimal("5000.0"), h2));
        }

        //Enrutar
        r1.enrutar(h2, l2);

        r2.enrutar(h2, l3);

    }

    private static void configuracionFebrero2017(Simulator s) {
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
        Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", new BigDecimal("2000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", new BigDecimal("1000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l3 = s.getRed().connect(h4, h2, "4", new BigDecimal("4000.0"), new BigDecimal("1000.0"));

        for (int i = 0; i < 4; i++) {
            c1.addPackage(new Package(new BigDecimal("4000.0"), h2));
        }

        //Enrutar
        r1.enrutar(h2, l2);

        r2.enrutar(h2, l3);

    }

    private static void configuracionJunio2016(Simulator s) {
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
        Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", new BigDecimal("10000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", new BigDecimal("50000.0"), new BigDecimal("4000.0"));
        Edge<Linker> l3 = s.getRed().connect(h4, h5, "3", new BigDecimal("20000.0"), new BigDecimal("4000.0"));
        Edge<Linker> l4 = s.getRed().connect(h5, h2, "4", new BigDecimal("10000.0"), new BigDecimal("1000.0"));

        for (int i = 0; i < 7; i++) {
            c1.addPackage(new Package(new BigDecimal("5000.0"), h2));
        }

        //Ejercicio d)
        //c1.addPackage(new Package(35000.0f, h2));
        //Enrutar
        r1.enrutar(h2, l2);

        r2.enrutar(h2, l3);

        r3.enrutar(h2, l4);
    }

    private static void configuracionJunio2017(Simulator s) {
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
        Edge<Linker> l1 = s.getRed().connect(h1, h3, "1", new BigDecimal("10000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l2 = s.getRed().connect(h3, h4, "2", new BigDecimal("20000.0"), new BigDecimal("2000.0"));
        Edge<Linker> l3 = s.getRed().connect(h4, h2, "4", new BigDecimal("5000.0"), new BigDecimal("1000.0"));

        c1.addPackage(new Package(new BigDecimal("4000.0"), h2));
        c1.addPackage(new Package(new BigDecimal("6000.0"), h2));
        c1.addPackage(new Package(new BigDecimal("3000.0"), h2));

        //Enrutar
        r1.enrutar(h2, l2);

        r2.enrutar(h2, l3);

    }

    private static void configuracionJunio2018(Simulator s) {
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
        Edge<Linker> l1 = s.getRed().connect(h1, h6, "1", new BigDecimal("1000.0"), new BigDecimal("100.0"));
        Edge<Linker> l2 = s.getRed().connect(h6, h5, "2", new BigDecimal("20000.0"), new BigDecimal("10000.0"));
        Edge<Linker> l3 = s.getRed().connect(h6, h7, "3", new BigDecimal("10000.0"), new BigDecimal("10000.0"));
        Edge<Linker> l4 = s.getRed().connect(h5, h4, "4", new BigDecimal("5000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l5 = s.getRed().connect(h4, h2, "5", new BigDecimal("1000.0"), new BigDecimal("100.0"));
        Edge<Linker> l6 = s.getRed().connect(h7, h3, "6", new BigDecimal("1000.0"), new BigDecimal("100.0"));

        for (int i = 0; i < 1; i++) {
            c1.addPackage(new Package(new BigDecimal("1.0"), h2));
        }

        Package p = new Package(new BigDecimal("2000.0"), h1);
        p.setTime(new BigDecimal("0.002306"));
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

    private static void configuracionMarzo2018(Simulator s) {
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
        Edge<Linker> l1 = s.getRed().connect(h1, h4, "1", new BigDecimal("20000.0"), new BigDecimal("1000.0"));
        Edge<Linker> l2 = s.getRed().connect(h4, h5, "2", new BigDecimal("10000.0"), new BigDecimal("5000.0"));
        Edge<Linker> l3 = s.getRed().connect(h5, h6, "3", new BigDecimal("10000.0"), new BigDecimal("5000.0"));
        Edge<Linker> l4 = s.getRed().connect(h5, h3, "4", new BigDecimal("5000.0"), new BigDecimal("2000.0"));
        Edge<Linker> l5 = s.getRed().connect(h6, h2, "5", new BigDecimal("20000.0"), new BigDecimal("1000.0"));

        for (int i = 0; i < 3; i++) {
            c1.addPackage(new Package(new BigDecimal("10000.0"), h2));
        }
        for (int i = 0; i < 4; i++) {
            c1.addPackage(new Package(new BigDecimal("5000.0"), h3));
        }

        //Enrutar
        r1.enrutar(h2, l2);
        r1.enrutar(h3, l2);

        r2.enrutar(h2, l3);
        r2.enrutar(h3, l4);

        r3.enrutar(h2, l5);

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

package objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import simulator.Event;
import material.graphs.ALGraph;
import material.graphs.Edge;
import material.graphs.Vertex;

public class Red implements Serializable {

    private static BigDecimal velocidadCable = new BigDecimal("200000000"); // Unidad : m/s
    private Random r = new Random();

    private ALGraph<Node, Linker> red;
    private HashMap<String, Node> hosts;
    private ArrayList<NodeState> queueStates;

    // CONTRUCTORS
    public Red() {
        this.red = new ALGraph<>();
        this.hosts = new HashMap<>();
        this.queueStates = new ArrayList<>();
    }

    // GETTERS AND SETTERS
    public ALGraph<Node, Linker> getRed() {
        return red;
    }

    public void setRed(ALGraph<Node, Linker> red) {
        this.red = red;
    }

    public HashMap<String, Node> getHosts() {
        return hosts;
    }

    public void setHosts(HashMap<String, Node> hosts) {
        this.hosts = hosts;
    }

    /*
	 * CONECTION METHODS
     */
    public Vertex<Node> addComputer(Host c1) {
        hosts.put(c1.getName(), c1);
        return red.insertVertex(c1);
    }

    public Vertex<Node> addRouter(Router r1) {
        hosts.put(r1.getName(), r1);
        return red.insertVertex(r1);
    }

    public void removeHost(Vertex<Node> vh) {
        hosts.remove(vh.getElement().getName());
        Collection<Edge<Linker>> list = (Collection<Edge<Linker>>) red.incidentEdges(vh);
        red.removeVertex(vh);
    }
    public void removeLinker(Edge<Linker> vl) {
        red.removeEdge(vl);
    }
    public Edge<Linker> connect(Vertex<Node> h1, Vertex<Node> h2, String ip,
            BigDecimal speed, BigDecimal distance) {
        Linker l = new Linker();
        l.setIp(ip);
        l.setSpeed(speed);
        l.setDistance(distance);
        return red.insertEdge(h1, h2, l);
    }

    /*
	 * CONECTION METHODS END
     */

 /*
	 * RANDOM PACKAGE SENDS
     */
    public List<Event> sendPackages(BigDecimal time) {
        List<Event> eventos = new ArrayList<>();
        queueStates.addAll(getRandomConfig(time));
        queueStates.addAll(getFirstPackageToSend());
        List<Vertex<Node>> listHost = getHosts(queueStates);
        Vertex<Node> h;
        List<State> states;
        State state1 = null;
        State state2 = null;
        while (!queueStates.isEmpty()) {
            // Se coloca la cola seg�n el tiempo que tengan
            Collections.sort(queueStates);
            // Se coge el host que menos tiempo tiene y se actualiza la lista de
            // hosts
            h = queueStates.remove(0).getHost();
            listHost.remove(h);

            // Se empieza con el envio
            if (h != null) {
                // Se envia el paquete y se recogen los estados que devuelve
                states = sendPackage(h);
                if (!states.isEmpty()) {
                    state1 = states.get(0);
                }
                if (states.size() > 1) {
                    state2 = states.get(1);
                }

                // Se procesan los estados y se actualiza la cola si es
                // necesario
                if (state1 != null && state1.getHost() != null) {
                    eventos.add(state1.getEventTransmission());
                    eventos.add(state1.getEventTransport());
                    if (!listHost.contains(state1.getHost())) {
                        queueStates.add(new NodeState(state1.getHost(), state1
                                .getEventTransport().getTime()));
                        listHost.add(state1.getHost());
                    } else {
                        updateState(queueStates, state1.getHost());
                    }
                }
                if (state2 != null && state2.getHost() != null) {
                    if (!listHost.contains(state2.getHost())) {
                        queueStates.add(new NodeState(state2.getHost(), state2
                                .getEventTransport().getTime()));
                        listHost.add(state2.getHost());
                    } else {
                        updateState(queueStates, state2.getHost());
                    }
                }
                state2 = null;
                state1 = null;
            }
        }
        return eventos;
    }

    /*
	 *FIN RANDOM PACKAGE SENDS
     */
 /*
        INICIO ENRUTAMIENTO AUTOMATICO
     */
    public Edge<Linker> getEnrutamiento(Vertex<Node> host, Vertex<Node> router) {
        ArrayList<Vertex<Node>> queueNodes = new ArrayList<>();
        ArrayList<Edge<Linker>> queueLinkers = new ArrayList<>();
        ArrayList<Edge<Linker>> listNodesChecked = new ArrayList<>();
        queueNodes.add(router);
        Vertex<Node> nextNode;
        Vertex<Node> node;
        Edge<Linker> linker = null;
        boolean encontrado = false;
        while (!queueNodes.isEmpty() && !encontrado) {
            nextNode = queueNodes.remove(0);
            if (!queueLinkers.isEmpty()) {
                linker = queueLinkers.remove(0);
            }
            for (Edge<Linker> l : this.red.incidentEdges(nextNode)) {
                if (nextNode == router) {
                    node = this.red.opposite(nextNode, l);
                    if (node == host) {
                        encontrado = true;
                        linker = l;
                    } else {
                        queueNodes.add(node);
                        queueLinkers.add(l);
                        listNodesChecked.add(l);
                    }
                } else {
                    if (!listNodesChecked.contains(l)) {
                        node = this.red.opposite(nextNode, l);
                        if (node == host) {
                            encontrado = true;
                        } else {
                            queueNodes.add(node);
                            queueLinkers.add(linker);
                            listNodesChecked.add(l);
                        }
                    }
                }
            }
        }
        if (encontrado) {
            return linker;
        } else {
            return null;
        }
    }

    /*
        FIN ENRUTAMIENTO AUTOMATICO
     */
 /*
        INICIO ENVIO PAQUETES STEP BY STEP
     */
    public List<Event> sendNextPackages(int i) {
        List<Event> eventos = new ArrayList<>();
        queueStates.addAll(getRandomConfig());
        if (i == 0) {
            queueStates.addAll(getFirstPackageToSend());
        }
        List<Vertex<Node>> listHost = getHosts(queueStates);
        Vertex<Node> h;
        List<State> states;
        State state1 = null;
        State state2 = null;
        while (eventos.size() < 4 && !queueStates.isEmpty()) {
            // Se coloca la cola seg�n el tiempo que tengan
            Collections.sort(queueStates);
            // Se coge el host que menos tiempo tiene y se actualiza la lista de
            // hosts
            h = queueStates.remove(0).getHost();
            listHost.remove(h);

            // Se empieza con el envio
            if (h != null) {
                // Se envia el paquete y se recogen los estados que devuelve
                states = sendPackage(h);
                if (!states.isEmpty()) {
                    state1 = states.get(0);
                }
                if (states.size() > 1) {
                    state2 = states.get(1);
                }

                // Se procesan los estados y se actualiza la cola si es
                // necesario
                if (state1 != null && state1.getHost() != null) {
                    eventos.add(state1.getEventTransmission());
                    eventos.add(state1.getEventTransport());
                    if (!listHost.contains(state1.getHost())) {
                        queueStates.add(new NodeState(state1.getHost(), state1
                                .getEventTransport().getTime()));
                        listHost.add(state1.getHost());
                    } else {
                        updateState(queueStates, state1.getHost());
                    }
                }
                if (state2 != null && state2.getHost() != null) {
                    if (!listHost.contains(state2.getHost())) {
                        queueStates.add(new NodeState(state2.getHost(), state2
                                .getEventTransport().getTime()));
                        listHost.add(state2.getHost());
                    } else {
                        updateState(queueStates, state2.getHost());
                    }
                }
                state2 = null;
                state1 = null;
            }
        }

        return eventos;
    }

    /*
        FIN ENVIO PAQUETES STEP BY STEP
     */
 /*
	 * INICIO PACKAGE SENDS ENVIO TOTAL SIN ENVIOS ALEATORIOS
     */
    public List<Event> sendPackages() {
        List<Event> eventos = new ArrayList<>();
        ArrayList<NodeState> queueStates = new ArrayList<>();
        queueStates.addAll(getFirstPackageToSend());
        List<Vertex<Node>> listHost = getHosts(queueStates);
        Vertex<Node> h;
        List<State> states;
        State state1 = null;
        State state2 = null;
        while (!queueStates.isEmpty()) {
            // Se coloca la cola seg�n el tiempo que tengan
            Collections.sort(queueStates);
            // Se coge el host que menos tiempo tiene y se actualiza la lista de
            // hosts
            h = queueStates.remove(0).getHost();
            listHost.remove(h);

            // Se empieza con el envio
            if (h != null) {
                // Se envia el paquete y se recogen los estados que devuelve
                states = sendPackage(h);
                if (!states.isEmpty()) {
                    state1 = states.get(0);
                }
                if (states.size() > 1) {
                    state2 = states.get(1);
                }

                // Se procesan los estados y se actualiza la cola si es
                // necesario
                if (state1 != null && state1.getHost() != null) {
                    eventos.add(state1.getEventTransmission());
                    eventos.add(state1.getEventTransport());
                    if (!listHost.contains(state1.getHost())) {
                        queueStates.add(new NodeState(state1.getHost(), state1
                                .getEventTransport().getTime()));
                        listHost.add(state1.getHost());
                    } else {
                        updateState(queueStates, state1.getHost());
                    }
                }
                if (state2 != null && state2.getHost() != null) {
                    if (!listHost.contains(state2.getHost())) {
                        queueStates.add(new NodeState(state2.getHost(), state2
                                .getEventTransport().getTime()));
                        listHost.add(state2.getHost());
                    } else {
                        updateState(queueStates, state2.getHost());
                    }
                }
                state2 = null;
                state1 = null;
            }
        }

        return eventos;
    }

    /*
	 * FIN PACKAGE SENDS ENVIO TOTAL SIN ENVIOS ALEATORIOS
     */

 /*
        INICIO CONFIGURACIONES RANDOM
     */
    private ArrayList<NodeState> getRandomConfig() {
        ArrayList<NodeState> queueStates = new ArrayList<>();
        List<Vertex<Node>> listComputers = getAllHosts();
        Package p = null;
        Host computer = null;
        for (Vertex<Node> host : listComputers) {
            if (host.getElement() instanceof Host) {
                computer = (Host) host.getElement();
                if (computer.isRandomSend()) {
                    p = getRandomPackage(computer.getRandomSend()
                            .getSizePackage(), host);
                    p.setTime(getRamdonTimePoisson(computer.getRandomSend().getTimeLastPackage().add(computer.getRandomSend()
                            .getAverageTime())));
                    computer.getRandomSend().setTimeLastPackage(computer.getRandomSend().getTimeLastPackage().add(p.getTime()));
                    host.getElement().addPackage(p);
                    NodeState hs = new NodeState(host, p.getTime());
                    queueStates.add(hs);
                }
            }
        }
        return queueStates;
    }

    private ArrayList<NodeState> getRandomConfig(BigDecimal time) {
        ArrayList<NodeState> queue = new ArrayList<>();
        List<Vertex<Node>> listComputers = getAllHosts();
        BigDecimal timeLastEvent = new BigDecimal(0.0);
        Package p = null;
        Host computer = null;
        for (Vertex<Node> host : listComputers) {
            if (host.getElement() instanceof Host) {
                computer = (Host) host.getElement();
                if (computer.isRandomSend()) {
                    while (timeLastEvent.compareTo(time) <= 0) {
                        p = getRandomPackage(computer.getRandomSend()
                                .getSizePackage(), host);
                        p.setTime(getRamdonTimePoisson(computer.getRandomSend().getTimeLastPackage().add(computer.getRandomSend()
                                .getAverageTime())));
                        computer.getRandomSend().setTimeLastPackage(computer.getRandomSend().getTimeLastPackage().add(p.getTime()));
                        if (p.getTime().compareTo(timeLastEvent) > 0) {
                            timeLastEvent = p.getTime();
                            host.getElement().addPackage(p);
                        }
                        NodeState hs = new NodeState(host, p.getTime());
                        queue.add(hs);
                    }
                    timeLastEvent = new BigDecimal(0.0);
                }
            }
        }
        return queue;
    }

    public Package getRandomPackage(BigDecimal sizePackage, Vertex<Node> host) {
        Vertex<Node> randomHost = getRandomComputer(host);
        BigDecimal randomSize = getPackageSize(sizePackage);

        Package p = new Package(randomSize, randomHost);
        return p;
    }

    private BigDecimal getPackageSize(BigDecimal sizePackage) {
        double lambda = 1.0f / sizePackage.doubleValue();
        return new BigDecimal(-(Math.log(r.nextDouble()) / lambda));
    }

    private Vertex<Node> getRandomComputer(Vertex<Node> host) {
        List<Vertex<Node>> listComputers = getAllHosts();
        listComputers.remove(host);
        int nRandomHost = (int) ((Math.random() * ((listComputers.size() - 0) + 1)) + 0);
        Vertex<Node> randomHost = listComputers.get(0);
        int n = 0;
        for (Vertex<Node> h : listComputers) {
            if (n == nRandomHost) {
                randomHost = h;
            }
        }
        return randomHost;
    }

    private BigDecimal getRamdonTimePoisson(BigDecimal lambda) {
        double L = Math.exp(-lambda.doubleValue());
        double p = 1.0;
        int k = 0;
        do {
            k++;
            p *= Math.random();
        } while (p > L);
        return new BigDecimal(k - 1);
    }

    /*
        FIN CONFIGURACIONES RANDOM
     */
 /*
        INICIO UTILES
     */
    public List<Vertex<Node>> getAllHosts() {
        List<Vertex<Node>> listComputer = new ArrayList<>();
        for (Vertex<Node> h : this.red.vertices()) {
            if (h.getElement() instanceof Host) {
                listComputer.add(h);
            }
        }
        return listComputer;
    }

    public List<Vertex<Node>> getAllRouters() {
        List<Vertex<Node>> listRouter = new ArrayList<>();
        for (Vertex<Node> h : this.red.vertices()) {
            if (h.getElement() instanceof Router) {
                listRouter.add(h);
            }
        }
        return listRouter;
    }

    /*
        FIN UTILES
     */
 /*
	 * RANDOM PACKAGE SENDS END
     */

 /*
	 * PACKAGE SENDS
     */
    private ArrayList<NodeState> getFirstPackageToSend() {
        ArrayList<NodeState> listStates = new ArrayList<>();
        Host computer = null;
        for (Vertex<Node> h : this.red.vertices()) {
            if (h.getElement() instanceof Host) {
                computer = (Host) h.getElement();
                if (!computer.isRandomSend()) {
                    if (!h.getElement().getQueuePackages().isEmpty()) {
                        NodeState sh = new NodeState(h, new BigDecimal(0.0));
                        listStates.add(sh);
                    }
                }
            }
        }
        return listStates;
    }

    private void updateState(List<NodeState> queueStates, Vertex<Node> host) {
        for (NodeState sh : queueStates) {
            if (sh.getHost() == host.getElement()) {
                sh.setTime(host.getElement().getQueuePackages().peek().getTime());
            }
        }
    }

    private List<Vertex<Node>> getHosts(ArrayList<NodeState> queueStates) {
        List<Vertex<Node>> hosts = new ArrayList<>();
        for (NodeState sh : queueStates) {
            hosts.add(sh.getHost());
        }
        return hosts;
    }

    /*
	 * PACKAGE SENDS END
     */

 /*
	 * SEND METHOD
     */
    private List<State> sendPackage(Vertex<Node> h1) {
        Package p = h1.getElement().getQueuePackages().remove();

        if (h1 != p.getDestinationHost() && p.getDestinationHost() != null) {
            java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
            // Se diferencia entre si es un computer o un router por la forma de
            // obtener el siguiente nodo
            if (h1.getElement() instanceof Host) {
                // Se obtiene el siguiente nodo
                Host c = (Host) h1.getElement();
                for (Edge<Linker> nextEdge : this.red.incidentEdges(h1)) {
                    ArrayList<Vertex<Node>> listNextNode = (ArrayList<Vertex<Node>>) this.red
                            .endVertices(nextEdge);
                    Vertex<Node> nextNode = null;
                    if (listNextNode.get(0) == h1) {
                        nextNode = listNextNode.get(1);
                    } else {
                        nextNode = listNextNode.get(0);
                    }

                    // Evento de Transmision al cable
                    BigDecimal timeTransmision = p.getSize().divide(nextEdge.getElement().getSpeed(), 6, RoundingMode.HALF_UP);
                    p.setTime(p.getTime().add(timeTransmision));
                    p.setArriveTime(p.getTime());
                    c.updateTimeQueue(p.getTime());
                    String menssageTransmision = h1.getElement().getName()
                            + bundle.getString("PackageSend") + p.getId()
                            + bundle.getString("ToLinker") + nextEdge.getElement().getIp()
                            + bundle.getString("In") + timeTransmision + " s";
                    Event eTransmision = new Event(p.getTime(),
                            menssageTransmision, h1.getElement(), nextNode.getElement(), nextEdge.getElement(), timeTransmision);

                    // Se configura el evento que ha generado el envio por el
                    // cable
                    BigDecimal timeTransport = nextEdge.getElement().getDistance().divide(velocidadCable, 6, RoundingMode.HALF_UP);
                    p.setTime(p.getTime().add(timeTransport));
                    p.setArriveTime(p.getTime());
                    String menssageTransport = bundle.getString("ThePackage") + p.getId()
                            + bundle.getString("ArrivedFrom")
                            + h1.getElement().getName() + bundle.getString("To")
                            + nextNode.getElement().getName() + bundle.getString("In")
                            + timeTransport + " s";

                    // Se a�ade a la cola del siguiente nodo
                    nextNode.getElement().addPackage(p);

                    // Se crean los estados
                    List<State> states = new ArrayList<>();
                    State state1 = new State(eTransmision, new Event(
                            p.getTime(), menssageTransport, h1.getElement(), nextNode.getElement(), nextEdge.getElement(), timeTransport), nextNode);
                    states.add(state1);
                    if (!c.getQueuePackages().isEmpty() && !c.isRandomSend()) {
                        State state2 = new State(new Event(c.getQueuePackages()
                                .peek().getTime(), null, h1.getElement(), nextNode.getElement(), nextEdge.getElement(), null), new Event(c
                                .getQueuePackages().peek().getTime(), null, h1.getElement(), nextNode.getElement(), nextEdge.getElement(), null), h1);
                        states.add(state2);
                    }

                    // Se envian los estados
                    return states;
                }
                // Si es un router
            } else {
                Router r = null;
                if (h1.getElement() instanceof Router) {
                    r = (Router) h1.getElement();
                } else // Si no es un router es porque los enlaces est�n mal
                // hechos, ya que un ordenador solo envia sus paquetes
                {
                    System.out.println("ERROR");
                }

                // Se consigue el siguiente nodo y el enlace
                Edge<Linker> linker = r.getEnrutamiento(p.getDestinationHost());
                Vertex<Node> nextNode = null;
                if (linker != null) {
                    nextNode = this.red.opposite(h1, linker);
                } else {
                    System.out.println("ERROR LINKER == NULL");
                }

                // Se configura el evento de tranmision del paquete al cable
                BigDecimal timeTransmision = p.getSize().divide(linker.getElement().getSpeed(), 6, RoundingMode.HALF_UP);
                p.setTime(p.getTime().add(timeTransmision));
                p.setArriveTime(p.getTime());
                r.updateTimeQueue(p.getTime());
                String menssageTransmision = h1.getElement().getName()
                        + bundle.getString("PackageSend") + p.getId()
                        + bundle.getString("ToLinker") + linker.getElement().getIp() + bundle.getString("In")
                        + timeTransmision + " s";
                Event eTransmision = new Event(p.getTime(), menssageTransmision, h1.getElement(), nextNode.getElement(), linker.getElement(), timeTransmision);

                // Se configura el evento de transporte por el cable
                BigDecimal timeTransport = linker.getElement().getDistance().divide(velocidadCable, 6, RoundingMode.HALF_UP);
                p.setTime(p.getTime().add(timeTransport));
                p.setArriveTime(p.getTime());
                String menssageTransport = bundle.getString("ThePackage") + p.getId()
                        + bundle.getString("ArrivedFrom") + h1.getElement().getName()
                        + bundle.getString("To") + nextNode.getElement().getName() + bundle.getString("In")
                        + timeTransport + " s";

                // Se mueve el paquete a la siguiente cola
                nextNode.getElement().addPackage(p);

                // Se guardan los estados
                List<State> states = new ArrayList<>();
                State state1 = new State(eTransmision, new Event(p.getTime(),
                        menssageTransport, h1.getElement(), nextNode.getElement(), linker.getElement(), timeTransport), nextNode);
                states.add(state1);
                if (!r.getQueuePackages().isEmpty()) {
                    State state2 = new State(new Event(r.getQueuePackages()
                            .peek().getTime(), null, h1.getElement(), nextNode.getElement(), linker.getElement(), null), new Event(r
                            .getQueuePackages().peek().getTime(), null, h1.getElement(), nextNode.getElement(), linker.getElement(), null), h1);
                    states.add(state2);
                }

                // Se envia el estado
                return states;
            }
        } else {
            java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
            String mensaje = bundle.getString("ThePackage") + p.getId() + bundle.getString("HasBeenSent");
            List<State> states = new ArrayList<>();
            State state = new State(new Event(p.getTime(), mensaje, h1.getElement(), null, null, null), new Event(
                    p.getTime(), mensaje, h1.getElement(), null, null, null), null);
            states.add(state);
            return states;
        }
        return null;
    }

    /*
	 * SEND METHOD END
     */
    @Override
    public String toString() {
        return "Red{" + "red=" + red + ", hosts=" + hosts + '}';
    }

}

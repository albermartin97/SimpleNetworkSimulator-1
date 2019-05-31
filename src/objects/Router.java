package objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import material.graphs.Edge;
import material.graphs.Vertex;

public class Router implements Node, Serializable {

    private String name;
    private int maxLinkers;
    private HashMap<Vertex<Node>, Edge<Linker>> routingTable;
    private PriorityQueue<Package> queuePackages;

    //CONTRUCTOR
    public Router(String name) {
        this.name = name;
        this.routingTable = new HashMap<>();
        Comparator<Package> compS = (Comparator<Package> & Serializable) 
                (Package a, Package b) -> a.compareTo(b);
        this.queuePackages = new PriorityQueue<>(compS);
    }

    //GETTERS Y SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxLinkers() {
        return maxLinkers;
    }

    public void setMaxLinkers(int maxLinkers) {
        this.maxLinkers = maxLinkers;
    }

    public PriorityQueue<Package> getQueuePackages() {
        return queuePackages;
    }

    public void setQueuePackages(PriorityQueue<Package> queuePackages) {
        this.queuePackages = queuePackages;
    }

    public HashMap<Vertex<Node>, Edge<Linker>> getRoutingTable() {
        return routingTable;
    }

    public void setRoutingTable(HashMap<Vertex<Node>, Edge<Linker>> routingTable) {
        this.routingTable = routingTable;
    }

    //METHODS
    public Edge<Linker> getEnrutamiento(Vertex<Node> h1) {
        return routingTable.get(h1);
    }

    public void enrutar(Vertex<Node> h, Edge<Linker> l) {
        routingTable.put(h, l);
    }

    public void updateTimeQueue(BigDecimal timePackage) {
        for (Package p : this.getQueuePackages()) {
            if (p.getTime().compareTo(timePackage) < 0) {
                p.setTime(timePackage);
            }
        }
    }

    public void addPackage(Package p) {
        this.queuePackages.offer(p);
    }

    @Override
    public String toString() {
        return "Router{\n" + name + ",\n" + routingTable.size() + "\n" + routingTable.toString() + ",\n" + queuePackages.size() + "\n" + queuePackages + '}';
    }

    public String toStringAux() {
        return "Router{\n" + name + '}';
    }
}

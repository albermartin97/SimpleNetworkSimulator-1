package objects;

import java.io.Serializable;
import java.math.BigDecimal;
import material.graphs.Vertex;

public class Package implements Comparable<Package>, Serializable {

    private BigDecimal size; // Unidad: Kb
    private static Integer num = 0;
    private Integer id;
    private BigDecimal time;
    private BigDecimal arriveTime;
    private Vertex<Node> destinationHost;

    //CONTRUCTORES
    
    public Package(BigDecimal size, Integer id, BigDecimal time, BigDecimal arriveTime) {
        this.size = size;
        this.id = id;
        num++;
        this.time = time;
        this.arriveTime = arriveTime;
    }

    public Package(BigDecimal size, Vertex<Node> destinationHost) {
        this.size = size;
        this.id = num;
        num++;
        this.time = new BigDecimal(0.0);
        this.arriveTime = new BigDecimal(0.0);
        this.destinationHost = destinationHost;
    }

    //GETTERS AND SETTERS
    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public Vertex<Node> getDestinationHost() {
        return destinationHost;
    }

    public void setDestinationHost(Vertex<Node> destinationHost) {
        this.destinationHost = destinationHost;
    }

    public BigDecimal getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(BigDecimal arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public int compareTo(Package p) {
        if (this.arriveTime.compareTo(p.arriveTime) == 0) {
            return this.id.compareTo(p.id);
        } else {
            return this.arriveTime.compareTo(p.arriveTime);
        }
    }

    public boolean equals(Package p) {
        return this.arriveTime == p.arriveTime;
    }

    @Override
    public String toString() {
        return "Package{\n" + size + ",\n" + id + ",\n" + time + ",\n" + arriveTime + ",\n" + destinationHost.getElement().toStringAux() + "}\n";
    }
    


}

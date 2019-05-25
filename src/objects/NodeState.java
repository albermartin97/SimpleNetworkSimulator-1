package objects;

import java.io.Serializable;
import java.math.BigDecimal;
import material.graphs.Vertex;

public class NodeState implements Comparable<NodeState>, Serializable {

    private Vertex<Node> host;
    private BigDecimal time;

    //CONTRUCTOR
    public NodeState(Vertex<Node> host, BigDecimal time) {
        super();
        this.host = host;
        this.time = time;
    }

    //GETTERS AND SETTERS
    public Vertex<Node> getHost() {
        return host;
    }

    public void setHost(Vertex<Node> host) {
        this.host = host;
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    //METHODS
    @Override
    public int compareTo(NodeState o) {
        if (this.equals(o)) {
            return 0;
        } else if (this.getTime().compareTo(o.getTime())>0) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean equals(NodeState o) {
        return this.getTime() == o.getTime();
    }

    @Override
    public String toString() {
        return "HostState{" + "host=" + host + ", time=" + time + '}';
    }

}

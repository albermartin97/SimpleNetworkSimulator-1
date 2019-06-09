package material.graphs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import objects.Host;
import objects.Linker;

public class ALGraph<V, E> implements Graph<V, E>, Serializable {

    private class ALVertex<V> implements Vertex<V>, Serializable {

        private V vertexValue;
        private final Graph graph;
        private Set<ALEdge<E, V>> adjacent = new HashSet<>();

        public ALVertex(V value, Graph graph, Set<ALEdge<E, V>> adjacent) {
            this.vertexValue = value;
            this.graph = graph;
            this.adjacent = adjacent;
        }

        public Graph getGraph() {
            return graph;
        }

        public void setAdjacent(Set<ALEdge<E, V>> adjacent) {
            this.adjacent = adjacent;
        }

        public Set<ALEdge<E, V>> getAdjacent() {
            return adjacent;
        }

        @Override
        public V getElement() {
            return this.vertexValue;
        }

        public void setElement(V value) {
            this.vertexValue = value;
        }
        @Override
        public String toString(){
            if(this.vertexValue instanceof Host){
                Host h = (Host) this.vertexValue;
                return h.toStringAux();
            }else
                return this.vertexValue.toString();
        }

    }

    private class ALEdge<E, V> implements Edge<E>, Serializable {

        private E edgeValue;
        private final Graph<V, E> graph;

        private final Vertex<V> startVertex;
        private final Vertex<V> endVertex;

        public ALEdge(E value, Vertex<V> startVertex, Vertex<V> endVertex,
                Graph<V, E> graph) {
            this.edgeValue = value;
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.graph = graph;
        }

        public int hashCode() {
            int hash = 3;

            final int min = Math.min(Objects.hashCode(this.startVertex),
                    Objects.hashCode(this.endVertex));
            final int max = Math.max(Objects.hashCode(this.startVertex),
                    Objects.hashCode(this.endVertex));

            hash = 67 * hash + Objects.hashCode(this.getGraph());
            hash = 67 * hash + min;
            hash = 67 * hash + max;
            return hash;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ALEdge<E, V> other = (ALEdge<E, V>) obj;
            if (!Objects.equals(this.graph, other.graph)) {
                return false;
            }

            final int min1 = Math.min(Objects.hashCode(this.startVertex),
                    Objects.hashCode(this.endVertex));
            final int max1 = Math.max(Objects.hashCode(this.startVertex),
                    Objects.hashCode(this.endVertex));

            final int min2 = Math.min(Objects.hashCode(other.startVertex),
                    Objects.hashCode(other.endVertex));
            final int max2 = Math.max(Objects.hashCode(other.startVertex),
                    Objects.hashCode(other.endVertex));

            if (!Objects.equals(min1, min2)) {
                return false;
            }
            if (!Objects.equals(max1, max2)) {
                return false;
            }
            return true;
        }

        @Override
        public E getElement() {
            return this.edgeValue;
        }

        public void setElement(E edgeValue) {
            this.edgeValue = edgeValue;
        }

        public Graph<V, E> getGraph() {
            return graph;
        }

        public Vertex<V> getStartVertex() {
            return startVertex;
        }

        public Vertex<V> getEndVertex() {
            return endVertex;
        }
        @Override
        public String toString(){
            if(this.edgeValue instanceof Linker){
                Linker l = (Linker)edgeValue;
                return l.toStringAux();
            }else
                return this.edgeValue.toString();
        }
    }

    private final Set<ALVertex<V>> vertexList = new HashSet<>();
    private final Set<ALEdge<E, V>> edgeList = new HashSet<>();

    private ALEdge<E, V> checkEdge(Edge<E> edge) {
        if (edge instanceof ALEdge) {
            ALEdge<E, V> e = (ALEdge<E, V>) edge;
            if (e.getGraph() == this) {
                return e;
            }
        }
        throw new RuntimeException("The edge is not in the graph");
    }

    private ALVertex<V> checkVertex(Vertex<V> vertex) {
        if (vertex instanceof ALVertex) {
            ALVertex<V> v = (ALVertex<V>) vertex;
            if (v.getGraph() == this) {
                return v;
            }
        }
        throw new RuntimeException("The vertex is not in the graph");
    }

    @Override
    public Collection<? extends Vertex<V>> vertices() {
        return Collections.unmodifiableCollection(this.vertexList);
    }

    @Override
    public Collection<? extends Edge<E>> edges() {
        return Collections.unmodifiableCollection(this.edgeList);
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) {
        ALVertex<V> vertex = checkVertex(v);
        return Collections.unmodifiableCollection(vertex.getAdjacent());
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        ALEdge<E, V> elv = checkEdge(e);
        if (elv.getStartVertex() == v) {
            return elv.getEndVertex();
        } else if (elv.getEndVertex() == v) {
            return elv.getStartVertex();
        } else {
            throw new RuntimeException("The vertex is not in the edge");
        }
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) {
        ALEdge<E, V> elv = checkEdge(edge);
        ArrayList<Vertex<V>> endVertices = new ArrayList<>();
        endVertices.add(elv.getStartVertex());
        endVertices.add(elv.getEndVertex());
        return endVertices;
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) {
        ALVertex<V> vertex1 = checkVertex(v1);
        ALVertex<V> vertex2 = checkVertex(v2);
        Set<ALEdge<E, V>> adjacent;
        if (vertex1.getAdjacent().size() > vertex2.getAdjacent().size()) {
            adjacent = vertex2.getAdjacent();
        } else {
            adjacent = vertex1.getAdjacent();
        }
        for (ALEdge<E, V> e : adjacent) {
            if (e.getEndVertex() == vertex1 && e.getStartVertex() == vertex2) {
                return e;
            } else if (e.getEndVertex() == vertex2
                    && e.getStartVertex() == vertex1) {
                return e;
            }
        }
        return null;
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) {
        ALVertex<V> v = checkVertex(vertex);
        V element = v.getElement();
        v.setElement(vertexValue);
        return element;
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) {
        ALEdge<E, V> e = checkEdge(edge);
        E element = e.getElement();
        e.setElement(edgeValue);
        return element;
    }

    @Override
    public Vertex<V> insertVertex(V value) {
        ALVertex<V> v = new ALVertex<>(value, this, new HashSet<ALEdge<E, V>>());
        this.vertexList.add(v);
        return v;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
        if (!vertexList.contains(v1)) {
            throw new RuntimeException(
                    "The vertex v1 doesn't belong to this graph");
        }
        if (!vertexList.contains(v2)) {
            throw new RuntimeException(
                    "The vertex v2 doesn't belong to this graph");
        }
        ALVertex<V> vertex1 = checkVertex(v1);
        ALVertex<V> vertex2 = checkVertex(v2);
        ALEdge<E, V> e = new ALEdge<>(edgeValue, v1, v2, this);
        this.edgeList.add(e);
        vertex1.getAdjacent().add(e);
        vertex2.getAdjacent().add(e);
        return e;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) {
        ALVertex<V> v = checkVertex(vertex);
        V element = vertex.getElement();
        Vertex<V> aux;
        for (ALEdge<E, V> e : v.getAdjacent()) {
            if (e.getStartVertex() == vertex) {
                aux = e.getEndVertex();
                ALVertex<V> alv = checkVertex(aux);
                alv.getAdjacent().remove(e);
            } else {
                aux = e.getStartVertex();
                ALVertex<V> alv = checkVertex(aux);
                alv.getAdjacent().remove(e);
            }
            this.edgeList.remove(e);
        }
        this.vertexList.remove(vertex);
        return element;
    }

    @Override
    public E removeEdge(Edge<E> edge) {
        ALEdge<E, V> e = checkEdge(edge);
        E element = edge.getElement();
        Vertex<V> aux = e.getEndVertex();
        ALVertex<V> alv = checkVertex(aux);
        alv.getAdjacent().remove(e);
        aux = e.getStartVertex();
        alv = checkVertex(aux);
        alv.getAdjacent().remove(e);
        this.edgeList.remove(e);
        return element;
    }
}

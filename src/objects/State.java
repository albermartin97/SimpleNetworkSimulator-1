package objects;

import java.math.BigDecimal;
import material.graphs.Vertex;
import simulator.Event;

public class State implements Comparable<State>{
	private Event eventTransmision;
	private Event eventTransport;
	private Vertex<Node> host;
	
	//CONSTRUCTORS
	public State(Event eventTransmision, Event eventTransport, Vertex<Node> host) {
		this.eventTransmision = eventTransmision;
		this.eventTransport = eventTransport;
		this.host = host;
	}

	//GETTERS AND SETTERS
	
	public Event getEventTransmision() {
		return eventTransmision;
	}

	public void setEventTransmision(Event eventTransmision) {
		this.eventTransmision = eventTransmision;
	}

	public Event getEventTransport() {
		return eventTransport;
	}

	public void setEventTransport(Event eventTransport) {
		this.eventTransport = eventTransport;
	}

	public Vertex<Node> getHost() {
		return host;
	}

	public void setHost(Vertex<Node> host) {
		this.host = host;
	}

	//METHODS
	@Override
	public int compareTo(State s) {
		BigDecimal time1 = this.getEventTransport().getTime();
		BigDecimal timeS = s.getEventTransport().getTime();
		if(this.equals(s))
			return 0;
		else if(time1.compareTo(timeS) > 0)
			return 1;
		else
			return -1;
	}
	
	public boolean equals(State s){
		return this.getEventTransport().getTime() == s.getEventTransport().getTime();
	}

	
}

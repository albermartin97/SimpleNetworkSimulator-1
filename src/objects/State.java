package objects;

import java.math.BigDecimal;
import material.graphs.Vertex;
import simulator.Event;

public class State implements Comparable<State>{
	private Event eventTransmission;
	private Event eventTransport;
	private Vertex<Node> host;
	
	//CONSTRUCTORS
	public State(Event eventTransmision, Event eventTransport, Vertex<Node> host) {
		this.eventTransmission = eventTransmision;
		this.eventTransport = eventTransport;
		this.host = host;
	}

	//GETTERS AND SETTERS
	
	public Event getEventTransmission() {
		return eventTransmission;
	}

	public void setEventTransmission(Event eventTransmission) {
		this.eventTransmission = eventTransmission;
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

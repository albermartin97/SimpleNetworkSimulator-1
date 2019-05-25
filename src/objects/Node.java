package objects;

import java.io.Serializable;
import java.util.PriorityQueue;

public interface Node extends Serializable{
	public String getName();
	public void setName(String name);
	public PriorityQueue<Package> getQueuePackages();
	public void setQueuePackages(PriorityQueue<Package> queuePackages);
	public void addPackage(Package p);
        @Override
        public String toString();
        public String toStringAux();
}

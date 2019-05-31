package objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.PriorityQueue;

public class Host implements Node, Serializable {

    private String name;
    private PriorityQueue<Package> queuePackages;
    private RandomSend randomSend;

    //CONTRUCTORES
    public Host(String name) {
        this.name = name;
        this.queuePackages = new PriorityQueue<>((a, b) -> a.compareTo(b));
        this.randomSend = null;
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriorityQueue<Package> getQueuePackages() {
        return queuePackages;
    }

    public void setQueuePackages(PriorityQueue<Package> queuePackages) {
        this.queuePackages = queuePackages;
    }

    public boolean isRandomSend() {
        return this.randomSend != null;
    }

    public void setRandomSend(BigDecimal sizePackage, BigDecimal averageTime) {
        this.randomSend = new RandomSend(sizePackage, averageTime);
    }

    public void setRandomSend(RandomSend randomSend) {
        this.randomSend = randomSend;
    }

    public RandomSend getRandomSend() {
        return this.randomSend;
    }
    //METHODS

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

    public void removePackage(int id) {
        for (Package p : this.queuePackages) {
            if (p.getId() == id) {
                this.queuePackages.remove(p);
            }
        }
    }

    @Override
    public String toString() {
        return "Computer{\n" + name + ",\n"+ queuePackages.size()+ "\n" + queuePackages + ",\n" + randomSend + '}';
    }
    
    public String toStringAux() {
        return "Computer{\n" + name + "}";
    }
}

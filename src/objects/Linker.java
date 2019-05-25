package objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class Linker implements Serializable {

    private String ip;
    private BigDecimal speed; // Unidad: Kb/s
    private BigDecimal distance; // Unidad: m

    //GETTERS AND SETTERS
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Linker{\n" + ip + ",\n" + speed.doubleValue() + ",\n" + distance.doubleValue() + '}';
    }

    public String toStringAux() {
        return "Linker{\n" + ip + "}";
    }
}

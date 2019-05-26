package objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class RandomSend implements Serializable {

    private BigDecimal sizePackage;
    private BigDecimal averageTime;
    private BigDecimal timeLastPackage;

    //CONSTRUCTOR
    public RandomSend(){
        
    }
    public RandomSend(BigDecimal sizePackage, BigDecimal averageTime) {
        super();
        this.sizePackage = sizePackage;
        this.averageTime = averageTime;
        this.timeLastPackage = new BigDecimal("0.00");
    }

    //GETTER AND SETTERS
    public BigDecimal getSizePackage() {
        return sizePackage;
    }

    public void setSizePackage(BigDecimal sizePackage) {
        this.sizePackage = sizePackage;
    }

    public BigDecimal getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(BigDecimal averageTime) {
        this.averageTime = averageTime;
    }

    public BigDecimal getTimeLastPackage() {
        return timeLastPackage;
    }

    public void setTimeLastPackage(BigDecimal timeLastPackage) {
        this.timeLastPackage = timeLastPackage;
    }

    @Override
    public String toString() {
        return "RandomSend{\n" + sizePackage.toString() + ",\n" + averageTime.toString() + '}';
    }

}

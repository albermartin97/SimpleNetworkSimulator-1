package objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class RandomSend implements Serializable {

    private BigDecimal sizePackage;
    private BigDecimal averageTime;

    //CONSTRUCTOR
    public RandomSend(){
        
    }
    public RandomSend(BigDecimal sizePackage, BigDecimal averageTime) {
        super();
        this.sizePackage = sizePackage;
        this.averageTime = averageTime;
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

    @Override
    public String toString() {
        return "RandomSend{\n" + sizePackage.toString() + ",\n" + averageTime.toString() + '}';
    }

}

package app.Elements;
import objects.Package;
/**
 *
 * @author alber
 */
public class Tupla {
    private String destHost;
    private Package p;

    public Tupla(String destHost, Package p) {
        this.destHost = destHost;
        this.p = p;
    }
    
    public String getDestHost() {
        return destHost;
    }

    public void setDestHost(String destHost) {
        this.destHost = destHost;
    }

    public Package getP() {
        return p;
    }

    public void setP(Package p) {
        this.p = p;
    }
    
    
}

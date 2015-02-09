
package entity;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Beer {

    @NotNull
    public String brand;
    @NotNull
    public int year;

    public Beer() {
        // Required by JAXB
    }
    
    public Beer(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Beer{" + "brand=" + brand + ", year=" + year + '}';
    }

}

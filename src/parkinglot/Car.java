package parkinglot;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 * 
 * @author Gonçalo
 */
public class Car {

    private static final Logger LOG = getLogger(Car.class.getName());

    private String registration;
    private String brand;
    private String model;    

    /**
     * 
     * 
     */
    public Car() {}

    /**
     * 
     * @param registration
     * @param Brand
     * @param Model 
     */
    public Car(String registration, String Brand, String Model) {
        this.registration = registration;
        this.brand = Brand;
        this.model = Model;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * 
     * @return 
     */
    public String getRegistration() {
        return registration;
    }
    
    /**
     * 
     * @return 
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @return 
     */
    public String getModel() {
        return model;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * 
     * @param registration 
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    /**
     * 
     * @param Brand 
     */
    public void setBrand(String Brand) {
        this.brand = Brand;
    }

    /**
     * 
     * @param Model 
     */
    public void setModel(String Model) {
        this.model = Model;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "Car{" + "registration=" + registration + ", Brand=" + brand + ", Model=" + model + '}';
    }
    // </editor-fold>
}
package parkinglot;

import java.time.LocalDateTime;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 * 
 * @author dsd07
 */
public class ParkingHistory {

    private static final Logger LOG = getLogger(ParkingHistory.class.getName());
    private String registration;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double price;

    /**
     * 
     * @param registration
     * @param startTime
     * @param endTime
     * @param price 
     */
    public ParkingHistory(String registration, LocalDateTime startTime, LocalDateTime endTime, double price) {
        this.registration = registration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
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
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * 
     * @return 
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * 
     * @return 
     */
    public double getPrice() {
        return price;
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
     * @param startTime 
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * 
     * @param endTime 
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "ParkingHistory{" + "registration=" + registration + ", startTime=" + startTime + ", endTime=" + endTime + ", price=" + price + '}';
    }
    // </editor-fold>
}
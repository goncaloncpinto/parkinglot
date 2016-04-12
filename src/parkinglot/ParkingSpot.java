package parkinglot;

import java.time.LocalDateTime;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 * 
 * @author dsd07
 */
public class ParkingSpot {

    private static final Logger LOG = getLogger(ParkingSpot.class.getName());   
    private int spotID;
    private String registration;

    /**
     *  To store the Check In date and time
     */
    public LocalDateTime startTime;

    /**
     * 
     * @param spotID
     * @param registration
     * @param startTime 
     */
    public ParkingSpot(int spotID, String registration, LocalDateTime startTime) {
        this.registration = registration;
        this.startTime = startTime;
        this.spotID = spotID;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * 
     * @return 
     */
    public int getSpotID() {
        return spotID;
    }

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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * 
     * @param spotID 
     */
    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }
    
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "ParkingSpot{" + "spotID=" + spotID + "registration=" + registration + ", startTime=" + startTime + '}';
    }
    // </editor-fold>
}

package parkinglot;

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import static java.sql.Timestamp.valueOf;
import static java.sql.Types.VARCHAR;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
// </editor-fold>

/**
 *
 * @author Goncalo Pinto
 */
public class ParkingLotDAOimpl {

    private static final Logger LOG = getLogger(ParkingLotDAOimpl.class.getName());
    private final Connection conn;

    // <editor-fold defaultstate="collapsed" desc="Constructor - CONNECTION">
    /**
     * 
     * @throws SQLException 
     */
    public ParkingLotDAOimpl() throws SQLException{
//        String user = "root";
//        String pass = "";
//        String url = "jdbc:mysql://localhost/ParkingLot";
        
        String user = "sa";
        String pass = "password";
        String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;DatabaseName=ParkingLot";

        conn = getConnection(url, user, pass);
        //conn.close();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Clocking IN a new car">
    /**
     * 
     * @param car
     * @param spotID
     * @return
     * @throws SQLException 
     */
    public int insertParking(Car car, int spotID) throws SQLException {
        LocalDateTime dt = now();
        Timestamp startTime = valueOf(dt);
        int numRows;
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO parkinglot (spotID,registration,starttime) VALUES (?,?,? )")) {
            stmt.setInt(1, spotID);
            stmt.setObject(2, car.getRegistration(), VARCHAR);
            stmt.setTimestamp(3, startTime);
            numRows = stmt.executeUpdate();
            if (!isCarPresentDB(car)) {
                insertCar(car);
            }
        }
        return numRows;   
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Clocking OUT a new car">
    /**
     * 
     * @param spotID
     * @return
     * @throws SQLException 
     */
    public int removeParking(int spotID) throws SQLException {
        int numRows;
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM parkinglot WHERE spotID = ?")) {
            stmt.setInt(1, spotID);
            numRows = stmt.executeUpdate();
        }
        return numRows;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get all parking spots">
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<ParkingSpot> getAllParkingSpots() throws SQLException {
        ArrayList<ParkingSpot> parkingSpot = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM parkinglot"); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                parkingSpot.add(
                        new ParkingSpot(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getTimestamp(3).toLocalDateTime()
                        )
                );
            }
        }
        return parkingSpot;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Check if car is present in Car DB table">
    /**
     * 
     * @param car
     * @return
     * @throws SQLException 
     */
    public boolean isCarPresentDB(Car car) throws SQLException {
        int numRows;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM car WHERE registration = ?")) {
            stmt.setString(1, car.getRegistration());
            try (ResultSet rs = stmt.executeQuery()) {
                numRows = 0;
                while (rs.next()) {numRows++;}
            }
        }
        return (numRows > 0);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Search and retrieve Car from DB table Car">
    /**
     * 
     * @param registration
     * @return
     * @throws SQLException 
     */
    public Car getCar(String registration) throws SQLException{
        Car c;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM car WHERE registration = ?")) {
            c = null;
            stmt.setString(1, registration);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    c = new Car(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                }
            }
        }
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Insert Car into DB table Car">
    /**
     * 
     * @param car
     * @return
     * @throws SQLException 
     */
    public int insertCar(Car car) throws SQLException{
        int numRows;
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO car (registration, brand, model) VALUES (?, ?, ?)")) {
            stmt.setString(1, car.getRegistration());
            stmt.setString(2, car.getBrand());
            stmt.setString(3, car.getModel());
            numRows = stmt.executeUpdate();
        }
        return numRows;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Get all History from DB table History">
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<ParkingHistory> getAllHistory() throws SQLException {
        ArrayList<ParkingHistory> historyList = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM history"); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                historyList.add(new ParkingHistory(
                        rs.getString(2),
                        (rs.getTimestamp(3)).toLocalDateTime(),
                        (rs.getTimestamp(4)).toLocalDateTime(),
                        rs.getDouble(5)
                ));
            }
        }
        return historyList;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Insert History into DB table History">
    /**
     * 
     * @param ph
     * @return
     * @throws SQLException 
     */
    public int insertHistory(ParkingHistory ph) throws SQLException {
        LocalDateTime dtCI = ph.getStartTime();
        Timestamp startTime = valueOf(dtCI);
        LocalDateTime dtCO = ph.getEndTime();
        Timestamp endtime = valueOf(dtCO);
        int numRows;
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO history (registration, starttime, endtime, price) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, ph.getRegistration());
            stmt.setTimestamp(2, startTime);
            stmt.setTimestamp(3, endtime);
            stmt.setDouble(4, ph.getPrice());
            numRows = stmt.executeUpdate();
            stmt.close();
        }
        return numRows;
    }
    // </editor-fold>
}
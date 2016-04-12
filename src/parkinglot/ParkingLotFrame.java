package parkinglot;

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import static java.awt.EventQueue.invokeLater;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Robot;
import java.awt.Toolkit;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import java.awt.event.KeyListener;
import java.io.File;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
// </editor-fold>

/**
 * 
 * @author Goncalo Pinto
 */
public class ParkingLotFrame extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="collapsed" desc="Member variables">
    static ParkingLotFrame plFrame;
    private ParkingLotDAOimpl plDAO;
    private ArrayList<ParkingSpot> carsParked = new ArrayList<>();
    private JLabel currentParkingSlot;
    private Object activeTextField;    
    private Thread priceCalc;
    private Boolean isCapsLockOn = false;
        // For the tooltip
    private final JLayeredPane layeredPane = getLayeredPane();
    private JPanel myTooltip;
    private JPanel tooltipBackground;
    private final JLabel [] overlayedPanelList = new JLabel[19];
    private int mouseX = 0;
    private int mouseY = 0;
        // For the Info panel
    private final JLayeredPane infoLayeredPane = getLayeredPane();
    private JPanel infoPanel;
    private JPanel infoShadow;
        // Parking prices
    private double amount = 0;
    private final double rateDay = 25;
    private final double rateHour = 0.85;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor"> 

    /**
     *
     */
    public ParkingLotFrame() {
        // Changes the default font for the JOptionPane messages
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,35)));
        // Sets Csps Lock to Off state
        Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);

        connectDB();
        initComponents();
        createToolTip();
        centerWindow();
        getAllParkingSpots();
        changePanel(pnlHome);
        setEscTabCapsEventListener();
        
        // Hides the Tooltip and Tooltip background panels
        showTooltip(false);
        createInfoPanel();
        showInfo(false);
        clock();
    }
    // </editor-fold>
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        pnlParkingRowTop = new javax.swing.JPanel();
        lblID1 = new javax.swing.JLabel();
        jlParkingSpot1 = new javax.swing.JLabel();
        lblID2 = new javax.swing.JLabel();
        jlParkingSpot2 = new javax.swing.JLabel();
        lblID3 = new javax.swing.JLabel();
        jlParkingSpot3 = new javax.swing.JLabel();
        lblID4 = new javax.swing.JLabel();
        jlParkingSpot4 = new javax.swing.JLabel();
        lblID5 = new javax.swing.JLabel();
        jlParkingSpot5 = new javax.swing.JLabel();
        lblID6 = new javax.swing.JLabel();
        jlParkingSpot6 = new javax.swing.JLabel();
        lblID7 = new javax.swing.JLabel();
        jlParkingSpot7 = new javax.swing.JLabel();
        lblID8 = new javax.swing.JLabel();
        jlParkingSpot8 = new javax.swing.JLabel();
        lblID9 = new javax.swing.JLabel();
        jlParkingSpot9 = new javax.swing.JLabel();
        pnlParkingRowBottom = new javax.swing.JPanel();
        lblID10 = new javax.swing.JLabel();
        jlParkingSpot10 = new javax.swing.JLabel();
        lblID11 = new javax.swing.JLabel();
        jlParkingSpot11 = new javax.swing.JLabel();
        lblID12 = new javax.swing.JLabel();
        jlParkingSpot12 = new javax.swing.JLabel();
        lblID13 = new javax.swing.JLabel();
        jlParkingSpot13 = new javax.swing.JLabel();
        lblID14 = new javax.swing.JLabel();
        jlParkingSpot14 = new javax.swing.JLabel();
        lblID15 = new javax.swing.JLabel();
        jlParkingSpot15 = new javax.swing.JLabel();
        lblID16 = new javax.swing.JLabel();
        jlParkingSpot16 = new javax.swing.JLabel();
        lblID17 = new javax.swing.JLabel();
        jlParkingSpot17 = new javax.swing.JLabel();
        lblID18 = new javax.swing.JLabel();
        jlParkingSpot18 = new javax.swing.JLabel();
        pnlVacOcup = new javax.swing.JPanel();
        pnlCounterFree = new javax.swing.JPanel();
        lblFree = new javax.swing.JLabel();
        lblCountFree = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        pnlCounterOccupied = new javax.swing.JPanel();
        lblOccupied = new javax.swing.JLabel();
        lblCountOccupied = new javax.swing.JLabel();
        btnInfo = new javax.swing.JLabel();
        pnlCheckIn = new javax.swing.JPanel();
        lblCheckIn = new javax.swing.JLabel();
        formCheckIn = new javax.swing.JPanel();
        txtBrand = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        txtRegistration = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlButtonsCI = new javax.swing.JPanel();
        btnCheckIn = new javax.swing.JButton();
        btnClearCI = new javax.swing.JButton();
        btnCancelCI = new javax.swing.JButton();
        pnlKeyboard = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnBackspace = new javax.swing.JButton();
        btnTab = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        btnSpace = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnEnter = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton46 = new javax.swing.JButton();
        pnlCheckOut = new javax.swing.JPanel();
        lblCheckOut = new javax.swing.JLabel();
        formCheckIn4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblBrandCO = new javax.swing.JLabel();
        lblModelCO = new javax.swing.JLabel();
        lblRegistrationCO = new javax.swing.JLabel();
        pnlButtonsCO = new javax.swing.JPanel();
        btnCheckOut = new javax.swing.JButton();
        btnCancelCO = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblDateCI = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblTimeCI = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblDateCO = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblTimeCO = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblTimeParked = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        pnlHistory = new javax.swing.JPanel();
        lblHistory = new javax.swing.JLabel();
        pnlHistoryTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        pnlHistoryButtons = new javax.swing.JPanel();
        btnCancelHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parking Lot Manager");
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        parentPanel.setLayout(new java.awt.CardLayout());

        pnlHome.setName("Home"); // NOI18N

        pnlParkingRowTop.setName("topRow"); // NOI18N

        lblID1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID1.setForeground(new java.awt.Color(51, 51, 255));
        lblID1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID1.setText("1");

        jlParkingSpot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot1.setName("1"); // NOI18N
        jlParkingSpot1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID2.setForeground(new java.awt.Color(51, 51, 255));
        lblID2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID2.setText("2");

        jlParkingSpot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot2.setText("jLabel1");
        jlParkingSpot2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot2.setName("2"); // NOI18N
        jlParkingSpot2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID3.setForeground(new java.awt.Color(51, 51, 255));
        lblID3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID3.setText("3");

        jlParkingSpot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot3.setText("jLabel1");
        jlParkingSpot3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot3.setName("3"); // NOI18N
        jlParkingSpot3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID4.setForeground(new java.awt.Color(51, 51, 255));
        lblID4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID4.setText("4");

        jlParkingSpot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot4.setText("jLabel1");
        jlParkingSpot4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot4.setName("4"); // NOI18N
        jlParkingSpot4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID5.setForeground(new java.awt.Color(51, 51, 255));
        lblID5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID5.setText("5");

        jlParkingSpot5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot5.setText("jLabel1");
        jlParkingSpot5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot5.setName("5"); // NOI18N
        jlParkingSpot5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID6.setForeground(new java.awt.Color(51, 51, 255));
        lblID6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID6.setText("6");

        jlParkingSpot6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot6.setText("jLabel1");
        jlParkingSpot6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot6.setName("6"); // NOI18N
        jlParkingSpot6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID7.setForeground(new java.awt.Color(51, 51, 255));
        lblID7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID7.setText("7");

        jlParkingSpot7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot7.setText("jLabel1");
        jlParkingSpot7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot7.setName("7"); // NOI18N
        jlParkingSpot7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID8.setForeground(new java.awt.Color(51, 51, 255));
        lblID8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID8.setText("8");

        jlParkingSpot8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot8.setText("jLabel1");
        jlParkingSpot8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot8.setName("8"); // NOI18N
        jlParkingSpot8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID9.setForeground(new java.awt.Color(51, 51, 255));
        lblID9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID9.setText("9");

        jlParkingSpot9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot9.setText("jLabel1");
        jlParkingSpot9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot9.setName("9"); // NOI18N
        jlParkingSpot9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlParkingRowTopLayout = new javax.swing.GroupLayout(pnlParkingRowTop);
        pnlParkingRowTop.setLayout(pnlParkingRowTopLayout);
        pnlParkingRowTopLayout.setHorizontalGroup(
            pnlParkingRowTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParkingRowTopLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlParkingRowTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParkingRowTopLayout.createSequentialGroup()
                        .addComponent(lblID1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlParkingRowTopLayout.createSequentialGroup()
                        .addComponent(jlParkingSpot1)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        pnlParkingRowTopLayout.setVerticalGroup(
            pnlParkingRowTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParkingRowTopLayout.createSequentialGroup()
                .addGroup(pnlParkingRowTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID1)
                    .addComponent(lblID2)
                    .addComponent(lblID3)
                    .addComponent(lblID4)
                    .addComponent(lblID5)
                    .addComponent(lblID6)
                    .addComponent(lblID7)
                    .addComponent(lblID8)
                    .addComponent(lblID9))
                .addGap(6, 6, 6)
                .addGroup(pnlParkingRowTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlParkingSpot1)
                    .addComponent(jlParkingSpot2)
                    .addComponent(jlParkingSpot3)
                    .addComponent(jlParkingSpot4)
                    .addComponent(jlParkingSpot5)
                    .addComponent(jlParkingSpot6)
                    .addComponent(jlParkingSpot7)
                    .addComponent(jlParkingSpot8)
                    .addComponent(jlParkingSpot9))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlParkingRowBottom.setName("bottomRow"); // NOI18N

        lblID10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID10.setForeground(new java.awt.Color(51, 51, 255));
        lblID10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID10.setText("10");

        jlParkingSpot10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot10.setName("10"); // NOI18N
        jlParkingSpot10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID11.setForeground(new java.awt.Color(51, 51, 255));
        lblID11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID11.setText("11");

        jlParkingSpot11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot11.setText("jLabel1");
        jlParkingSpot11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot11.setName("11"); // NOI18N
        jlParkingSpot11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID12.setForeground(new java.awt.Color(51, 51, 255));
        lblID12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID12.setText("12");

        jlParkingSpot12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot12.setText("jLabel1");
        jlParkingSpot12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot12.setName("12"); // NOI18N
        jlParkingSpot12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID13.setForeground(new java.awt.Color(51, 51, 255));
        lblID13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID13.setText("13");

        jlParkingSpot13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot13.setText("jLabel1");
        jlParkingSpot13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot13.setName("13"); // NOI18N
        jlParkingSpot13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID14.setForeground(new java.awt.Color(51, 51, 255));
        lblID14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID14.setText("14");

        jlParkingSpot14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot14.setText("jLabel1");
        jlParkingSpot14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot14.setName("14"); // NOI18N
        jlParkingSpot14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID15.setForeground(new java.awt.Color(51, 51, 255));
        lblID15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID15.setText("15");

        jlParkingSpot15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot15.setText("jLabel1");
        jlParkingSpot15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot15.setName("15"); // NOI18N
        jlParkingSpot15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID16.setForeground(new java.awt.Color(51, 51, 255));
        lblID16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID16.setText("16");

        jlParkingSpot16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot16.setText("jLabel1");
        jlParkingSpot16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot16.setName("16"); // NOI18N
        jlParkingSpot16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID17.setForeground(new java.awt.Color(51, 51, 255));
        lblID17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID17.setText("17");

        jlParkingSpot17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot17.setText("jLabel1");
        jlParkingSpot17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot17.setName("17"); // NOI18N
        jlParkingSpot17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        lblID18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblID18.setForeground(new java.awt.Color(51, 51, 255));
        lblID18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID18.setText("18");

        jlParkingSpot18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/free.jpg"))); // NOI18N
        jlParkingSpot18.setText("jLabel1");
        jlParkingSpot18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlParkingSpot18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlParkingSpot18.setName("18"); // NOI18N
        jlParkingSpot18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlParkingSpot1MouseMoved(evt);
            }
        });
        jlParkingSpot18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlParkingSpot18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                parkingSpotMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parkingSpotMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlParkingRowBottomLayout = new javax.swing.GroupLayout(pnlParkingRowBottom);
        pnlParkingRowBottom.setLayout(pnlParkingRowBottomLayout);
        pnlParkingRowBottomLayout.setHorizontalGroup(
            pnlParkingRowBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParkingRowBottomLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlParkingRowBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParkingRowBottomLayout.createSequentialGroup()
                        .addComponent(lblID10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblID18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlParkingRowBottomLayout.createSequentialGroup()
                        .addComponent(jlParkingSpot10)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jlParkingSpot18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        pnlParkingRowBottomLayout.setVerticalGroup(
            pnlParkingRowBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParkingRowBottomLayout.createSequentialGroup()
                .addGroup(pnlParkingRowBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID10)
                    .addComponent(lblID11)
                    .addComponent(lblID12)
                    .addComponent(lblID13)
                    .addComponent(lblID14)
                    .addComponent(lblID15)
                    .addComponent(lblID16)
                    .addComponent(lblID17)
                    .addComponent(lblID18))
                .addGap(6, 6, 6)
                .addGroup(pnlParkingRowBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlParkingSpot10)
                    .addComponent(jlParkingSpot11)
                    .addComponent(jlParkingSpot12)
                    .addComponent(jlParkingSpot13)
                    .addComponent(jlParkingSpot14)
                    .addComponent(jlParkingSpot15)
                    .addComponent(jlParkingSpot16)
                    .addComponent(jlParkingSpot17)
                    .addComponent(jlParkingSpot18)))
        );

        lblFree.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblFree.setForeground(new java.awt.Color(51, 51, 255));
        lblFree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFree.setText("Vacant");

        lblCountFree.setFont(new java.awt.Font("Arial Black", 1, 72)); // NOI18N
        lblCountFree.setForeground(new java.awt.Color(0, 153, 51));
        lblCountFree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountFree.setText("18");

        javax.swing.GroupLayout pnlCounterFreeLayout = new javax.swing.GroupLayout(pnlCounterFree);
        pnlCounterFree.setLayout(pnlCounterFreeLayout);
        pnlCounterFreeLayout.setHorizontalGroup(
            pnlCounterFreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCounterFreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCounterFreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCountFree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCounterFreeLayout.setVerticalGroup(
            pnlCounterFreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCounterFreeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCountFree)
                .addContainerGap())
        );

        btnHistory.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        btnHistory.setText("History");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        lblOccupied.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblOccupied.setForeground(new java.awt.Color(51, 51, 255));
        lblOccupied.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOccupied.setText("Occupied");

        lblCountOccupied.setFont(new java.awt.Font("Arial Black", 1, 72)); // NOI18N
        lblCountOccupied.setForeground(new java.awt.Color(204, 0, 0));
        lblCountOccupied.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountOccupied.setText("0");

        javax.swing.GroupLayout pnlCounterOccupiedLayout = new javax.swing.GroupLayout(pnlCounterOccupied);
        pnlCounterOccupied.setLayout(pnlCounterOccupiedLayout);
        pnlCounterOccupiedLayout.setHorizontalGroup(
            pnlCounterOccupiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCounterOccupiedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCounterOccupiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOccupied, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCountOccupied, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCounterOccupiedLayout.setVerticalGroup(
            pnlCounterOccupiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCounterOccupiedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOccupied)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCountOccupied)
                .addContainerGap())
        );

        btnInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/info_default.png"))); // NOI18N
        btnInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInfoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlVacOcupLayout = new javax.swing.GroupLayout(pnlVacOcup);
        pnlVacOcup.setLayout(pnlVacOcupLayout);
        pnlVacOcupLayout.setHorizontalGroup(
            pnlVacOcupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVacOcupLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(pnlCounterFree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlVacOcupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVacOcupLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnHistory))
                    .addGroup(pnlVacOcupLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnInfo)))
                .addGap(100, 100, 100)
                .addComponent(pnlCounterOccupied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVacOcupLayout.setVerticalGroup(
            pnlVacOcupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVacOcupLayout.createSequentialGroup()
                .addGroup(pnlVacOcupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVacOcupLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo))
                    .addGroup(pnlVacOcupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlVacOcupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlCounterFree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCounterOccupied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlParkingRowTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlParkingRowBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlVacOcup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlParkingRowTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(pnlVacOcup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(pnlParkingRowBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        parentPanel.add(pnlHome, "card2");

        pnlCheckIn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnlCheckIn.setName("Check In"); // NOI18N

        lblCheckIn.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblCheckIn.setForeground(new java.awt.Color(51, 51, 255));
        lblCheckIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCheckIn.setText("Check In");

        formCheckIn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtBrand.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBrand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtModelFocusGained(evt);
            }
        });
        txtBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyTyped(evt);
            }
        });

        txtModel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtModelFocusGained(evt);
            }
        });
        txtModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyTyped(evt);
            }
        });

        txtRegistration.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtRegistration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtModelFocusGained(evt);
            }
        });
        txtRegistration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel2.setText("Car Make:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel3.setText("Car Model:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel4.setText("Date:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel5.setText("Time:");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        lblDate.setText("20/01/2016");

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        lblTime.setText("00:00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel8.setText("Reg. Plate:");

        javax.swing.GroupLayout formCheckInLayout = new javax.swing.GroupLayout(formCheckIn);
        formCheckIn.setLayout(formCheckInLayout);
        formCheckInLayout.setHorizontalGroup(
            formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCheckInLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRegistration)
                    .addComponent(txtBrand)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(50, 50, 50)
                .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime)
                    .addComponent(lblDate))
                .addGap(130, 130, 130))
        );

        formCheckInLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel8});

        formCheckInLayout.setVerticalGroup(
            formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCheckInLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBrand)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(formCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        formCheckInLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel8, txtBrand, txtModel, txtRegistration});

        btnCheckIn.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        btnCheckIn.setText("Check In");
        btnCheckIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckIn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtModelFocusGained(evt);
            }
        });
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        btnClearCI.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        btnClearCI.setText("Clear");
        btnClearCI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearCI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtModelFocusGained(evt);
            }
        });
        btnClearCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCIActionPerformed(evt);
            }
        });

        btnCancelCI.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        btnCancelCI.setText("Cancel");
        btnCancelCI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelCI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtModelFocusGained(evt);
            }
        });
        btnCancelCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsCILayout = new javax.swing.GroupLayout(pnlButtonsCI);
        pnlButtonsCI.setLayout(pnlButtonsCILayout);
        pnlButtonsCILayout.setHorizontalGroup(
            pnlButtonsCILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsCILayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnCheckIn)
                .addGap(80, 80, 80)
                .addComponent(btnClearCI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelCI)
                .addGap(100, 100, 100))
        );

        pnlButtonsCILayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelCI, btnCheckIn, btnClearCI});

        pnlButtonsCILayout.setVerticalGroup(
            pnlButtonsCILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancelCI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsCILayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClearCI, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlKeyboard.setBackground(new java.awt.Color(153, 153, 153));
        pnlKeyboard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("1");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton2.setText("2");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton3.setText("4");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton4.setText("3");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton5.setText("5");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton6.setText("6");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton7.setText("7");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton8.setText("9");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton9.setText("8");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton10.setText("0");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBackspace.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBackspace.setText("backspace");
        btnBackspace.setToolTipText("");
        btnBackspace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnTab.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTab.setText("tab");
        btnTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton14.setText("q");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton15.setText("w");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton16.setText("e");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton17.setText("r");
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton18.setText("t");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton19.setText("y");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton20.setText("u");
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton21.setText("i");
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton22.setText("o");
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton23.setText("p");
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton25.setText("a");
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton26.setText("s");
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton27.setText("d");
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton28.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton28.setText("f");
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton29.setText("g");
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton30.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton30.setText("j");
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton31.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton31.setText("h");
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton32.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton32.setText("k");
        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton33.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton33.setText("l");
        jButton33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton34.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton34.setText("/");
        jButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton35.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton35.setText("z");
        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton36.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton36.setText("x");
        jButton36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton37.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton37.setText("c");
        jButton37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton38.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton38.setText("v");
        jButton38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton39.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton39.setText("b");
        jButton39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton40.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton40.setText("n");
        jButton40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton41.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton41.setText("m");
        jButton41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton42.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton42.setText(",");
        jButton42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton43.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton43.setText(".");
        jButton43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton44.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton44.setText("-");
        jButton44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSpace.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnSpace.setText("space");
        btnSpace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        btnEnter.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnEnter.setText("enter");
        btnEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEnter, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnEnter, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jButton45.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton45.setText("caps lock");
        jButton45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45jButton1ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 90, 15), 5));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Caps Lock");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton46.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton46.setText("\\");
            jButton46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jButton46.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout pnlKeyboardLayout = new javax.swing.GroupLayout(pnlKeyboard);
            pnlKeyboard.setLayout(pnlKeyboardLayout);
            pnlKeyboardLayout.setHorizontalGroup(
                pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKeyboardLayout.createSequentialGroup()
                    .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlKeyboardLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlKeyboardLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlKeyboardLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlKeyboardLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlKeyboardLayout.createSequentialGroup()
                                                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pnlKeyboardLayout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(btnSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(pnlKeyboardLayout.createSequentialGroup()
                                                .addComponent(btnTab, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlKeyboardLayout.createSequentialGroup()
                                                .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlKeyboardLayout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBackspace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGap(20, 20, 20))
            );

            pnlKeyboardLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton10, jButton14, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9});

            pnlKeyboardLayout.setVerticalGroup(
                pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKeyboardLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                    .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlKeyboardLayout.createSequentialGroup()
                            .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnTab, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlKeyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15))
            );

            pnlKeyboardLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTab, jButton14, jButton15, jButton16});

            pnlKeyboardLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton22, jButton23});

            pnlKeyboardLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton25, jButton26, jButton27, jButton28, jButton29, jButton30, jButton31, jButton32, jButton33, jButton44, jButton45});

            javax.swing.GroupLayout pnlCheckInLayout = new javax.swing.GroupLayout(pnlCheckIn);
            pnlCheckIn.setLayout(pnlCheckInLayout);
            pnlCheckInLayout.setHorizontalGroup(
                pnlCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCheckInLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(formCheckIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlButtonsCI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCheckInLayout.createSequentialGroup()
                    .addContainerGap(74, Short.MAX_VALUE)
                    .addComponent(pnlKeyboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(67, 67, 67))
            );
            pnlCheckInLayout.setVerticalGroup(
                pnlCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCheckInLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblCheckIn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(formCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pnlButtonsCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                    .addComponent(pnlKeyboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            parentPanel.add(pnlCheckIn, "card3");

            pnlCheckOut.setName("Check Out"); // NOI18N

            lblCheckOut.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
            lblCheckOut.setForeground(new java.awt.Color(51, 51, 255));
            lblCheckOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblCheckOut.setText("Check Out");

            formCheckIn4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

            jLabel35.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel35.setText("Car Make:");

            jLabel24.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel24.setText("Car Model:");

            jLabel27.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel27.setText("Reg. Plate:");

            lblBrandCO.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N

            lblModelCO.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N

            lblRegistrationCO.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel35)
                            .addGap(18, 18, 18)
                            .addComponent(lblBrandCO))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addGap(18, 18, 18)
                            .addComponent(lblModelCO))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addGap(18, 18, 18)
                            .addComponent(lblRegistrationCO)))
                    .addContainerGap(100, Short.MAX_VALUE))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(lblBrandCO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(lblModelCO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(lblRegistrationCO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            javax.swing.GroupLayout formCheckIn4Layout = new javax.swing.GroupLayout(formCheckIn4);
            formCheckIn4.setLayout(formCheckIn4Layout);
            formCheckIn4Layout.setHorizontalGroup(
                formCheckIn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formCheckIn4Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            formCheckIn4Layout.setVerticalGroup(
                formCheckIn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formCheckIn4Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
            );

            btnCheckOut.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
            btnCheckOut.setText("Check Out");
            btnCheckOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCheckOutActionPerformed(evt);
                }
            });

            btnCancelCO.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
            btnCancelCO.setText("Cancel");
            btnCancelCO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnCancelCO.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCancelActionPerformed(evt);
                }
            });

            jLabel30.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
            jLabel30.setForeground(new java.awt.Color(0, 0, 102));
            jLabel30.setText("Check In");

            jLabel25.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel25.setText("Date:");

            lblDateCI.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            lblDateCI.setText("20/01/2016");

            jLabel26.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel26.setText("Time:");

            lblTimeCI.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            lblTimeCI.setText("00:00");

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel30)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(18, 18, 18)
                            .addComponent(lblDateCI))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addGap(18, 18, 18)
                            .addComponent(lblTimeCI)))
                    .addContainerGap(31, Short.MAX_VALUE))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel30)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDateCI)
                        .addComponent(jLabel25))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(lblTimeCI))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jLabel31.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
            jLabel31.setForeground(new java.awt.Color(0, 0, 102));
            jLabel31.setText("Check Out");

            jLabel28.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel28.setText("Date:");

            lblDateCO.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            lblDateCO.setText("20/01/2016");

            jLabel29.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel29.setText("Time:");

            lblTimeCO.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            lblTimeCO.setText("00:00");

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel31)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addGap(18, 18, 18)
                            .addComponent(lblDateCO))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addGap(18, 18, 18)
                            .addComponent(lblTimeCO)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel31)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDateCO))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTimeCO))
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(200, 200, 200))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(30, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout pnlButtonsCOLayout = new javax.swing.GroupLayout(pnlButtonsCO);
            pnlButtonsCO.setLayout(pnlButtonsCOLayout);
            pnlButtonsCOLayout.setHorizontalGroup(
                pnlButtonsCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlButtonsCOLayout.createSequentialGroup()
                    .addGap(250, 250, 250)
                    .addComponent(btnCheckOut)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelCO)
                    .addGap(250, 250, 250))
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            pnlButtonsCOLayout.setVerticalGroup(
                pnlButtonsCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlButtonsCOLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlButtonsCOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCancelCO, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addComponent(btnCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            jLabel23.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel23.setText("Duration:");

            jLabel36.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
            jLabel36.setText("Amount");

            lblTimeParked.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
            lblTimeParked.setForeground(new java.awt.Color(255, 102, 102));
            lblTimeParked.setText("less than 1 minute");

            lblAmount.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
            lblAmount.setForeground(new java.awt.Color(255, 0, 0));
            lblAmount.setText("€0.00");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel23)
                        .addComponent(jLabel36))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAmount)
                        .addComponent(lblTimeParked))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(lblTimeParked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                    .addGap(0, 0, 0))
            );

            javax.swing.GroupLayout pnlCheckOutLayout = new javax.swing.GroupLayout(pnlCheckOut);
            pnlCheckOut.setLayout(pnlCheckOutLayout);
            pnlCheckOutLayout.setHorizontalGroup(
                pnlCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCheckOutLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCheckOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(formCheckIn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlButtonsCO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(12, 12, 12))
            );
            pnlCheckOutLayout.setVerticalGroup(
                pnlCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCheckOutLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblCheckOut)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(formCheckIn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(pnlButtonsCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            parentPanel.add(pnlCheckOut, "card4");

            pnlHistory.setName("History"); // NOI18N

            lblHistory.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
            lblHistory.setForeground(new java.awt.Color(51, 51, 255));
            lblHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblHistory.setText("History");

            jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

            tblHistory.setAutoCreateRowSorter(true);
            tblHistory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            tblHistory.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Registration", "Check In", "Check Out", "Amount"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tblHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            tblHistory.setRowHeight(35);
            tblHistory.setRowMargin(0);
            tblHistory.setRowSelectionAllowed(false);
            jScrollPane1.setViewportView(tblHistory);
            if (tblHistory.getColumnModel().getColumnCount() > 0) {
                tblHistory.getColumnModel().getColumn(3).setMinWidth(150);
                tblHistory.getColumnModel().getColumn(3).setPreferredWidth(150);
                tblHistory.getColumnModel().getColumn(3).setMaxWidth(150);
            }

            javax.swing.GroupLayout pnlHistoryTableLayout = new javax.swing.GroupLayout(pnlHistoryTable);
            pnlHistoryTable.setLayout(pnlHistoryTableLayout);
            pnlHistoryTableLayout.setHorizontalGroup(
                pnlHistoryTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1196, Short.MAX_VALUE)
                .addGroup(pnlHistoryTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistoryTableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
                        .addContainerGap()))
            );
            pnlHistoryTableLayout.setVerticalGroup(
                pnlHistoryTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 656, Short.MAX_VALUE)
                .addGroup(pnlHistoryTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistoryTableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                        .addContainerGap()))
            );

            btnCancelHistory.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
            btnCancelHistory.setText("Cancel");
            btnCancelHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnCancelHistory.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCancelActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout pnlHistoryButtonsLayout = new javax.swing.GroupLayout(pnlHistoryButtons);
            pnlHistoryButtons.setLayout(pnlHistoryButtonsLayout);
            pnlHistoryButtonsLayout.setHorizontalGroup(
                pnlHistoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlHistoryButtonsLayout.createSequentialGroup()
                    .addGap(515, 515, 515)
                    .addComponent(btnCancelHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(516, 516, 516))
            );
            pnlHistoryButtonsLayout.setVerticalGroup(
                pnlHistoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlHistoryButtonsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnCancelHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
            );

            javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
            pnlHistory.setLayout(pnlHistoryLayout);
            pnlHistoryLayout.setHorizontalGroup(
                pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistoryLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pnlHistoryButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlHistoryTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(12, 12, 12))
            );
            pnlHistoryLayout.setVerticalGroup(
                pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlHistoryLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblHistory)
                    .addGap(18, 18, 18)
                    .addComponent(pnlHistoryTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pnlHistoryButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            parentPanel.add(pnlHistory, "card5");

            getContentPane().add(parentPanel, "card4");

            pack();
        }// </editor-fold>//GEN-END:initComponents
    
    
    // <editor-fold defaultstate="collapsed" desc="Escape / Caps Lock / Tab - Set Event Listener for all elements and sets the to fucusable">
    /**
     * Key Event Listener to listen for the keys:
     *  - Escape
     *  - Tab
     *  - Caps Lock
     */
    private void setEscTabCapsEventListener() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 27:
                        // ESC key
                        if (pnlHome.isShowing()) {      // if you're in the home screen
                            System.exit(0);             // exit to system
                        } else changePanel(pnlHome);    // if not, go back to home screen
                        break;
                    case 20:
                        // Caps Lock key
                        // gets the Caps Lock state
                        isCapsLockOn = java.awt.Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
                        updateCapsLocState(isCapsLockOn);   // calls a method to update the virtual keyboard based on the passing Caps Lock state
                        break;
                    case 9:
                        // TAB key
                        tabPressed();   // calls a method to change focus on text fields
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyTyped(KeyEvent e) {}
        };
        // gets all components for the Check In panel
        List allElements = getAllComponents(pnlCheckIn);
        // calls a method to add the key listener to all passed components
        addEventListener2All(kl, allElements);

        // gets all components for the Home panel
        allElements = getAllComponents(pnlHome);
        // calls a method to add the key listener to all passed components
        addEventListener2All(kl, allElements);
        
        // gets all components for the Check Out panel
        allElements = getAllComponents(pnlCheckOut);
        // calls a method to add the key listener to all passed components
        addEventListener2All(kl, allElements);
        
        // gets all components for the History panel
        allElements = getAllComponents(pnlHistory);
        // calls a method to add the key listener to all passed components
        addEventListener2All(kl, allElements);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Add a KeyListener to a List of elements in a panel">
    /**
     * 
     * @param kl
     * @param list 
     */
    private void addEventListener2All(KeyListener kl, List list) {
        for (Object allElement : list) {    // loops through the passed list of components
            ((Component)allElement).setFocusable(true);     // set the element as focusable
            ((Component)allElement).addKeyListener(kl);     // add the key listener to the component
            
            // disable focus traversal keys to allow correct listening for the Tab key
            // (valid for shift key too)
            ((Component)allElement).setFocusTraversalKeysEnabled(false);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Return all Components in a passed Container"> 
    /**
     *
     * @param c
     * @return
     */
    public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();          // creates an array containing all components in the passed container
        List<Component> compList = new ArrayList<>();   // creates an ArrayList to store all the components
        for (Component comp : comps) {          // loop through all the components in the array
            compList.add(comp);                 // adds component to the ArrayList
            if (comp instanceof Container) {    // if the component is a container
                compList.addAll(getAllComponents((Container) comp)); // call this method again storing all the components in the ArrayList
            }
        }
        return compList;    // return the ArrayList with all the components
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Clock (Date / Time) update in realtime">
    /**
     * 
     */
    private void clock() {
        // Thread for the date and time update
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    final LocalDateTime time = LocalDateTime.now();
                    SwingUtilities.invokeLater(new Runnable() {
                        //@Override
                        public void run() {
                            // Update the Date
                            lblDate.setText(
                                String.format("%02d", time.getDayOfMonth()) + "/" + 
                                String.format("%02d", time.getMonthValue()) + "/" + 
                                String.format("%4d", time.getYear())
                            );
                            lblDateCO.setText(
                                String.format("%02d", time.getDayOfMonth()) + "/" + 
                                String.format("%02d", time.getMonthValue()) + "/" + 
                                String.format("%4d", time.getYear())
                            );
                            
                            // Update the Time
                            lblTime.setText(String.format("%02d", time.getHour()) + ":" + 
                                String.format("%02d", time.getMinute()) + ":" + 
                                format("%02d", time.getSecond())
                            );
                            lblTimeCO.setText(
                                String.format("%02d", time.getHour()) + ":" + 
                                String.format("%02d", time.getMinute()) + ":" + 
                                String.format("%02d", time.getSecond())
                            );
                        }
                    });
                    try {
                        sleep(100);
                    } catch (IllegalArgumentException | InterruptedException e) {
                        JOptionPane.showMessageDialog(plFrame, "There was a problem with the clock", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        ).start();
    }
    // </editor-fold>

    // FORMATTING
        // <editor-fold defaultstate="collapsed" desc="Center Window">
    /**
     * Centers the Window
     */
    private void centerWindow() {
        // gets the size of the screen (in pixels)
        Dimension screenSize = getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();     // gets the width
        int height = (int)screenSize.getHeight();   // gets the height
        // sets the window location at:
        // x  ->  (screen width / 2) - (window width / 2)  
        // y  ->  (screen height / 2) - (window height / 2)  
        this.setLocation((width / 2) - (this.getWidth() / 2), (height / 2) - (this.getHeight() / 2));
    }
        // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Date - return formated date">
    /**
     * 
     * @param ldt
     * @return 
     */
        private String formatDate(LocalDateTime ldt) {
            String CIdate = String.format("%02d/%02d/%02d",
                    ldt.getDayOfMonth(),
                    ldt.getMonthValue(),
                    ldt.getYear()
            );
            return CIdate;
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Time - return formated time">
        /**
         * 
         * @param ldt
         * @return 
         */
        private String formatTime(LocalDateTime ldt) {
            String CItime = String.format("%02d:%02d:%02d",
                    ldt.getHour(),
                    ldt.getMinute(),
                    ldt.getSecond()
            );
            return CItime;
        }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Connection to DB">
        /**
         * 
         */
    private void connectDB() {
        try {
            plDAO = new ParkingLotDAOimpl();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to connect to the database.\n Application is closing.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Creates the Info panel">
    /**
     * Creates the panel that contains the info about the team and the technologies used to develop this program
     */
    private void createInfoPanel() {
        Dimension frameSize = parentPanel.getSize();    // gets the window size
        int width = (int)frameSize.getWidth();          // gets the width
        int height = (int)frameSize.getHeight();        // gets the heihgt
        
        infoShadow = new JPanel();      // created a JPanel to simulate the shadow
        infoPanel = new JPanel();       // cerates a JPanel for the 'main' content
        
        int thisWidth = 680;
        int thisHeight = 302;
        
        // calculate X and Y to make the window centered
        int posX = (width / 2) - (thisWidth / 2);
        int posY = (height / 2) - (thisHeight / 2);
        
        // positions the shadow layer (panel) 15 pixels down and 20 pixels to the right and give it a size
        // (size and position is adjusted for a better result as the top layered panel is taking a different size in the end
        // as it is being created in HTML and therefore the dimensions are different due to standard panel margins)
        infoShadow.setBounds(posX + 20, posY + 15, thisWidth - 15, thisHeight - 5);
        // centers the content panel and give it a size
        infoPanel.setBounds(posX, posY, thisWidth, thisHeight);
        
        // sets the background color for the background panel (RGBA)
        infoShadow.setBackground(new Color(80,80,80,30));
        // sets the background panel to a full transparent background
        // (a background color will be defined in the content HTML code)
        infoPanel.setBackground(new Color(0,0,0,0));
        
        // makes both panels visible
        infoShadow.setVisible(true);
        infoPanel.setVisible(true);
        
        // changes the cursor when the panel is hovered - hand cursor
        infoPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // PNG files with the logos
        File logoJava = new File("src\\parkinglot\\Java_logo.png");
        File logoMSSQL = new File("src\\parkinglot\\MSSQL_logo.png");
        File logoHTML = new File("src\\parkinglot\\HTML_logo.png");
        File logoCSS = new File("src\\parkinglot\\CSS_logo.png");
       
        // adds a new JLabel using HTML and CSS to the main panel
        infoPanel.add(new JLabel("<html>"
                + "<style>"
                + "  * {"
                + "     padding: 0px; "
                + "     margin: 0px;"
                + "     }"
                + "  #aboutBlock {"
                + "     font-size: 14px;"
                + "     font-wieght: bold;"
                + "     color: #000000;"
                + "     text-align: center;"
                + "     border: 2px solid #ffffff;"
                + "     border-left: 2px solid #eeeeee;"
                + "     border-right: 2px solid #555555;"
                + "     border-bottom: 2px solid #555555;"
                + "     background-color: #aaaaaa;"
                + "     width: 512px;"
                + "     height: 228px;"
                + "     }"
                + "  .title {"
                + "     font-size: 17px;"
                + "     font-weight: bold;"
                + "     padding: 10px 0px;"
                + "     color: #2222dd;"
                + "     }"
                + "</style>"
                + "<div id='aboutBlock'>"
                + "     <div class='title'>Developed by:</div>"
                + "     <div>Gon&ccedil;alo Pinto</div>"
                + "     <div>Shariff Jailan</div>"
                + "     <div>Robert Garba</div>"
                + "     <div class='title'>Technologies used:</div>"
                + "     <div>"
                + "         <span><img src=\"file:" + logoJava.getAbsolutePath() + "\"/></span>"
                + "         <span><img src=\"file:" + logoMSSQL.getAbsolutePath() + "\"/></span>"
                + "         <span><img src=\"file:" + logoHTML.getAbsolutePath() + "\"/></span>"
                + "         <span><img src=\"file:" + logoCSS.getAbsolutePath() + "\"/></span>"
                + "     </div>"
                + "</div>"
                + "</html>"));

        // adds the shadow panel with a z-index of 1
        infoLayeredPane.add(infoShadow, Integer.valueOf(1));
        // adds the main panel with a z-index of 2
        infoLayeredPane.add(infoPanel, Integer.valueOf(2));
        
        // adds a new mouse listener to the main panel
        infoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showInfo(false);    // if mouse exits the panel call a method to hide it
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showInfo(false);    // if mouse button is pressed over the panel call a method to hide it
            }
        });
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Info panel = show / hide">
    /**
     * 
     * @param show 
     */
    private void showInfo(boolean show) {
        // if the boolean value passed is 'true' and the panel is not visible
        if (show && !infoPanel.isVisible()) {
            pnlVacOcup.setVisible(false);   // hides the panel that contains the 'History' button (to prevent it to be clicked)
            infoShadow.setVisible(true);    // shows the shadow panel
            infoPanel.setVisible(true);     // shows the main panel
            infoPanel.requestFocus();       // requests focus for the main panel
        } else {
            pnlVacOcup.setVisible(true);    // shows the panel that contains the 'History' button
            infoShadow.setVisible(false);   // hides the shadow panel
            infoPanel.setVisible(false);    // hides the main panel
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Create a new tooltip and it's shadow">
    /**
     * Creates a tooltip
     */
    private void createToolTip() {
        tooltipBackground = new JPanel();
        tooltipBackground.setBounds(10, 10, 340, 132);
        tooltipBackground.setBackground(new Color(80,80,80,30));
        layeredPane.add(tooltipBackground, Integer.valueOf(1));

        myTooltip = new JPanel();
        myTooltip.setBounds(0, 0, 340, 132);
        myTooltip.setBackground(new Color(0,0,0,0));
        layeredPane.add(myTooltip, valueOf(2));
        myTooltip.setCursor(new Cursor(Cursor.HAND_CURSOR));
    } 
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Set the content of a tooltip">
    /**
     * 
     * @param car
     * @param parkingSpot
     * @return 
     */
    private JLabel setToolTip(Car car, ParkingSpot parkingSpot) {
        myTooltip.removeAll();
        JLabel jl = new JLabel("<html>"
                + "<style>"
                + "     * {"
                + "         padding: 0px;"
                + "         margin: 0px;"
                + "     }"
                + "     #mainDiv {"
                + "         background-color: #aaaaaa;"
                + "         padding: 7px 10px 15px 10px;"
                + "         border: 2px solid #ffffff;"
                + "         border-left: 2px solid #eeeeee;"
                + "         border-right: 2px solid #555555;"
                + "         border-bottom: 2px solid #555555;"
                + "         width: 260px;"
                + "     }"
                + "     .title {"
                + "         font-weight: bold;"
                + "         font-size: 14px;"
                + "         color: #2222dd;"
                + "     }"
                + "     span {"
                + "         color: #000000;"
                + "         font-weight: normal;"
                + "         font-size: 13px;"
                + "     }"
                + "</style>"
                + "             <div id='mainDiv'>"
                + "                 <div class='title'>Car make: <span>" + 
                    ((car.getBrand().length() > 13) ? (car.getBrand()).substring(0, 11) + "..." : car.getBrand()) 
                                    + "</span></div> "
                + "                 <div class='title'>Car model: <span>" +  
                    ((car.getModel().length() > 13) ? (car.getModel()).substring(0, 11) + "..." : car.getModel()) 
                                    + "</span></div> "
                + "                 <div class='title'>Registration: <span>" + car.getRegistration() + "</span></div> "
                + "                 <div class='title'>Check In: <span>" + formatDate(parkingSpot.getStartTime()) + " - " + formatTime(parkingSpot.getStartTime()) + "</span></div>"
                + "             </div>"
                + "         </html>");
        myTooltip.add(jl);
        return jl;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Tooltip - changes the state (show/hide)">
    /**
     * 
     * @param show 
     */
    private void showTooltip(boolean show) {
        tooltipBackground.setVisible(show);
        myTooltip.setVisible(show);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Update the Counters">
    /**
     * 
     */
    private void updateCounters() {
         // Updates the counters in middle of screen
        lblCountOccupied.setText(String.valueOf(carsParked.size()));
        lblCountFree.setText(valueOf(
                ((pnlParkingRowTop.getComponentCount() / 2) + (pnlParkingRowBottom.getComponentCount() / 2)) - 
                carsParked.size()
        ));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Parking Status - Update a row - Home panel">
    /**
     * 
     * @param jp 
     */
    private void parkingStatusRow(JPanel jp) {
        Car  car = new Car();  
        for (Component c : jp.getComponents()) {
            if (c instanceof JLabel) {
                JLabel ps = ((JLabel)c);
                if (ps.getHeight() > 100) {
                    String newImage = "";
                    if (isPresent(Integer.parseInt(ps.getName()))) {
                        for (ParkingSpot parkingSpot : carsParked) {
                            if (Integer.parseInt(ps.getName()) == parkingSpot.getSpotID()) {                             
                                try {
                                    car = plDAO.getCar(parkingSpot.getRegistration());
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(this, "Cannot load car from the database", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                                overlayedPanelList[Integer.parseInt(ps.getName())] = setToolTip(car, parkingSpot);
                                if (jp == pnlParkingRowTop) {
                                    newImage = "car_top";
                                } else if (jp == pnlParkingRowBottom) {
                                    newImage = "car_bottom";
                                }
                            }
                        }
                    } else {
                        ps.setToolTipText(null); 
                        newImage = "free";
                    }
                    ps.setIcon(new ImageIcon(getClass().getResource("/parkinglot/" + newImage + ".jpg")));
                }
            }
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Parking Status - Update - Home panel">

    /**
     *
     */
    public void parkingStatus() {    
        updateCounters();
        // Set top row
        parkingStatusRow(pnlParkingRowTop);
        // Set bottom row
        parkingStatusRow(pnlParkingRowBottom);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get all Parking Spots">
    /**
     * 
     */
    private void getAllParkingSpots() {
        try {
            carsParked = plDAO.getAllParkingSpots();
            parkingStatus();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Cannot load parking spots from the database", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Change Panel">
    /**
     * 
     * @param panel2add 
     */
    private void changePanel(JPanel panel2add) {
        parentPanel.removeAll();
        parentPanel.add(panel2add);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        panel2add.setVisible(true);
        panel2add.getComponent(0).requestFocus();
        
        if (panel2add == pnlCheckIn){
            if (activeTextField instanceof JTextField) {
                ((Component)activeTextField).requestFocus();
            } else {
                activeTextField = txtBrand;
                txtBrand.requestFocus();
            }
        }
        // Hides the tooltip
        showTooltip(false);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Populate and update Check Out panel">
    /**
     * 
     * @param jl 
     */
    private void populateCO(JLabel jl) {

        for (ParkingSpot parkingSpot : carsParked) {
            if (parkingSpot.getSpotID() == Integer.parseInt(currentParkingSlot.getName())) {
                try {
                    Car c = new Car();
                    c = plDAO.getCar(parkingSpot.getRegistration());
                    lblBrandCO.setText(c.getBrand());
                    lblModelCO.setText(c.getModel());
                    lblRegistrationCO.setText(c.getRegistration());
                    String CIdate = formatDate(parkingSpot.getStartTime());
                    String CItime = formatTime(parkingSpot.getStartTime());
                    lblDateCI.setText(CIdate);
                    lblTimeCI.setText(CItime);
                    break;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error loading the car from the database", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        // Thread for the date and time update
        priceCalc = new Thread(new Runnable() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Check In date and time
                        String dt1str = lblDateCI.getText() + " " + lblTimeCI.getText();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime dtCI = LocalDateTime.parse(dt1str, dtf);

                        // Check In date and time
                        String dt2str = lblDateCO.getText() + " " + lblTimeCO.getText();
                        LocalDateTime dtCO = LocalDateTime.parse(dt2str, dtf);

                        // Populate duration and amount to pay
                        lblTimeParked.setText(timeDuration(dtCI, dtCO));
                        lblAmount.setText(format("€%.2f", amount));
                    }
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
        );
        priceCalc.start();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Calculate parking durationa and price">
    /**
     * 
     * @param fromDateTime
     * @param toDateTime
     * @return 
     */
    private String timeDuration(LocalDateTime fromDateTime, LocalDateTime toDateTime) {

        LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);
        amount = rateHour;
        
        long days = tempDateTime.until(toDateTime, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(days);
        amount = days * rateDay;

        long hours = tempDateTime.until(toDateTime, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(hours);
        amount += hours * rateHour;

        long minutes = tempDateTime.until(toDateTime, ChronoUnit.MINUTES);
        if (days == 0 && hours == 0) {
            amount = rateHour;
        } else {
            amount += rateHour;
        }

        String duration = ("<html>" +
                ((days > 0) ? "<span style='color:#3333cc'>" + days + "</span> day" + ((days > 1) ? "s " : " ") : "")
                + ((hours > 0) ? "<span style='color:#3333cc'>" + hours + "</span> hour" + ((hours > 1) ? "s " : " ") : "")
                + ((minutes > 0) ? "<span style='color:#3333cc'>" + minutes + "</span> minute" + ((minutes > 1) ? "s ": " ") : "")
                + "</html>"
                );
        if (days == 0 && hours == 0 && minutes == 0) {
            duration = "less than 1 minute";
        }
        return duration;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Parking Spot - state change - action performed">
    /**
     * 
     * @param jl 
     */
    private void spotStatusChange(JLabel jl) {

        // Check if the element (Jlabel) passed contains "free.jpg" on the icon properties that are
        // being converted to string for the comperision
        if (( jl.getIcon()).toString().contains("free.jpg")) {
            // hide current panel and show Check In panel
            changePanel(pnlCheckIn);
            currentParkingSlot = jl;
        } else {
            changePanel(pnlCheckOut);
            currentParkingSlot = jl;
            populateCO(jl);
        }        
        parkingStatus();    // update the home panel
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Parking Spot - Check In - insert DB">
    /**
     * 
     */
    private void addParkingSpot() {
        // Get the name for the panel which contains the Jlabel that was passed in
        String activeRow = currentParkingSlot.getParent().getName();

        // if all details are not filled then run code below
        if (txtBrand.getText().isEmpty() || txtModel.getText().isEmpty() || txtRegistration.getText().isEmpty()) {
            String message = "Please enter: ";
            if (txtBrand.getText().isEmpty()) {
                message += "\n- Car brand";
            }
            if (txtModel.getText().isEmpty()) {
                message += "\n- Car model";
            }
            if (txtRegistration.getText().isEmpty()) {
                message += "\n- Registration plate";
            }
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
        } else { 
            try {
                Car car = new Car(txtRegistration.getText(), txtBrand.getText(), txtModel.getText());
                plDAO.insertParking(car, parseInt(currentParkingSlot.getName()));
                carsParked.add(new ParkingSpot(Integer.parseInt(currentParkingSlot.getName()), txtRegistration.getText(), LocalDateTime.now()));
                currentParkingSlot.setIcon(new ImageIcon(getClass().getResource(
                        "/parkinglot/"
                        + ((activeRow.equals("topRow")) ? "car_top" : "car_bottom")
                        + ".jpg"
                )));
                changePanel(pnlHome);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        ((((ex.getLocalizedMessage()).toLowerCase()).contains("duplicate")) ? "Vehicle already checked in" : "Error checking in the vehicle"),
                        "Warning", JOptionPane.WARNING_MESSAGE
                ); 
            }
            parkingStatus();    // update the home panel
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mouse / Keyboard Events">
    
        // *****   H O M E   *****
    
        // <editor-fold defaultstate="collapsed" desc="Parking Spot - Mouse Released">
    /**
     * 
     * @param evt 
     */
    private void parkingSpotMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parkingSpotMouseReleased
        spotStatusChange((JLabel)evt.getComponent());      
        (evt.getComponent()).setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateCounters();
    }//GEN-LAST:event_parkingSpotMouseReleased
    // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Parking Spot - Mouse Pressed">
    /**
     * 
     * @param evt 
     */
    private void parkingSpotMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parkingSpotMousePressed
        (evt.getComponent()).setCursor(new Cursor(WAIT_CURSOR));
    }//GEN-LAST:event_parkingSpotMousePressed
    // </editor-fold>
    
        // *****   C H E C K   I N   *****
    
        // <editor-fold defaultstate="collapsed" desc="Check In - Action Performed">
    /**
     * 
     * @param evt 
     */
    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        addParkingSpot();
    }//GEN-LAST:event_btnCheckInActionPerformed
    // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Clear - Action Performed">
    /**
     * 
     * @param evt 
     */
    private void btnClearCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCIActionPerformed
        for (Component tb : formCheckIn.getComponents()) {
            if (tb instanceof JTextField) {
                ((JTextComponent)tb).setText("");
            }
        }
    }//GEN-LAST:event_btnClearCIActionPerformed
    // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Check Out - Action Performed">
    /**
     * 
     * @param evt 
     */
    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        try {
            plDAO.removeParking(Integer.parseInt(currentParkingSlot.getName()));
            for (ParkingSpot parkingSpot : carsParked) {
                if (parkingSpot.getSpotID() == Integer.parseInt(currentParkingSlot.getName())) {
                    carsParked.remove(parkingSpot);
                    break;
                }
            }
            carsParked.clear();     // reset the ArrayList will all parking spots 
            getAllParkingSpots();   // reload from DB
            parkingStatus();

            // Here we are going to save this checkout to DB / history table
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime starttime = LocalDateTime.parse(lblDateCI.getText() + " " + lblTimeCI.getText(), dtf);
            LocalDateTime endtime = LocalDateTime.parse(lblDateCO.getText() + " " + lblTimeCO.getText(), dtf);
            plDAO.insertHistory(new ParkingHistory(
                    lblRegistrationCO.getText(),
                    starttime,
                    endtime,
                    parseDouble(lblAmount.getText().substring(1, lblAmount.getText().length())))
            );
            priceCalc.interrupt();
            
            changePanel(pnlHome);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Could not Clock Out the vehicle. Error accessing the database", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed
        // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Tab - text field - cycle focus">
    /**
     * 
     */
    private void tabPressed() {
        if (activeTextField == txtBrand) {
            txtModel.requestFocus();
        } else if (activeTextField == txtModel) {
            txtRegistration.requestFocus();
        } else if (activeTextField == txtRegistration) {
            txtBrand.requestFocus();
        }
    }
        // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Virtual Keyboard">
    /**
     * 
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String kp = evt.getActionCommand();     // Gets Button content (text)
        
        VK_KEY_EVEMT:   // label for next If statement where ll the other keys are being handled
        // this block runs only if there is something with focus (JTextarea or JButton)
        if (activeTextField != null) {
            try {
                Robot robot = new Robot();
                char keyToPress = 0;        // creates and resets a variable to store virtual key to be pressed
                // if the button text is bigger than one char
                if (kp.length() > 1) {
                    switch (kp) {
                        case "tab" : {
                            tabPressed();
                            break VK_KEY_EVEMT;
                        }
                        case "space" : keyToPress = KeyEvent.VK_SPACE; break;
                        case "backspace" : keyToPress = VK_BACK_SPACE; break;
                        case "enter" : keyToPress = KeyEvent.VK_ENTER; break;
                    }
                // else / if ony one char JButton
                } else {
                    keyToPress = kp.charAt(0);      // store the char into the variable for virtual key
                }
                
                // Request focus for the element that had focus before the event was fired
                ((Component) activeTextField).requestFocus();

                
                if (keyToPress == KeyEvent.VK_ENTER) {
                    if (activeTextField == txtBrand) {
                        txtModel.requestFocus();
                    } else if (activeTextField == txtModel) {
                        txtRegistration.requestFocus(); 
                    } else if (activeTextField == txtRegistration) {
                        btnCheckIn.requestFocus();
                    } else if (activeTextField == btnCheckIn) {
                        btnCheckIn.doClick();
                    } else if (activeTextField == btnClearCI) {
                        btnClearCI.doClick();
                    } else if (activeTextField == btnCancelCI) {
                        btnCancelCI.doClick();
                    }
                } else {
                    // if the value in keypressed is a lower case letter, then make it am upper case
                    // for the robot to virtually press the righ key
                    if (keyToPress >= 97 && keyToPress <= 122) {
                        int newChar = keyToPress - 32;
                        keyToPress = (char)newChar;
                    }
                    // virtually press a key and release it after
                    robot.keyPress(keyToPress);
                    robot.keyRelease(keyToPress);
                }
                //robot = null;
            } catch (AWTException ex) {
                JOptionPane.showMessageDialog(this, "The key you pressed is not a valid key", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Text Fields - stores active txt field awhen focus gained">
    /**
     * 
     * @param evt 
     */
    private void txtModelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModelFocusGained
        if (evt.getSource() instanceof JTextField) {
            activeTextField = (evt.getComponent());
        }
        else if (evt.getSource() instanceof JButton) {
            activeTextField = (evt.getComponent());
        }
    }//GEN-LAST:event_txtModelFocusGained
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Virtual Caps Lock - Action Event - Virtual Keyboard">
    /**
     * 
     * @param evt 
     */
    private void jButton45jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45jButton1ActionPerformed
        isCapsLockOn = java.awt.Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        java.awt.Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, !isCapsLockOn);
        updateCapsLocState(!isCapsLockOn);
    }//GEN-LAST:event_jButton45jButton1ActionPerformed
        // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="History - Action Event">
    /**
     * 
     * @param evt 
     */
    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        changePanel(pnlHistory);
        tblHistory.getTableHeader().setFont(new Font("SansSerif", BOLD, 24));
        tblHistory.getColumnModel().setColumnMargin(10);
        for (int i = tblHistory.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) tblHistory.getModel()).removeRow(i);
        }
        try {
            ArrayList<ParkingHistory> allHistory = plDAO.getAllHistory();
            String starttime = "";
            String endtime = "";
            for (ParkingHistory ph : allHistory) {
                
                LocalDateTime st = ph.getStartTime();
                starttime = String.format("%02d/%02d/%02d - %02d:%02d:%02d", st.getDayOfMonth(), st.getMonthValue(), st.getYear(), st.getHour(), st.getMinute(), st.getSecond());
                st = ph.getEndTime();
                endtime = String.format("%02d/%02d/%02d - %02d:%02d:%02d", st.getDayOfMonth(), st.getMonthValue(), st.getYear(), st.getHour(), st.getMinute(), st.getSecond());
                
                DefaultTableModel model = (DefaultTableModel) tblHistory.getModel();
                model.addRow(new Object [] {
                    ph.getRegistration(),
                    starttime,
                    endtime,
                    String.format("€%.2f", ph.getPrice())
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "There was a problem trying to get all the parking records from the database", "Warning", JOptionPane.WARNING_MESSAGE);
        }
       
        // Center Align text inside column 6 (Quantity)
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblHistory.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
  
    }//GEN-LAST:event_btnHistoryActionPerformed
       // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Parking Spot - Mouse Move Event - Tooltip">
    /**
     * 
     * @param evt 
     */
    private void jlParkingSpot1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlParkingSpot1MouseMoved
        if (plFrame.getWidth() > ((evt.getX()) + evt.getComponent().getX() + evt.getComponent().getParent().getX() + 15 + myTooltip.getWidth())) {
            mouseX = (evt.getX()) + evt.getComponent().getX() + evt.getComponent().getParent().getX() + 5;
        } else {
            mouseX = plFrame.getWidth() - myTooltip.getWidth() - 10;
        }
        
        if (plFrame.getHeight() > ((evt.getY()) + evt.getComponent().getY() + evt.getComponent().getParent().getY() + 50 + myTooltip.getHeight())) {
            mouseY = (evt.getY()) + evt.getComponent().getY() + evt.getComponent().getParent().getY() + 15;
        } else {
            mouseY = plFrame.getHeight() - myTooltip.getHeight() - 35;
        }
        
        if ((myTooltip.getX()-10 != mouseX) && ((myTooltip.getY()-35 != mouseY))) {
            tooltipBackground.setLocation(mouseX + 10, mouseY + 10);
            myTooltip.setLocation(mouseX, mouseY);
        }
    }//GEN-LAST:event_jlParkingSpot1MouseMoved
        // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Parking Spot - Mouse Leave Event - Tooltip">
    /**
     * 
     * @param evt 
     */
    private void jlParkingSpot18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlParkingSpot18MouseExited
        showTooltip(false);
    }//GEN-LAST:event_jlParkingSpot18MouseExited
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parking Spot - Mouse Enter Event - Tooltip">
    /**
     * 
     * @param evt 
     */
    private void jlParkingSpot18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlParkingSpot18MouseEntered
        JLabel jl = (JLabel)(evt.getComponent());
        
        // Run this is the parking spot is occupied
        if (isPresent(Integer.parseInt(jl.getName()))) {
            myTooltip.removeAll();
            myTooltip.add(overlayedPanelList[Integer.parseInt(jl.getName())], Integer.valueOf(1));
            showTooltip(true);
        }
    }//GEN-LAST:event_jlParkingSpot18MouseEntered
        // </editor-fold>                                     
    
        // <editor-fold defaultstate="collapsed" desc="Cancel - Action Performed">
    /**
     * 
     * @param evt 
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (pnlCheckOut.isShowing() && priceCalc != null) {
            priceCalc.interrupt();
        }
        changePanel(pnlHome);
    }//GEN-LAST:event_btnCancelActionPerformed
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Text field - Key Typed">
    /**
     * 
     * @param evt 
     */
    private void txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyTyped
        if (evt.getSource() == txtBrand && txtBrand.getText().length() > 19) {
            txtBrand.setText((txtBrand.getText()).substring(0, 19));
        } else if (evt.getSource() == txtModel && txtModel.getText().length() > 19) {
            txtModel.setText((txtModel.getText()).substring(0, 19));
        } else if (evt.getSource() == txtRegistration && txtRegistration.getText().length() > 9) {
            txtRegistration.setText((txtRegistration.getText()).substring(0, 9));
        }
    }//GEN-LAST:event_txtKeyTyped
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Info Icon - Mouse Clicked Event">
    /**
     * 
     * @param evt 
     */
    private void btnInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoMouseClicked
        showInfo(true);
    }//GEN-LAST:event_btnInfoMouseClicked
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Info Icon - Mouse Entered Event">
    /**
     * 
     * @param evt 
     */
    private void btnInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoMouseEntered
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/info_hovered.png")));
    }//GEN-LAST:event_btnInfoMouseEntered
        //</editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Info Icon - Mouse Exited Event">
    /**
     * 
     * @param evt 
     */
    private void btnInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoMouseExited
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parkinglot/info_default.png")));
    }//GEN-LAST:event_btnInfoMouseExited
        //</editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Update Caps Lock Led - Virtual Keyboard">
    /**
     * 
     * @param CLstate 
     */
    private void updateCapsLocState(boolean CLstate) {
        if (CLstate) {
            jLabel7.setBorder(BorderFactory.createLineBorder(new Color(50, 255, 20), 5));
        } else {
            jLabel7.setBorder(BorderFactory.createLineBorder(new Color(15, 90, 15), 5));
        }
        kbLettersUpdate();      // update virtual keyboard (upper / lower case)
        
        // if ther is an activeTextField and if it really is a JTextField then give the focus back to it
        if (activeTextField != null) {
            if (activeTextField instanceof JTextField) {
                ((Component) activeTextField).requestFocus();
            }
        }
    }
        // </editor-fold>
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Update the letters on the virtual keyboard - Upper and Lower case">
    /**
     * 
     */
    private void kbLettersUpdate() {
        for (Component component : pnlKeyboard.getComponents()) {
            if (component instanceof JButton) {
                JButton jb = ((JButton)component);
                if (jb.getText().length() == 1)  {
                    if (!isCapsLockOn && (jb.getText().charAt(0) >= 65 && jb.getText().charAt(0) <= 90)) {
                        jb.setText(String.valueOf((char)(jb.getText().charAt(0) + 32)));
                    } else if (isCapsLockOn && (jb.getText().charAt(0) >= 97 && jb.getText().charAt(0) <= 122)) {
                        jb.setText(String.valueOf((char)(jb.getText().charAt(0) - 32)));
                    }
                }
            }
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Check if spotID is present in the loaded ArrayList">
    /**
     * 
     * @param spotID
     * @return 
     */
    private boolean isPresent(int spotID) {
        for (ParkingSpot parkingSpot : carsParked) {
            if (spotID == parkingSpot.getSpotID()) {
                return true;
            }
        }
        return false;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main">

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParkingLotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParkingLotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParkingLotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParkingLotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        invokeLater(new Runnable() {
            @Override
            public void run() {
                plFrame = new ParkingLotFrame();
                plFrame.setVisible(true);
            }
        });
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackspace;
    private javax.swing.JButton btnCancelCI;
    private javax.swing.JButton btnCancelCO;
    private javax.swing.JButton btnCancelHistory;
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnClearCI;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnHistory;
    private javax.swing.JLabel btnInfo;
    private javax.swing.JButton btnSpace;
    private javax.swing.JButton btnTab;
    private javax.swing.JPanel formCheckIn;
    private javax.swing.JPanel formCheckIn4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlParkingSpot1;
    private javax.swing.JLabel jlParkingSpot10;
    private javax.swing.JLabel jlParkingSpot11;
    private javax.swing.JLabel jlParkingSpot12;
    private javax.swing.JLabel jlParkingSpot13;
    private javax.swing.JLabel jlParkingSpot14;
    private javax.swing.JLabel jlParkingSpot15;
    private javax.swing.JLabel jlParkingSpot16;
    private javax.swing.JLabel jlParkingSpot17;
    private javax.swing.JLabel jlParkingSpot18;
    private javax.swing.JLabel jlParkingSpot2;
    private javax.swing.JLabel jlParkingSpot3;
    private javax.swing.JLabel jlParkingSpot4;
    private javax.swing.JLabel jlParkingSpot5;
    private javax.swing.JLabel jlParkingSpot6;
    private javax.swing.JLabel jlParkingSpot7;
    private javax.swing.JLabel jlParkingSpot8;
    private javax.swing.JLabel jlParkingSpot9;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBrandCO;
    private javax.swing.JLabel lblCheckIn;
    private javax.swing.JLabel lblCheckOut;
    private javax.swing.JLabel lblCountFree;
    private javax.swing.JLabel lblCountOccupied;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateCI;
    private javax.swing.JLabel lblDateCO;
    private javax.swing.JLabel lblFree;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblID10;
    private javax.swing.JLabel lblID11;
    private javax.swing.JLabel lblID12;
    private javax.swing.JLabel lblID13;
    private javax.swing.JLabel lblID14;
    private javax.swing.JLabel lblID15;
    private javax.swing.JLabel lblID16;
    private javax.swing.JLabel lblID17;
    private javax.swing.JLabel lblID18;
    private javax.swing.JLabel lblID2;
    private javax.swing.JLabel lblID3;
    private javax.swing.JLabel lblID4;
    private javax.swing.JLabel lblID5;
    private javax.swing.JLabel lblID6;
    private javax.swing.JLabel lblID7;
    private javax.swing.JLabel lblID8;
    private javax.swing.JLabel lblID9;
    private javax.swing.JLabel lblModelCO;
    private javax.swing.JLabel lblOccupied;
    private javax.swing.JLabel lblRegistrationCO;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimeCI;
    private javax.swing.JLabel lblTimeCO;
    private javax.swing.JLabel lblTimeParked;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel pnlButtonsCI;
    private javax.swing.JPanel pnlButtonsCO;
    private javax.swing.JPanel pnlCheckIn;
    private javax.swing.JPanel pnlCheckOut;
    private javax.swing.JPanel pnlCounterFree;
    private javax.swing.JPanel pnlCounterOccupied;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JPanel pnlHistoryButtons;
    private javax.swing.JPanel pnlHistoryTable;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlKeyboard;
    private javax.swing.JPanel pnlParkingRowBottom;
    private javax.swing.JPanel pnlParkingRowTop;
    private javax.swing.JPanel pnlVacOcup;
    private javax.swing.JTable tblHistory;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtRegistration;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(ParkingLotFrame.class.getName());
    // </editor-fold>
}
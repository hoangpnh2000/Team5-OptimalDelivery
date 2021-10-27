import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionGui extends JFrame {

    public String pickupLocation;
    // Elements of UI
    private JLabel choosePickupLabel, numPackagesLabel;
    private JComboBox choosePickupComboBox;
    private JTextField numPackagesJTF;
    private JButton continueButton, homeButton;
    private JTextField textX, textY;
    private JTable table;
    private final Color errorColor = new Color(255, 102, 102);
    private int numPackages;
    private int k = 0;
    private int xCoordinate;
    private int yCoordinate;

    private final Map map;
    private final String[][] matrix;

    public TransactionGui(Map m, String[][] mat) {
        this.map = m;
        this.matrix = mat;
        this.createUI();
    }

    private void createUI() {
        // Content Pane
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // Choose Pickup Location
        choosePickupLabel = new JLabel("Pick Up Location");
        choosePickupLabel.setBounds(10, 10, 150, 40);
        contentPane.add(choosePickupLabel);

        // String sample[] = {"Pickup 1","Pickup 2","Pickup 3","Pickup 4"};
        String[] pickups = new String[Map.listPickup.size()];
        for (int i = 0; i < pickups.length; i++) {
            pickups[i] = Map.listPickup.get(i).getName();
        }

        choosePickupComboBox = new JComboBox(pickups);
        choosePickupComboBox.setBounds(170, 10, 180, 40);
        contentPane.add(choosePickupComboBox);
        choosePickupComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numPackagesJTF.setEditable(true);
            }
        });

        // Enter number of Packages
        numPackagesLabel = new JLabel("Number of Packages");
        numPackagesLabel.setBounds(10, 60, 150, 40);
        contentPane.add(numPackagesLabel);

        numPackagesJTF = new JTextField();
        // numPackagesJTF.setEditable(false);
        numPackagesJTF.setBounds(170, 60, 180, 40);
        contentPane.add(numPackagesJTF);

        JLabel lblNewLabel = new JLabel("Pick up point:");
        lblNewLabel.setEnabled(false);
        lblNewLabel.setBounds(10, 212, 77, 13);
        getContentPane().add(lblNewLabel);

        JLabel lblPickupPoint = new JLabel("");
        lblPickupPoint.setEnabled(false);
        lblPickupPoint.setBounds(115, 212, 135, 13);
        getContentPane().add(lblPickupPoint);

        JLabel lblNewLabel_2 = new JLabel("Delivery Point: ");
        lblNewLabel_2.setEnabled(false);
        lblNewLabel_2.setBounds(10, 235, 77, 23);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setEnabled(false);
        lblNewLabel_3.setBounds(10, 268, 77, 13);
        getContentPane().add(lblNewLabel_3);

        JLabel lblPackageNum = new JLabel("");
        lblPackageNum.setEnabled(false);
        lblPackageNum.setBounds(115, 268, 45, 13);
        getContentPane().add(lblPackageNum);

        JLabel lblNewLabel_5 = new JLabel("X");
        lblNewLabel_5.setEnabled(false);
        lblNewLabel_5.setBounds(115, 240, 45, 13);
        getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Y");
        lblNewLabel_6.setEnabled(false);
        lblNewLabel_6.setBounds(185, 240, 45, 13);
        getContentPane().add(lblNewLabel_6);

        textX = new JTextField();
        textX.setEnabled(false);
        textX.setBounds(125, 237, 45, 19);
        getContentPane().add(textX);
        textX.setColumns(10);

        textY = new JTextField();
        textY.setEnabled(false);
        textY.setBounds(205, 237, 45, 19);
        getContentPane().add(textY);
        textY.setColumns(10);

        JButton btnNewButton = new JButton("Add Package");
        btnNewButton.setEnabled(false);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = numPackages - k;

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // lblPackageNum.setText(Integer.toString(i-k));

                try {
                    xCoordinate = Integer.parseInt(textX.getText());
                    yCoordinate = Integer.parseInt(textY.getText());

                    if (matrix[xCoordinate][yCoordinate].equals("*")) {
                        //public String pickupLocation;
                        //Removes all the non-numerical charcters in string to match with the cooresponding pickup location
                        String identifier = pickupLocation.substring(pickupLocation.length() - 1);
                        identifier = identifier.replaceAll("[^\\d.]", "");

                        //use the string of the pickup location and the x and y coordinates to add a new package to the packagearraylist of the correct pickup object
                        //public static ArrayList<Package> packageArrayList = new ArrayList<Package>();
                        for (int bruh = 0; bruh < Map.listPickup.size(); bruh++) {
                            if (Map.listPickup.get(bruh).getName().contains(identifier)) {
                                //Adds new package with corresponding origin and destination coordinates to pickup location of user's choice
                                PickUp.packageArrayList.add(new Package(false, false, Map.listPickup.get(bruh).locationX, Map.listPickup.get(bruh).locationY, xCoordinate, yCoordinate));
                                matrix[xCoordinate][yCoordinate] = "D";
                                //System.out.println("Package Added");
                                String name = "Delivery " + (Map.listDelivery.size() + 1);
                                DeliveryPoint delivery = new DeliveryPoint(false, xCoordinate, yCoordinate, name);
                                Map.listDelivery.add(delivery);
                                break;
                            }
                        }


//					Map.listPickup.get(i).getPackageArrayList().get(j);


                        textX.setBackground(Color.white);
                        textY.setBackground(Color.white);

                        if (i > 0) {
                            model.addRow(new Object[]{pickupLocation, textX.getText(), textY.getText(), numPackages});
                        }
                        k++;
                        if (i <= 1) {
                            btnNewButton.setEnabled(false);
                            lblNewLabel.setEnabled(false);
                            lblPickupPoint.setEnabled(false);
                            lblNewLabel_2.setEnabled(false);
                            // lblNewLabel_3.setEnabled(false);
                            // lblPackageNum.setEnabled(false);
                            lblNewLabel_5.setEnabled(false);
                            lblNewLabel_6.setEnabled(false);
                            textX.setEnabled(false);
                            textY.setEnabled(false);
                            k = 0;
                        }
                    } else {
                        //System.out.println("ERROR: Point already occupied");
                        JOptionPane.showMessageDialog(null, "Point already occupied.", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ecp) {
                    textX.setBackground(errorColor);
                    textY.setBackground(errorColor);
                    //System.out.println("ERROR: Must enter valid coordinates.");
                    JOptionPane.showMessageDialog(null, "Must enter valid coordinates.", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(10, 305, 107, 33);
        getContentPane().add(btnNewButton);

        // Buttons on bottom
        // Continue to add package details
        continueButton = new JButton("Next");
        continueButton.setBounds(10, 110, 165, 45);
        contentPane.add(continueButton);
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pickupLocation = (String) choosePickupComboBox.getSelectedItem();
                //System.out.println("Pick Up Location: " + pickupLocation);

                try {
                    numPackages = Integer.parseInt(numPackagesJTF.getText());
                    //System.out.println("packages: " + numPackages);
                    numPackagesJTF.setBackground(Color.white);

                    lblPickupPoint.setText(pickupLocation);
                    // lblPackageNum.setText(Integer.toString(numPackages));
                    btnNewButton.setEnabled(true);
                    lblNewLabel.setEnabled(true);
                    lblPickupPoint.setEnabled(true);
                    lblNewLabel_2.setEnabled(true);
                    // lblNewLabel_3.setEnabled(true);
                    // lblPackageNum.setEnabled(true);
                    lblNewLabel_5.setEnabled(true);
                    lblNewLabel_6.setEnabled(true);
                    textX.setEnabled(true);
                    textY.setEnabled(true);

                } catch (Exception ecp) {
                    numPackagesJTF.setBackground(errorColor);
                    //System.out.println("ERROR: Must enter number in 'Number of Packages' field.");
                    JOptionPane.showMessageDialog(null, "Must enter number in 'Number of Packages' field.", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        // Go Back
        homeButton = new JButton("Go Back to Home");
        homeButton.setBounds(383, 336, 165, 45);
        contentPane.add(homeButton);
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FirstPage home = new FirstPage(map, Map.completedMap);
                home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(504, 24, 346, 302);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Name", "X", "Y", "Num"}));
        scrollPane.setViewportView(table);

        // Information about window
        setTitle("Add Pick Up Location");
        setSize(894, 428);
        setVisible(true);
        setResizable(true);
    }
}

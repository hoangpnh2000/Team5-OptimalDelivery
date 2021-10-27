import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TransactionGui extends JFrame {

	// Elements of UI
	private JLabel choosePickupLabel, numPackagesLabel;
	private JComboBox choosePickupComboBox;
	private JTextField numPackagesJTF;
	private JButton continueButton, cancelButton;
	private JTextField textX;
	private JTextField textY;
	private JTable table;
	private int numPackages;
	private String pickupLocation;
	private int k = 0;

	private Map map;
	private String[][] matrix;

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
		String pickups[] = new String[this.map.listPickup.size()];
		for (int i = 0; i < pickups.length; i++) {
			pickups[i] = map.listPickup.get(i).getName();
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

		JButton btnNewButton = new JButton("Update");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = numPackages - k;

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				// lblPackageNum.setText(Integer.toString(i-k));
				
				try {
					int xCoordinate = Integer.parseInt(textX.getText());
					int yCoordinate = Integer.parseInt(textY.getText());
					
					textX.setBackground(Color.white);
					textY.setBackground(Color.white);
					
					if (i > 0) {
						model.addRow(new Object[] { pickupLocation, textX.getText(), textY.getText(), numPackages });
					}
					k++;
					if (i <= 0) {
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
				} catch (Exception ecp) {
					textX.setBackground(Color.red);
					textY.setBackground(Color.red);
					System.out.println("ERROR: Must enter valid coordinates.");
					JOptionPane.showMessageDialog(null, "Must enter valid coordinates.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(10, 305, 107, 33);
		getContentPane().add(btnNewButton);

		// Buttons on bottom
		// Continue to add package details
		continueButton = new JButton("Continue");
		continueButton.setBounds(10, 110, 165, 45);
		contentPane.add(continueButton);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pickupLocation = (String) choosePickupComboBox.getSelectedItem();
				System.out.println("Pick Up Location: " + pickupLocation);

				try {
					numPackages = Integer.parseInt(numPackagesJTF.getText());
					System.out.println("packages: " + numPackages);
					numPackagesJTF.setBackground(Color.white);

					/*
					 * for(int i=1; i<= numPackages; i++) { //AddTransactionPage page = new
					 * AddTransactionPage(i,numPackages,pickupLocation); }
					 */

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
					numPackagesJTF.setBackground(Color.red);
					System.out.println("ERROR: Must enter number in 'Number of Packages' field.");
					JOptionPane.showMessageDialog(null, "Must enter number in 'Number of Packages' field.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// Cancel
		continueButton = new JButton("Cancel");
		continueButton.setBounds(383, 336, 165, 45);
		contentPane.add(continueButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(504, 24, 346, 302);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "X", "Y", "Num" }));
		scrollPane.setViewportView(table);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// Information about window
		setTitle("Add Pick Up Location");
		setSize(894, 428);
		setVisible(true);
		setResizable(!false);
	}
}

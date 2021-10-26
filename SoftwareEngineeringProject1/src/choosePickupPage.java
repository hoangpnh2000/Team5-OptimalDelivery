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

public class choosePickupPage extends JFrame{

	// Elements of UI
	private JLabel choosePickupLabel, numPackagesLabel;
	private JComboBox choosePickupComboBox;
	private JTextField numPackagesJTF;
	private JButton continueButton, cancelButton; 
	
	public choosePickupPage() {
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
		
		String sample[] = {"Pickup 1","Pickup 2","Pickup 3","Pickup 4"};
		
		choosePickupComboBox = new JComboBox(sample);
		choosePickupComboBox.setBounds(170, 10, 180, 40);
		contentPane.add(choosePickupComboBox);
		choosePickupComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				numPackagesJTF.setEditable(true);
			}
		});
		
		// Enter number of Packages
		numPackagesLabel = new JLabel("Number of Packages");
		numPackagesLabel.setBounds(10, 60, 150, 40);
		contentPane.add(numPackagesLabel);
		
		numPackagesJTF = new JTextField();
		//numPackagesJTF.setEditable(false);
		numPackagesJTF.setBounds(170, 60, 180, 40);
		contentPane.add(numPackagesJTF);
		
		// Buttons on bottom
		// Continue to add package details
		continueButton = new JButton("Continue");
		continueButton.setBounds(10,110,165,45);
		contentPane.add(continueButton);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pickupLocation = (String) choosePickupComboBox.getSelectedItem();
				System.out.println("Pick Up Location: " + pickupLocation);
				
				try {
					int numPackages = Integer.parseInt(numPackagesJTF.getText());
					System.out.println("packages: "+numPackages);
					
					for(int i=1; i<= numPackages; i++) {
						AddTransactionPage page = new AddTransactionPage(i,numPackages,pickupLocation);
					}
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
		continueButton.setBounds(185,110,165,45);
		contentPane.add(continueButton);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		// Information about window
		setTitle("Add Pick Up Location");
		setSize(360,210);
		setVisible(true);
		setResizable(!false);
	}
}

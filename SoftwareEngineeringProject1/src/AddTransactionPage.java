import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddTransactionPage extends JFrame{
	
	// Elements of UI
	private JButton addButton;
	private JLabel pickupLabel, pickupLocationLabel, chooseDeliveryLabel;
	private JTextField deliveryFieldX, deliveryFieldY;
	
	// 
	private int packageNum, totalPackages;
	private String pickupLocation; 
	
	public AddTransactionPage(int num, int total, String location) {
		this.packageNum = num;
		this.totalPackages = total;
		this.pickupLocation = location;
		this.createUI();
	}
	
	private void createUI() {
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		// Choose Pickup Location for Transaction
		pickupLabel = new JLabel("Pick Up Point");
		pickupLabel.setHorizontalAlignment(JLabel.CENTER);
		pickupLabel.setBounds(10, 60, 100, 40);
		contentPane.add(pickupLabel);
		
		pickupLocationLabel = new JLabel(pickupLocation);
		pickupLocationLabel.setBounds(110,60,180,40);
		contentPane.add(pickupLocationLabel);
		
		// Choose X and Y coordinates for delivery location
		chooseDeliveryLabel = new JLabel("Delivery Point");
		chooseDeliveryLabel.setHorizontalAlignment(JLabel.CENTER);
		chooseDeliveryLabel.setBounds(10, 90, 100, 40);
		contentPane.add(chooseDeliveryLabel);
		
		
		deliveryFieldX = new JTextField("X");
		deliveryFieldX.setHorizontalAlignment(JTextField.CENTER);
		deliveryFieldX.setBounds(110,90,90,40);
		contentPane.add(deliveryFieldX);
		
		deliveryFieldY = new JTextField("Y");
		deliveryFieldY.setHorizontalAlignment(JTextField.CENTER);
		deliveryFieldY.setBounds(200,90,90,40);
		contentPane.add(deliveryFieldY);
		
		
		addButton = new JButton("Add Transaction");
		addButton.setBounds(10, 140, 280, 45);
		contentPane.add(addButton);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				// Go back to home page 
				dispose();
			}
		});
		
		setTitle("Package " + packageNum + " out of " + totalPackages);
		setSize(300,250);
		setVisible(true);
		setResizable(!false);
	}

}

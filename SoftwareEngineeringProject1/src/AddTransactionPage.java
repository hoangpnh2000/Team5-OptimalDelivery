import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AddTransactionPage extends JFrame{
	
	private JButton backButton, addButton;
	private JLabel choosePickupText, chooseDeliveryText;
	private JComboBox pickupDropdown, deliveryDropdown;
	
	public AddTransactionPage() {
		this.createUI();
	}
	
	private void createUI() {
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		backButton = new JButton("< Back");
		backButton.setBounds(10, 10, 100, 45);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				FirstPage page1 = new FirstPage();
				page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		
		choosePickupText = new JLabel("Pick Up Point");
		choosePickupText.setHorizontalAlignment(JLabel.CENTER);
		choosePickupText.setBounds(10, 60, 100, 40);
		contentPane.add(choosePickupText);
		
		pickupDropdown = new JComboBox();
		pickupDropdown.setBounds(110,60,180,40);
		contentPane.add(pickupDropdown);
		
		chooseDeliveryText = new JLabel("Delivery Point");
		chooseDeliveryText.setHorizontalAlignment(JLabel.CENTER);
		chooseDeliveryText.setBounds(10, 90, 100, 40);
		contentPane.add(chooseDeliveryText);
		
		deliveryDropdown = new JComboBox();
		deliveryDropdown.setBounds(110,90,180,40);
		contentPane.add(deliveryDropdown);
		
		addButton = new JButton("Add Transaction");
		addButton.setBounds(10, 140, 280, 45);
		contentPane.add(addButton);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				FirstPage page1 = new FirstPage();
				page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		
		setTitle("Add Transaction");
		setSize(300,250);
		setVisible(true);
		setResizable(!false);
	}

}

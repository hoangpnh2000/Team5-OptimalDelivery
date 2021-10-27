import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;

public class SeeRoutesPage extends JFrame{

	private JLabel pickTruckLabel;
	private JComboBox trucksComboBox;
	private JButton seeRouteButton;
	private JTextArea routesJTA;
	
	private Map map;
	private String[][] matrix;
	
	public SeeRoutesPage(Map m, String[][] mat) {
		this.map = m;
		this.matrix = mat;
		createUI();
	}
	
	private void createUI() {
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		pickTruckLabel = new JLabel("Truck #");
		pickTruckLabel.setBounds(10,10,75,40);
		contentPane.add(pickTruckLabel);
		
		trucksComboBox = new JComboBox();
		trucksComboBox.setBounds(90,10,300,40);
		contentPane.add(trucksComboBox);
		
		seeRouteButton = new JButton("See Route");
		seeRouteButton.setBounds(400,10,90,40);
		contentPane.add(seeRouteButton);
		
		routesJTA = new JTextArea();
		BevelBorder b = new BevelBorder(BevelBorder.LOWERED);
		routesJTA.setBorder(b);
		JScrollPane routesScrollPane = new JScrollPane(routesJTA);
		routesScrollPane.setBounds(10,50,480,400);
		contentPane.add(routesScrollPane);
		
		
		setTitle("Routes");
		setSize(500,500);
		setResizable(true);
		setVisible(true);
	}
	
}

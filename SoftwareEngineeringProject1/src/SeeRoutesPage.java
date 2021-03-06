import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class SeeRoutesPage extends JFrame{

	private JLabel pickTruckLabel;
	private JComboBox trucksComboBox;
	private JButton seeRouteButton;
	private JTextArea routesJTA;
	
	private Map map;
	private String[][] matrix;
	private Route route;
	
	public SeeRoutesPage(Map m, String[][] mat) {
		this.map = m;
		this.matrix = mat;
		
		route = new Route();
		route.initialBestRoute();
		
		createUI();
	}
	
	private void createUI() {
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		pickTruckLabel = new JLabel("Truck #");
		pickTruckLabel.setBounds(10, 10, 75, 40);
		contentPane.add(pickTruckLabel);

		String trucks[] = new String[this.map.listTruck.size()];
		for (int i = 0; i < trucks.length; i++) {
			trucks[i] = map.listTruck.get(i).getName();
		}

		trucksComboBox = new JComboBox(trucks);
		trucksComboBox.setBounds(90, 10, 280, 40);
		contentPane.add(trucksComboBox);

		seeRouteButton = new JButton("See Route");
		seeRouteButton.setBounds(380, 10, 100, 40);
		contentPane.add(seeRouteButton);
		seeRouteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				routesJTA.setText("");

				int index = trucksComboBox.getSelectedIndex();
				for (int j = 0; j < route.routes.get(index).size(); j++) {
					routesJTA.append(route.routes.get(index).get(j) + "\n");
				}
			}
		});

		routesJTA = new JTextArea();
		routesJTA.setEditable(false);
		BevelBorder b = new BevelBorder(BevelBorder.LOWERED);
		routesJTA.setBorder(b);
		JScrollPane routesScrollPane = new JScrollPane(routesJTA);
		routesScrollPane.setBounds(10, 50, 480, 400);
		contentPane.add(routesScrollPane);


		setTitle("Routes");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
	}
}

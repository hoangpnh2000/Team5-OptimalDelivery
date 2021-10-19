//import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FirstPage extends JFrame{
	
	private JLabel welcomeText;
	private JButton addTransactionButton, seeMapButton, seeTransactionsButton;
	
	public FirstPage() {
		this.createUI();
	}
	
	private void createUI() {
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		welcomeText = new JLabel("Optimal Delivery");
		welcomeText.setHorizontalAlignment(JLabel.CENTER);
		welcomeText.setFont(new Font("Arial",Font.BOLD,20));
		welcomeText.setBounds(10, 10, 280, 40);
		contentPane.add(welcomeText);
		
		addTransactionButton = new JButton("Add Transaction");
		addTransactionButton.setBounds(10, 55, 280, 50);
		contentPane.add(addTransactionButton);
		addTransactionButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				@SuppressWarnings("unused")
				AddTransactionPage page2 = new AddTransactionPage();
				dispose();
			}
		});
		
		seeMapButton = new JButton("Map");
		seeMapButton.setBounds(10, 105, 280, 50);
		contentPane.add(seeMapButton);
		
		seeTransactionsButton = new JButton("List of Transactions");
		seeTransactionsButton.setBounds(10, 155, 280, 50);
		contentPane.add(seeTransactionsButton);
		
		
		setTitle("Optimal Delivery");
		setSize(300,250);
		setVisible(true);
		setResizable(false);
	}
}
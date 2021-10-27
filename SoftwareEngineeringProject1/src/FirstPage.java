//import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FirstPage extends JFrame {

    private JLabel welcomeText;
    private JButton addTransactionButton, seeMapButton, routesButton, helpButton;

    
    private Map map;
    private String[][] matrix;
    
    public FirstPage(Map m, String[][] mat) {
    	this.map = m;
    	this.matrix = mat;
        this.createUI();
    }

    private void createUI() {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        welcomeText = new JLabel("Optimal Delivery");
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeText.setBounds(10, 10, 280, 40);
        contentPane.add(welcomeText);

        addTransactionButton = new JButton("Add Transaction");
        addTransactionButton.setBounds(10, 55, 280, 50);
        contentPane.add(addTransactionButton);
        addTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                @SuppressWarnings("unused")
                TransactionGui page2 = new TransactionGui(map,matrix);
            }
        });

        seeMapButton = new JButton("Map");
        seeMapButton.setBounds(10, 105, 280, 50);
        contentPane.add(seeMapButton);
        seeMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
            	System.out.println("Opening Map");
                @SuppressWarnings("unused")
                JFrame window = new JFrame();
                window.setResizable(!false);
                window.setTitle("Map");
                Panel panel = new Panel(map, matrix);
                JScrollPane scrollPane = new JScrollPane(panel);
                window.add(scrollPane);
                window.pack();
                window.setLocationRelativeTo(null);
                window.setVisible(true);
                //dispose();
            }
        });

        routesButton = new JButton("Start Routes");
        routesButton.setBounds(10, 155, 280, 50);
        contentPane.add(routesButton);
        routesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
            	System.out.println("Opening Routes Page");
                SeeRoutesPage page3 = new SeeRoutesPage(map,matrix);
                addTransactionButton.setEnabled(false);
                routesButton.setEnabled(false);
            }
        });
        
        
        helpButton = new JButton("Help");
        helpButton.setBounds(10, 205, 280, 50);
        contentPane.add(helpButton);
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
            	System.out.println("Opening Help Page");
                HelpPage page4 = new HelpPage(map,matrix);
            }
        });

        setTitle("Optimal Delivery");
        setSize(300, 300);
        setVisible(true);
        setResizable(false);
    }
}
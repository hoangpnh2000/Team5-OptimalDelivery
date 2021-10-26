//import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FirstPage extends JFrame {

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
        welcomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeText.setBounds(10, 10, 280, 40);
        contentPane.add(welcomeText);

        addTransactionButton = new JButton("Add Transaction");
        addTransactionButton.setBounds(10, 55, 280, 50);
        contentPane.add(addTransactionButton);
        addTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                @SuppressWarnings("unused")
                choosePickupPage page2 = new choosePickupPage();
            }
        });

        seeMapButton = new JButton("Map");
        seeMapButton.setBounds(10, 105, 280, 50);
        contentPane.add(seeMapButton);
        seeMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                @SuppressWarnings("unused")
                JFrame window = new JFrame();
                window.setResizable(false);
                window.setTitle("2D Adventure");
                Panel panel = new Panel();
                window.add(panel);
                window.pack();
                window.setLocationRelativeTo(null);
                window.setVisible(true);
                //dispose();
            }
        });

        seeTransactionsButton = new JButton("See Route");
        seeTransactionsButton.setBounds(10, 155, 280, 50);
        contentPane.add(seeTransactionsButton);
        seeTransactionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                @SuppressWarnings("unused")
                SeeRouteGui route = new SeeRouteGui();
            }
        });

        setTitle("Optimal Delivery");
        setSize(300, 250);
        setVisible(true);
        setResizable(false);
    }
}
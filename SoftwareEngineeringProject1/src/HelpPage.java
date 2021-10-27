import javax.swing.*;
import java.awt.*;

public class HelpPage extends JFrame {

    private JLabel titleJLabel;
    private JTextArea infoJTA;
    
    private Map map;
    private String[][] matrix;

    public HelpPage(Map m, String[][] mat){
    	this.map = m;
    	this.matrix = mat;
        createUI();
    }

    private void createUI(){
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);

        titleJLabel = new JLabel("How does this program work?");
        titleJLabel.setBounds(0,10,500,50);
        titleJLabel.setFont(new Font("Arial",Font.BOLD,20));
        titleJLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(titleJLabel);
        
        String helpText = "OptimalDelivery is a logistics company that wants to move shipments from Producer to Consumer in a distance-optimal manner. They have a fleet of \n"
        		+ "5 trucks to pick up from 5 (predetermined) pickup points, and deliver to \n"
        		+ "0 receiving points. This program is to calculate the best way for the Trucks to fulfill orders in order to minimize on fuel costs. \n"
        		+ "\n"
        		+ "\n"
        		+ "Map:\n"
        		+ "\n"
        		+ "Click on the \"Map\" Button to visualize the area in which OptimalDelivery \n"
        		+ "operates. Trucks are marked by RED Tiles, Pickup Points are marked by \n"
        		+ "BLUE Tiles, and Delivery Points are marked by GREEN Tiles. \n"
        		+ "\n"
        		+ "\n"
        		+ "Adding Transactions:\n"
        		+ "\n"
        		+ "To add the orders for today, our user (i.e. a manager or administrator) \n"
        		+ "would click the \"Add Transaction\" button. \n"
        		+ "\n"
        		+ "First, choose the Pickup Point from where you will deliver the package(s). \n"
        		+ "Once you do that, enter the amount of packages coming from that pickup \n"
        		+ "point. \n"
        		+ "\n"
        		+ "After that, enter the x and y coordinates for each of the packages and click \n"
        		+ "\"Add Package\". You will then see the details for each of the transactions \n"
        		+ "you just added on the table to the right.\n"
        		+ "\n"
        		+ "Finally click 'Go Back to Home' to return to the home page.\n"
        		+ "\n"
        		+ "\n"
        		+ "Starting the Route:\n"
        		+ "\n"
        		+ "Once Transactions have been added to the system, you can start the day's \n"
        		+ "route by clicking the \"Start Route\" button on the home page. In that page, \n"
        		+ "you can see the points that each trucks travels in its route by selecting the \n"
        		+ "truck whose route you want to see, and subsequently clicking \"See Route\". \n"
        		+ "";

        infoJTA = new JTextArea(helpText);
        infoJTA.setLineWrap(true);
        infoJTA.setEditable(!false);
        JScrollPane scroll = new JScrollPane(infoJTA);
        scroll.setBounds(5,60,500,440);
        contentPane.add(scroll);

        setTitle("Help");
        setSize(510,500);
        setVisible(true);
        setResizable(false);
    }
}

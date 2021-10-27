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
        
        String helpText = "OptimalDelivery is a logistics company that wants to move shipments from \n"
        		+ "Producer to Consumer in a distance-optimal manner. They have a fleet of "+map.listTruck.size()+"\n"
        		+ "trucks to pick up from "+map.listPickup.size()+" (predetermined) pickup points, and deliver to "+map.listDelivery.size()+" \n"
        		+ "receiving points. This program is to calculate the best way for the Trucks to \n"
        		+ "fulfill orders in order to minimize on fuel costs. \n"
        		+ "\n"
        		+ "Map:\n"
        		+ "\n"
        		+ "Click on the \"Map\" Button to visualize the area in which OptimalDelivery \n"
        		+ "operates. Trucks are marked by RED Tiles, Pickup Points are marked by BLUE \n"
        		+ "Tiles, and Delivery Points are marked by GREEN Tiles. \n"
        		+ "\n"
        		+ "\n"
        		+ "Adding Transactions:\n"
        		+ "\n"
        		+ "To add the orders for today, our user (i.e. a manager or administrator) would \n"
        		+ "click the \"Add Transactions\" button. \n"
        		+ "\n"
        		+ "First, choose the Pickup Point from where you will deliver the package(s). Once\n "
        		+ "you do that, enter the amount of packages coming from that pickup point. \n\n"
        		+ "After that, enter the x and y coordinates for each of the packages and click \n"
        		+ "\"Update\". You will then see the details for each of the transactions you just \n"
        		+ "added on the table to the right. ";

        infoJTA = new JTextArea(helpText);
        infoJTA.setBounds(5,60,500,440);
        infoJTA.setLineWrap(true);
        infoJTA.setEditable(false);
        contentPane.add(infoJTA);

        setTitle("Help");
        setSize(510,500);
        setVisible(true);
        setResizable(false);
    }
}

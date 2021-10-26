import javax.swing.*;
import java.awt.*;

public class HelpPage extends JFrame {

    private JLabel titleJLabel;
    private JTextArea infoJTA;

    public HelpPage(){
        createUI();
    }

    private void createUI(){
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        titleJLabel = new JLabel("How does this work?");
        titleJLabel.setBounds(0,10,500,50);
        titleJLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(titleJLabel);

        infoJTA = new JTextArea();
        infoJTA.setBounds(0,60,500,440);
        contentPane.add(infoJTA);

        setTitle("Help");
        setSize(500,500);
        setVisible(true);
    }
}

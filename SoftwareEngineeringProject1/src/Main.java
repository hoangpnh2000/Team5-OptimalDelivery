import javax.swing.JFrame;
/*
public class Main {


    public static void main(String[] args) {
        // TODO Auto-generated method stub


        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        Panel panel = new Panel();
        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //panel.startRunThread();

    }

}
*/
public class Main {
    public static void main(String args[]) {
        //Map map = new Map();
        //System.out.println(map.generate(10,10,3,5,5));

        FirstPage page1 = new FirstPage();
        page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Opening First Page");
    }
}


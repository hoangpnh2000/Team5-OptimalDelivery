import java.util.Random;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

    	// Generate map once Program Starts
    	Random rand = new Random();
    	int rows = rand.nextInt(50);
    	int columns = rand.nextInt(50);
    	int size = rows * columns;
    	int limit = size/3;
    	int trucks = rand.nextInt(limit);
    	int pickups = rand.nextInt(limit);
    	int deliveries = rand.nextInt(limit);
    	
    	System.out.println("Map Generated");
    	System.out.println(rows+" by "+columns+" Map with "+trucks+" trucks and "
    			+pickups+" pick up points.");
    	
    	Map map = new Map();
    	String mat[][] = map.generate(rows,columns,trucks,pickups,deliveries);

        FirstPage page1 = new FirstPage(map, mat);
        page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Opening First Page");
        
    	/*
    	TransactionGui page=new TransactionGui();
    	page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

        //panel.startRunThread();

    }

}

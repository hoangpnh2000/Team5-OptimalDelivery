import java.util.Random;

import javax.swing.*;

public class Main {

	private static Map map;

    public static void main(String[] args) {

    	// Generate map once Program Starts
    	Random rand = new Random();
    	int rows = rand.nextInt(10) + 4;
    	int columns = rand.nextInt(10) + 4;
    	int size = rows * columns;
    	int limit = size/3;
    	int trucks = rand.nextInt(limit) + 1;
    	int pickups = rand.nextInt(limit) + 1;
    	int deliveries = rand.nextInt(limit) + 1;
    	
    	System.out.println(rows+" by "+columns+" Map with "+trucks+" trucks and "
    			+pickups+" pick up points.");
    	
    	map = new Map();
		System.out.println("Map Generated");
		map.generate(rows,columns,trucks,pickups);

        FirstPage page1 = new FirstPage(map, map.completedMap);
        page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Opening First Page");

    	/*
    	TransactionGui page=new TransactionGui();
    	page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

        //panel.startRunThread();

    }

}

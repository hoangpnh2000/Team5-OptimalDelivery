import java.util.Random;

import javax.swing.*;

public class Main {

	private static Map map;
	public static int xMapSize;
	public static int yMapSize;
    public static void main(String[] args) {

    	// Generate map once Program Starts
    	Random rand = new Random();
    	int xMapSize = 10;
    	int yMapSize = 10;
		int size = xMapSize + yMapSize;
		int limit = size/10;
    	int pickups = rand.nextInt(limit) + 1;
		int trucks = rand.nextInt(limit) + 1;

		//System.out.println(xMapSize+" by "+yMapSize+" Map with "+trucks+" trucks and "
		//		+pickups+" pick up points.");
    	
    	map = new Map();
		//System.out.println("Map Generated");
		map.generate(xMapSize,yMapSize,trucks,pickups);

        FirstPage page1 = new FirstPage(map, map.completedMap);
        page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.out.println("Opening First Page");

    	/*
    	TransactionGui page=new TransactionGui();
    	page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

        //panel.startRunThread();

    }

}

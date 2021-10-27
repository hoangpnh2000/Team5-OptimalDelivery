import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {

	//Screen settings
	final int originalTileSize=16; // 16x16 title
	final int scale= 3;

	final int tileSize= originalTileSize*scale;//48x48 tile
	final int maxScreenCol;
	final int maxScreenRow;
	final int  screenWidth;
	final int screenHeight;
	private Map map;
	String[][] M;
	Thread runThread;

	public Panel(Map m, String[][] mat) {
		this.map = m;
		this.M = mat;

		maxScreenRow = M[0].length;
		maxScreenCol = M.length;

		screenWidth= tileSize*maxScreenRow;
		screenHeight= tileSize*maxScreenCol;

		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}

	public void startRunThread() {
		runThread = new Thread(this);
		runThread.start();
	}

	@Override
	public void run() {
		while(runThread != null) {
			//System.out.println("running");
			//1:Update character position
			update();
			//2:Draw
			repaint();
		}
	}

	public void update() {
		for (int i = 0; i < Map.listPickup.size(); i++){
			  for (int j = 0; j< Map.listPickup.get(i).getPackageArrayList().size(); j++){
			    int xcoord = Map.listPickup.get(i).getPackageArrayList().get(j).destinationX;
			    int ycoord = Map.listPickup.get(i).getPackageArrayList().get(j).destinationY;
			    System.out.println(xcoord+" "+ycoord);
			  }
			}
	}

	public void paintComponent(Graphics g) {
		update();
		
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;

		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M[0].length;j++) {
				if(M[i][j].equals("T")) {
					g2.setColor(Color.RED);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
				}else if(M[i][j].equals("P")) {
					g2.setColor(Color.BLUE);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
				}else if(M[i][j].equals("D")) {
					g2.setColor(Color.GREEN);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
			    }else {
			    	g2.setColor(Color.WHITE);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
			    }
			}}
		g2.dispose();
	}
}
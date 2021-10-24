import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {

	//Screen settings
	final int originalTileSize=16; // 16x16 title
	final int scale= 3;

	final int tileSize= originalTileSize*scale;//48x48 tile
	final int maxScreenCol=16;
	final int maxScreenRow=12;
	final int  screenWidth= tileSize*maxScreenCol; //768 pixels
	final int screenHeight= tileSize*maxScreenRow; //576 pixels
	String[][] M=new String[5000][5000];
	Thread runThread;

	public Panel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		Map map= new Map();
		M=map.generate(10,10, 2, 1, 5);

	}


	public void startRunThread() {
		runThread = new Thread(this);
		runThread.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(runThread != null) {

			//System.out.println("running");

			//1:Update character position
			update();
			//2:Draw
			repaint();
		}
	}

	public void update() {
	}
	public void paintComponent(Graphics g) {


		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;

		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M.length;j++) {
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

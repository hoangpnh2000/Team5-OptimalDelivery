package main;


import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

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
	
	Thread runThread;
	
	public Panel() {
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
		int[][] M=new int[50][50];

		
		super.paintComponent(g);
		
		Graphics2D g2= (Graphics2D)g;
		
		Map map= new Map();
		M=map.generate(5, 5, 1, 1, 1);
		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M.length;j++) {
				if(M[i][j]==1) {
					g2.setColor(Color.RED);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
				}else if(M[i][j]==2) {
					g2.setColor(Color.BLUE);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
				}else if(M[i][j]==3) {
					g2.setColor(Color.GREEN);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
			    }else {
			    	g2.setColor(Color.WHITE);
					g2.fillRect(j*30,i*30,tileSize/2,tileSize/2);
			    }
				
				
			}}
		
		
		/*
		g2.setColor(Color.BLUE);
		
		g2.fillRect(0*30,0*30,tileSize/2,tileSize/2);
		
		g2.setColor(Color.GREEN);
		
		g2.fillRect(4*30,0*30,tileSize/2,tileSize/2);*/
		g2.dispose();
		
	}
	
	
}

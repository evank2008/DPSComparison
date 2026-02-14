package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.*;

public class Graph extends JPanel{
	int xIncrement=1;
	int yIncrement=200;
	int width,  height,  xMin,  xMax,  yMin,  yMax;
	double xScale, yScale;
	Troop[] troops;

	public Graph(int width, int height, int xMin, int xMax, int yMin, int yMax, Troop[] troops) {
		super();
		this.setSize(width,height);
		this.width=width;
		this.height=height;
		this.xMin=xMin;
		this.xMax=xMax;
		this.yMin=yMin;
		this.yMax=yMax;
		xScale = (double) width / (xMax - xMin);
		yScale = (double) height / (yMax - yMin);
		this.troops=troops;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draw the graph lines
		System.out.println("drawing");
		
		g.setColor(new Color(200,200,200));
		for(int i = xMin;i<=xMax;i+=xIncrement) {
			g.fillRect(getScreenPos(i,true), 0, 1, height);
		}
		for(int i = yMin;i<=yMax;i+=yIncrement) {
			g.fillRect(0, getScreenPos(i,false), width, 2);
		}
		
		g.setColor(new Color(150,150,150));
		for(int i = 0;i<=xMax;i+=5*xIncrement) {
			g.fillRect(getScreenPos(i,true), 0, 1, height);
		}
		for(int i = 0;i<=yMax;i+=5*yIncrement) {
			g.fillRect(0, getScreenPos(i,false), width, 1);
		}
		
		g.setColor(Color.black);
		g.fillRect(getScreenPos(0,true), 0, 2, height);
		g.fillRect(0, getScreenPos(0,false), width, 2);
		
		for(Troop t: troops) {
			plotTroop(t,g);
		}
		
	}
	int getScreenPos(double value, boolean isXValue) {
		if(isXValue) {
			return (int) ((value-xMin)*xScale);
		} else {
			return height-(int) ((value-yMin)*yScale);
		}
		

	}
	public void plotTroop(Troop troop, Graphics g) {
		System.out.println("plotting troop");
		double time = 0;
		int damage=0;
		Point lastPoint = new Point(getScreenPos(0,true),getScreenPos(0,false));
		while(time<=xMax) {
			double[] hit = troop.getNextHit();
			time+=hit[0];
			damage+=hit[1];
			Point newPoint = new Point(getScreenPos(time,true),getScreenPos(damage,false));
			int width=(int) (hit[0]*xScale);
			int thickness=2;
			g.setColor(troop.getColor());
			g.fillRect(lastPoint.x, lastPoint.y, width, thickness);
			int height = lastPoint.y-newPoint.y;
			g.fillRect(newPoint.x-thickness, lastPoint.y-height, thickness, height+thickness);
			lastPoint=newPoint;
			
		}
	}
	

}

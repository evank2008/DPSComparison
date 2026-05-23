package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Graph extends JPanel implements KeyListener{
	int xIncrement=1;
	int yIncrement=200;
	int width,  height,  xMin,  xMax,  yMin,  yMax;
	double xScale, yScale;
	Troop[] troops;
	boolean ctrlPressed = false;

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
		this.requestFocusInWindow();
		
	}
	public void paintComponent(Graphics gg) {
		super.paintComponent(gg);
		Graphics2D g = (Graphics2D) gg;
		//draw the graph lines
		g.setFont(g.getFont().deriveFont(20f));
		g.setColor(new Color(200,200,200));
		for(int i = xMin;i<=xMax;i+=xIncrement) {
			g.drawLine(getScreenPos(i,true), 0, getScreenPos(i,true), height);
		}
		for(int i = yMin;i<=yMax;i+=yIncrement) {
			g.drawLine(0, getScreenPos(i,false), width, getScreenPos(i,false));
		}
		for(int i = 0;i<=xMax;i+=5*xIncrement) {
			g.setColor(new Color(150,150,150));
			g.drawLine(getScreenPos(i,true), 0, getScreenPos(i,true), height);
		}
		g.setColor(new Color(150,150,150));
		for(int i = 0;i<=yMax;i+=5*yIncrement) {
			g.drawLine(0, getScreenPos(i,false), width, getScreenPos(i,false));
		}
		
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(2));
		g.drawLine(getScreenPos(0, true), 0, getScreenPos(0, true), height);
		g.drawLine(0, getScreenPos(0, false), width, getScreenPos(0, false));

		//draw the number strings
		for(int i = 5*xIncrement;i<=xMax;i+=5*xIncrement) {
			if(i<=5*xIncrement) {
				g.setColor(this.getBackground());
				g.fillRect(getScreenPos(i,true)-8, getScreenPos(0,false)+5, 16, 20);
				g.setColor(Color.black);
				g.drawString(""+i, getScreenPos(i,true)-5, getScreenPos(0,false)+22);
			} else {
				g.setColor(this.getBackground());
				g.fillRect(getScreenPos(i,true)-8, getScreenPos(0,false)+5, 16, 20);
				g.setColor(Color.black);
				g.drawString(""+i, getScreenPos(i,true)-10, getScreenPos(0,false)+22);
			}
		}
		for(int i = 5*yIncrement;i<=yMax;i+=5*yIncrement) {
			g.setColor(this.getBackground());
			g.fillRect(getScreenPos(0,true)-50, getScreenPos(i,false)-10, 45, 20);
			g.setColor(Color.black);
			g.drawString(""+i,getScreenPos(0,true)-50,getScreenPos(i,false)+6);
		}
		g.setColor(this.getBackground());
		g.fillRect(getScreenPos(0,true)-25, getScreenPos(0,false)+5, 16, 20);
		g.setColor(Color.black);
		g.drawString("0", getScreenPos(0,true)-25, getScreenPos(0,false)+22);
		
		g.setColor(Color.black);
		g.setFont(g.getFont().deriveFont(16f).deriveFont(Font.BOLD));
		g.drawString("Time (s)", getScreenPos(7, true), getScreenPos(0, false)+22);
		g.drawString("Damage", getScreenPos(-1.8, true), getScreenPos(1500, false));
		
		//color key on right
		g.setColor(Color.white);
		int h = troops.length;
		int bottom = getScreenPos(yIncrement, false);
		int top = getScreenPos(yIncrement*(h+3), false);
		g.fillRect(getScreenPos(13, true), top, getScreenPos(19, true)-getScreenPos(13, true), bottom-top);
		g.setColor(Color.black);
		g.drawRect(getScreenPos(13, true), top, getScreenPos(19, true)-getScreenPos(13, true), bottom-top);
		g.drawString("Key", getScreenPos(15, true)+10, getScreenPos(yIncrement*(h+2),false)-8);
		
		int row = 0;
		for(Troop t: troops) {
			plotTroop(t,g);
			
			g.drawString(t.getName(), getScreenPos(13.2, true), getScreenPos(yIncrement*(h-row), false)-8);
			g.fillRect(getScreenPos(18, true), getScreenPos(yIncrement*(h+0.75-row), false),(int)(xIncrement*0.7*xScale), (int)(yIncrement*0.5*yScale));
			
			row++;
		}
		
	}
	int getScreenPos(double value, boolean isXValue) {
		if(isXValue) {
			return (int) ((value-xMin)*xScale);
		} else {
			return height-(int) ((value-yMin)*yScale);
		}
		

	}
	public void plotTroop(Troop troop, Graphics gg) {
		Graphics2D g = (Graphics2D) gg;
		System.out.println("plotting troop");
		double time = 0;
		int damage=0;
		Point lastPoint = new Point(getScreenPos(0,true),getScreenPos(0,false));
		troop.reset();
		while(time<=xMax) {
			double[] hit = troop.getNextHit();
			time+=hit[0];
			damage+=hit[1];
			Point newPoint = new Point(getScreenPos(time,true),getScreenPos(damage,false));
			g.setColor(troop.getColor());
			g.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
			
			//draw lines
			g.drawLine(lastPoint.x, lastPoint.y, newPoint.x, lastPoint.y);
			g.drawLine(newPoint.x, lastPoint.y, newPoint.x, newPoint.y);
			
			lastPoint=newPoint;
			
		}
	}
	

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_CONTROL) {
			this.ctrlPressed=true;
		}
		if(e.getKeyCode()==e.VK_S) {
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to save this image to your default user directory?")==JOptionPane.OK_OPTION) {
				DPSComparison.saveImage();
			}
		}
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_CONTROL) {
			this.ctrlPressed=false;
		}
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

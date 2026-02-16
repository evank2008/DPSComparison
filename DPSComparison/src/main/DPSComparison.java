package main;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DPSComparison {
	boolean saveFileRightNow=false;
	static JFrame frame;
	Graph graph;
	public static final int WIDTH=800,HEIGHT=600;
public static void main(String[] args) {
	new DPSComparison();
}

public DPSComparison() {
	frame = new JFrame();
	frame.setSize(WIDTH,HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	
	graph = new Graph(WIDTH,HEIGHT,-2,21,-600,3800, new Troop[]{
			new EvolvedMusketeer(),
			new Musketeer(),
			new LittlePrince(true),
			new LittlePrince(false),
	});
	frame.add(graph);
	frame.setVisible(true);
	frame.addKeyListener(graph);
}
	
public static void saveImage() {
	Container content = frame.getContentPane();

	BufferedImage image = new BufferedImage(
	        content.getWidth(),
	        content.getHeight(),
	        BufferedImage.TYPE_INT_ARGB
	);

	Graphics2D g2d = image.createGraphics();
	content.paint(g2d);
	g2d.dispose();

	try {
		Path path = Paths.get(System.getProperty("user.home"), "damageComparison.png");
		ImageIO.write(image, "png", path.toFile());
System.out.println("success");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}


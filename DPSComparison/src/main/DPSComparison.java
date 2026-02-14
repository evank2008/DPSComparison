package main;

import javax.swing.*;

public class DPSComparison {
	JFrame frame;
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
			new Archers(),
			new LittlePrince(),
	});
	frame.add(graph);
	frame.setVisible(true);
	
	
}
}

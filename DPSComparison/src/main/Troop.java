package main;

import java.awt.Color;

public abstract class Troop {

	
	public abstract double[] getNextHit();
	//index 0 is the time
	//index 1 is the damage
	
	public abstract Color getColor();
}

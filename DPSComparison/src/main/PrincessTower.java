package main;

import java.awt.Color;

public class PrincessTower extends Troop{

	boolean firstHit=false;
	@Override
	public double[] getNextHit() {
		
		
		return new double[] {0.8, 109};
	}

	@Override
	public Color getColor() {
		return new Color(43,26,99);
	}

	void reset() {
		firstHit=false;
	}
	public String getName() {
		return "Princess Tower";
	}
}

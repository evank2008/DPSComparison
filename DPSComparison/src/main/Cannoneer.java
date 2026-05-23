package main;

import java.awt.Color;

public class Cannoneer extends Troop{

	boolean firstHit=false;
	@Override
	public double[] getNextHit() {
		
		if(!firstHit) {
			firstHit=true;
			return new double[] {0.8, 320};
		}
		return new double[] {2.2,320};
	}

	@Override
	public Color getColor() {
		return new Color(84,122,156);
	}

	void reset() {
		firstHit=false;
	}
	public String getName() {
		return "Cannoneer";
	}
}

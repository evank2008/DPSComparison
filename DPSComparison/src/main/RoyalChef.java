package main;

import java.awt.Color;

public class RoyalChef extends Troop{

	boolean firstHit=false;
	@Override
	public double[] getNextHit() {
		
		if(!firstHit) {
			firstHit=true;
			return new double[] {0.8, 109};
		}
		return new double[] {1,109};
	}

	@Override
	public Color getColor() {
		return new Color(99,69,30);
	}

	void reset() {
		firstHit=false;
	}
	public String getName() {
		return "Royal Chef";
	}
}

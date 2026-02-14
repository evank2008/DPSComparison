package main;

import java.awt.Color;

public class LittlePrince extends Troop{
	boolean firstHit=false;
	@Override
	public double[] getNextHit() {
		
		if(!firstHit) {
			firstHit=true;
			return new double[]{0.5,224};
		}
		return new double[] {0.9, 224};
	}

	@Override
	public Color getColor() {
		return new Color(3,161,43);
	}

}

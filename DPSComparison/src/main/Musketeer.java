package main;

import java.awt.Color;

public class Musketeer extends Troop{

	boolean firstHit=false;
	@Override
	public double[] getNextHit() {
		
		if(!firstHit) {
			firstHit=true;
			return new double[]{0.7,217};
		}
		return new double[] {1, 217};
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(237, 117, 255);
	}

	@Override
	void reset() {
		firstHit=false;		
	}

}

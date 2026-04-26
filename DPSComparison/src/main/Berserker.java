package main;

import java.awt.Color;

public class Berserker extends Troop{

	boolean firstHit=false;
	@Override
	public double[] getNextHit() {
		// TODO Auto-generated method stub
		if(!firstHit) {
			firstHit=true;
			return new double[]{0.2,102};
		}
		return new double[] {0.6, 102};
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(242, 94, 37);
	}

	@Override
	void reset() {
		// TODO Auto-generated method stub
		firstHit=false;
	}
	public String getName() {
		return "Berserker";
	}
}

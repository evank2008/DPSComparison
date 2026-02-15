package main;

import java.awt.Color;

public class LittlePrince extends Troop{
	int hits=-1;
	@Override
	public double[] getNextHit() {
		hits++;
		if(hits==0) {
			return new double[]{0.5,104};
		} else if(hits<=3) {
			return new double[]{1.2,104};
		} else if(hits<=6) {
			return new double[]{0.6,104};
		} else {
			return new double[]{0.4,104};
		}
	}

	@Override
	public Color getColor() {
		return new Color(3,161,43);
	}
	void reset() {
		hits=-1;
	}

}

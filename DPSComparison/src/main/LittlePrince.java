package main;

import java.awt.Color;

public class LittlePrince extends Troop{
	int hits=-1;
	boolean usedAbility;
	public LittlePrince(boolean usedAbility) {
	this.usedAbility=usedAbility;	
	}
	@Override
	public double[] getNextHit() {
		hits++;
		if(usedAbility) {
			if(hits==0) {
				return new double[] {2,256};
			}
			if(hits==1) {
				return new double[]{0.5,104+202};
			} else if(hits<=4) {
				return new double[]{1.2,104+202};
			} else if(hits<=7) {
				if(hits==6) {
					return new double[]{0.6,104+202};
				}
				return new double[]{0.6,104};
			} else {
				//8 and above, guardienne hits on 8 and each subsequent 3rd
				if((hits-8)%3==0) return new double[]{0.4,104+202};
				else return new double[]{0.4,104};
			}
		} else {
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
	}

	@Override
	public Color getColor() {
		if(usedAbility) return new Color(77,195,194);
		return new Color(3,161,43);
	}
	void reset() {
		hits=-1;
	}

}

package main;

import java.awt.Color;

public class EvolvedMusketeer extends Troop{

	int hits = -1;
	@Override
	public double[] getNextHit() {
		hits++;
		//first hit at hits==0
		if(hits==0) {
			return new double[] {0.7,390};
		} if(hits<=2) {
			return new double[] {1,390};
		}
		return new double[] {1,217};
		//next two hits at hits<=2
		//all future hits normal
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(139, 84, 143);
	}

	@Override
	void reset() {
		hits=-1;
	}

}

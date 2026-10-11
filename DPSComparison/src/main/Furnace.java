package main;

import java.awt.Color;

public class Furnace extends Troop{

	boolean firstHit=false;
	double time=0;
	int spiritsSpawned=0;
	@Override
	public double[] getNextHit() {
		
		if(!firstHit) {
			firstHit=true;
			time+=0.7;
			return new double[]{0.7,179};
		}
		time+=1.8;
		if(time/5>spiritsSpawned) {
			spiritsSpawned++;
			return new double[] {1.8, 179+215};
		}
		return new double[] {1.8, 179};
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(255, 157, 59);
	}

	@Override
	void reset() {
		firstHit=false;		
	}
	public String getName() {
		return "Furnace";
	}
}

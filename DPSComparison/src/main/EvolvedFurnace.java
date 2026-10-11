package main;

import java.awt.Color;

public class EvolvedFurnace extends Troop{

	boolean firstHit=false;
	double time=0;
	int spiritsSpawned=0;
	@Override
	public double[] getNextHit() {
		
		if(!firstHit) {
			firstHit=true;
			time+=0.7;
			return new double[]{0.7,179+215};
		}
		time+=1.8;
		if(time/5>spiritsSpawned) {
			spiritsSpawned++;
			return new double[] {1.8, 179+215+215};
		}
		return new double[] {1.8, 179+215};
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(252, 59, 200);
	}

	@Override
	void reset() {
		firstHit=false;		
	}
	public String getName() {
		return "Evolved Furnace";
	}
}

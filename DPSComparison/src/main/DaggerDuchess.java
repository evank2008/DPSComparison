package main;

import java.awt.Color;

public class DaggerDuchess extends Troop{

	int ammo = 8;
	@Override
	public double[] getNextHit() {
		
		if(ammo==8) {
			ammo--;
			return new double[] {0.5, 107};
		}
		if(ammo>0) {
			ammo--;
			return new double[] {0.5,107};
		}
		return new double[] {1.4, 107};
	}

	@Override
	public Color getColor() {
		return new Color(242,211,56);
	}

	void reset() {
		ammo=8;
}
	public String getName() {
		return "Dagger Duchess";
	}
}

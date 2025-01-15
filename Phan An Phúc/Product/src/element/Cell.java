package element;

import playing.Color;

public class Cell {
	private boolean light = false;
	private boolean shield = false;
	private boolean isHit;
	private boolean hasBoat;

	public Cell() {
		this.isHit = false;
		this.hasBoat = false;
	}
	public void hasLight()
	{
		this.light = true;
	}
	public boolean isLight() {
		return light;
	}
	public void setShield(boolean check)
	{
		this.shield = check;
	}
	public boolean isShield() {
		return shield;
	}
	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean hit) {
		isHit = hit;
	}

	public boolean hasBoat() {
		return hasBoat;
	}

	public void setBoat(boolean hasBoat) {
		this.hasBoat = hasBoat;
	}

	@Override
	public String toString() {
		if (isHit) {
			return hasBoat ? Color.red + " X" + Color.ANSI_Reset : Color.purple + " O" + Color.ANSI_Reset;
		} else {
			return "~";
		}
	}

	public String toString(boolean choice) {
		if (hasBoat || light) {
			return Color.blue + " T"  + Color.ANSI_Reset;
		} 
		else if(light)
		{
			return Color.yellow + " L" + Color.ANSI_Reset;
		}
		else {
			return "~";
		}
	}

	public String toString(boolean choice, boolean checkHit) {
		if (isHit) {
			return hasBoat ? Color.red + " X" + Color.ANSI_Reset : Color.purple + " O" + Color.ANSI_Reset;
		} else if (!isHit) {
			if (hasBoat ) {
				return Color.blue + " T"  + Color.ANSI_Reset;
			} 
			else if(light)
			{
				return Color.yellow + " L" + Color.ANSI_Reset;
			}
			else {
				return "~";
			}
		} else {
			return "~";
		}
	}

}

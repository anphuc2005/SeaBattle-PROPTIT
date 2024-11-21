package Element;

public class Cell {
	private boolean isHit;
	private boolean hasBoat;

	public Cell() {
		this.isHit = false;
		this.hasBoat = false;
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
			return hasBoat ? "X" : "O";
		} else {
			return "~";
		}
	}

	public String toString(boolean choice) {
		if (hasBoat) {
			return "T";
		} else {
			return "~";
		}
	}
}

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
			return hasBoat ? "\u2693" : "\uD83D\uDCA5";
		} else {
			return "\uD83C\uDF0A";
		}
	}

	public String toString(boolean choice) {
		if (hasBoat) {
			return "\uD83D\uDEA2";
		} else {
			return "\uD83C\uDF0A";
		}
	}

}

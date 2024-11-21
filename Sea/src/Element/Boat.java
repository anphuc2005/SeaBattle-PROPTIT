package Element;

import java.util.ArrayList;

public class Boat {
	private BoatType type;
	private ArrayList<int[]> coordinates;

	public Boat(BoatType type) {
		this.type = type;
		this.coordinates = new ArrayList<>();
	}

	public void addCoordinate(int x, int y) {
		coordinates.add(new int[] { x, y });
	}

	public boolean isDestroyed(Cell[][] map) {
		for (int[] coord : coordinates) {
			int x = coord[0];
			int y = coord[1];
			if (!map[x][y].isHit()) {
				return false;
			}
		}
		return true;
	}

	public String getName() {
		return type.getName();
	}

	public int getSize() {
		return type.getSize();
	}

	public int getSoLuong() {
		return type.getSoLuong();
	}

	public ArrayList<int[]> getCoordinates() {
		return coordinates;
	}
}

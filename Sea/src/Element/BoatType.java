package Element;

public enum BoatType {
	PATROL_BOAT("Tàu tuần tra", 2, 2), SUBMARINE("Tàu ngầm", 3, 1), DESTROYER_BOAT("Tàu khu trục", 4, 1),
	BATTLE_SHIP("Tàu chiến hạm", 5, 1);

	private final String name;
	private final int size;
	private final int so_luong;

	BoatType(String name, int size, int quantity) {
		this.name = name;
		this.size = size;
		this.so_luong = quantity;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public int getSoLuong() {
		return so_luong;
	}
}

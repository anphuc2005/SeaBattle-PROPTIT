package element;

public enum BoatType {
	PATROL_BOAT("Tàu tuần tra", 2, 2,"P"), SUBMARINE("Tàu ngầm", 3, 1,"S"), DESTROYER_BOAT("Tàu khu trục", 4, 1, "D"),
	BATTLE_SHIP("Tàu chiến hạm", 5, 1,"B");

	private final String name;
	private final int size;
	private final int soLuong;
	private final String shortName;

	BoatType(String name, int size, int quantity, String shortName) {
		this.name = name;
		this.size = size;
		this.soLuong = quantity;
		this.shortName = shortName;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public int getSoLuong() {
		return soLuong;
	}
	public String getshortName()
	{
		return shortName;
	}
}

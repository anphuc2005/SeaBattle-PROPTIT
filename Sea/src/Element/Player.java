package Element;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	static char Hang = 'A';
	static int Cot = 1;
	private String namePlayer;
	private ArrayList<Boat> boats;
	private Cell[][] mapPlayer;

	public Player(String namePlayer, ArrayList<Boat> boats, Cell[][] mapPlayer) {
		this.namePlayer = namePlayer;
		this.boats = boats;
		this.mapPlayer = mapPlayer;
	}

	public String getNamePlayer() {
		return namePlayer;
	}

	public ArrayList<Boat> getBoats() {
		return boats;
	}

	public Cell[][] getMapPlayer() {
		return mapPlayer;
	}

	public void mapPlaying() {
		Cot = 1;
		Hang = 'A';

		System.out.print("   ");
		for (int j = 1; j <= mapPlayer[0].length; ++j) {
			System.out.printf("%2d ", j);
		}
		System.out.println();
		for (int i = 0; i < mapPlayer.length; i++) {
			System.out.printf("%2c ", Hang++);
			for (int j = 0; j < mapPlayer[i].length; j++) {
				System.out.printf("%3s", mapPlayer[i][j].toString());
			}
			System.out.println();
		}
	}

	public void mapSetUp() {
		Cot = 1;
		Hang = 'A';

		System.out.print("   ");
		for (int j = 1; j <= mapPlayer[0].length; ++j) {
			System.out.printf("%2d ", j);
		}
		System.out.println();
		for (int i = 0; i < mapPlayer.length; i++) {
			System.out.printf("%2c ", Hang++);
			for (int j = 0; j < mapPlayer[i].length; j++) {
				System.out.printf("%3s", mapPlayer[i][j].toString(true));
			}
			System.out.println();
		}
	}

	public boolean acceptedCoordinates(int x, int y) {
		System.out.println("Kiểm tra tọa độ hợp lệ...");
		if (x >= 0 && x < mapPlayer.length && y >= 0 && y < mapPlayer[0].length) {
			return true;
		}
		return false;
	}

	public int[] getCoordinatesFromPlayer(String namePlayer) {
		Scanner sc = new Scanner(System.in);
		System.out.println(namePlayer + ", nhập tọa độ bắn (dạng: x y): ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		--x;
		--y;
		while (acceptedCoordinates(x, y) == false) {
			System.out.println("Vui lòng nhập lại tọa độ:");
			x = sc.nextInt();
			y = sc.nextInt();
		}
		return new int[] { x, y };
	}

}

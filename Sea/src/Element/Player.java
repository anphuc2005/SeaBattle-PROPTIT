package Element;

import java.util.ArrayList;

public class Player {
	static char Hang = 'A';
	static int Cot = 1;
	private String namePlayer;
	private ArrayList<Boat> boats;
	private Cell[][] mapPlayer;
	private int numOfShip;

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

	public int getNumOfShip() {
		return numOfShip;
	}

	public void setNumOfShip(int numOfShip) {
		this.numOfShip = numOfShip;
	}

	public void mapPlaying() {
		ManagePlayer.mapWhilePlaying(mapPlayer);
	}

	public void mapSetUp() {
		ManagePlayer.mapWhileSetUp(mapPlayer);
	}

	public void mapPlayingAfterShot() {
		ManagePlayer.mapWhilePlayingAfterShot(mapPlayer);
	}

	public boolean acceptedCoordinates(int x, int y) {
		return ManagePlayer.acceptedCoordinates(x, y, mapPlayer);
	}

	public int[] getCoordinatesFromPlayer(String namePlayer) {
		return ManagePlayer.getCoordinatesFromPlayer(namePlayer, mapPlayer);
	}

}

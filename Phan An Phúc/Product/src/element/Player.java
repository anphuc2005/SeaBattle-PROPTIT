package element;

import java.util.ArrayList;
import playing.Shop;

public class Player {
	static char Hang = 'A';
	static int Cot = 1;
	private String namePlayer;
	protected ArrayList<Boat> boats;
	protected Cell[][] mapPlayer;
	private Shop shopPlayer;
	private int numOfShip = 5;
	private int money ;

	public Player(String namePlayer, ArrayList<Boat> boats, Cell[][] mapPlayer) {
		this.namePlayer = namePlayer;
		this.boats = boats;
		this.mapPlayer = mapPlayer;
		this.shopPlayer = new Shop();
	}
	public int getMoney() {
		return money;
	}
	public Shop getShop()
	{
		return shopPlayer;
	}
	public void setMoney(int money) {
		this.money += money;
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
		numOfShip = -1;
		this.numOfShip = numOfShip;
	}

	public void mapPlaying(Cell[][] mapPlayer2) {
		ManagePlayer.mapWhilePlaying(mapPlayer, mapPlayer2);
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

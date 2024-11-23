package Playing;

import java.util.Scanner;

import Element.Boat;
import Element.Player;
import Element.PlayerOpponent;

public class GameController {
	static ScoreBoard scoreBoard = new ScoreBoard();
	static ClearConsole clear = new ClearConsole();
	static Scanner sc = new Scanner(System.in);
	private Player player1;
	private PlayerOpponent player2;
	public int numTurn1 = 1;
	public int numTurn2 = 1;
	boolean isGameOver;

	public GameController(Player player1, PlayerOpponent player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void startGame() {
		int turn = 0;

		while (true) {
			if (turn == 0) {
				player2.mapPlaying();
				System.out.println("Chọn chức năng của bạn");
				System.out.println("1. Xem map của bạn");
				System.out.println("2. Bắt đầu bắn");
				int choice = Integer.parseInt(sc.nextLine());
				boolean hit = false;
				switch (choice) {
				case 1:
					player1.mapPlayingAfterShot();
				case 2:
					hit = takeTurn(player1, player2);
					break;
				}
				if (isGameOver == true) {

					break;
				}
				if (hit) {
					System.out.println("Người chơi 1 được bắn tiếp!");
					numTurn1++;
				} else {
					clear.clearConsole();
					turn = 1;
				}
			} else {
				player1.mapPlaying();
				System.out.println("Chọn chức năng của bạn");
				System.out.println("1. Xem map của bạn");
				System.out.println("2. Bắt đầu bắn");
				int choice = Integer.parseInt(sc.nextLine());
				boolean hit = false;
				switch (choice) {
				case 1:
					player2.mapPlayingAfterShot();
				case 2:
					hit = takeTurn(player2, player1);
					break;
				}
				if (isGameOver == true)
					break;
				if (hit) {
					System.out.println("Người chơi 2 được bắn tiếp!");
					numTurn2++;
				} else {
					clear.clearConsole();
					turn = 0;
				}
			}
		}
	}

	private boolean checkGameOver(Player player) {
		for (Boat boat : player.getBoats()) {
			if (!boat.isDestroyed(player.getMapPlayer())) {
				return false;
			}
		}
		return true;
	}

	private boolean takeTurn(Player current, Player opponent) {
		int[] coordinates = current.getCoordinatesFromPlayer(current.getNamePlayer());
		int x = coordinates[0];
		int y = coordinates[1];
		if (opponent.getMapPlayer()[x][y].isHit()) {
			System.out.println("Ô này đã bắn trước đó, vui lòng chọn tọa độ khác.");
			return takeTurn(current, opponent);
		}

		if (opponent.getMapPlayer()[x][y].hasBoat()) {
			opponent.getMapPlayer()[x][y].setHit(true);
			Effect.isHit();
//			opponent.mapPlaying();

			for (Boat boat : opponent.getBoats()) {
				if (boat.isSunk(x, y)) {
					Effect.isSunk();
					System.out.println(Color.purple + "Tàu " + boat.getName() + " đã bị chìm!" + Color.ANSI_Reset);
					opponent.setNumOfShip(boat.getNumOfShip());
					clear.clearConsole();
				}
			}

			if (checkGameOver(opponent)) {
				System.out.println("Tất cả tàu của " + opponent.getNamePlayer() + " đã bị tiêu diệt!");
				Effect.isVictory();
				isGameOver = true;
				return true;
			}

			return true;
		} else {
			opponent.getMapPlayer()[x][y].setHit(true);
			Effect.isMiss();
//			opponent.mapPlaying();
			return false;
		}
	}

}

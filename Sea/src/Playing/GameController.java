package Playing;

import java.util.Scanner;

import Element.Boat;
import Element.Player;
import Element.PlayerOpponent;

public class GameController {
	static Scanner sc = new Scanner(System.in);
	private Player player1;
	private PlayerOpponent player2;

	public GameController(Player player1, PlayerOpponent player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void startGame() {
		boolean isGameOver = false;
		int turn = 0;

		while (!isGameOver) {
			if (turn == 0) {
				System.out.println("Chọn chức năng của bạn");
				System.out.println("1. Xem map của đối thủ");
				System.out.println("2. Bắt đầu bắn");
				int choice = sc.nextInt();
				boolean hit = false;
				switch (choice) {
				case 1:
					player2.mapPlaying();
				case 2:
					hit = takeTurn(player1, player2);
					break;
				}
				if (hit) {
					System.out.println("Người chơi 1 được bắn tiếp!");
				} else {
					turn = 1;
				}
			} else {
				System.out.println("Chọn chức năng của bạn");
				System.out.println("1. Xem map của đối thủ");
				System.out.println("2. Bắt đầu bắn");
				int choice = sc.nextInt();
				boolean hit = false;
				switch (choice) {
				case 1:
					player1.mapPlaying();
				case 2:
					hit = takeTurn(player2, player1);
					break;
				}
				if (hit) {
					System.out.println("Người chơi 2 được bắn tiếp!");
				} else {
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
			System.out.println("Trúng tàu!");
			opponent.mapPlaying();

			for (Boat boat : opponent.getBoats()) {
				if (boat.isSunk(x, y) && boat.isDestroyed(opponent.getMapPlayer())) {
					System.out.println("Tàu " + boat.getName() + " đã bị chìm!");
				}
			}

			if (checkGameOver(opponent)) {
				System.out.println("Tất cả tàu của " + opponent.getNamePlayer() + " đã bị tiêu diệt!");
				return true;
			}

			return true;
		} else {
			opponent.getMapPlayer()[x][y].setHit(true);
			System.out.println("Bắn trượt!");
			opponent.mapPlaying();
			return false;
		}
	}

}

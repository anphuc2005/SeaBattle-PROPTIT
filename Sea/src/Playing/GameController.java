package Playing;

import java.util.Scanner;

import Element.Boat;
import Element.Bot;
import Element.Player;
import Element.PlayerOpponent;

public class GameController {
	static ClearConsole clear = new ClearConsole();
	static Scanner sc = new Scanner(System.in);
	private Player player1;
	private PlayerOpponent player2;
	private Bot bot;
	public int numTurn1 = 1;
	public int numTurn2 = 1;
	boolean isGameOver;

	public GameController(Player player1, PlayerOpponent player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public GameController(Player player1, Bot player2) {
		this.player1 = player1;
		this.bot = player2;
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
					ScoreBoard scoreBoard = new ScoreBoard(player1.getNamePlayer(), numTurn1, player1.getNumOfShip());
					ScoreBoard.saveScoreBoard(scoreBoard);
					System.out.println("Trò chơi kết thúc! Kết quả đã được lưu.");
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
				if (isGameOver == true) {
					ScoreBoard scoreBoard = new ScoreBoard(player2.getNamePlayer(), numTurn2, player2.getNumOfShip());
					ScoreBoard.saveScoreBoard(scoreBoard);
					System.out.println("Trò chơi kết thúc! Kết quả đã được lưu.");
					break;
				}
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

	public void startGameWithBot() {
		int turn = 0;

		while (true) {
			if (turn == 0) {
				bot.mapPlaying();
				System.out.println("Chọn chức năng của bạn");
				System.out.println("1. Xem map của bạn");
				System.out.println("2. Bắt đầu bắn");
				int choice = Integer.parseInt(sc.nextLine());
				boolean hit = false;
				switch (choice) {
				case 1:
					player1.mapPlayingAfterShot();
				case 2:
					hit = takeTurn(player1, bot);
					break;
				}
				if (isGameOver == true) {
					ScoreBoard scoreBoard = new ScoreBoard(player1.getNamePlayer(), numTurn1, player1.getNumOfShip());
					ScoreBoard.saveScoreBoard(scoreBoard);
					System.out.println("Trò chơi kết thúc! Kết quả đã được lưu.");
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

				boolean hit = takeTurnWithBot(bot, player1);
				if (isGameOver == true) {
					ScoreBoard scoreBoard = new ScoreBoard(player2.getNamePlayer(), numTurn2, player2.getNumOfShip());
					ScoreBoard.saveScoreBoard(scoreBoard);
					System.out.println("Trò chơi kết thúc! Kết quả đã được lưu.");
					break;
				}
				if (hit) {
					System.out.println("Bot được bắn tiếp!");
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

	private boolean takeTurn(Player current, Bot opponent) {
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

	private boolean takeTurnWithBot(Bot current, Player opponent) {
		int[] coordinates;

		// Lấy tọa độ từ hàng đợi target nếu bot đang nhắm mục tiêu
		if (current.inTargetShip()) {
			coordinates = current.getNextCoordinates(opponent.getMapPlayer());
		} else {
			// Ngược lại, chọn tọa độ ngẫu nhiên
			coordinates = current.getRandomCoordinates(opponent.getMapPlayer());
		}

		int x = coordinates[0];
		int y = coordinates[1];

		// Nếu ô này đã bị bắn, không bắn lại, chọn tọa độ khác
		if (opponent.getMapPlayer()[x][y].isHit()) {
			return takeTurnWithBot(current, opponent); // Thử với tọa độ khác
		}

		// Đánh dấu ô là đã bắn
		opponent.getMapPlayer()[x][y].setHit(true);

		// Nếu trúng tàu
		if (opponent.getMapPlayer()[x][y].hasBoat()) {
			Effect.isHit(); // Hiển thị hiệu ứng khi trúng
			current.detechTargetShip(x, y, opponent.getMapPlayer()); // Thêm các ô xung quanh vào hàng đợi

			// Kiểm tra nếu tàu bị chìm
			for (Boat boat : opponent.getBoats()) {
				if (boat.isSunk(x, y)) {
					Effect.isSunk();
					System.out.println(Color.purple + "Tàu " + boat.getName() + " đã bị chìm!" + Color.ANSI_Reset);
					current.getTargetHit().clear(); // Xóa hàng đợi nếu tàu chìm
					opponent.setNumOfShip(boat.getNumOfShip());
					break;
				}
			}

			// Kiểm tra nếu trò chơi kết thúc
			if (checkGameOver(opponent)) {
				System.out.println("Tất cả tàu của " + opponent.getNamePlayer() + " đã bị tiêu diệt!");
				Effect.isVictory();
				isGameOver = true;
				return true;
			}

			return true; // Nếu trúng, bot được bắn tiếp
		} else {
			// Nếu bot bắn trượt
			Effect.isMiss();
			return false; // Kết thúc lượt bot
		}
	}

}

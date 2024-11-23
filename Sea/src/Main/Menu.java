package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Element.Boat;
import Element.Cell;
import Element.Player;
import Element.PlayerOpponent;
import Playing.BeforePlaying;
import Playing.ClearConsole;
import Playing.Color;
import Playing.GameController;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ClearConsole clear = new ClearConsole();

	public void Menu() {
		System.out.println(Color.cyan + " ________  _______   ________                                     \r\n"
				+ "|\\   ____\\|\\  ___ \\ |\\   __  \\                                    \r\n"
				+ "\\ \\  \\___|\\ \\   __/|\\ \\  \\|\\  \\                                   \r\n"
				+ " \\ \\_____  \\ \\  \\_|/_\\ \\   __  \\                                  \r\n"
				+ "  \\|____|\\  \\ \\  \\_|\\ \\ \\  \\ \\  \\                                 \r\n"
				+ "    ____\\_\\  \\ \\_______\\ \\__\\ \\__\\                                \r\n"
				+ "   |\\_________\\|_______|\\|__|\\|__|                                \r\n"
				+ "   \\|_________|                                                   \r\n"
				+ "                                                                  \r\n"
				+ "                                                                  \r\n"
				+ " ________  ________  _________  _________  ___       _______      \r\n"
				+ "|\\   __  \\|\\   __  \\|\\___   ___\\\\___   ___\\\\  \\     |\\  ___ \\     \r\n"
				+ "\\ \\  \\|\\ /\\ \\  \\|\\  \\|___ \\  \\_\\|___ \\  \\_\\ \\  \\    \\ \\   __/|    \r\n"
				+ " \\ \\   __  \\ \\   __  \\   \\ \\  \\     \\ \\  \\ \\ \\  \\    \\ \\  \\_|/__  \r\n"
				+ "  \\ \\  \\|\\  \\ \\  \\ \\  \\   \\ \\  \\     \\ \\  \\ \\ \\  \\____\\ \\  \\_|\\ \\ \r\n"
				+ "   \\ \\_______\\ \\__\\ \\__\\   \\ \\__\\     \\ \\__\\ \\ \\_______\\ \\_______\\\r\n"
				+ "    \\|_______|\\|__|\\|__|    \\|__|      \\|__|  \\|_______|\\|_______|" + Color.ANSI_Reset);

		System.out.println();
		System.out.println("==================================");
		System.out.println("|              Menu              |");
		System.out.println("==================================");
		System.out.println("| 1. Play                        |");
		System.out.println("| 2. Cancel                      |");
		System.out.println("==================================");
		System.out.print("--> Enter your choice: ");
		int choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			StartGame();
		} else if (choice == 2)
			return;
	}

	public void StartGame() {

		System.out.println("Nhập kích cỡ của bảng");
		int size = Integer.parseInt(sc.nextLine());

		Cell[][] mapPlayer1 = new Cell[size][size];
		Cell[][] mapPlayer2 = new Cell[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				mapPlayer1[i][j] = new Cell();
				mapPlayer2[i][j] = new Cell();
			}
		}
		ArrayList<Boat> boats1 = new ArrayList<>();
		ArrayList<Boat> boats2 = new ArrayList<>();
		System.out.println("Nhập tên người chơi 1:");
		String nguoi_choi_1 = sc.nextLine();
		Player player1 = new Player(nguoi_choi_1, boats1, mapPlayer1);

		System.out.println("Nhập tên người chơi 2:");
		String nguoi_choi_2 = sc.nextLine();
		PlayerOpponent player2 = new PlayerOpponent(nguoi_choi_2, boats2, mapPlayer2);

		BeforePlaying beforePlaying = new BeforePlaying();
		System.out.println("Đặt tàu cho người chơi 1");
		System.out.println("Bạn muốn đặt tàu thủ công hay tự động ");
		System.out.println("1. Thủ công");
		System.out.println("2. Tự động");

		int choice_1 = Integer.parseInt(sc.nextLine());
		boolean choice_player1;
		if (choice_1 == 1)
			choice_player1 = true;
		else
			choice_player1 = false;
		beforePlaying.setUpBoatsForPlayer(player1, choice_player1);
		clear.clearConsole();

		System.out.println("Đặt tàu cho người chơi 2");
		System.out.println("Bạn muốn đặt tàu thủ công hay tự động ");
		System.out.println("1. Thủ công");
		System.out.println("2. Tự động");
		int choice_2 = Integer.parseInt(sc.nextLine());
		boolean choice_player2;
		if (choice_2 == 1)
			choice_player2 = true;
		else
			choice_player2 = false;
		beforePlaying.setUpBoatsForOpponent(player2, choice_player2);
		clear.clearConsole();

		System.out.println("\nTất cả tàu đã được đặt. Trò chơi bắt đầu!");
		clear.clearConsole();
		GameController gameController = new GameController(player1, player2);
		gameController.startGame();

		System.out.println("Trò chơi kết thúc!");

	}
}

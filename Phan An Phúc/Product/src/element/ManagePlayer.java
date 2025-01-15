package element;

import Main.Input;
import java.util.Random;
import java.util.Scanner;

public class ManagePlayer {
	static char Hang = 'A';
	static int Cot = 1;
	static Scanner sc = Input.getScanner();
	private static Random random = new Random();

	public static void mapWhilePlaying(Cell[][] mapPlayer1, Cell[][] mapPlayer2) {
		char rowLabel = 'A';

		// Print the column headers for both maps
		System.out.print("   ");
		for (int j = 1; j <= mapPlayer1[0].length; ++j) {
			System.out.printf("| %2d  ", j);
		}
		System.out.print("|   ~~~   ");
		for (int j = 1; j <= mapPlayer2[0].length; ++j) {
			System.out.printf("| %2d  ", j);
		}
		System.out.println("|");

		// Print the horizontal divider for both maps
		System.out.print("   ");
		for (int j = 1; j <= mapPlayer1[0].length; ++j) {
			System.out.print("+-----");
		}
		System.out.print("+   ~~~   ");
		for (int j = 1; j <= mapPlayer2[0].length; ++j) {
			System.out.print("+-----");
		}
		System.out.println("+");

		// Print the rows of both maps side by side
		for (int i = 0; i < mapPlayer1.length; i++) {
			// Print the row label and the content of the first map
			System.out.printf(" %c ", rowLabel++);
			for (int j = 0; j < mapPlayer1[i].length; j++) {
				System.out.printf("| %2s  ", mapPlayer1[i][j].toString());
			}
			System.out.print("|   ~~~   ");

			// Print the content of the second map
			for (int j = 0; j < mapPlayer2[i].length; j++) {
				System.out.printf("| %2s  ", mapPlayer2[i][j].toString(true,true));
			}
			System.out.println("|");
		}
	}

	public static void mapWhilePlayingAfterShot(Cell[][] mapPlayer) {
		Cot = 1;
		Hang = 'A';
		System.out.print("   ");
		for (int j = 1; j <= mapPlayer[0].length; ++j) {
			System.out.printf("| %2d  ", j);
		}
		System.out.println("|");
		System.out.print("   ");
		for (int j = 1; j <= mapPlayer[0].length; ++j) {
			System.out.print("+-----");
		}
		System.out.println("+");

		for (int i = 0; i < mapPlayer.length; i++) {
			System.out.printf(" %c ", Hang++);
			for (int j = 0; j < mapPlayer[i].length; j++) {
				System.out.printf("| %2s  ", mapPlayer[i][j].toString(true));
			}
			System.out.println("|");
		}
	}

	public static void mapWhileSetUp(Cell[][] mapPlayer) {
		Cot = 1;
		Hang = 'A';
		System.out.print("   ");
		for (int j = 1; j <= mapPlayer[0].length; ++j) {
			System.out.printf("| %2d  ", j);
		}
		System.out.println("|");
		System.out.print("   ");
		for (int j = 1; j <= mapPlayer[0].length; ++j) {
			System.out.print("+-----");
		}
		System.out.println("+");

		for (int i = 0; i < mapPlayer.length; i++) {
			System.out.printf(" %c ", Hang++);
			for (int j = 0; j < mapPlayer[i].length; j++) {
				System.out.printf("| %2s  ", mapPlayer[i][j].toString());
			}
			System.out.println("|");
		}
	}

	public static boolean acceptedCoordinates(int x, int y, Cell[][] mapPlayer) {
		System.out.println("Check your coordinates....");
		if (x >= 0 && x < mapPlayer.length && y >= 0 && y < mapPlayer[0].length) {
			return true;
		}
		return false;
	}

	public static int[] getCoordinatesFromPlayer(String namePlayer, Cell[][] mapPlayer) {
		System.out.println(namePlayer + ", enter coordinate x: ");
		int toaDoX = Integer.parseInt(sc.nextLine());
		System.out.println(namePlayer + ", enter coordinate y");
		int toaDoY = Integer.parseInt(sc.nextLine());
		--toaDoX;
		--toaDoY;
		while (acceptedCoordinates(toaDoX, toaDoY, mapPlayer) == false) {
			System.out.println("Please re-enter your coordinates:");
			toaDoX = Integer.parseInt(sc.nextLine());
			toaDoY = Integer.parseInt(sc.nextLine());
		}
		return new int[] { toaDoX, toaDoY };
	}

}

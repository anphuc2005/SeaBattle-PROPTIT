package Playing;

import java.io.IOException;

public class ClearConsole {
	@SuppressWarnings("deprecation")
	public static void clrscr() throws IOException {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

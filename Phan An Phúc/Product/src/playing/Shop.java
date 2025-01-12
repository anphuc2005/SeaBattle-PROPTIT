package playing;

import Main.Input;
import element.Item;
import element.ManagePlayer;
import element.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    static Scanner sc = Input.getScanner();
    private final List<Item> items;

    public Shop() {
        items = new ArrayList<>();
        items.add(new Item(5, "Light", 0));
        items.add(new Item(15, "Bomb", 0));
        items.add(new Item(7, "Shield", 0));
    }

    public void ShopStore(Player player) {
        ClearConsole.clearConsole();
System.out.println(Color.cyan + "██╗    ██╗███████╗██╗     ██╗      ██████╗ ██████╗ ███╗   ███╗███████╗       \r\n" + //
		"██║    ██║██╔════╝██║     ██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝       \r\n" + //
		"██║ █╗ ██║█████╗  ██║     ██║     ██║     ██║   ██║██╔████╔██║█████╗         \r\n" + //
		"██║███╗██║██╔══╝  ██║     ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         \r\n" + //
		"╚███╔███╔╝███████╗███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       \r\n" + //
		" ╚══╝╚══╝ ╚══════╝╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       \r\n" + //
		"                                                                             \r\n" + //
		"████████╗ ██████╗                                                            \r\n" + //
		"╚══██╔══╝██╔═══██╗                                                           \r\n" + //
		"   ██║   ██║   ██║                                                           \r\n" + //
		"   ██║   ██║   ██║                                                           \r\n" + //
		"   ██║   ╚██████╔╝                                                           \r\n" + //
		"   ╚═╝    ╚═════╝                                                            \r\n" + //
		"                                                                             \r\n" + //
		"██████╗ ██╗██████╗  █████╗ ████████╗███████╗███████╗██╗  ██╗ ██████╗ ██████╗ \r\n" + //
		"██╔══██╗██║██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔════╝██║  ██║██╔═══██╗██╔══██╗\r\n" + //
		"██████╔╝██║██████╔╝███████║   ██║   █████╗  ███████╗███████║██║   ██║██████╔╝\r\n" + //
		"██╔═══╝ ██║██╔══██╗██╔══██║   ██║   ██╔══╝  ╚════██║██╔══██║██║   ██║██╔═══╝ \r\n" + //
		"██║     ██║██║  ██║██║  ██║   ██║   ███████╗███████║██║  ██║╚██████╔╝██║     \r\n" + //
		"╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝     " + Color.ANSI_Reset);
        System.out.println("What do you want to buy?");
        System.out.println("+------------------+------+----------+");
        System.out.println("|      Tên Item    | Giá  | Số lượng |");
        System.out.println("+------------------+------+----------+");

        for (Item item : items) {
            System.out.printf("| %-16s | %-4d | %-8d |\n", item.getTen(), item.getGia(), item.getSoLuong());
        }
        System.out.println("+------------------+------+----------+");

        System.out.println("Your Money: " + player.getMoney());
        System.out.println("Nhập tên item để mua (Light, Bomb, Shield): ");
        String itemName = sc.nextLine().trim();

        boolean itemFound = false;
        for (Item item : items) {
            if (item.getTen().equalsIgnoreCase(itemName)) {
                System.out.println("Bạn đã chọn: " + item.getTen());
                System.out.println("Nhập số lượng cần mua: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                if (quantity > 0 && player.getMoney() >= item.getGia() * quantity) {
                    System.out.println("Bạn đã mua " + quantity + " " + item.getTen() + "(s).");
                    item.setSoLuong(item.getSoLuong() + quantity);
                    player.setMoney(player.getMoney() - (item.getGia() * quantity));
                    System.out.println("Số tiền còn lại: " + player.getMoney());
                } else {
                    System.out.println("Số lượng không hợp lệ hoặc tiền không đủ.");
                }
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            System.out.println("Tên item không tồn tại!");
        }

        System.out.println("\nBảng sau khi mua:");
        displayItems();
    }

    public void useItem(Player current, Player opponent) {
        System.out.println("\nBảng các item:");
        displayItems();

        System.out.println("Nhập tên item bạn muốn sử dụng:");
        String itemName = sc.nextLine().trim();

        for (Item item : items) {
            if (item.getTen().equalsIgnoreCase(itemName)) {
                if (item.getSoLuong() > 0) {
                    activeItem(current, opponent, item.getTen());
                    System.out.println("Bạn đã sử dụng " + item.getTen() + ".");
                    item.setSoLuong(item.getSoLuong() - 1);
                } else {
                    System.out.println("Số lượng không đủ.");
                }
                return;
            }
        }
        System.out.println("Tên item không tồn tại!");
    }

    public void activeItem(Player current, Player opponent, String nameItem) {
        ClearConsole.clearConsole();
        current.mapPlaying();
        System.out.println("Nhập tọa độ bạn muốn sử dụng:");
        System.out.println("Nhập tọa độ x: ");
        int x = sc.nextInt();
        System.out.println("Nhập tọa độ y: ");
        int y = sc.nextInt();
        sc.nextLine();
        x--;
        y--;

        if (ManagePlayer.acceptedCoordinates(x, y, current.getMapPlayer())) {
            if (nameItem.equalsIgnoreCase("Light")) {
                opponent.getMapPlayer()[x][y].hasLight();
                current.mapPlayingAfterShot();

            } else if (nameItem.equalsIgnoreCase("Bomb")) {
                opponent.getMapPlayer()[x][y].setHit(true);
                current.mapPlayingAfterShot();
                while(true)
                {
                    if(x >= 0 && x + 1 < opponent.getMapPlayer().length && y >= 0 && y+1 < opponent.getMapPlayer()[0].length)
                    {
                        for (int i = x ; i < x + 2 ; ++i)
                        {
                            for (int j = y ; j < y + 2 ; ++j)
                            {
                                opponent.getMapPlayer()[i][j].setHit(true);
                            }
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("Wrong coordinates!! Please input again");
                    }
                }
            } else if (nameItem.equalsIgnoreCase("Shield")) {
                current.getMapPlayer()[x][y].setShield(true);
                current.mapSetUp();
            }
        }
    }

    private void displayItems() {
        System.out.println("+------------------+------+----------+");
        System.out.println("|      Tên Item    | Giá  | Số lượng |");
        System.out.println("+------------------+------+----------+");

        for (Item item : items) {
            System.out.printf("| %-16s | %-4d | %-8d |\n", item.getTen(), item.getGia(), item.getSoLuong());
        }
        System.out.println("+------------------+------+----------+");
    }
}

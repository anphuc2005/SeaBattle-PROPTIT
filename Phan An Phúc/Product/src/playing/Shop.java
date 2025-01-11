package playing;

import Main.Input;
import element.Item;
import element.ManagePlayer;
import element.Player;
import java.util.Scanner;


public class Shop {
    static Scanner sc = Input.getScanner();
    public static void ShopStore (Player player)
    {
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
        
        System.out.println("What do you want to buy");
        System.out.println("+------------------+------+----------+");
        System.out.println("|      Tên Item    | Giá  | Số lượng |");
        System.out.println("+------------------+------+----------+");

        for (Item item : Item.values()) {
            System.out.printf("| %-16s | %-4d | %-8d |\n", 
                              item.getTen(), item.getGia(), item.getSoLuong());
        }
        System.out.println("+------------------+------+----------+");

        // Chọn item để mua
        System.out.println("Nhập tên item để mua (Light, Bomb, Shield): ");
        String itemName = sc.nextLine().trim();

        boolean itemFound = false;
        for (Item item : Item.values()) {
            if (item.getTen().equalsIgnoreCase(itemName)) {
                int money = player.getMoney();
                System.out.println("Bạn đã chọn: " + item.getTen());
                System.out.println("Nhập số lượng cần mua: ");
                int quantity = sc.nextInt();

                if (quantity > 0 && money > (item.getGia() * quantity)) {
                    System.out.println("Bạn đã mua " + quantity + " " + item.getTen() + "(s).");
                    item.setSoLuong(item.getSoLuong() + quantity);
                    player.setMoney(player.getMoney() - (item.getGia() * quantity));
                    System.out.println("Số tiền còn lại: " + player.getMoney());
                } else {
                    System.out.println("Số lượng không hợp lệ.");
                }
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            System.out.println("Tên item không tồn tại!");
        }

        // Hiển thị lại bảng sau khi mua
        System.out.println("\nBảng sau khi mua:");
        System.out.println("+------------------+------+----------+");
        System.out.println("|      Tên Item    | Giá  | Số lượng |");
        System.out.println("+------------------+------+----------+");

        for (Item item : Item.values()) {
            System.out.printf("| %-16s | %-4d | %-8d |\n", 
                              item.getTen(), item.getGia(), item.getSoLuong());
        }
        System.out.println("+------------------+------+----------+");
    }

    public static void useItem(Player current, Player opponent)
    {
        System.out.println("\nBảng sau khi mua:");
        System.out.println("+------------------+------+----------+");
        System.out.println("|      Tên Item    | Giá  | Số lượng |");
        System.out.println("+------------------+------+----------+");

        for (Item item : Item.values()) {
            System.out.printf("| %-16s | %-4d | %-8d |\n", 
                              item.getTen(), item.getGia(), item.getSoLuong());
        }
        System.out.println("+------------------+------+----------+");
        System.out.println("Nhập tên item bạn muốn sử dụng");
        String itemName = sc.nextLine().trim();
        boolean itemFound = false;
        for (Item item : Item.values()) {
            if (item.getTen().equals(itemName)) {
                if (item.getSoLuong() > 0) {
                    activeItem(current,opponent,itemName);
                    System.out.println("Bạn đã sử dụng " + item.getTen() + ".");
                    item.setSoLuong(item.getSoLuong() - 1);
                    break;
                }
                else 
                {
                    System.out.println("Số lượng không đủ.");
                }
            }
            else {
                System.out.println("Tên item không tồn tại!");
            }
        }
    }

    public static void activeItem (Player current, Player opponent, String nameItem)
    {
        System.out.println("Nhập tọa độ bạn muốn sử dụng");
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        x--;
        y--;
        if(ManagePlayer.acceptedCoordinates(x,y,current.getMapPlayer()))
        {
            if(nameItem.equals("light"))
            {
                opponent.getMapPlayer()[x][y].hasLight();
            }
            else if(nameItem.equals("bomb"))
            {
                opponent.getMapPlayer()[x][y].setHit(true);
            }
            else if(nameItem.equals("shield"))
            {
                current.getMapPlayer()[x][y].setShield(true);
            }
        }
    }
}

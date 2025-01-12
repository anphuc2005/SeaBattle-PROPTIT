package element;

public class Item {
    private final int gia;
    private final String ten;
    private int soLuong;

    public Item(int gia, String ten, int soLuong) {
        this.gia = gia;
        this.ten = ten;
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public String getTen() {
        return ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}

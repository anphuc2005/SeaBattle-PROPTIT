package element;

public enum Item {
    DEN_PIN(5, "Light", 0),
    BOMB(15, "Bomb", 0),
    SHIELD(7, "Shield", 0);

    private final int gia;
    private final String ten;
    private int soLuong; 

    Item(int gia, String ten, int soLuong) {
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

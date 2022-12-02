package project;

import java.util.Scanner;
/**
 *
 * @author nam23
 */
public class CHITIETPN {
    Scanner inp = new Scanner(System.in);

    private MATHANG g;
    private int maPN;
    private int maMH;
    private long dongia;
    private int soluong;
    private long thanhtien;

    public CHITIETPN() {
    }
    public CHITIETPN(MATHANG g, int maPN, int maMh, long dongia, int soluong, long thanhtien) {
        this.g = g;
        this.maPN = maPN;
        this.maMH = maMh;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }
    public MATHANG getG() {
        return g;
    }
    public void setG(MATHANG g) {
        this.g = g;
    }
    public int getMaPN() {
        return maPN;
    }
    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }
    public int getMaMH() {
        return maMH;
    }
    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }    
    public long getDongia() {
        return dongia;
    }
    public void setDongia(long dongia) {
        this.dongia = dongia;
    }
    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public long getThanhtien() {
        return thanhtien;
    }
    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }
    public double tinhThanhTien(){
        return thanhtien = dongia * soluong;
    }
    
    public void khoiTaoCTPN(){
        System.out.println("Chọn loại hàng:\n1/Thực phẩm.\n2/Phi thực phẩm.");
        System.out.print("Loại mặt hàng: ");
        int mode;
        mode = inp.nextInt();
        outer: while (true) {
            switch (mode) {
                case 1:
                    g = new THUCPHAM();
                    break outer;
                case 2:
                    g = new PHITHUCPHAM();
                    break outer;
                default:{
                    System.out.print("Chọn lại loại mặt hàng:");
                    mode = inp.nextInt();
                }
            }
        }
        g.khoiTaoMH();
        setMaMH(g.getId());
        setDongia(g.getPrice());
        setSoluong(g.getQuantity());
        tinhThanhTien();
    }
    
    public void xuatCTPN(){
        System.out.printf("%-15s\t%-1s\t%-15s\t%-10s\t%-15s\n", "Mã phiếu nhập", "Mã mặt hàng", "Đơn giá", "Số lượng", "Thành tiền");
        System.out.printf("%-15d\t%-14d\t%-15d\t%-10d\t%-15d\n", this.maPN, this.maMH, this.dongia, this.soluong, this.thanhtien);
    }
}

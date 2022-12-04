package project;

import java.util.Scanner;
/**
 *
 * @author nam23
 */
public class CHITIETPN {
    Scanner inp = new Scanner(System.in);

    private MATHANG g;
    private String maPN;
    private long dongia;
    private int soluong;
    private long thanhtien;

    public CHITIETPN() {
    }

    public CHITIETPN(MATHANG g, String maPN, long dongia, int soluong, long thanhtien) {
        this.g = g;
        this.maPN = maPN;
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
    public String getMaPN() {
        return maPN;
    }
    public void setMaPN(String maPN) {
        this.maPN = maPN;
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
        System.out.println("Chọn loại hàng:\n1/Thuc pham.\n2/Phi thuc pham.");
        System.out.print("Loai mat hang: ");
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
                    System.out.print("Chon lai loai mat hang:");
                    mode = inp.nextInt();
                }
            }
        }
        g.khoiTaoMH();
        setDongia(g.getPrice());
        setSoluong(g.getQuantity());
        tinhThanhTien();
    }
    public void khoiTaoCTPN(String mamh){
        System.out.println("Chon loai hàng:\n1/Thuc pham.\n2/Phi thuc pham.");
        System.out.print("Loai mat hang: ");
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
                    System.out.print("Chon lai loai mat hang:");
                    mode = inp.nextInt();
                }
            }
        }
        g.khoiTaoMH(mamh);
        setDongia(g.getPrice());
        setSoluong(g.getQuantity());
        tinhThanhTien();
    }
    public void xuatMh(){
        g.xuatMH();
    }
    public void xuatCTPN(){
        System.out.println("Chi tiet mat hang " + this.g.getId());
        System.out.printf("%-15s\t%-1s\t%-15s\t%-10s\t%-15s\n", "Ma phieu nhap", "Ma mat hang", "Don gia", "So luong", "Thanh tien");
        System.out.printf("%-15s\t%-14s\t%-,15d\t%-10d\t%-,15d\n\n", this.maPN, this.g.getId(), this.dongia, this.soluong, this.thanhtien);
        xuatMh();
        System.out.println("\n");
    }
}

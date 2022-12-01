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
    private double dongia;
    private int soluong;
    private double thanhtien = 0f;

    public CHITIETPN() {
    }
    public CHITIETPN(MATHANG g, int maPN, int maMh, int dongia, int soluong, double thanhtien) {
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
    public double getDongia() {
        return dongia;
    }
    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public double getThanhtien() {
        return thanhtien;
    }
    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public double tinhThanhTien(){
        return thanhtien = dongia * soluong;
    }
    
    public void khoiTaoCTPN(){
        g.khoiTaoMH();
        setMaMH(g.getId());
        setDongia(g.getPrice());
        setSoluong(g.getQuantity());
        tinhThanhTien();
    }
    
    public void xuatCTPN(){
        System.out.printf("%-15d\t%-14d\t%-15f\t%-10d\t%-15f\n", this.maPN, this.maMH, this.dongia, this.soluong, this.thanhtien);
    }
}

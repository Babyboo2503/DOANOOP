package project;

import java.util.Scanner;
/**
 *
 * @author nam23
 */
public class CHITIETPN {
    Scanner inp = new Scanner(System.in);

    private MATHANG g;
    private int maMH;
    private int dongia;
    private int soluong;
    private long thanhtien;

    public CHITIETPN() {
    }
    public CHITIETPN(MATHANG g, int dongia, int soluong, long thanhtien) {
        this.g = g;
        this.maMH = g.getId();
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }
    public int getMaMH() {
        return maMH;
    }
    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }
    public MATHANG getG() {
        return g;
    }
    public void setG(MATHANG g) {
        this.g = g;
    }
    public int getDongia() {
        return dongia;
    }
    public void setDongia(int dongia) {
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
    public long tinhThanhTien(){
        return thanhtien = (long)dongia * soluong;
    }
    
}

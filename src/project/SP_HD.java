/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author nam23
 */
public class SP_HD {
    Scanner inp = new Scanner(System.in);
    public String mahd;
    public String maMh;
    public String tenMh;
    public int soluong;
    public long gia;
    public long thanhtien;

    SP_HD() {
    }
    SP_HD(String maMh, String tenMh, int soluong, long gia, long thanhtien) {
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
    }
    SP_HD(String mahd, String maMh, String tenMh, int soluong, long gia) {
        this.mahd = mahd;
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = soluong * gia;
    }
    SP_HD(String mahd, String maMh, String tenMh, int soluong, long gia, long thanhtien) {
        this.mahd = mahd;
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
    }
    public long getThanhtien() {
        return thanhtien;
    }
    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }
    public String getMaMh() {
        return maMh;
    }
    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }
    public String getTenMh() {
        return tenMh;
    }
    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }
    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public long getGia() {
        return gia;
    }
    public void setGia(long gia) {
        this.gia = gia;
    }
    
    public void nhapSpHd(String mamh){
        setMaMh(mamh);
    }
    
    public void xuatSp(){
        System.out.printf("%-15s%-40s%-,20d%-10d%-,20d\n", maMh, tenMh, gia, soluong, thanhtien);
    }
    
    @Override
    public String toString(){
        return mahd + "," + maMh + "," + tenMh + "," + gia + "," + soluong + "," + thanhtien; 
    }
}


package com.mycompany.doanhthu;
import java.util.Scanner;

public class CHI {
    private double dien=3000;
    private int ki;
    private double nuoc=9000;
    private int khoi;
    private long matbang=2000000;
    private double luongnhanvien=0;// tien luong cua nhanvien
    private double tiennhaphang=0; /// tien nhap hang

    public CHI(int ki, int khoi) {
        this.ki = ki;
        this.khoi = khoi;
    }
    public CHI(){
        this.ki=0;
        this.khoi=0;
    }
    public double getDien() {
        return dien;
    }

    public void setDien(double dien) {
        this.dien = dien;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public double getNuoc() {
        return nuoc;
    }

    public void setNuoc(double nuoc) {
        this.nuoc = nuoc;
    }

    public int getKhoi() {
        return khoi;
    }

    public void setKhoi(int khoi) {
        this.khoi = khoi;
    }

    public long getMatbang() {
        return matbang;
    }

    public void setMatbang(long matbang) {
        this.matbang = matbang;
    }

    public double getLuongnhanvien() {
        return luongnhanvien;
    }

    public void setLuongnhanvien(double luongnhanvien) {
        this.luongnhanvien = luongnhanvien;
    }

    public double getTiennhaphang() {
        return tiennhaphang;
    }

    public void setTiennhaphang(double tiennhaphang) {
        this.tiennhaphang = tiennhaphang;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    Scanner sc= new Scanner(System.in);
    public void nhapdichvu(){
        System.out.println("NHAP GIA TRI TIEU DUNG TRONG THANG");
        System.out.println("Nhap so ki dien ");
        ki=sc.nextInt();
        System.out.println("Nhap so khoi nuoc ");
        khoi=sc.nextInt();
    }
    public double phidichvu(){
        return (double)ki*dien+khoi*nuoc+matbang;
    }
    public double tienchi(){
        return phidichvu()+luongnhanvien+tiennhaphang;
    }
  
}


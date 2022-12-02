

package com.mycompany.doanhthu;
import java.util.Scanner;

public class CHI {
    private double dien=3000;
    private double nuoc=9000;
    private long matbang=2000000;
    private double luongnhanvien;// tien luong cua nhanvien
    private double tiennhaphang; /// tien nhap hang

    public CHI() {
    }

    

    
    public double getDien() {
        return dien*10;
    }

    public void setDien(double dien) {
        this.dien = dien;
    }



    public double getNuoc() {
        return nuoc*10;
    }

    public void setNuoc(double nuoc) {
        this.nuoc = nuoc;
    }

    public long getMatbang() {
        return matbang;
    }

    public void setMatbang(long matbang) {
        this.matbang = matbang;
    }

    public double getLuongnhanvien() {
        DOCFILE t= new DOCFILE();
        return t.luongnhanvien();
    }

    public void setLuongnhanvien(double luongnhanvien) {
        this.luongnhanvien = luongnhanvien;
    }

    public double getTiennhaphang() {
        DOCFILE a= new DOCFILE();
        
        return a.tienhanghoa();
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
    public double phidichvu(){
        return (double)(getDien()+getNuoc()+getMatbang());
    }
    public double tienchi(){
        return phidichvu()+getLuongnhanvien()+getTiennhaphang();
    }

  
}




package com.mycompany.doanhthu;
import java.io.BufferedReader;
import java.io.FileReader;
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
 
        try {
            FileReader fr= new FileReader("nhanvien.txt");
            BufferedReader br= new BufferedReader(fr);
            String line="";
            
            while (true) {   
                line=br.readLine();
                if(line==null)
                        break;
                String txt[]=line.split(";");
                double tien= Double.parseDouble(txt[2]);
                this.luongnhanvien+=tien;
                
            }
        } catch (Exception e) {
        }
        return this.luongnhanvien;
    }

    public void setLuongnhanvien(double luongnhanvien) {
        this.luongnhanvien = luongnhanvien;
    }

    public double getTiennhaphang() {
        try {
            FileReader fr= new FileReader("hanghoa.txt");
            BufferedReader br= new BufferedReader(fr);
            String line="";
            
            while (true) {   
                line=br.readLine();
                if(line==null)
                        break;
                String txt[]=line.split(";");
                double tien= Double.parseDouble(txt[2]);
                this.tiennhaphang+=tien;
                
            }
        } catch (Exception e) {
        }
        return this.tiennhaphang;
    }

    public void setTiennhaphang(double tiennhaphang) {
        this.tiennhaphang = tiennhaphang;
    }

    
    
    Scanner sc= new Scanner(System.in);
    public double phidichvu(){
        return (double)(getDien()+getNuoc()+getMatbang());
    }
    public double tienchi(){
        return phidichvu()+getLuongnhanvien()+getTiennhaphang();
    }

  
}


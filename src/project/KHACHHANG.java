package project;

import java.util.Scanner;

/**
 *
 * @author compu
 */
public class KHACHHANG implements IO{

    Scanner input=new Scanner(System.in);
    private String ten,SDT;

    public KHACHHANG(String ten) {
        this.ten = ten;
    }
    
    public void NHAP_TEN(){
        System.out.print("Ten KH:");
        ten=input.nextLine(); 
    }

    @Override
    public String toString() {
        return  SDT+"/"+ten;
    }

    public KHACHHANG() {
    }

    public KHACHHANG(String ten, String SDT) {
        this.ten = ten;
        this.SDT = SDT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }    

    @Override
    public void nhap() {
        System.out.print("Nhap ten KH:");
        ten=input.nextLine();
        System.out.print("Nhap SDT:");
        SDT=input.nextLine();
    }

    @Override
    public void xuat() {
        System.out.println(SDT+"/"+ten);
    }

}

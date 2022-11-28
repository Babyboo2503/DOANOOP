package KH;

import java.util.Scanner;

public class THONGTINKHACHHANG {
    Scanner input=new Scanner(System.in);
    private String ten,SDT;
    public void NHAP(){
        System.out.print("Ten KH:");
        ten=input.nextLine();
        System.out.print("SDT:");
        SDT=input.nextLine();  
    }

    public String XUAT() {
        return "THONG TIN KHACH HANG(" + "ten=" + ten + ", SDT=" + SDT + ')';
    }

    public THONGTINKHACHHANG() {
    }

    public THONGTINKHACHHANG(String ten, String SDT) {
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
           
    
}

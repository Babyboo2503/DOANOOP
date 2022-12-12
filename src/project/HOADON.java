package project;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class HOADON{
    private String maHD;
    private String SDT;
    private int maNV;
    private CHITIETHOADON chitiethd;
    private long thanhTien;
    SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy");
    Date date=new Date();
    private String ngayTaoHD=ft.format(date);
    
    Scanner input=new Scanner(System.in); 
    DecimalFormat format = new DecimalFormat();

    HOADON(String maHD,int MaNV, String SDT,String ngayTaoHD) {
        this.maHD = maHD;
        this.maNV=MaNV;
        this.SDT = SDT;
        this.ngayTaoHD=ngayTaoHD;
    }
    HOADON(String maHD,int MaNV, String SDT,String ngayTaoHD, long thanhtien) {
        this.maHD = maHD;
        this.maNV=MaNV;
        this.SDT = SDT;
        this.ngayTaoHD=ngayTaoHD;
        this.thanhTien = thanhtien;
    }

    public HOADON(String maHD, String SDT, int maNV, CHITIETHOADON chitiethd, long thanhTien, String ngayTaoHD) {
        this.maHD = maHD;
        this.SDT = SDT;
        this.maNV = maNV;
        this.chitiethd = chitiethd;
        this.ngayTaoHD = ngayTaoHD;
        this.thanhTien = thanhTien;
    }
    HOADON() {
    }

    @Override
    public String toString() {
        return maHD + "," + maNV + "," + SDT + ","+ ngayTaoHD + "," + thanhTien;
    }
    
    public String xuatHdVaCt(){
        return chitiethd.toString();
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public CHITIETHOADON getChitiethd() {
        return chitiethd;
    }

    public void setChitiethd(CHITIETHOADON chitiethd) {
        this.chitiethd = chitiethd;
        setThanhTien(chitiethd.getTT());
    }

    public String getNgayTaoHD() {
        return ngayTaoHD;
    }

    public void setNgayTaoHD(String ngayTaoHD) {
        this.ngayTaoHD = ngayTaoHD;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public void taoHD(String mahd, int manv, String sdtkh, KHO kho){
        setMaHD(mahd);
        setMaNV(manv);
        setSDT(sdtkh);
        chitiethd = new CHITIETHOADON();
        chitiethd.nhapCTHD(mahd,kho);
        setThanhTien(chitiethd.getTT());
    }
    public void taoHD(int manv, KHO kho){
        setMaNV(manv);
        chitiethd = new CHITIETHOADON();
        chitiethd.nhapCTHD(maHD, kho);
        setThanhTien(chitiethd.getTT());
    }

    public void XUAT_KTV(){
        System.out.println("-------------------------------HOADON------------------------------------\n");
        System.out.println("Ma don: "+getMaHD());
        System.out.println("N.Vien: "+getMaNV());
        System.out.println("                                                        KH: "+getSDT());
        System.out.println("                                                  Ngay tao: "+getNgayTaoHD());
        System.out.printf("%-15s%-40s%-20s%-10s%-20s\n","Ma san pham","Ten san pham","So luong","Gia tien","Thanh Tien");
        chitiethd.xuat();
        System.out.println("-------------------------------------------------------------");
        System.out.printf("TONG TIEN : %,d VND",thanhTien);    
        System.out.println("\n\n");
    }
    
    /*
    public void XUAT(HOADON A,ArrayList<CHITIETHOADON> arrayctdh ){
        System.out.println("-------------------------------HOADON------------------------------------\n");
        System.out.println("Ma don: "+getMaHD());
        System.out.println("N.Vien: "+getMaNV());
        System.out.println("                                                        KH: "+getSDT());
        System.out.println("                                                  Ngay tao: "+getNgayTaoHD());
//        System.out.printf("%6s%15s%15s%15s%15s\n","Ma san pham","Ten san pham","So luong","Gia tien","Thanh Tien");
//        for(int i=0;i<arrayctdh.size();i++)
//        {
//        long x=arrayctdh.get(i).getSL()*arrayctdh.get(i).getDG();
//        System.out.printf("%6s%15s%15s%15s%15s\n",arrayctdh.get(i).getMaSP(),arrayctdh.get(i).getTenSP(),arrayctdh.get(i).getSL(),arrayctdh.get(i).getDG(),x);
//        thanhTien+=x;
//        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("TONG TIEN : %35.3f VND",thanhTien);
        System.out.println();
    }*/
}
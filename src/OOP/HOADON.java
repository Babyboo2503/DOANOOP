package OOP;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class HOADON {
    static String maHD;
    String SDT,maNV;
    CHITIETHOADON chitiethd;
    long thanhTien;
    SimpleDateFormat ft=new SimpleDateFormat("dd-MM-yyyy");
    Date date=new Date();
    String ngayTaoHD=ft.format(date);
    
    Scanner input=new Scanner(System.in); 
    DecimalFormat format = new DecimalFormat();



    public HOADON(String maHD,String MaNV, String SDT,String ngayTaoHD) {
        this.maHD = maHD;
        this.maNV=MaNV;
        this.SDT = SDT;
        this.ngayTaoHD=ngayTaoHD;
    }

    public HOADON() {
    }


    @Override
    public String toString() {
        return maHD + "/" + maNV + "/" + SDT + "/"+ ngayTaoHD;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public CHITIETHOADON getChitiethd() {
        return chitiethd;
    }

    public void setChitiethd(CHITIETHOADON chitiethd) {
        this.chitiethd = chitiethd;
    }

    public String getNgayTaoHD() {
        return ngayTaoHD;
    }

    public void setNgayTaoHD(String ngayTaoHD) {
        this.ngayTaoHD = ngayTaoHD;
    }

    public void XUAT_KTV(HOADON A, ArrayList<CHITIETHOADON> arraycthd){
        System.out.println("-------------------------------HOADON------------------------------------\n");
        System.out.println("Ma don: "+getMaHD());
        System.out.println("N.Vien: "+getMaNV());
        System.out.println("                                                        KH: "+getSDT());
        System.out.println("                                                  Ngay tao: "+getNgayTaoHD());
        System.out.printf("%6s%15s%15s%15s%15s\n","Ma san pham","Ten san pham","So luong","Gia tien","Thanh Tien");
        for(int i=0;i<arraycthd.size();i++)
        {
        long x=arraycthd.get(i).getSL()*arraycthd.get(i).getDG();
        System.out.printf("%6s%15s%15s%15s%15s\n",arraycthd.get(i).getMaSP(),arraycthd.get(i).getTenSP(),arraycthd.get(i).getSL(),arraycthd.get(i).getDG(),x);
        thanhTien+=x;
        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("TONG TIEN : %35.3f VND",thanhTien);    
        System.out.println();
    }
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
    }
}
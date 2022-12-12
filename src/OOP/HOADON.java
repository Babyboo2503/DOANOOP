package OOP;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class HOADON {
    static String maHD;
    String SDT;
    int maNV;
    SimpleDateFormat ft=new SimpleDateFormat("dd-MM-yyyy");
    Date date=new Date();
    String ngayTaoHD=ft.format(date);
    
    Scanner input=new Scanner(System.in); 
    DecimalFormat format = new DecimalFormat();



    public HOADON(String maHD,int MaNV, String SDT,String ngayTaoHD) {
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
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    


    public String getNgayTaoHD() {
        return ngayTaoHD;
    }

    public void setNgayTaoHD(String ngayTaoHD) {
        this.ngayTaoHD = ngayTaoHD;
    }

    public void XUAT_KTV(){
        System.out.println("-------------------------------HOADON------------------------------------\n");
        System.out.println("Ma don: "+getMaHD());
        System.out.println("N.Vien: "+getMaNV());
        System.out.println("                                                        KH: "+getSDT());
        System.out.println("                                                  Ngay tao: "+getNgayTaoHD());
        System.out.printf("%6s%15s%15s%15s%15s\n","Ma san pham","Ten san pham","So luong","Gia tien","Thanh Tien");
//        for(int i=0;i<arraycthd.size();i++)
//        {
//        long x=arraycthd.get(i).getSL()*arraycthd.get(i).getDG();
//        System.out.printf("%6s%15s%15s%15s%15s\n",arraycthd.get(i).getMaSP(),arraycthd.get(i).getTenSP(),arraycthd.get(i).getSL(),arraycthd.get(i).getDG(),x);
//        thanhTien+=x;
//        }

    }
    public void XUAT( ){
        System.out.println("-------------------------------HOADON------------------------------------\n");
        System.out.println("Ma don: "+getMaHD());
        System.out.println("N.Vien: "+getMaNV());
        System.out.println("                                                  Ngay tao: "+getNgayTaoHD());
        System.out.printf("%6s%15s%15s%15s%15s\n","Ma san pham","Ten san pham","So luong","Gia tien","Thanh Tien");
    }


}
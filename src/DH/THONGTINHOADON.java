package DH;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class THONGTINHOADON {
    String maKH,maHD,TenSP,ngayTaoHD,maSP;
    int SL;
    double donGia, thanhTien;
    Scanner input=new Scanner(System.in); 
    DecimalFormat format = new DecimalFormat();

    public void NHAP(){
        System.out.print("Ma san pham: ");
        maSP=input.nextLine();
        System.out.print("So luong: ");
        SL=input.nextInt();
        System.out.print("Don gia:");
        donGia=input.nextDouble();
        thanhTien=donGia*SL;
        System.out.println("Thanh tien:"+format.format(thanhTien));
    }

    @Override
    public String toString() {
        return "HOADON{" + "TenSP=" + TenSP + ", maSP=" + maSP + ", SL=" + SL + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }
    
    public void XUAT(){
        System.out.println("-------------------------------HOADON------------------------------------\n");
        System.out.println("Ma don: "+maHD);
        System.out.printf("%6s%15s%15s%15s\n","Ma DH","Ma san pham","So luong","Gia tien");
        //System.out.println("          Ma san pham           Gia tien              So luong         ");
//        for(THONGTINSANPHAM t : ttsp){
//        System.out.printf("%15d%15d%17.3f VND\n",t.masp,t.soluong,t.price);
//        }
//        System.out.println("-------------------------------------------------------------");
//        System.out.printf("TONG TIEN : %35.3f VND",thanhtien);
//        //System.out.println("                                                       TONG TIEN = "+thanhtien+"VND");        
    }
}

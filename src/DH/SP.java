package DH;

import static DH.CHITIETHD.arraySP;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class SP {
    String TenSP,maSP;
    int SL;
    double donGia, thanhTien;    
    DecimalFormat format = new DecimalFormat();
    Scanner input=new Scanner(System.in);


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

    public SP( String maSP,String TenSP, int SL, double donGia, double thanhTien) {
        this.TenSP = TenSP;
        this.maSP = maSP;
        this.SL = SL;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public SP() {
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
    public void themSP(){
//        arraySP.clear();
        FILE_SP f=new FILE_SP();
//        f.readFromFile(arraySP);
        SP a=new SP();
        a.NHAP();
        arraySP.add(a);
        f.writeToFile(arraySP);       
    }
    
}

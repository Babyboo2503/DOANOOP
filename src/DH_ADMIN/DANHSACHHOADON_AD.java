package DH_ADMIN;

import DH.CHITIETHD;
import static DH.CHITIETHD.arraySP;
import DH.HOADON;
import DH.SP;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class DANHSACHHOADON_AD {
    public static ArrayList<HOADON> arrayHD=new ArrayList<>();
    static public int i=0;
    Scanner input=new Scanner(System.in);
    public void themHD(){
        FILE_DH f=new FILE_DH();
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        SP sp=new SP();
        i++;
                CHITIETHD cthd=new CHITIETHD();
        cthd.main();
        arrayHD.add(a);
        a.XUAT(a,arraySP);
        f.writeToFile(arrayHD);       
    }
    public void themHD_KTV(String SDT){
        FILE_DH f=new FILE_DH();
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        a.setSDT(SDT);
//        a.setMaNV(SDT);
        CHITIETHD cthd=new CHITIETHD();
        cthd.main();
        arrayHD.add(a);
        a.XUAT_KTV(a,arraySP);
        f.writeToFile(arrayHD);       
    }
     public void timKiem_HD(){
        FILE_DH f=new FILE_DH();
        f.readFromFile(arrayHD);
        System.out.print("Nhap ma hoa don:");
        input=new Scanner(System.in);
        String mahd= input.nextLine();
        for(int i=0;i<arrayHD.size();i++){
            if(mahd.compareTo(arrayHD.get(i).getMaHD())==0){
                System.out.println(arrayHD.get(i).toString());
                int option;
                do{
                System.out.println("=====BANG CHON=====");
                System.out.println("1.Xoa");
                System.out.println("2.Thoat");
                System.out.println("(1/2)");
                option=input.nextInt();
                DANHSACHHOADON_AD B= new DANHSACHHOADON_AD();
                switch(option){
                case 1 -> {
                    B.xoaHD(mahd);
                }
                case 2 -> {
                    QLHD_AD A=new QLHD_AD();
                    A.main();
                }
                                    }}while(option<4&&option>0);
                }
            if(i==(arrayHD.size()-1) &&mahd.compareTo(arrayHD.get(i).getMaHD())!=0)
                System.out.println("Khong ton tai");
        }
    }
     
    public void xoaHD(String maHD){
//        System.out.print("Nhap so dien thoai:");
//        input=new Scanner(System.in);
//        String SDT= input.nextLine();
        arrayHD.clear();
        FILE_DH f=new FILE_DH();
        FILE_DH f2=new FILE_DH();
        f.readFromFile(arrayHD);
        for(int i=0;i<arrayHD.size();i++){
            if(maHD.compareTo(arrayHD.get(i).getMaHD())==0){
                arrayHD.remove(arrayHD.get(i));
                f2.writeToFile(arrayHD);
                System.out.println("Da xoa");
                break;
            }
            if(i==(arrayHD.size()-1) &&maHD.compareTo(arrayHD.get(i).getSDT())!=0){
                System.out.println("Khong thanh cong");
            }
        }
    }
    public void xuatDSHD(){
        arrayHD.clear();
        FILE_DH file=new FILE_DH();
        file.readFromFile(arrayHD);
        for(int x=0;x<arrayHD.size();x++){
            System.out.println(arrayHD.get(x).toString());
        }
    }

}

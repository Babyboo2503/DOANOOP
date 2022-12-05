package DH;
import DH_ADMIN.FILE_DH;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHHOADON {
    Scanner input=new Scanner(System.in);
    ArrayList<HOADON> arrayHD=new ArrayList<>();
    static public int i=0;
    public void themHD(){
        FILE_DH f=new FILE_DH();
        HOADON a= new HOADON();
        a.NHAP();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        arrayHD.add(a);
        a.XUAT(a);
        f.writeToFile(arrayHD);       
    }
    public void themHD_KTV(String SDT){
        FILE_DH f=new FILE_DH();
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        a.setSDT(SDT);
//        a.setMaNV(SDT);
        a.NHAP();
        arrayHD.add(a);
        a.XUAT_KTV(a);
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
//                int option;
//                do{
//                System.out.println("=====BANG CHON=====");
//                System.out.println("1.IN HOA DON");
//                System.out.println("2.Sua");
//                System.out.println("3.Xoa");
//                System.out.println("4.Thoat");
//                System.out.println("(1/2/3/4)");
//                option=input.nextInt();
//                switch(option){
//                case 1 -> {
//                    DANHSACHHOADON_AD B= new DANHSACHHOADON_AD();
//                    B.themHD();
//                }
//                case 2 -> {
//                    suaKH(i);
//                    arrayKH.get(i).toString();
//                }
//                case 3 ->{    
//                    xoaKH(SDT);
//                    KHACHTHANHVIEN_AD A=new KHACHTHANHVIEN_AD();
//                    A.main();
//                }
//                }
//                ERROR
//                                    }while(option<4&&option>0);
                }
            if(i==(arrayHD.size()-1) &&mahd.compareTo(arrayHD.get(i).getMaHD())!=0)
                System.out.println("Khong ton tai");
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

package KH_ADMIN;
import DH_ADMIN.DANHSACHHOADON_AD;
import static DH_ADMIN.DANHSACHHOADON_AD.arrayHD;
import DH_ADMIN.FILE_DH;
import KH.KHACHHANG;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHKHACHHANG_AD {
    static Scanner input=new Scanner(System.in);
    static ArrayList<KHACHHANG> arrayKH=new ArrayList<>();
//    HÀM KIỂM TRA VÀ TÌM KIẾM KHÁCH HÀNG
    public int ktraKH(String SDT){
        arrayKH.clear();
        FILE_KH file=new FILE_KH();
        file.readFromFile(arrayKH); 
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0)
                    return 1;
            }
        return 0;
    }
//    THEM KH VAO DS BANG FILE_KH
//    THEM MOI KHACH HANG
    public void themKH(){       
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT= input.nextLine();
        if(ktraKH(SDT)==0){
            KHACHHANG a= new KHACHHANG();
            a.NHAP_TEN();
            a.setSDT(SDT);
            arrayKH.add(a);
            FILE_KH f=new FILE_KH();
            f.writeToFile(arrayKH);
            System.out.println("Them thanh cong!"); 
        }
        else{
        System.out.println("SDT da ton tai");
        }
    }
//LOI ARRAYKH DANG BI TRONG, KHONG CO PHAN TU
    public void xuatDSKH(){
        arrayKH.clear();
        FILE_KH file=new FILE_KH();
        file.readFromFile(arrayKH);
        for(int i=0;i<arrayKH.size();i++){
            System.out.println(arrayKH.get(i).toString());
        }
    }
//TÌM KIẾM KHÁCH H, NEU TIM THAY CO QUYEN SUA,XOA
    public void timKiem(){
        FILE_KH f=new FILE_KH();
        FILE_DH f2=new FILE_DH();
        f2.readFromFile(arrayHD);
        f.readFromFile(arrayKH);
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                System.out.println(arrayKH.get(i).toString());
                int option;
                do{
                System.out.println("=====BANG CHON=====");
                System.out.println("1.LICH SU MUA HANG");
                System.out.println("2.Sua");
                System.out.println("3.Xoa");
                System.out.println("4.Thoat");
                System.out.println("(1/2/3/4)");
                option=input.nextInt();
                switch(option){
                case 1 -> {                
                    for(int j=0;j<arrayHD.size();j++)
                    {
                         if(SDT.compareTo(arrayHD.get(j).getSDT())==0){
                            System.out.println(arrayHD.get(j).toString());
                        }
                         
                    }     
                }
                case 2 -> {
                    suaKH(i);
                    arrayKH.get(i).toString();
                }
                case 3 ->{    
                    xoaKH(SDT);
                    KHACHTHANHVIEN_AD A=new KHACHTHANHVIEN_AD();
                    A.main();
                }
                }
                                    }while(option<4&&option>0);
                }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        }
    }
    public void timKiem_xuatHD(){
        FILE_KH f=new FILE_KH();
        f.readFromFile(arrayKH);
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                System.out.println(arrayKH.get(i).toString());
                DANHSACHHOADON_AD B= new DANHSACHHOADON_AD();
                B.themHD_KTV(SDT);
                }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        }
    }
//    public void xacNhanInHD(){
//    }
    public void xoaKH(String SDT){
//        System.out.print("Nhap so dien thoai:");
//        input=new Scanner(System.in);
//        String SDT= input.nextLine();
        arrayKH.clear();
        FILE_KH f=new FILE_KH();
        FILE_KH f2=new FILE_KH();
        f.readFromFile(arrayKH);
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                arrayKH.remove(arrayKH.get(i));
                f2.writeToFile(arrayKH);
                System.out.println("Da xoa");
                break;
            }
//            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0){
//                System.out.println("");
//            }
        }
    }
    public void suaKH(int i){
        int option;
        System.out.println("=====BANGCHON=====");
        System.out.println("1.SDT");
        System.out.println("2.Ten");
        System.out.println("3.Thoat");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        switch (option) {
            case 1 -> {
                System.out.print("Nhap SDT moi:");
                input=new Scanner(System.in);
                String SDT_tmp=input.nextLine();
//                arrayKH.clear();
                arrayKH.get(i).setSDT(SDT_tmp);
                FILE_KH f=new FILE_KH();
                f.writeToFile(arrayKH);
            }
            case 2 -> {
//                KHI XOA THI XOA HET MANG, NHUNG SET CHI SET 1 GIA TRI, LOI CT
                System.out.print("Nhap ten moi:");
                input=new Scanner(System.in);
                String ten_tmp=input.nextLine();               
                arrayKH.get(i).setTen(ten_tmp);
                FILE_KH f=new FILE_KH();
                f.writeToFile(arrayKH);}
        }
        }
    }
//    public void


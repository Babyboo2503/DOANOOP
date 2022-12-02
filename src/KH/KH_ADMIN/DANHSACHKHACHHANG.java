package KH_ADMIN;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHKHACHHANG {
    static Scanner input=new Scanner(System.in);
    static ArrayList<KHACHHANG> arrayKH=new ArrayList<>();
//    HÀM KIỂM TRA VÀ TÌM KIẾM KHÁCH HÀNG
    public int ktraKH(String SDT){
        FILE file=new FILE();
        file.readFromFile(arrayKH); 
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0)
                    return 1;
            }
        return 0;
    }
//    THEM KH VAO DS BANG FILE
//    THEM MOI KHACH HANG
    public void themKH(){       
        System.out.print("Nhap so dien thoai:");
        String SDT= input.nextLine();
        if(ktraKH(SDT)==0){
            KHACHHANG a= new KHACHHANG();
            a.NHAP_TEN();
            a.setSDT(SDT);
            arrayKH.add(a);
            FILE f=new FILE();
            f.writeToFile(arrayKH);
            System.out.println("Them thanh cong!"); 
        }
        else{
        System.out.println("SDT da ton tai");
        }
    }
//LOI ARRAYKH DANG BI TRONG, KHONG CO PHAN TU
    public void xuatDSKH(){
//        FILE file=new FILE();
//        file.readFromFile(arrayKH);
        for(int i=0;i<arrayKH.size();i++){
            System.out.println(arrayKH.get(i).toString());
        }
    }
//TÌM KIẾM KHÁCH H, NEU TIM THAY CO QUYEN SUA,XOA
    public void timKiem(){
        FILE f=new FILE();
        f.readFromFile(arrayKH);
        System.out.print("Nhap so dien thoai:");
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                System.out.println(arrayKH.get(i).toString());
                int option;
                do{
                System.out.println("=====BANG CHON=====");
                System.out.println("1.Sua");
                System.out.println("2.Xoa");
                System.out.println("3.Thoat");
                System.out.println("(1/2/3)");
                option=input.nextInt();
                switch(option){
                case 1 -> {
                    suaKH(i);
                    arrayKH.get(i).toString();
                }
                case 2 ->{    
                    xoaKH();
                }
                }
                }while(option<3&&option>0);
                }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        }
    }
    public void xacNhanInHD(){
        int option;
        do {
        System.out.println("1.THANH TOAN");
        System.out.println("2.THOAT ");
        System.out.println("(1/2)");
        option=input.nextInt();            
            switch(option){
            case 1 -> {
                //
            }
            case 2 ->{                 
                
            }
        }        
        } while (option<3);   
    }
    public void xoaKH(){
        System.out.print("Nhap so dien thoai:");
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                arrayKH.remove(arrayKH.get(i));
                break;
            }
                FILE f=new FILE();
                f.writeToFile(arrayKH);
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai ");
        }
    }
    public void suaKH(int i){
        int option;
        System.out.println("=====BANGCHON=====");
        System.out.println("1.SDT:");
        System.out.println("2.Ten");
        System.out.println("3.Thoat");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        switch (option) {
            case 1 -> {
                System.out.print("Nhap SDT moi:");
                String SDT_tmp=input.nextLine();
                arrayKH.get(i).setSDT(SDT_tmp);
            }
            case 2 -> {
                System.out.println("Nhap ten moi:");
                String ten_tmp=input.nextLine();
                arrayKH.get(i).setTen(ten_tmp);}
        }
        }
    }
//    public void


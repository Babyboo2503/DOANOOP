package DH_ADMIN;

import DH.HOADON;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class DANHSACHHOADON_AD {
    static ArrayList<HOADON> arrayHD=new ArrayList<>();
    static int i=0;
    Scanner input=new Scanner(System.in);
    public void themHD(){
        FILE f=new FILE();
        HOADON a= new HOADON();
        a.NHAP();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        System.out.println(a.getMaHD());
        System.out.println("Thanh cong!");
        arrayHD.add(a);
        a.XUAT(a);
        f.writeToFile(arrayHD);       
    }
     public void timKiem(){
        FILE f=new FILE();
        f.readFromFile(arrayHD);
        System.out.print("Nhap ma hoa don:");
        input=new Scanner(System.in);
        String maHD= input.nextLine();
        for(int i=0;i<arrayHD.size();i++){
            if(maHD.compareTo(arrayHD.get(i).getMaHD())==0){
                System.out.println(arrayHD.get(i).toString());
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
//                    suaKH(i);
//                    arrayKH.get(i).toString();
                }
//                ERROR
                case 2 ->{    
                    
                }
                }
                }while(option<3&&option>0);
                }
            if(i==(arrayHD.size()-1) &&maHD.compareTo(arrayHD.get(i).getMaHD())!=0)
                System.out.println("Khong ton tai");
        }
    }
    public void xuatDSHD(){
        arrayHD.clear();
        FILE file=new FILE();
        file.readFromFile(arrayHD);
        for(int x=0;x<arrayHD.size();x++){
            System.out.println(arrayHD.get(x).toString());
        }
    }
//    public void test(){
//        arrayHD.clear();
//        FILE file=new FILE();
//        file.readFromFile(arrayHD);
//    }
    public void suaHD(){
        int option;
        System.out.println("=====BANGCHON=====");
        System.out.println("1.Ma San Pham");
        System.out.println("2.So luong");
        System.out.println("3.Thoat");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        switch (option) {
            case 1 -> {
//                System.out.print("Nhap SDT moi:");
//                input=new Scanner(System.in);
//                String SDT_tmp=input.nextLine();
////                arrayKH.clear();
//                arrayHD.get(i).setSDT(SDT_tmp);
//                FILE f=new FILE();
//                f.writeToFile(arrayKH);
            }
            case 2 -> {
////                KHI XOA THI XOA HET MANG, NHUNG SET CHI SET 1 GIA TRI, LOI CT
//                System.out.print("Nhap ten moi:");
//                input=new Scanner(System.in);
//                String ten_tmp=input.nextLine();               
//                arrayKH.get(i).setTen(ten_tmp);
//                FILE f=new FILE();
//                f.writeToFile(arrayKH);}
        }        
    }
    }
}

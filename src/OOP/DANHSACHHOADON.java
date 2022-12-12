package OOP;

import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHHOADON extends IOfile{
        ArrayList<HOADON> arrayHD= new ArrayList<>();
        DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();   
        Scanner input=new Scanner(System.in);
        public int i=0;
        int option;
        CHITIETHOADON B=new CHITIETHOADON();        
    public void InHD(){
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        arrayHD.add(a);
        f.writeToFile_HD(arrayHD);
        B.nhap();
    }
    public void InHD_KTV(String SDT){


        if (A.ktraKH(SDT)==1){
            HOADON a= new HOADON();
            a.setMaHD("HD"+ String.valueOf(i));
            i++;
            a.setSDT(SDT);
            arrayHD.add(a);
            f.writeToFile_HD(arrayHD); 
            B.nhap();
            System.out.println("Them thanh cong");
        }
        else{
            System.out.println("KHACH HANG KHONG TON TAI");
        }

    }    
    

     public void timKiem_HD(){
        f.readFromFile_HD(arrayHD);
        System.out.print("Nhap ma hoa don:");
        input=new Scanner(System.in);
        String mahd= input.nextLine();
        for(int n=0;n<arrayHD.size();n++){
            if(mahd.compareTo(arrayHD.get(n).getMaHD())==0){
                System.out.println(arrayHD.get(n).toString());
                }
            if(n==(arrayHD.size()-1) &&mahd.compareTo(arrayHD.get(n).getMaHD())!=0)
                System.out.println("Khong ton tai");
        }
    }
     public void timKiem_HD(String SDT){
        f.readFromFile_HD(arrayHD);
//        System.out.print("Nhap ma hoa don:");
//        input=new Scanner(System.in);
//        String mahd= input.nextLine();
        for(int n=0;n<arrayHD.size();n++){
            if(SDT.compareTo(arrayHD.get(n).getSDT())==0){
                System.out.println(arrayHD.get(n).toString());
                }
            if(n==(arrayHD.size()-1) &&SDT.compareTo(arrayHD.get(n).getSDT())!=0)
                System.out.println("Khong ton tai");
        }
    }
    public void xuatDSHD(){
        arrayHD.clear();
        f.readFromFile_HD(arrayHD);
        for(int x=0;x<arrayHD.size();x++){
            System.out.println(arrayHD.get(x).toString());
        }
    }   

    public void xoaHD(){
        f.readFromFile_HD(arrayHD);
        System.out.print("Nhap ma hoa don can xoa:");
        input=new Scanner(System.in);
        String mahd= input.nextLine();
        for(int n=0;n<arrayHD.size();n++){
            if(mahd.compareTo(arrayHD.get(n).getMaHD())==0){
                arrayHD.remove(arrayHD.get(n));
                System.out.println("Da xoa");
                }
            if(n==(arrayHD.size()-1) &&mahd.compareTo(arrayHD.get(n).getMaHD())!=0)
                System.out.println("Khong ton tai");
        }        
    }
    public void menu(){
        System.out.println("=====MENU=====");
        System.out.println("1. Tim kiem HD");
        System.out.println("2. Xem DSHD");
        System.out.println("3. Thoat");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        switch (option) {
            case 1:
                timKiem_HD();
                break;
            case 2:
                xuatDSHD();
                break;
            default:
                throw new AssertionError();
        }
    }
    public void TTOAN_AD(){
        
    }
    public void main(){
        menu();
    }
}

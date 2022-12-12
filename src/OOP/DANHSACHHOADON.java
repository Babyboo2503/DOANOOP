package OOP;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHHOADON extends IOfile{
        static ArrayList<HOADON> arrayHD= new ArrayList<>();
        DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();    
        Scanner input=new Scanner(System.in);
        static int i=0;
        int option;
        CHITIETHOADON B=new CHITIETHOADON();        
    public void InHD(int id){
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        a.setMaNV(id);
        arrayHD.clear();
        arrayHD.add(a);
        f.writeToFile_HD(arrayHD);
        B.nhap(a);        
    }
    public void InHD_KTV(int id){
        String SDT;
        System.out.println("Nhap SDT");
        SDT=input.nextLine();
        if (A.ktraKH(SDT)==1){
            HOADON a= new HOADON();
            a.setMaHD("HD"+ String.valueOf(i));
            i++;
            a.setSDT(SDT);
            a.setMaNV(id);
            arrayHD.clear();
            arrayHD.add(a);
            f.writeToFile_HD(arrayHD);  
            B.nhap_KTV(a);          
        }
        else{
            System.out.println("KHACH HANG KHONG TON TAI");
        }
    }    
    public void InHD(){
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        a.setMaNV(0);
        arrayHD.clear();
        arrayHD.add(a);
        f.writeToFile_HD(arrayHD); 
        B.nhap(a);        
    }
    public void InHD_KTV(){
        String SDT;
        System.out.println("Nhap SDT");
        SDT=input.nextLine();
        if (A.ktraKH(SDT)==1){
            HOADON a= new HOADON();
            a.setMaHD("HD"+ String.valueOf(i));
            i++;
            a.setSDT(SDT);
            a.setMaNV(0);
            arrayHD.clear();
            arrayHD.add(a);
            f.writeToFile_HD(arrayHD);
            B.nhap_KTV(a);            
        }
        else{
            System.out.println("KHACH HANG KHONG TON TAI");
        }

    }    
    
    

     public void timKiem_HD(){
         int n=0;
        f.readFromFile_HD(arrayHD);
        if(f!=NULL){
        System.out.print("Nhap ma hoa don:");
        input=new Scanner(System.in);
        String mahd= input.nextLine();
        for(;n<arrayHD.size();n++){
            if(mahd.compareTo(arrayHD.get(n).getMaHD())==0){
                System.out.println(arrayHD.get(n).toString());
                }
            if(n==(arrayHD.size()-1) &&mahd.compareTo(arrayHD.get(n).getMaHD())!=0){
                System.out.println("Khong ton tai");
            }
        }
        }
        else
             System.out.println("DSHD rong");
    }
     public void timKiem_HD(String SDT){
        f.readFromFile_HD(arrayHD);
        int n=0;
        for(;n<arrayHD.size();n++){
            if(SDT.compareTo(arrayHD.get(n).getSDT())==0){
                System.out.println(arrayHD.get(n).toString());
                }
        }
        if(n==(arrayHD.size()-1) &&SDT.compareTo(arrayHD.get(n).getSDT())!=0)
                System.out.println("Lich su mua hang trong");
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
    public void menu() throws InterruptedException{
        do{
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
            case 3:
                QUANLYCUAHANG.ADMIN();
        }
        }while(option<3&&option>0);    
    }
    public void TTOAN_AD(){
        
    }
    public void main() throws InterruptedException{
        menu();
    }
}

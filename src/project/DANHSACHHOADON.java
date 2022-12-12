package project;

import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHHOADON extends IOfile{
    
    private ArrayList<HOADON> arrayHD= new ArrayList<>();
    private DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();   
    Scanner input=new Scanner(System.in);
    private int option;
/*
    public void InHD(){
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        arrayHD.add(a);
        f.writeToFile_HD(arrayHD);
    }
*/
    DANHSACHHOADON(ArrayList<HOADON> arrayHD, int option, DANHSACHKHACHHANG A) {
        this.arrayHD = arrayHD;
        this.option = option;
        this.A = A;
    }
    DANHSACHHOADON() {
        f.readFromFile_HD(arrayHD);
    }
    
    public void InHD(String SDT, int manv, KHO kho){
        HOADON a= new HOADON();
        int mahd = (arrayHD.size()>0) ? arrayHD.size() + 1 : 1;
        a.setMaHD("HD"+ String.valueOf(mahd));
        a.setSDT(SDT);
        a.taoHD(manv, kho);
        arrayHD.add(a);
        f.writeToFile_HD(arrayHD); 
        System.out.println("Them thanh cong");
    }

    public void timKiem_HD(){
        if(arrayHD.isEmpty()){
            System.out.println("Khong co hoa don!");
            return;
        }
        byte count = 0;
        System.out.print("Nhap ma hoa don:");
        input=new Scanner(System.in);
        String mahd= input.nextLine();
        for(int n=0;n<arrayHD.size();n++){
            if(mahd.compareTo(arrayHD.get(n).getMaHD())==0){
                count = 1;
                arrayHD.get(n).XUAT_KTV();
            }
        }
        if(count == 0){
            System.out.println("Khong co hoa don can tim!");
        }
    }
    public void timKiem_HD(String SDT){
//        System.out.print("Nhap ma hoa don:");
//        input=new Scanner(System.in);
//        String mahd= input.nextLine();
        byte count = 0;
        for(int n=0;n<arrayHD.size();n++){
            if(SDT.compareTo(arrayHD.get(n).getSDT())==0){
                count = 1;
                arrayHD.get(n).XUAT_KTV();
            }
        }
        if(count == 0){
            System.out.println("Khong co hoa don can tim!");
        }
    }
    public void xuatDSHD(){
        for(int x=0;x<arrayHD.size();x++){
            arrayHD.get(x).XUAT_KTV();
        }
    }   
    public void xoaHD(){
        byte count = 0;
        System.out.print("Nhap ma hoa don can xoa:");
        input=new Scanner(System.in);
        String mahd= input.nextLine();
        for(int n=0;n<arrayHD.size();n++){
            if(mahd.compareTo(arrayHD.get(n).getMaHD())==0){
                count = 1;
                arrayHD.remove(arrayHD.get(n));
                System.out.println("Da xoa");
                f.writeToFile_HD(arrayHD);
            }
        }       
        if(count == 0){
            System.out.println("Khong co hoa don can tim!");
        }
    }

    public void menu(DANHSACHKHACHHANG dskh, int manv, KHO kho){
        hd:
        while(true){
            System.out.println("=====MENU=====");
            System.out.println("1. Tao HD");
            System.out.println("2. Tim kiem HD");
            System.out.println("3. Xem DSHD");
            System.out.println("4. Quay lai");
            System.out.println("(1/2/3/4)");
            option=input.nextInt();
            switch (option) {
                case 1: {
                    if(input.hasNextLine()){
                        input.nextLine();
                    }
                    dskh.xuatDSKH();
                    System.out.print("So dien thoai cua khach: ");
                    String SDT = input.nextLine();
                    while(dskh.ktraKH(SDT) != 1){
                        System.out.println("So dien thoai khong dung!");
                        System.out.print("Nhap lai so dien thoai cua khach: ");
                    }
                    System.out.println("Nhap dung!");
                    InHD(SDT, manv, kho);
                }
                    break;
                case 2:
                    timKiem_HD();
                    break;
                case 3:
                    xuatDSHD();
                    break;
                case 4:
                    break hd;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
}

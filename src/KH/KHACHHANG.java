package KH;

import java.util.Scanner;
public class KHACHHANG {
    Scanner input=new Scanner(System.in);
    public void main(){
        int option;
        do {            
        System.out.println("=====BANG CHON=====");
        System.out.println("1.TIM KIEM");
        System.out.println("2.THEM MOI ");
        System.out.println("3.XEM DANH SACH KHACH HANG ");
        System.out.println("4.THOAT ");
        System.out.println("(1/2/3/4)");
        option=input.nextInt();
            switch(option){
            case 1 -> {
                DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();
                A.timKiem();
            }
            case 2 -> {
                DANHSACHKHACHHANG B=new DANHSACHKHACHHANG();
                if(B.ktraKH()==0){
                    B.themKH();
                    B.xuatDSKH();
                }
                
                else
                    System.out.println("SDT da ton tai");
            }
            case 3 -> {
                DANHSACHKHACHHANG C= new DANHSACHKHACHHANG();
                C.xuatDSKH();
                }
            case 4 -> {
                HINHTHUCMUAHANG D= new HINHTHUCMUAHANG();
                D.main();
            }
            }
        }while (option<5);
            
        }
            
        }
        


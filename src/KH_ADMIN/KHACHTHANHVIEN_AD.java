package KH_ADMIN;
import java.util.Scanner;
public class KHACHTHANHVIEN_AD {
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
                DANHSACHKHACHHANG_AD A=new DANHSACHKHACHHANG_AD();
                A.timKiem();
            }
            case 2 -> {
                DANHSACHKHACHHANG_AD B=new DANHSACHKHACHHANG_AD();
                B.themKH();
            }
            case 3 -> {
                DANHSACHKHACHHANG_AD C= new DANHSACHKHACHHANG_AD();
                C.xuatDSKH();
                }
            case 4 -> {
                TTOAN_AD D= new TTOAN_AD();
                D.main();
            }
            default -> { 
                System.out.println("========END========");
                }
                
            }
        }while (option<5);
            
        }
            
        }
        


package KH;
import java.util.Scanner;
public class KHACHTHANHVIEN {
    Scanner input=new Scanner(System.in);
    public void main(){
        int option;
        do {            
        System.out.println("=====BANG CHON=====");
        System.out.println("1.TIM KIEM");
        System.out.println("2.THEM MOI");
        System.out.println("3.XEM DANH SACH KHACH HANG ");
        System.out.println("4.THOAT ");
        System.out.println("(1/2/3/4)");
        option=input.nextInt();
        DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();
            switch(option){
            case 1 -> {
                A.timKiem();
            }
            case 2 -> {
                A.themKH();
            }
            case 3 -> {
                A.xuatDSKH();
                }
            case 4 -> {
                TTOAN D= new TTOAN();
                D.main();
            }
            default -> { 
                System.out.println("========END========");
                }
                
            }
        }while (option<5);
            
        }
            
        }
        


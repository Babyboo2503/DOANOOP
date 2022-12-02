package KH;
import java.util.Scanner;
public class KHACHTHANHVIEN {
    Scanner input=new Scanner(System.in);
    public void main(){
        int option;
        do {            
        System.out.println("=====BANG CHON=====");
        System.out.println("1.TIM KIEM");
        System.out.println("2.XEM DANH SACH KHACH HANG ");
        System.out.println("3.THOAT ");
        System.out.println("(1/2/3/4)");
        option=input.nextInt();
            switch(option){
            case 1 -> {
                DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();
                A.timKiem();
            }
            case 2 -> {
                DANHSACHKHACHHANG C= new DANHSACHKHACHHANG();
                C.xuatDSKH();
                }
            case 3 -> {
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
        


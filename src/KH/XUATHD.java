package KH;

import DH.DANHSACHHOADON;
import KH_ADMIN.DANHSACHKHACHHANG_AD;
import java.util.Scanner;
public class XUATHD {
    Scanner input=new Scanner(System.in);
    public void main(){
        int option;
        do {            
            System.out.println("=====BANG CHON=====");
            System.out.println("1.IN");
            System.out.println("2.KHACH THANH VIEN");
            System.out.println("3.THOAT");
            option=input.nextInt();
            switch(option){
            case 1 -> {
                DANHSACHHOADON B= new DANHSACHHOADON();
                B.themHD();
            }
            case 2 -> {
                DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();
                A.timKiem_xuatHD();
            }
            case 3 -> {
                TTOAN A=new TTOAN();               
                A.main();
            }
            }
        }while (option<4&&option>0);
            
        }
}

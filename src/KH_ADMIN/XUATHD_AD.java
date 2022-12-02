package KH_ADMIN;
import DH.HOADON;
import DH_ADMIN.DANHSACHHOADON_AD;
import java.util.Scanner;
public class XUATHD_AD {
    Scanner input=new Scanner(System.in);
    public void main(){
        int option;
        do {            
            System.out.println("=====BANG CHON=====");
            System.out.println("1.IN");
            System.out.println("2.THOAT");
            option=input.nextInt();
            switch(option){
            case 1 -> {
                DANHSACHHOADON_AD B= new DANHSACHHOADON_AD();
                B.themHD();
                
            }
            case 2 -> {
                TTOAN_AD A=new TTOAN_AD();               
                A.main();
            }
            }
        }while (option<3&&option>0);
            
        }
    }

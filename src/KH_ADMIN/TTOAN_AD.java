package KH_ADMIN;
//ADMIN
import DH_ADMIN.QLHD_AD;
import java.util.Scanner;
public class TTOAN_AD {
    public void main(){
        Scanner input=new Scanner(System.in);
        int option;
        do {
        System.out.println("=====BANG CHON=====");
        System.out.println("1.IN HOA DON");
        System.out.println("2.DANH SACH KHACH THANH VIEN ");
        System.out.println("3.DANH SACH HOA DON ");       
        System.out.println("4.THOAT ");
        System.out.println("(1/2/3/4)");
        option=input.nextInt();            
            switch(option){
            case 1 -> {
                XUATHD_AD A= new XUATHD_AD();
                A.main();
            }
            case 2 ->{                 
                KHACHTHANHVIEN_AD B= new KHACHTHANHVIEN_AD();
                B.main();
            }
            case 3 -> {
                QLHD_AD C=new QLHD_AD();
                C.main();
            }
            case 4 -> { 
                System.out.println("========END========");
                }
            }       
        } while (option<4&&option>0);        
    }
}

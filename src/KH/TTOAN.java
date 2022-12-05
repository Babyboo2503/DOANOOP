package KH;
import DH.QLHD;
import KH_ADMIN.XUATHD_AD;
import java.util.Scanner;
//USER
public class TTOAN {
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
                XUATHD A= new XUATHD();
                A.main();
            }
            case 2 ->{                 
                KHACHTHANHVIEN B= new KHACHTHANHVIEN();
                B.main();
            }
            case 3 -> {
                QLHD C=new QLHD();
                C.main();
            }
            case 4 -> { 
                System.out.println("========END========");
                }
            }       
        } while (option<4&&option>0);        
    }
}

package KH;
import java.util.Scanner;
public class HINHTHUCMUAHANG {
    public void main(){
        Scanner input=new Scanner(System.in);
        int option;
        do {
        System.out.println("=====BANG CHON=====");
        System.out.println("1.THANH TOAN");
        System.out.println("2.KHACH HANG ");
        System.out.println("3.THOAT ");
        System.out.println("(1/2/3)");
        option=input.nextInt();            
            switch(option){
            case 1 -> {
                //
            }
            case 2 ->{                 
                KHACHHANG A= new KHACHHANG();
                A.main();
            }
        }        
        } while (option<3);        
    }
}

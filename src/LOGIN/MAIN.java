
package LOGIN;

import KH.MAIN_USER;
import KH_ADMIN.MAIN_AD;
import Nhanviensiucap.MAIN_NV;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
                LOGIN_OUT A=new LOGIN_OUT();
        A.main();
    }
//    private static String id;
//    public static void main(String[] args) {
//        Scanner input=new Scanner(System.in);
//        int option=0;
//        do{
//            System.out.println("=====MENU=====");
//            System.out.println("1.DANG NHAP");
//            System.out.println("2.DANG XUAT");
//            option=input.nextInt();
//            switch (option) {
//                case 1:{
//                    DANGNHAP d = new DANGNHAP();
//             do {            
//            d.nhap();
//            if (d.getOk()==1) {
//                QUANLYCUAHANG A= new QUANLYCUAHANG();
//                A.main();
//            }
//            else if(d.getOk()==2){
//            id=d.getIdlv();
//            System.out.println("ID DANG LAM VIEC : "+id);
//            MAIN_USER USER=new MAIN_USER();
//            USER.main();
//        }
//        } while (d.getOk()==0);
//                    break;
//            }
//                
//                default:
//                    System.out.println("=========END=========");
//            }
//        }while(option==1);
//    }

}

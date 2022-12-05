package LOGIN;

import KH_ADMIN.MAIN_AD;
import Nhanviensiucap.MAIN_NV;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class QUANLYCUAHANG {
    public void main(){
        Scanner input=new Scanner(System.in);
    int option_AD=0;
            System.out.println("1.QUAN LY NHAN SU");
            System.out.println("2.QUAN LY TAI QUAY");
            System.out.println("3.QUAN LY KHO HANG");
            System.out.println("4.QUAN LY THU,CHI");
                System.out.println("5.THOAT");
                System.out.println("(1/2/3/4/5)");
                option_AD=input.nextInt();
                switch (option_AD) {
                    case 1:{
                        MAIN_NV NV =new MAIN_NV();
                        NV.main();
                        break;}
                    case 2:{
                        MAIN_AD AD=new MAIN_AD();
                        AD.main();
                        break;}
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        LOGIN_OUT LOG=new LOGIN_OUT();
                        LOG.main();
                        break;
                    default:
                        throw new AssertionError();
                }
    }

}

package DH_ADMIN;

import KH_ADMIN.TTOAN_AD;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class QLHD_AD {
    Scanner input=new Scanner(System.in);
    public void main() {
        int option=0;
        do{
        System.out.println("======BANG CHON======");
        System.out.println("1.TIM KIEM ");
        System.out.println("2.DANH SACH HOA DON"); /*CHON 1 HOA DON: SUA, XOA, IN */
        System.out.println("3.THOAT");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        switch(option){
            case 1:{
                    DANHSACHHOADON_AD A=new DANHSACHHOADON_AD();
                    A.timKiem_HD();
                    break;
            }
            case 2:{
                DANHSACHHOADON_AD C=new DANHSACHHOADON_AD();
                C.xuatDSHD();
                break;
            }
            case 3:{
                TTOAN_AD A=new TTOAN_AD();
                A.main();
            }
        }}while(option<4 && option >0);

        }
        
        
    }

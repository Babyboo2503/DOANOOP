package DH_ADMIN;

import java.util.Scanner;

/**
 *
 * @author compu
 */
public class QLHD_AD {
    Scanner input=new Scanner(System.in);
    public void main() {
        System.out.println("======BANG CHON======");
        System.out.println("1.TIM KIEM HOA DON");
        System.out.println("2.THEM HOA DON");   /*Thêm và xuất HD */
        System.out.println("3.DANH SACH HOA DON"); /*CHON 1 HOA DON: SUA, XOA, IN */
        System.out.println("4.THOAT");
        System.out.println("(1/2/3/4)");
        int option;
        option=input.nextInt();
        switch(option){
            case 1:{
                    DANHSACHHOADON_AD A=new DANHSACHHOADON_AD();
                    A.timKiem();
                    QLHD_AD B=new QLHD_AD();
                    B.main();
            }
            case 2:{
                    DANHSACHHOADON_AD B=new DANHSACHHOADON_AD();
                    B.themHD();
            }
            case 3:{
                DANHSACHHOADON_AD C=new DANHSACHHOADON_AD();
                C.xuatDSHD();
            }
            case 4:{
                
            }

        }
    }
}

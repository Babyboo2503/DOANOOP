package DH;
import KH.TTOAN;
import java.util.Scanner;
public class QLHD {
    public void main() {
        Scanner input=new Scanner(System.in);
        int option=0;
        do{
        System.out.println("======BANG CHON======");
        System.out.println("1.TIM KIEM ");
        System.out.println("2.DANH SACH HOA DON"); /*CHON 1 HOA DON: SUA, XOA, IN */
        System.out.println("3.THOAT");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        DANHSACHHOADON A=new DANHSACHHOADON();
        switch(option){
            case 1 -> {
                A.timKiem_HD();
            }
            case 2 -> {
                A.xuatDSHD();
            }
            case 3 -> {
                TTOAN B=new TTOAN();
                B.main();
            }
        }}while(option<4 && option >0);

        }
    
}

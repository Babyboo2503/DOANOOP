package DH;

import KH_ADMIN.XUATHD_AD;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class CHITIETHD {
    public static ArrayList<SP> arraySP=new ArrayList<>();
    public void main(){
        Scanner input=new Scanner(System.in);
        int option=0;
        do{
        System.out.println("======BANG CHON======");
        System.out.println("1.Them ");
        System.out.println("2.In");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        switch(option){
            case 1:{
                SP A=new SP();
                A.themSP();
                break;
            }

        }
        }while(option<2&&option>0);
        }

}

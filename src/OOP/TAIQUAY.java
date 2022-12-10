package OOP;

import static OOP.IO.input;

/**
 *
 * @author compu
 */
public class TAIQUAY {

    public static void main(){
        DANHSACHHOADON HD=new DANHSACHHOADON();        
        int option;
        System.out.println("=====MENU=====");
        System.out.println("1. IN HD");
        System.out.println("2. KTV");
        System.out.println("3. Thoat");
        System.out.println("(1/2/3)");  
        option=input.nextInt();
        switch (option) {
            case 1 -> HD.InHD();
            case 2 -> {
                System.out.println("Nhap SDT");
                String SDT=input.nextLine();
                HD.InHD_KTV(SDT);
            }
            default -> throw new AssertionError();
        }        
    }
}

package OOP;

import static OOP.IO.input;

/**
 *
 * @author compu
 */
public class TAIQUAY {

    public static void main(int id) throws InterruptedException{
        DANHSACHHOADON HD=new DANHSACHHOADON(); 
        DANHSACHKHACHHANG KH=new DANHSACHKHACHHANG();
        int option;
        outer:
        while(true){
        System.out.println("=====MENU=====");
        System.out.println("1. IN HD");
        System.out.println("2. KTV");
        System.out.println("3. Thoat");
        System.out.println("(1/2/3)");  
        option=input.nextInt();
        switch (option) {
            case 1 -> HD.InHD(id);
            case 2 -> {
                HD.InHD_KTV(id);
            }
            case 3 -> {
                break outer;
                }
            default -> {System.out.println("Khong hop le");
            }
        }        
    }
    }
    public static void main() throws InterruptedException{
        DANHSACHHOADON HD=new DANHSACHHOADON(); 
        DANHSACHKHACHHANG KH=new DANHSACHKHACHHANG();
        int option;
        outer:
        while(true){
        System.out.println("=====MENU=====");
        System.out.println("1. IN HD");
        System.out.println("2. KTV");
        System.out.println("3. Thoat");
        System.out.println("(1/2/3)");  
        option=input.nextInt();
        switch (option) {
            case 1 -> HD.InHD();
            case 2 -> {
                HD.InHD_KTV();
            }
            case 3 -> {
                break outer;
                }
            default -> {System.out.println("Khong hop le");
            break;
            }
    }
    }
    }
}

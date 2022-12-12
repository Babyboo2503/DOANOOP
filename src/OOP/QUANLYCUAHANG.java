package OOP;

import static OOP.IO.input;

/**
 *
 * @author compu
 */
public class QUANLYCUAHANG {
    public static void ADMIN() throws InterruptedException{
        do{
        int option;
        System.out.println("=====MENU=====ADMIN=====");
        System.out.println("1. IN HOA DON TAI QUAY");
        System.out.println("2. QUAN LY NHAN SU");
        System.out.println("3. QUAN LY HANG HOA");
        System.out.println("4. QUAN LY KHACH HANG");
        System.out.println("5. QUAN LY HOA DON");
        System.out.println("6. THU CHI");
        System.out.println("7. THOAT");
        System.out.println("(1/2/3/4/5/6)");
        option=input.nextInt();
        switch (option) {
            case 1:
                TAIQUAY.main();
                break;
            case 2:
                MainNV.main();
                break;
            case 3:
                MAINhh.main();
                break;
            case 4:
                MAINKH.main();
                break;
            case 5:
                MAINHD.main();
                break;
            case 6:
                loinhuan.main();
                break;
            default:
                MAIN.main();
        }      
        }while(true);
    }
    public static void USER(int id) throws InterruptedException{
        do{
        System.out.println("=====MENU=====USER=====");
        System.out.println("1. IN HOA DON TAI QUAY");
        System.out.println("2. HANG HOA");
        System.out.println("3. KHACH HANG");
        System.out.println("4. HOA DON");
            System.out.println("5. THOAT");
        System.out.println("(1/2/3/4)");   
        int option;
        option=input.nextInt();
        switch (option) {
            case 1:
                TAIQUAY.main(id);
                break;
            case 2:
                MAINhh.main();
                break;
            case 3:
                MAINKH.main();
                break;
            case 4:
                MAINHD.main();
                break;
            default:
                MAIN.main();
        }     
    }while(true); 
    }
    }

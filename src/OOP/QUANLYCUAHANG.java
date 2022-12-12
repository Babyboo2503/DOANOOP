package OOP;

import static OOP.IO.input;

/**
 *
 * @author compu
 */
public class QUANLYCUAHANG {
    public static void ADMIN() throws InterruptedException{
        System.out.println("=====MENU=====ADMIN=====");
        System.out.println("1. IN HÓA ĐƠN TẠI QUẦY");
        System.out.println("2. QUẢN LÍ NHÂN SỰ");
        System.out.println("3. QUẢN LÍ HÀNG HÓA");
        System.out.println("4. QUẢN LÍ KHÁCH HÀNG");
        System.out.println("5. QUẢN LÍ HÓA ĐƠN");
        System.out.println("6. THU CHI");
        int option;
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
            case 6:
                loinhuan.main();
            default:
                System.out.println("=========END=========");
        }        
    }
    public static void USER() throws InterruptedException{
        System.out.println("=====MENU=====USER=====");
        System.out.println("1. IN HÓA ĐƠN TẠI QUẦY");
        System.out.println("2. HÀNG HÓA");
        System.out.println("3. KHÁCH HÀNG");
        System.out.println("4. HÓA ĐƠN");
        int option;
        System.out.println("(1/2/3/4)");
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
            case 6:
                loinhuan.main();
            default:
                throw new AssertionError();
        }        
    }        
    }

package Nhanviensiucap;

import LOGIN.QUANLYCUAHANG;
import java.util.Scanner;

/**
 * MAIN_NV class
 *
 * @author Nhanviensiucap
 */
public class MAIN_NV {
    public static Scanner scanner = new Scanner(System.in);

    public static void main() {

        int choose=0;
//        boolean exit = false;
        Chinhsuadanhsach chinhsuadanhsach = new Chinhsuadanhsach();
        int nhanvienId;
//        // show menu

        showMenu();
                    choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            chinhsuadanhsach.add();
                            MAIN_NV.main();
                            break;
                        case 2:
                            nhanvienId = chinhsuadanhsach.inputId();
                            chinhsuadanhsach.edit(nhanvienId);
                            MAIN_NV.main();
                            break;
                        case 3:
                            nhanvienId = chinhsuadanhsach.inputId();
                            chinhsuadanhsach.delete(nhanvienId);
                            MAIN_NV.main();
                            break;
                        case 4:{
                            chinhsuadanhsach.show();
                            MAIN_NV.main();
                            break;
                        }
                        case 5:
                            System.out.println(chinhsuadanhsach.findNhanVien());
                            MAIN_NV.main();
                            break;
                        case 6:
                            QUANLYCUAHANG A=new QUANLYCUAHANG();
                            A.main();
                            break;
                        default:
                            System.out.println("invalid! please choose action in below menu:");
                            break;
                    }
    }
    public static void showMenu() {
        System.out.println("+-----------menu------------+");
        System.out.println("|1. Add nhanvien.           |");
        System.out.println("|2. Edit nhanvien by id.    |");
        System.out.println("|3. Delete nhanvien by id.  |");
        System.out.println("|4. Show nhanvien.          |");
        System.out.println("|5. Find nhanvien by name.  |");
        System.out.println("|6. Return                  |");
        System.out.println("+---------------------------+");
        System.out.print("Please choose: ");
    }

    public static void showMenus() {
        System.out.println("+-----------menu------------+");
        System.out.println("|1. Show nhanvien.          |");
        System.out.println("|2. Find nhanvien by name.  |");
        System.out.println("+---------------------------+");
        System.out.print("Please choose: ");
    }
}

package Nhanviensiucap;

import java.util.List;
import java.util.Scanner;

/**
 * Main class
 *
 * @author Nhanviensiucap
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String choose = null;
        boolean exit = false;
        Chinhsuadanhsach chinhsuadanhsach = new Chinhsuadanhsach();
        int nhanvienId;
        //show menu

        DANGNHAP d = new DANGNHAP();

        d.nhap();
        while (d.getOk() != 3) {
            switch (d.getOk()) {
                case 1:
                    // show menu
                    showMenu();
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            chinhsuadanhsach.add();
                            break;
                        case "2":
                            nhanvienId = chinhsuadanhsach.inputId();
                            chinhsuadanhsach.edit(nhanvienId);
                            break;
                        case "3":
                            nhanvienId = chinhsuadanhsach.inputId();
                            chinhsuadanhsach.delete(nhanvienId);
                            break;
                        case "4":
                            chinhsuadanhsach.show();
                            break;
                        case "5":
                            System.out.println(chinhsuadanhsach.findNhanVien());
                            break;
                        case "0":
                            System.out.println("LOGOUT!");
                            d.nhap();
                            break;
                        default:
                            System.out.println("invalid! please choose action in below menu:");
                            break;
                    }
                    break;
                case 2:
                    // show menu
                    showMenus();
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            chinhsuadanhsach.show();
                            break;
                        case "2":
                            System.out.println(chinhsuadanhsach.findNhanVien());
                            break;
                        case "0":
                            System.out.println("LOGOUT!");
                            d.nhap();
                            break;
                        default:
                            System.out.println("invalid! please choose action in below menu:");
                            break;
                    }
                    break;
                case 0:
                    d.nhap();
                    break;
            }
        }
}
    

    /**
     * create menu
     */
    public static void showMenu() {
        System.out.println("+-----------menu------------+");
        System.out.println("|1. Add nhanvien.           |");
        System.out.println("|2. Edit nhanvien by id.    |");
        System.out.println("|3. Delete nhanvien by id.  |");
        System.out.println("|4. Show nhanvien.          |");
        System.out.println("|5. Find nhanvien by name.  |");
        System.out.println("|0. logout.                 |");
        System.out.println("+---------------------------+");
        System.out.print("Please choose: ");
    }

    public static void showMenus() {
        System.out.println("+-----------menu------------+");
        System.out.println("|1. Show nhanvien.          |");
        System.out.println("|2. Find nhanvien by name.  |");
        System.out.println("|0. logout.                 |");
        System.out.println("+---------------------------+");
        System.out.print("Please choose: ");
    }
}
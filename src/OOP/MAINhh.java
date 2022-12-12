 package OOP;

import java.util.Scanner;

public class MAINhh {

    public static void main(){
        Scanner in = new Scanner(System.in);
        DSPN dspn = new DSPN();
        DSNCC dsncc = new DSNCC();
        KHO kho = new KHO();

        dspn.docFile();
        kho.docFile();
        dsncc.docFile();
        outer:
        while(true){
            System.out.println("========================================Menu ve hang hoa========================================");
            System.out.println("1/Phieu nhap.");
            System.out.println("2/Kho.");
            System.out.println("2/Cac nha cung cap.");
            System.out.println("0/Quay lai.");
            byte k = in.nextByte();
            switch(k){
                case 1: dspn.menuPn(kho,dsncc);
                    break;
                case 2: kho.menuKho();
                    break;
                case 3: dsncc.menuNcc();
                    break;
                case 0:
                    break outer;
                default:    System.out.println("Lenh khong hop le!");
                    break;
            }
        }
        /*
        String date = "05/12/2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate day = LocalDate.parse(date,formatter);
        System.out.println(day.compareTo(today));
        System.out.println(LocalDate.parse(today.toString(), formatter));
        */
        
    }
    void showMenu(){
        System.out.println("dasdas");
    }
}
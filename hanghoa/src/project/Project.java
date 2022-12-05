 package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DSPN a = new DSPN();
        KHO kho = new KHO();

        a.docFile();
        kho.docFile();
        outer:
        while(true){
            System.out.println("========================================Menu ve hang hoa========================================");
            System.out.println("1/Phieu nhap.");
            System.out.println("2/Kho.");
            System.out.println("0/Quay lai.");
            int k = in.nextInt();
            switch(k){
                case 1: a.menuPn(kho);
                break;
                case 2: kho.menuKho();
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
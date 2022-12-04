package project;

import java.util.Scanner;

public class Project {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        DSPN a = new DSPN();
        a.docFile();
        
        outer:
        while(true){
            System.out.println("========================================Menu========================================");
            System.out.println("1/Xem phieu nhap, hang hoa.");
            System.out.println("2/Tim kiem phieu, hang hoa.");
            System.out.println("3/Them phieu.");
            System.out.println("4/Xoa phieu.");
            System.out.println("0/Thoat.");
            System.out.print(" : ");
            int n = in.nextInt();
            switch(n){
                case 1: a.menuXem();
                    break;
                case 2: a.menuTimKiem();
                    break;
                case 3: a.menuThem();
                    break;
                case 4: a.menuXoa();
                    break;
                case 0:
                    break outer;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
        
    }
    void showMenu(){
        System.out.println("dasdas");
    }
}
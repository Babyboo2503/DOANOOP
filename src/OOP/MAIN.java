package OOP;

import java.util.Scanner;

public class MAIN {
    private static int id;
    public static void main() throws InterruptedException {
        Scanner input=new Scanner(System.in);
        int option;    
        do{
        System.out.println("=====MENU=====");
        System.out.println("1.DANG NHAP");
        System.out.println("2.DANG XUAT");
        option=input.nextInt();
        switch (option) {
            case 1:{
                DANGNHAP d = new DANGNHAP();
                do {            
                d.nhap();
                if (d.getOk()==1) {
                    QUANLYCUAHANG.ADMIN();
            }
            else if(d.getOk()==2){
                id=d.getIdlv();
                System.out.println("ID DANG LAM VIEC : "+id);
                    QUANLYCUAHANG.USER(id);
        }
        } while (d.getOk()==0);
                    break;
            }
                default:
                    System.out.println("=========END=========");
            }
        while(option==1);
        }while(option==1);
    }
    public static void main(String[] args) throws InterruptedException {
        main();
    }
}


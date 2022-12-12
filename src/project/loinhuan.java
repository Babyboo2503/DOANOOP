package project;

import java.util.Scanner;

public class loinhuan {
    private long loinhuan_n;
    private long loinhuan_t;
    Scanner sc=new Scanner(System.in);
    Checking check = new Checking();
    loinhuan(){
        loinhuan_n=0;
        loinhuan_t=0;
    }

    public long getloinhuan_n(){
        return loinhuan_n;
    }


    public long getloinhuan_t(){
        return loinhuan_t;
    }

    public void doanhthungay(){
        if(sc.hasNextLine())
            sc.nextLine();
        chi chi_n=new chi();
        thu thu_n=new thu();
        loinhuan loi=new loinhuan();

        System.out.print("Nhap ngay (dd/MM/yyyy): "); 
        String ngay=sc.nextLine();
        while(true){
            if(check.checkNull(ngay)){
                System.out.print("Vui long nhap thang (dd//MM/yyyy): ");
                ngay = sc.nextLine();
            }
            else if(!check.checkDateFormat(ngay)){
                System.out.print("Vui long nhap ngay (dd/MM/yyyy): ");
                ngay = sc.nextLine();
            }
            else
                break;
        }
        
        chi_n.setnhaphang_n(ngay);
        chi_n.setchi_n();
        thu_n.setbanhang_n(ngay);
        System.out.println("\nTong chi ngay "+ngay+": "+chi_n.getchi_n());
        System.out.println("Tong thu ngay "+ngay+": "+thu_n.getbanhang_n());
        loi.loinhuan_n=thu_n.getbanhang_n()-chi_n.getchi_n();
        System.out.println("Doanh thu: "+loi.getloinhuan_n()+"\n");

    }

    public void doanhthuthang(){
        if(sc.hasNextLine())
            sc.nextLine();
        chi chi_t = new chi();
        thu thu_t = new thu();
        loinhuan loi=new loinhuan();
        System.out.print("Nhap thang (MM/yyyy): ");
        String thang=sc.nextLine();
        while(true){
            if(check.checkNull(thang)){
                System.out.print("Vui long nhap thang (MM/yyyy): ");
                thang = sc.nextLine();
            }
            else if(!check.checkMonthYear(thang)){
                System.out.print("Vui long nhap thang (MM/yyyy): ");
                thang = sc.nextLine();
            }
            else
                break;
        }
        //nhập chi
        chi_t.setnhaphang_t(thang);
        chi_t.setdiennuocwifi(thang);
        chi_t.setchi_t();
        System.out.println("\nTien dien thang nay: "+chi_t.getdien());
        System.out.println("Tien nuoc thang nay: "+chi_t.getnuoc());
        System.out.println("Tien wifi thang nay: "+chi_t.getwifi());
        //nhập thu
        thu_t.setbanhang_t(thang);

        System.out.println("\nTong chi thang "+thang+": "+chi_t.getchi_t());
        System.out.println("Tong thu thang "+thang+": "+thu_t.getbanhang_t());
        
        loi.loinhuan_t = thu_t.getbanhang_t() - chi_t.getchi_t();
        System.out.println("Doanh thu: " + loi.getloinhuan_t()+"\n");

    }

    
    public void menu() {
        OUTER:
        while(true) {
            System.out.println("\n========================================DOANH THU========================================\n");
            System.out.println("Xuat doanh thu theo: \n1.Ngay \n2.Thang \n0.Thoat");
            System.out.print("Nhap lua chon: ");
            byte k = sc.nextByte();
            switch (k) {
                case 1:
                    doanhthungay();
                    break;
                case 2:
                    doanhthuthang();
                    break;
                case 0:
                    break OUTER;
                default:    System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
}
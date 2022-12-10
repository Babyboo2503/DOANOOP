import java.util.Scanner;

public class loinhuan {
    private float loinhuan_n;
    private float loinhuan_t;
    
    loinhuan(){
        loinhuan_n=0;
        loinhuan_t=0;
    }

    public float getloinhuan_n(){
        return loinhuan_n;
    }


    public float getloinhuan_t(){
        return loinhuan_t;
    }


    public void Nhap(){
        Scanner sc=new Scanner(System.in);

        int luachon1;
        do{
            System.out.println("\n<---------------------DOANH THU--------------------->\n");
            System.out.println("Xuat doanh thu theo: \n1.Ngay \n2.Thang \n0.Thoat");
            System.out.print("Nhap lua chon: ");
            luachon1 = Integer.valueOf(sc.nextLine());
            if (luachon1==1){
                doanhthungay();
            }
            else if (luachon1==2){
                doanhthuthang();
            }
            else if (luachon1==0) break;
        } while(luachon1<1 || 3<luachon1);
 
        sc.close();
    }


    public void doanhthungay(){
        Scanner sc=new Scanner(System.in);
        chi chi_n=new chi();
        thu thu_n=new thu();
        loinhuan loi=new loinhuan();

        System.out.print("Nhap ngay (dd/mm/yyyy): "); 
        String ngay=sc.nextLine();
        chi_n.setnhaphang_n(ngay);
        chi_n.setchi_n();
        thu_n.setbanhang_n(ngay);
        System.out.println("\nTong chi ngay "+ngay+": "+chi_n.getchi_n());
        System.out.println("Tong thu ngay "+ngay+": "+thu_n.getbanhang_n());
        loi.loinhuan_n=thu_n.getbanhang_n()-chi_n.getchi_n();
        System.out.println("Doanh thu: "+loi.getloinhuan_n()+"\n");

        sc.close();
    }

    public void doanhthuthang(){
        Scanner sc=new Scanner(System.in);
        chi chi_t = new chi();
        thu thu_t = new thu();
        loinhuan loi=new loinhuan();

        System.out.print("Nhap thang (mm/yyyy): ");
        String thang=sc.nextLine();
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
        loi.loinhuan_t=thu_t.getbanhang_t()-chi_t.getchi_t();
        System.out.println("Doanh thu: "+loi.getloinhuan_t()+"\n");

        sc.close();
    }

    
    public static void main(String[] args) throws InterruptedException {
        loinhuan LN = new loinhuan();
        LN.Nhap();
    }
}

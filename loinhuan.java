import java.util.Scanner;

public class loinhuan {
    private float loi;
    
    loinhuan(){
        loi=0;
    }

    public void Nhap(){

    }
    public static void main(String[] args) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        System.out.println("<---------------------DOANH THU--------------------->");
        System.out.println("Xuat doanh thu theo: \n1.Day \n2.Month \n3.Exit");
        // int luachon1=sc.nextInt();
        int luachon1 = Integer.valueOf(sc.nextLine());
        if(luachon1==1){
            chi chi=new chi();
            thu thu=new thu();
            // Arrays loinhuanngay[chi,thu];

            System.out.print("Nhap ngay (dd/mm/yy): "); 
            String ngay=sc.nextLine();
            chi.setnhaphang_n(ngay);
            Thread.sleep(500);
            System.out.println("Tong chi ngay "+ngay+": "+chi.getnhaphang_n());
        }
        sc.close();
    }
}

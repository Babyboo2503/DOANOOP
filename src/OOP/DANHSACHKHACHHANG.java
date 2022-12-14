package OOP;
import java.util.ArrayList;
import java.util.Scanner;
public  class DANHSACHKHACHHANG extends IOfile{
    int option=0;
    ArrayList<KHACHHANG> arrayKH=new ArrayList<>();
    static Scanner input=new Scanner(System.in);
//    HÀM KIỂM TRA VÀ TÌM KIẾM KHÁCH HÀNG
    public int ktraKH(String SDT){
        arrayKH.clear();
        f.readFromFile_KH(arrayKH); 
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0)
                    return 1;
            }
        return 0;
    }

    public void themKH(){       
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT;
        do{
            SDT= input.nextLine();
        }while (Checking.checkPhoneNum(SDT));            

        if(ktraKH(SDT)==0){
            KHACHHANG a= new KHACHHANG();
            a.NHAP_TEN();
            a.setSDT(SDT);
            arrayKH.add(a);
            f.writeToFile_KH(arrayKH);
            System.out.println("Them thanh cong!"); 
        }
        else{
        System.out.println("SDT da ton tai");
        }
    }
//LOI ARRAYKH DANG BI TRONG, KHONG CO PHAN TU
    public void xuatDSKH(){
        arrayKH.clear();
        f.readFromFile_KH(arrayKH);
        for(int i=0;i<arrayKH.size();i++){
            System.out.println(arrayKH.get(i).toString());
        }
    }
//TÌM KIẾM KHÁCH H, NEU TIM THAY CO QUYEN SUA,XOA
    public void timKiem_admin() throws InterruptedException{
        arrayKH.clear();
        f.readFromFile_KH(arrayKH);
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                System.out.println(arrayKH.get(i).toString());
                System.out.println("=====MENU=====");
                System.out.println("1.Sua");
                System.out.println("2.Xoa");
                System.out.println("3.Lich su mua hang");
                System.out.println("4.Thoat");
                System.out.println("(1/2/3/4)");
                option=input.nextInt();
                switch(option){
                    case 1 -> suaKH(i);
                    case 2 -> xoaKH(SDT);
                    case 3 -> {
                        DANHSACHHOADON A=new DANHSACHHOADON();
                        A.timKiem_HD(SDT);
                    }
                    case 4 -> {
                        QUANLYCUAHANG.ADMIN();
                    }
                        
                }
            }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        
        }
    }    
    public void timKiem_user(){
        arrayKH.clear();
        f.readFromFile_KH(arrayKH);
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                System.out.println(arrayKH.get(i).toString());
                System.out.println("=====MENU=====");
                System.out.println("1.Lich su mua hang");
                System.out.println("2.Thoat");
                System.out.println("(1/2)");
                option=input.nextInt();
                switch(option){

                    case 1 -> {
                        DANHSACHHOADON A=new DANHSACHHOADON();
                        A.timKiem_HD(SDT);
                    }
                    case 2 -> {
                    }           
                }                
            }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        
        }
    }    

    public void xoaKH(String SDT){
        arrayKH.clear();
        FILE f2=new FILE();
        f.readFromFile_KH(arrayKH);
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                arrayKH.remove(arrayKH.get(i));
                f2.writeToFile_KH(arrayKH);
                System.out.println("Da xoa");
                break;
            }
//            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0){
//                System.out.println("");
//            }
        }
    }
    public void suaKH(int i){
        System.out.println("=====BANGCHON=====");
        System.out.println("1.SDT");
        System.out.println("2.Ten");
        System.out.println("3.Thoat");
        System.out.println("(1/2/3)");
        option=input.nextInt();
        switch (option) {
            case 1 -> {
                System.out.print("Nhap SDT moi:");
                input=new Scanner(System.in);
                String SDT_tmp=input.nextLine();
//                arrayKH.clear();
                arrayKH.get(i).setSDT(SDT_tmp);
                f.writeToFile_KH(arrayKH);
            }
            case 2 -> {
//                KHI XOA THI XOA HET MANG, NHUNG SET CHI SET 1 GIA TRI, LOI CT
                System.out.print("Nhap ten moi:");
                input=new Scanner(System.in);
                String ten_tmp=input.nextLine();               
                arrayKH.get(i).setTen(ten_tmp);
                f.writeToFile_KH(arrayKH);}
        }
        }    
    public void menu_KH_admin() throws InterruptedException{
        do{
        System.out.println("=====MENU=====");
        System.out.println("1.Tim kiem");
        System.out.println("2.Them KH");
        System.out.println("3.Xem DSKH");
        System.out.println("4.Thoat");
        System.out.println("(1/2/3/4)");
        option=input.nextInt();
        switch (option) {
            case 1:
                timKiem_admin();
                break;
            case 2:
                themKH();
                break;
            case 3:
                xuatDSKH();
                break;
            case 4:
                QUANLYCUAHANG.ADMIN();
                break;
        }
        }while (option>0&&option<5);            
    }

    public void menu_KH_user() throws InterruptedException{
        do{
        System.out.println("=====MENU=====");
        System.out.println("1.Tim kiem");
        System.out.println("2.Them KH");
        System.out.println("3.Xem DSKH");
        System.out.println("4.Thoat");
        System.out.println("(1/2/3/4)");
        option=input.nextInt();
        switch (option) {
            case 1:
                timKiem_user();
                break;
            case 2:
                themKH();
                break;
            case 3:
                xuatDSKH();
                break;
            case 4:
                break;
            default:
                throw new AssertionError();
        }
        }while (option>0&&option<5);            
    }
    public void main() throws InterruptedException{
        menu_KH_admin();
        menu_KH_user();
    }
    
}

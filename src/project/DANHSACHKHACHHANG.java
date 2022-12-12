package project;
import java.util.ArrayList;
import java.util.Scanner;

public  class DANHSACHKHACHHANG extends IOfile{
    private int option=0;
    private ArrayList<KHACHHANG> arrayKH=new ArrayList<>();
    static Scanner input=new Scanner(System.in);

    DANHSACHKHACHHANG() {
    }
    DANHSACHKHACHHANG(ArrayList<KHACHHANG> arrayKH, int option){
        this.arrayKH = arrayKH;
        this.option = option;
    }
    
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
        String SDT= input.nextLine();
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
    public void timKiem_admin(DANHSACHHOADON dshd){
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
                    case 1 :suaKH(i);
                    case 2 :xoaKH(SDT);
                    case 3 :{
                        dshd.timKiem_HD(SDT);
                    }
                    case 4 :
                        return;
                }
            }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        
        }
    }    
    public void timKiem_user(DANHSACHHOADON dshd){
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
                    case 1 :{
                        dshd.timKiem_HD(SDT);
                    }
                    case 2 :
                        return;
                }                
            }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        
        }
    }    

    public void xoaKH(String SDT){
        FILE f2=new FILE();
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
        suaKH:
        while(true){
            System.out.println("=====BANGCHON=====");
            System.out.println("1.SDT");
            System.out.println("2.Ten");
            System.out.println("3.Thoat");
            System.out.println("(1/2/3)");
            option=input.nextInt();
            switch (option) {
                case 1 :{
                    System.out.print("Nhap SDT moi:");
                    input=new Scanner(System.in);
                    String SDT_tmp=input.nextLine();
    //                arrayKH.clear();
                    arrayKH.get(i).setSDT(SDT_tmp);
                    f.writeToFile_KH(arrayKH);
                }   break;
                case 2 :{
    //                KHI XOA THI XOA HET MANG, NHUNG SET CHI SET 1 GIA TRI, LOI CT
                    System.out.print("Nhap ten moi:");
                    input=new Scanner(System.in);
                    String ten_tmp=input.nextLine();               
                    arrayKH.get(i).setTen(ten_tmp);
                    f.writeToFile_KH(arrayKH);
                }   break;
                case 3:
                    break suaKH;
            }
        }
    }    
    public void menu_KH_admin(DANHSACHHOADON dshd){
        KHad:
        while(true){
            System.out.println("========================================Menu khach hang========================================");
            System.out.println("1.Tim kiem");
            System.out.println("2.Them KH");
            System.out.println("3.Xem DSKH");
            System.out.println("4.Quay lai");
            System.out.println("(1/2/3/4)");
            option=input.nextInt();
            switch (option) {
                case 1:
                    timKiem_admin(dshd);
                    break;
                case 2:
                    themKH();
                    break;
                case 3:
                    xuatDSKH();
                    break;
                case 4:
                    break KHad;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
    public void menu_KH_user(DANHSACHHOADON dshd){
        KHuser:
        while(true){
            System.out.println("========================================Menu khach hang========================================");
            System.out.println("1.Tim kiem");
            System.out.println("2.Them KH");
            System.out.println("3.Xem DSKH");
            System.out.println("4.Quay lai");
            System.out.println("(1/2/3/4)");
            option=input.nextInt();
            switch (option) {
                case 1:
                    timKiem_user(dshd);
                    break;
                case 2:
                    themKH();
                    break;
                case 3:
                    xuatDSKH();
                    break;
                case 4:
                    break KHuser;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
    public void main(int ok, DANHSACHHOADON dshd){
        if(ok == 1)
            menu_KH_admin(dshd);
        else if(ok == 2)
            menu_KH_user(dshd);
    }
}
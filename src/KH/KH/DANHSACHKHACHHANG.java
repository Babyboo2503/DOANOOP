package KH;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHKHACHHANG {
    static Scanner input=new Scanner(System.in);
    static ArrayList<KHACHHANG> arrayKH=new ArrayList<>();
//    HÀM KIỂM TRA VÀ TÌM KIẾM KHÁCH HÀNG
    public int ktraKH(String SDT){
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0)
                    return 1;
            }
        return 0;
    }
//    THEM MOI KHACH HANG
    public void themKH(){
        System.out.print("Nhap so dien thoai:");
        String SDT= input.nextLine();
        if(ktraKH(SDT)==0){
            KHACHHANG a= new KHACHHANG();
            a.NHAP_TEN();
            a.setSDT(SDT);
            arrayKH.add(a);
            System.out.println("Them thanh cong!"); 
        }
        else{
        System.out.println("SDT da ton tai");
        }
    }

    public void xuatDSKH(){
        for(int i=0;i<arrayKH.size();i++){
            System.out.println(arrayKH.get(i).XUAT());
        }
    }
//TÌM KIẾM KHÁCH H
    public void timKiem(){
        System.out.print("Nhap so dien thoai:");
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                System.out.println(arrayKH.get(i).XUAT());
                break;
            }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        }
    }
    public void xacNhanInHD(){
        int option;
        do {
        System.out.println("1.THANH TOAN");
        System.out.println("2.THOAT ");
        System.out.println("(1/2)");
        option=input.nextInt();            
            switch(option){
 
        }        
        } while (option<3);   
    }
}


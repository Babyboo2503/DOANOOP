package KH;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHKHACHHANG {
    static Scanner input=new Scanner(System.in);
    static ArrayList<THONGTINKHACHHANG> arrayKH=new ArrayList<>();
//    HÀM KIỂM TRA VÀ TÌM KIẾM KHÁCH HÀNG
    public int ktraKH(){
        System.out.print("Nhap so dien thoai:");
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0)
                    return 1;
            }
        return 0;
    }
//    THEM MOI KHACH HANG
    public void themKH(){
        THONGTINKHACHHANG a= new THONGTINKHACHHANG();
        a.NHAP();
        arrayKH.add(a);
        System.out.println("Them thanh cong!");        
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
}


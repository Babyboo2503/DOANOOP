package KH;
import KH_ADMIN.DANHSACHKHACHHANG_AD;
import KH_ADMIN.FILE_KH;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHKHACHHANG extends DANHSACHKHACHHANG_AD{
    static Scanner input=new Scanner(System.in);
    static ArrayList<KHACHHANG> arrayKH=new ArrayList<>();
//    HÀM KIỂM TRA VÀ TÌM KIẾM KHÁCH HÀNG
    public int ktraKH(String SDT){
//        arrayKH.clear();
//        FILE_KH file=new FILE_KH();
//        file.readFromFile(arrayKH); 
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0)
                    return 1;
            }
        return 0;
    }
//    THEM KH VAO DS BANG FILE_KH
//    THEM MOI KHACH HANG
    public void themKH(){       
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT= input.nextLine();
        if(ktraKH(SDT)==0){
            KHACHHANG a= new KHACHHANG();
            a.NHAP_TEN();
            a.setSDT(SDT);
            arrayKH.add(a);
            FILE_KH f=new FILE_KH();
            f.writeToFile(arrayKH);
            System.out.println("Them thanh cong!"); 
        }
        else{
        System.out.println("SDT da ton tai");
        }
    }
//LOI ARRAYKH DANG BI TRONG, KHONG CO PHAN TU
    public void xuatDSKH(){
        arrayKH.clear();
        FILE_KH file=new FILE_KH();
        file.readFromFile(arrayKH);
        for(int i=0;i<arrayKH.size();i++){
            System.out.println(arrayKH.get(i).toString());
        }
    }
//TÌM KIẾM KHÁCH H, NEU TIM THAY CO QUYEN SUA,XOA
    public void timKiem(){
        arrayKH.clear();
        FILE_KH f=new FILE_KH();
        f.readFromFile(arrayKH);
        System.out.print("Nhap so dien thoai:");
        input=new Scanner(System.in);
        String SDT= input.nextLine();
        for(int i=0;i<arrayKH.size();i++){
            if(SDT.compareTo(arrayKH.get(i).getSDT())==0){
                System.out.println(arrayKH.get(i).toString());
            }
            if(i==(arrayKH.size()-1) &&SDT.compareTo(arrayKH.get(i).getSDT())!=0)
                System.out.println("Khong ton tai");
        
        }
    }

}


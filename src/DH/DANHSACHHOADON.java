package DH;
import static DH.CHITIETHD.arraySP;
import DH_ADMIN.FILE_DH;
import java.util.ArrayList;
import java.util.Scanner;
public class DANHSACHHOADON {
    Scanner input=new Scanner(System.in);
    ArrayList<HOADON> arrayHD=new ArrayList<>();
    static public int i=0;
    public void themHD(){
        FILE_DH f=new FILE_DH();
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        CHITIETHD cthd=new CHITIETHD();
        cthd.main();
        arrayHD.add(a);
        a.XUAT(a,arraySP);
        f.writeToFile(arrayHD); 
                arraySP.clear();
        
    }
    public void themHD_KTV(String SDT){
        FILE_DH f=new FILE_DH();
        HOADON a= new HOADON();
        a.setMaHD("HD"+ String.valueOf(i));
        i++;
        a.setSDT(SDT);
//        a.setMaNV(SDT);
        CHITIETHD cthd=new CHITIETHD();
        cthd.main();
        arrayHD.add(a);
        a.XUAT_KTV(a,arraySP);
        f.writeToFile(arrayHD);     
        arraySP.clear();        
    }
     public void timKiem_HD(){
        FILE_DH f=new FILE_DH();
        f.readFromFile(arrayHD);
        System.out.print("Nhap ma hoa don:");
        input=new Scanner(System.in);
        String mahd= input.nextLine();
        for(int i=0;i<arrayHD.size();i++){
            if(mahd.compareTo(arrayHD.get(i).getMaHD())==0){
                System.out.println(arrayHD.get(i).toString());

                }
            if(i==(arrayHD.size()-1) &&mahd.compareTo(arrayHD.get(i).getMaHD())!=0)
                System.out.println("Khong ton tai");
        }
    }
    public void xuatDSHD(){
        arrayHD.clear();
        FILE_DH file=new FILE_DH();
        file.readFromFile(arrayHD);
        for(int x=0;x<arrayHD.size();x++){
            System.out.println(arrayHD.get(x).toString());
        }
    }
}

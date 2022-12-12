package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        /*KHAI BAO PN, MH, NV, ...*/
        DSPN dspn = new DSPN();
        DSNCC dsncc = new DSNCC();
        KHO kho = new KHO();
        DANHSACHKHACHHANG dskh = new DANHSACHKHACHHANG();
        DANGNHAP dn = new DANGNHAP();
        Chinhsuadanhsach csds = new Chinhsuadanhsach();
        DANHSACHHOADON dshd = new DANHSACHHOADON();
        loinhuan LN = new loinhuan();
        /*LAY DU LIEU*/
        
        dspn.docFile();
        kho.docFile();
        dsncc.docFile();

        outer:
        while(true){
            System.out.println("========================================Xin chao========================================");
            System.out.println("1/Dang nhap.");
            System.out.println("0/Dang xuat.");
            System.out.print(" : ");
            byte n = in.nextByte();

            switch(n){
                case 1:{
                    do{
                        dn.nhap();
                    }while(dn.getOk() == 0);

                    int manv = dn.getIdlv();
                    byte kt = (byte) dn.getOk();
                    
                    //ok = 2 la nhan vien; 1 la quan ly
                    if( kt == 2 ){
                        nhanvien:
                        while(true){
                            System.out.println("========================================Menu nhan vien========================================");
                            System.out.println("1/Phieu nhap.");
                            System.out.println("2/Kho hang.");
                            System.out.println("3/Khach hang.");
                            System.out.println("4/Hoa don.");
                            System.out.println("5/Nhan vien.");
                            System.out.println("0/Thoat.");
                            System.out.print(" : ");
                            byte k = in.nextByte();

                            switch(k){
                                case 1: dspn.menuPn(kho, dsncc, manv);
                                    break;
                                case 2: kho.menuKho();
                                    break;
                                case 3: {
                                    dskh.main(2,dshd);
                                }
                                    break;
                                case 4:{
                                    dshd.menu(dskh, manv, kho);
                                }
                                    break;
                                case 5: csds.menu(2);
                                    break;
                                case 0:
                                    break nhanvien;
                                default : System.out.println("Lenh khong hop le!");
                                    break;
                            }
                        }
                    }
                    else if( kt == 1 ){
                        quanly:
                        while(true){
                            System.out.println("========================================Menu quan ly========================================");
                            System.out.println("1/Phieu nhap.");
                            System.out.println("2/Kho hang.");
                            System.out.println("3/Nhan vien.");
                            System.out.println("4/Khach hang.");
                            System.out.println("5/Hoa don.");
                            System.out.println("6/Doanh thu.");
                            System.out.println("0/Thoat.");
                            System.out.print(" : ");
                            byte k = in.nextByte();

                            switch(k){
                                case 1: dspn.menuPn(kho, dsncc, manv);
                                    break;
                                case 2: kho.menuKho();
                                    break;
                                case 3: csds.menu(1);
                                    break;
                                case 4:{
                                    dskh.main(1,dshd);
                                }
                                    break;
                                case 5: {
                                    kho.xuatKhoChoNv();
                                    dshd.menu(dskh, manv, kho);
                                }    
                                    break;
                                case 6: {
                                    LN.menu();
                                }
                                    break;
                                case 0:
                                    break quanly;
                                default : System.out.println("Lenh khong hop le!");
                                    break;
                            }
                        }
                    }
                }
                    break;
                case 0:
                    break outer;
                default : System.out.println("Lenh khong hop le!");
                    break;
            }
        }
        /*
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDate td = LocalDate.parse(today.toString() , formatter);
        System.out.println(today.format(formatter));
         */
    }
}
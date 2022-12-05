/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nam23
 */
public class DSPN implements DocGhiFile{
    private ArrayList<PHIEUNHAP> dspn;
    private long tongSoTienNhapHang = 0;
    
    Checking check = new Checking();
    Scanner inp = new Scanner(System.in);

    public DSPN() {
        this.dspn = new ArrayList<>();
        tongSoTienNhapHang = 0;
    }

    public DSPN(ArrayList<PHIEUNHAP> dspn, long tongSoTienNhapHang) {
        this.dspn = new ArrayList<>();
        this.tongSoTienNhapHang = tongSoTienNhapHang;
    }

    public long getTongSoTienNhapHang() {
        return tongSoTienNhapHang;
    }

    public void setTongSoTienNhapHang(long tongSoTienNhapHang) {
        this.tongSoTienNhapHang = tongSoTienNhapHang;
    }
    public ArrayList<PHIEUNHAP> getDspn() {
        return dspn;
    }
    public void setDspn(ArrayList<PHIEUNHAP> dspn) {
        this.dspn = dspn;
    }
    
    public double tinhTongTienDSPN(){
        tongSoTienNhapHang = 0;
        int length = dspn.size();
        for(int i=0; i<length; i++){
            tongSoTienNhapHang += dspn.get(i).getTotalMoney();
        }
        return tongSoTienNhapHang;
    }
    
    @Override
    public void docFile(){
        dspn.clear();
        
        ArrayList<CHITIETPN> dsctpn = new ArrayList<>();
        int length = 0;
        try( FileReader fr2 = new FileReader("DSCTPN.txt")){
            try (BufferedReader br2 = new BufferedReader(fr2)) {
                String line = br2.readLine();
                if(line == null){
                    System.out.println("Khong co du lieu!");
                    br2.close();
                    fr2.close();
                    return;
                }
                while(line != null){
                    String []ctpn = line.split(",");
                    String idPn = ctpn[0];
                    String idMh = ctpn[1];
                    String tenMh = ctpn[2];
                    long giaMh = Long.parseLong(ctpn[3]);
                    int soluong = Integer.parseInt(ctpn[4]);
                    String hsd = ctpn[5];
                    String donvi = ctpn[6];
                    String tinhtrang = ctpn[7];
                    long thanhtien = Long.parseLong(ctpn[8]);
                    String loai = ctpn[9];
                    
                    MATHANG temp = null;
                    if(loai.equalsIgnoreCase("TP")){
                        temp = new THUCPHAM(idMh, tenMh, giaMh, hsd, donvi, soluong, tinhtrang);
                    }
                    else if(loai.equalsIgnoreCase("PTP")){
                        temp = new PHITHUCPHAM(idMh, tenMh, giaMh, hsd, donvi, soluong, tinhtrang);
                    }
                    
                    dsctpn.add(new CHITIETPN(temp, idPn, giaMh, soluong, thanhtien));
                    line = br2.readLine();
                }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            
            fr2.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(DSPN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try(FileReader fr = new FileReader("DSPN.txt")){
            try(BufferedReader br = new BufferedReader(fr)){
                String line = br.readLine();
                if(line == null){
                    System.out.println("Khong co du lieu!");
                    br.close();
                    fr.close();
                    return;
                }
                while( line != null){
                    String []pn = line.split(",");
                    String idpn = pn[0];
                    String supplier = pn[1];
                    int employeeID = Integer.parseInt(pn[2]);
                    String date = pn[3];
                    long totalMoney = Long.parseLong(pn[4]);

                    CHITIETPN []ct = null;
                    int count = 0;
                    for(int i=0; i<dsctpn.size(); i++){
                        if(dsctpn.get(i).getMaPN().equalsIgnoreCase(idpn)){
                            count ++;
                        }
                    }
                    ct = new CHITIETPN[count];
                    for(int i=0; i<count; i++){
                        ct[i] = dsctpn.get(0);
                        dsctpn.remove(0);
                    }
                    dspn.add(new PHIEUNHAP(idpn, employeeID, supplier, date, totalMoney, ct));

                    line = br.readLine();
                }
                br.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            
            fr.close();
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(DSPN.class.getName()).log(Level.SEVERE, null, ex);
        }
        tinhTongTienDSPN();
    }
    @Override
    public void ghiFile(){
        //String str = "idPN,NCC,NVNhap,NgayNhap,TongTien";  PN
        //String str = "idPN, idMH,gia,soluong,thanhtien";   CTPN
        FileWriter fw = null;
        FileWriter fw2 = null;
        try{
            fw = new FileWriter("DSPN.txt");
            fw2 = new FileWriter("DSCTPN.txt");
            String idpn, idncc, idnv, ngaynhap, tongtien;
            String idmh, tenmh, giamh, soluong, hsd, donvi, tinhtrang, loai, thanhtien;
            int length = dspn.size();
            for(int i=0; i<length; i++){
                idpn = String.valueOf(dspn.get(i).getIdPN());
                idncc = String.valueOf(dspn.get(i).getSupplier());
                idnv = String.valueOf(dspn.get(i).getEmployeeID());
                ngaynhap = String.valueOf(dspn.get(i).getDate());
                tongtien = String.valueOf(dspn.get(i).getTotalMoney());
                
                String str = String.format("%s,%s,%s,%s,%s\n", idpn, idncc, idnv, ngaynhap, tongtien);
                fw.write(str);
                
                CHITIETPN[] temp = dspn.get(i).getCtpn().clone();
                int len = temp.length;
                for(int j=0; j< len; j++){
                    idmh = temp[j].getG().getId();
                    tenmh = temp[j].getG().getName();
                    giamh = String.valueOf(temp[j].getG().getPrice());
                    soluong = String.valueOf(temp[j].getG().getQuantity());
                    hsd = temp[j].getG().getExp();
                    donvi = temp[j].getG().getUnit();
                    tinhtrang = temp[j].getG().getCondition();
                    loai = temp[j].getG().getType();
                    thanhtien = String.valueOf(temp[j].getThanhtien());
                    
                    String str2 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", idpn, idmh, tenmh, giamh, soluong, hsd, donvi, tinhtrang, thanhtien, loai);
                    fw2.write(str2);
                }
            }
            fw.close();
            fw2.close();
        }catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
    
    //TAO DANH SACH PHIEU MOI
    public void taoDSPN(KHO kho){
        System.out.print("So luong phieu them vao: ");
        int n = inp.nextInt();
        
        for(int i=0; i<n; i++){
            System.out.println("Tao phieu nhap thu " + (i+1));
            PHIEUNHAP pn = new PHIEUNHAP();
            pn.khoiTaoPN(kho);
            dspn.add(pn);
        }
        tinhTongTienDSPN();
        ghiFile();
        
    }
    
    //TAO PHIEU MOI
    public void taoPN(String ma, KHO kho){
        PHIEUNHAP pn = new PHIEUNHAP();
        pn.khoiTaoPN(ma, kho);
        dspn.add(pn);
        tinhTongTienDSPN();
        ghiFile();
    }
    
    //XUAT DANH SACH PHIEU NHAP
    public void xuatDSPN(){
        if(dspn.isEmpty()){
            System.out.println("KHONG CO PHIEU NHAP!");
        }
        else{
            System.out.printf("%-15s\t%-20s\t%-20s\t%-20s\t%10s\n", "Ma phieu nhap", "Ma nha cung cap", "Ma nhan vien nhap", "Ngay nhap", "Tong tien");
            int length = dspn.size();
            for (int i=0; i<length; i++){
                dspn.get(i).xuatPN();
                int len = dspn.get(i).getCtpn().length;
                for(int j=0; j<len; j++){
                    dspn.get(i).getCtpn()[j].xuatCTPN();
                }
            }
        }
    }
    //XUAT CHI TIET PHIEU
    public void xuatchiTietPhieu(){        
        int length = dspn.size();
        for (int i=0; i<length; i++){
            System.out.println("Phieu " + dspn.get(i).getIdPN());
            System.out.printf("%-15s\t%-20s\t%-20s\t%-20s\t%10s\n", "Ma phieu nhap", "Ma nha cung cap", "Ma nhan vien nhap", "Ngay nhap", "Tong tien");
            dspn.get(i).xuatPN();
            int len = dspn.get(i).getCtpn().length;

            for(int j=0; j<len; j++){
                dspn.get(i).getCtpn()[j].xuatCTPN();
            }
        }
        
    }
    
    //KIEM TRA PHIEU THEO MA PHIEU
    public int ktPNTonTaiTheoMaPn(String ma){
        int length = dspn.size();
        for(int i=0; i<length; i++){
            if(ma.equals(dspn.get(i).getIdPN())){
                return i;
            }
        }
        return -1;
    }
    
    //KIEM TRA MAT HANG TRONG 1 PHIEU
    public int ktMaMH(int indexMaPN, String ma){
        int length = dspn.get(indexMaPN).getCtpn().length;
        for(int i=0; i<length; i++){
            if(dspn.get(indexMaPN).getCtpn()[i].getG().getId().equals(ma)){
                return i;
            }
        }
        return -1;
    }
    
    //KIEM TRA THEO MA NCC TRA VE VI TRI TRONG DANH SACH PHIEU
    public int[] ktPNTonTaiTheoMaNCC1(String ma){
        int length = dspn.size();
        int []temp;
        int count = 0;
        for(int i=0; i<length; i++){
            if(dspn.get(i).getSupplier().equals(ma)){
                count++;
            }
        }
        temp = new int[count];
        int k = 0;
        for(int i=0; i<length; i++){
            if(dspn.get(i).getSupplier().equals(ma)){
                temp[k++] = i;
            }
        }
        return temp;
    }
    
    //KIEM TRA PHIEU THEO MA NCC TRA VE SO PHIEU CO NCC DO
    public int ktPNTonTaiTheoMaNCC2(String ma){
        int length = dspn.size();
        int count = 0;
        for(int i=0; i<length; i++){
            if(dspn.get(i).getSupplier().equals(ma)){
                count++;
            }
        }
        return count;
    }
    /*
    //KIEM TRA HANG HET HAN
    public int ktHangHetHan(){
        int length = dspn.size();
        int count = 0;
        for(int i=0; i<length; i++){
            count += dspn.get(i).ktHangHh();
        }
        return count;
    }
    //XUAT DANH SACH CAC MAT HANG HET HAN
    public void xoaMhHh(){
        int count = ktHangHetHan();
        if(count == 0){
            System.out.println("Khong co mat hang nao het han!");
        }
        else{
            int length = dspn.size();
            for(int i=0; i<length; i++){
                dspn.get(i).xoaHangHh();
            }
            tinhTongTienDSPN();
            ghiFile();
        }
    }
    */
    //THEM PHIEU MOI
    public void themPN(KHO kho){
        System.out.print("Nhap ma phieu: ");
        String ma;
        ma = inp.nextLine();
        while( true ){
            if(check.checkNull(ma)){
                System.out.print("Vui long nhap ma phieu: ");
                ma = inp.nextLine();
            }
            else if(!check.checkNumString(ma)){
                System.out.print("Vui long nhap lai ma phieu: ");
                 ma = inp.nextLine();
            }
            else{
                break;
            }
        }
        int indexMaPN = ktPNTonTaiTheoMaPn(ma);
        while(true){
            if(indexMaPN == -2){
                System.out.println("Khong co phieu nhap nao!");
                System.out.println("Tien hanh tao phieu nhap!");
                break;
            }
            else{
                if(indexMaPN != -1){
                    System.out.println("Phieu nhap da ton tai!");
                    return;
                }
                else{
                    System.out.println("Tien hanh tao phieu nhap!");
                    break;
                }
            }
        }
        taoPN(ma, kho);
    }
    //THEM MAT HANG VAO PHIEU DA TIN TAI HOAC TAO PHIEU MOI NEU KO TON TAI PHIEU
    public void themVaoPNDaTonTai(KHO  kho){
        System.out.println("Nhap ma phieu: ");
        String ma;
        ma = inp.nextLine();
        while( true ){
            if(check.checkNull(ma)){
                System.out.print("Vui long nhap ma phieu: ");
                ma = inp.nextLine();
            }
            else if(!check.checkNumString(ma)){
                System.out.print("Vui long nhap lai ma phieu: ");
                 ma = inp.nextLine();
            }
            else{
                break;
            }
        }
        int indexMaPN = ktPNTonTaiTheoMaPn(ma);
        if(indexMaPN == -2 ){
            System.out.println("Khong co phieu nhap nao!");
            return;
        }
        if(indexMaPN != -1){
            System.out.print("Nhap ma mat hang: ");
            String mamh = inp.nextLine();
            while( true ){
                if(check.checkNull(mamh)){
                    System.out.print("Vui long nhap ma mat hang: ");
                    mamh = inp.nextLine();
                }
                else if(!check.checkNumString(mamh)){
                    System.out.print("Vui long nhap lai ma mat hang: ");
                    mamh = inp.nextLine();
                }
                else{
                    break;
                }
            }
            int index = ktMaMH(indexMaPN, mamh);
            if(index != -1){
                System.out.println("Mat hang da ton tai trong phieu!");
                System.out.print("Vui long nhap so luong muon them vao: ");
                int soluongthemvao;
                soluongthemvao = inp.nextInt();
                while(soluongthemvao <= 0){
                    System.out.print("Nhap lai so luong them vao: ");
                    soluongthemvao = inp.nextInt();
                }
                int soluongbandau = dspn.get(indexMaPN).getCtpn()[index].getSoluong();
                dspn.get(indexMaPN).getCtpn()[index].setSoluong(soluongthemvao + soluongbandau);
                dspn.get(indexMaPN).getCtpn()[index].tinhThanhTien();
                dspn.get(indexMaPN).tinhTongTien1PN();
                tinhTongTienDSPN();
                kho.thayDoisoluong(dspn.get(indexMaPN).getCtpn()[index].getG().getId(), dspn.get(indexMaPN).getCtpn()[index].getG().getExp(), soluongthemvao);
                ghiFile();
            }
            else{
                System.out.println("Tao mat hang!");
                CHITIETPN ctmoi = new CHITIETPN();
                ctmoi.khoiTaoCTPN(mamh,kho);

                int newlength = dspn.get(indexMaPN).getCtpn().length + 1;

                CHITIETPN []temp = new CHITIETPN[newlength];

                System.arraycopy(dspn.get(indexMaPN).getCtpn(), 0, temp, 0, newlength-1);
                temp[newlength -1 ]= ctmoi;

                dspn.get(indexMaPN).setCtpn(temp);
                dspn.get(indexMaPN).tinhTongTien1PN();
                tinhTongTienDSPN();
                ghiFile();
            }
        }
        else{
            System.out.println("PHIEU NHAP KHONG TON TAI!");
            System.out.println("Ban co muon tao phieu nhap moi?\n1/Tao phieu moi.\n2/Khong tao.");
            int k = inp.nextInt();

            outer :while(true){
                switch (k) {
                    case 1:{
                        System.out.println("TAO PHIEU NHAP MOI!");
                        taoPN(ma, kho);
                    } break outer;
                    case 2:
                        break outer;
                    default:{
                        System.out.print("Nhap lai lua chon (1/Tao phieu moi.\t2/Khong tao.): ");
                        k = inp.nextInt();
                    }
                }
            }
        }
    }
    
    //XOA PHIEU THEO MA PHIEU
    public void xoaPNTheoMaPhieu(){
        docFile();
        xuatDSPN();
        String ma = nhapMaPn();
        int k = ktPNTonTaiTheoMaPn(ma);
        if(k == -1){
            System.out.print("PHIEU NHAP KHONG TON TAI!");
        }
        else{
            System.out.println("XAC NHAN XOA PHIEU NHAP!");
            System.out.print("Y/N: ");
            String conf = inp.nextLine();
            while(true){
                if(conf.equalsIgnoreCase("y") || conf.equalsIgnoreCase("Y")){
                    PHIEUNHAP remove = dspn.remove(k);
                    if(remove != null){
                        System.out.println("DA XOA PHIEU NHAP!");
                        tinhTongTienDSPN();
                        ghiFile();
                        break;
                    }
                    else{
                        System.out.println("LOI");
                        break;
                    }
                }
                else if(conf.equalsIgnoreCase("n") || conf.equalsIgnoreCase("N")){
                    break;
                }
                else{
                    System.out.print("Y/N: ");
                    conf = inp.nextLine();
                }
            }
        }
    }
    
    //XOA PHIEU THEO MA NCC
    public void xoaPNTheoMaNCC(){
        docFile();
        xuatDSPN();
        String ma = nhapMaNcc();
        outer :
        while(true){
            int count = ktPNTonTaiTheoMaNCC2(ma);
            if(count == 0){
                System.out.println("Khong co phieu nhap phu hop");
            }
            else{
                int k = 0;
                System.out.println("XAC NHAN XOA PHIEU NHAP!");
                System.out.print("Y/N: ");
                String conf = inp.nextLine();
                while(true){
                    if(conf.equalsIgnoreCase("y") || conf.equalsIgnoreCase("Y")){
                        while(k<count){
                            int length = dspn.size();
                            for(int i=0; i<length; i++){
                                if(dspn.get(i).getSupplier().equals(ma)){
                                    dspn.remove(i);
                                    k++;
                                    break;
                                }
                            }
                        }
                        tinhTongTienDSPN();
                        ghiFile();
                        break outer;
                    }
                    else if(conf.equalsIgnoreCase("n") || conf.equalsIgnoreCase("N")){
                        break outer;
                    }
                    else{
                        System.out.print("Y/N: ");
                        conf = inp.nextLine();
                    }
                }
            }
        }
    }
    
    //XOA TOAN BO PHIEU NHAP
    public void xoaToanBoPn(){
        docFile();
        System.out.println("XAC NHAN XAO TOAN BO PHIEU NHAP!");
        System.out.print("Y/N: ");
        String conf = inp.nextLine();
        while(true){
            if(conf.equalsIgnoreCase("y") || conf.equalsIgnoreCase("Y")){
                dspn.clear();
                tinhTongTienDSPN();
                ghiFile();
                break;
            }  
            else if(conf.equalsIgnoreCase("n") || conf.equalsIgnoreCase("N")){
                break;
            }
            else{
                System.out.print("Y/N: ");
                conf = inp.nextLine();
            }
        }
    }
    
    //TIM KIEM PHIEU NHAP THEO MA PHIEU
    public void timKiemPnTheoMaPN(String ma){
        if(dspn.isEmpty()){
            System.out.println("KHONG CO PHIEU NHAP!");
        }
        else{
            int  k = ktPNTonTaiTheoMaPn(ma);
            if(k==-1){
                System.out.println("Khong co phieu nhap can tim!");
            }
            else{
                int length = dspn.size();
                System.out.printf("%-15s\t%-20s\t%-20s\t%-20s\t%10s\n", "Ma phieu nhap", "Ma nha cung cap", "Ma nhan vien nhap", "Ngay nhap phieu", "Tong tien");
                for(int i=0; i<length; i++){
                    if(dspn.get(i).getIdPN().contains(ma)){
                        dspn.get(i).xuatPN();
                    }
                }
            }
        }
    }
    
    //TIM KIEM PHIEU NHAP THEO MANCC
    public void timKiemPnTheoMaNCC(String ma){
        if(dspn.isEmpty()){
            System.out.println("KHONG CO PHIEU NHAP!");
        }
        else{
            int k = ktPNTonTaiTheoMaNCC2(ma);
            if( k==0 ){
                System.out.println("Khong co phieu nhap can tim!");
            }
            else{
                int length = dspn.size();
                System.out.printf("%-15s\t%-20s\t%-20s\t%-20s\t%10s\n", "Ma phieu nhap", "Ma nha cung cap", "Ma nhan vien nhap", "Ngay nhap phieu", "Tong tien");
                for(int i=0; i<length; i++){
                    if(dspn.get(i).getSupplier().contains(ma)){
                        dspn.get(i).xuatPN();
                    }
                }
            }
        }
    }
    
    //TIM KIEM MAT HANG THEO MA MH
    public void timKiemMhTheoMaMH(String ma){
        if(dspn.isEmpty()){
            System.out.println("KHONG CO PHIEU NHAP!");
        }
        else{
            int length = dspn.size();
            boolean k;
            boolean res = false;
            for(int i=0; i<length; i++){
                k = dspn.get(i).timKiemMHTheomamh(ma);
                if(k){
                    res = true;
                }
            }
            if(!res){
                System.out.println("Khong co mat hang can tim!");
            }
        }
    }
    
    //TIM KIEM MAT HANG THEO TEN MAT HANG
    public void timKiemMhTheoTen(String ten){
        if(dspn.isEmpty()){
            System.out.println("KHONG CO PHIEU NHAP!");
        }
        else{
            int length = dspn.size();
            boolean k;
            boolean res = false;
            for(int i=0; i<length; i++){
                k = dspn.get(i).timKiemMHTheotenmh(ten);
                if(k){
                    res = true;
                }
            }
            if(!res){
                System.out.println("Khong co mat hang can tim!");
            }
        }
    }
    
    //TIM KIEM MAT HANG THEO MA PHIEU NHAP
    public void timKiemMHTheoMaPn(String ma){
        if(dspn.isEmpty()){
            System.out.println("KHONG CO PHIEU NHAP!");
        }
        else{
            int index = ktPNTonTaiTheoMaPn(ma);
            if(index == -1){
                System.out.println("Phieu nhap khong ton tai!");
            }
            else{
                dspn.get(index).xuatCacMh();
            }
        }
    }
    
    public void menuXem(){
        xem: 
        while(true){
            System.out.println("========================================Xem========================================");
            System.out.println("1/Xuat danh sach phieu nhap");
            System.out.println("2/Xuat chi tiet phieu.");
            System.out.println("0/Quay lai.");
            System.out.print(" : ");
            int mode1 = inp.nextInt();
            if(inp.hasNextLine()){
                inp.nextLine();
            }
            switch(mode1){
                case 1:{
                    xuatDSPN();
                    System.out.println("Tong so tien nhap hang: " + getTongSoTienNhapHang());
                }
                    break;
                case 2:{
                    xuatchiTietPhieu();
                    System.out.println("Tong so tien nhap hang: " + getTongSoTienNhapHang());
                }
                    break;
                case 0: 
                    break xem;
                default: {
                    System.out.println("Lenh khong hop le!");
                }   break;
            }
        }
    }
    
    public void menuThem(KHO kho){
        them: 
        while(true){
            System.out.println("========================================Them========================================");
            System.out.println("1/Them 1 phieu moi.");
            System.out.println("2/Them mat hang vao 1 phieu da ton tai.");
            System.out.println("0/Quay lai.");
            System.out.print(" : ");
            int mode2 = inp.nextInt();
            if(inp.hasNextLine()){
                inp.nextLine();
            }
            switch(mode2){
                case 1: {
                    themPN(kho);
                    System.out.println("Tong so tien nhap hang: " + getTongSoTienNhapHang());
                }
                    break;
                case 2: {
                    themVaoPNDaTonTai(kho);
                    System.out.println("Tong so tien nhap hang: " + getTongSoTienNhapHang());
                }
                    break;
                case 0:
                    break them;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
    
    public void menuXoa(){
        xoa: 
        while(true){
            System.out.println("========================================Xoa phieu nhap========================================");
            System.out.println("1/Xoa phieu theo ma phieu.");
            System.out.println("2/Xoa phieu theo ma nha cung cap.");
            System.out.println("3/Xoa toan bo phieu.");
            System.out.println("0/Quay lai.");
            System.out.print(" : ");
            int mode3 = inp.nextInt();
            switch(mode3){
                case 1: {
                    xoaPNTheoMaPhieu();
                    System.out.println("Tong so tien nhap hang: " + getTongSoTienNhapHang());
                }
                    break;
                case 2: {
                    xoaPNTheoMaNCC();
                    System.out.println("Tong so tien nhap hang: " + getTongSoTienNhapHang());
                }
                    break;
                case 3:{
                    xoaToanBoPn();
                } 
                    break;
                case 0:
                    break xoa;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
    
    public void menuTimKiem(){
        timkiem:
        while(true){
            System.out.println("========================================Tim kiem========================================");
            System.out.println("1/Tim phieu nhap.");
            System.out.println("2/Tim mat hang.");
            System.out.println("0/Quay lai.");
            System.out.print(" : ");
            int mode = inp.nextInt();
            switch(mode){
                case 1:{
                    pn:
                    while(true){
                        System.out.println("========================================Tim phieu nhap========================================");
                        System.out.println("1/Tim theo ma phieu.");
                        System.out.println("2/Tim theo ma nha cung cap.");
                        System.out.println("0/Quay lai.");
                        System.out.print(" : ");
                        int mode1 = inp.nextInt();
                        switch(mode1){
                            case 1: {
                                String ma = nhapMaPn();
                                timKiemPnTheoMaPN(ma);
                            }   break;
                            case 2: {
                                String ma = nhapMaNcc();
                                timKiemPnTheoMaNCC(ma);
                            }   break;
                            case 0:
                                break pn;
                            default: System.out.println("Lenh khong hop le!");
                                break;
                        }
                    }
                }   break;
                case 2:{
                    mh:
                    while(true){
                        System.out.println("========================================Tim mat hang========================================");
                        System.out.println("1/Tim theo ma phieu nhap.");
                        System.out.println("2/Tim theo ma mat hang.");
                        System.out.println("3/Tim theo ten mat hang.");
                        System.out.println("0/Quay lai.");
                        System.out.print(" : ");
                        int mode1 = inp.nextInt();
                        switch(mode1){
                            case 1: {
                                String ma = nhapMaPn();
                                timKiemMHTheoMaPn(ma);
                            }break;
                            case 2: {
                                String ma = nhapMaMh();
                                timKiemMhTheoMaMH(ma);
                            }break;
                            case 3:{
                                String ten = nhaptenMh();
                                timKiemMhTheoTen(ten);
                            }break;
                            case 0:
                                break mh;
                            default: System.out.println("Lenh khong hop le!");
                                break;
                        }
                    }
                }   break;
                case 0:
                    break timkiem;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
    public void menuPn(KHO kho){
    outer:
        while(true){
            System.out.println("========================================Menu phieu nhap========================================");
            System.out.println("1/Xem phieu nhap, hang hoa.");
            System.out.println("2/Tim kiem phieu, hang hoa.");
            System.out.println("3/Them phieu.");
            System.out.println("4/Xoa phieu.");
            System.out.println("0/Thoat.");
            System.out.print(" : ");
            int n = inp.nextInt();
            switch(n){
                case 1: {
                    if(getDspn().isEmpty()){
                        System.out.println("Khong co phieu nhap!");
                    }
                    else{
                        menuXem();
                    }
                }
                    break;
                case 2: {
                    if(getDspn().isEmpty()){
                        System.out.println("Khong co phieu nhap!");
                    }
                    else{
                        menuTimKiem();
                    }
                }
                    break;
                case 3: {
                    menuThem(kho);
                }
                    break;
                case 4: {
                    if(getDspn().isEmpty()){
                        System.out.println("Khong co phieu nhap!");
                    }
                    else{
                        menuXoa();
                    }
                }
                    break;
                case 0:
                    break outer;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
    public String nhapMaNcc(){
        if(inp.hasNextLine()){
            inp.nextLine();
        }
        System.out.print("Nhap ma nha cung cap: ");
        String ma = inp.nextLine();
        while( true ){
            if(check.checkNull(ma)){
                System.out.print("Vui long nhap ma nha cung cap: ");
                ma = inp.nextLine();
            }
            else if(!check.checkNumString(ma)){
                System.out.print("Vui long nhap lai ma nha cung cap: ");
                ma = inp.nextLine();
            }
            else if(!"101".equals(ma) && !"102".equals(ma) && !"103".equals(ma)){
                System.out.print("Vui long nhap lai ma nha cung cap (hien tai chi co 3 nha cung cap: 101, 102 va 103).");
                System.out.print(" : ");
                ma = inp.nextLine();
            }
            else{
                break;
            }
        }
        return ma;
    }
    public String nhapMaPn(){
        if(inp.hasNextLine()){
            inp.nextLine();
        }
        System.out.print("Nhap ma phieu nhap: ");
        String ma = inp.nextLine();
        while( true ){
                if(check.checkNull(ma)){
                    System.out.print("Vui long nhap ma phieu: ");
                    ma = inp.nextLine();
                }
                else if(!check.checkNumString(ma)){
                    System.out.print("Vui long nhap lai ma phieu: ");
                     ma = inp.nextLine();
                }
                else{
                    break;
                }
        }
        return ma;
    }
    public String nhapMaMh(){
        if(inp.hasNextLine()){
            inp.nextLine();
        }
        System.out.print("Nhap ma mat hang: ");
        String ma = inp.nextLine();
        while( true ){
                if(check.checkNull(ma)){
                    System.out.print("Vui long nhap ma mat hang: ");
                    ma = inp.nextLine();
                }
                else if(!check.checkNumString(ma)){
                    System.out.print("Vui long nhap lai ma mat hang: ");
                     ma = inp.nextLine();
                }
                else{
                    break;
                }
        }
        return ma;
    }
    public String nhaptenMh(){
        if(inp.hasNextLine()){
            inp.nextLine();
        }
        System.out.print("Nhap ten mat hang: ");
        String ten = inp.nextLine();
        while( true ){
                if(check.checkNull(ten)){
                    System.out.print("Vui long nhap ten mat hang: ");
                    ten = inp.nextLine();
                }
                else if(!check.checkTextString(ten)){
                    System.out.print("Vui long nhap lai ten mat hang: ");
                     ten = inp.nextLine();
                }
                else{
                    break;
                }
        }
        return ten;
    }
}
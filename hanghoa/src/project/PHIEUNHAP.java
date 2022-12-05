/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author nam23
 */
public class PHIEUNHAP{
    private String idPN;
    private int employeeID;
    private String supplier;
    private String date;
    private long totalMoney;
    private CHITIETPN [] ctpn;
    Scanner inp = new Scanner(System.in);
    Checking check = new Checking();

            
    public PHIEUNHAP() {
    }
    public PHIEUNHAP(String idPN, int employeeID, String supplier, String date, long totalMoney, CHITIETPN [] ctpn) {
        this.idPN = idPN;
        this.employeeID = employeeID;
        this.supplier = supplier;
        this.date = date;
        this.totalMoney = totalMoney;
        this.ctpn = ctpn;
    }
    public PHIEUNHAP(String idPN, int employeeID, String supplier, String date, long totalMoney){
        this.idPN = idPN;
        this.employeeID = employeeID;
        this.supplier = supplier;
        this.date = date;
        this.totalMoney = totalMoney;
    }
    public String getIdPN() {
        return idPN;
    }
    public void setIdPN(String id) {
        this.idPN = id;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public long getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }
    public CHITIETPN[] getCtpn() {
        return ctpn;
    }
    public void setCtpn(CHITIETPN[] ctpn) {
        this.ctpn = ctpn;
    }
    public void nhapMaPN(){
        System.out.println("Nhap ma phieu nhap: ");
        idPN = inp.nextLine();
        while(true){
            if(check.checkNull(idPN)){
                System.out.print("Vui long nhap ma phieu: ");
                idPN = inp.nextLine();
            }
            else if(!check.checkNumString(idPN)){
                System.out.println("Sai dinh dang!");
                System.out.print("Nhap lai ma phieu(chuoi ky tu so): ");
                idPN = inp.nextLine();
            }
            else{
                break;
            }
        }
    }
    public void nhapMaNVN(){
        System.out.println("Nhap ma nhan vien nhap: ");
        employeeID = inp.nextInt();
    }
    
    public void tinhTongTien1PN(){
        totalMoney = 0;
        int length = ctpn.length;
        for (int i=0; i<length; i++){
            totalMoney += ctpn[i].getThanhtien();
        }
    }
    
    public void nhapNCC(){
        DSNCC a = new DSNCC();
        a.nhaCungCapMacDinh();
        System.out.println("Cac nha cung cap: ");
        a.xuatNCCMacDinh();
        if(inp.hasNextLine()){
            inp.nextLine();
        }
        System.out.print("Ma nha cung cấp duoc chon la:  ");
        String ma = inp.nextLine();
        while(true){
            if (ma.equals(a.getNcc(2).getMaNCC())|| ma.equals(a.getNcc(0).getMaNCC()) || ma.equals(a.getNcc(1).getMaNCC())){
                break;
            }
            else{
                System.out.println("Vui long chon 1 trong 3 nha cung cap: ");
                ma = inp.nextLine();
            }
        }
        supplier = ma;
    }
    public void nhapNgayNhap(){
        System.out.println("Ngay nhap phieu: ");
        date = inp.nextLine();
        while (true)
        {
            if (check.checkNull(date)){
                System.out.println("Chua nhap ngay nhap phieu!");
                System.out.println("Nhap ngay nhap phieu theo dinh dang DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                date = inp.nextLine();
            }
            else if(!check.checkDateFormat(date)){
                System.out.println("Nhap sai dinh dang!");
                System.out.println("Nhap lai ngay nhap phieu theo dinh dang DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                date = inp.nextLine();
            }
            else if(check.checkNgayNhapPhieu(date) > 0){
                System.out.println("Ngay nhap phieu khong hop le!");
                System.out.println("Nhap lai ngay nhap phieu theo dinh dang DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                date = inp.nextLine();
            }
            else{
                break;
            }
        }
    }

    //Nhap chi tiet phieu nhap moi
    public void nhapCTPNMoi(KHO kho){
        int n;
        System.out.print("So mat hang trong phieu la: ");
        n = inp.nextInt();
        ctpn = new CHITIETPN[n];
        for(int i=0; i<n; i++){
            System.out.println("Tao mat hang thu " + (i+1));
            ctpn[i] = new CHITIETPN();
            ctpn[i].setMaPN(idPN);
            ctpn[i].khoiTaoCTPN(kho);
        }
    }
    //Tao 1 phieu nhap moi
    public void khoiTaoPN(KHO kho){
        nhapMaPN();
        nhapMaNVN();
        nhapNCC();
        nhapNgayNhap();
        nhapCTPNMoi(kho);
        tinhTongTien1PN();
    }
    //Tao 1 phieu nhap moi
    public void khoiTaoPN(String ma, KHO kho){
        setIdPN(ma);
        nhapMaNVN();
        nhapNCC();
        nhapNgayNhap();
        nhapCTPNMoi(kho);
        tinhTongTien1PN();
    }
    
    //Kiem tra ma mat hang trong ctpn co san
    public boolean ktraMaMH(String ma){
        int length = ctpn.length;
        if(length == 0){
            return false;
        }
        for(int i=0; i<length; i++){
            if(ctpn[i].getG().getId().contains(ma)){
                return true;
            }
        }
        return false;
    }
    
    //TIM KIEM THEO MA MAT HANG
    public boolean timKiemMHTheomamh(String ma){
        int len = ctpn.length;
        boolean c = false;
        for(int i=0; i<len; i++){
            if(ctpn[i].getG().getId().contains(ma)){
                ctpn[i].getG().xuatMH();
                c = true;
            }
        }
        return c;
    }
    
    //TIM KIEM MAT HANG THEO TEN
    public boolean timKiemMHTheotenmh(String ten){
        int len = ctpn.length;
        boolean c = false;
        for(int i=0; i<len; i++){
            String name = ctpn[i].getG().getName().toLowerCase();
            if(name.contains(ten)){
                ctpn[i].getG().xuatMH();
                c = true;
            }
        }
        return c;
    }
    
    //XUAT MAT HANG
    public void xuatCacMh(){
        int length = ctpn.length;
        for(int i=0; i<length; i++){
            ctpn[i].xuatMh();
        }
    }
    /*
    //KIEM TRA HANG HET HAN
    public int ktHangHh(){
        int length = ctpn.length;
        int count = 0;
        for(int i=0; i<length; i++){
            if(ctpn[i].getG().getCondition().contains("Het")){
                count++;
            }
        }
        return count;
    }
    
    //XOA HANG HET HAN
    public void xoaHangHh(){
        int length = ctpn.length;
        int count = ktHangHh();
        if(count == 0){
            return;
        }
        else{
            CHITIETPN []temp = new CHITIETPN[length - count];
            int k = 0;
            for(int i=0; i<length; i++){
                if( !ctpn[i].getG().getCondition().contains("Het") ){
                    temp[k++] = ctpn[i];
                }
            }
            setCtpn(temp);
            tinhTongTien1PN();
        }
    }
    */
    public void xuatPN(){
        //System.out.printf("%-15s\t%-20s\t%-20s\t%-20s\t%10s\n", "Ma phieu nhap", "Ma nha cung cap", "Ma nhan vien nhap", "Ngay nhap phieu", "Tong tien");
        System.out.printf("%-5s\t\t%-5s\t\t\t%5d\t\t\t%-20s\t %-,12d\n\n", this.idPN, this.supplier, this.employeeID, this.date, this.totalMoney);
    }
    
}
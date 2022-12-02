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
    private int idPN;
    private int employeeID;
    private int supplier;
    private String date;
    private long totalMoney;
    private CHITIETPN [] ctpn;
    Scanner inp = new Scanner(System.in);
            
    public PHIEUNHAP() {
    }
    public PHIEUNHAP(int idPN, int employeeID, int supplier, String date, long totalMoney, CHITIETPN [] ctpn) {
        this.idPN = idPN;
        this.employeeID = employeeID;
        this.supplier = supplier;
        this.date = date;
        this.totalMoney = totalMoney;
        this.ctpn = ctpn;
    }
    public PHIEUNHAP(int idPN, int employeeID, int supplier, String date, long totalMoney){
        this.idPN = idPN;
        this.employeeID = employeeID;
        this.supplier = supplier;
        this.date = date;
        this.totalMoney = totalMoney;
    }
    public int getIdPN() {
        return idPN;
    }
    public void setIdPN(int id) {
        this.idPN = id;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public int getSupplier() {
        return supplier;
    }
    public void setSupplier(int supplier) {
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
        System.out.println("Nhập mã phiếu nhập: ");
        idPN = inp.nextInt();
    }
    public void nhapMaNVN(){
        System.out.println("Nhập mã nhân viên nhập: ");
        employeeID = inp.nextInt();
    }
    public void nhapNCC(){
        DSNCC a = new DSNCC();
        a.nhaCungCapMacDinh();
        System.out.println("Các nhà cung cấp: ");
        a.xuatNCCMacDinh();
        System.out.print("Mã nhà cung cấp được chọn là:  ");
        int ma = inp.nextInt();
        while(true){
            if (ma == a.getNcc(0).getMaNCC() || ma == a.getNcc(1).getMaNCC() || ma == a.getNcc(2).getMaNCC() ){
                break;
            }
            else{
                System.out.println("Vui lòng chọn 1 trong 3 nhà cung cấp: ");
                ma = inp.nextInt();
            }
        }
        supplier = ma;
    }
    public void nhapNgayNhap(){
        if(inp.hasNextLine()){
            inp.nextLine();
        }
        Checking check = new Checking();
        System.out.println("Ngày nhập phiếu: ");
        date = inp.nextLine();
        
        while ( check.checkNull(date) ||!check.checkDateFormat(date) )
        {
            if (check.checkNull(date)){
                System.out.println("Chưa nhập ngày nhập phiếu!");
                System.out.println("Nhập ngày nhập phiếu theo định dạng DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                date = inp.nextLine();
            }
            else if(!check.checkDateFormat(date)){
                System.out.println("Nhập sai định dạng!");
                System.out.println("Nhập lại ngày nhập phiếu theo định dạng DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                date = inp.nextLine();
            }
        }
    }
    public void nhapCTPN(){
        int n;
        System.out.print("Số mặt hàng trong phiếu là: ");
        n = inp.nextInt();
        ctpn = new CHITIETPN[n];
        for(int i=0; i<n; i++){
            ctpn[i] = new CHITIETPN();
            ctpn[i].setMaPN(idPN);
            ctpn[i].khoiTaoCTPN();
        }
    }
    public void khoiTaoPN(){
        nhapMaNVN();
        nhapNCC();
        nhapNgayNhap();
        nhapCTPN();
        tinhTongTien1PN();
    }
    public void tinhTongTien1PN(){
        int length = ctpn.length;
        for (int i=0; i<length; i++){
            totalMoney += ctpn[i].getThanhtien();
        }
    }
    
    public void xuatPN(){
        //System.out.printf("%-15s\t%-20s\t%-20s\t%-20s\t%10s\n", "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên nhập", "Ngày nhập phiếu", "Tổng tiền");
        System.out.printf("%-5d\t\t%-5d\t\t\t%5d\t\t\t%-20s\t %-,12d\n", this.idPN, this.supplier, this.employeeID, this.date, this.totalMoney);
    }
    
}
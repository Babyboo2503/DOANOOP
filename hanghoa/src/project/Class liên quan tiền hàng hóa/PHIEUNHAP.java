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
    private double totalMoney;
    private CHITIETPN [] ctpn;
    Scanner inp = new Scanner(System.in);
            
    public PHIEUNHAP() {
    }
    public PHIEUNHAP(int idPN, int employeeID, int supplier, String date, double totalMoney, CHITIETPN [] ctpn) {
        this.idPN = idPN;
        this.employeeID = employeeID;
        this.supplier = supplier;
        this.date = date;
        this.totalMoney = totalMoney;
        this.ctpn = ctpn;
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
    public double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(double totalMoney) {
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
        Checking check = new Checking();
        System.out.println("Nhập mã nhân viên nhập: ");
    }
    public void nhapNCC(){
        DSNCC a = new DSNCC();
        a.nhaCungCapMacDinh();
        Checking check = new Checking();
        
        System.out.println("Các nhà cung cấp: ");
        a.xuatNCCMacDinh();
        
        System.out.print("Mã nhà cung cấp được chọn là:  ");
        int ma = inp.nextInt();
        
        while(ma != a.getNcc(0).getMaNCC() || ma != a.getNcc(1).getMaNCC() || ma != a.getNcc(2).getMaNCC() ){
            System.out.println("Vui lòng chọn 1 trong 3 nhà cung cấp: ");
            ma = inp.nextInt();
        }
        supplier = ma;
        
    }
    public void nhapNgayNhap(){
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

    
}
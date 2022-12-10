/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP;

import java.util.Scanner;

/**
 *
 * @author nam23
 */
public class NCC {
    private String maNCC;
    private String tenNCC;
    private String sodtlh;
    Scanner inp = new Scanner(System.in);
    Checking check = new Checking();

    public NCC() {
    }
    public NCC(String maNCC, String tenNCC, String sodtlh) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sodtlh = sodtlh;
    }
    public String getMaNCC() {
        return maNCC;
    }
    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    public String getTenNCC() {
        return tenNCC;
    }
    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
    public String getSodtlh() {
        return sodtlh;
    }
    public void setSodtlh(String sodtlh) {
        this.sodtlh = sodtlh;
    }
    public void nhapTenNCC(){
        System.out.print("Nhap ten nha cung cap: ");
        tenNCC = inp.nextLine();
        
        while(check.checkNull(tenNCC)){
            System.out.print("Vui long nhap ten nha cung cap: ");
            tenNCC = inp.nextLine();
        }
    }
    public void nhapMaNCC(){
        System.out.print("Nhap ma nha cung cap: ");
        maNCC = inp.nextLine();
        
        while(true){
            if(check.checkNull(maNCC)){
                System.out.print("Vui long nhap ma nha cung cap: ");
                maNCC = inp.nextLine();
            }
            else if(!check.checkNumString(maNCC)){
                System.out.println("Vui long nhap dung dinh dang (chuoi ky tu so): ");
                maNCC = inp.nextLine();
            }
            else
                break;
        }
    }
    public void nhapSdtLh(){
        System.out.print("Nhap so dien thoai nha cung cap: ");
        sodtlh = inp.nextLine();
        
        while(true){
            if(check.checkNull(sodtlh)){
                System.out.print("Vui long nhap so dien thoai nha cung cap: ");
                sodtlh = inp.nextLine();
            }
            else if(!check.checkPhoneNum(sodtlh)){
                System.out.println("Vui long nhap dung dinh dang: ");
                sodtlh = inp.nextLine();
            }
            else
                break;
        }
    }
    public void khoiTaoNcc(){
        nhapMaNCC();
        nhapTenNCC();
        nhapSdtLh();
    }
    public void xuatThongTinNcc(){
        System.out.printf("%-10s\t%-20s\t%-15s\n", maNCC, tenNCC, sodtlh);
    }
}

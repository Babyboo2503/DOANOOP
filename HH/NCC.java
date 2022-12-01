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
public class NCC {
    private int maNCC;
    private String tenNCC;
    private String sodtlh;
    Scanner inp = new Scanner(System.in);

    public NCC() {
    }
    public NCC(int maNCC, String tenNCC, String sodtlh) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sodtlh = sodtlh;
    }
    public int getMaNCC() {
        return maNCC;
    }
    public void setMaNCC(int maNCC) {
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
    public void nhaTenNCC(){
        System.out.print("Nhập tên nhà cung cấp: ");
        tenNCC = inp.nextLine();
        
        Checking check = new Checking();
        while(check.checkNull(tenNCC)){
            System.out.print("Vui lòng nhập tên nhà cung cấp: ");
            tenNCC = inp.nextLine();
        }
    }
    public void nhapMaNCC(){
        System.out.print("Nhập mã nhà cung cung cấp: ");
        maNCC = inp.nextInt();
    }
    public void nhapSdtLh(){
        System.out.print("Nhập số điện thoại nhà cung cung cấp: ");
        sodtlh = inp.nextLine();
    }
}

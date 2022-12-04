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
public class DSPN {
    private PHIEUNHAP [] pn;
    private int soluongpn;
    private double tongSoTienNhapHang = 0.0;
    Scanner inp = new Scanner(System.in);

    public DSPN() {
    }

    public DSPN(PHIEUNHAP[] pn, int soluongpn, double tongSoTienNhapHang) {
        this.pn = pn;
        this.soluongpn = soluongpn;
        this.tongSoTienNhapHang = tongSoTienNhapHang;
    }

    public PHIEUNHAP[] getPn() {
        return pn;
    }

    public void setPn(PHIEUNHAP[] pn) {
        this.pn = pn;
    }

    public int getSoluongpn() {
        return soluongpn;
    }

    public void setSoluongpn(int soluongpn) {
        this.soluongpn = soluongpn;
    }

    public double getTongSoTienNhapHang() {
        return tongSoTienNhapHang;
    }

    public void setTongSoTienNhapHang(double tongSoTienNhapHang) {
        this.tongSoTienNhapHang = tongSoTienNhapHang;
    }
    

    public void taoDSPN(NCC []ncc){
        System.out.print("Số lượng phiếu bạn muốn nhập vào là: ");
        soluongpn = inp.nextInt();
        pn = new PHIEUNHAP [soluongpn];
        int length = pn.length;
        for(int i=0; i<length; i++){
            pn[i].nhapMaPN();
            pn[i].nhapMaNVN();
            pn[i].nhapNCC();
            pn[i].nhapNgayNhap();
        }
    }
    
    public boolean ktMaPN(int ma){
        return true;
    }
    
    public double tinhTongTienDSPN(){
        int length = pn.length;
        for(int i=0; i<length; i++){
            tongSoTienNhapHang += pn[i].getTotalMoney();
        }
        return tongSoTienNhapHang;
    }
    
}

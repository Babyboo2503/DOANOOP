/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nam23
 */
public class DSPN {
    private ArrayList<PHIEUNHAP> dspn;
    private double tongSoTienNhapHang = 0.0;
    
    Scanner inp = new Scanner(System.in);

    public DSPN() {
    }

    public DSPN(ArrayList<PHIEUNHAP> dspn) {
        this.dspn = dspn;
    }

    public double getTongSoTienNhapHang() {
        return tongSoTienNhapHang;
    }

    public void setTongSoTienNhapHang(double tongSoTienNhapHang) {
        this.tongSoTienNhapHang = tongSoTienNhapHang;
    }
    
    public boolean ktMaPN(int ma){
        dspn.clear();
        
        
        return true;
    }
    
    public void taoDSPN(){
        PHIEUNHAP pn = new PHIEUNHAP();
        pn.khoiTaoPN();
        dspn.add(pn);
        ghiFileDSPN();
    }
    
    public double tinhTongTienDSPN(){
        int length = dspn.size();
        for(int i=0; i<length; i++){
            tongSoTienNhapHang += dspn.get(i).getTotalMoney();
        }
        return tongSoTienNhapHang;
    }
    
    public void docFileDSPN(){
        
    }
    public void ghiFileDSPN(){
        FileWriter fw = null;
        
        String str = "idPN,NCC,NVNhap,NgayNhap,TongTien\n";
        try{
            fw = new FileWriter("DSPN.txt");
            fw.write(str);
            
            int length = dspn.size();
            for(int i=0; i<length; i++){
                String idPn = String.valueOf(dspn.get(i).getIdPN());
                String idNcc = String.valueOf(dspn.get(i).getSupplier());
                String idNv = String.valueOf(dspn.get(i).getEmployeeID());
                String date = String.valueOf(dspn.get(i).getDate());
                String tongtien = String.valueOf(dspn.get(i).getTotalMoney());
                
                str = String.format("%s,%s,%s,%s,%s\n", idPn, idNcc, idNv, date, tongtien);
                
                fw.write(str);
            }
            fw.close();

        }catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}

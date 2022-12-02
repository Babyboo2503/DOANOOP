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
    private ArrayList<PHIEUNHAP> dspn = new ArrayList();
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
    
    public void taoDSPN(int ma){
        PHIEUNHAP pn = new PHIEUNHAP();
        pn.setIdPN(ma);
        pn.khoiTaoPN();
        dspn.add(pn);
        tinhTongTienDSPN();
        ghiFile();
    }
    
    public double tinhTongTienDSPN(){
        int length = dspn.size();
        for(int i=0; i<length; i++){
            tongSoTienNhapHang += dspn.get(i).getTotalMoney();
        }
        return tongSoTienNhapHang;
    }
    
    @Override
    public void docFile(){
        dspn.clear();
        FileReader fr = null;
        BufferedReader br = null;
        int i = 0;
        try{
            fr = new FileReader("DSPN.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            
            while( line != null){
                String []pn = line.split(",");
                
                int idpn = Integer.parseInt(pn[0]);
                int employeeID = Integer.parseInt(pn[1]);
                int supplier = Integer.parseInt(pn[2]);
                String date = pn[3];
                long totalMoney = Long.parseLong(pn[4]);
                PHIEUNHAP temp = new PHIEUNHAP(idpn, employeeID, supplier, date, totalMoney);
                dspn.add(temp);
                
                line = br.readLine();
            }
            br.close();
            fr.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(DSPN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void ghiFile(){
        FileWriter fw = null;
        
        //String str = "idPN,NCC,NVNhap,NgayNhap,TongTien\n";
        try{
            fw = new FileWriter("DSPN.txt");
            
            int length = dspn.size();
            for(int i=0; i<length; i++){
                String idPn = String.valueOf(dspn.get(i).getIdPN());
                String idNcc = String.valueOf(dspn.get(i).getSupplier());
                String idNv = String.valueOf(dspn.get(i).getEmployeeID());
                String date = String.valueOf(dspn.get(i).getDate());
                String tongtien = String.valueOf(dspn.get(i).getTotalMoney());
                
                String str = String.format("%s,%s,%s,%s,%s\n", idPn, idNcc, idNv, date, tongtien);
                fw.write(str);
            }
            fw.close();
        }catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
    public void testDocGhi(){
        docFile();
    }
    public static void main(String[] args){
        DSPN a = new DSPN();
        a.themPN();
        a.xuatDSPN();
    }
    
    public void xuatDSPN(){
        System.out.printf("%-15s\t%-20s\t%-20s\t%-20s\t%10s\n", "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên nhập", "Ngày nhập phiếu", "Tổng tiền");
        int length = dspn.size();
        for (int i=0; i<length; i++){
            dspn.get(i).xuatPN();
        }
    }
    public boolean ktPNTonTai(int ma){
        docFile();
        int length = dspn.size();
        for(int i=0; i<length; i++){
            if(ma == dspn.get(i).getIdPN()){
                return true;
            }
        }
        return false;
    }
    public void themPN(){
        Checking check = new Checking();
        System.out.print("Nhập mã phiếu: ");
        int ma;
        
        String str = inp.nextLine();
        outer:while(true){
            while(check){
                
            }
        }
        while(ma == 0 || ktPNTonTai(ma)){
            if(ktPNTonTai(ma)){
                System.out.println("Phiếu nhập đã tồn tại!");
                return;
            }
            else if(ma == 0){
                System.out.println("Vui lòng nhập lại mã phiếu, mã phiếu không thể bằng 0!");
                System.out.print("Mã phiếu: ");
                ma = inp.nextInt();
            }
        }
        taoDSPN(ma);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nam23
 */
public class KHO implements DocGhiFile{
    private MATHANG [] dsmh;    
    Scanner inp = new Scanner(System.in);
    Checking check = new Checking();
    public KHO(MATHANG[] dsmh) {
        this.dsmh = dsmh;
    }

    public KHO() {
    }

    public MATHANG[] getDsmh() {
        return dsmh;
    }

    public void setDsmh(MATHANG[] dsmh) {
        this.dsmh = dsmh;
    }
    
    public void themVaoKho(MATHANG a){
        if(dsmh == null){
            dsmh = new MATHANG[1];
            dsmh[0] = a;
            ghiFile();
            return;
        }
        int newlength = dsmh.length +1;
        MATHANG []temp = new MATHANG[newlength];
        System.arraycopy(dsmh, 0, temp, 0, newlength-1);
        temp[newlength-1] = a;
        setDsmh(temp);
        ghiFile();
    }
    
    public void thayDoisoluong(String mamh, String hsd, int soluongthemvao){
        int length = dsmh.length;
        for(int i=0; i<length; i++){
            if(mamh.equalsIgnoreCase(dsmh[i].getId()) && hsd.equalsIgnoreCase(dsmh[i].getExp())){
                int soluongbandau = dsmh[i].getQuantity();
                dsmh[i].setQuantity(soluongbandau + soluongthemvao);
                ghiFile();
                break;
            }
        }
    }

    @Override
    public void docFile() {
        if(dsmh == null){
            System.out.println("Khong co mat hang nao trong kho!");
            return;
        }
        FileReader fr = null;
        BufferedReader br = null;
        
        ArrayList<MATHANG> mh = new ArrayList<>();
        try{
            fr = new FileReader("KHO.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            
            if(line == null){
                System.out.println("Khong co du lieu!");
                br.close();
                fr.close();
                return;
            }
            String mamh, tenmh, hsd, donvi, tinhtrang, loai;
            long giamh;
            int soluong;
            while(line != null){
                String []ctmh = line.split(",");
                mamh = ctmh[0];
                tenmh = ctmh[1];
                giamh = Long.parseLong(ctmh[2]);
                soluong = Integer.parseInt(ctmh[3]);
                hsd = ctmh[4];
                donvi = ctmh[5];
                tinhtrang = ctmh[6];
                loai = ctmh[7];
                
                MATHANG temp = null;
                if(loai.equalsIgnoreCase("TP")){
                    temp = new THUCPHAM(mamh, tenmh, giamh, hsd, donvi, soluong, tinhtrang);
                }
                else if(loai.equalsIgnoreCase("PTP")){
                    temp = new PHITHUCPHAM(mamh, tenmh, giamh, hsd, donvi, soluong, tinhtrang);
                }
                
                mh.add(temp);
                line = br.readLine();
            }
            
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KHO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KHO.class.getName()).log(Level.SEVERE, null, ex);
        }
        int length = mh.size();
        dsmh = new MATHANG[length];
        for(int i=0; i<length; i++){
            dsmh[i] = mh.get(i);
        }
    }

    @Override
    public void ghiFile() {
        if(dsmh == null){
            System.out.println("Khong co mat hang nao trong kho!");
            return;
        }
        FileWriter fw = null;
        try{
            fw = new FileWriter("KHO.txt");
            String mamh, tenmh, giamh, soluong, hsd, donvi, tinhtrang, loai;
            String str;
            int length = dsmh.length;
            for(int i=0; i<length; i++){
                mamh = dsmh[i].getId();
                tenmh = dsmh[i].getName();
                giamh = String.valueOf(dsmh[i].getPrice());
                soluong = String.valueOf(dsmh[i].getQuantity());
                hsd = dsmh[i].getExp();
                donvi = dsmh[i].getUnit();
                tinhtrang = dsmh[i].getCondition();
                loai = dsmh[i].getType();
                
                str = String.format("%s,%s,%s,%s,%s,%s,%s,%s\n", mamh, tenmh, giamh, soluong, hsd, donvi, tinhtrang, loai);
                fw.write(str);
            }
            fw.close();
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public int ktHangHh(){
        if(dsmh == null){
            System.out.println("Khong co mat hang trong kho!");
            return -1;
        }
        int length = dsmh.length;
        int count = 0;
        for(int i=0; i<length; i++){
            if(dsmh[i].getCondition().contains("Het")){
                count++;
            }
        }
        return count;
    }
    
    public void xoaMhHh(){
        int count = ktHangHh();
        if(count == -1){
            return;
        }
        if(count == 0){
            System.out.println("Khong co mat hang het han!");
            return;
        }
        int length = dsmh.length;
        MATHANG []temp;
        temp = new MATHANG[length - count];
        int k =0;
        
        for(int i=0; i<length; i++){
            if(!dsmh[i].getCondition().contains("Het")){
                temp[k++] = dsmh[i];
            }
        }
        setDsmh(temp);
        ghiFile();
    }
    
    public void xuatKho(){
        System.out.printf("%-15s%-40s%-20s%-20s%-10s\t%-14s%-20s\n" ,"Ma mat hang", "Ten mat hang", "Gia", "HSD", "So luong", "Don vi tinh", "Tinh trang");
        for (MATHANG dsmh1 : dsmh) {
            dsmh1.xuatMH();
        }
    }
    public void timTheoMaMh(String ma){
        if(dsmh == null){
            System.out.println("Kho rong!");
            return;
        }
        int length = dsmh.length;
        for(int i=0; i<length; i++){
            if(dsmh[i].getId().contains(ma)){
                System.out.printf("%-15s%-40s%-20s%-20s%-10s\t%-14s%-20s\n" ,"Ma mat hang", "Ten mat hang", "Gia", "HSD", "So luong", "Don vi tinh", "Tinh trang");
                dsmh[i].xuatMH();
            }
        }
        System.out.println("\n");
    }
    public void timTheoTen(String ten){
        if(dsmh == null){
            System.out.println("Kho rong!");
            return;
        }
        int length = dsmh.length;
        for(int i=0; i<length; i++){
            String name = dsmh[i].getName().toLowerCase();
            if(name.contains(ten)){
                System.out.printf("%-15s%-40s%-20s%-20s%-10s\t%-14s%-20s\n" ,"Ma mat hang", "Ten mat hang", "Gia", "HSD", "So luong", "Don vi tinh", "Tinh trang");
                dsmh[i].xuatMH();
            }
        }
        System.out.println("\n");
    }
    public void menuKho(){
        kho:
        while(true){
            System.out.println("========================================Menu kho========================================");
            System.out.println("1/Xem kho.");
            System.out.println("2/Tim kiem hang theo ma.");
            System.out.println("3/Tim kiem hang theo ten.");
            System.out.println("4/Xoa cac mat hang het han trong kho.");
            System.out.println("0/Quay lai.");
            byte mode = inp.nextByte();
            switch(mode){
                case 1:{
                    if(dsmh == null){
                        System.out.println("Khong co mat hang nao trong kho!");
                        break;
                    }
                    xuatKho();
                }   break;
                case 2:{
                    if(dsmh == null){
                        System.out.println("Khong co mat hang nao trong kho!");
                        break;
                    }
                    System.out.println("Nhap ma mat hang: ");
                    String ma = inp.nextLine();
                    while(true){
                        if(check.checkNull(ma)){
                            System.out.println("Vui long nhap ma mat hang: ");
                            ma = inp.nextLine();
                        }
                        if(!check.checkNumString(ma)){
                            System.out.println("Nhap sai dinh dang!");
                            System.out.println("Nhap ma mat hang (chuoi ky tu so): ");
                            ma = inp.nextLine();
                        }
                        else{
                            break;
                        }
                    }
                    timTheoMaMh(ma);
                }   break;
                case 3:{
                    if(dsmh == null){
                        System.out.println("Khong co mat hang nao trong kho!");
                        break;
                    }
                    System.out.println("Nhap ten mat hang: ");
                    String ten = inp.nextLine();
                    while(true){
                        if(check.checkNull(ten)){
                            System.out.println("Vui long nhap ten mat hang: ");
                            ten = inp.nextLine();
                        }
                        else if(!check.checkTextString(ten)){
                            System.out.println("Nhap sai dinh dang!");
                            System.out.println("Nhap lai ten mat hang: ");
                            ten = inp.nextLine();
                        }
                        else{
                            break;
                        }
                    }
                    timTheoTen(ten);
                }   break;
                case 4:{
                    if(dsmh == null){
                        System.out.println("Khong co mat hang nao trong kho!");
                        break;
                    }
                    xoaMhHh();
                }   break;
                case 0:
                    break kho;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
                    
        }
    }
}

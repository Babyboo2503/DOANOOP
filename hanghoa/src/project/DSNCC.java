/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nam23
 */
public class DSNCC implements DocGhiFile{
    private NCC []ncc;
    Scanner inp = new Scanner(System.in);
    Checking check = new Checking();

    public DSNCC() {
    }

    public DSNCC(NCC[] ncc) {
        this.ncc = ncc;
    }

    public NCC[] getNcc() {
        return ncc;
    }

    public void setNcc(NCC[] ncc) {
        this.ncc = ncc;
    }
    
    public NCC getNcc(int index){
        return ncc[index];
    }
    
    public void xuatDSNCC(){
        System.out.printf("%-10s\t%-20s\t%-15s\n", "Mã NCC", "Tên NCC", "Số điện thoại");
        for(int i=0; i<3; i++){
            ncc[i].xuatThongTinNcc();
        }
    }

    @Override
    public void docFile() {
        if(ncc == null){
            System.out.println("Khong co nha cung cap nao!");
            return;
        }
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<NCC> dsncc= new ArrayList<>();
        try{
            fr = new FileReader("DSNCC.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            if(line == null){
                System.out.println("Khong co du lieu!");
                br.close();
                fr.close();
                return;
            }
            
            String mancc, tenncc, sdtncc;
            while(line != null){
                String []c = line.split(",");
                mancc = c[0];
                tenncc = c[1];
                sdtncc = c[2];
                
                NCC temp = new NCC(mancc, tenncc, sdtncc);
                dsncc.add(temp);
                line = br.readLine();
            }
            br.close();
            fr.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        int newlength = dsncc.size();
        for(int i=0; i<newlength; i++){
            ncc[i] = dsncc.get(i);
        }
    }

    @Override
    public void ghiFile() {
        if(ncc == null){
            System.out.println("Khong co nha cung cap nao!");
            return;
        }
        FileWriter fw = null;
        
        try{
            fw = new FileWriter("DSNCC.txt");
            String mancc, tenncc, sdtncc, str;
            int length = ncc.length;
            for(int i=0; i<length; i++){
                mancc = ncc[i].getMaNCC();
                tenncc = ncc[i].getTenNCC();
                sdtncc = ncc[i].getSodtlh();
                
                str = String.format("%s,%s,%s\n", mancc, tenncc, sdtncc);
                fw.write(str);
            }
            
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void themNhaCc(NCC a){
        if(ncc == null){
            ncc = new NCC[1];
            ncc[0] = a;
            ghiFile();
            return;
        }
        int newlength = ncc.length +1;
        NCC []temp = new NCC[newlength];
        System.arraycopy(ncc, 0, temp, 0, newlength-1);
        temp[newlength - 1] = a;
        setNcc(temp);
        ghiFile();
    }
    
    public void suaTenNcc(String ten){
        System.out.print("Chon ma nha cung cap muon sua: ");
        String ma = inp.nextLine();
        while(true){
            if(check.checkNull(ma)){
                System.out.print("Vui long nhap ma: ");
                ma = inp.nextLine();
            }
            else if(!check.checkNumString(ma)){
                System.out.print("Vui long nhap dung dinh dang (chuoi ky tu so): ");
                ma = inp.nextLine();
            }
            else{
                int length = ncc.length;
                for(int i=0; i<length ;i++){
                    if(ncc[i].getMaNCC().equalsIgnoreCase(ma)){
                        ncc[i].setTenNCC(ten);
                        System.out.println("Doi ten nha cung cap thanh cong!");
                        return;
                    }
                }
                System.out.println("Khong co nha cung cap can sua doi!");
                return;
            }
        }
    }
    
    public void suaSdtNcc(String sdt){
        System.out.print("Chon ma nha cung cap muon sua: ");
        String ma = inp.nextLine();
        while(true){
            if(check.checkNull(ma)){
                System.out.print("Vui long nhap ma: ");
                ma = inp.nextLine();
            }
            else if(!check.checkNumString(ma)){
                System.out.print("Vui long nhap dung dinh dang (chuoi ky tu so): ");
                ma = inp.nextLine();
            }
            else{
                int length = ncc.length;
                for(int i=0; i<length ;i++){
                    if(ncc[i].getMaNCC().equalsIgnoreCase(ma)){
                        ncc[i].setSodtlh(sdt);
                        System.out.println("Doi so dien thoai nha cung cap thanh cong!");
                        return;
                    }
                }
                System.out.println("Khong co nha cung cap can sua doi!");
                return;
            }
        }
    }
    
    public void menuNcc(){
        ncc:
        while(true){
            System.out.println("========================================Menu ve hang hoa========================================");
            System.out.println("1/Xem NCC.");
            System.out.println("2/Them NCC.");
            System.out.println("0/Quay lai.");
            byte k = inp.nextByte();
            switch(k){
                case 1: {
                    if(ncc == null){
                        System.out.println("Khong co nha cung cap nao!");
                        break;
                    }
                    xuatDSNCC();
                }
                    break;
                case 2: {
                    NCC a = new NCC();
                    a.khoiTaoNcc();
                    themNhaCc(a);
                }
                    break;
                case 0:
                    break ncc;
                default:    System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }
}

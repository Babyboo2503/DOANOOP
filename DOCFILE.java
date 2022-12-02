
package com.mycompany.doanhthu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class DOCFILE {
    private double luongnv;
    private double hhoa;
    private double hdon;
//    public void writetofile(List<student> list){
//        try {
//            FileWriter fw= new FileWriter("data.txt");
//            BufferedWriter bw= new BufferedWriter(fw);
//            for(student o: list){
//                bw.write(o.toString());
//                bw.newLine();
//            }
//            bw.close();
//            fw.close();
//            
//        } catch (Exception e) {
//        }
//}
    public double luongnhanvien(){
 
        try {
            FileReader fr= new FileReader("nhanvien.txt");
            BufferedReader br= new BufferedReader(fr);
            String line="";
            
            while (true) {   
                line=br.readLine();
                if(line==null)
                        break;
                String txt[]=line.split(";");
                double tien= Double.parseDouble(txt[2]);
                this.luongnv+=tien;
                
            }
        } catch (Exception e) {
        }
        return this.luongnv;
    }
    public double tienhanghoa(){
 
        try {
            FileReader fr= new FileReader("hanghoa.txt");
            BufferedReader br= new BufferedReader(fr);
            String line="";
            
            while (true) {   
                line=br.readLine();
                if(line==null)
                        break;
                String txt[]=line.split(";");
                double tien= Double.parseDouble(txt[2]);
                this.hhoa+=tien;
                
            }
        } catch (Exception e) {
        }
        return this.hhoa;
    }
    public double tienhoadon(){
 
        try {
            FileReader fr= new FileReader("hoadon.txt");
            BufferedReader br= new BufferedReader(fr);
            String line="";
            
            while (true) {   
                line=br.readLine();
                if(line==null)
                        break;
                String txt[]=line.split(";");
                double tien= Double.parseDouble(txt[2]);
                this.hdon+=tien;
                
            }
        } catch (Exception e) {
        }
        return this.hdon;
    }
}

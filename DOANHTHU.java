
package com.mycompany.doanhthu;

import java.io.BufferedReader;
import java.io.FileReader;


public class DOANHTHU {
    private double tiendonhang;
    //tien thu duoc thu hoa don
    public double tienthu(){
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
                this.tiendonhang+=tien;
                
            }
        } catch (Exception e) {
        }
        return this.tiendonhang;
    }
}



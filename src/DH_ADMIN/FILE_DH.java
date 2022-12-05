package DH_ADMIN;

import DH.HOADON;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FILE_DH {
    public void writeToFile(ArrayList<HOADON> arrayHD) {
        try {
            FileWriter fw=new FileWriter("DSHD.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            for (HOADON i : arrayHD) {
                bw.write(i.toString());
                bw.newLine();
            } 
            bw.close();
            fw.close();
        } catch (Exception e) {  
            System.out.println("LOI");
        }
    }
    public void readFromFile(ArrayList<HOADON> arrayHD){
        try {
            FileReader fr=new FileReader("DSHD.txt");
            BufferedReader br=new BufferedReader(fr);
            String line=" ";
            while (true) {                
            line=br.readLine(); //doc tung dong
            if(line==null){
                break;
            }
            String tmp[]=line.split("/");
            String maHD=tmp[0];
            String maNV=tmp[1];
            String SDT=tmp[2];
            String ngaytaoHD= tmp[3];
            String tenSP=tmp[5];
            String maSP=tmp[4];
            int SL=Integer.parseInt(tmp[6]);
            double DG=Double.parseDouble(tmp[7]);
            double TT=Double.parseDouble(tmp[8]);
            arrayHD.add(new HOADON(maHD,maNV,SDT,ngaytaoHD,maSP,tenSP,SL,DG,TT));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("LOI");
        }
    }
    }

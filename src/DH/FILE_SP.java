package DH;

import DH.HOADON;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FILE_SP {
    public void writeToFile(ArrayList<SP> arraySP) {
        try {
            FileWriter fw=new FileWriter("DSSP.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            for (SP i : arraySP) {
                bw.write(i.toString());
                bw.newLine();
            } 
            bw.close();
            fw.close();
        } catch (Exception e) {  
            System.out.println("LOI");
        }
    }
    public void readFromFile(ArrayList<SP> arraySP){
        try {
            FileReader fr=new FileReader("DSSP.txt");
            BufferedReader br=new BufferedReader(fr);
            String line=" ";
            while (true) {                
            line=br.readLine(); //doc tung dong
            if(line==null){
                break;
            }
            String tmp[]=line.split("/");
            
//                String TenSP,maSP;
//    int SL;
//    double donGia, thanhTien;    
            String masp=tmp[0];
            String tensp=tmp[1];
            int SL=Integer.parseInt(tmp[2]);
            double DG=Double.parseDouble(tmp[3]);
            double TT=Double.parseDouble(tmp[4]);
            arraySP.add(new SP(masp,tensp,SL,DG,TT));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("LOI");
        }
    }
    }

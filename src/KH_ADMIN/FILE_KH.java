package KH_ADMIN;

import KH.KHACHHANG;
import static KH_ADMIN.DANHSACHKHACHHANG_AD.arrayKH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author compu
 */
public class FILE_KH {
    public void writeToFile(ArrayList<KHACHHANG> arrayKH) {
        try {
            FileWriter fw=new FileWriter("DSKH.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            for (KHACHHANG i : arrayKH) {
                bw.write(i.toString());
                bw.newLine();
            } 
            bw.close();
            fw.close();
        } catch (Exception e) {      
        }
    }
    public void readFromFile(ArrayList<KHACHHANG> arrayKH){
        try {
            FileReader fr=new FileReader("DSKH.txt");
            BufferedReader br=new BufferedReader(fr);
            String line=" ";
            while (true) {                
            line=br.readLine(); //doc tung dong
            if(line==null){
                break;
            }
            String tmp[]=line.split("/");
            String ten=tmp[1];
            String SDT=tmp[0];
            arrayKH.add(new KHACHHANG(ten,SDT));
            }

        } catch (Exception e) {
        }
    }
    }

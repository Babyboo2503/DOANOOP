package project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author compu
 */
public class FILE{
    FILE(){
        
    }
    public void writeToFile_KH(ArrayList<KHACHHANG> arrayKH) {
        try {
            FileWriter fw=new FileWriter("DSKH.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            for (KHACHHANG i : arrayKH) {
                bw.write(i.toString());
                bw.newLine();
            } 
            bw.close();
            fw.close();
        } catch (IOException e) {     
            System.out.println(e.getMessage());
        }
    }
    public void readFromFile_KH(ArrayList<KHACHHANG> arrayKH){
        try {
            FileReader fr=new FileReader("DSKH.txt");
            BufferedReader br=new BufferedReader(fr);
            String line= br.readLine();
            if(line == null){
                System.out.println("Danh sach khach hang rong");
                System.out.println("Hay them 1 KH moi di ne");
                DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();
                A.themKH();
                br.close();
                fr.close();
                return;
            }
            while (line != null) {  
                String tmp[]=line.split("/");
                String ten=tmp[1];
                String SDT=tmp[0];
                arrayKH.add(new KHACHHANG(ten,SDT));
                
                line=br.readLine(); //doc tung dong
            }
            
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void writeToFile_HD(ArrayList<HOADON> arrayHD) {
        try {
            FileWriter fw=new FileWriter("DSHD.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            FileWriter fw2=new FileWriter("DSCTHD.txt");
            BufferedWriter bw2=new BufferedWriter(fw2);
            for (HOADON i : arrayHD) {
                //HD
                bw.write(i.toString());
                bw.newLine();
                //CTHD
                bw2.write(i.toString());
                bw2.newLine();
                bw2.write(i.xuatHdVaCt());
            }
            bw2.close();
            bw.close();
            fw2.close();
            fw.close();
        } catch (IOException e) {  
            System.out.println(e.getMessage());
        }
    }
    public void readFromFile_HD(ArrayList<HOADON> arrayHD){
        try {
            FileReader fr=new FileReader("DSCTHD.txt");
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine();
            if(line==null){
                System.out.println("Danh sach hoa don rong");
                br.close();
                fr.close();
                return;
            }
            while ( line!= null) {         
                String tmp[]=line.split(",");
                if(tmp.length == 5){
                    String mahd = tmp[0];
                    int maNV=Integer.parseInt(tmp[1]);
                    String SDT=tmp[2];
                    String ngaytaoHD= tmp[3];
                    long thanhtienhd = Long.parseLong(tmp[4]);
                    CHITIETHOADON cthd = new CHITIETHOADON();
                    line = br.readLine();
                    String []temp = line.split(",");
                    inner:
                    while(temp.length == 6){
                        String mamh = temp[1];
                        String tenmh = temp[2];
                        long gia = Long.parseLong(temp[3]);
                        int soluong = Integer.parseInt(temp[4]);
                        long thanhtiensp = Long.parseLong(temp[5]);
                        cthd.setMaHD(mahd);
                        cthd.themSpVaoHd(new SP_HD(mahd, mamh, tenmh, soluong, gia, thanhtiensp));
                        line = br.readLine();
                        if(line == null){
                            break inner;
                        }
                        else{
                            temp = line.split(",");
                        }
                    }
                    HOADON a =new HOADON(mahd, SDT, maNV, cthd, thanhtienhd, ngaytaoHD);
                    arrayHD.add(a);
                }
            }
            br.close();
            fr.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

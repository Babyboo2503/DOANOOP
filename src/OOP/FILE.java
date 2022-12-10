package OOP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author compu
 */
public class FILE{
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
            System.out.println("LOI");
        }
    }
    public void readFromFile_KH(ArrayList<KHACHHANG> arrayKH){
        try {
            FileReader fr=new FileReader("DSKH.txt");
            BufferedReader br=new BufferedReader(fr);
            String line=" ";
            while (true) {  
            line=br.readLine(); //doc tung dong
            if(line==null){
                System.out.println("Danh sach khach hang rong");
                System.out.println("Hay them 1 KH moi di ne");
                DANHSACHKHACHHANG A=new DANHSACHKHACHHANG();
                A.themKH();
                break;
            }
            else{
            String tmp[]=line.split("/");
            String ten=tmp[1];
            String SDT=tmp[0];
            arrayKH.add(new KHACHHANG(ten,SDT));
            }}

        } catch (IOException e) {
            System.out.println("LOI");
        }
    }
    public void writeToFile_HD(ArrayList<HOADON> arrayHD) {
        try {
            FileWriter fw=new FileWriter("DSHD.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            for (HOADON i : arrayHD) {
                bw.write(i.toString());
                bw.newLine();
            } 
            bw.close();
            fw.close();
        } catch (IOException e) {  
            System.out.println("LOI");
        }
    }
    public void readFromFile_HD(ArrayList<HOADON> arrayHD){
        try {
            FileReader fr=new FileReader("DSHD.txt");
            BufferedReader br=new BufferedReader(fr);
            String line=" ";
            while (true) {                
            line=br.readLine(); //doc tung dong
            if(line==null){
                System.out.println("Danh sach hoa don rong");
                break;
            }
            else{
            String tmp[]=line.split("/");
            String maHD=tmp[0];
            String maNV=tmp[1];
            String SDT=tmp[2];
            String ngaytaoHD= tmp[3];

            arrayHD.add(new HOADON(maHD,maNV,SDT,ngaytaoHD));
            }}
        } catch (IOException | NumberFormatException e) {
            System.out.println("LOI");
        }
    }
    public void writeToFile_cthd(ArrayList<CHITIETHOADON> arraycthd) {
        try {
            FileWriter fw=new FileWriter("CTHD.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            for (CHITIETHOADON i : arraycthd) {
                bw.write(i.toString());
                bw.newLine();
            } 
            bw.close();
            fw.close();
        } catch (IOException e) {  
            System.out.println("LOI");
        }
    }
    public void readFromFile_cthd(ArrayList<CHITIETHOADON> arraycthd){
        try {
            FileReader fr=new FileReader("CTHD.txt");
            BufferedReader br=new BufferedReader(fr);
            String line=" ";
            while (true) {                
            line=br.readLine(); //doc tung dong
            if(line==null){
                System.out.println("Khong co hoa don nao!");
                break;
            }
            else{
            String tmp[]=line.split("/");
            String maHD=tmp[0];
            String maSP=tmp[1];
            String tenSP=tmp[2];
            int SL=Integer.parseInt(tmp[3]);
            long DG =Long.parseLong(tmp[4]);
            long TT =Long.parseLong(tmp[5]);

            

            arraycthd.add(new CHITIETHOADON(maHD,maSP,tenSP,SL,DG,TT));
            }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("LOI");
        }
    }
    }

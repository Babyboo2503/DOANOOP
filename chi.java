import java.io.*;

import java.io.FileReader;
import java.util.Scanner;

public class chi {
    private float nhaphang_n;
    private float nhaphang_t;
    private float huyhang;
    private float luongNV;
    private float dien;
    private float nuoc;
    private float wifi;
    private float matbang;
    
    chi(){
        this.nhaphang_n=0;
        this.nhaphang_t=0;
        this.huyhang=0;
        this.luongNV=0;
        this.dien=0;
        this.nuoc=0;
        this.wifi=0;
        this.matbang=0;
    }

    Scanner sc_s=new Scanner(System.in);


//phần tiền chi nhập hàng sử dụng dữ liệu từ nhập hàng của quản lý hàng hóa.
    public void setnhaphang_n(String ngaynhap){
        try {
            BufferedReader br=new BufferedReader(new FileReader("phieunhap.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(ngaynhap == getngaynhap(s)){
                    this.nhaphang_n += gettongtien(s);
                }
            }
            br.close();
        } catch (Exception e) {
            return;
        }
    }

    public int gettongtien (String s){
        String tongtien=s.substring(s.lastIndexOf(',')+1);
        return Integer.parseInt (tongtien);
    }

    public String getngaynhap (String s){
        return s.substring(s.lastIndexOf(',',s.lastIndexOf(',')-1)+1,s.lastIndexOf(','));
    }



    public float getnhaphang_n(){
        return nhaphang_n;
    }

    public void setnhaphang_t(){

    }
    public float getnhaphang_t(){
        return nhaphang_t;
    }

//hủy hàng lấy dữ liệu từ quản lý hàng hóa.
    public void sethuyhang(float a){
        huyhang=a;
    }
    public float gethuyhang(){
        return huyhang;
    }



//lương NV lấy dữ liệu từ nhân sự.
    public void setluongNV(float a){
        luongNV=a;
    }
    public float getluongNV(){
        return luongNV;
    }

//tiền điện
    public void setdien(){
        dien=sc_s.nextFloat();

    }
    public float getdien(){
        return dien;
    }

// tiền nước
    public void setnuoc(){
        nuoc=sc_s.nextFloat();
    }
    public float getnuoc(){
        return nuoc;
    }

//tiền wifi
    public void setwifi(){
        wifi=sc_s.nextFloat();
    }
    public float getwifi(){
        return wifi;
    }

//tiền mặt bằng
    public void setmatbang(){
        matbang=sc_s.nextFloat();
    }
    public float getmatbang(){
        return matbang;
    }
}

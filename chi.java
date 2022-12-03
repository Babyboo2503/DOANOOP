import java.io.*;

import java.io.FileReader;

public class chi {
    private float nhaphang_n;
    private float nhaphang_t;
    private float huyhang;
    private float luongNV;
    private float dien;
    private float nuoc;
    private float wifi;
    private float chi_n;
    private float chi_t;
    
    chi(){
        this.nhaphang_n=0;
        this.nhaphang_t=0;
        this.huyhang=0;
        this.luongNV=0;
        this.dien=0;
        this.nuoc=0;
        this.wifi=0;
    }


    public int gettongtien (String s){
        String tongtien=s.substring(s.lastIndexOf(',')+1);
        return Integer.parseInt (tongtien);
    }

    public String getngaynhap (String s){
        return (s.substring(s.lastIndexOf(',',s.lastIndexOf(',')-1)+1,s.lastIndexOf(','))).toString();
    }



//phần tiền chi nhập hàng sử dụng dữ liệu từ nhập hàng của quản lý hàng hóa.
    public void setnhaphang_n(String ngaynhap){
        try {
            BufferedReader br=new BufferedReader(new FileReader("phieunhap.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(ngaynhap.equals(getngaynhap(s))){
                    nhaphang_n+=gettongtien(s);                    
                }
            }
            br.close(); 
        } catch (Exception e) {
            return;
        }
    }



    public float getnhaphang_n(){
        return this.nhaphang_n;
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
    public void setdien(float a){
        dien=a;

    }
    public float getdien(){
        return dien;
    }

// tiền nước
    public void setnuoc(float a){
        nuoc=a;
    }
    public float getnuoc(){
        return nuoc;
    }

//tiền wifi
    public void setwifi(float a){
        wifi=a;
    }
    public float getwifi(){
        return wifi;
    }


    public void setchi_n(){
        chi_n=nhaphang_n+huyhang;
    }
    public float getchi_n(){
        return chi_n;
    }


    public void setchi_t(){
        chi_n=nhaphang_t+huyhang+luongNV+dien+nuoc+wifi;
    }
    public float getchi_t(){
        return chi_t;
    }
}

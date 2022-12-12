package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class chi {
    private long nhaphang_n;
    private long nhaphang_t;
    private long dien;
    private long nuoc;
    private long wifi;
    private long chi_n;
    private long chi_t;

    chi(){
        this.nhaphang_n=0;
        this.nhaphang_t=0;
        this.dien=0;
        this.nuoc=0;
        this.wifi=0;
        this.chi_n=0;
        this.chi_t=0;
    }

    public long gettongtien (String s){
        String tongtien=s.substring(s.lastIndexOf(',')+1);
        return Long.parseLong(tongtien);
    }

    public String getngaynhap (String s){
        return (s.substring(s.lastIndexOf(',',s.lastIndexOf(',')-1)+1,s.lastIndexOf(',')));
    }

//phần tiền chi nhập hàng sử dụng dữ liệu từ nhập hàng của quản lý hàng hóa.
    public void setnhaphang_n(String ngaynhap){
        try {
            BufferedReader br=new BufferedReader(new FileReader("DSPN.txt"));
            String s;
            while((s = br.readLine()) !=null){
                // if(ngaynhap.equals(getngaynhap(s))){
                if(s.contains(ngaynhap)){
                    nhaphang_n+=gettongtien(s);                    
                }
            }
            br.close(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public long getnhaphang_n(){
        return nhaphang_n;
    }

    public void setnhaphang_t(String thang){
        try {
            BufferedReader br=new BufferedReader(new FileReader("DSPN.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(s.contains(thang)){
                    nhaphang_t+=gettongtien(s);                    
                }
            }
            br.close(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public long getnhaphang_t(){
        return nhaphang_t;
    }
/*
    public void sethuyhang(long a){
        huyhang=a;
    }
    public long gethuyhang(){
        return huyhang;
    }
*/
//tiền điện
    public void setdiennuocwifi(String thang){
        try {
            BufferedReader br=new BufferedReader(new FileReader("DienNuoc.txt"));
            String s = br.readLine();
            String[] dnw = s.split(",");
            dien=Integer.parseInt(dnw[0]);
            nuoc=Integer.parseInt(dnw[1]);
            wifi=Integer.parseInt(dnw[2]);
            /*
            while((s = br.readLine()) !=null){
                if(s.contains(thang)){
                    String[] dnw = s.split(",");
                    dien=Integer.parseInt(dnw[0]);
                    nuoc=Integer.parseInt(dnw[1]);
                    wifi=Integer.parseInt(dnw[2]);
                }
            }*/
            br.close(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public long getdien(){
        return dien;
    }
    public long getnuoc(){
        return nuoc;
    }
    public long getwifi(){
        return wifi;
    }

    public void setchi_n(){
        chi_n=nhaphang_n;
    }
    public long getchi_n(){
        return chi_n;
    }


    public void setchi_t(){
        chi_t=nhaphang_t+dien+nuoc+wifi;
    }
    public long getchi_t(){
        return chi_t;
    }
}
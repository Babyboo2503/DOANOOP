package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class thu{
    private long banhang_n;
    private long banhang_t;

    thu(){
        banhang_n=0;
        banhang_t=0;
    }

    public int gettongtien (String s){
        String tongtien=s.substring(s.lastIndexOf('/')+1);
        return Integer.parseInt (tongtien);
    }

    public void setbanhang_n(String ngay){
        try {
            BufferedReader br=new BufferedReader(new FileReader("DSHD.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(s.contains(ngay)){
                    banhang_n+=gettongtien(s);                   
                }
            }
            br.close(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public long getbanhang_n(){
        return banhang_n;
    }
    public void setbanhang_t(String thang){
        try {
            BufferedReader br=new BufferedReader(new FileReader("DSHD.txt"));
            String s ;
            
            while((s = br.readLine()) !=null){
                if(s.contains(thang)){
                    banhang_t+=gettongtien(s);                   
                }
            }
            br.close(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public long getbanhang_t(){
        return banhang_t;
    }
}
import java.io.*;

public class thu {
    private float banhang_n;
    private float banhang_t;

    thu(){
        banhang_n=0;
        banhang_t=0;
    }


    public int gettongtien (String s){
        String tongtien=s.substring(s.lastIndexOf(',')+1);
        return Integer.parseInt (tongtien);
    }

    public void setbanhang_n(String ngay){
        try {
            BufferedReader br=new BufferedReader(new FileReader("file\\hoadonbanhang.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(s.contains(ngay)){
                    banhang_n+=gettongtien(s);                   
                }
            }
            br.close(); 
        } catch (Exception e) {
            return;
        }
    }
    public float getbanhang_n(){
        return banhang_n;
    }
    public void setbanhang_t(String thang){
        try {
            BufferedReader br=new BufferedReader(new FileReader("file\\hoadonbanhang.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(s.contains(thang)){
                    banhang_t+=gettongtien(s);                   
                }
            }
            br.close(); 
        } catch (Exception e) {
            return;
        }
    }
    public float getbanhang_t(){
        return banhang_t;
    }
}

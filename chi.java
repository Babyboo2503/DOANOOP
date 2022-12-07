import java.io.*;

public class chi {
    private float nhaphang_n;
    private float nhaphang_t;
    private float huyhang;
    private float dien;
    private float nuoc;
    private float wifi;
    private float chi_n;
    private float chi_t;
    
    chi(){
        this.nhaphang_n=0;
        this.nhaphang_t=0;
        this.huyhang=0;
        this.dien=0;
        this.nuoc=0;
        this.wifi=0;
        this.chi_n=0;
        this.chi_t=0;
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
            BufferedReader br=new BufferedReader(new FileReader("file\\DSPN.txt"));
            String s;
            while((s = br.readLine()) !=null){
                // if(ngaynhap.equals(getngaynhap(s))){
                if(s.contains(ngaynhap)){
                    nhaphang_n+=gettongtien(s);                    
                }
            }
            br.close(); 
        } catch (Exception e) {
            return;
        }
    }



    public float getnhaphang_n(){
        return nhaphang_n;
    }

    public void setnhaphang_t(String thang){
        try {
            BufferedReader br=new BufferedReader(new FileReader("file\\DSPN.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(s.contains(thang)){
                    nhaphang_t+=gettongtien(s);                    
                }
            }
            br.close(); 
        } catch (Exception e) {
            return;
        }
    }
    public float getnhaphang_t(){
        return nhaphang_t;
    }

    public void sethuyhang(float a){
        huyhang=a;
    }
    public float gethuyhang(){
        return huyhang;
    }

//tiền điện
    public void setdiennuocwifi(String thang){
        try {
            BufferedReader br=new BufferedReader(new FileReader("file\\dien_nuoc_wifi.txt"));
            String s;
            while((s = br.readLine()) !=null){
                if(s.contains(thang)){
                    String[] dnw = s.split(",");
                    dien=Integer.parseInt(dnw[1]);
                    nuoc=Integer.parseInt(dnw[2]);
                    wifi=Integer.parseInt(dnw[3]);
                }
            }
            br.close(); 
        } catch (Exception e) {
            return;
        }

    }
    public float getdien(){
        return dien;
    }
    public float getnuoc(){
        return nuoc;
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
        chi_t=nhaphang_t+huyhang+dien+nuoc+wifi;
    }
    public float getchi_t(){
        return chi_t;
    }
}

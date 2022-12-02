package project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DSHH{
    private MATHANG []g;
    private int soLuongHH;
    Scanner inp = new Scanner(System.in);

    DSHH() {
    }
    
    DSHH(MATHANG[] g,int soLuongHH) {
        this.soLuongHH = soLuongHH;
        this.g = g;
    }
    public MATHANG[] getG() {
        return g;
    }
    public void setG(MATHANG[] g) {
        this.g = g;
    }  
    public MATHANG getGi(int i){
        return g[i];
    }
    public int getSoLuongHH() {
        return soLuongHH;
    }
    public void setSoLuongHH(int soLuongHH) {
        this.soLuongHH = soLuongHH;
    }
    public void nhapSoLuongMH(){
        System.out.print("Nhập số lượng mặt hàng: ");
        soLuongHH = inp.nextInt();
    }
    public void khoiTaoDSHH(MATHANG [] g){
        nhapSoLuongMH();
        this.g = g.clone();
    }
    
    public void nhapVaoFile(String file) throws  IOException{
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.append("maMH,tenMH,gia,hsd,soluong,donvitinh,tinhtrang\n");

            for(int i=0; i<soLuongHH; i++){
                fr.append(String.valueOf(g[i].getId()));
                fr.append(',');
                fr.append(g[i].getName());
                fr.append(',');
                fr.append(String.valueOf(g[i].getPrice()));
                fr.append(',');
                fr.append(g[i].getExp());
                fr.append(',');
                fr.append(String.valueOf(g[i].getQuantity()));
                fr.append(',');
                fr.append(g[i].getUnit());
                fr.append(',');
                fr.append(g[i].getCondition());            
            }
        }catch(IOException er){
            System.out.println("Error!");
        }finally{
            try {
                fr.flush();
                fr.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
            }
        }
    }
    public void docFile(){
        
    }
    
}
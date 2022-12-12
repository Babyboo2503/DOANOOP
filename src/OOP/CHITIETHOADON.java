package OOP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class CHITIETHOADON extends IOfile implements IO{
    Scanner input=new Scanner(System.in);

    public CHITIETHOADON(String maHD, String MaSP, int SL, long DG, String tenSP, long TTHD) {
        this.maHD = maHD;
        this.MaSP = MaSP;
        this.SL = SL;
        this.DG = DG;
        this.tenSP = tenSP;
        this.TTHD = TTHD;
    }
    
        static public ArrayList<CHITIETHOADON> arraycthd=new ArrayList<>();       
        public String maHD;
        public String MaSP;
        public int SL;
        public long DG;
        public String tenSP;
        public long TT=DG*SL;
        public long TTHD=0;

    public long getTTHD() {
        return TTHD;
    }

    public void setTTHD(long TTHD) {
        this.TTHD = TTHD;
    }

    public CHITIETHOADON() {
        
    }
        
        //Xây dựng hàm có tham số
    
        public CHITIETHOADON(String maHD,String MaSP,String tenSP, int SL, long DG,long TT) {
            this.maHD=maHD;
            this.MaSP = MaSP;
            this.tenSP=tenSP;
            this.SL = SL;
            this.DG = DG;
            this.TT=TT;
        }

        public void xuatThongTin(String maHD)
        {
            System.out.printf("│%-20s│%-20s│%-20s│%-20s│%-20s│\n", getMaSP(),getTenSP(),getSL(),getDG(),getTT());
        }

    @Override
    public String toString() {
        return maHD + "/" + MaSP + "/" + SL + "/" + DG + "/" + tenSP + "/" + TT ;
    }

        
        public String getMaSP() {
            return MaSP;
        }

        public void setMaSP(String MaSP) {
            this.MaSP = MaSP;
        }

        public int getSL() {
            return SL;
        }

        public void setSL(int SL) {
            this.SL = SL;
        }

        public long getDG() {
            return DG;
        }

        public void setDG(long DG) {
            this.DG = DG;
        }

        public String getTenSP() {
            return tenSP;
        }

        public void setTenSP(String tenSP) {
            this.tenSP = tenSP;
        }

    public long getTT() {
        return TT;
    }

    public void setTT(long TT) {
        this.TT = TT;
    }
        
     public void nhapCTHD(CHITIETHOADON CT, HOADON a){
         KHO K=new KHO();
         outer:
         while(true){
         System.out.println("1.Them san pham");
         System.out.println("2.In ");
         System.out.println("3.Thoat");
         int option=input.nextInt();
         switch(option){
             case 1 -> {
            System.out.print("Nhap ma san pham:");
            String maSp_tmp=input.nextLine();
            CT.setTenSP(K.timMH_xuattenSP("008"));
            CT.setDG(K.timMH_xuatDG("008"));
            System.out.print("Nhap so luong:");
            int SLsp;
            SLsp=input.nextInt();
            CT.setSL(SLsp);   
            arraycthd.clear();
            arraycthd.add(CT);   
            TTHD+=CT.getTT();
            CT.setTTHD(TTHD);            
             }
             case 2 -> {
                 a.XUAT();
                 xuat();
                 System.out.println("TONG TIEN : "+CT.getTTHD()); 
         }
             case 3 -> {
                 break outer;
                 }             
         }
        }
    }
     public void nhapCTHD_KTV(CHITIETHOADON CT, HOADON a){
         KHO K = new KHO();
         outer:
         while(true){
         System.out.println("1.Them san pham");
         System.out.println("2.In ");
         System.out.println("3.Thoat");
         int option=input.nextInt();
         switch(option){
             case 1 -> {
            System.out.print("Nhap ma san pham:");
            String maSp_tmp=input.nextLine();
            CT.setTenSP(K.timMH_xuattenSP(maSp_tmp));
            CT.setDG(K.timMH_xuatDG(maSp_tmp));
            System.out.print("Nhap so luong:");
            int SLsp;
            SLsp=input.nextInt();
            CT.setSL(SLsp);  
            arraycthd.clear();
            arraycthd.add(CT);
            f.writeToFile_cthd(arraycthd);
            TTHD+=CT.getTT();
            CT.setTTHD(TTHD);
             }
             case 2 -> {
                 a.XUAT_KTV();
                 xuat();
                 System.out.println("TONG TIEN : "+CT.getTTHD());  
         }
             case 3 -> {
                 break outer;
                 }
                 
         }
        }
    }

    public void nhap(HOADON a) {
        CHITIETHOADON CT=new CHITIETHOADON();
        CT.maHD=a.getMaHD();
        nhapCTHD(CT,a);  
    }
    public void nhap_KTV(HOADON a) {
        CHITIETHOADON CT=new CHITIETHOADON();
        CT.maHD=a.getMaHD();
        nhapCTHD_KTV(CT,a);  
    }

        @Override
    public void xuat() {
//        System.out.printf("%6s%15s%15s%15s%15s\n","Ma san pham","Ten san pham","So luong","Gia tien","Thanh Tien");
        for(int i=0;i<arraycthd.size();i++)
        {
        System.out.printf("%6s%15s%15s%15s%15s\n",arraycthd.get(i).getMaSP(),arraycthd.get(i).getTenSP(),arraycthd.get(i).getSL(),arraycthd.get(i).getDG(),arraycthd.get(i).getTT());
        TTHD+=arraycthd.get(i).getTT();
        }        
    }

    @Override
    public void nhap() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

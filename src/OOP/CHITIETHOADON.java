package OOP;

import java.util.ArrayList;

/**
 *
 * @author compu
 */
public class CHITIETHOADON implements IO{

    public CHITIETHOADON(String maHD, String MaSP, int SL, long DG, String tenSP, long TTHD) {
        this.maHD = maHD;
        this.MaSP = MaSP;
        this.SL = SL;
        this.DG = DG;
        this.tenSP = tenSP;
        this.TTHD = TTHD;
    }
    
        ArrayList<CHITIETHOADON> arraycthd=new ArrayList<>();   
        HOADON A=new HOADON();       
        public String maHD;
        public String MaSP;
        public int SL;
        public long DG;
        public String tenSP;
        public long TT=DG*SL;
        public long TTHD;

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
            System.out.printf("│%-20s|%-20s│%-20s│%-20s│%-20s│%-20s│\n",A.getMaHD(), getMaSP(),getTenSP(),getSL(),getDG(),getTT());
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

        public void setDG(int DG) {
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
        
     public void nhapCTHD(CHITIETHOADON CT){
         System.out.println("1.Them san pham");
         System.out.println("2.In ");
         int option=input.nextInt();
         switch(option){
             case 1 -> {
            System.out.print("Nhap ma san pham:");
            String maSp_tmp;
            maSp_tmp=input.nextLine();
            CT.setMaSP(maSp_tmp);
            
            
            
            
            arraycthd.add(CT);             
             }
             case 2 -> xuat();
         }
         
     }   

        @Override
    public void nhap() {
        CHITIETHOADON CT=new CHITIETHOADON();
        CT.maHD=A.getMaHD();
        
        nhapCTHD(CT);   
    }

        @Override
    public void xuat() {
        System.out.printf("%6s%15s%15s%15s%15s\n","Ma san pham","Ten san pham","So luong","Gia tien","Thanh Tien");
        for(int i=0;i<arraycthd.size();i++)
        {
        System.out.printf("%6s%15s%15s%15s%15s\n",arraycthd.get(i).getMaSP(),arraycthd.get(i).getTenSP(),arraycthd.get(i).getSL(),arraycthd.get(i).getDG(),arraycthd.get(i).getTT());
        TTHD+=arraycthd.get(i).getTT();
        }        
    }
}

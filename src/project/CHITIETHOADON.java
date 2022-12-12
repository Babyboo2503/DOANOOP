package project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author compu
 */
public class CHITIETHOADON implements IO{

    private SP_HD [] dssp;
    private String maHD;
    private long TT;
    Scanner inp = new Scanner(System.in);
    Checking check = new Checking();
    CHITIETHOADON() {
    }

    //Xây dựng hàm có tham số

    public CHITIETHOADON(SP_HD[] dssp, String maHD, long TT) {
        this.dssp = dssp;
        this.maHD = maHD;
        this.TT = TT;
    }

    public long getTT() {
        return TT;
    }
    public void setTT(long TT) {
        this.TT = TT;
    }
    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public SP_HD[] getDssp() {
        return dssp;
    }
    public void setDssp(SP_HD[] dssp) {
        this.dssp = dssp;
    }
    
    public void themSpVaoHd(SP_HD a){
        if(dssp == null){
            dssp = new SP_HD[1];
            dssp[0] = a;
            return;
        }
        int newlength = dssp.length + 1;
        SP_HD []temp = new SP_HD[newlength];
        System.arraycopy(dssp, 0, temp, 0, newlength - 1);
        temp[newlength - 1] = new SP_HD();
        temp[newlength - 1] = a;
        setDssp(temp);
    }
    
    public void tinhThanhTien(){
        TT = 0;
        int length = dssp.length;
        for(int i=0; i<length; i++){
            TT += dssp[i].getThanhtien();
        }
    }
    public void nhapCTHD(String mahd, KHO kho){
        kho.xuatKhoChoKhach();
        muahang:
        while(true){
            System.out.println("========================================Tao chi tiet hoa don========================================");
            System.out.println("1.Them san pham");
            System.out.println("2.In ");
            System.out.println("3. Quay lai");
            System.out.println("(1/2/3)");
            int option=inp.nextInt();
            themsp:
            switch(option){
                case 1 :{
                    if(inp.hasNextLine())
                        inp.nextLine();
                    System.out.print("Nhap ma san pham muon mua: ");
                    String ma = inp.nextLine();
                    if(!check.checkNumString(ma) || check.checkNull(ma)){
                        System.out.println("Khong tim thay san pham nay!");
                        break;
                    }
                    int length = kho.getDsmh().length;
                    byte count = 0;
                    for(int i=0; i<length; i++){
                        if(kho.getDsmh()[i].getId().equals(ma)){
                            count = 1;
                            int soluong = kho.getDsmh()[i].getQuantity();
                            String ten = kho.getDsmh()[i].getName();
                            long gia = kho.getDsmh()[i].getPrice();
                            if(soluong == 0){
                                System.out.println("Xin loi quy khach, san pham da het hang!");
                                break themsp;
                            }
                            System.out.print("So luong muon mua la: ");
                            int soluongmuonmua = inp.nextInt();
                            while(soluongmuonmua > soluong){
                                System.out.println("So luong hang san pham con lai chi con lai " + soluong + kho.getDsmh()[i].getUnit());
                                System.out.println("Mong quy khach mua voi so luong it hon! Xin cam on quy khach!");
                                System.out.print("So luong muon mua la: ");
                                soluongmuonmua = inp.nextInt();
                            }
                            soluong -= soluongmuonmua;
                            themSpVaoHd(new SP_HD(mahd, ma, ten, soluongmuonmua, gia));
                            tinhThanhTien();
                            kho.getDsmh()[i].setQuantity(soluong);
                            kho.ghiFile();
                            break themsp;
                        }
                    }
                    if(count == 0){
                        System.out.println("Khong tim thay san pham nay!");
                    }
                }
                    break;
                case 2 :{
                    System.out.printf("%-15s%-40s%-20s%-10s%-20s\n", "Ma san pham", "Ten san pham", "Gia tien", "So luong", "Thanh tien");
                    xuat();
                }
                    break;
                case 3:
                    break muahang;
                default: System.out.println("Lenh khong hop le!");
                    break;
            }
        }
    }   

    @Override
    public void nhap() {
    }

    @Override
    public void xuat() {
        if(dssp == null){
            System.out.println("Khong co san pham nao!");
            return;
        }
        int length = dssp.length;
        //System.out.printf("%-15s%-40s%-20s%-10s%-20s", "Ma san pham", "Ten san pham", "Gia tien", "So luong", "Thanh tien");
        for(int i=0; i<length; i++){
            dssp[i].xuatSp();
        }
    }
    
    @Override
    public String toString(){
        if(dssp == null){
            System.out.println("Khong co san pham trong hoa don!");
            return "null";
        }
        int length = dssp.length;
        String str = "";
        for(int i=0; i<length; i++){
            str += dssp[i].toString() + "\n";
        }
        return str;
    }

}
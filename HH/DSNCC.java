/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author nam23
 */
public class DSNCC {
    private NCC []ncc = new NCC[3];

    public DSNCC() {
    }

    public DSNCC(NCC[] ncc) {
        this.ncc = ncc;
    }

    public NCC[] getNcc() {
        return ncc;
    }

    public void setNcc(NCC[] ncc) {
        this.ncc = ncc;
    }
    
    public NCC getNcc(int index){
        return ncc[index];
    }
    
    public void nhaCungCapMacDinh(){
        ncc[0] = new NCC(101, "Nhà cung cấp A", "0998877123");
        ncc[1] = new NCC(102, "Nhà cung cấp B", "0998877456");
        ncc[2] = new NCC(103, "Nhà cung cấp C", "0998877789");
    }
    public NCC[] layNCCMacDinh(){
        return ncc;
    }
    
    public void xuatNCCMacDinh(){
        String str = String.format("%-10s\t%-20s\t%-15s", "Mã NCC", "Tên NCC", "Số điện thoại");
        System.out.println(str);
        for(int i=0; i<3; i++){
            System.out.printf("%-10s\t%-20s\t%-15s\n", ncc[i].getMaNCC(), ncc[i].getTenNCC(), ncc[i].getSodtlh());
        }
    }
    
}

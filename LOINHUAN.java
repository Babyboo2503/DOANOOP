
package com.mycompany.doanhthu;


public class LOINHUAN {
    protected double tienloi;
    public void xuatloinhuan(){
        CHI c1= new CHI();
        System.out.println("---XUAT BANG LOI NHUAN---");
        System.out.println("Chi : "+c1.tienchi());
        DOANHTHU d1= new DOANHTHU();
        System.out.println("Thu : "+d1.tienthu());
        LOINHUAN l1= new LOINHUAN();
        l1.tienloi=(double)d1.tienthu()-c1.tienchi();
        System.out.println("LOI NHUAN THANG :"+l1.tienloi);
    }
}

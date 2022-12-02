
package com.mycompany.doanhthu;


public class DOANHTHU {
    private double tiendonhang;
    //tien thu duoc thu hoa don
    public double tienthu(){
        DOCFILE a= new DOCFILE();
        return a.tienhoadon();
    }
}


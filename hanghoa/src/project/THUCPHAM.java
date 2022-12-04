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
public class THUCPHAM extends MATHANG{

    public THUCPHAM() {
        super();
    }

    public THUCPHAM(String id, String name, long price, String exp, String unit, int quantity, String condition) {
        super(id, name, price, exp, unit, quantity, condition);
    }

    /**
     *
     */
    @Override
    public void giaThanh() {
        long giagoc = super.getPrice();
        super.setPrice((long) (giagoc * 1.05));
    }
    
    
    @Override
    public void xuatMH(){
        System.out.printf("%-15s%-30s%-20s%-20s%-10s\t%-14s%-20s\n" ,"Ma mat hang", "Ten mat hang", "Gia", "HSD", "So luong", "Don vi tinh", "Tinh trang");
        System.out.printf("%-15s%-30s%-,20d%-20s%-10d\t%-14s%-20s\n" ,getId(), getName(), getPrice(), getExp(), getQuantity(), getUnit(), getCondition());
    }

    @Override
    public void khoiTaoMH() {
        nhapId();
        nhapTen();
        nhapGia();
        nhapHSD();
        nhapSoLuong();
        nhapDonVi();
        kiemTraMatHang();
        giaThanh();
    }

    @Override
    public void khoiTaoMH(String mamh) {
        setId(mamh);
        nhapTen();
        nhapGia();
        nhapHSD();
        nhapSoLuong();
        nhapDonVi();
        kiemTraMatHang();
        giaThanh();
    }
    public void kiemTraMatHang(){
        Checking check = new Checking();
        if (check.checkEXP(getExp()) <= 0)
            setCondition("Het han su dung");
        else if (check.checkEXP(getExp()) > 0)
            setCondition("Con han su dung");
    }
}

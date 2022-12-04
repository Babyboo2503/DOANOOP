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
public class PHITHUCPHAM extends MATHANG{

    public PHITHUCPHAM() {
        super();
    }

    public PHITHUCPHAM(String id, String name, long price, String unit, int quantity) {
        super(id, name, price, unit, quantity);
    }

    @Override
    public void giaThanh() {
        long giagoc = super.getPrice();
        super.setPrice((long)(giagoc * 1.1));
    }

    @Override
    public void xuatMH(){
        System.out.printf("%-15s%-30s%-20s%-10s\t%-14s\n" ,"Ma mat hang", "Ten mat hang", "Gia",  "So luong", "Don vi tisnh");
        System.out.printf("%-15s%-30s%-,20d%-10s\t%-14s\n" ,getId(), getName(), getPrice(), getQuantity(), getUnit());
    }
    @Override
    public void khoiTaoMH() {
        nhapId();
        nhapTen();
        nhapGia();
        nhapSoLuong();
        nhapDonVi();
        giaThanh();
    }
    @Override
    public void khoiTaoMH(String mamh) {
        setId(mamh);
        nhapTen();
        nhapGia();
        nhapSoLuong();
        nhapDonVi();
        giaThanh();
    }
}

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

    public THUCPHAM(int id, String name, long price, String exp, String unit, int quantity, String condition) {
        super(id, name, price, exp, unit, quantity, condition);
    }

    /**
     *
     */
    @Override
    public void giaThanh() {
        double giagoc = super.getPrice();
        super.setPrice(giagoc * 1.2);
    }
    
    public void khoiTaoThucPham(){
        super.khoiTaoMH();
        giaThanh();
    }
    
    @Override
    public void xuatMH(){
        //System.out.printf("%-15s%-30s%-20s%-20s%-10s%-14s%-20s\n" ,"Mã mặt hàng", "Tên mặt hàng", "Giá", "HSD", "Số lượng", "Đơn vị tính", "Tình trạng");
        System.out.printf("%-15d%-30s%-20s%-20s%-10s%-14s%-20s\n" ,super.getId(), super.getName(), super.getPrice(), super.getExp(), super.getQuantity(), super.getUnit(), super.getCondition());
    }
}

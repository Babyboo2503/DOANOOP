/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP;

/**
 *
 * @author nam23
 */
public class THUCPHAM extends MATHANG{

    public THUCPHAM() {
        super();
        super.setType("TP");
    }

    public THUCPHAM(String id, String name, long price, String exp, String unit, int quantity, String condition) {
        super(id, name, price, exp, unit, quantity, condition, "TP");
    }

    THUCPHAM(String mamh, String tenmh, String giamh, String hsd, String donvi, String soluong, String tinhtrang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void giaThanh() {
        long giagoc = super.getPrice();
        super.setPrice((long) (giagoc * 1.05));
    }
}
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
public class PHITHUCPHAM extends MATHANG{

    public PHITHUCPHAM() {
        super();
        super.setType("PTP");
    }

    public PHITHUCPHAM(String id, String name, long price, String exp, String unit, int quantity, String condition) {
        super(id, name, price, exp, unit, quantity, condition, "PTP");
    }

    @Override
    public void giaThanh() {
        long giagoc = super.getPrice();
        super.setPrice((long)(giagoc * 1.1));
    }
}